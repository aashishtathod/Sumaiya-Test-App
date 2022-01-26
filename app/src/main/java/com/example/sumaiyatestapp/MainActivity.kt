package com.example.sumaiyatestapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sumaiyatestapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.square.setOnClickListener{
            val intent = Intent(this ,ImageDetailsActivity::class.java)
            intent.putExtra("shape" ,1)
            startActivity(intent)
        }

        binding.circle.setOnClickListener{
            val intent = Intent(this ,ImageDetailsActivity::class.java)
            intent.putExtra("shape" ,2)
            startActivity(intent)
        }

        binding.rectangle.setOnClickListener{
            val intent = Intent(this ,ImageDetailsActivity::class.java)
            intent.putExtra("shape" ,3)
            startActivity(intent)
        }
        binding.cut.setOnClickListener{
            val intent = Intent(this ,ImageDetailsActivity::class.java)
            intent.putExtra("shape" ,4)
            startActivity(intent)
        }
    }
}