package ds2020.assignment3.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class MedicationTreatment implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;
    @Column(name = "patientID", nullable = false)
    private UUID patientID;
    @Column(name = "medication", nullable = false)
    private String medicationName;
    @Column(name = "date", nullable = false)
    private LocalDateTime takenDate;
    @Column(name = "taken", nullable = false)
    private String taken;

    public MedicationTreatment() {

    }

    public MedicationTreatment(UUID id, UUID patientID, String medicationName, LocalDateTime takenDate, String taken) {
        this.id = id;
        this.patientID = patientID;
        this.medicationName = medicationName;
        this.takenDate = takenDate;
        this.taken = taken;
    }

    public MedicationTreatment(UUID patientID, String medicationName, LocalDateTime takenDate, String taken) {
        this.patientID = patientID;
        this.medicationName = medicationName;
        this.takenDate = takenDate;
        this.taken = taken;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPatientID() {
        return patientID;
    }

    public void setPatientID(UUID patientID) {
        this.patientID = patientID;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public LocalDateTime getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(LocalDateTime takenDate) {
        this.takenDate = takenDate;
    }

    public String getTaken() {
        return taken;
    }

    public void setTaken(String taken) {
        this.taken = taken;
    }
}
