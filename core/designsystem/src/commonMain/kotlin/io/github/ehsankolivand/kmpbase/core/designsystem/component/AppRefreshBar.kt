package io.github.ehsankolivand.kmpbase.core.designsystem.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import io.github.ehsankolivand.kmpbase.core.designsystem.theme.AppTheme

@Composable
fun RefreshIndicatorSlot(
    visible: Boolean,
    modifier: Modifier = Modifier,
    contentDescription: String = "Refreshing products",
) {
    val motion = AppTheme.motion
    val alpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = if (visible) motion.refreshBarEnter() else motion.refreshBarExit(),
        label = "refreshBarAlpha",
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(AppTheme.sizes.progressTrackHeight),
    ) {
        if (alpha > 0f) {
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer { this.alpha = alpha }
                    .semantics { this.contentDescription = contentDescription },
                color = AppTheme.colors.primary,
                trackColor = AppTheme.colors.surfaceContainerHighest,
                strokeCap = StrokeCap.Round,
            )
        }
    }
}