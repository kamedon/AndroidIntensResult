package com.kamedon.androidintensresult

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.invoke
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_select_photo.*

class SelectPhotoActivity : AppCompatActivity(R.layout.activity_select_photo) {

    val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        Log.d("result", "activity: $uri")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectBtn.setOnClickListener {
            getContent("image/*")
        }
    }

}
