package code.street.menu;

import code.street.enums.ShopDepartment;
import code.street.model.House;
import code.street.model.Street;
import code.street.service.street.StreetService;

import java.util.Arrays;
import java.util.Scanner;

public class MenuExecutor {
    StreetService streetService;
    MenuPublisher menu;

    public MenuExecutor(String streetName, int housesCount) {
        this.streetService = new StreetService(new Street(streetName, housesCount));
        this.menu = new MenuPublisher();
    }

    public MenuExecutor(StreetService streetService) {
        this.streetService = streetService;
        this.menu = new MenuPublisher();
    }

    public MenuExecutor(StreetService streetService, MenuPublisher menu) {
        this.streetService = streetService;
        this.menu = menu;
    }

    public void start() {
        int answer;
        do {
            answer = menu.showMainMenu(streetService.getStreet().getName());
            switch (answer) {
                case 1:
                    executePrint();
                    break;
                case 2:
                    executeFindShopsByDepartment();
                    break;
                case 3:
                    executeRemove();
                    break;
            }
        } while (answer != 0);
        return;
    }

    void executePrint() {
        streetService.getStreet().print();
    }

    void executeFindShopsByDepartment() {
        int searchRadius;
        ShopDepartment shopDepartment = null;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter search radius: ");
            searchRadius = scanner.nextInt();
            if (searchRadius < 1) {
                System.out.println("Invalid search radius");
                continue;
            }
            scanner.nextLine();
            System.out.println("Enter shop department (possible answers: " + Arrays.toString(ShopDepartment.values()) + ") : ");
            try {
                shopDepartment = ShopDepartment.valueOf(scanner.nextLine().trim()
                        .replace(' ', '_').toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid shop department");
                continue;
            }
            break;
        } while (true);
        menu.showSearchingResult(streetService.findShopsByDepartment(searchRadius, shopDepartment));
    }

    void executeRemove() {
        System.out.print("Enter the address to remove: ");
        Scanner scanner = new Scanner(System.in);
        String address = scanner.nextLine().trim();
        System.out.println();
        try {
            streetService.getStreet().removeHouse(address);
            System.out.println("House was successfully removed!");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
