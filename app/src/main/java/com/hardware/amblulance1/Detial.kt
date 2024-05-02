package com.hardware.amblulance1




import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

import com.hardware.amblulance1.databinding.ActivityDetialBinding

class Detial : AppCompatActivity() {

    private lateinit var binding: ActivityDetialBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            val name = binding.txt1.text.toString()
            val mobilenumber = binding.txt2.text.toString()
            val aadharnumber = binding.txt3.text.toString()
            val age = binding.txt4.text.toString()
            val bd = binding.txt5.text.toString()
            val insid = binding.txt6.text.toString()
            val add = binding.txt7.text.toString()



            if (name.isNotEmpty() && aadharnumber.isNotEmpty() && mobilenumber.isNotEmpty() && add.isNotEmpty()&&age.isNotEmpty()&&bd.isNotEmpty()&&insid.isNotEmpty()&&add.isNotEmpty()) {

                database = FirebaseDatabase.getInstance().getReference("Users")
                val User = User(name, mobilenumber, aadharnumber, add,age,bd,insid)

                database.child(name).setValue(User).addOnSuccessListener {

                    binding.txt1.text?.clear()
                    binding.txt2.text?.clear()
                    binding.txt3.text?.clear()
                    binding.txt4.text?.clear()
                    binding.txt5.text?.clear()
                    binding.txt6.text?.clear()
                    binding.txt7.text?.clear()



                    Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show()
                    if (1 == 1) {

                        val gotobutton = findViewById<Button>(R.id.button)
                        gotobutton.setOnClickListener {

                            val intent1 = Intent(this, Final::class.java)
                            startActivity(intent1)
                        }
                    }


                }.addOnFailureListener {

                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()


                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }

        }

    }

    data class User(
        val agencyName: String? = null,
        val contactNo: String? = null,
        val userName: String? = null,
        val address: String,
        val id: Any,
        val ag: Any,
        val inu: Any
    )
}


