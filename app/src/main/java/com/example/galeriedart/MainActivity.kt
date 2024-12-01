package com.example.galeriedart


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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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


    data class ImageData(val imageResource: Int, val title: Int, val auteur: Int, val date: Int)

    val images = listOf(
        ImageData(R.drawable.__the_gallery, R.string.titre1, R.string.auteur1, R.string.date1),
        ImageData(R.drawable.__the_kiss, R.string.titre2, R.string.auteur2, R.string.date2), // Add title resource for other images
        ImageData(R.drawable.__nuit_etoilee, R.string.titre3, R.string.auteur3, R.string.date3) // Add title resource for other images
    )


    @Composable
    fun PageWithImageTextAndButtons(modifier: Modifier = Modifier) {
        var currentImageIndex by remember { mutableStateOf(0) }
        val currentImage = remember(currentImageIndex) { images[currentImageIndex] }
        Column(
            modifier = modifier
                .wrapContentSize()
                .padding(26.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(currentImage.imageResource),
                contentDescription = stringResource(currentImage.title)
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
                    Text(text = stringResource(currentImage.auteur), Modifier.padding(horizontal = 5.dp))
                    Text(text = stringResource(currentImage.date), Modifier.padding(horizontal = 5.dp))
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier) {
                Button(onClick = {
                        currentImageIndex = (currentImageIndex - 1 + images.size) % images.size
                                }
                        ) { Text(text = stringResource(R.string.btPrevious)) }
                Spacer(Modifier.weight(1f))
                Button(onClick = {
                    currentImageIndex = (currentImageIndex + 1) % images.size
                        }
                         ) { Text(text = stringResource(R.string.btNext)) }
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