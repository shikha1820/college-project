package org.stanfordmedicine.tds.as.college.lecturer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer,Long> {

    Lecturer findBySubjectId(Long id);

  
 
    
}