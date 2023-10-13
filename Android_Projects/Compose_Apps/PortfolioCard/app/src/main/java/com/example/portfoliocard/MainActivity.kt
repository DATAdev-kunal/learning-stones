package com.example.portfoliocard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfoliocard.ui.theme.PortfolioCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortfolioCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        Portfolio()
                }
            }
        }
    }
}

@Composable
fun Portfolio(modifier: Modifier = Modifier) {
    Column(

        verticalArrangement = Arrangement.spacedBy(space = 250.dp),
        modifier = Modifier

    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
//                .wrapContentHeight()
                .padding(20.dp, 100.dp, 20.dp, 20.dp)
        ) {
            val image = painterResource(R.drawable.profile_img)
            Image(
                painter = image,
                contentDescription = "This is the profile image",
                modifier = Modifier
                    .padding(90.dp, 0.dp, 90.dp, 20.dp)
            )
            Text(
                text = stringResource(R.string.person_name),
                color = Color(0xFF0D1D73),
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold,

                )
            Text(
                text = stringResource(R.string.title),
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic,

                )
        }

        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(30.dp)
                .wrapContentHeight()
        ) {
            val PhoneIcon = Icons.Rounded.Phone
            val LinkedInIcon = Icons.Rounded.AccountCircle
            val EmailIcon = Icons.Rounded.Email
            Row(
                    horizontalArrangement = Arrangement.spacedBy(space = 20.dp),
                    modifier = Modifier
                        .padding(20.dp, 20.dp, 20.dp, 8.dp)
            ) {
                Icon(
                    imageVector = PhoneIcon,
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.phone),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Row (
                horizontalArrangement = Arrangement.spacedBy(space = 20.dp),
                modifier = Modifier
                    .padding(20.dp,0.dp, 8.dp, 8.dp)
            ){
                Icon(
                    imageVector = LinkedInIcon,
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.linkedIn),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Row (
                horizontalArrangement = Arrangement.spacedBy(space = 18.dp),
                modifier = Modifier
                    .padding(20.dp, 0.dp, 8.dp)
            ){
                Icon(
                    imageVector = EmailIcon,
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.email),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    PortfolioCardTheme {
        Portfolio()
    }
}