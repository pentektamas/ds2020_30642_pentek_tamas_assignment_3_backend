package ds2020.assignment3.repositories;

import ds2020.assignment3.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {

    Optional<Patient> findPatientByAccount_Id(UUID accountID);
}
