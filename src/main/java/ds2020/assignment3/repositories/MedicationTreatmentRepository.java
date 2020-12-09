package ds2020.assignment3.repositories;

import ds2020.assignment3.entities.MedicationTreatment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicationTreatmentRepository extends JpaRepository<MedicationTreatment, UUID> {
}
