package code.street.service.residential;

import code.street.model.Hospital;
import code.street.model.Residential;
import code.street.service.hospital.HospitalPrintable;

import java.util.Arrays;

public class ResidentialPrintableFullImpl implements ResidentialPrintable {
    public void print(Residential residential) {
        System.out.println("-------------------[Residential information]----------------");
        System.out.println("Address: " + residential.getAddress());
        System.out.println("Capacity: " + residential.getCapacity());
        System.out.println("Current Residents Count : " + residential.getCurrentResidentsCount());
        System.out.println("-----------------[Residential information end]--------------");
    }
}
