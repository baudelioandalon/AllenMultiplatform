plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.android.application)
    alias(libs.plugins.buildConfig)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.sqlDelight)
    alias(libs.plugins.apollo)
    alias(libs.plugins.google.services)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        all {
            languageSettings {
                optIn("org.jetbrains.compose.resources.ExperimentalResourceApi")
            }
        }
        commonMain.dependencies {

            implementation(compose.runtime)
            implementation(compose.material3)
            implementation(compose.material)
            implementation(compose.materialIconsExtended)
            @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
            implementation(libs.composeImageLoader)
            implementation(libs.kotlinx.coroutines.core)
            api(libs.moko.core)
            api(libs.moko.mvvm)
            implementation(libs.ktor.core)
            implementation(libs.ktor.negotiation)
            implementation(libs.ktor.serialization)
            implementation(libs.composeIcons.featherIcons)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kotlinx.datetime)
            implementation(libs.multiplatformSettings)
            implementation(libs.kstore)
            implementation(libs.apollo.runtime)
            implementation(libs.kamel.image)
            api(compose.foundation)
            api(compose.animation)
            implementation(libs.compottie)
//...
//            implementation(libs.voyager.navigator)

            //Koin
            implementation(libs.koin.core)
            implementation(libs.koin.compose)

            api(libs.precompose)

            //Firebase
            implementation(libs.firebase.auth)
            implementation(libs.gitlive.firebase.firestore) // This line
            implementation(libs.gitlive.firebase.common)// This line

// api("moe.tlaster:precompose-molecule:$precompose_version") // For Molecule intergration

// api("moe.tlaster:precompose-viewmodel:$precompose_version") // For ViewModel intergration

// api("moe.tlaster:precompose-koin:$precompose_version")
            implementation(project(":shared"))
            implementation(project(":allenSharedUI"))
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        androidMain.dependencies {
            implementation(libs.androidx.appcompat)
            implementation(libs.androidx.activityCompose)
            implementation(libs.compose.uitooling)
            implementation(libs.kotlinx.coroutines.android)
            implementation(libs.ktor.client.okhttp)
            implementation(libs.sqlDelight.driver.android)
            implementation(libs.koin.core)
            implementation(libs.koin.android)
            //firebase
            implementation(libs.firebase.common.ktx)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
            implementation(libs.sqlDelight.driver.native)
        }


    }
}


android {


    namespace = AndroidConfig.namespace
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk

        applicationId = AndroidConfig.applicationId
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName
    }
    sourceSets["main"].apply {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
        res.srcDirs("src/androidMain/res", "src/commonMain/resources")
        resources.srcDir("src/commonMain/resources")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
}

buildConfig {
    // BuildConfig configuration here.
    // https://github.com/gmazzo/gradle-buildconfig-plugin#usage-in-kts
    packageName(AndroidConfig.namespace)
    buildConfigField("String", "versionName", "\"${AndroidConfig.versionName}\"")
    buildConfigField("String", "versionCode", "\"${AndroidConfig.versionCode}\"")
    buildConfigField("String", "currency", "\"MXN\"")
}

sqldelight {
    databases {
        create("allenDatabase") {
            // Database configuration here.
            // https://cashapp.github.io/sqldelight
            packageName.set("com.borealnetwork.allen.db")
        }
    }
}

apollo {
    service("api") {
        // GraphQL configuration here.
        // https://www.apollographql.com/docs/kotlin/advanced/plugin-configuration/
        packageName.set("com.borealnetwork.allen.graphql")
    }
}
