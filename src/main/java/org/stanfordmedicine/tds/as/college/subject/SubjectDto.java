package org.stanfordmedicine.tds.as.college.subject;

import org.stanfordmedicine.tds.as.foundation.dto.ResourceDto;

public class SubjectDto extends ResourceDto {
    private String subId;
    private String subName;
         

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