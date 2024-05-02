package com.hardware.amblulance1


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import com.airbnb.lottie.LottieAnimationView

import com.hardware.amblulance1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainBinding.signupmain.setOnClickListener {
            val intent = Intent(this@MainActivity, SignUpActivity::class.java)
            startActivity(intent)
        }

        mainBinding.loginmain.setOnClickListener {
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }
        mainBinding.lottie1.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
        }





        var lottin = findViewById<LottieAnimationView?>(R.id.lottie1)



        Handler().postDelayed({
            val i = Intent(
                applicationContext,
                MainActivity::class.java
            )
            startActivity(i)
        }, 3000000)

    }

}




