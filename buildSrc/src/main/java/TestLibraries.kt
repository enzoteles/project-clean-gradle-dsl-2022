object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val extJunit = "1.1.3"
        const val espresso = "3.4.0"

        const val androidXTest = "1.3.0"
        const val androidArchTesting = "2.0.0"
        const val koin = "2.0.1"
        const val kotlinCorotines = "1.3.2"
        const val room = "2.2.3"
        const val hamcrestVersion = "1.3"
        const val mockitoKotlinVersion = "2.2.0"
        const val mockitoCoreVersion = "3.0.0"
    }
    const val junit4                    = "junit:junit:${Versions.junit4}"
    const val extJunit                  = "androidx.test.ext:${Versions.extJunit}"

    const val mockito                   = "org.mockito:mockito-core:${Versions.mockitoCoreVersion}"
    const val mockitoKotlin             = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlinVersion}"
    const val hamcrest                  = "org.hamcrest:hamcrest-all:${Versions.hamcrestVersion}"
    const val testCore                  = "androidx.test:core:${Versions.androidXTest}"

    const val testRunner                = "androidx.test:runner:${Versions.androidXTest}"
    const val testInstrumentationRunner = "br.com.rrodovalho.marvelapp.util.runner.KoinTestRunner"
    const val espresso                  = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val archCoreTesting           = "androidx.arch.core:core-testing:${Versions.androidArchTesting}"
    const val koin                      = "org.koin:koin:${Versions.koin}"
    const val kotlinCoroutines          = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCorotines}"
    const val room                      = "androidx.room:room-testing:${Versions.room}"
}
