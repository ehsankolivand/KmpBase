package io.github.ehsankolivand.kmpbase.core.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import io.github.ehsankolivand.kmpbase.core.designsystem.theme.AppTheme

@Composable
fun CatalogCircularIndicator(
    modifier: Modifier = Modifier,
    size: Dp = AppTheme.sizes.indicatorFirstLoad,
    contentDescription: String = "Loading products",
) {
    CircularProgressIndicator(
        modifier = modifier
            .size(size)
            .semantics { this.contentDescription = contentDescription },
        color = AppTheme.colors.primary,
        trackColor = AppTheme.colors.surfaceContainerHighest,
        strokeWidth = AppTheme.sizes.indicatorStroke,
        strokeCap = StrokeCap.Round,
    )
}

@Composable
fun PaginationFooter(
    modifier: Modifier = Modifier,
    contentDescription: String = "Loading more products",
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(AppTheme.sizes.paginationFooterHeight),
        contentAlignment = Alignment.Center,
    ) {
        CatalogCircularIndicator(
            size = AppTheme.sizes.indicatorPagination,
            contentDescription = contentDescription,
        )
    }
}