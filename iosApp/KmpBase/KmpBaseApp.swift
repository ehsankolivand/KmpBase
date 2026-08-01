import SwiftUI
import Shared

@main
struct KmpBaseApp: App {
    let root: RootComponent

    init() {
        MainViewControllerKt.startApp()
        root = MainViewControllerKt.createRootComponent()
    }

    var body: some Scene {
        WindowGroup {
            ContentView(root: root)
        }
    }
}
