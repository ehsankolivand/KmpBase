package io.github.ehsankolivand.kmpbase

import androidx.compose.runtime.Composable
import io.github.ehsankolivand.kmpbase.core.designsystem.theme.CatalogTheme
import io.github.ehsankolivand.kmpbase.root.RootComponent
import io.github.ehsankolivand.kmpbase.root.RootContent

@Composable
fun App(rootComponent: RootComponent) {
    CatalogTheme {
        RootContent(rootComponent)
    }
}