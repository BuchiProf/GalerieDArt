package com.example.galeriedart

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.galeriedart.ui.theme.GalerieDArtTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GalerieDArtTheme {
                ArtGalleryApp()
            }
        }
    }

    @Composable
    fun PageWithImageTextAndButtons(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .wrapContentSize()
                .padding(26.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(
                    R.drawable._40px_the_gallery_of_cornelis_van_der_geest
                ),
                contentDescription = "tableau"
            )
            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.titre1),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
                Row(modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "auteur",
                        Modifier.padding(horizontal = 5.dp)
                    )
                    Text(
                        text = "date",
                        Modifier.padding(horizontal = 5.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier) {
                Button(
                    onClick = {/*todo*/ }
                ) { Text(text = "gauche") }
                Spacer(Modifier.weight(1f))
                Button(onClick = {/*todo*/ }) { Text(text = "droite") }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ArtGalleryApp() {
        PageWithImageTextAndButtons(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}