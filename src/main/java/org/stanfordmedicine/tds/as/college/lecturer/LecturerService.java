package org.stanfordmedicine.tds.as.college.lecturer;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.stanfordmedicine.tds.as.college.subject.Subject;
import org.stanfordmedicine.tds.as.college.subject.SubjectDto;
import org.stanfordmedicine.tds.as.college.subject.SubjectRepository;
import org.stanfordmedicine.tds.as.college.subject.SubjectService;

@Service
public class LecturerService {
    @Autowired
    private LecturerRepository lecturerRepository;
    // @Autowired
    // private SubjectService subjectService;
    

    public Lecturer createLecturer(LecturerDto lecturerDto) {
       Lecturer lecturer = new Lecturer();
       lecturer.setLectId(lecturerDto.getLectId());
       lecturer.setLectName(lecturerDto.getLectName());
       lecturer.setLectEmail(lecturerDto.getLectEmail());
       lecturer.setLectAddress(lecturerDto.getLectAddress());
       SubjectDto subjectDto = lecturerDto.getSubject();
       Subject subject = new Subject();
       subject.setSubId(subjectDto.getSubId());
       subject.setSubName(subjectDto.getSubName());
       lecturer.setSubject(subject);

       return lecturerRepository.save(lecturer);
    }


    public Page<Lecturer> getAllLecturer(@Min(1) @Valid Integer p, @Min(1) @Max(500) @Valid Integer ps, @Valid String s) {
        p = p-1;
        // lectId: asc
        Pageable paging = null;
        String[] sortingParameters = s.split(":");
  
        if(sortingParameters[1].equalsIgnoreCase("asc"))
          paging = PageRequest.of(p, ps, Sort.by(sortingParameters[0]).ascending());
        else if (sortingParameters[1].equalsIgnoreCase("desc"))
          paging = PageRequest.of(p, ps, Sort.by(sortingParameters[0]).descending());
        return lecturerRepository.findAll(paging);
    
    
    
    }


    // public  Lecturer getLecturerBySubject(Long id) {
    //   return lecturerRepository.findBySubjectId(id);
    // }


    public Lecturer getLecturerBySubject(Subject subject) {
      return lecturerRepository.findBySubjectId(subject.getId());
    }

  


   
   
    
}