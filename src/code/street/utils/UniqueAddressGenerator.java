package code.street.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueAddressGenerator {
    public static String getUniqueAddress(String[] addresses, String prev) {
        if(prev.isEmpty()){
            return getUniqueAddress(addresses);
        }
        if(addresses[addresses.length-1].equals(prev)){
            return getUniqueAddress(addresses);
        }
        Set<String> addressSet = new HashSet<String>(Arrays.asList(addresses));
        if(!addressSet.contains(prev)) {
            return getUniqueAddress(addresses);
        }
        char suffix = 'a';

        while (addressSet.contains(prev + suffix)) {
            suffix++;
        }

        return prev + suffix;
    }

    public static String getUniqueAddress(String[] addresses) {
        if (addresses.length == 0) return "1";
        String numbers = addresses[addresses.length - 1].replaceAll("[^0-9]", "");
        return Integer.toString(Integer.parseInt(numbers) + 1);
    }
}
