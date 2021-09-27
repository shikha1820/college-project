package org.stanfordmedicine.tds.as.college.student;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stanfordmedicine.tds.as.college.api.StudentsApi;
import org.stanfordmedicine.tds.as.foundation.dto.PagedResultDto;
import org.stanfordmedicine.tds.as.foundation.dto.ViewType;

import io.swagger.annotations.Api;

@Api(tags = {"Student API"})
@RestController
@RequestMapping("/api/v1")

public class StudentApiController implements StudentsApi {

@Autowired
StudentService studentService;
@Autowired
StudentDtoAssembler studentDtoAssembler;


@Override
public ResponseEntity<StudentDto> studentsPost(StudentDto dto) {
    return new ResponseEntity<>(
        studentDtoAssembler.toResource(studentService.createStudent(dto)),
        HttpStatus.CREATED);
}


@Override
public ResponseEntity<PagedResultDto> studentsGet(@Min(1) @Valid Integer p, @Min(1) @Max(500) @Valid Integer ps,
        @Valid String s) {
   
    List<StudentDto> studentDtos = new ArrayList<>();
    ControllerLinkBuilder controllerLinkBuilder = ControllerLinkBuilder.linkTo(StudentApiController.class);
    return new ResponseEntity<>(studentDtoAssembler.toResource(controllerLinkBuilder,studentService.getAllStudents(p,ps,s),studentDtos, ViewType.BRIEF), HttpStatus.OK);
}


@Override
public ResponseEntity<StudentDto> studentsIdGet(Long id) {
   
    return new ResponseEntity<>(studentDtoAssembler.toResource(studentService.getStudentById(id)) ,HttpStatus.OK);
}


@Override
public ResponseEntity<StudentDto> studentsIdPut(Long id, StudentDto dto) {
 
    return new ResponseEntity<>(studentDtoAssembler.toResource(studentService.upadateStudent(id, dto)),HttpStatus.OK);
}




    
}