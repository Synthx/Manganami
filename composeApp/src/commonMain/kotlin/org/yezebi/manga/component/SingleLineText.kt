package org.yezebi.manga.component

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun SingleLineText(text: String, color: Color = Color.Unspecified, style: TextStyle = LocalTextStyle.current) {
    Text(text, color = color, style = style, maxLines = 1, overflow = TextOverflow.Ellipsis)
}
