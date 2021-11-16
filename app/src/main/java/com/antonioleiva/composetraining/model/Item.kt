package com.antonioleiva.composetraining.model

data class Item(
    val id: Int,
    val title: String,
    val subtitle: String,
    val thumb: String
)

val itemList = (1..1000).map {
    Item(
        it,
        "Title $it",
        "Subtitle $it",
        thumb = "https://loremflickr.com/400/400?lock=$it"
    )
}