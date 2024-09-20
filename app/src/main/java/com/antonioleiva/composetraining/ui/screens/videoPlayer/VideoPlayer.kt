package com.antonioleiva.composetraining.ui.screens.videoPlayer

import android.net.Uri
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.antonioleiva.composetraining.ui.theme.ComposeTrainingTheme

const val videoUrl =
    "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"

@Composable
fun VideoPlayer() {

    var exoplayer by remember { mutableStateOf<ExoPlayer?>(null) }

    ComposeTrainingTheme {
        Scaffold { innerPadding ->
            ExoplayerEffect(
                video = Uri.parse(videoUrl),
                onExoplayerChange = { exoplayer = it }
            )
            AndroidView(
                factory = { ctx ->
                    PlayerView(ctx).apply {
                        layoutParams = FrameLayout
                            .LayoutParams(MATCH_PARENT, MATCH_PARENT)
                    }
                },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) { view ->
                exoplayer?.let {
                    view.player = it
                }
            }
        }
    }

}

@Composable
private fun ExoplayerEffect(
    video: Uri,
    onExoplayerChange: (ExoPlayer?) -> Unit,
) {
    val ctx = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(ctx, lifecycleOwner, video) {
        val exoPlayer = ExoPlayer.Builder(ctx).build().apply {
            setMediaItem(MediaItem.fromUri(video))
            prepare()
        }
        onExoplayerChange(exoPlayer)

        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_PAUSE -> {
                    exoPlayer.pause()
                }

                Lifecycle.Event.ON_RESUME -> {
                    exoPlayer.play()
                }

                else -> {}
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            exoPlayer.release()
            onExoplayerChange(null)
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}