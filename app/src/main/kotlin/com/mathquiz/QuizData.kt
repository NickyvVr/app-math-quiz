package com.mathquiz

enum class Operation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE
}

enum class Level(val value: Int) {
    LEVEL_1(1),
    LEVEL_2(2),
    LEVEL_3(3),
    LEVEL_4(4),
    LEVEL_5(5)
}

data class Question(
    val num1: Int,
    val num2: Int,
    val operation: Operation,
    val answer: Int
) {
    fun getDisplayString(): String {
        val operatorSymbol = when (operation) {
            Operation.ADD -> "+"
            Operation.SUBTRACT -> "-"
            Operation.MULTIPLY -> "×"
            Operation.DIVIDE -> "÷"
        }
        return "$num1 $operatorSymbol $num2 = ?"
    }
}

object QuizGenerator {
    fun generateQuestion(level: Level, operation: Operation): Question {
        return when {
            level == Level.LEVEL_1 -> generateLevel1(operation)
            level == Level.LEVEL_2 -> generateLevel2(operation)
            level == Level.LEVEL_3 -> generateLevel3(operation)
            level == Level.LEVEL_4 -> generateLevel4(operation)
            level == Level.LEVEL_5 -> generateLevel5(operation)
            else -> throw IllegalArgumentException("Unknown level: $level")
        }
    }

    private fun generateLevel1(operation: Operation): Question {
        return when (operation) {
            Operation.ADD -> {
                val num1 = (1..5).random()
                val num2 = (1..5).random()
                Question(num1, num2, operation, num1 + num2)
            }
            Operation.SUBTRACT -> {
                val num1 = (3..9).random()
                val num2 = (1..3).random()
                Question(num1, num2, operation, num1 - num2)
            }
            Operation.MULTIPLY -> {
                val num1 = (2..5).random()
                val num2 = (2..5).random()
                Question(num1, num2, operation, num1 * num2)
            }
            Operation.DIVIDE -> {
                val num1 = (1..5).random()
                val num2 = (1..3).random()
                Question(num1 * num2, num2, operation, num1)
            }
        }
    }

    private fun generateLevel2(operation: Operation): Question {
        return when (operation) {
            Operation.ADD -> {
                val num1 = (5..15).random()
                val num2 = (5..15).random()
                Question(num1, num2, operation, num1 + num2)
            }
            Operation.SUBTRACT -> {
                val num1 = (10..20).random()
                val num2 = (5..10).random()
                Question(num1, num2, operation, num1 - num2)
            }
            Operation.MULTIPLY -> {
                val num1 = (2..6).random()
                val num2 = (2..6).random()
                Question(num1, num2, operation, num1 * num2)
            }
            Operation.DIVIDE -> {
                val num1 = (2..6).random()
                val num2 = (2..5).random()
                Question(num1 * num2, num2, operation, num1)
            }
        }
    }

    private fun generateLevel3(operation: Operation): Question {
        return when (operation) {
            Operation.ADD -> {
                val num1 = (20..50).random()
                val num2 = (20..50).random()
                Question(num1, num2, operation, num1 + num2)
            }
            Operation.SUBTRACT -> {
                val num1 = (30..100).random()
                val num2 = (15..30).random()
                Question(num1, num2, operation, num1 - num2)
            }
            Operation.MULTIPLY -> {
                val num1 = (5..9).random()
                val num2 = (5..9).random()
                Question(num1, num2, operation, num1 * num2)
            }
            Operation.DIVIDE -> {
                val num1 = (5..10).random()
                val num2 = (2..6).random()
                Question(num1 * num2, num2, operation, num1)
            }
        }
    }

    private fun generateLevel4(operation: Operation): Question {
        return when (operation) {
            Operation.ADD -> {
                val num1 = (50..200).random()
                val num2 = (50..200).random()
                Question(num1, num2, operation, num1 + num2)
            }
            Operation.SUBTRACT -> {
                val num1 = (100..500).random()
                val num2 = (50..200).random()
                Question(num1, num2, operation, num1 - num2)
            }
            Operation.MULTIPLY -> {
                val num1 = (10..20).random()
                val num2 = (10..20).random()
                Question(num1, num2, operation, num1 * num2)
            }
            Operation.DIVIDE -> {
                val num1 = (10..20).random()
                val num2 = (2..9).random()
                Question(num1 * num2, num2, operation, num1)
            }
        }
    }

    private fun generateLevel5(operation: Operation): Question {
        return when (operation) {
            Operation.ADD -> {
                val num1 = (200..1000).random()
                val num2 = (200..1000).random()
                Question(num1, num2, operation, num1 + num2)
            }
            Operation.SUBTRACT -> {
                val num1 = (500..2000).random()
                val num2 = (200..800).random()
                Question(num1, num2, operation, num1 - num2)
            }
            Operation.MULTIPLY -> {
                val num1 = (20..99).random()
                val num2 = (20..99).random()
                Question(num1, num2, operation, num1 * num2)
            }
            Operation.DIVIDE -> {
                val num1 = (20..50).random()
                val num2 = (5..15).random()
                Question(num1 * num2, num2, operation, num1)
            }
        }
    }
}
