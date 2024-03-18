# Compose Multiplatform Application

## Before running!
 - check your system with [KDoctor](https://github.com/Kotlin/kdoctor)
 - install JDK 17 on your machine
 - add `local.properties` file to the project root and set a path to Android SDK there
 - https://medium.com/@carlosgub/how-to-implement-firebase-firestore-in-kotlin-multiplatform-mobile-with-compose-multiplatform-32b66cdba9f7
 - https://medium.com/@j.c.moreirapinto/simplifying-cross-platform-app-development-dependency-injection-with-koin-in-compose-multiplatform-f77595396fbc
 - https://github.com/alexzhirkevich/compottie

### Android
To run the application on android device/emulator:  
 - open project in Android Studio and run imported android run configuration

To build the application bundle:
 - run `./gradlew :composeApp:assembleDebug`
 - find `.apk` file in `composeApp/build/outputs/apk/debug/composeApp-debug.apk`

### iOS
To run the application on iPhone device/simulator:
 - Open `iosApp/iosApp.xcproject` in Xcode and run standard configuration
 - Or use [Kotlin Multiplatform Mobile plugin](https://plugins.jetbrains.com/plugin/14936-kotlin-multiplatform-mobile) for Android Studio

