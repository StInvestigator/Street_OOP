package code.street.service.street;

import code.street.enums.ShopDepartment;
import code.street.model.House;
import code.street.model.Residential;
import code.street.model.Shop;
import code.street.model.Street;

import java.util.Arrays;
import java.util.Random;

public class StreetService {
    private final Street street;

    public StreetService(Street street) {
        this.street = street;
    }

    public Street getStreet() {
        return street;
    }

    public House[] findShopsByDepartment(int searchRadius, ShopDepartment shopDepartment) {
        int counter = 0;

        for (int i = 0; i < street.getHousesCount(); i++) {
            if (street.getHouses()[i] instanceof Residential) {
                counter++;
            }
        }

        Random random = new Random();
        int randomNum = random.nextInt(counter);
        counter = 0;

        for (int i = 0; i < street.getHousesCount(); i++) {
            if (street.getHouses()[i] instanceof Residential) {
                if (randomNum == counter) {
                    counter = i;
                    break;
                }
                counter++;
            }
        }

        int shopCounter = 0;

        for (int i = Math.max(counter - searchRadius, 0); i < Math.min(counter + searchRadius, street.getHousesCount()); i++) {
            if (street.getHouses()[i] instanceof Shop shop) {
                for (int j = 0; j < shop.getDepartments().length; j++) {
                    if (shop.getDepartments()[j] == shopDepartment) {
                        shopCounter++;
                    }
                }
            }
        }

        Shop[] shops = new Shop[shopCounter];
        shopCounter = 0;

        for (int i = Math.max(counter - searchRadius, 0); i < Math.min(counter + searchRadius, street.getHousesCount()); i++) {
            if (street.getHouses()[i] instanceof Shop shop) {
                for (int j = 0; j < shop.getDepartments().length; j++) {
                    if (shop.getDepartments()[j] == shopDepartment) {
                        shops[shopCounter] = shop;
                        shopCounter++;
                    }
                }
            }
        }

        return shops;
    }
}
