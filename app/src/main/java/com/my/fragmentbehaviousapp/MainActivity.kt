package com.my.fragmentbehaviousapp

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.my.fragmentbehaviousapp.fragment.Frag1
import com.my.fragmentbehaviousapp.fragment.Frag2

class MainActivity : AppCompatActivity(), Frag1.MyShareInterface {
    var view1: View? = null
    var view2: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        initViews()
        addFragments()
    }

    private fun initViews() {
        view1 = findViewById<FrameLayout>(R.id.ll_top)
        view2 = findViewById<FrameLayout>(R.id.ll_bottom)
    }

    private fun addFragments() {

        //add frag1
        supportFragmentManager.apply {
            val transaction = this.beginTransaction()
            transaction.add(R.id.ll_top, Frag1(), "Frag1")
            transaction.commitAllowingStateLoss()
        }

        //add frag2
        supportFragmentManager.apply {
            val transaction = this.beginTransaction()
            transaction.add(R.id.ll_bottom, Frag2(), "Frag2")
            transaction.commitAllowingStateLoss()
        }

    }

    //This is frag1 class interface which is responsible to share data to frag2
    override fun sendData(msg: String) {
        //get fragment 2 instance to send value to same
        val frag2: Frag2 =
            supportFragmentManager.findFragmentByTag("Frag2") as Frag2
        frag2.displayReceiveData(msg)
    }
}