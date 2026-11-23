package io.itch.curiouscompiler.pixelchess.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import io.itch.curiouscompiler.pixelchess.Piece
import io.itch.curiouscompiler.pixelchess.R
import io.itch.curiouscompiler.pixelchess.Square
import io.itch.curiouscompiler.pixelchess.getSquare

@Composable
fun PlacePiece(file: Char, rank: Int, board: Array<Square>) {
    val piece = getSquare(file, rank, board).piece
    when (piece) {
        Piece.KING_W -> {
            Image(
                painter = painterResource(R.drawable.chess_klt45),
                contentDescription = null
            )
        }

        Piece.QUEEN_W -> {
            Image(
                painter = painterResource(R.drawable.chess_qlt45),
                contentDescription = null
            )
        }

        Piece.ROOK_W -> {
            Image(
                painter = painterResource(R.drawable.chess_rlt45),
                contentDescription = null
            )
        }

        Piece.BISHOP_W -> {
            Image(
                painter = painterResource(R.drawable.chess_blt45),
                contentDescription = null
            )
        }

        Piece.KNIGHT_W -> {
            Image(
                painter = painterResource(R.drawable.chess_nlt45),
                contentDescription = null
            )
        }

        Piece.PAWN_W -> {
            Image(
                painter = painterResource(R.drawable.chess_plt45),
                contentDescription = null
            )
        }

        Piece.KING_B -> {
            Image(
                painter = painterResource(R.drawable.chess_kdt45),
                contentDescription = null
            )
        }

        Piece.QUEEN_B -> {
            Image(
                painter = painterResource(R.drawable.chess_qdt45),
                contentDescription = null
            )
        }

        Piece.ROOK_B -> {
            Image(
                painter = painterResource(R.drawable.chess_rdt45),
                contentDescription = null
            )
        }

        Piece.BISHOP_B -> {
            Image(
                painter = painterResource(R.drawable.chess_bdt45),
                contentDescription = null
            )
        }

        Piece.KNIGHT_B -> {
            Image(
                painter = painterResource(R.drawable.chess_ndt45),
                contentDescription = null
            )
        }

        Piece.PAWN_B -> {
            Image(
                painter = painterResource(R.drawable.chess_pdt45),
                contentDescription = null
            )
        }

        Piece.EMPTY -> {
            /** no-op */
        }
    }
}