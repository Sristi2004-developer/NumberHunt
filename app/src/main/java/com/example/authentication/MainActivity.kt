package com.example.authentication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var randomNum=Random.nextInt(1,20)
    private var guess=""
    private lateinit var text1:TextView
    private var numTries=0
    private var maxTries=5
    private lateinit var triesTextView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)

        text1=findViewById(R.id.tvOperand1)
        triesTextView=findViewById(R.id .tvTry)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




            findViewById<Button>(R.id.button1)?.setOnClickListener() {
                guess+= "1"
                text1.text = guess
            }
            findViewById<Button>(R.id.button2)?.setOnClickListener() {
                guess+= "2"
                text1.text = guess
            }
            findViewById<Button>(R.id.button3)?.setOnClickListener() {
                guess+= "3"
                text1.text = guess
            }
            findViewById<Button>(R.id.button4)?.setOnClickListener() {
                guess+= "4"
                text1.text = guess
            }
            findViewById<Button>(R.id.button5)?.setOnClickListener() {
                guess+= "5"
                text1.text = guess
            }
            findViewById<Button>(R.id.button6)?.setOnClickListener() {
                guess+= "6"
                text1.text = guess
            }
            findViewById<Button>(R.id.button7)?.setOnClickListener() {
                guess+= "7"
                text1.text = guess
            }
            findViewById<Button>(R.id.button8)?.setOnClickListener() {
                guess+= "8"
                text1.text = guess
            }
            findViewById<Button>(R.id.button9)?.setOnClickListener() {
                guess+= "9"
                text1.text = guess
            }
        findViewById<Button>(R.id.button0)?.setOnClickListener() {
            guess+= "0"
            text1.text = guess
        }
        findViewById<Button>(R.id.buttonClc)?.setOnClickListener() {
            guess+= ""
            text1.text = ""
        }
        findViewById<Button>(R.id.btnCheck)?.setOnClickListener(){
            checkGuess()

        }



    }
    private fun checkGuess(){
        val userGuess = guess.toIntOrNull() ?: return
        numTries++
        if(numTries>=maxTries){
            showTryAgainDialog()
            resetGame()
            return
        }
        if (userGuess ==randomNum) {
            text1.text = "Correct!"
            randomNum = Random.nextInt(1, 20)
            numTries=0

            val builder=AlertDialog.Builder(this)
            builder.setTitle("Congratulations! You guessed it right")

            builder.setPositiveButton("Play Again"){
                dialog, _ -> dialog.dismiss()
            }
            val dialog=builder.create()
            dialog.show()
            resetGame()
            return
        } else if (userGuess > randomNum) {
            text1.text = "Too high!"
        }else if (userGuess < randomNum) {
            text1.text = "Too low!"
        }

        guess=""
        triesTextView.text="Tries: $numTries"

    }

    private fun showTryAgainDialog(){
        val builder=AlertDialog.Builder(this)
        builder.setTitle("Out of Tries!")
        builder.setPositiveButton("Play Again")
        {   dialog, _ ->
            dialog.dismiss()
        }
        val dialog=builder.create()
        dialog.show()

    }
    private fun resetGame(){
        randomNum=Random.nextInt(1,20)
        numTries=0
        guess=""
        text1.text=""
        triesTextView.text="Tries: $numTries"

    }
}