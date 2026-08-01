import SwiftUI
import UIKit
import Shared

struct ContentView: UIViewControllerRepresentable {
    let root: RootComponent

    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.mainViewController(root: root)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
