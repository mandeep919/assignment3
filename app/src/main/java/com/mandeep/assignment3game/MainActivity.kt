package com.mandeep.assignment3game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var btnGame1: Button
    private lateinit var btnGame2: Button
    private lateinit var tvResultText: TextView
    private lateinit var tvResult: TextView
    private lateinit var tvCorrectText: TextView
    private lateinit var tvCorrect: TextView
    private lateinit var tvIncorrectText: TextView
    private lateinit var tvIncorrect: TextView
    private lateinit var btnRestart: Button


    private var rnd1 : Int = 0 // generated random from 1 to 100 included
    private var rnd2 : Int = 0
    private var counter : Int = 0
    private var count : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGame1 = findViewById(R.id.btnGame1)
        btnGame2 = findViewById(R.id.btnGame2)
        tvResult = findViewById(R.id.tvResultLbl)
        tvResultText = findViewById(R.id.tvResultText)
        tvCorrect = findViewById(R.id.tvCorrectLbl)
        tvCorrectText = findViewById(R.id.tvCorrectText)
        tvIncorrect = findViewById(R.id.tvIncorrectLbl)
        tvIncorrectText = findViewById(R.id.tvIncorrectText)
        btnRestart = findViewById(R.id.btnRestart)

        valueInitialize()

        btnRestart.setOnClickListener{
            resetAll()
        }
    }

    private fun resetAll(){
        count = 0
        counter = 0
        btnGame1.isEnabled = true
        btnGame2.isEnabled = true
        tvResult.visibility = View.GONE
        tvResultText.visibility = View.GONE
        tvCorrect.visibility = View.GONE
        tvCorrectText.visibility = View.GONE
        tvIncorrect.visibility = View.GONE
        tvIncorrectText.visibility = View.GONE
        btnRestart.visibility = View.GONE
        valueInitialize()

    }

    private fun valueInitialize(){
        counter++
        for (i in counter..11) {
            rnd1 = (0..100).random() // generated random from 1 to 100 included
            rnd2 = (0..100).random()
            if (rnd1 != rnd2) {
                btnGame1.text = rnd1.toString()
                btnGame2.text = rnd2.toString()
            }
        }
        if (counter==11) {
            btnGame1.isEnabled = false
            btnGame2.isEnabled = false
            tvResult.visibility = View.VISIBLE
            tvResultText.visibility = View.VISIBLE
            tvCorrect.visibility = View.VISIBLE
            tvCorrectText.visibility = View.VISIBLE
            tvIncorrect.visibility = View.VISIBLE
            tvIncorrectText.visibility = View.VISIBLE
            btnRestart.visibility = View.VISIBLE
            val correct = tvCorrect.text.toString().toInt()
            val incorrect = tvIncorrect.text.toString().toInt()
            when {
                correct > incorrect -> {
                    tvResult.text = "Won"
                }
                correct == incorrect -> {
                    tvResult.text = "Draw"
                }
                else -> {
                    tvResult.text = "Lost"
                }
            }
        }
    }

    fun clickableBtn1(view: View) {
        val first = btnGame1.text.toString().toInt()
        val second = btnGame2.text.toString().toInt()
        if(first>second){
            count++
        }
        valueInitialize()
        tvCorrect.text = count.toString()
        val incorrect = 10-count
        tvIncorrect.text = incorrect.toString()
    }

    fun clickableBtn2(view: View) {
        val first = btnGame1.text.toString().toInt()
        val second = btnGame2.text.toString().toInt()
        if(second>first){
            count++
        }
        valueInitialize()
        tvCorrect.text = count.toString()
        val incorrect = 10-count
        tvIncorrect.text = incorrect.toString()
    }
}