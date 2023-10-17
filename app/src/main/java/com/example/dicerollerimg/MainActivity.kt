package com.example.dicerollerimg

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //create a variable to hold the button from the view
        val rollButton: Button = findViewById(R.id.button2)
        //listen for a button click
        rollButton.setOnClickListener {
            rollDice()
        }
        //roll dice on app start
        rollDice()
    }

    private fun rollDice() {
        //create dice 1
        val dice = Dice(6)
        //roll dice
        val diceRoll = dice.roll()
        //get imageView
        val diceImage: ImageView = findViewById(R.id.imageView)
        //set imageResource to drawableResource variable given dice roll
        val drawableResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //set the image for dice roll
        diceImage.setImageResource(drawableResource)



    }
}
// blueprint for making a dice
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}