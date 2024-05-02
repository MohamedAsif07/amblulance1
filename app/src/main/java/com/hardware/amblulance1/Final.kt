package com.hardware.amblulance1
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class Final : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        val textView5: TextView = findViewById(R.id.textView5)

        // Generate a random number between 1000 and 9999
        val randomNumber = Random.nextInt(1000, 10000)

        // Set the random number to textView5
        textView5.text = randomNumber.toString()
    }
}
