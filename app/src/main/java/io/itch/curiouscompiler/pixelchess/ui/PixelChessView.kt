package io.itch.curiouscompiler.pixelchess.ui

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import io.itch.curiouscompiler.pixelchess.Square
import io.itch.curiouscompiler.pixelchess.SquareColor
import io.itch.curiouscompiler.pixelchess.fileLabels
import io.itch.curiouscompiler.pixelchess.getSquare
import io.itch.curiouscompiler.pixelchess.numberOfRanks
import io.itch.curiouscompiler.pixelchess.rankLabels
import io.itch.curiouscompiler.pixelchess.ui.theme.PixelChessBoardTheme

private const val percentOfScreen = 0.9f

@Composable
fun ChessBoard(
    board: Array<Square>,
    onSelectSquare: (Char, Int) -> Unit,
    updateText: (String) -> Unit
) {
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
                                    onSelectSquare(file, rank)
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
        ChessBoard(emptyArray(), { _, _ -> }, { _ -> })
    }
}