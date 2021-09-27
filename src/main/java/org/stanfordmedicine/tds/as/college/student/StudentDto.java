package org.stanfordmedicine.tds.as.college.student;

import org.stanfordmedicine.tds.as.college.enrollment.EnrollmentDto;
import org.stanfordmedicine.tds.as.foundation.dto.ResourceDto;


public class StudentDto extends ResourceDto{
    private String sid;
    private String sName;
    private String sAddress;
    private String sBdate;
    private EnrollmentDto enroll;
    

   

    public String getSid() {
        return sid;
    }

   
    public void setSid(String sid) {
        this.sid = sid;
    }

    
    public String getSName() {
        return sName;
    }

    
    public void setSName(String sName) {
        this.sName = sName;
    }

 
    public String getSAddress() {
        return sAddress;
    }

    public void setSAddress(String sAddress) {
        this.sAddress = sAddress;
    }

  
    public String getSBdate() {
        return sBdate;
    }

    public void setSBdate(String sBdate) {
        this.sBdate = sBdate;
    }

   
    public EnrollmentDto getEnroll() {
        return enroll;
    }

    public void setEnroll(EnrollmentDto enroll) {
        this.enroll = enroll;
    }

}