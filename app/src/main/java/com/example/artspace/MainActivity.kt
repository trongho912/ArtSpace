package com.example.artspace

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Artwork(artwork: Int, desc: String, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = artwork),
        contentDescription = desc)
}

@Composable
fun ArtworkDetail(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "",
        modifier = modifier
    )
}

@Composable
fun ArtworkTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        modifier = modifier,
        fontSize = 20.sp
    )
}

@Composable
fun ArtworkArtist(name: String, year: String, modifier: Modifier = Modifier) {
    if (year != null) {
        Text(
            text = name,
            modifier = modifier
        )
    } else {
        Text(
            text = buildAnnotatedString {
                append("$name ")
                withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) {
                    append("($year)")
                }
            },
            modifier = modifier
        )
    }
}

@Composable
fun ButtonGroup(name: String, modifier: Modifier = Modifier) {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .fillMaxWidth()
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = modifier.width(120.dp)
        ) {
            Text(stringResource(id = R.string.previous))
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = modifier.width(120.dp)
        ){
            Text(stringResource(id = R.string.next))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkPreview() {
    ArtSpaceTheme {
        Artwork(R.drawable.the_starry_night, "starry night")
    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkDetailPreview() {
    ArtSpaceTheme {
        Artwork(R.drawable.the_starry_night, "starry night")
    }
}


@Preview(showBackground = true)
@Composable
fun ButtonGroupPreview() {
    ArtSpaceTheme {
        ButtonGroup("Android")
    }
}