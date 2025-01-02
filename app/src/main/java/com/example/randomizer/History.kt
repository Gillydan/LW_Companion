package com.example.randomizer

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class History : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_history)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val textView2 = findViewById<TextView>(R.id.textView2)
        setSupportActionBar(toolbar)



        supportActionBar?.apply {
            title = "Cronologia"
            setDisplayHomeAsUpEnabled(true)
        }

        val contenuto = GlobalData.historyArray[0]
        if(GlobalData.historyArray[0] == null){
            textView2.text = "Ancora nessun numero"
        }else{
            textView2.text = contenuto.toString()
        }

        //println("Il numero è $contenuto")

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish() // Chiudi l'attività corrente e torna indietro
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}