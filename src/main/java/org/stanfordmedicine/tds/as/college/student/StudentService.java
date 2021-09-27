package org.stanfordmedicine.tds.as.college.student;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.stanfordmedicine.tds.as.college.enrollment.Enrollment;
import org.stanfordmedicine.tds.as.college.enrollment.EnrollmentDto;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    
    public Student createStudent(StudentDto studentDto){
        Student stud = new Student();
        stud.setSId(studentDto.getSid());
        stud.setSName(studentDto.getSName());
        stud.setSAddress(studentDto.getSAddress());
        stud.setSBdate(studentDto.getSBdate());
        EnrollmentDto enrollmentDto = studentDto.getEnroll();
        Enrollment enroll = new Enrollment();
        enroll.setDateOfEnroll(enrollmentDto.getDateOfEnroll());
        enroll.setCourseName(enrollmentDto.getCourseName());
        stud.setEnroll(enroll);
        
        return studentRepository.save(stud);
    }

// return all Students in pagination 
    public Page<Student> getAllStudents(@Min(1) @Valid Integer p, @Min(1) @Max(500) @Valid Integer ps, @Valid String s) {
   
      p = p-1;
      // sId: asc
      Pageable paging = null;
      String[] sortingParameters = s.split(":");

      if(sortingParameters[1].equalsIgnoreCase("asc"))
        paging = PageRequest.of(p, ps, Sort.by(sortingParameters[0]).ascending());
      else if (sortingParameters[1].equalsIgnoreCase("desc"))
        paging = PageRequest.of(p, ps, Sort.by(sortingParameters[0]).descending());
      return studentRepository.findAll(paging);

   
    }

    public Student getStudentById(Long id) { 
        return studentRepository.findById(id).get();
        
}

    public Student upadateStudent(Long id, StudentDto dto) {
       Student stud = getStudentById(id);
       stud.setSId(dto.getSid());
       stud.setSName(dto.getSName());
       stud.setSAddress(dto.getSAddress());
       stud.setSBdate(dto.getSBdate());
       return studentRepository.save(stud);

   }

}