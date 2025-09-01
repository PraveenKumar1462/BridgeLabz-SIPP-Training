package Day1_LambdaExpressions;

import java.util.Arrays;
import java.util.List;

public class HospitalPatientIDPrinting {
    public static void main(String[] args) {
        List<String> patientIDs = Arrays.asList("P001", "P002", "P003", "P004");


        patientIDs.forEach(System.out::println);
    }
}
