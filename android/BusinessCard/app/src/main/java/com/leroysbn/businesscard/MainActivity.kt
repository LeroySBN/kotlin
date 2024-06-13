package com.leroysbn.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leroysbn.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    val profilePhoto = painterResource(id = R.drawable.profile_photo)
    Column(
        modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = profilePhoto,
            contentDescription = stringResource(R.string.profile_photo),
            modifier
                .background(color = Color.Black)
                .height(250.dp).width(250.dp),
        )
        Text(
            text = stringResource(R.string.full_name),
            fontSize = 35.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(R.string.title),
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
    }
    Column(
        modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(bottom = 50.dp, start = 90.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom
    ) {
        UserContacts(
            iconType = Icons.Filled.Share,
            iconDescription = stringResource(R.string.website_icon),
            contactInfoDetail = stringResource(R.string.website_link)
        )
        Spacer(modifier.height(8.dp))
        UserContacts(
            iconType = Icons.Filled.DateRange,
            iconDescription = stringResource(R.string.calendar_icon),
            contactInfoDetail = stringResource(R.string.calendar_link)
        )
    }
}

@Composable
private fun UserContacts(
    contactInfoDetail: String,
    modifier: Modifier = Modifier,
    iconType: ImageVector,
    iconDescription: String
){
    Row(modifier) {
        Icon(
            imageVector = iconType,
            contentDescription = iconDescription,
            modifier.height(20.dp),
            tint = Color.Blue
        )
        Spacer(modifier.width(20.dp))
        Text(
            text = contactInfoDetail,
            modifier,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}