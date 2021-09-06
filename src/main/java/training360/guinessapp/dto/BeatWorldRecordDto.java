package training360.guinessapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeatWorldRecordDto {

    private String description;

    private String UnitOfMeasure;

    private String oldRecorderName;

    private Double oldRecordValue;

    private String newRecorderName;

    private double newRecordValue;

    private double recordDifference;

}
