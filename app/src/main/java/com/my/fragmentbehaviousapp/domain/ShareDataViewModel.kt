package com.my.fragmentbehaviousapp.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareDataViewModel : ViewModel() {
    private var msg: MutableLiveData<String> = MutableLiveData()
    val _msg: LiveData<String>
        get() = msg

    fun sendData(mMsg: String) {
        msg.value = mMsg
    }
}