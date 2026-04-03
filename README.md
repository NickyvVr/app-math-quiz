# Reken Quiz - Math Quiz App

A simple, KISS (Keep It Simple, Stupid) design math quiz app for Android, tailored for Dutch elementary school students (ages 6-12, groep 3-8).

## Features

✨ **4 Math Operations**
- Optellen (Addition)
- Aftrekken (Subtraction)
- Vermenigvuldigen (Multiplication)
- Delen (Division)

✨ **5 Difficulty Levels**
- Groep 3 (6-7 years) - Basic addition/subtraction up to 10
- Groep 4 (7-8 years) - Numbers up to 20
- Groep 5 (8-9 years) - Numbers up to 100
- Groep 6 (9-10 years) - Numbers up to 500
- Groep 7-8 (10-12 years) - Advanced arithmetic

✨ **Game Features**
- 📊 Streak tracking (current & best) - persisted with SharedPreferences
- 🟢 Number pad input for easy navigation
- ✅ Immediate feedback (green for correct, red for incorrect)
- 🎨 Clean, colorful UI with green/blue/orange theme

## Design Philosophy

- **KISS Principle**: Minimal UI, no distractions, focused on learning
- **Kid-Friendly**: Large buttons, clear colors, simple navigation
- **Dutch Language**: All UI text in Dutch for natural learning
- **Color Theme**: Green (primary), Blue (input), Orange (accents)

## Architecture

```
app/src/main/
├── kotlin/com/mathquiz/
│   ├── MainActivity.kt         # Home screen with level/operation selection
│   ├── QuizActivity.kt         # Main quiz interface with number pad
│   ├── QuizData.kt             # Question generation logic & data models
│   ├── PreferencesHelper.kt    # SharedPreferences wrapper for streak tracking
│
├── res/
│   ├── layout/
│   │   ├── activity_main.xml   # Home screen layout
│   │   └── activity_quiz.xml   # Quiz screen with number pad
│   ├── drawable/
│   │   ├── button_background.xml
│   │   └── number_pad_button.xml
│   └── values/
│       ├── colors.xml
│       ├── strings.xml (Dutch)
│       └── styles.xml
```

## Key Components

### PreferencesHelper
Manages streak tracking using Android SharedPreferences:
- `getCurrentStreak()` - Returns current streak count
- `getBestStreak()` - Returns personal best
- `incrementStreak()` - Adds 1 to streak (updates best if needed)
- `resetStreak()` - Resets to 0 (on wrong answer)

### QuizGenerator
Intelligently generates questions by level:
- **Level 1**: Simple addition (1-5), subtraction with small numbers
- **Level 2**: Medium numbers (5-20), basic multiplication tables
- **Level 3**: Larger numbers (20-100), extended tables
- **Level 4**: Big numbers (50-500), larger multiplication
- **Level 5**: Advanced arithmetic (200-2000+)

### UI Components
- **Number Pad**: 3x4 grid with digits 0-9, minus sign, equals
- **Answer Display**: Editable field showing user input
- **Question Display**: Large, centered question text
- **Streak Counter**: Orange badge showing current/best streak

## Build & Run

### Prerequisites
- Android Studio 2022.1 or later
- Android SDK 24+ (API level 24)
- Kotlin 1.9.0+

### Build
```bash
./gradlew build
./gradlew installDebug
```

### Run on Emulator/Device
```bash
./gradlew run
```

## Project Structure

- Minimum SDK: API 24 (Android 7.0)
- Target SDK: API 34 (Android 14)
- Kotlin + ViewBinding
- No external dependencies except AndroidX (Lifecycle, AppCompat, Material)

## User Flow

1. **Home Screen** - Select difficulty level (5 buttons)
2. **Operation Select** - Choose math operation (4 buttons)
3. **Quiz Screen** - Answer questions:
   - View the question
   - Input answer using number pad
   - Tap "Controleer" (Check) or "=" to submit
   - See result (green/red)
   - Tap "Volgende vraag" (Next) to continue
4. **Streak** - Persists between sessions via SharedPreferences

## Colors

- 🟢 **Primary Green**: `#2E7D32` (buttons, header)
- 🔵 **Primary Blue**: `#1976D2` (number pad)
- 🟠 **Accent Orange**: `#FF9800` (streak display)

## Future Enhancement Ideas

- Sound effects & haptic feedback
- Leaderboard/statistics
- Timed challenges
- Multiple player profiles
- Custom difficulty
- Dark mode

## License

Simple educational project - Free to use and modify.

---

**Made for Dutch elementary school students** 🇳🇱 📚
