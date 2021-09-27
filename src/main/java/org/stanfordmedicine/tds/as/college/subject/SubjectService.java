package org.stanfordmedicine.tds.as.college.subject;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stanfordmedicine.tds.as.college.lecturer.Lecturer;
import org.stanfordmedicine.tds.as.college.lecturer.LecturerService;

@Service
public class SubjectService {
@Autowired
SubjectRepository subjectRepository;
@Autowired
LecturerService lecturerService;


private Optional<Subject> getSubjectById(Long id) {
   return subjectRepository.findById(id);
   
}

public Lecturer getLecturerBySubjectId(Long id) {

     Optional<Subject> subject = getSubjectById(id);
    return lecturerService.getLecturerBySubject(subject.get());
    

}


    

    
}