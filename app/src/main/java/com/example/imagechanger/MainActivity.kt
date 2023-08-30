package com.example.imagechanger

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity


class MainActivity : ComponentActivity() {

    private var clicker = 0
    private var clicker2 = 0
    private val endResult = (3..6).random()
    private lateinit var imageViewer: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        imageViewer = findViewById(R.id.imageView)


        imageViewer.setOnClickListener {
            clicker++

            when (clicker) {
                1 -> Toast.makeText(this, "Keep going", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(this, "Don't Give up", Toast.LENGTH_SHORT).show()
                endResult -> {
                    switchToSecondActivity()
                }
            }
        }
    }

    private fun switchToSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}

    class SecondActivity : AppCompatActivity() {
        private lateinit var imageViewer2: ImageView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.second_activity)

            imageViewer2 = findViewById(R.id.imageView2)
            imageViewer2.setOnClickListener {
                switchToThirdActivity()
            }
        }
        private fun switchToThirdActivity(){
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }

    class ThirdActivity : AppCompatActivity() {
        private lateinit var imageViewer3: ImageView
        private lateinit var  arrow: ImageView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.third_activity)

            imageViewer3 = findViewById(R.id.imageView3)
            arrow = findViewById(R.id.imageView4)

            arrow.setOnClickListener {
                switchToMainActivity()
            }
        }
        private fun switchToMainActivity(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


