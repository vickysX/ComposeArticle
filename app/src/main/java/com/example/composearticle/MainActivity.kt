package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Article()
                }
            }
        }
    }
}

@Composable
fun Article() {
    Column {
        Image(
            painter = painterResource(R.drawable.bg_compose_background),
            contentDescription = null,
            modifier = Modifier
                .wrapContentHeight(Alignment.Top)
                .fillMaxWidth()
        )
        TextPart(
            res = R.string.article_title,
            size = 24.sp,
            top = 16.dp,
            bottom = 16.dp
        )
        TextPart(
            res = R.string.first_paragraph,
            align = TextAlign.Justify
        )
        TextPart(
            res = R.string.second_paragraph,
            top = 16.dp,
            bottom = 16.dp,
            align = TextAlign.Justify
        )
    }
}

@Composable
fun TextPart(
    res: Int,
    size: TextUnit = TextUnit.Unspecified,
    top: Dp = 0.dp,
    bottom: Dp = 0.dp,
    align: TextAlign? = null
) {
    Text(
        text = stringResource(id = res),
        fontSize = size,
        textAlign = align,
        modifier = Modifier.padding(
            start = 16.dp,
            end = 16.dp,
            bottom = bottom,
            top = top
        )
    )

}

@Preview(showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
        Article()
    }
}