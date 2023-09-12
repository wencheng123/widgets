package com.wen.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wen.widgets.utils.WLogUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        WLogUtil.i("====")
    }
}