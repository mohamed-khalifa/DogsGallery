object Libs {
    // kotlin
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    // Android Jetpack (UI & navigation)
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}"
    const val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.viewModel}"
    const val navigationCore = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    //Network
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConvertor = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    // Coroutines
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    //Image Loading
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    //Shimmer Loading
    const val shimmerVeil = "com.github.skydoves:androidveil:${Versions.shimmerVeil}"

    //Dependency Injection
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    // Testing
    const val junit = "junit:junit:${Versions.junit}"
    const val mockK = "io.mockk:mockk:${Versions.mockK}"
    const val androidXTest = "androidx.test.ext:junit:${Versions.androidXTest}"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val archCoreTesting = "androidx.arch.core:core-testing:${Versions.archCoreTesting}"

}

