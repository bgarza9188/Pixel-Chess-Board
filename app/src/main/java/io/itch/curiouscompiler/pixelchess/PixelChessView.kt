package io.itch.curiouscompiler.pixelchess

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import io.itch.curiouscompiler.pixelchess.ui.theme.PixelChessBoardTheme

private const val percentOfScreen = 0.9f

@Composable
fun ChessBoard(board: Array<Square>, updateText: (String) -> Unit) {
    BoxWithConstraints(
        contentAlignment = Alignment.Center
    ) {
        val boxWidth = calculateMaxBoardSize(maxWidth, maxHeight)
        Column {
            rankLabels.forEach { rank ->
                Row {
                    fileLabels.forEach { file ->
                        Box(
                            modifier = Modifier
                                .size(boxWidth)
                                .background(calculateSquareColor(file, rank, board))
                                .clickable {
                                    updateText(getSquare(file, rank, board).piece.name)
                                }
                        ) {
                            PlacePiece(file, rank, board)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PlacePiece(file: Char, rank: Int, board: Array<Square>) {
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

@Composable
private fun calculateSquareColor(file: Char, rank: Int, board: Array<Square>): Color =
    if (getSquare(file, rank, board).color == SquareColor.WHITE) {
        Color(0xFFFFF9C4)
    } else {
        Color(0xFF4CAF50)//Green for now
    }

@Composable
private fun calculateMaxBoardSize(maxWidth: Dp, maxHeight: Dp): Dp {
    val maxSize = if (maxWidth > maxHeight)
        maxHeight
    else
        maxWidth
    return (maxSize * percentOfScreen) / numberOfRanks
}

@Preview(showBackground = true)
@Composable
fun ChessBoardPreview() {
    PixelChessBoardTheme {
        ChessBoard(emptyArray()) { }
    }
}