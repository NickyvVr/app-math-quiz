package com.mathquiz

import android.content.Context
import android.content.SharedPreferences

class PreferencesHelper(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("math_quiz_prefs", Context.MODE_PRIVATE)

    fun getCurrentStreak(): Int = sharedPreferences.getInt("current_streak", 0)

    fun getBestStreak(): Int = sharedPreferences.getInt("best_streak", 0)

    fun incrementStreak(): Int {
        val current = getCurrentStreak() + 1
        val best = getBestStreak()
        
        sharedPreferences.edit().apply {
            putInt("current_streak", current)
            if (current > best) {
                putInt("best_streak", current)
            }
            apply()
        }
        
        return current
    }

    fun resetStreak() {
        sharedPreferences.edit().apply {
            putInt("current_streak", 0)
            apply()
        }
    }
}
