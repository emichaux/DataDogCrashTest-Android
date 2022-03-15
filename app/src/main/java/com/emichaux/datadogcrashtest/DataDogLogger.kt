package com.emichaux.datadogcrashtest

import android.content.Context
import android.util.Log
import com.datadog.android.Datadog
import com.datadog.android.core.configuration.Configuration
import com.datadog.android.core.configuration.Credentials
import com.datadog.android.privacy.TrackingConsent
import com.datadog.android.rum.GlobalRum
import com.datadog.android.rum.RumMonitor
import com.datadog.android.rum.tracking.MixedViewTrackingStrategy

object DataDogLogger {

    private const val stagingApplicationId = ""
    private const val stagingClientToken = ""

    fun startDataDog(applicationContext: Context) {
        val configuration: Configuration = Configuration.Builder(
            logsEnabled = true,
            tracesEnabled = true,
            crashReportsEnabled = true,
            rumEnabled = true
        )
            .trackInteractions()
            .trackLongTasks()
            .useViewTrackingStrategy(MixedViewTrackingStrategy(false))
            .trackBackgroundRumEvents(true)
            .build()
        val credentials =
            Credentials(
                stagingClientToken,
                "staging",
                "internal",
                stagingApplicationId,
                "android-app"
            )
        Datadog.initialize(applicationContext, credentials, configuration, TrackingConsent.GRANTED)
        Datadog.setVerbosity(Log.VERBOSE)

        val monitor: RumMonitor = RumMonitor.Builder().build()
        GlobalRum.registerIfAbsent(monitor)
    }
}