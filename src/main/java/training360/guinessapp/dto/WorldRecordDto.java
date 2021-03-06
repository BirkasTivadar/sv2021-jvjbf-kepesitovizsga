package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorldRecordDto {

    private Long id;

    private String description;

    private Double value;

    private String UnitOfMeasure;

    private LocalDate dateOfRecord;

    private Long recorderId;

    private String recorderName;
}
