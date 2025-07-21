# 🎮 LnB Quiz Game

A **Java-based CLI (Command-Line Interface) Quiz Game** that fetches multiple-choice questions from the [Open Trivia Database API](https://opentdb.com/). It includes:

- Customizable difficulty and category
- Timer for each question (15 seconds)
- Score tracking and saving to `scores.txt`

## 📌 Features

✅ Fetches questions live using HTTP from Open API  
✅ Multiple-choice questions with randomized options  
✅ User selects:
- Number of questions  
- Difficulty (easy, medium, hard)  
- Category (General Knowledge, Sports, etc.)

✅ 15-second countdown timer per question  
✅ Final score displayed  
✅ Scores saved in `scores.txt`

## 📂 Project Structure

LnB-Quiz-Game/
├── src/
│   ├── QuizGame.java          # Main game logic
│   ├── Question.java          # Data model for each quiz question
│   ├── QuizService.java       # API fetch + JSON parsing
│   └── TimedInput.java        # Timer for input
├── libs/
│   └── json-simple-1.1.1.jar  # JSON parsing library
├── scores.txt                 # Score history (generated after running)
├── README.md
└── .gitignore


## 🚀 How to Run

### 💡 Requirements

- Java 8 or later
- Internet connection
- `json-simple-1.1.1.jar` [👉 Download here](https://code.google.com/archive/p/json-simple/downloads)

### ⚙️ Compilation (Terminal)

<pre> ``` javac -cp libs/json-simple-1.1.1.jar src/*.java ``` </pre>

### ▶️ Running the Game

<pre> ``` java -cp libs/json-simple-1.1.1.jar:src QuizGame ``` </pre>


🔁 **Windows users:** Replace `:` with `;` in the classpath.

## 🛡 License

This project is licensed under the Apache 2.0 License.
