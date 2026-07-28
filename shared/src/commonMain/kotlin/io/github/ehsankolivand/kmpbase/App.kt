package io.github.ehsankolivand.kmpbase

import androidx.compose.runtime.Composable
import io.github.ehsankolivand.kmpbase.core.designsystem.theme.AppTheme
import io.github.ehsankolivand.kmpbase.root.RootComponent
import io.github.ehsankolivand.kmpbase.root.RootContent

@Composable
fun App(rootComponent: RootComponent) {
    AppTheme {
        RootContent(rootComponent)
    }
}