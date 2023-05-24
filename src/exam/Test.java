
package exam;

/**
 *
 * @author Net
 */

import user.Person;

public class Test {
    private ExamModel exam_model;
    private Person person;
    private int ponderation;
    private int time_to_finish; // minutes
    
    public Test (ExamModel exam_model, Person person, int ponderation, int time_to_finish) {
        this.exam_model = exam_model;
        this.person = person;
        this.ponderation = ponderation;
        this.time_to_finish = time_to_finish;
    }
    
    //setters
    
    public void setExamModel(ExamModel exam_model) {
        this.exam_model = exam_model;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    
    public void setPonderation(int ponderation) {
        this.ponderation = ponderation;
    }
    
    public void setTimeToFinish(int time_to_finish) {
        this.time_to_finish = time_to_finish;
    }
    
    //getters
    public ExamModel getExamModel() {
        return exam_model;
    }
    
    public Person getPerson() {
        return person;
    }
    
    public int getPonderation() {
        return ponderation;
    }
    
    public int getTimeToFinish() {
        return time_to_finish;
    }


}
