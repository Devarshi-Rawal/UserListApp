package com.example.userlistapp.activities

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import com.example.userlistapp.R
import com.example.userlistapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    //binding variable created
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        customStatusBar()

    }

    private fun customStatusBar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val window: Window = window
            val decorView: View = window.decorView
            val wic = WindowInsetsControllerCompat(window, decorView)
            wic.isAppearanceLightStatusBars = true // true or false as desired.

            // And then you can set any background color to the status bar.
            window.statusBarColor = Color.WHITE
        } else{
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;//  set status text dark
            window.statusBarColor = ContextCompat.getColor(this,R.color.white);// set status background white
        }
    }
}