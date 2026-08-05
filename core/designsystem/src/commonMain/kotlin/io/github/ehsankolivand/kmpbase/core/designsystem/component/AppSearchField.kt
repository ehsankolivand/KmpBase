package io.github.ehsankolivand.kmpbase.core.designsystem.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import io.github.ehsankolivand.kmpbase.core.designsystem.theme.AppTheme

@Composable
fun CatalogSearchField(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Search products",
    enabled: Boolean = true,
    isError: Boolean = false,
    onSearch: (String) -> Unit = {},
    onClear: () -> Unit = { onQueryChange("") },
    searchIconContentDescription: String? = null,
    clearContentDescription: String = "Clear search query",
) {
    val focusManager = LocalFocusManager.current

    TextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = AppTheme.sizes.searchFieldHeight),
        enabled = enabled,
        isError = isError,
        singleLine = true,
        shape = CircleShape,
        textStyle = AppTheme.typography.bodyLarge,
        placeholder = {
            Text(text = placeholder, style = AppTheme.typography.bodyLarge)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = searchIconContentDescription,
            )
        },
        trailingIcon = {
            AnimatedVisibility(
                visible = query.isNotEmpty(),
                enter = fadeIn(spring()) + scaleIn(spring(), initialScale = 0.8f),
                exit = fadeOut(spring()) + scaleOut(spring(), targetScale = 0.8f),
            ) {
                IconButton(onClick = onClear, enabled = enabled) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = clearContentDescription,
                    )
                }
            }
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearch(query)
                focusManager.clearFocus()
            },
        ),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = AppTheme.colors.surfaceContainerHigh,
            unfocusedContainerColor = AppTheme.colors.surfaceContainerHigh,
            errorContainerColor = AppTheme.colors.surfaceContainerHigh,
            disabledContainerColor = AppTheme.colors.onSurface.copy(alpha = 0.12f),
            focusedTextColor = AppTheme.colors.onSurface,
            unfocusedTextColor = AppTheme.colors.onSurface,
            errorTextColor = AppTheme.colors.onSurface,
            disabledTextColor = AppTheme.colors.onSurface.copy(alpha = 0.38f),
            focusedPlaceholderColor = AppTheme.colors.onSurfaceVariant,
            unfocusedPlaceholderColor = AppTheme.colors.onSurfaceVariant,
            errorPlaceholderColor = AppTheme.colors.onSurfaceVariant,
            disabledPlaceholderColor = AppTheme.colors.onSurface.copy(alpha = 0.38f),
            focusedLeadingIconColor = AppTheme.colors.onSurfaceVariant,
            unfocusedLeadingIconColor = AppTheme.colors.onSurfaceVariant,
            errorLeadingIconColor = AppTheme.colors.onSurfaceVariant,
            disabledLeadingIconColor = AppTheme.colors.onSurface.copy(alpha = 0.38f),
            focusedTrailingIconColor = AppTheme.colors.onSurfaceVariant,
            unfocusedTrailingIconColor = AppTheme.colors.onSurfaceVariant,
            errorTrailingIconColor = AppTheme.colors.error,
            disabledTrailingIconColor = AppTheme.colors.onSurface.copy(alpha = 0.38f),
            cursorColor = AppTheme.colors.primary,
            errorCursorColor = AppTheme.colors.error,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
        ),
    )
}