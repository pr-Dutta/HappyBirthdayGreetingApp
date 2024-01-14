package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme
import androidx.compose.foundation.Image                                 // manually added
import androidx.compose.foundation.layout.Box

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(                         // - (14-01-2024)
                        message = "Happy Birthday Sam!",
                        from = "From Emma"
                    )
                }
            }
        }
    }
}

// The name of the function is a noun,  -> This will great you with the text
@Composable
fun GreetingText(
    message: String,
    from: String,
    modifier: Modifier = Modifier
) {
    Column(     // (11-01-2024)
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)
    ) {
        Text(   // (11-01-2024)
            text = message,
            fontSize = 96.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            // From the next element textAlign doesn't works
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.End)
        )
    }
}

// - (13-01-2024)   //This will great you with the image
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {

    /* painterResource() function loads a drawable image resource and takes
    * resource ID (R.drawable.androidparty in this case) as an argument.*/
    val image = painterResource(R.drawable.androidparty)

    /* In the box layout Composable the UI elements are stacked
    * one in the top of other */

    // - (14-01-2024)               ----   I have to rigorously revise the entire data flow
    Box {
        Image(
            painter = image,
            contentDescription = null
        )

        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
            )
    }
}

/* (07-01-2024), Preview with parameters, it provides extra information
* to the tool processing it */
@Preview(
    showBackground = true,
    //showSystemUi = true,
    name = "My preview"
)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingImage(                              // - (14-01-2024)
            message = "Happy Birthday Sam!",
            from = "From Emma"
        )
    }
}


