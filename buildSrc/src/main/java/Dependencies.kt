object Dependencies {
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.appcompat}" }
    val material by lazy {"com.google.android.material:material:${Versions.material}"}
    val activity by lazy { "androidx.activity:activity:${Versions.activity}" }
    val constraintlayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}" }
    val junit by lazy {"junit:junit:${Versions.junit}"}
    val test by lazy { "androidx.test.ext:junit:${Versions.junitest}" }
    val core by lazy { "androidx.test.espresso:espresso-core:${Versions.core}" }

    val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltCompiler by lazy { "com.google.dagger:hilt-compiler:${Versions.hilt}" }


    //Retrofit
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val okhttp by lazy { "com.squareup.okhttp3:okhttp:${Versions.okhttp}" }
    val gsonConverter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}" }
    val moshi by lazy { "com.squareup.moshi:moshi-kotlin:${Versions.moshi}" }
    val moshiConverter by lazy { "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}" }
    val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}" }

    //Coroutines
    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}" }
    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}" }

    //splash screen dependency
    val splashScreen by lazy {"androidx.core:core-splashscreen:${Versions.splashScreen}"}

    //coil library to show image
    val coil by lazy { "io.coil-kt:coil-compose:${Versions.coil}" }

    //Recycler view
    val recyclerView by lazy { "androidx.recyclerview:recyclerview:${Versions.recyclerView}" }

    //Picasso library
    val picasso by lazy { "com.squareup.picasso:picasso:${Versions.picasso}" }
}