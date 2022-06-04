package com.raman.createanduselib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raman.mylibrary.ScreenChanges

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // when Activity starts it reports in onCreate method that it has been accessed
        ScreenChanges.report(this)
    }
}