package org.stanfordmedicine.tds.as.college.lecturer;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stanfordmedicine.tds.as.college.api.LecturersApi;
import org.stanfordmedicine.tds.as.foundation.dto.PagedResultDto;
import org.stanfordmedicine.tds.as.foundation.dto.ViewType;

import io.swagger.annotations.Api;

@Api(tags = {"Lecturer API"})
@RestController
@RequestMapping("/api/v1")
public class LecturerApiController implements LecturersApi{
    @Autowired
    LecturerService lecturerService;
    @Autowired
    LecturerDtoAssembler lecturerDtoAssembler;
    
    @Override
    public ResponseEntity<LecturerDto> lecturersPost(LecturerDto lecturerDto) {
        
        return new ResponseEntity<>(lecturerDtoAssembler.toResource(lecturerService.createLecturer(lecturerDto)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PagedResultDto> lecturersGet(@Min(1) @Valid Integer p, @Min(1) @Max(500) @Valid Integer ps,
            @Valid String s) {
                List<LecturerDto> lecturerDtos = new ArrayList<>();
                ControllerLinkBuilder controllerLinkBuilder = ControllerLinkBuilder.linkTo(LecturerApiController.class);
                return new ResponseEntity<>(lecturerDtoAssembler.toResource(controllerLinkBuilder,lecturerService.getAllLecturer(p,ps,s),lecturerDtos, ViewType.BRIEF), HttpStatus.OK);
            }
                
        
      

    // @Override
    // public ResponseEntity<LecturerDto> lecturersIdGet(Long id) {
      
    //     return new ResponseEntity<>(lecturerDtoAssembler.toResource(lecturerService.getLecturerById(id)), HttpStatus.CREATED);
    // };
    // }
    
}