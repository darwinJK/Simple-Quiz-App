package com.example.myquizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getName = findViewById<EditText>(R.id.nameTxt)

        val startBtn :Button=findViewById(R.id.startBtn)
        startBtn.setOnClickListener {

            if(getName.text.isEmpty()) {
                Toast.makeText(this,"please, enter your name",Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this,QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME,getName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}