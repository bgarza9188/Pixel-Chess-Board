package io.itch.curiouscompiler.pixelchess

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BoardViewModel : ViewModel() {
    private val _board = MutableLiveData<Array<Square>>()
    val board: LiveData<Array<Square>> = _board
}