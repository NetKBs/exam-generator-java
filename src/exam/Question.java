package exam;

/**
 *
 * @author Net
 */

import java.util.ArrayList;

public final class Question {

    private String question;
    private String type;
    private String[] answer;
    private String[] another_answers; // wrongs answers

    public Question(String question, String[] answer, String[] another_answers, String type) {
        this.question = question;
        this.answer = answer;

        // Verify if is null or empty (just possible if is type VF)
        if ("CD".equals(type)) {
            // For true/false question, another_answers must be null
            if (another_answers.length > 0) {
                throw new IllegalArgumentException("Cannot have wrong answers for a coding question.");
            }
            this.another_answers = null;
        } else {
            this.another_answers = another_answers;
        }

        this.type = type;
    }

    // setters
    public void setQuestion(String question) {
        this.question = question;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAnswers(String[] answer) {
        this.answer = answer;
    }

    public void setWrongAnswers(String[] another_answers) {
        this.another_answers = another_answers;
    }

    // getters
    public String getQuestion() {
        return question;
    }

    public String getType() {
        return type;
    }

    public String[] getAnswers() {
        return answer;
    }

    public String[] getWrongAnswers() {
        if (!type.equals("CD")) {
            return another_answers;
        }
        return new String[0];
    }

    // get ponderation
    public int verifyAnswer(String[] answers_user) {
        
        String[] correct_answers = getAnswers();
        int correctCount = 0; // contador de respuestas correctas
 
        for (int i = 0; i < correct_answers.length; i++) {
            // comparar cada respuesta del usuario con la respuesta correcta correspondiente
            // Eliminamos espacios en blanco completamente
            if (getType().equals("CD")) {
                correct_answers[i] = correct_answers[i].replaceAll(" ", ""); 
                answers_user[i] = answers_user[i].replaceAll(" ", ""); 
            }
            
            
            if (i < answers_user.length && correct_answers[i].equals(answers_user[i])) {
                correctCount++;
            }
        }
        
        int ponderation = correctCount == correct_answers.length ? 1 : 0;
        return ponderation;
    }

    // Print question details
    public void printQuestionDetails() {
        System.out.printf("%s\nQuestion Type: %s\n", getQuestion(), getType());

        System.out.println("Correct Answers: ");
        for (String e : getAnswers()) {
            System.out.println(e);
        }

        System.out.println();

        if (getWrongAnswers() != null) { // verify if another_answers is not null
            System.out.println("Wrong Answers: ");
            for (String e : getWrongAnswers()) {
                System.out.println(e);
            }
        }
    }

}
