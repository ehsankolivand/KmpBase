package io.github.ehsankolivand.kmpbase.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember

@Composable
fun CatalogTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val fonts = rememberCatalogFonts()
    val typography = remember(fonts) { catalogTypography(fonts) }
    val typeExtras = remember(fonts) { catalogTypeExtras(fonts) }

    CompositionLocalProvider(
        LocalSpacing provides Spacing(),
        LocalSizes provides Sizes(),
        LocalAppMotion provides AppMotion(),
        LocalAppTypeExtras provides typeExtras,
        LocalAppShapeExtras provides AppShapeExtras(),
        LocalAppElevation provides AppElevation(),
    ) {
        MaterialTheme(
            colorScheme = if (darkTheme) CatalogDarkColorScheme else CatalogLightColorScheme,
            typography = typography,
            shapes = CatalogShapes,
            content = content,
        )
    }
}

object AppTheme {
    val colors: ColorScheme
        @Composable @ReadOnlyComposable get() = MaterialTheme.colorScheme

    val typography: Typography
        @Composable @ReadOnlyComposable get() = MaterialTheme.typography

    val shapes: Shapes
        @Composable @ReadOnlyComposable get() = MaterialTheme.shapes

    val spacing: Spacing
        @Composable @ReadOnlyComposable get() = LocalSpacing.current

    val sizes: Sizes
        @Composable @ReadOnlyComposable get() = LocalSizes.current

    val motion: AppMotion
        @Composable @ReadOnlyComposable get() = LocalAppMotion.current

    val typeExtras: AppTypeExtras
        @Composable @ReadOnlyComposable get() = LocalAppTypeExtras.current

    val shapeExtras: AppShapeExtras
        @Composable @ReadOnlyComposable get() = LocalAppShapeExtras.current

    val elevation: AppElevation
        @Composable @ReadOnlyComposable get() = LocalAppElevation.current
}