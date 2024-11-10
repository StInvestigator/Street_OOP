package code.street.enums;

public enum ShopDepartment {
    CLOTHING,          // Одежда
    FOOTWEAR,          // Обувь
    ELECTRONICS,       // Электроника
    GROCERY,           // Продукты питания
    HOME_APPLIANCES,   // Бытовая техника
    BEAUTY,            // Косметика и парфюмерия
    TOYS,              // Игрушки
    SPORTS,            // Спортивные товары
    BOOKS,             // Книги
    FURNITURE;         // Мебель

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase().replace('_', ' ');
    }
}