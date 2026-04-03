package com.mathquiz

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizActivity : AppCompatActivity() {
    private lateinit var questionView: TextView
    private lateinit var answerInput: EditText
    private lateinit var checkButton: Button
    private lateinit var nextButton: Button
    private lateinit var backButton: Button
    private lateinit var clearButton: Button
    private lateinit var streakCounter: TextView
    private lateinit var resultMessage: TextView
    private lateinit var resultSection: LinearLayout
    private lateinit var numberPad: GridLayout

    private lateinit var preferencesHelper: PreferencesHelper
    private var currentLevel: Level? = null
    private var currentOperation: Operation? = null
    private var currentQuestion: Question? = null
    private var isAnswered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        preferencesHelper = PreferencesHelper(this)
        
        // Get level and operation from intent
        val levelValue = intent.getIntExtra("level", 1)
        val operationOrdinal = intent.getIntExtra("operation", 0)
        
        currentLevel = Level.values().find { it.value == levelValue }
        currentOperation = Operation.values().getOrNull(operationOrdinal)

        initializeViews()
        setupNumberPad()
        loadNewQuestion()
    }

    private fun initializeViews() {
        questionView = findViewById(R.id.questionView)
        answerInput = findViewById(R.id.answerInput)
        checkButton = findViewById(R.id.checkButton)
        nextButton = findViewById(R.id.nextButton)
        backButton = findViewById(R.id.backButton)
        clearButton = findViewById(R.id.clearButton)
        streakCounter = findViewById(R.id.streakCounter)
        resultMessage = findViewById(R.id.resultMessage)
        resultSection = findViewById(R.id.resultSection)
        numberPad = findViewById(R.id.numberPad)

        streakCounter.text = preferencesHelper.getCurrentStreak().toString()

        checkButton.setOnClickListener { checkAnswer() }
        nextButton.setOnClickListener { loadNewQuestion() }
        backButton.setOnClickListener { finish() }
        clearButton.setOnClickListener { answerInput.text.clear() }
    }

    private fun setupNumberPad() {
        val buttons = listOf(
            "7", "8", "9",
            "4", "5", "6",
            "1", "2", "3",
            "0", "-", "="
        )

        buttons.forEach { label ->
            val button = Button(this).apply {
                text = label
                layoutParams = GridLayout.LayoutParams().apply {
                    width = 0
                    height = 80
                    columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                    setMargins(8, 8, 8, 8)
                }
                setBackgroundResource(R.drawable.number_pad_button)
                setTextColor(ContextCompat.getColor(this@QuizActivity, R.color.white))
                textSize = 20f
                setTypeface(null, android.graphics.Typeface.BOLD)
                
                setOnClickListener {
                    when (label) {
                        "=" -> checkAnswer()
                        "-" -> {
                            val current = answerInput.text.toString()
                            if (current.isNotEmpty() && !current.startsWith("-")) {
                                answerInput.setText("-$current")
                            } else if (current.startsWith("-")) {
                                answerInput.setText(current.substring(1))
                            }
                        }
                        else -> {
                            val current = answerInput.text.toString()
                            if (current.length < 3) {
                                answerInput.append(label)
                            }
                        }
                    }
                }
            }
            numberPad.addView(button)
        }
    }

    private fun loadNewQuestion() {
        if (currentLevel == null || currentOperation == null) {
            finish()
            return
        }

        currentQuestion = QuizGenerator.generateQuestion(currentLevel!!, currentOperation!!)
        questionView.text = currentQuestion!!.getDisplayString()
        answerInput.setText("")
        resultSection.visibility = LinearLayout.GONE
        checkButton.visibility = Button.VISIBLE
        isAnswered = false
    }

    private fun checkAnswer() {
        if (isAnswered) {
            loadNewQuestion()
            return
        }

        val userAnswer = answerInput.text.toString().toIntOrNull()
        val correctAnswer = currentQuestion!!.answer

        if (userAnswer == null) {
            resultMessage.text = getString(R.string.incorrect)
            resultMessage.setTextColor(ContextCompat.getColor(this, R.color.red))
            preferencesHelper.resetStreak()
            streakCounter.text = "0"
        } else if (userAnswer == correctAnswer) {
            resultMessage.text = getString(R.string.correct)
            resultMessage.setTextColor(ContextCompat.getColor(this, R.color.green))
            val newStreak = preferencesHelper.incrementStreak()
            streakCounter.text = newStreak.toString()
        } else {
            resultMessage.text = getString(R.string.incorrect)
            resultMessage.setTextColor(ContextCompat.getColor(this, R.color.red))
            preferencesHelper.resetStreak()
            streakCounter.text = "0"
        }

        resultSection.visibility = LinearLayout.VISIBLE
        checkButton.visibility = Button.GONE
        isAnswered = true
    }
}
