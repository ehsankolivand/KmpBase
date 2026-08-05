package io.github.ehsankolivand.kmpbase.core.designsystem.gallery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.ehsankolivand.kmpbase.core.designsystem.component.CatalogCircularIndicator
import io.github.ehsankolivand.kmpbase.core.designsystem.component.CatalogEmptyState
import io.github.ehsankolivand.kmpbase.core.designsystem.component.CatalogErrorState
import io.github.ehsankolivand.kmpbase.core.designsystem.component.CatalogPrimaryButton
import io.github.ehsankolivand.kmpbase.core.designsystem.component.CatalogSearchField
import io.github.ehsankolivand.kmpbase.core.designsystem.component.PaginationFooter
import io.github.ehsankolivand.kmpbase.core.designsystem.component.ProductCard
import io.github.ehsankolivand.kmpbase.core.designsystem.component.ProductThumbnail
import io.github.ehsankolivand.kmpbase.core.designsystem.component.RefreshIndicatorSlot
import io.github.ehsankolivand.kmpbase.core.designsystem.component.ThumbnailStatus
import io.github.ehsankolivand.kmpbase.core.designsystem.theme.AppTheme

@Composable
fun ComponentGallery(modifier: Modifier = Modifier) {
    var query by remember { mutableStateOf("") }
    var refreshing by remember { mutableStateOf(true) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(AppTheme.colors.background),
        contentPadding = AppTheme.spacing.listContentPadding,
        verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.cardGap),
    ) {
        item { SectionTitle("Search field") }
        item {
            CatalogSearchField(query = query, onQueryChange = { query = it })
        }

        item { SectionTitle("Refresh bar") }
        item { RefreshIndicatorSlot(visible = refreshing) }
        item {
            CatalogPrimaryButton(
                text = if (refreshing) "Hide refresh bar" else "Show refresh bar",
                onClick = { refreshing = !refreshing },
            )
        }

        item { SectionTitle("Product cards") }
        item {
            ProductCard(
                title = "Essence Mascara Lash Princess",
                price = "$9.99",
                meta = "2.56 · beauty",
                contentDescription = "Essence Mascara Lash Princess, 9 dollars 99, rated 2.56, beauty",
                onClick = {},
                thumbnail = { ProductThumbnail(status = ThumbnailStatus.Loading) },
            )
        }
        item {
            ProductCard(
                title = "A product with a very long title that should wrap onto two lines and then stop",
                price = "$1,299.00",
                meta = "4.87 · laptops",
                contentDescription = "Long title product",
                onClick = {},
                thumbnail = { ProductThumbnail(status = ThumbnailStatus.Failure) },
            )
        }

        item { SectionTitle("Indicators") }
        item {
            Box(modifier = Modifier.fillMaxWidth().height(96.dp), contentAlignment = androidx.compose.ui.Alignment.Center) {
                CatalogCircularIndicator()
            }
        }
        item { PaginationFooter() }

        item { SectionTitle("Empty state") }
        item {
            Box(modifier = Modifier.fillMaxWidth().height(260.dp)) {
                CatalogEmptyState(
                    headline = "No products found",
                    supportingText = "Try a different search term.",
                )
            }
        }

        item { SectionTitle("Error state") }
        item {
            Box(modifier = Modifier.fillMaxWidth().height(320.dp)) {
                CatalogErrorState(
                    headline = "No internet connection",
                    supportingText = "Check your connection, then try again.",
                    onRetry = {},
                )
            }
        }
    }
}

@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        style = AppTheme.typography.titleLarge,
        color = AppTheme.colors.onSurfaceVariant,
        modifier = Modifier.padding(top = AppTheme.spacing.base),
    )
}