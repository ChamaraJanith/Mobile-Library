package com.example.booknest.model

data class GoogleBooksResponse(
    val items: List<GoogleBookItem> = emptyList()
)

data class GoogleBookItem(
    val id: String = "",
    val volumeInfo: GoogleVolumeInfo = GoogleVolumeInfo()
)

data class GoogleVolumeInfo(
    val title: String = "",
    val authors: List<String>? = null,
    val description: String? = "",
    val imageLinks: ImageLinks? = null,
    val infoLink: String? = ""
)

data class ImageLinks(
    val thumbnail: String? = ""
)
