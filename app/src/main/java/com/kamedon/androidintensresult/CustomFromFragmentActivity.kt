package com.kamedon.androidintensresult

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CustomFromFragmentActivity : AppCompatActivity(R.layout.activity_custom_from_fragment) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().replace(R.id.container, CustomFragment()).commit()
    }
}
