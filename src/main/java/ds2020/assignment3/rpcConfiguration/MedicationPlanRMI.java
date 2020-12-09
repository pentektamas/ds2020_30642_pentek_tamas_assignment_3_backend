package ds2020.assignment3.rpcConfiguration;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;

import java.util.UUID;

@JsonRpcService("/medi")
public interface MedicationPlanRMI {

    String getMedicationPlanByPatientId(@JsonRpcParam(value = "patientId") UUID patientId);

    void sendTakenMedications(@JsonRpcParam(value = "takenTreatment") String takenTreatment);

    void updateTreatmentPeriod(@JsonRpcParam(value = "patientId") UUID patientId);
}
