plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "id.openai.belajarlitpers"
    compileSdk = 35

    defaultConfig {
        applicationId = "id.openai.belajarlitpers"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
}
