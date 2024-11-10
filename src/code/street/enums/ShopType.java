package code.street.enums;

public enum ShopType {
    SMALL_SHOP,
    SUPERMARKET;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
    }
}