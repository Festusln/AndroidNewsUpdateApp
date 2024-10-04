package com.example.newsupdate

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsUpdateApplication : Application() {

    init {
        Log.d(TAG, "App entry point...")
    }
    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        const val TAG = "NewsUpdateApplication"
    }

}