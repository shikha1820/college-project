package org.stanfordmedicine.tds.as.college.student;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.stanfordmedicine.tds.as.college.enrollment.Enrollment;
import org.stanfordmedicine.tds.as.foundation.data.jpa.AbstractAuditingEntity;

@Entity
@Table(name = Student.TABLE_NAME )
class Student extends AbstractAuditingEntity<Long> {
    public static final String TABLE_NAME = "STUDENTS";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "S_ID")
    private String sId;
    @Column(name = "S_NAME")
    private String sName;
    @Column(name = "S_ADDRESS")
    private String sAddress;
    @Column(name = "S_BDATE")
    private String sBdate;   
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "C_ID", referencedColumnName = "COURSE_ID")
    private Enrollment enroll;

    @Override
    public void setId(Long id) {
        this.id = id;
        
    }

    @Override
    public Long getId() {
       
        return id;
    }

    public String getSId() {
        return sId;
    }

    
    public void setSId(String sId) {
        this.sId = sId;
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

  
    public Enrollment getEnroll() {
        return enroll;
    }

  
    public void setEnroll(Enrollment enroll) {
        this.enroll = enroll;
    }

}