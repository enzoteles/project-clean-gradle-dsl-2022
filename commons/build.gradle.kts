plugins {
    id (BuildPlugins.androidLibrary)
    kotlin (BuildPlugins.kotlinAndroid)
}

android {

    compileSdk = AndroidSdk.compileSdk

    defaultConfig {
        minSdk = AndroidSdk.minSdk
        targetSdk = AndroidSdk.targetSdk
        version = Application.applicationVersionCode

        testInstrumentationRunner = (AndroidSdk.testInstrumentationRunner)
        consumerProguardFiles(AndroidSdk.consumerProguardFiles)
    }

    buildFeatures{
        viewBinding = true
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

    testImplementation (TestLibraries.junit4)
    testImplementation (TestLibraries.extJunit)
    testImplementation (TestLibraries.espresso)

    //Picasso
    implementation (Libraries.picasso)
    //Retrofit
    implementation (Libraries.retrofit)
    implementation (Libraries.retrofitGson)
    implementation (Libraries.retrofitRx)
}