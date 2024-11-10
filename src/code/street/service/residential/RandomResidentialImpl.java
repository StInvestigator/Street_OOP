package code.street.service.residential;

import code.street.model.Residential;
import code.street.utils.UniqueAddressGenerator;

import java.util.Random;

public class RandomResidentialImpl implements RandomResidential {
    @Override
    public Residential getRandom(String address) {
        Random rand = new Random();
        int capacity = rand.nextInt(2, 200);
        int currentResidential = rand.nextInt(capacity/2-1,capacity);

        return new Residential(address, currentResidential, capacity, new ResidentialPrintableFullImpl());
    }
}
