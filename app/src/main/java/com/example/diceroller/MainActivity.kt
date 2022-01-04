package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    lateinit var rollButton: Button
    lateinit var firstDice: ImageView
    lateinit var secondDice: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollButton = findViewById<Button>(R.id.button)
        firstDice = findViewById(R.id.imageView1)
        secondDice = findViewById(R.id.imageView2)
        rollDice(firstDice)
        rollDice(secondDice)

        rollButton.setOnClickListener {
            rollDice(firstDice)
            rollDice(secondDice)
        }
    }

    private fun rollDice(diceImage: ImageView) {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceResource = when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(diceResource)
        diceImage.contentDescription = "Your $diceImage rolled a ${diceRoll.toString()}"

    }
}

class Dice(private val numSides: Int){
    fun roll(): Int{
        return (1..numSides).random()
    }
}