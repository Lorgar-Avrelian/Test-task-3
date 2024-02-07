package test.task.crptapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

public class Description {
    @Schema(example = "string", description = "ИНН поставщика")
    private String participantInn;

    public Description() {
    }

    public Description(String participantInn) {
        this.participantInn = participantInn;
    }

    public String getParticipantInn() {
        return participantInn;
    }

    public void setParticipantInn(String participantInn) {
        this.participantInn = participantInn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return Objects.equals(participantInn, that.participantInn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantInn);
    }

    @Override
    public String toString() {
        return "Description{" +
                "participantInn='" + participantInn + '\'' +
                '}';
    }
}
