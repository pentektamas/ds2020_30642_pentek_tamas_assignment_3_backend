package ds2020.assignment3.repositories;

import ds2020.assignment3.entities.MedicationPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicationPlanRepository extends JpaRepository<MedicationPlan, UUID> {

}
