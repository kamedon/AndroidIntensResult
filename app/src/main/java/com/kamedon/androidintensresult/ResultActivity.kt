package com.kamedon.androidintensresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity(R.layout.activity_result) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resultBtn.setOnClickListener {
            val intent = Intent()
            intent.putExtra("result", "Hello")
            setResult(Activity.RESULT_OK, intent)
            finish();
        }
    }
}
