import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class QuizGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuizService service = new QuizService();

        System.out.println("🎮 Welcome to the Java Quiz Game!");

        // Get number of questions
        System.out.print("📌 Enter number of questions (1–20): ");
        int amount = scanner.nextInt();
        scanner.nextLine();

        // Get difficulty
        System.out.print("🎯 Choose difficulty (easy / medium / hard): ");
        String difficulty = scanner.nextLine();

        // Display categories
        System.out.println("\n📚 Categories:");
        System.out.println("  9  - General Knowledge");
        System.out.println(" 10  - Books");
        System.out.println(" 11  - Film");
        System.out.println(" 12  - Music");
        System.out.println(" 17  - Science & Nature");
        System.out.println(" 18  - Computers");
        System.out.println(" 19  - Mathematics");
        System.out.println(" 20  - Mythology");
        System.out.println(" 21  - Sports");
        System.out.println(" 23  - History");

        // Get category
        System.out.print("\n🗂️  Enter category ID (default = 9): ");
        String categoryInput = scanner.nextLine();
        String categoryId = categoryInput.isEmpty() ? "9" : categoryInput;

        // Fetch questions
        List<Question> questions = service.fetchQuestions(amount, difficulty, categoryId);
        int score = 0;

        // Run quiz
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.getQuestionText());

            List<String> options = q.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            System.out.print("⏱ You have 15 seconds! Enter your answer: ");

            try {
                String input = TimedInput.readLineWithTimeout(15);
                int choice = Integer.parseInt(input);
                String selected = options.get(choice - 1);

                if (selected.equals(q.getCorrectAnswer())) {
                    System.out.println("✅ Correct!");
                    score++;
                } else {
                    System.out.println("❌ Wrong! Correct answer: " + q.getCorrectAnswer());
                }

            } catch (TimeoutException e) {
                System.out.println("\n" + e.getMessage());
                System.out.println("❌ You didn’t answer in time! Correct answer: " + q.getCorrectAnswer());
            } catch (Exception e) {
                System.out.println("⚠️ Invalid input! Skipping this question.");
            }
        }

        // Final score
        System.out.println("\n🎉 Quiz Completed!");
        System.out.println("📊 Your final score: " + score + " out of " + questions.size());

        // Save score to file
        System.out.println("\n💬 Enter your name to save your score: ");
        String name = scanner.nextLine();

        try (FileWriter fw = new FileWriter("scores.txt", true)) {
            fw.write(name + " scored " + score + " out of " + questions.size() + "\n");
            System.out.println("💾 Score saved to scores.txt!");
        } catch (IOException e) {
            System.out.println("❌ Failed to save score.");
        }

        scanner.close();
    }
}