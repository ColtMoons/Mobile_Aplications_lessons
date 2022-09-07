package com.example.appgeoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var questions: ArrayList<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadQuestions()
        setupViews()
    }

    private fun loadQuestions(){
        questions = ArrayList()
        var question = Question("Es Lima la capital de Peru", true)
        questions.add(question)

        questions.add(Question("Es Lima la capital de Chile", false))
        questions.add(Question("Es Piura la capital de Chile", false))
        questions.add(Question("Es Brasil la capital de Chile", false))
        questions.add(Question("Es Bogota la capital de Colombia", true))
        questions.add(Question("Es Lima la capital de Argentina", false))
        questions.add(Question("Es Argentina la capital de Chile", false))


    }

    private fun setupViews(){
        val btYes = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)
        val btNext = findViewById<Button>(R.id.btNext)
        var counter = 0

        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)

        tvQuestion.text = questions[counter].sentence

        btYes.setOnClickListener {
            if(questions[counter].answer)
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
        }

        btNo.setOnClickListener {
            if(!questions[counter].answer)
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
        }

        btNext.setOnClickListener {
            counter++
            tvQuestion.text = questions[counter].sentence
        }
    }
}