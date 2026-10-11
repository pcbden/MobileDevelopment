package com.example.myapplication.ui.taste

data class Musician(
    val id: Int,
    val fullName: String,
    val musicGenre: String
)

val customMusiciansList = listOf(
    Musician(101, "Alice", "Pop"),
    Musician(102, "Bob", "Pop"),
    Musician(103, "Charlie", "Pop"),
    Musician(104, "David", "Rock"),
    Musician(105, "Emma", "Rock"),
    Musician(106, "Frank", "Rock"),
    Musician(107, "Grace", "Jazz"),
    Musician(108, "Hannah", "Jazz"),
    Musician(109, "Ian", "Jazz"),
    Musician(110, "Jack", "Folk"),
    Musician(111, "Karen", "Folk"),
    Musician(112, "Leo", "Folk")
)

data class CustomTasteState(
    val catalog: List<Musician> = customMusiciansList,
    val activeCategory: String? = null,
    val favoriteIds: Set<Int> = emptySet()
) {
    val categoryList: List<String>
        get() = catalog.map { it.musicGenre }.distinct()

    val filteredCatalog: List<Musician>
        get() = if (activeCategory == null) catalog else catalog.filter { it.musicGenre == activeCategory }

    val totalFavorites: Int
        get() = favoriteIds.size

    val isReadyToProceed: Boolean
        get() = totalFavorites >= 3
}
