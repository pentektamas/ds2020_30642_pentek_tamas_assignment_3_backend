package ds2020.assignment3.dtos.builders;

import ds2020.assignment3.dtos.MedicationDTO;
import ds2020.assignment3.entities.Medication;

public class MedicationBuilder {

    private MedicationBuilder() {

    }

    public static MedicationDTO toMedicationDTO(Medication medication) {
        return new MedicationDTO(medication.getId(), medication.getName(), medication.getSideEffects(), medication.getDosage());
    }

    public static Medication toMedicationEntity(MedicationDTO medicationDTO) {
        return new Medication(medicationDTO.getId(), medicationDTO.getName(), medicationDTO.getSideEffects(), medicationDTO.getDosage());
    }
}
