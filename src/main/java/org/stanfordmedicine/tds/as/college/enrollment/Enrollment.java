package org.stanfordmedicine.tds.as.college.enrollment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.stanfordmedicine.tds.as.foundation.data.jpa.AbstractAuditingEntity;

@Entity
@Table(name = Enrollment.TABLE_NAME)
public class Enrollment extends AbstractAuditingEntity<Long>{
    public static final String TABLE_NAME = "ENROLLMENTS";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_ID")
    private Long id;
    @Column(name = "ENROLL_DATE")
    private String dateOfEnroll;
 
    @Column(name = "COURSE_NAME")
    private String courseName;
    @Override
    public Long getId() {
      
        return id ;
    }
    @Override
    public void setId(Long id) {
        this.id=id;
        }

    
    public String getDateOfEnroll() {
        return dateOfEnroll;
    }

    
    public void setDateOfEnroll(String dateOfEnroll) {
        this.dateOfEnroll = dateOfEnroll;
    }

  
    public String getCourseName() {
        return courseName;
    }

 
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}