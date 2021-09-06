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

    private String UnitOfMeasure;

    private LocalDate dateOfRecord;

   private Long recorderId;


    public WorldRecord(String description, Double value, String unitOfMeasure, LocalDate dateOfRecord, Long recorderId) {
        this.description = description;
        this.value = value;
        UnitOfMeasure = unitOfMeasure;
        this.dateOfRecord = dateOfRecord;
        this.recorderId = recorderId;
    }
}
