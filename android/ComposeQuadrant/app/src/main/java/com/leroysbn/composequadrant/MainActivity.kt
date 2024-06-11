package com.leroysbn.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leroysbn.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuadrantApp(
                        composableTextTitle = stringResource(R.string.text_composable_title),
                        composableText = stringResource(R.string.text_composable),
                        composableImageTitle = stringResource(R.string.image_composable),
                        composableImageText = stringResource(R.string.image_composable_text),
                    )
                }
            }
        }
    }
}

@Composable
fun QuadrantApp(
    composableTextTitle: String,
    composableText: String,
    composableImageTitle: String,
    composableImageText: String,
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxWidth()) {
        Row(modifier.weight(1f)) {
            Column(
                modifier
                    .background(color = Color(0xFFEADDFF))
                    .padding(16.dp)
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = composableTextTitle,
                    modifier.padding(bottom = 16.dp),
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = composableText,
                    modifier
                )
            }
            Column(
                modifier
                    .background(color = Color(0xFFD0BCFF))
                    .padding(16.dp)
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = composableImageTitle,
                    modifier.padding(bottom = 16.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = composableImageText,
                    modifier
                )
            }
        }
        Row(modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(id = R.string.row_composable),
                description = stringResource(id = R.string.row_composable_text),
                backgroundColor =  Color(0xFFB69DF8),
                modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(id = R.string.column_composable),
                description = stringResource(id = R.string.column_composable_text),
                backgroundColor =  Color(0xFFF6EDFF),
                modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun ComposableInfoCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
){
    Column(
        modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuadrantPreview() {
    ComposeQuadrantTheme {
        QuadrantApp(
            composableTextTitle = stringResource(R.string.text_composable_title),
            composableText = stringResource(R.string.text_composable),
            composableImageTitle = stringResource(R.string.image_composable),
            composableImageText = stringResource(R.string.image_composable_text)
        )
    }
}