package code.street;

import code.street.menu.MenuExecutor;
import code.street.model.Residential;
import code.street.model.Street;
import code.street.service.residential.ResidentialPrintableFullImpl;
import code.street.service.street.StreetService;

public class Main {
    public static void main(String[] args) {
        Street street = new Street("Stepana Bandery St.", 100);

        try {
            street.addByJson("[" +
                    "\"houseType\":" + "\"shop\"," +
                    "\"address\":" + "\"2\"," +
                    "\"name\":" + "\"JSON Shop\"," +
                    "\"type\":" + "\"SMALL_SHOP\"," +
                    "\"departments\":" + "[\"GROCERY\",\"HOME_APPLIANCES\"];" +
                    "]");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        street.addHouse(new Residential("2",10,100, new ResidentialPrintableFullImpl()));
        street.removeHouse("3");

        StreetService service = new StreetService(street);

        MenuExecutor menu = new MenuExecutor(service);
        menu.start();
    }
}