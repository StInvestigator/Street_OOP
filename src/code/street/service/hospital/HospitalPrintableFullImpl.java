package code.street.service.hospital;

import code.street.model.Hospital;

import java.util.Arrays;

public class HospitalPrintableFullImpl implements HospitalPrintable {
    public void print(Hospital hospital){
        System.out.println("-------------------[Hospital information]----------------");
        System.out.println("Address: " + hospital.getAddress());
        System.out.println("Departments: " + Arrays.toString(hospital.getDepartments()));
        System.out.println("-----------------[Hospital information end]--------------");
    }
}
