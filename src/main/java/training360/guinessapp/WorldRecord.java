package training360.guinessapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "world_record")
public class WorldRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Double value;

    @Column(name = "unit_of_measure")
    private String UnitOfMeasure;

    @Column(name = "date_of_record")
    private LocalDate dateOfRecord;

    @Column(name = "recorder_id")
    private Long recorderId;


    public WorldRecord(String description, Double value, String unitOfMeasure, LocalDate dateOfRecord, Long recorderId) {
        this.description = description;
        this.value = value;
        UnitOfMeasure = unitOfMeasure;
        this.dateOfRecord = dateOfRecord;
        this.recorderId = recorderId;
    }
}
