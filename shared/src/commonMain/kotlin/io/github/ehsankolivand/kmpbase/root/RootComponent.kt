package io.github.ehsankolivand.kmpbase.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable

interface FeatureRoot

data object PlaceholderRoot : FeatureRoot

@Serializable
sealed interface RootConfig {
    @Serializable
    data object Placeholder : RootConfig
    // gen:begin GEN:NAV_CONFIG
    // gen:end GEN:NAV_CONFIG
}

interface RootComponent {
    val childStack: Value<ChildStack<*, FeatureRoot>>
}

class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<RootConfig>()

    override val childStack: Value<ChildStack<*, FeatureRoot>> =
        childStack(
            source = navigation,
            serializer = RootConfig.serializer(),
            initialConfiguration = RootConfig.Placeholder,
            handleBackButton = true,
            childFactory = ::createChild,
        )

    private fun createChild(
        config: RootConfig,
        componentContext: ComponentContext,
    ): FeatureRoot = when (config) {
        RootConfig.Placeholder -> PlaceholderRoot
        // gen:begin GEN:NAV_CHILD
        // gen:end GEN:NAV_CHILD
    }
}