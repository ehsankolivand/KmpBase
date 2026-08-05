package io.github.ehsankolivand.kmpbase.core.designsystem.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.ehsankolivand.kmpbase.core.designsystem.theme.AppTheme

@Composable
fun CatalogSnackbarHost(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier,
) {
    SnackbarHost(
        hostState = hostState,
        modifier = modifier.padding(horizontal = AppTheme.spacing.screenHorizontal),
    ) { data ->
        Snackbar(
            snackbarData = data,
            shape = AppTheme.shapes.medium,
            containerColor = AppTheme.colors.inverseSurface,
            contentColor = AppTheme.colors.inverseOnSurface,
            actionColor = AppTheme.colors.inversePrimary,
            actionContentColor = AppTheme.colors.inversePrimary,
            dismissActionContentColor = AppTheme.colors.inverseOnSurface,
        )
    }
}