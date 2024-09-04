package com.example.myquizapp

object Constants {

    const val USER_NAME : String ="name"
    const val TOTAL_QUESTION:String = "total_questions"
    const val CORRECT_ANSWER : String = " correct_answers"


    fun getQuestion():ArrayList<Question>{

        val questionsList = ArrayList<Question>()

        val q1 = Question(1,"Which country This flag belongs to ?",
            R.drawable.bhutan__flag,"Kyrgyzstan","Kenya","Afghanistan","Bhutan",4)
        questionsList.add(q1)

        val q2 = Question(2,"Which country This flag belongs to ?",
            R.drawable.combodia_flag,"GreenLand","Libya","Cambodia","Thailand",3)
        questionsList.add(q2)

        val q3 = Question(3,"Which country This flag belongs to ?",
            R.drawable.croatia__flag,"Croatia","Colombia","Uruguay","Netherlands",1)
        questionsList.add(q3)

        val q4 = Question(4,"Which country This flag belongs to ?",
            R.drawable.greenland_flag,"Greenland","Malaysia","Madagascar","Norway",1)
        questionsList.add(q4)

        val q5 = Question(5,"Which country This flag belongs to ?",
            R.drawable.kazakhstan_flag,"papa new Gua","Iran","Kazakhstan","Morocco",3)
        questionsList.add(q5)

        val q6 = Question(6,"Which country This flag belongs to ?",
            R.drawable.vathican_flag,"Luxembourg ","Vatican City","Armenia","Italy",2)
        questionsList.add(q6)

        val q7 = Question(7,"Which country This flag belongs to ?",
            R.drawable.mozambique_flag,"Uganda ","Mozambique","Kyrgyzstan","Bermuda",2)
        questionsList.add(q7)

        val q8 = Question(8,"Which country This flag belongs to ?",
            R.drawable.mauritius_flag,"Moldova","Malaysia","Myanmar","Mauritius",4)
        questionsList.add(q8)

        val q9 = Question(9,"Which country This flag belongs to ?",
            R.drawable.kenya,"Poland","Bangladesh","Nepal","Kenya",4)
        questionsList.add(q9)

        val q10 = Question(10,"Which country This flag belongs to ?",
            R.drawable.libiya_flag,"Libya","Russia","Turkey","Lebanon",1)
        questionsList.add(q10)

        return questionsList
    }
}