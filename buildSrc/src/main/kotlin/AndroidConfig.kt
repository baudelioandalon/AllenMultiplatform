import java.text.SimpleDateFormat
import java.util.*

object AndroidConfig {
    const val minSdk = 24
    const val targetSdk = 34
    const val compileSdk = 34
    const val namespace = "com.borealnetwork.allen"
    const val applicationId = "com.borealnetwork.allenEcommerce"
    const val versionCode = 1
    val versionName = "1.0.0-${SimpleDateFormat("ddMMyyyyHHmmss", Locale.US).format(Date())}-beta"
}