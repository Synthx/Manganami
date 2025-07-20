package org.yezebi.manga.domains.manga.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import manga.composeapp.generated.resources.Res
import manga.composeapp.generated.resources.volume_number
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.yezebi.manga.component.Image
import org.yezebi.manga.component.SingleLineText
import org.yezebi.manga.domains.manga.model.MinimalVolume

@Composable
fun VolumeCard(
    volume: MinimalVolume,
    onClick: (String) -> Unit = {}
) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp), modifier = Modifier.clickable { onClick(volume.id) }) {
        Image(volume.imageUrl)
        Column {
            SingleLineText(
                volume.title,
                style = MaterialTheme.typography.bodyMedium,
            )
            Text(
                stringResource(Res.string.volume_number, volume.number),
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview
@Composable
internal fun VolumeCardPreview() {
    val volume = MinimalVolume(
        id = "1",
        number = 3,
        imageUrl = "https://m.media-amazon.com/images/I/41mMPo6+03L._SY500_.jpg",
        title = "Ruridragon"
    )

    VolumeCard(volume)
}
