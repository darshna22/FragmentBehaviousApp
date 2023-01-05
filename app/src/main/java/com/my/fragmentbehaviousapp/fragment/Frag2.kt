package com.my.fragmentbehaviousapp.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.my.fragmentbehaviousapp.R

class Frag2 : Fragment() {

    private val TAG: String = "Darshna "
    private var textView: TextView? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i(TAG, "fag1 onAttach: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "fag1 onCreate: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(TAG, "fag1 onCreateView: ")
        return inflater.inflate(R.layout.layout_frag2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById<TextView>(R.id.receiveTxt)
        Log.i(TAG, "fag1 onViewCreated: ")

    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.i(TAG, "fag1 onViewStateRestored: ")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "fag1 onStart: ")
    }


    override fun onResume() {
        super.onResume()
        Log.i(TAG, "fag1 onResume: ")
    }


    override fun onPause() {
        super.onPause()
        Log.i(TAG, "fag1 onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "fag1 onStop: ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "fag1 onSaveInstanceState: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "fag1 onDestroy: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(TAG, "fag1 onDestroyView: ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i(TAG, "fag1 onDetach: ")
    }

    fun displayReceiveData(msg: String) {
        textView!!.text = msg
    }


}