package com.example.appgeoquiz

import android.content.Intent
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

        val tvScore = findViewById<TextView>(R.id.tvScore)
        tvScore.text = "0 of "+ questions.size

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
        var counter = 0
        var score = 0


        val tvScore = findViewById<TextView>(R.id.tvScore)
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)

        tvQuestion.text = questions[counter].sentence

        btYes.setOnClickListener {
            if(counter < questions.size) {
                if(questions[counter].answer){
                    Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
                    tvScore.text = ""+ ++score + " of " + questions.size + ""
                }
                else
                    Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()

                counter++
                if(counter <= questions.size - 1)
                    tvQuestion.text = questions[counter].sentence
            }

            if(counter == questions.size){
                val intent = Intent(this, PlayAgain::class.java)
                intent.putExtra("text",tvScore.text.toString())
                startActivity(intent)
            }

        }

        btNo.setOnClickListener {
            if(counter < questions.size) {
                if(!questions[counter].answer){
                    Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
                    tvScore.text = ""+ ++score + " of " + questions.size
                }
                else
                    Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()

                counter++
                if(counter <= questions.size - 1)
                    tvQuestion.text = questions[counter].sentence
            }

            if(counter == questions.size){
                val intent = Intent(this, PlayAgain::class.java)
                intent.putExtra("text",tvScore.text.toString())
                startActivity(intent)
            }

        }



    }
}