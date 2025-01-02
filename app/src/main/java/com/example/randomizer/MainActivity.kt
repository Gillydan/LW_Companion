package com.example.randomizer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

object GlobalData {
    val historyArray = Array<String?>(10){null}
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttonRand = findViewById<Button>(R.id.buttonRand)
        val buttonHistory = findViewById<Button>(R.id.buttonHistory)
        val textField = findViewById<TextView>(R.id.textField)

        var i = 0;


        buttonRand.setOnClickListener {
            var rand = Random.nextInt(10)
            GlobalData.historyArray[i] = rand.toString()
            textField.text = rand.toString()
        }

        buttonHistory.setOnClickListener{
            val intent = Intent(this, History::class.java)
            startActivity(intent)
        }



    }
}