package io.itch.curiouscompiler.pixelchess

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BoardViewModel : ViewModel() {
    private val _board = MutableLiveData(initStandardBoard())
    private val _firstSelectedSquare = MutableLiveData<Square?>()
    val board: LiveData<Array<Square>> = _board

    fun updateBoard(from: Square, to: Square) {
        if (from.piece == Piece.EMPTY) return
        _board.value?.let { board ->
            val newBoard = board.copyOf()

            newBoard[from.id] = from.copy(piece = Piece.EMPTY)
            newBoard[to.id] = to.copy(piece = from.piece)

            _board.value = newBoard
        }
    }

    fun selectSquare(file: Char, rank: Int) {
        board.value?.let { board ->
            val currentSquare = getSquare(file, rank, board)
            if (_firstSelectedSquare.value == null) {
                // Can't start a move from an empty square
                if (currentSquare.piece == Piece.EMPTY) {
                    return
                }
                //first selected not yet set
                _firstSelectedSquare.value = currentSquare
            } else if (_firstSelectedSquare.value != currentSquare) {
                //if the currently selected value is different then update board
                //and make selection null
                _firstSelectedSquare.value?.let{
                    updateBoard(from = it, to = currentSquare)
                }
                _firstSelectedSquare.value = null
            }
        }
    }

    fun resetBoard() {
        _board.value = initStandardBoard()
    }
}