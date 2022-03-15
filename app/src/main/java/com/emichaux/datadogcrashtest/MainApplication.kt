package com.emichaux.datadogcrashtest

import android.app.Application

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startDataDog()
    }

    private fun startDataDog() {
        DataDogLogger.startDataDog(
            this
        )
    }
}