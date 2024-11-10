package code.street.service.hospital;

import code.street.enums.HospitalDepartment;
import code.street.model.Hospital;
import code.street.utils.UniqueAddressGenerator;

import java.util.Arrays;
import java.util.Random;

public class RandomHospitalImpl implements RandomHospital {
    private HospitalDepartment[] getRandomDepartments() {
        Random random = new Random();
        HospitalDepartment[] allHospitalDepartments = HospitalDepartment.values();

        // Перемешиваем массив
        for (int i = allHospitalDepartments.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            HospitalDepartment temp = allHospitalDepartments[i];
            allHospitalDepartments[i] = allHospitalDepartments[j];
            allHospitalDepartments[j] = temp;
        }

        int depCount = random.nextInt(1,10);
        return Arrays.copyOfRange(allHospitalDepartments, 0,
                Math.min(depCount, allHospitalDepartments.length));
    }


    @Override
    public Hospital getRandom(String address) {
        HospitalDepartment[] hospitalDepartments = getRandomDepartments();
        return new Hospital(address, hospitalDepartments, new HospitalPrintableFullImpl());
    }
}
