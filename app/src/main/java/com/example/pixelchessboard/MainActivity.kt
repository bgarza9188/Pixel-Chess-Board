package com.example.pixelchessboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pixelchessboard.ui.theme.PixelChessBoardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PixelChessBoardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ChessBoard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ChessBoard(modifier: Modifier = Modifier) {
    val files = 'a'..'h'
    val ranks = 8 downTo 1
    var selectedSquare by remember { mutableStateOf(Pair('a', 1)) }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("${selectedSquare.first}${selectedSquare.second}")
        ranks.forEachIndexed { i, rank ->
            Row {
                files.forEachIndexed { j, file ->
                    val color = if ((i + j) % 2 == 0) {
                        Color.LightGray
                    } else {
                        Color.Black
                    }
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .background(color)
                            .clickable {
                                selectedSquare = Pair(file, rank)
                            }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChessBoardPreview() {
    PixelChessBoardTheme {
        ChessBoard()
    }
}