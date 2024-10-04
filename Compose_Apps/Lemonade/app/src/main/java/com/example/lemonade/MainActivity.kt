package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MakeTheLemonadeApp()
                }
            }
        }
    }
}

@Composable
fun MakeTheLemonadeApp(modifier: Modifier = Modifier
    .wrapContentSize(Alignment.Center)
    ) {
    var nextImage by remember {
        mutableStateOf(1)
    }

    var imageSelector = when(nextImage) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    var stringSelector = when (imageSelector) {
        R.drawable.lemon_tree -> R.string.lemon_tree
        R.drawable.lemon_squeeze -> R.string.lemon_squeeze
        R.drawable.lemon_drink -> R.string.lemonade_drink
        else -> R.string.empty_glass
    }
    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            shape = RoundedCornerShape(22),
            onClick = {
                if(nextImage in 1..3) {
                    if(nextImage == 2) {
                        var noOfClicks = (1..3).random()
                        var count: Int = 0
                        while(count < noOfClicks) {
                            nextImage = 2
                            count++
                        }
                    }
                    nextImage++
                }
                else {
                    nextImage = 1
                }
            }
        ){
            Image(
                painter = painterResource(imageSelector),
                contentDescription = stringResource(R.string.empty_glass_content_description
                )
            )
        }
        Spacer(modifier = modifier.padding(10.dp))
        Text(
            text = stringResource(stringSelector)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MakeTheLemonadeMaking() {
    LemonadeTheme () {
        MakeTheLemonadeApp()
    }
}