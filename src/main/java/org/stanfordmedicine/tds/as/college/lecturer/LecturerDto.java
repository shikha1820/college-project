package org.stanfordmedicine.tds.as.college.lecturer;

import org.stanfordmedicine.tds.as.college.subject.SubjectDto;
import org.stanfordmedicine.tds.as.foundation.dto.ResourceDto;

public class LecturerDto extends ResourceDto {
    private String lectId;
    private String lectName;
    private String lectEmail;
    private String lectAddress;
    private SubjectDto subject;
    

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


    public SubjectDto getSubject() {
        return subject;
    }

    public void setSubject(SubjectDto subject) {
        this.subject = subject;
    }

}