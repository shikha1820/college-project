package org.stanfordmedicine.tds.as.college.lecturer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.stanfordmedicine.tds.as.college.subject.Subject;
import org.stanfordmedicine.tds.as.foundation.data.jpa.AbstractAuditingEntity;

@Entity
@Table(name = Lecturer.TABLE_NAME)
public class Lecturer extends AbstractAuditingEntity<Long> {
    public static final String TABLE_NAME = "LECTURERS";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "L_ID")
    private Long id;
    @Column(name = "LECT_ID")
    private String lectId;
    @Column(name = "LECT_NAME")
    private String lectName;
    @Column(name = "LECT_EMAIL")
    private String lectEmail;
    @Column(name = "LECT_ADDRESS")
    private String lectAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SUBJECT_ID", referencedColumnName = "S_ID")
    private Subject subject;


    @Override
    public void setId(Long id) {
     this.id = id;
        
    }

    @Override
    public Long getId() {
        
        return id;
    }

    public String getLectId() {
        return lectId;
    }

    public void setLectId(String lectId) {
        this.lectId = lectId;
    }

    public String getLectName() {
        return lectName;
    }

    public void setLectName(String lectName) {
        this.lectName = lectName;
    }


    public String getLectEmail() {
        return lectEmail;
    }

    public void setLectEmail(String lectEmail) {
        this.lectEmail = lectEmail;
    }

    public String getLectAddress() {
        return lectAddress;
    }

    public void setLectAddress(String lectAddress) {
        this.lectAddress = lectAddress;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

}