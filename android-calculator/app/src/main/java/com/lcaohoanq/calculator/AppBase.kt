package com.lcaohoanq.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class AppBase : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}