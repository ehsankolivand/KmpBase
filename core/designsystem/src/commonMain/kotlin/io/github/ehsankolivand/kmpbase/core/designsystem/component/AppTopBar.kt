package io.github.ehsankolivand.kmpbase.core.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextOverflow
import io.github.ehsankolivand.kmpbase.core.designsystem.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    overline: String? = null,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    LargeTopAppBar(
        modifier = modifier,
        title = {
            Column {
                if (overline != null) {
                    Text(
                        text = overline,
                        style = AppTheme.typography.labelSmall,
                        color = AppTheme.colors.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.graphicsLayer {
                            alpha = 1f - (scrollBehavior?.state?.collapsedFraction ?: 0f)
                        },
                    )
                }
                Text(
                    text = title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        },
        collapsedHeight = AppTheme.sizes.appBarCollapsedHeight,
        expandedHeight = AppTheme.sizes.appBarExpandedHeight,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = AppTheme.colors.surface,
            scrolledContainerColor = AppTheme.colors.surfaceContainer,
            titleContentColor = AppTheme.colors.onSurface,
            navigationIconContentColor = AppTheme.colors.onSurface,
            actionIconContentColor = AppTheme.colors.onSurfaceVariant,
        ),
        scrollBehavior = scrollBehavior,
    )
}


