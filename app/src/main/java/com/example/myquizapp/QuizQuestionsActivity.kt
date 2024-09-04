package com.example.myquizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(),View.OnClickListener {

    var mQuestionList : ArrayList<Question>? =null
    var mCurrentPosition : Int = 1
    var selectedPosition : Int = 0

    private var mUserName : String? = null
    private var mCorrectAnswers : Int = 0
    

    private var questionTxt : TextView? = null
    private var imageview : ImageView? = null
    private var progressBar : ProgressBar? = null
    private var progressTxt : TextView? = null
    private var option1 : TextView? = null
    private var option2 : TextView? = null
    private var option3 : TextView? = null
    private var option4 : TextView? = null
    private var submitBtn : Button? = null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)


        questionTxt=findViewById(R.id.questionTxt)
        imageview=findViewById(R.id.imageView)
        progressBar =findViewById(R.id.progressBar)
        progressTxt=findViewById(R.id.progressTxt)
        option1=findViewById(R.id.option1txt)
        option2=findViewById(R.id.option2txt)
        option3=findViewById(R.id.option3txt)
        option4=findViewById(R.id.option4txt)
        submitBtn=findViewById(R.id.submitBtn)

        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        submitBtn?.setOnClickListener(this)

        mQuestionList = Constants.getQuestion()

       setQuestions()

    }
    private fun setQuestions(){
        defaultOptionText()

        val questions = mQuestionList!![mCurrentPosition-1]

        questionTxt?.text=questions.question
        imageview?.setImageResource(questions.image)
        progressBar?.progress = mCurrentPosition
        progressTxt?.text= "$mCurrentPosition/${progressBar?.max}"

        option1?.text = questions.option1
        option2?.text = questions.option2
        option3?.text = questions.option3
        option4?.text=questions.option4

        if(mCurrentPosition==mQuestionList!!.size)
            submitBtn?.text = "FINISH"
        else
            submitBtn?.text="SUBMIT"
    }


    private fun defaultOptionText(){
        val options = ArrayList<TextView>()
        option1?.let {
            options.add(0,it)
        }
        option2?.let {
            options.add(1,it)
        }
        option3?.let {
            options.add(2,it)
        }
        option4?.let {
            options.add(3,it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#D3D3D3"))
            option.typeface= Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,R.drawable.default_option_border_bg)
        }
    }


    private fun SelectedOptionText(tv: TextView, selectedOptionNum:Int){
        defaultOptionText()

        selectedPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,R.drawable.selected_option_drawable_bg)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option1txt->{
                option1?.let {
                    SelectedOptionText(it,1)
                }
            }
            R.id.option2txt->{
                option2?.let {
                    SelectedOptionText(it,2)
                }
            }
            R.id.option3txt->{
                option3?.let {
                    SelectedOptionText(it,3)
                }
            }
            R.id.option4txt->{
                option4?.let {
                    SelectedOptionText(it,4)
                }
            }

            R.id.submitBtn->{
                if(selectedPosition==0){
                    mCurrentPosition++
                    when {
                        mCurrentPosition<=mQuestionList!!.size -> setQuestions()

                        else-> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWER,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTION, mQuestionList?.size)
                            startActivity(intent)
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition-1)

                    if (question!!.correctAnswer!=selectedPosition)
                        correctOption(selectedPosition,R.drawable.wrong_option_bg)
                    else
                        mCorrectAnswers++

                    correctOption(question.correctAnswer,R.drawable.correct_option_bg)

                    if(mCurrentPosition==mQuestionList!!.size)
                        submitBtn?.text = "FINISH"
                    else
                        submitBtn?.text="NEXT"

                    selectedPosition=0
                }
            }
        }
    }
    private fun correctOption(answer:Int,drawableView :Int){

        when(answer){
            1 -> {
                option1?.background=ContextCompat.getDrawable(this,drawableView)
            }
            2 -> {
                option2?.background=ContextCompat.getDrawable(this,drawableView)
            }
            3 -> {
                option3?.background=ContextCompat.getDrawable(this,drawableView)
            }
            4 -> {
                option4?.background=ContextCompat.getDrawable(this,drawableView)
            }
        }
    }
}