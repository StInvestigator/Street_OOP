package code.street.model;

import code.street.enums.ShopDepartment;
import code.street.enums.ShopType;
import code.street.service.shop.ShopPrintableFullImpl;
import code.street.utils.MyJsonParser;
import code.street.service.shop.ShopPrintable;

public class Shop extends House{
    private String name;
    private ShopType type;
    private ShopDepartment[] departments;
    private ShopPrintable printable;

    public Shop(String Json) {
        super(Json);
    }

    public Shop(String address, String name, ShopType type, ShopDepartment[] departments, ShopPrintable printable) {
        this.address = address;
        this.name = name;
        this.type = type;
        this.departments = departments;
        this.printable = printable;
    }

    @Override
    public void print() {
        printable.print(this);
    }

    @Override
    public void setFields(String dataJson) {
        address = MyJsonParser.extractValue(dataJson, "address");
        name = MyJsonParser.extractValue(dataJson, "name");
        type = ShopType.valueOf(MyJsonParser.extractValue(dataJson, "type"));

        String[] departmentStrings = MyJsonParser.extractArray(dataJson, "departments");
        departments = new ShopDepartment[departmentStrings.length];

        for (int i = 0; i < departmentStrings.length; i++) {
            departments[i] = ShopDepartment.valueOf(departmentStrings[i]);
        }
        printable = new ShopPrintableFullImpl();
    }

    public void setPrintable(ShopPrintable printable) {
        this.printable = printable;
    }

    public String getName() {
        return name;
    }

    public ShopType getType() {
        return type;
    }

    public ShopDepartment[] getDepartments() {
        return departments;
    }
}
