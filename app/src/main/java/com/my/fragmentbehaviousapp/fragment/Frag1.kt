package com.my.fragmentbehaviousapp.fragment

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.my.fragmentbehaviousapp.R

class Frag1 : Fragment() {

    private val TAG: String = "Darshna "
    private lateinit var myShareInterface: MyShareInterface

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            myShareInterface = activity as MyShareInterface
        } catch (e: ClassCastException) {
            throw ClassCastException("Error in retrieving data. Please try again")
        }
        Log.i(TAG, "fag2 onAttach: ")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "fag2 onCreate: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(TAG, "fag2 onCreateView: ")
        return inflater.inflate(R.layout.layout_frag1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(TAG, "fag2 onViewCreated: ")
        initView(view);
    }

    private fun initView(view: View) {
        val editText = view.findViewById<EditText>(R.id.editText)
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val msg = s.toString()
                //setData to interface
                myShareInterface.sendData(msg)
            }
        })
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.i(TAG, "fag2 onViewStateRestored: ")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "fag2 onStart: ")
    }


    override fun onResume() {
        super.onResume()
        Log.i(TAG, "fag2 onResume: ")
    }


    override fun onPause() {
        super.onPause()
        Log.i(TAG, "fag2 onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "fag2 onStop: ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "fag2 onSaveInstanceState: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "fag2 onDestroy: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(TAG, "fag2 onDestroyView: ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i(TAG, "fag2 onDetach: ")
    }


    interface MyShareInterface {
        fun sendData(msg: String)
    }

}

