package com.wen.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.wen.widgets.utils.WLogUtil
import com.wen.widgets.ui.LibMainActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        WLogUtil.i("====")

        findViewById<Button>(R.id.btn).setOnClickListener {
            startActivity(Intent(this,LibMainActivity::class.java))
        }
    }
}