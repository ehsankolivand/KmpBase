package io.github.ehsankolivand.kmpbase.core.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.github.ehsankolivand.kmpbase.core.designsystem.theme.AppTheme

@Composable
fun CatalogErrorState(
    headline: String,
    supportingText: String,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier,
    retryLabel: String = "Retry",
    retryEnabled: Boolean = true,
    icon: ImageVector = Icons.Filled.Warning,
    iconContentDescription: String? = null,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = AppTheme.spacing.stateGutter),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = iconContentDescription,
            tint = AppTheme.colors.error,
            modifier = Modifier.size(AppTheme.sizes.stateIcon),
        )
        Text(
            text = headline,
            style = AppTheme.typography.headlineSmall,
            color = AppTheme.colors.onSurface,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = AppTheme.spacing.stateIconToHeadline),
        )
        Text(
            text = supportingText,
            style = AppTheme.typography.bodyLarge,
            color = AppTheme.colors.onSurfaceVariant,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = AppTheme.spacing.stateHeadlineToBody)
                .widthIn(max = 280.dp),
        )
        CatalogPrimaryButton(
            text = retryLabel,
            onClick = onRetry,
            enabled = retryEnabled,
            modifier = Modifier.padding(top = AppTheme.spacing.stateBodyToAction),
        )
    }
}