package code.street.service.shop;

import code.street.enums.HospitalDepartment;
import code.street.enums.ShopDepartment;
import code.street.enums.ShopType;
import code.street.model.Shop;
import code.street.utils.UniqueAddressGenerator;

import java.util.Arrays;
import java.util.Random;

public class RandomShopStaticArrImpl implements RandomShop {
    private static final String[] names = new String[]{
            "Zenith", "BlueSky", "NovaStore", "UrbanPoint", "RedPeak",
            "PrimeChoice", "CrystalWave", "GoldenEra", "VividStore", "EchoPlace",
            "SilentHaven", "PeakMarket", "SilverLine", "NewHorizon", "LuxWave"
    };

    private ShopDepartment[] getRandomDepartments(int count) {
        Random random = new Random();
        ShopDepartment[] allDepartments = ShopDepartment.values();

        // Перемешиваем массив
        for (int i = allDepartments.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            ShopDepartment temp = allDepartments[i];
            allDepartments[i] = allDepartments[j];
            allDepartments[j] = temp;
        }

        return Arrays.copyOfRange(allDepartments, 0,
                Math.min(count, allDepartments.length));
    }
    @Override
    public Shop getRandom(String address) {
        Random rand = new Random();
        String name = names[rand.nextInt(0, names.length)];
        ShopType shopType = ShopType.values()[rand.nextInt(0, ShopType.values().length)];
        ShopDepartment[] departments;
        if(shopType == ShopType.SMALL_SHOP){
            departments = new ShopDepartment[1];
            departments[0] = ShopDepartment.values()[rand.nextInt(0,ShopDepartment.values().length)];
        }
        else{ // shopType == ShopType.SUPERMARKET
            departments = getRandomDepartments(5);
        }
        return new Shop(address,name,shopType, departments,new ShopPrintableFullImpl());
    }
}
