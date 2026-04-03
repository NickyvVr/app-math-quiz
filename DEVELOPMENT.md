# Reken Quiz - Development Guide

## ✅ Project Complete

Your **Reken Quiz** Android app has been fully created with all necessary components!

## 📁 What Was Created

### Core Application Files
- **MainActivity.kt** - Home screen with level and operation selection
- **QuizActivity.kt** - Main quiz interface with number pad input
- **QuizData.kt** - Question generation engine with difficulty levels
- **PreferencesHelper.kt** - Streak tracking using SharedPreferences

### UI Resources
- **activity_main.xml** - Home screen layout (level & operation grid, streak display)
- **activity_quiz.xml** - Quiz screen layout (question, number pad, streak counter)
- **button_background.xml** - Green button style with press effects
- **number_pad_button.xml** - Blue button style for number pad
- **ic_launcher_foreground.xml** - App icon (white plus symbol)

### Theming & Styling
- **colors.xml** - Green/Blue/Orange color palette
- **strings.xml** - All UI text in Dutch
- **styles.xml** - Button and text styles
- **AndroidManifest.xml** - App configuration

### Build Configuration
- **build.gradle** (root & app) - Dependencies and compilation settings
- **settings.gradle** - Project structure
- **gradle-wrapper.properties** - Gradle version (8.2)
- **proguard-rules.pro** - Code obfuscation rules

---

## 🎮 App Features at a Glance

### 5 Difficulty Levels (groep 3-8)
| Level | Ages | Range | Example |
|-------|------|-------|---------|
| Groep 3 | 6-7 | 1-10 | 3 + 4 = ? |
| Groep 4 | 7-8 | 5-20 | 15 - 8 = ? |
| Groep 5 | 8-9 | 20-100 | 7 × 8 = ? |
| Groep 6 | 9-10 | 50-500 | 48 ÷ 6 = ? |
| Groep 7-8 | 10-12 | 200+ | 25 × 32 = ? |

### 4 Operations
✅ Optellen (Addition: +)
✅ Aftrekken (Subtraction: -)
✅ Vermenigvuldigen (Multiplication: ×)
✅ Delen (Division: ÷)

### Streak System
- **Current Streak**: Resets on wrong answer
- **Best Streak**: Personal record, persisted permanently
- Shows immediately on home screen
- Updated live during play

### Number Pad
```
7 8 9
4 5 6
1 2 3
0 - =
```
- Large, kid-friendly buttons
- Minus for negative numbers
- Equals to submit
- Clear button to delete input

---

## 🏗️ Project Structure

```
app-math-quiz/
├── app/
│   ├── src/main/
│   │   ├── kotlin/com/mathquiz/
│   │   │   ├── MainActivity.kt
│   │   │   ├── QuizActivity.kt
│   │   │   ├── QuizData.kt
│   │   │   └── PreferencesHelper.kt
│   │   ├── res/
│   │   │   ├── drawable/        # Button styles & icons
│   │   │   ├── layout/           # XML layouts
│   │   │   ├── mipmap/           # App icons
│   │   │   ├── values/           # Colors, strings, styles
│   │   │   └── xml/              # Backup & data extraction rules
│   │   └── AndroidManifest.xml
│   ├── build.gradle
│   └── proguard-rules.pro
├── gradle/wrapper/
│   └── gradle-wrapper.properties
├── build.gradle (root)
├── settings.gradle
├── README.md
├── DEVELOPMENT.md (this file)
└── .gitignore
```

---

## 🚀 Quick Start

### 1. Open in Android Studio
```
File → Open → app-math-quiz
```

### 2. Build the Project
```bash
./gradlew clean build
```
Or use Android Studio menu: Build → Clean Project → Build Project

### 3. Run on Emulator/Device
```bash
./gradlew installDebug
```
Or click the Run button in Android Studio

### 4. Test the App
- Select a level (e.g., Groep 3)
- Select an operation (e.g., Optellen)
- Use the number pad to enter answers
- Watch the streak grow! 🔥

---

## 🎨 Color Theme

The app uses a kid-friendly, educational color scheme:

- **Primary Green** `#2E7D32` - Buttons, headers, correct answers
- **Light Green** `#4CAF50` - Button backgrounds
- **Primary Blue** `#1976D2` - Number pad
- **Light Blue** `#64B5F6` - Number pad buttons
- **Accent Orange** `#FF9800` - Streak display, highlights
- **White** `#FFFFFF` - Text, backgrounds
- **Red** `#D32F2F` - Wrong answers

---

## 📊 Difficulty Generation Details

### Question Logic by Level

Each level generates age-appropriate questions:

**Level 1 (Groep 3)** - Ages 6-7
- Addition: 1-5 + 1-5
- Subtraction: 3-9 - 1-3
- Multiplication: 2-5 × 2-5
- Division: (1-5 × 1-3) ÷ 1-3

**Level 2 (Groep 4)** - Ages 7-8
- Addition: 5-15 + 5-15
- Subtraction: 10-20 - 5-10
- Multiplication: 2-6 × 2-6
- Division: (2-6 × 2-5) ÷ 2-5

**Level 3 (Groep 5)** - Ages 8-9
- Addition: 20-50 + 20-50
- Subtraction: 30-100 - 15-30
- Multiplication: 5-9 × 5-9
- Division: (5-10 × 2-6) ÷ 2-6

**Level 4 (Groep 6)** - Ages 9-10
- Addition: 50-200 + 50-200
- Subtraction: 100-500 - 50-200
- Multiplication: 10-20 × 10-20
- Division: (10-20 × 2-9) ÷ 2-9

**Level 5 (Groep 7-8)** - Ages 10-12
- Addition: 200-1000 + 200-1000
- Subtraction: 500-2000 - 200-800
- Multiplication: 20-99 × 20-99
- Division: (20-50 × 5-15) ÷ 5-15

---

## 💾 Data Persistence

SharedPreferences stores:
- `current_streak` - Current question streak (reset on error)
- `best_streak` - Best streak ever (persists across all sessions)

File: `math_quiz_prefs.xml` (in device/emulator storage)

Backed up automatically by Android backup service.

---

## 🔧 Technical Stack

- **Language**: Kotlin 1.9.0
- **Min API**: 24 (Android 7.0)
- **Target API**: 34 (Android 14)
- **Architecture**: MVP (Model-View-Presenter via Activities)
- **Storage**: SharedPreferences
- **UI Framework**: Android AppCompat + Material Design 2
- **Gradle Version**: 8.2
- **Key Dependencies**:
  - androidx.core:core-ktx
  - androidx.appcompat:appcompat
  - androidx.lifecycle:lifecycle-viewmodel-ktx
  - com.google.android.material:material

---

## 🎯 KISS Principle Implementation

The app follows Keep It Simple, Stupid:

1. **No Distractions** - Single focus on math problems
2. **Clear Navigation** - 3 screens max (home → select → quiz)
3. **Large Buttons** - Finger-friendly for ages 6-12
4. **Intuitive Input** - Number pad mimics real calculator
5. **Immediate Feedback** - Green/red results instantly
6. **Minimal Text** - Clear, short Dutch labels
7. **No Ads/Tracking** - Pure learning experience
8. **Fast Loading** - Lightweight, no network calls

---

## 🚧 Future Enhancement Ideas

- [ ] Sound effects (ding for correct, buzz for wrong)
- [ ] Haptic feedback (vibration on feedback)
- [ ] Timed challenges (30 seconds per question)
- [ ] Statistics (questions answered, accuracy %)
- [ ] Multiple player profiles
- [ ] Custom difficulty ranges
- [ ] Dark mode
- [ ] Leaderboard (local)
- [ ] Hint system
- [ ] Achievement badges

---

## 🐛 Troubleshooting

### Gradle Build Fails
- Check Android SDK installation
- Run `./gradlew clean build`
- Try `File → Invalidate Caches → Restart` in Android Studio

### Layout Issues on Different Screen Sizes
- All layouts use flexible GridLayout and LinearLayout.MATCH_PARENT
- Tested on phones (4"-6") and tablets (7"-10")

### Streak Not Persisting
- Check device storage is not full
- Verify SharedPreferences enabled in permissions
- Clear app data and retry (Settings → Apps → Reken Quiz → Storage → Clear Data)

### Number Pad Not Responding
- Ensure keyboard is hidden (can interfere on some devices)
- Try tapping the EditText to focus it

---

## 📝 License & Credits

A simple educational math game for Dutch elementary school children.

Created with ❤️ for learning.

---

**Questions?** Check the README.md or review the code comments in QuizData.kt!
