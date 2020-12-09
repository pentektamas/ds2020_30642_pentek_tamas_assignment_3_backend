package ds2020.assignment3.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import ds2020.assignment3.rpcConfiguration.MedicationPlanRMI;
import ds2020.assignment3.services.MedicationPlanService;
import ds2020.assignment3.services.MedicationTreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AutoJsonRpcServiceImpl
public class MedicationPlanController implements MedicationPlanRMI {

    private final MedicationPlanService medicationPlanService;
    private final MedicationTreatmentService medicationTreatmentService;

    @Autowired
    public MedicationPlanController(MedicationPlanService medicationPlanService, MedicationTreatmentService medicationTreatmentService) {
        this.medicationPlanService = medicationPlanService;
        this.medicationTreatmentService = medicationTreatmentService;
    }

    @Override
    public String getMedicationPlanByPatientId(UUID patientId) {
        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString(medicationPlanService.findMedicationPlanByPatientId(patientId));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println("Error when transforming JSON");
        }
        return result;
    }

    @Override
    public void sendTakenMedications(String takenTreatment) {
        medicationTreatmentService.insertMedicationTreatment(takenTreatment);
    }

    @Override
    public void updateTreatmentPeriod(UUID patientId) {
        medicationPlanService.updateMedicationPlan(patientId);
    }
}
