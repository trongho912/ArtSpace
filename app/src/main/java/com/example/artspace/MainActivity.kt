package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
//                var currentImage by remember { mutableStateOf(1) }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Artwork(artwork = imageResource, desc = stringResource(id = imageName))
                        ArtworkTitle(title = stringResource(imageName))
                        ArtworkArtist(
                            name = stringResource(id = imageArtist),
                            year = stringResource(id = imageYear)
                        )
                        ButtonGroup(name = "")
                    }
                }
            }
        }
    }
}

@Composable
fun ArtApp() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Artwork(artwork = imageResource, desc = stringResource(id = imageName))
            ArtworkDetail(
                artName = stringResource(imageName),
                artistName = stringResource(id = imageArtist),
                artYear = stringResource(id = imageYear)
            )
            ButtonGroup(name = "")
        }
    }
}

@Composable
fun Artwork(artwork: Int, desc: String, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = artwork),
        contentDescription = desc)
}

@Composable
fun ArtworkDetail(artName: String, artistName: String, artYear: String, modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ArtworkTitle(title = artName)
        ArtworkArtist(name = artistName, year = artYear)
    }
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
    if (year == "") {
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
            onClick = {picNumber--},
            modifier = modifier.width(120.dp),
            enabled = picNumber != 1
        ) {
            Text(stringResource(id = R.string.previous))
        }
        Button(
            onClick = {picNumber++},
            modifier = modifier.width(120.dp),
            enabled = picNumber != 3
        ){
            Text(stringResource(id = R.string.next))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtAppPreview() {
    ArtSpaceTheme {
        ArtApp()
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
fun ArtworkTitlePreview() {
    ArtSpaceTheme {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Artwork(artwork = imageResource, desc = stringResource(id = imageName))
            ArtworkTitle(title = stringResource(imageName))
            ArtworkArtist(
                name = stringResource(id = imageArtist),
                year = stringResource(id = imageYear)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkDetailPreview() {
    ArtSpaceTheme {
        ArtworkArtist(
            name = stringResource(id = imageArtist),
            year = stringResource(id = imageYear),
            modifier = Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonGroupPreview() {
    ArtSpaceTheme {
        ButtonGroup("Android")
    }
}

var picNumber = 3

val imageResource = when (picNumber) {
    1 -> R.drawable.the_starry_night
    2 -> R.drawable.mona_lisa
    else -> R.drawable.to_ngoc_van_thieu_nu_ben_hoa_hue
}

val imageName = when (picNumber) {
    1 -> R.string.pic1
    2 -> R.string.pic2
    else -> R.string.pic3
}

val imageArtist = when (picNumber) {
    1 -> R.string.artist1
    2 -> R.string.artist2
    else -> R.string.artist3
}

val imageYear = when (picNumber) {
    1 -> R.string.year1
    2 -> R.string.year2
    else -> R.string.year3
}

