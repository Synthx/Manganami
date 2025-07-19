package org.yezebi.manga.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun Image(url: String?) {
    val baseModifier = Modifier
        .fillMaxWidth()
        .aspectRatio(2/3f)
    val shape = RoundedCornerShape(4.dp)

    if (url == null) {
        Card(
            shape = shape,
            modifier = baseModifier,
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text("No Image")
            }
        }
    }

    AsyncImage(
        model = url,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = baseModifier.clip(shape),
    )
}
