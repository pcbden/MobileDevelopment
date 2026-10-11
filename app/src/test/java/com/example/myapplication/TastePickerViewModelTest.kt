package com.example.myapplication

import com.example.myapplication.ui.taste.TastePickerViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class TastePickerViewModelTest {

    @Test
    fun toggling_like_adds_then_removes_artist() {
        val vm = TastePickerViewModel()

        vm.toggleFavorite(101)
        assertEquals(setOf(101), vm.state.value.favoriteIds)

        vm.toggleFavorite(101)
        assertTrue(vm.state.value.favoriteIds.isEmpty())
    }

    @Test
    fun continue_is_enabled_only_after_three_likes() {
        val vm = TastePickerViewModel()

        vm.toggleFavorite(101)
        vm.toggleFavorite(102)
        assertFalse(vm.state.value.isReadyToProceed)

        vm.toggleFavorite(103)
        assertTrue(vm.state.value.isReadyToProceed)
    }

    @Test
    fun selecting_genre_filters_and_tapping_again_clears() {
        val vm = TastePickerViewModel()

        vm.selectCategory("Rock")
        assertEquals(3, vm.state.value.filteredCatalog.size)
        assertTrue(vm.state.value.filteredCatalog.all { it.musicGenre == "Rock" })

        vm.selectCategory("Rock")
        assertEquals(12, vm.state.value.filteredCatalog.size)
    }

    @Test
    fun likes_survive_changing_the_genre_filter() {
        val vm = TastePickerViewModel()

        vm.toggleFavorite(101)
        vm.selectCategory("Jazz")

        assertEquals(setOf(101), vm.state.value.favoriteIds)
    }
}
