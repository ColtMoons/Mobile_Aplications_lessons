package com.example.appgeoquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PlayAgain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_again)

        setResult()
    }

    private fun setResult(){
        val tvScore = findViewById<TextView>(R.id.tvScore)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        tvResult.text = intent.getStringExtra("text")
        val btAgain = findViewById<Button>(R.id.btPlayAgain)

        btAgain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}