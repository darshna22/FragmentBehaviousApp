package com.my.fragmentbehaviousapp.resultapifragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

// Fragment that hosts the Compose UI
class SenderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Use ComposeView in the Fragment
        return ComposeView(requireContext()).apply {
            setContent {
                ParentComposable()
            }
        }
    }

    @Composable
    fun ParentComposable() {
        InputFieldScreen { message ->
            println("darshna ${message}")
            val resultBundle = Bundle().apply {
                putString("key_data", message)
            }
            parentFragmentManager.setFragmentResult(
                "requestKey",
                resultBundle
            )// Handle the callback here (e.g., update state, log, or navigate)
        }
    }
}
