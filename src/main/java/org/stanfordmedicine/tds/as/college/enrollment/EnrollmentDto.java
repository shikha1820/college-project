package org.stanfordmedicine.tds.as.college.enrollment;

import org.stanfordmedicine.tds.as.foundation.dto.ResourceDto;

public class EnrollmentDto extends ResourceDto{
    private String dateOfEnroll;
    private String courseName;

   
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