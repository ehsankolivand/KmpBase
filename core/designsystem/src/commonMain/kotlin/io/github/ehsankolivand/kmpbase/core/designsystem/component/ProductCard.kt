package io.github.ehsankolivand.kmpbase.core.designsystem.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.text.style.TextOverflow
import io.github.ehsankolivand.kmpbase.core.designsystem.theme.AppTheme

@Composable
fun ProductCard(
    title: String,
    price: String,
    meta: String,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    thumbnail: @Composable () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()
    val container by animateColorAsState(
        targetValue = if (pressed) {
            AppTheme.colors.surfaceContainerHigh
        } else {
            AppTheme.colors.surfaceContainer
        },
        animationSpec = AppTheme.motion.pressFeedback(),
        label = "productCardContainer",
    )

    Card(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = AppTheme.sizes.cardMinHeight)
            .clearAndSetSemantics { this.contentDescription = contentDescription },
        enabled = enabled,
        shape = AppTheme.shapes.extraLarge,
        colors = CardDefaults.cardColors(
            containerColor = container,
            contentColor = AppTheme.colors.onSurface,
            disabledContainerColor = AppTheme.colors.onSurface.copy(alpha = 0.12f),
            disabledContentColor = AppTheme.colors.onSurface.copy(alpha = 0.38f),
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = AppTheme.elevation.level0.shadow,
            pressedElevation = AppTheme.elevation.level0.shadow,
            focusedElevation = AppTheme.elevation.level0.shadow,
            hoveredElevation = AppTheme.elevation.level0.shadow,
            disabledElevation = AppTheme.elevation.level0.shadow,
        ),
        interactionSource = interactionSource,
    ) {
        Row(
            modifier = Modifier.padding(AppTheme.spacing.cardPadding),
            horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.cardThumbnailGap),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            thumbnail()
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = AppTheme.typography.titleMedium,
                    color = AppTheme.colors.onSurface,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = price,
                    style = AppTheme.typeExtras.priceEmphasized,
                    color = AppTheme.colors.tertiary,
                    maxLines = 1,
                    modifier = Modifier.padding(top = AppTheme.spacing.cardTitleToPrice),
                )
                Row(
                    modifier = Modifier.padding(top = AppTheme.spacing.cardPriceToMeta),
                    horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.ratingIconGap),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null,
                        tint = AppTheme.colors.onSurfaceVariant,
                        modifier = Modifier.size(AppTheme.sizes.iconInline),
                    )
                    Text(
                        text = meta,
                        style = AppTheme.typography.bodyMedium,
                        color = AppTheme.colors.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}