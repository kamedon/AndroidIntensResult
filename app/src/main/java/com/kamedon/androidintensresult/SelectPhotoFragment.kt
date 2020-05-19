package com.kamedon.androidintensresult

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
import kotlinx.android.synthetic.main.fragment_select_photo.*

class SelectPhotoFragment : Fragment(R.layout.fragment_select_photo) {
    lateinit var observer: MyLifecycleObserver

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observer = MyLifecycleObserver(requireActivity().activityResultRegistry)
        lifecycle.addObserver(observer)
        selectBtn.setOnClickListener {
            observer.selectImage()
        }
    }
}

class MyLifecycleObserver(private val registry: ActivityResultRegistry) : DefaultLifecycleObserver {
    lateinit var getContent: ActivityResultLauncher<String>

    override fun onCreate(owner: LifecycleOwner) {
        getContent =
            registry.register(
                "key",
                owner,
                ActivityResultContracts.GetContent(),
                ActivityResultCallback {
                    Log.d("result", "fragment: $it")
                })
    }

    fun selectImage() {
        getContent("image/*")
    }
}