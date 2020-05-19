package com.kamedon.androidintensresult

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        selectPhotoBtn.setOnClickListener {
            startActivity(Intent(this, SelectPhotoActivity::class.java))
        }

        selectPhotoFragmentBtn.setOnClickListener {
            startActivity(Intent(this, SelectPhotoFromFragmentActivity::class.java))
        }

        customBtn.setOnClickListener {
            startActivity(Intent(this, CustomActivity::class.java))
        }

        customFromFragmentBtn.setOnClickListener {
            startActivity(Intent(this, CustomFromFragmentActivity::class.java))
        }
    }


}
