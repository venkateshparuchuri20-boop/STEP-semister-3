package week3.practice_problems;


import java.util.*;

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

abstract class Question {
    String text;
    int marks;

    Question(String text, int marks) {
        this.text = text;
        this.marks = marks;
    }

    // Every question type evaluates answers differently
    abstract int evaluate(String answer);
}

class MultipleChoiceQuestion extends Question {
    String correctAnswer;

    MultipleChoiceQuestion(String text, String correctAnswer, int marks) {
        super(text, marks);
        this.correctAnswer = correctAnswer;
    }

    @Override
    int evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer) ? marks : 0;
    }
}

class TrueFalseQuestion extends Question {
    String correctAnswer;

    TrueFalseQuestion(String text, String correctAnswer, int marks) {
        super(text, marks);
        this.correctAnswer = correctAnswer;
    }

    @Override
    int evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer) ? marks : 0;
    }
}

class ShortAnswerQuestion extends Question {
    String correctAnswer;

    ShortAnswerQuestion(String text, String correctAnswer, int marks) {
        super(text, marks);
        this.correctAnswer = correctAnswer;
    }

    @Override
    int evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer.trim()) ? marks : 0;
    }
}

class Examination {
    String name;
    List<Question> questions = new ArrayList<>();

    Examination(String name) {
        this.name = name;
    }

    void addQuestion(Question q) {
        questions.add(q);
    }
}

class Attempt {
    Student student;
    Examination exam;
    Map<Integer, String> answers = new HashMap<>();
    boolean submitted = false;

    Attempt(Student student, Examination exam) {
        this.student = student;
        this.exam = exam;
    }

    void answerQuestion(int number, String answer) {
        if (submitted) {
            System.out.println("Cannot change answers for a submitted examination.");
            return;
        }

        if (number < 1 || number > exam.questions.size()) {
            System.out.println("Invalid question number.");
            return;
        }

        answers.put(number, answer);
        System.out.println("Answer recorded for Question " + number);
    }

    void submit() {
        if (submitted) {
            System.out.println("Examination already submitted.");
            return;
        }

        submitted = true;
        int total = 0;

        System.out.println("Exam submitted by " + student.name);

        for (int i = 0; i < exam.questions.size(); i++) {
            Question q = exam.questions.get(i);
            String answer = answers.getOrDefault(i + 1, "");
            int score = q.evaluate(answer);

            total += score;

            System.out.println("Question " + (i + 1) + ": "
                    + (score > 0 ? "Correct" : "Incorrect")
                    + " (" + score + " points)");
        }

        System.out.println("Total score: " + total + "/"
                + exam.questions.stream().mapToInt(q -> q.marks).sum());
    }
}

public class Main2 {
    public static void main(String[] args) {
        Student s1 = new Student("Student 1");
        Examination exam = new Examination("Exam A");

        exam.addQuestion(new MultipleChoiceQuestion(
                "Which language is used here?", "C", 5));

        exam.addQuestion(new TrueFalseQuestion(
                "Java supports inheritance.", "True", 5));

        Attempt attempt = new Attempt(s1, exam);

        System.out.println("Exam started by " + s1.name);

        attempt.answerQuestion(1, "C");
        attempt.answerQuestion(2, "True");

        attempt.submit();

        // Attempt to change an answer after submission
        attempt.answerQuestion(1, "Java");
    }
}

