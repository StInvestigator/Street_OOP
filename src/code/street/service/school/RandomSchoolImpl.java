package code.street.service.school;

import code.street.enums.SchoolType;
import code.street.model.School;
import code.street.utils.UniqueAddressGenerator;

import java.util.Random;

public class RandomSchoolImpl implements RandomSchool {

    @Override
    public School getRandom(String address) {
        Random rand = new Random();
        int maxStudents;
        SchoolType schoolType = SchoolType.values()[rand.nextInt(0, SchoolType.values().length)];
        maxStudents = switch (schoolType) {
            case GENERAL_EDUCATION -> 500;
            case GYMNASIUM -> 300;
            case LYCEUM -> 200;
            case TECHNICAL_SCHOOL -> 400;
        };
        return new School(address, rand.nextInt(maxStudents / 2, maxStudents), maxStudents,
                schoolType, new SchoolPrintableFullImpl());
    }
}
