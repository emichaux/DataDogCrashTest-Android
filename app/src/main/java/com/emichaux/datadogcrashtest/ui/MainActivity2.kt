package com.emichaux.datadogcrashtest.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emichaux.datadogcrashtest.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        addFragment()
    }

    private fun addFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(
                R.id.container_fragment,
                Fragment1.newInstance()
            )
            .commit()
    }

    companion object {
        fun start(context: Context, shouldClearBackStack: Boolean = false) {
            val intent = Intent(context, MainActivity2::class.java).apply {
                if (shouldClearBackStack) {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                }
            }
            context.startActivity(intent)
        }

    }
}