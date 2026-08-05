package io.github.ehsankolivand.kmpbase.core.designsystem.component

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import io.github.ehsankolivand.kmpbase.core.designsystem.theme.AppTheme

enum class ThumbnailStatus { Loading, Success, Failure }

@Composable
fun ProductThumbnail(
    status: ThumbnailStatus,
    modifier: Modifier = Modifier,
    size: Dp = AppTheme.sizes.thumbnail,
    failureContentDescription: String = "Image unavailable",
    image: @Composable BoxScope.() -> Unit = {},
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(AppTheme.shapeExtras.thumbnail)
            .background(AppTheme.colors.surfaceContainerHighest),
        contentAlignment = Alignment.Center,
    ) {
        Crossfade(
            targetState = status,
            animationSpec = AppTheme.motion.thumbnailCrossfade(),
            label = "thumbnailStatus",
        ) { current ->
            Box(modifier = Modifier.size(size), contentAlignment = Alignment.Center) {
                when (current) {
                    ThumbnailStatus.Loading -> Unit
                    ThumbnailStatus.Success -> image()
                    ThumbnailStatus.Failure -> Icon(
                        imageVector = Icons.Filled.Warning,
                        contentDescription = failureContentDescription,
                        tint = AppTheme.colors.outline,
                        modifier = Modifier.size(AppTheme.sizes.thumbnailFailureIcon),
                    )
                }
            }
        }
    }
}