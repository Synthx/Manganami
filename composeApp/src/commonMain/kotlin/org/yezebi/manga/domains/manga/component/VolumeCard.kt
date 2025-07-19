package org.yezebi.manga.domains.manga.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kotlinx.datetime.LocalDate
import manga.composeapp.generated.resources.Res
import manga.composeapp.generated.resources.volume_number
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.yezebi.manga.component.Image
import org.yezebi.manga.domains.manga.model.Volume

@Composable
fun VolumeCard(
    volume: Volume
) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Image(volume.imageUrl)
        Column {
            Text(
                volume.title,
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
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
    val volume = Volume(
        id = "1",
        number = 3,
        releaseDate = LocalDate(2025, 1, 1),
        imageUrl = "https://m.media-amazon.com/images/I/41mMPo6+03L._SY500_.jpg",
        title = "Ruridragon"
    )

    VolumeCard(volume)
}
