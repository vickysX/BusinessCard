package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun Card() {
    Surface(color = Color.Blue) {
        Column {
            UpperPart()
            LowerPart()
        }
    }
}

@Composable
fun UpperPart() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(
            top = 150.dp,
            bottom = 150.dp
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                bottom = 25.dp
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "android logo",
                modifier = Modifier.padding(
                    start = 100.dp,
                    top = 25.dp,
                    end = 100.dp
                )
            )
            Text(
                text = stringResource(R.string.my_name),
                color = Color.White,
                fontSize = 50.sp,
                fontWeight = FontWeight.Thin
            )
            Text(
                text = stringResource(R.string.my_job_title),
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3ddc84)
            )
        }
    }
}

@Composable
fun LowerPart() {
    Row(
        verticalAlignment = Alignment.Bottom
    ) {
        Column {
            Divider(
                modifier = Modifier.height(1.dp),
                color = Color.White
            )
            Contact(
                R.drawable.ic_contact_phone,
                stringResource(R.string.my_phone_number)
            )
            Divider(
                modifier = Modifier.height(1.dp),
                color = Color.White
            )
            Contact(
                R.drawable.ic_share,
                stringResource(R.string.my_social)
            )
            Divider(
                modifier = Modifier.height(1.dp),
                color = Color.White
            )
            Contact(
                R.drawable.ic_contact_mail,
                stringResource(R.string.my_email)
            )
            Divider(
                modifier = Modifier.height(1.dp),
                color = Color.White
            )
        }
    }
}

@Composable
fun Contact(
    iconId: Int,
    contact: String
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)

    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = null,
            tint = Color(0xFF3ddc84)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = contact,
            color = Color.White
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        Card()
    }
}