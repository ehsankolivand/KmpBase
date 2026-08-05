package io.github.ehsankolivand.kmpbase.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.github.ehsankolivand.kmpbase.core.designsystem.resources.Res
import io.github.ehsankolivand.kmpbase.core.designsystem.resources.bricolage_bold
import io.github.ehsankolivand.kmpbase.core.designsystem.resources.bricolage_extrabold
import io.github.ehsankolivand.kmpbase.core.designsystem.resources.figtree_regular
import io.github.ehsankolivand.kmpbase.core.designsystem.resources.figtree_semibold
import org.jetbrains.compose.resources.Font


@Immutable
data class CatalogFonts(
    val display: FontFamily,
    val ui: FontFamily,
)

@Composable
fun rememberCatalogFonts(): CatalogFonts = CatalogFonts(
    display = FontFamily(
        Font(Res.font.bricolage_bold, FontWeight.Bold),
        Font(Res.font.bricolage_extrabold, FontWeight.ExtraBold),
    ),
    ui = FontFamily(
        Font(Res.font.figtree_regular, FontWeight.Normal),
        Font(Res.font.figtree_semibold, FontWeight.SemiBold),
    ),
)

fun catalogTypography(fonts: CatalogFonts): Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = fonts.display, fontWeight = FontWeight.Bold,
        fontSize = 57.sp, lineHeight = 64.sp, letterSpacing = (-0.25).sp,
    ),
    displayMedium = TextStyle(
        fontFamily = fonts.display, fontWeight = FontWeight.Bold,
        fontSize = 45.sp, lineHeight = 52.sp, letterSpacing = 0.sp,
    ),
    displaySmall = TextStyle(
        fontFamily = fonts.display, fontWeight = FontWeight.Bold,
        fontSize = 40.sp, lineHeight = 48.sp, letterSpacing = (-1.0).sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = fonts.display, fontWeight = FontWeight.Bold,
        fontSize = 32.sp, lineHeight = 40.sp, letterSpacing = 0.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = fonts.display, fontWeight = FontWeight.Bold,
        fontSize = 36.sp, lineHeight = 44.sp, letterSpacing = (-0.5).sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = fonts.display, fontWeight = FontWeight.Bold,
        fontSize = 24.sp, lineHeight = 32.sp, letterSpacing = (-0.25).sp,
    ),
    titleLarge = TextStyle(
        fontFamily = fonts.ui, fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp, lineHeight = 28.sp, letterSpacing = 0.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = fonts.ui, fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp, lineHeight = 22.sp, letterSpacing = 0.15.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = fonts.ui, fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.1.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = fonts.ui, fontWeight = FontWeight.Normal,
        fontSize = 16.sp, lineHeight = 24.sp, letterSpacing = 0.5.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = fonts.ui, fontWeight = FontWeight.Normal,
        fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.25.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = fonts.ui, fontWeight = FontWeight.Normal,
        fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = 0.4.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = fonts.ui, fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp, lineHeight = 20.sp, letterSpacing = 0.1.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = fonts.ui, fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = 0.5.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = fonts.ui, fontWeight = FontWeight.SemiBold,
        fontSize = 11.sp, lineHeight = 16.sp, letterSpacing = 1.2.sp,
    ),
)