package io.github.ehsankolivand.kmpbase.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import io.github.ehsankolivand.kmpbase.App
import io.github.ehsankolivand.kmpbase.root.DefaultRootComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rootComponent = DefaultRootComponent(defaultComponentContext())
        setContent {
            App(rootComponent)
        }
    }
}