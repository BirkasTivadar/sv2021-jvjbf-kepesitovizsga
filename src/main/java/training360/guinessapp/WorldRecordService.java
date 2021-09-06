package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import training360.guinessapp.dto.BeatWorldRecordDto;
import training360.guinessapp.dto.WorldRecordCreateCommand;
import training360.guinessapp.dto.WorldRecordDto;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class WorldRecordService {

    private ModelMapper modelMapper;

    private WorldRecordRepository repository;

    private RecorderRepository recorderRepository;

    public WorldRecordDto createWorldRecord(WorldRecordCreateCommand command) {
        String recorderName = recorderRepository.findById(command.getRecorderId()).orElseThrow(() -> new NotFoundException(command.getRecorderId()))
                .getName();
        WorldRecord worldRecord = new WorldRecord(command.getDescription(), command.getValue(), command.getUnitOfMeasure(), command.getDateOfRecord(), command.getRecorderId());
        repository.save(worldRecord);
        WorldRecordDto worldRecordDto = new WorldRecordDto(worldRecord.getId(), worldRecord.getDescription(), worldRecord.getValue(), worldRecord.getUnitOfMeasure(), worldRecord.getDateOfRecord(), worldRecord.getRecorderId(), recorderName);
        return worldRecordDto;
    }

    @Transactional
    public BeatWorldRecordDto beatWorldRecord(long recorderId, Long worldRecordId, Double newWorldRecord) {
        Recorder newRecorder = recorderRepository.findById(recorderId).orElseThrow(() -> new IllegalArgumentException("Recorder not found"));
        WorldRecord worldRecord = repository.findById(worldRecordId).orElseThrow(() -> new IllegalArgumentException("World record not found"));
        if (newWorldRecord < worldRecord.getValue()) {
            throw new IllegalArgumentException("Can not beat");
        }
        String oldRecorderName = recorderRepository.findById(worldRecord.getRecorderId()).orElseThrow(() -> new IllegalArgumentException()).getName();
        Double oldWorldRecord = worldRecord.getValue();
        Double difference = newWorldRecord - oldWorldRecord;

        setNewWorldRecord(recorderId, newWorldRecord, worldRecord);

        BeatWorldRecordDto beatWorldRecordDto = new BeatWorldRecordDto(worldRecord.getDescription(), worldRecord.getUnitOfMeasure(), oldRecorderName, oldWorldRecord, newRecorder.getName(), newWorldRecord, difference);
        return beatWorldRecordDto;
    }

    private void setNewWorldRecord(long recorderId, Double newWorldRecord, WorldRecord worldRecord) {
        worldRecord.setRecorderId(recorderId);
        worldRecord.setDateOfRecord(LocalDate.now());
        worldRecord.setValue(newWorldRecord);
    }
}
