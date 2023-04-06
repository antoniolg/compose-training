package com.antonioleiva.composetraining.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Item(
    val id: Int,
    val title: String,
    val subtitle: String,
    val thumb: String
) : Parcelable

val itemList = (1..1000).map {
    Item(
        it,
        "Title $it",
        "Subtitle $it",
        thumb = "https://loremflickr.com/400/400?lock=$it"
    )
}