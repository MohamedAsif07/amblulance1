package com.hardware.amblulance1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.hardware.amblulance1.databinding.ActivityLogin1Binding

class Login1 : AppCompatActivity() {
    lateinit var mainBinding: ActivityLogin1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityLogin1Binding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainBinding.button.setOnClickListener {
            val intent = Intent(this@Login1, Final::class.java)
            startActivity(intent)
        }
        mainBinding.button2.setOnClickListener {
            val intent = Intent(this@Login1, Detial::class.java)
            startActivity(intent)
        }
    }
}