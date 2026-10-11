package com.example.myapplication.ui.taste

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TastePickerViewModel : ViewModel() {
    private val _state = MutableStateFlow(CustomTasteState())
    val state: StateFlow<CustomTasteState> = _state.asStateFlow()

    fun selectCategory(category: String) {
        _state.update {
            it.copy(activeCategory = if (it.activeCategory == category) null else category)
        }
    }

    fun toggleFavorite(id: Int) {
        _state.update {
            val updated = if (id in it.favoriteIds) it.favoriteIds - id else it.favoriteIds + id
            it.copy(favoriteIds = updated)
        }
    }
}
