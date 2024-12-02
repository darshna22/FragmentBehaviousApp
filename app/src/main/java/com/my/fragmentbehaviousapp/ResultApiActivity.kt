package com.my.fragmentbehaviousapp

import android.os.Bundle
import android.view.View
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.compose.ui.viewinterop.AndroidView
import android.widget.FrameLayout
import androidx.compose.material3.Text
import com.my.fragmentbehaviousapp.resultapifragment.ReceiverFragment
import com.my.fragmentbehaviousapp.resultapifragment.SenderFragment

class ResultApiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                FragmentInCompose()
            }
        }
    }

    @Composable
    fun FragmentInCompose() {
        val activity = LocalContext.current as AppCompatActivity

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Embed Top Fragment
            FragmentContainerView(
                fragmentManager = activity.supportFragmentManager,
                fragment = SenderFragment(),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )

            // Embed Bottom Fragment
            FragmentContainerView(
                fragmentManager = activity.supportFragmentManager,
                fragment = ReceiverFragment(),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
        }
    }
}

@Composable
fun FragmentContainerView(
    fragmentManager: FragmentManager,
    fragment: Fragment,
    modifier: Modifier = Modifier
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            FrameLayout(context).apply {
                id = View.generateViewId()
                fragmentManager.commit {
                    replace(this@apply.id, fragment)
                }
            }
        }
    )
}
