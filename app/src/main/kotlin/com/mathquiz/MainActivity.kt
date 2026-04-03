package com.mathquiz

import android.content.Intent
import android.os.Bundle
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var preferencesHelper: PreferencesHelper
    private var selectedLevel: Level? = null
    private var selectedOperation: Operation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferencesHelper = PreferencesHelper(this)
        
        updateStreakDisplay()
        setupLevelButtons()
        setupOperationButtons()
    }

    private fun updateStreakDisplay() {
        findViewById<TextView>(R.id.currentStreakView).text = 
            preferencesHelper.getCurrentStreak().toString()
        findViewById<TextView>(R.id.bestStreakView).text = 
            preferencesHelper.getBestStreak().toString()
    }

    private fun setupLevelButtons() {
        val levelGrid = findViewById<GridLayout>(R.id.levelGrid)
        val levels = listOf(
            Level.LEVEL_1 to R.string.level_1,
            Level.LEVEL_2 to R.string.level_2,
            Level.LEVEL_3 to R.string.level_3,
            Level.LEVEL_4 to R.string.level_4,
            Level.LEVEL_5 to R.string.level_5
        )

        levels.forEach { (level, labelRes) ->
            val button = Button(this).apply {
                text = getString(labelRes)
                layoutParams = GridLayout.LayoutParams().apply {
                    width = 0
                    height = GridLayout.LayoutParams.WRAP_CONTENT
                    columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                    setMargins(8, 8, 8, 8)
                }
                setBackgroundResource(R.drawable.button_background)
                setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                setPadding(16, 16, 16, 16)
                textSize = 14f
                setOnClickListener {
                    selectedLevel = level
                    tryStartQuiz()
                }
            }
            levelGrid.addView(button)
        }
    }

    private fun setupOperationButtons() {
        val operationGrid = findViewById<GridLayout>(R.id.operationGrid)
        val operations = listOf(
            Operation.ADD to R.string.add,
            Operation.SUBTRACT to R.string.subtract,
            Operation.MULTIPLY to R.string.multiply,
            Operation.DIVIDE to R.string.divide
        )

        operations.forEach { (operation, labelRes) ->
            val button = Button(this).apply {
                text = getString(labelRes)
                layoutParams = GridLayout.LayoutParams().apply {
                    width = 0
                    height = GridLayout.LayoutParams.WRAP_CONTENT
                    columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                    setMargins(8, 8, 8, 8)
                }
                setBackgroundResource(R.drawable.button_background)
                setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                setPadding(16, 16, 16, 16)
                textSize = 14f
                setOnClickListener {
                    selectedOperation = operation
                    tryStartQuiz()
                }
            }
            operationGrid.addView(button)
        }
    }

    private fun tryStartQuiz() {
        if (selectedLevel != null && selectedOperation != null) {
            val intent = Intent(this, QuizActivity::class.java).apply {
                putExtra("level", selectedLevel!!.value)
                putExtra("operation", selectedOperation!!.ordinal)
            }
            startActivity(intent)
            selectedLevel = null
            selectedOperation = null
        }
    }

    override fun onResume() {
        super.onResume()
        updateStreakDisplay()
    }
}
