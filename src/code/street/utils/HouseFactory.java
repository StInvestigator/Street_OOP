package code.street.utils;

import code.street.model.House;
import code.street.service.house.RandomHouse;

public class HouseFactory {
    private RandomHouse randomHouse;

    public HouseFactory(RandomHouse randomHouse) {
        this.randomHouse = randomHouse;
    }

    public House createHouse(String address){
        return randomHouse.getRandom(address);
    }


    public void setRandomHouse(RandomHouse randomHouse) {
        this.randomHouse = randomHouse;
    }
}
