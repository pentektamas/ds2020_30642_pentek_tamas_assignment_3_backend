package ds2020.assignment3.services;

import ds2020.assignment3.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ds2020.assignment3.dtos.MedicationPlanDTO;
import ds2020.assignment3.dtos.builders.MedicationPlanBuilder;
import ds2020.assignment3.entities.MedicationPlan;
import ds2020.assignment3.entities.Patient;
import ds2020.assignment3.repositories.MedicationPlanRepository;
import ds2020.assignment3.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MedicationPlanService {

    private final MedicationPlanRepository medicationPlanRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public MedicationPlanService(MedicationPlanRepository medicationPlanRepository, PatientRepository patientRepository) {
        this.medicationPlanRepository = medicationPlanRepository;
        this.patientRepository = patientRepository;
    }

    public MedicationPlanDTO findMedicationPlanById(UUID medicationPlanId) {
        Optional<MedicationPlan> foundMedicationPlan = medicationPlanRepository.findById(medicationPlanId);
        if (!foundMedicationPlan.isPresent()) {
            throw new ResourceNotFoundException(MedicationPlan.class.getSimpleName() + " with id: " + medicationPlanId);
        }
        return MedicationPlanBuilder.toMedicationPlanDTO(foundMedicationPlan.get());
    }

    public MedicationPlanDTO findMedicationPlanByPatientId(UUID patientId) {
        Optional<Patient> foundPatient = patientRepository.findById(patientId);
        if (!foundPatient.isPresent()) {
            throw new ResourceNotFoundException(Patient.class.getSimpleName() + " with id: " + patientId);
        }

        MedicationPlan medicationPlan = foundPatient.get().getMedicationPlan();
        return MedicationPlanBuilder.toMedicationPlanDTO(medicationPlan);
    }


    public void updateMedicationPlan(UUID patientID) {
        MedicationPlan currentPlan = MedicationPlanBuilder.toMedicationPlanEntity(findMedicationPlanByPatientId(patientID));

        if (currentPlan.getTreatmentPeriod() >= 1) {
            currentPlan.setTreatmentPeriod(currentPlan.getTreatmentPeriod() - 1);
            medicationPlanRepository.save(currentPlan);
        }
    }
}
