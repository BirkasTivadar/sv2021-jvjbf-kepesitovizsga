package training360.guinessapp;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class NotFoundException extends AbstractThrowableProblem {
    public NotFoundException(Long id) {
        super(
                URI.create("/api/worldrecords"),
                "Recorder not found",
                Status.NOT_FOUND,
                String.format("Not found with id: %d", id)
        );
    }
}
