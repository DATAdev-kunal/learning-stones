package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

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
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    var next by remember {
        mutableStateOf(1)
    }

    val albumCoverState = when (next){
        1 -> R.drawable.album_1_cover
        2 -> R.drawable.album_2_cover
        3 -> R.drawable.album_3_cover
        4 -> R.drawable.album_4_cover
        5 -> R.drawable.album_5_cover
        6 -> R.drawable.album_6_cover
        7 -> R.drawable.album_7_cover
        8 -> R.drawable.album_8_cover
        9 -> R.drawable.album_9_cover
        10 -> R.drawable.album_10_cover
        11 -> R.drawable.album_11_cover
        12 -> R.drawable.album_12_cover
        13 -> R.drawable.album_13_cover
        else -> R.drawable.album_14_cover
    }

    val albumInfoState = when(next){
        1 -> R.string.album_1
        2 -> R.string.album_2
        3 -> R.string.album_3
        4 -> R.string.album_4
        5 -> R.string.album_5
        6 -> R.string.album_6
        7 -> R.string.album_7
        8 -> R.string.album_8
        9 -> R.string.album_9
        10 -> R.string.album_10
        11 -> R.string.album_11
        12 -> R.string.album_12
        13 -> R.string.album_13
        else -> R.string.album_14
    }

    val albumTrackInfo = when(next){
        1 -> R.string.no_of_tracks_album_1
        2 -> R.string.no_of_tracks_album_2
        3 -> R.string.no_of_tracks_album_3
        4 -> R.string.no_of_tracks_album_4
        5 -> R.string.no_of_tracks_album_5
        6 -> R.string.no_of_tracks_album_6
        7 -> R.string.no_of_tracks_album_7
        8 -> R.string.no_of_tracks_album_8
        9 -> R.string.no_of_tracks_album_9
        10 -> R.string.no_of_tracks_album_10
        11 -> R.string.no_of_tracks_album_11
        12 -> R.string.no_of_tracks_album_12
        13 -> R.string.no_of_tracks_album_13
        else -> R.string.no_of_tracks_album_14
    }
    val albumReleaseYear = when(next){
        1 -> R.string.album_year_1
        2 -> R.string.album_year_2
        3 -> R.string.album_year_3
        4 -> R.string.album_year_4
        5 -> R.string.album_year_5
        6 -> R.string.album_year_6
        7 -> R.string.album_year_7
        8 -> R.string.album_year_8
        9 -> R.string.album_year_9
        10 -> R.string.album_year_10
        11 -> R.string.album_year_11
        12 -> R.string.album_year_12
        13 -> R.string.album_year_13
        else -> R.string.album_year_14
    }

    Column (
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
//            .verticalScroll(ScrollState(0),true)
            .background(colorResource(R.color.App_bg))
            .wrapContentSize()
    ) {
        Surface (
            shadowElevation = 10.dp,
            modifier = Modifier
                .shadow(10.dp, shape = RoundedCornerShape(10))
                .background(colorResource(R.color.Info_bg))
                .padding(30.dp)
        ) {
            Image(
                painter = painterResource(id = albumCoverState),
                contentDescription = stringResource(id = albumInfoState),
                modifier = Modifier
                    .shadow(5.dp, shape = RoundedCornerShape(10))
                    .background(color = colorResource(R.color.Image_bg))
                    .padding(start = 20.dp, end = 20.dp)
                    .size(width = 400.dp, height = 500.dp)
            )
        }
        Surface (
            modifier = Modifier
                .shadow(10.dp, shape = RoundedCornerShape(25.dp))
                .padding(top = 20.dp)
                .background(color = colorResource(R.color.Info_bg))
        ) {
            Column (
                modifier = Modifier
                    .background(colorResource(R.color.Text_bg))
                    .padding(8.dp)
            ){
                Text(
                    text = stringResource(id = albumInfoState),
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Italic,
                    modifier = modifier
                        .padding(top = 20.dp, bottom = 5.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    Text(
                        text = stringResource(id = albumTrackInfo),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.padding(15.dp))
                    Text(
                        text = stringResource(id = albumReleaseYear),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding(15.dp))
        Row {
            Button(onClick = {
                if(next in 2..14){
                    next--
                }

            }) {
                Text(text = stringResource(R.string.prev_button))
            }

            Spacer(modifier = Modifier.padding(50.dp))

            Button(onClick = {
                if(next in 1..13){
                    next++
                }
            }) {
                Text(text = stringResource(R.string.next_button))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}