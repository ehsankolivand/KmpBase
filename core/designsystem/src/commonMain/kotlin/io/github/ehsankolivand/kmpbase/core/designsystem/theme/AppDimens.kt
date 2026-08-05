package io.github.ehsankolivand.kmpbase.core.designsystem.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Spacing(
    val xxs: Dp = 2.dp,
    val xs: Dp = 4.dp,
    val sm: Dp = 8.dp,
    val md: Dp = 12.dp,
    val base: Dp = 16.dp,
    val lg: Dp = 20.dp,
    val xl: Dp = 24.dp,
    val xxl: Dp = 32.dp,
    val xxxl: Dp = 48.dp,
    val screenHorizontal: Dp = 16.dp,
    val listContentTop: Dp = 12.dp,
    val listContentBottom: Dp = 24.dp,
    val cardGap: Dp = 12.dp,
    val cardPadding: Dp = 12.dp,
    val cardThumbnailGap: Dp = 16.dp,
    val cardTitleToPrice: Dp = 4.dp,
    val cardPriceToMeta: Dp = 2.dp,
    val ratingIconGap: Dp = 4.dp,
    val appBarToSearch: Dp = 8.dp,
    val searchToProgress: Dp = 8.dp,
    val stateGutter: Dp = 32.dp,
    val stateIconToHeadline: Dp = 20.dp,
    val stateHeadlineToBody: Dp = 8.dp,
    val stateBodyToAction: Dp = 24.dp,
    val minTouchTarget: Dp = 48.dp,
) {
    val listContentPadding: PaddingValues
        get() = PaddingValues(
            start = screenHorizontal,
            end = screenHorizontal,
            top = listContentTop,
            bottom = listContentBottom,
        )
}

@Immutable
data class Sizes(
    val thumbnail: Dp = 88.dp,
    val cardMinHeight: Dp = 112.dp,
    val searchFieldHeight: Dp = 56.dp,
    val progressTrackHeight: Dp = 4.dp,
    val paginationFooterHeight: Dp = 72.dp,
    val buttonHeight: Dp = 56.dp,
    val indicatorFirstLoad: Dp = 48.dp,
    val indicatorPagination: Dp = 32.dp,
    val indicatorStroke: Dp = 4.dp,
    val stateIcon: Dp = 40.dp,
    val thumbnailFailureIcon: Dp = 28.dp,
    val iconStandard: Dp = 24.dp,
    val iconInButton: Dp = 20.dp,
    val iconInline: Dp = 16.dp,
    val appBarCollapsedHeight: Dp = 64.dp,
    val appBarExpandedHeight: Dp = 92.dp,
)

val LocalSpacing = staticCompositionLocalOf { Spacing() }
val LocalSizes = staticCompositionLocalOf { Sizes() }