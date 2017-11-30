package br.ufal.ic.cb.sample.model;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

/**
 *
 * @author Marcos
 */
@Document
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE, delimiter = ".")
    private String id;
    @Field
    private final String courseId;
    @Field
    private final String userId;
    @Field
    private int currentSemester;
    @Field
    private final Set<Discipline> paidDisciplines;

    public Student(String courseId,  String userId, int currentSemester) {
        this.courseId = courseId;
        this.currentSemester = currentSemester;
        this.paidDisciplines = new HashSet<>();
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public String getCourse() {
        return courseId;
    }

    public void setCurrentSemester(int currentSemester) {
        this.currentSemester = currentSemester;
    }
    
    public int getCurrentSemester() {
        return currentSemester;
    }

    public void addPaidDiscipline(Discipline paidDiscipline) {
        this.paidDisciplines.add(paidDiscipline);
    }
    
    public Set<Discipline> getPaidDiscipline() {
        return Collections.unmodifiableSet(this.paidDisciplines);
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", courseId=" + courseId + ", userId=" 
                + userId + ", currentSemester=" + currentSemester 
                + ", paidDisciplines=" + paidDisciplines + '}';
    }
    
    
    
}
