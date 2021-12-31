plugins {
    id (BuildPlugins.androidApplication)
    kotlin (BuildPlugins.kotlinAndroid)
    id (BuildPlugins.navigationSafeArgs)
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

    buildFeatures{
        viewBinding = true
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

    //Module Core
    implementation(project(BuildModules.CORE))
    //Module Commons
    implementation(project(BuildModules.COMMONS))

    //Retrofit
    implementation (Libraries.retrofit)
    implementation (Libraries.retrofitGson)
    implementation (Libraries.retrofitRx)
    implementation (Libraries.okHttpInteceptor)
    //RxAndroid
    implementation (Libraries.rxjava)
    implementation (Libraries.rxandroid)
    implementation (Libraries.rxkotlin)
    //LiveData
    implementation (Libraries.lifecycleLivedata)
    implementation (Libraries.lifeCycleExtensions)
    implementation (Libraries.fragmentKtx)
    //Fragment
    implementation (Libraries.fragmentVersion)
    //Koin
    implementation (Libraries.koinAndroidScopes)
    implementation (Libraries.koinAndroidViewModel)
    implementation (Libraries.koinFragment)
    implementation (Libraries.koinWorkmanager)
    //Navigation
    implementation (Libraries.navUi)
    implementation (Libraries.navFragment)
    //Picasso
    implementation (Libraries.picasso)
    //Paging
    implementation (Libraries.pagingRuntime)
    implementation (Libraries.pagingRx)

}



