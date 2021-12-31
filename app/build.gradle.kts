plugins {
    id (BuildPlugins.androidApplication)
    kotlin (BuildPlugins.kotlinAndroid)
}

android {
    compileSdk = AndroidSdk.compileSdk

    defaultConfig {
        applicationId = (Application.applicationId)
        minSdk = AndroidSdk.minSdk
        targetSdk = AndroidSdk.targetSdk
        versionCode = (Application.applicationVersionCode)
        versionName =  (Application.applicationVersionName)

        testInstrumentationRunner = (AndroidSdk.testInstrumentationRunner)
    }

    buildTypes {
        getByName("release"){
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile(AndroidSdk.optimize), AndroidSdk.rules)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        this as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {

    implementation (Libraries.ktxCore)
    implementation (Libraries.appCompat)
    implementation (Libraries.googleMaterial)
    implementation (Libraries.constraintLayout)

    testImplementation (TestLibraries.junit4)
    testImplementation (TestLibraries.extJunit)
    testImplementation (TestLibraries.espresso)
}