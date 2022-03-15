package com.emichaux.datadogcrashtest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.emichaux.datadogcrashtest.R

class Fragment2 : Fragment(R.layout.fragment_2) {

    private lateinit var testLateInitVar: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        printTestCrash(testLateInitVar)
    }

    private fun printTestCrash(testCrash: String) {
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            Fragment2()
    }
}