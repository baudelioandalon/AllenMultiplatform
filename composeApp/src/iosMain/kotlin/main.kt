import androidx.compose.ui.window.ComposeUIViewController
import com.borealnetwork.allen.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
