package code.street.service.school;

import code.street.model.Residential;
import code.street.model.School;
import code.street.service.residential.ResidentialPrintable;

public class SchoolPrintableFullImpl implements SchoolPrintable {
    public void print(School school) {
        System.out.println("-------------------[School information]----------------");
        System.out.println("Address: " + school.getAddress());
        System.out.println("School Type: " + school.getType());
        System.out.println("Capacity: " + school.getCapacity());
        System.out.println("Students Count : " + school.getStudentsCount());
        System.out.println("-----------------[School information end]--------------");
    }
}
