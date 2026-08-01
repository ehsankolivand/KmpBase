package io.github.ehsankolivand.kmpbase

import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.ApplicationLifecycle
import io.github.ehsankolivand.kmpbase.di.initKoin
import io.github.ehsankolivand.kmpbase.root.DefaultRootComponent
import io.github.ehsankolivand.kmpbase.root.RootComponent
import platform.UIKit.UIViewController

fun startApp() {
    initKoin()
}

fun createRootComponent(): RootComponent =
    DefaultRootComponent(DefaultComponentContext(ApplicationLifecycle()))

fun mainViewController(root: RootComponent): UIViewController =
    ComposeUIViewController { App(root) }