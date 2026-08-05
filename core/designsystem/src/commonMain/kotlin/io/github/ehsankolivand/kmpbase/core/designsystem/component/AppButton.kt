package io.github.ehsankolivand.kmpbase.core.designsystem.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import io.github.ehsankolivand.kmpbase.core.designsystem.theme.AppTheme

@Composable
fun CatalogPrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: ImageVector? = null,
    iconContentDescription: String? = null,
) {
    Button(
        onClick = onClick,
        modifier = modifier.heightIn(min = AppTheme.sizes.buttonHeight),
        enabled = enabled,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = AppTheme.colors.primary,
            contentColor = AppTheme.colors.onPrimary,
            disabledContainerColor = AppTheme.colors.onSurface.copy(alpha = 0.12f),
            disabledContentColor = AppTheme.colors.onSurface.copy(alpha = 0.38f),
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = AppTheme.elevation.level0.shadow,
            pressedElevation = AppTheme.elevation.level0.shadow,
            focusedElevation = AppTheme.elevation.level0.shadow,
            hoveredElevation = AppTheme.elevation.level0.shadow,
            disabledElevation = AppTheme.elevation.level0.shadow,
        ),
        contentPadding = PaddingValues(horizontal = AppTheme.spacing.xl),
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = iconContentDescription,
                modifier = Modifier.size(AppTheme.sizes.iconInButton),
            )
            Spacer(modifier = Modifier.width(AppTheme.spacing.sm))
        }
        Text(text = text, style = AppTheme.typography.labelLarge)
    }
}