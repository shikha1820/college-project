package org.stanfordmedicine.tds.as.college.lecturer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;
import org.stanfordmedicine.tds.as.college.subject.SubjectDtoAssembler;
import org.stanfordmedicine.tds.as.foundation.dto.EntityAwareDtoAssembler;
import org.stanfordmedicine.tds.as.foundation.dto.PagedResultDto;
import org.stanfordmedicine.tds.as.foundation.dto.ViewType;

@Component
public class LecturerDtoAssembler extends EntityAwareDtoAssembler<Lecturer, LecturerDto> {
    @Autowired
    SubjectDtoAssembler subjectDtoAssembler;

    public LecturerDtoAssembler() {
        super(LecturerApiController.class, LecturerDto.class);
    }

    @Override
    protected LecturerDto toResource(Lecturer entity, LecturerDto dto, ViewType arg2) {
      dto.setLectId(entity.getLectId());
      dto.setLectName(entity.getLectName());
      dto.setLectEmail(entity.getLectEmail());
      dto.setLectAddress(entity.getLectAddress());
      dto.setSubject(subjectDtoAssembler.toResource( entity.getSubject()));
     
      return dto;
    }

    @Override
    public PagedResultDto<LecturerDto> toResource(ControllerLinkBuilder arg0, Page<Lecturer> arg1, List<LecturerDto> arg2,
            ViewType arg3) {
        
        arg2 = arg1.stream().map(student-> toResource(student)).collect(Collectors.toList());
        
        return super.toResource(arg0, arg1, arg2, arg3);
    }
    
}