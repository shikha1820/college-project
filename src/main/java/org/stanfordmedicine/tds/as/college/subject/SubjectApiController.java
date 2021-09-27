package org.stanfordmedicine.tds.as.college.subject;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stanfordmedicine.tds.as.college.api.SubjectsApi;
import org.stanfordmedicine.tds.as.college.lecturer.LecturerDto;
import org.stanfordmedicine.tds.as.college.lecturer.LecturerDtoAssembler;

import io.swagger.annotations.Api;

@Api(tags = "Subject Api")
@RestController
@RequestMapping("/api/v1")
public class SubjectApiController implements SubjectsApi {
    @Autowired
    SubjectService subjectService;
    @Autowired
    LecturerDtoAssembler lecturerDtoAssembler;
    @Override
    public ResponseEntity<LecturerDto> subjectsIdLecturersGet(Long id) {
        
      return new ResponseEntity<LecturerDto>(lecturerDtoAssembler.toResource(subjectService.getLecturerBySubjectId(id)), HttpStatus.OK);
    }



   
 
   
    
}