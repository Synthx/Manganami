package org.yezebi.manga.config.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun CustomTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = themeDarkColorScheme,
        typography = themeTypography,
        content = content
    )
}
