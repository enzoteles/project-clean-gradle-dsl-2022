object BuildPlugins {

    private object Versions {
        const val buildTools = "4.0.1"
        const val googleServicesVersion = "4.3.3"
        const val navigation = "2.1.0"
    }

    const val androidGradlePlugin       = "com.android.tools.build:gradle:${Versions.buildTools}"
    const val googleServicesGradlePlugin = "com.google.gms:google-services:${Versions.googleServicesVersion}"
    const val kotlinGradlePlugin        = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val navigationSafeArgsGradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    const val androidApplication        = "com.android.application"
    const val androidLibrary            = "com.android.library"
    const val kotlinLibrary             = "kotlin"
    const val kotlinAndroid             = "android"
    const val kotlinKapt                = "kotlin-kapt"
    const val navigationSafeArgs        = "androidx.navigation.safeargs.kotlin"
}