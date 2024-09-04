package com.example.myquizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val nameBtn = findViewById<TextView>(R.id.nameText)
        val scoreBtn = findViewById<TextView>(R.id.scoreText)
        var finishBtn = findViewById<Button>(R.id.finishBtn)

        val correctScore = intent.getIntExtra(Constants.CORRECT_ANSWER,0)
        val totalQuestion = intent.getIntExtra(Constants.TOTAL_QUESTION,0)

        nameBtn?.text = intent.getStringExtra(Constants.USER_NAME)
        scoreBtn?.text= "Your score is $correctScore out of $totalQuestion"

        finishBtn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }





    }
}