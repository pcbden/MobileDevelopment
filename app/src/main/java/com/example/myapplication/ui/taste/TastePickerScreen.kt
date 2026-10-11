package com.example.myapplication.ui.taste

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TastePickerScreen(
    state: CustomTasteState,
    onGenreClick: (String) -> Unit,
    onLikeClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            TastePickerBottomBar(
                likedCount = state.totalFavorites,
                required = 3,
                canContinue = state.isReadyToProceed,
                onContinueClick = {},
                onSkipClick = {}
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            GenreChips(
                genres = state.categoryList,
                selectedGenre = state.activeCategory,
                onGenreClick = onGenreClick
            )
            ArtistGrid(
                artists = state.filteredCatalog,
                likedIds = state.favoriteIds,
                onLikeClick = onLikeClick
            )
        }
    }
}

@Composable
fun TastePickerRoute(
    modifier: Modifier = Modifier,
    viewModel: TastePickerViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    TastePickerScreen(
        state = state,
        onGenreClick = viewModel::selectCategory,
        onLikeClick = viewModel::toggleFavorite,
        modifier = modifier
    )
}
