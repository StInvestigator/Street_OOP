package code.street.service.house;

import code.street.model.House;
import code.street.service.hospital.RandomHospital;
import code.street.service.residential.RandomResidential;
import code.street.service.school.RandomSchool;
import code.street.service.shop.RandomShop;

import java.util.Random;

public class RandomHouseImpl implements RandomHouse {
    private RandomHospital rHospital;
    private RandomResidential rResidential;
    private RandomSchool rSchool;
    private RandomShop rShop;

    public RandomHouseImpl(RandomHospital rHospital, RandomResidential rResidential,
                           RandomSchool rSchool, RandomShop rShop) {
        this.rHospital = rHospital;
        this.rResidential = rResidential;
        this.rSchool = rSchool;
        this.rShop = rShop;
    }


    @Override
    public House getRandom(String address) {
        Random random = new Random();
        return switch (random.nextInt(4)) {
            case 0 -> rHospital.getRandom(address);
            case 1 -> rResidential.getRandom(address);
            case 2 -> rSchool.getRandom(address);
            case 3 -> rShop.getRandom(address);
            default -> null;
        };
    }

    public void setRandomHospital(RandomHospital rHospital) {
        this.rHospital = rHospital;
    }

    public void setRandomResidential(RandomResidential rResidential) {
        this.rResidential = rResidential;
    }

    public void setRandomSchool(RandomSchool rSchool) {
        this.rSchool = rSchool;
    }

    public void setRandomShop(RandomShop rShop) {
        this.rShop = rShop;
    }
}
