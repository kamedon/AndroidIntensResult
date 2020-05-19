package com.kamedon.androidintensresult

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SelectPhotoFromFragmentActivity :
    AppCompatActivity(R.layout.activity_select_photo_from_fragment) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().replace(R.id.container, SelectPhotoFragment())
            .commit()
    }
}
