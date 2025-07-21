import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;

public class QuizService {

    public List<Question> fetchQuestions(int amount, String difficulty, String categoryId) {
        List<Question> questionsList = new ArrayList<>();
        try {
            String apiUrl = String.format(
                    "https://opentdb.com/api.php?amount=%d&difficulty=%s&type=multiple&category=%s",
                    amount, difficulty.toLowerCase(), categoryId
            );

            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(response.toString());
            JSONArray results = (JSONArray) jsonResponse.get("results");

            for (Object obj : results) {
                JSONObject questionObj = (JSONObject) obj;
                String question = decodeHtml((String) questionObj.get("question"));
                String correctAnswer = decodeHtml((String) questionObj.get("correct_answer"));

                JSONArray incorrectArr = (JSONArray) questionObj.get("incorrect_answers");
                List<String> options = new ArrayList<>();
                for (Object wrong : incorrectArr) {
                    options.add(decodeHtml(wrong.toString()));
                }
                options.add(correctAnswer);
                Collections.shuffle(options);

                questionsList.add(new Question(question, correctAnswer, options));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return questionsList;
    }

    private String decodeHtml(String input) {
        return URLDecoder.decode(input, java.nio.charset.StandardCharsets.UTF_8);
    }
}