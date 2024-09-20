package com.antonioleiva.composetraining

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.fragment.app.FragmentActivity
import com.antonioleiva.composetraining.ui.MyFragment

class MainActivity : FragmentActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, MyFragment())
            .commit()
    }
}