package com.kamedon.androidintensresult

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.invoke
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import kotlinx.android.synthetic.main.fragment_custom.*

class CustomFragment : Fragment(R.layout.fragment_custom) {

    private lateinit var observer: CustomLifecycleObserver

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observer = CustomLifecycleObserver(requireActivity().activityResultRegistry)
        lifecycle.addObserver(observer)
        startBtn.setOnClickListener {
            observer.start(requireContext())
        }
    }
}

class CustomLifecycleObserver(private val registry: ActivityResultRegistry) :
    DefaultLifecycleObserver {

    private lateinit var startForResult: ActivityResultLauncher<Intent>

    override fun onCreate(owner: LifecycleOwner) {
        startForResult =
            registry.register("key", owner, ActivityResultContracts.StartActivityForResult(),
                ActivityResultCallback {
                    Log.d("result", "fragment: ${it.data?.getStringExtra("result")}")
                })
    }

    fun start(context: Context) {
        startForResult(Intent(context, ResultActivity::class.java))
    }
}