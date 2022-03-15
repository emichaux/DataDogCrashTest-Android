package com.emichaux.datadogcrashtest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.emichaux.datadogcrashtest.R

class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            replaceFragment()
        }
    }

    private fun replaceFragment() {
        val testFragment: Fragment = Fragment2.newInstance()
        val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(
            R.id.container_fragment,
            testFragment,
            testFragment.javaClass.simpleName
        )
        fragmentTransaction.addToBackStack(testFragment.javaClass.simpleName)
        fragmentTransaction.commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            Fragment1()
    }
}