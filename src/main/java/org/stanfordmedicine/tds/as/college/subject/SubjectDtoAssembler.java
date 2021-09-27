package org.stanfordmedicine.tds.as.college.subject;

import org.springframework.stereotype.Component;
import org.stanfordmedicine.tds.as.college.lecturer.LecturerApiController;
import org.stanfordmedicine.tds.as.foundation.dto.EntityAwareDtoAssembler;
import org.stanfordmedicine.tds.as.foundation.dto.ViewType;
@Component
public class SubjectDtoAssembler extends EntityAwareDtoAssembler<Subject, SubjectDto>{

    public SubjectDtoAssembler() {
        super(LecturerApiController.class, SubjectDto.class);
        
    }

    @Override
    protected SubjectDto toResource(Subject arg0, SubjectDto arg1, ViewType arg2) {
       arg1.setSubId(arg0.getSubId());
       arg1.setSubName(arg0.getSubName());

        return arg1;
    }
    
}