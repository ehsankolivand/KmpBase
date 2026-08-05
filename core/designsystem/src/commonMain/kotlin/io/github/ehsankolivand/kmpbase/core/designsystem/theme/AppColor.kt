package io.github.ehsankolivand.kmpbase.core.designsystem.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

internal object CatalogPalette {
    val Teal10 = Color(0xFF00201F)
    val Teal20 = Color(0xFF003735)
    val Teal30 = Color(0xFF00504D)
    val Teal40 = Color(0xFF006A66)
    val Teal80 = Color(0xFF80D5CF)
    val Teal90 = Color(0xFF9CF1EA)

    val Sage10 = Color(0xFF051F1F)
    val Sage20 = Color(0xFF1C3534)
    val Sage30 = Color(0xFF324B4A)
    val Sage40 = Color(0xFF4A6362)
    val Sage80 = Color(0xFFB1CCCB)
    val Sage90 = Color(0xFFCDE8E7)

    val Amber10 = Color(0xFF2A1700)
    val Amber20 = Color(0xFF472A00)
    val Amber30 = Color(0xFF663E00)
    val Amber40 = Color(0xFF875400)
    val Amber80 = Color(0xFFFFB951)
    val Amber90 = Color(0xFFFFDDB3)

    val Red10 = Color(0xFF410002)
    val Red20 = Color(0xFF690005)
    val Red30 = Color(0xFF93000A)
    val Red40 = Color(0xFFBA1A1A)
    val Red80 = Color(0xFFFFB4AB)
    val Red90 = Color(0xFFFFDAD6)

    val Neutral0 = Color(0xFF000000)
    val Neutral4 = Color(0xFF090F0F)
    val Neutral6 = Color(0xFF0E1514)
    val Neutral10 = Color(0xFF171D1C)
    val Neutral12 = Color(0xFF1B2121)
    val Neutral17 = Color(0xFF252B2B)
    val Neutral20 = Color(0xFF2B3231)
    val Neutral22 = Color(0xFF303636)
    val Neutral24 = Color(0xFF343A3A)
    val Neutral87 = Color(0xFFD5DBDA)
    val Neutral90 = Color(0xFFDDE4E2)
    val Neutral92 = Color(0xFFE3E9E8)
    val Neutral94 = Color(0xFFE8EFED)
    val Neutral95 = Color(0xFFECF2F0)
    val Neutral96 = Color(0xFFEEF5F3)
    val Neutral98 = Color(0xFFF4FBF9)
    val Neutral100 = Color(0xFFFFFFFF)

    val NeutralVariant30 = Color(0xFF3F4948)
    val NeutralVariant50 = Color(0xFF6F7978)
    val NeutralVariant60 = Color(0xFF899392)
    val NeutralVariant80 = Color(0xFFBEC9C7)
    val NeutralVariant90 = Color(0xFFDAE5E3)
}

val CatalogLightColorScheme: ColorScheme = lightColorScheme(
    primary = CatalogPalette.Teal40,
    onPrimary = CatalogPalette.Neutral100,
    primaryContainer = CatalogPalette.Teal90,
    onPrimaryContainer = CatalogPalette.Teal10,
    inversePrimary = CatalogPalette.Teal80,
    secondary = CatalogPalette.Sage40,
    onSecondary = CatalogPalette.Neutral100,
    secondaryContainer = CatalogPalette.Sage90,
    onSecondaryContainer = CatalogPalette.Sage10,
    tertiary = CatalogPalette.Amber40,
    onTertiary = CatalogPalette.Neutral100,
    tertiaryContainer = CatalogPalette.Amber90,
    onTertiaryContainer = CatalogPalette.Amber10,
    error = CatalogPalette.Red40,
    onError = CatalogPalette.Neutral100,
    errorContainer = CatalogPalette.Red90,
    onErrorContainer = CatalogPalette.Red10,
    background = CatalogPalette.Neutral98,
    onBackground = CatalogPalette.Neutral10,
    surface = CatalogPalette.Neutral98,
    onSurface = CatalogPalette.Neutral10,
    surfaceVariant = CatalogPalette.NeutralVariant90,
    onSurfaceVariant = CatalogPalette.NeutralVariant30,
    surfaceTint = CatalogPalette.Teal40,
    inverseSurface = CatalogPalette.Neutral20,
    inverseOnSurface = CatalogPalette.Neutral95,
    outline = CatalogPalette.NeutralVariant50,
    outlineVariant = CatalogPalette.NeutralVariant80,
    scrim = CatalogPalette.Neutral0,
    surfaceBright = CatalogPalette.Neutral98,
    surfaceDim = CatalogPalette.Neutral87,
    surfaceContainerLowest = CatalogPalette.Neutral100,
    surfaceContainerLow = CatalogPalette.Neutral96,
    surfaceContainer = CatalogPalette.Neutral94,
    surfaceContainerHigh = CatalogPalette.Neutral92,
    surfaceContainerHighest = CatalogPalette.Neutral90,
)

val CatalogDarkColorScheme: ColorScheme = darkColorScheme(
    primary = CatalogPalette.Teal80,
    onPrimary = CatalogPalette.Teal20,
    primaryContainer = CatalogPalette.Teal30,
    onPrimaryContainer = CatalogPalette.Teal90,
    inversePrimary = CatalogPalette.Teal40,
    secondary = CatalogPalette.Sage80,
    onSecondary = CatalogPalette.Sage20,
    secondaryContainer = CatalogPalette.Sage30,
    onSecondaryContainer = CatalogPalette.Sage90,
    tertiary = CatalogPalette.Amber80,
    onTertiary = CatalogPalette.Amber20,
    tertiaryContainer = CatalogPalette.Amber30,
    onTertiaryContainer = CatalogPalette.Amber90,
    error = CatalogPalette.Red80,
    onError = CatalogPalette.Red20,
    errorContainer = CatalogPalette.Red30,
    onErrorContainer = CatalogPalette.Red90,
    background = CatalogPalette.Neutral6,
    onBackground = CatalogPalette.Neutral90,
    surface = CatalogPalette.Neutral6,
    onSurface = CatalogPalette.Neutral90,
    surfaceVariant = CatalogPalette.NeutralVariant30,
    onSurfaceVariant = CatalogPalette.NeutralVariant80,
    surfaceTint = CatalogPalette.Teal80,
    inverseSurface = CatalogPalette.Neutral90,
    inverseOnSurface = CatalogPalette.Neutral20,
    outline = CatalogPalette.NeutralVariant60,
    outlineVariant = CatalogPalette.NeutralVariant30,
    scrim = CatalogPalette.Neutral0,
    surfaceBright = CatalogPalette.Neutral24,
    surfaceDim = CatalogPalette.Neutral6,
    surfaceContainerLowest = CatalogPalette.Neutral4,
    surfaceContainerLow = CatalogPalette.Neutral10,
    surfaceContainer = CatalogPalette.Neutral12,
    surfaceContainerHigh = CatalogPalette.Neutral17,
    surfaceContainerHighest = CatalogPalette.Neutral22,
)