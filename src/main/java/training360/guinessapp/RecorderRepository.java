package training360.guinessapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import training360.guinessapp.dto.RecorderShortDto;

import java.util.List;

public interface RecorderRepository extends JpaRepository<Recorder, Long> {

    @Query("select r from Recorder r where r.name like 'B%' or r.name like '%e%' order by r.dateOfBirth desc")
    List<Recorder> getRecorders();
}
