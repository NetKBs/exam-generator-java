package exam;

/**
 *
 * @author Net
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public final class ExamModel {


    private String topic;
    private ArrayList<Question> questions;

    public ExamModel(String topic) {
        this.topic = topic;
        this.questions = new ArrayList<>();
        // Automatically generate questions about the topic
        generateQuestions();

    }

    // setters
    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    //getters
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public String getTopic() {
        return topic;
    }

    // Questions Generator
    public void generateQuestions() {

        // Types of questions
        ArrayList<Question> vf = new ArrayList<>();
        ArrayList<Question> s1 = new ArrayList<>();
        ArrayList<Question> s2 = new ArrayList<>();
        ArrayList<Question> s3 = new ArrayList<>();
        ArrayList<Question> code = new ArrayList<>();

        String slice = File.separator;
        String file_path = System.getProperty("user.dir") + slice + "src" + slice + "exam" + slice + topic + "_questions.txt";

        try {

            File file = new File(file_path);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.trim().isEmpty()) {
                    continue; // skip empty lines
                }
                
                String[] line_elements = line.split("\\|"); // split the line into an array of elements using the separator |

                String question = line_elements[0];
                String[] answer = line_elements[1].split(",");
                String[] another_answers = line_elements[2].equals("null") ? null : line_elements[2].split(",");
                String type = line_elements[3];

                // save it
                switch (type) {
                    case "VF":
                     
                        vf.add(new Question(question, answer, another_answers, type));
                        break;
                    case "S1":
                        s1.add(new Question(question, answer, another_answers, type));
                        break;
                    case "S2":
                   
                        s2.add(new Question(question, answer, another_answers, type));
                        break;
                    case "S3":
                        s3.add(new Question(question, answer, another_answers, type));
                        break;
                    default:
                        code.add(new Question(question, answer, another_answers, type));
                        break;
                }

            }

        } catch (IOException e) {
        }

        // Shuffle questions
        Collections.shuffle(vf);
        //Collections.shuffle(s1);
        Collections.shuffle(s2);
        //Collections.shuffle(s3);
        //Collections.shuffle(code);

        // Add the first 5 elements of each question type in order
        this.questions.addAll(vf.subList(0, 5));
        //questions.addAll(s1.subList(0, 5));
        this.questions.addAll(s2.subList(0, 5));
        //questions.addAll(s3.subList(0, 5));
        //questions.addAll(code.subList(0, 5));
    }
}
