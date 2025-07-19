package org.yezebi.manga.model

import manga.composeapp.generated.resources.Res
import manga.composeapp.generated.resources.screen_home_title
import org.jetbrains.compose.resources.StringResource

enum class Screen(val title: StringResource) {
    Home(Res.string.screen_home_title)
}