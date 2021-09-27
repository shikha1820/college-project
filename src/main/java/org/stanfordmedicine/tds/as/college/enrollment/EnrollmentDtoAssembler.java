package org.stanfordmedicine.tds.as.college.enrollment;

import org.springframework.stereotype.Component;
import org.stanfordmedicine.tds.as.college.student.StudentApiController;
import org.stanfordmedicine.tds.as.foundation.dto.EntityAwareDtoAssembler;
import org.stanfordmedicine.tds.as.foundation.dto.ViewType;

@Component
public class EnrollmentDtoAssembler extends EntityAwareDtoAssembler <Enrollment, EnrollmentDto>{

    public EnrollmentDtoAssembler() {
        super(StudentApiController.class, EnrollmentDto.class);
        
    }

    @Override
    protected EnrollmentDto toResource(Enrollment arg0, EnrollmentDto arg1, ViewType arg2) {
       arg1.setCourseName(arg0.getCourseName());
       arg1.setDateOfEnroll(arg0.getDateOfEnroll());
        return arg1;
    }
    
}