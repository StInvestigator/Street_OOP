package code.street.model;

import code.street.service.hospital.RandomHospitalImpl;
import code.street.service.house.RandomHouse;
import code.street.service.house.RandomHouseImpl;
import code.street.service.residential.RandomResidentialImpl;
import code.street.service.school.RandomSchoolImpl;
import code.street.service.shop.RandomShopStaticArrImpl;
import code.street.utils.HouseFactory;
import code.street.utils.MyJsonParser;
import code.street.utils.UniqueAddressGenerator;

import java.util.*;

public class Street {
    private final String name;
    private House[] houses;
    private int housesCount = 0;

    public Street(String name, House[] houses) {
        this.name = name;
        this.houses = houses;
        this.housesCount = houses.length;
        sortHouses();
    }

    public Street(String name, int housesCount) {
        this.name = name;
        houses = new House[housesCount];
        for (int i = 0; i < housesCount; i++) {
            HouseFactory factory = new HouseFactory(new RandomHouseImpl(
                    new RandomHospitalImpl(),
                    new RandomResidentialImpl(),
                    new RandomSchoolImpl(),
                    new RandomShopStaticArrImpl()
            ));

            House newHouse = factory.createHouse(UniqueAddressGenerator.getUniqueAddress(getAddresses()));
            houses[i] = newHouse;
            this.housesCount++;
        }
        sortHouses();
    }

    private void sortHouses() {
        Arrays.sort(houses, Comparator.comparingDouble(House::addressComparator));
    }

    public void print() {
        for (House house : houses) {
            house.print();
        }
    }

    public void addRandomHouse(RandomHouse randomHouse, String prevAddress) {
        houses = Arrays.copyOf(houses, houses.length + 1);
        houses[houses.length - 1] = randomHouse.getRandom(UniqueAddressGenerator.
                getUniqueAddress(getAddresses(), prevAddress));
        sortHouses();
    }

    public void addRandomHouse(RandomHouse randomHouse) {
        addRandomHouse(randomHouse, "");
    }

    public void addHouse(House house) {
        Set<String> addressSet = new HashSet<String>(Arrays.asList(getAddresses()));
        if (addressSet.contains(house.getAddress())) {
            house.setAddress(UniqueAddressGenerator.getUniqueAddress(getAddresses(), house.getAddress()));
        }
        houses = Arrays.copyOf(houses, houses.length + 1);
        houses[houses.length - 1] = house;
        sortHouses();
    }

    public void removeHouse(String address) {
        Set<String> addressSet = new HashSet<String>(Arrays.asList(getAddresses()));
        if (!addressSet.contains(address)) {
            throw new IllegalArgumentException("ERROR: There is no such address on this street");
        }
        House[] result = new House[houses.length - 1];
        int j = 0;
        for (int i = 0; i < houses.length; i++, j++) {
            if (houses[i].getAddress().equals(address)) {
                j--;
                continue;
            }
            result[j] = houses[i];
        }
        houses = result;
    }

    public void addByJson(String json) {
        String houseType = MyJsonParser.extractValue(json, "houseType");
        if (!houseType.equals("hospital") && !houseType.equals("residential")
                && !houseType.equals("school") && !houseType.equals("shop")) {
            throw new IllegalArgumentException("Invalid house type: " + houseType);
        }
        String address = MyJsonParser.extractValue(json, "address");

        Set<String> addressSet = new HashSet<String>(Arrays.asList(getAddresses()));
        if (addressSet.contains(address)) {
            char suffix = 'a';
            while (addressSet.contains(address + suffix)) {
                suffix++;
            }
            address += suffix;
            int startIndex = json.indexOf("\"address\"") + "\"address\"".length();
            startIndex = json.indexOf(":", startIndex) + 2;
            json = json.replaceAll("(\"address\":\")[^\"]*(\")", "$1" + address + "$2");
        }

        houses = Arrays.copyOf(houses, houses.length + 1);
        switch (houseType) {
            case "hospital" -> houses[houses.length - 1] = new Hospital(json);
            case "residential" -> houses[houses.length - 1] = new Residential(json);
            case "school" -> houses[houses.length - 1] = new School(json);
            case "shop" -> houses[houses.length - 1] = new Shop(json);
        }
        sortHouses();
        housesCount++;
    }

    public String[] getAddresses() {
        String[] addresses = new String[housesCount];
        for (int i = 0; i < housesCount; i++) {
            addresses[i] = houses[i].getAddress();
        }
        return addresses;
    }

    public String getName() {
        return name;
    }

    public House[] getHouses() {
        return houses;
    }

    public int getHousesCount() {
        return housesCount;
    }
}
