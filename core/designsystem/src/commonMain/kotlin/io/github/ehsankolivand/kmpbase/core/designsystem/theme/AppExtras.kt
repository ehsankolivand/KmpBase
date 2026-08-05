package io.github.ehsankolivand.kmpbase.core.designsystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Immutable
data class AppTypeExtras(
    val priceEmphasized: TextStyle,
)

fun catalogTypeExtras(fonts: CatalogFonts): AppTypeExtras = AppTypeExtras(
    priceEmphasized = TextStyle(
        fontFamily = fonts.display,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 22.sp,
        lineHeight = 26.sp,
        letterSpacing = (-0.4).sp,
    ),
)

@Immutable
data class AppShapeExtras(
    val thumbnail: Shape = RoundedCornerShape(20.dp),
    val extraLargeIncreased: Shape = RoundedCornerShape(32.dp),
    val huge: Shape = RoundedCornerShape(48.dp),
)

@Immutable
data class ElevationLevel(val tonal: Dp, val shadow: Dp)

@Immutable
data class AppElevation(
    val level0: ElevationLevel = ElevationLevel(0.dp, 0.dp),
    val level1: ElevationLevel = ElevationLevel(1.dp, 1.dp),
    val level2: ElevationLevel = ElevationLevel(3.dp, 3.dp),
    val level3: ElevationLevel = ElevationLevel(6.dp, 6.dp),
    val level4: ElevationLevel = ElevationLevel(8.dp, 8.dp),
    val level5: ElevationLevel = ElevationLevel(12.dp, 12.dp),
)

val LocalAppTypeExtras = staticCompositionLocalOf<AppTypeExtras> {
    error("AppTypeExtras not provided. Wrap your content in CatalogTheme.")
}
val LocalAppShapeExtras = staticCompositionLocalOf { AppShapeExtras() }
val LocalAppElevation = staticCompositionLocalOf { AppElevation() }