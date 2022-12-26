package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
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
            Row() {
               Column() {
                   Image(
                        painter = painterResource(id = R.drawable.android_logo),
                        contentDescription = "android logo"
                   )
                   Text(text = "myName")
                   Text(text = "myJobTitle")
               }
            }
            Row() {
                Column {
                    Contact(R.drawable.ic_contact_phone, "myPhone")
                    Contact(R.drawable.ic_share, "mySocial")
                    Contact(R.drawable.ic_contact_mail, "myEmailAddress")
                }
            }
        }
    }
}

@Composable
fun Contact(
    iconId: Int,
    contact: String
) {
    Row() {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = null
        )
        Text(text = contact)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        Card()
    }
}