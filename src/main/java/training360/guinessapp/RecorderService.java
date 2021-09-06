package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.dto.RecorderShortDto;

import java.util.List;

@Service
@AllArgsConstructor
public class RecorderService {

    private ModelMapper modelMapper;

    private RecorderRepository repository;


    public RecorderDto createRecorder(RecorderCreateCommand command) {
        Recorder recorder = new Recorder(command.getName(), command.getDateOfBirth());
        repository.save(recorder);
        return modelMapper.map(recorder, RecorderDto.class);
    }

    public List<RecorderShortDto> getRecorders() {
        return repository.getRecorders().stream()
                .map(recorder -> modelMapper.map(recorder, RecorderShortDto.class))
                .toList();
    }
}
