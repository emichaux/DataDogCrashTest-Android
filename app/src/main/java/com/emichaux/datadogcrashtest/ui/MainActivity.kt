package com.emichaux.datadogcrashtest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.datadog.android.rum.GlobalRum
import com.emichaux.datadogcrashtest.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalRum.get().startResource("testKey", "GET", "http://www.example.com")
        MainActivity2.start(this, true)
    }
}