package ds2020.assignment3.repositories;

import ds2020.assignment3.entities.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicationRepository extends JpaRepository<Medication, UUID> {
}
