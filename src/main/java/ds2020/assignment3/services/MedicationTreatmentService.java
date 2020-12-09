package ds2020.assignment3.services;

import ds2020.assignment3.entities.MedicationTreatment;
import ds2020.assignment3.repositories.MedicationTreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class MedicationTreatmentService {

    private final MedicationTreatmentRepository medicationTreatmentRepository;

    @Autowired
    public MedicationTreatmentService(MedicationTreatmentRepository medicationTreatmentRepository) {
        this.medicationTreatmentRepository = medicationTreatmentRepository;
    }


    public void insertMedicationTreatment(String treatment) {
        MedicationTreatment medicationTreatment = unpackTreatmentJSON(treatment);
        medicationTreatmentRepository.save(medicationTreatment);

    }

    private MedicationTreatment unpackTreatmentJSON(String treatment) {
        MedicationTreatment medicationTreatment = null;
        try {
            JSONObject treatmentObject = new JSONObject(treatment);
            UUID patientID = UUID.fromString(treatmentObject.getString("patientID"));
            String medication = treatmentObject.getString("medicationName");
            LocalDateTime date = LocalDateTime.parse(treatmentObject.getString("takenDate"));
            String taken = treatmentObject.getString("taken");
            medicationTreatment = new MedicationTreatment(patientID, medication, date, taken);
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("JSON Exception!");
        }
        return medicationTreatment;
    }

}
