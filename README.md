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

<img width="852" height="344" alt="image" src="https://github.com/user-attachments/assets/4ad87e8e-ee4e-4f23-92e3-c3cffaa013e2" />

## 🚀 How to Run

### 💡 Requirements

- Java 8 or later
- Internet connection
- `json-simple-1.1.1.jar` [👉 Download here](https://code.google.com/archive/p/json-simple/downloads)

### ⚙️ Compilation (Terminal)

<pre> javac -cp libs/json-simple-1.1.1.jar src/*.java </pre>

### ▶️ Running the Game

<pre> java -cp libs/json-simple-1.1.1.jar:src QuizGame </pre>


🔁 **Windows users:** Replace `:` with `;` in the classpath.

## 🛡 License

This project is licensed under the Apache 2.0 License.
