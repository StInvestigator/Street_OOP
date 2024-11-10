package code.street.service.shop;

import code.street.model.School;
import code.street.model.Shop;
import code.street.service.school.SchoolPrintable;

import java.util.Arrays;

public class ShopPrintableFullImpl implements ShopPrintable {
    public void print(Shop shop) {
        System.out.println("-------------------[Shop information]----------------");
        System.out.println("Address: " + shop.getAddress());
        System.out.println("Shop Name: " + shop.getName());
        System.out.println("Shop Type: " + shop.getType());
        System.out.println("Shop departments: " + Arrays.toString(shop.getDepartments()));
        System.out.println("-----------------[Shop information end]--------------");
    }
}
