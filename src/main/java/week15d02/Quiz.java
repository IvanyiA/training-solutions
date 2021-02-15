package week15d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Quiz {

    private final List<Question> questions = new ArrayList<>();

    public void readFile(Path path) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String question;
            while ((question = bufferedReader.readLine()) != null) {
                String secondLine = bufferedReader.readLine();
                String[] parts = secondLine.split(" ");
                String answer = parts[0];
                int point = Integer.parseInt(parts[1]);
                String category = parts[2];
                questions.add(new Question(question, answer, point, category));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public List<String> justTheQuestionsByACathegory(String category) {
        List<String> justTheQuestionsByCathegory = new ArrayList<>();
        for (Question twoSentence : questions) {
            if (twoSentence.getCategory().equals(category)) {
                justTheQuestionsByCathegory.add(twoSentence.getQuestion());
            }
        }
        return justTheQuestionsByCathegory;
    }

    public Question randomQuestion(Random rnd) {
        int index = rnd.nextInt(questions.size());
        return questions.get(index);
    }

    public Map<String, List<Question>> twoSentencesInCathegoryOrder() {
        Map<String, List<Question>> twoSentencesByCathegoryMap = new HashMap<>();
        for (Question item : questions) {
            if (!twoSentencesByCathegoryMap.containsKey(item.getCategory())) {
                twoSentencesByCathegoryMap.put(item.getCategory(), new ArrayList<>());
            }
            twoSentencesByCathegoryMap.get(item.getCategory()).add(item);
        }
        return twoSentencesByCathegoryMap;
    }

    private String countPointsAndChooseMaxPointedTheme() {
        Map<String, List<Question>> map = twoSentencesInCathegoryOrder();
        String result = "";
        int max = 0;
        for (Map.Entry<String, List<Question>> entry : map.entrySet()) {
            int sum = 0;
            for (Question twoSentences : questions) {
                sum += twoSentences.getPoint();
            }
            if (sum > max) {
                max = sum;
                result = entry.getKey();
            }
        }
        return result;
    }

    public List<Question> getQuestions() {
        return new ArrayList<>(questions);
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.readFile(Path.of("kerdesek.txt"));
        System.out.println(quiz.questions.size());
        System.out.println(quiz.justTheQuestionsByACathegory("matematika"));
        System.out.println(quiz.twoSentencesInCathegoryOrder());
        Random random = new Random();
        System.out.println(quiz.randomQuestion(random));
        System.out.println(quiz.countPointsAndChooseMaxPointedTheme());


    }

}
