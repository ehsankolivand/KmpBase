package io.github.ehsankolivand.kmpbase.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation

@Composable
fun RootContent(component: RootComponent) {
    Children(
        stack = component.childStack,
        animation = stackAnimation(fade()),
    ) { child ->
        when (child.instance) {
            is PlaceholderRoot -> PlaceholderScreen()
            // gen:begin GEN:NAV_RENDER
            // gen:end GEN:NAV_RENDER
            else -> Unit
        }
    }
}

@Composable
private fun PlaceholderScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("KMPBase is running")
    }
}