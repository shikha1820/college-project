package org.stanfordmedicine.tds.as.college.student;

import java.util.List;

import java.util.stream.Collectors;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;
import org.stanfordmedicine.tds.as.college.enrollment.EnrollmentDtoAssembler;
import org.stanfordmedicine.tds.as.foundation.dto.EntityAwareDtoAssembler;
import org.stanfordmedicine.tds.as.foundation.dto.PagedResultDto;
import org.stanfordmedicine.tds.as.foundation.dto.ViewType;
@Component
public class StudentDtoAssembler extends EntityAwareDtoAssembler<Student, StudentDto>{
@Autowired
EnrollmentDtoAssembler enrollmentDtoAssembler;

    public StudentDtoAssembler() {
        super(StudentApiController.class, StudentDto.class);
       
    }

    @Override
    protected StudentDto toResource(Student entity, StudentDto dto, ViewType arg2) {

        ControllerLinkBuilder link = linkTo(methodOn(StudentApiController.class).studentsIdGet(entity.getId()));
        Link selfLink = link.withSelfRel().expand(entity.getId());
        dto.add(selfLink);
        
        dto.setSid(entity.getSId());
        dto.setSName(entity.getSName());
        dto.setSAddress(entity.getSAddress());
        dto.setSBdate(entity.getSBdate());
        dto.setEnroll(enrollmentDtoAssembler.toResource(entity.getEnroll()));
        return dto;
    }

    @Override
    public PagedResultDto<StudentDto> toResource(ControllerLinkBuilder arg0, Page<Student> arg1, List<StudentDto> arg2,
            ViewType arg3) {
        
        arg2 = arg1.stream().map(student-> toResource(student)).collect(Collectors.toList());
        
        return super.toResource(arg0, arg1, arg2, arg3);
    }
    
}