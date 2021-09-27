package org.stanfordmedicine.tds.as.college.subject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.stanfordmedicine.tds.as.foundation.data.jpa.AbstractAuditingEntity;

@Entity
@Table(name = Subject.TABLE_NAME)
public class Subject extends AbstractAuditingEntity<Long>{
    public static final String TABLE_NAME = "SUBJECTS";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "S_ID")
    private Long id;

    @Column(name = "SUB_ID")
    private String subId;
    @Column(name = "SUB_NAME")
    private String subName;
    

    @Override
    public void setId(Long id) {
       this.id = id;
        
    }

    @Override
    public Long getId() {
       
        return id;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

}