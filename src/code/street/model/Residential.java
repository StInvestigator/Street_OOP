package code.street.model;

import code.street.service.residential.ResidentialPrintableFullImpl;
import code.street.service.shop.ShopPrintableFullImpl;
import code.street.utils.MyJsonParser;
import code.street.service.residential.ResidentialPrintable;

public class Residential extends House{
    private int currentResidentsCount;
    private int capacity;
    private ResidentialPrintable printable;

    public Residential(String Json) {
        super(Json);
    }

    public Residential(String address, int currentResidentsCount, int capacity, ResidentialPrintable printable) {
        this.address = address;
        this.currentResidentsCount = currentResidentsCount;
        this.capacity = capacity;
        this.printable = printable;
    }

    @Override
    public void print() {
        printable.print(this);
    }

    @Override
    public void setFields(String dataJson) {
        address = MyJsonParser.extractValue(dataJson, "address");
        currentResidentsCount = Integer.parseInt(MyJsonParser.extractValue(dataJson, "currentResidentsCount"));
        capacity = Integer.parseInt(MyJsonParser.extractValue(dataJson, "capacity"));
        printable = new ResidentialPrintableFullImpl();
    }

    public void setPrintable(ResidentialPrintable printable) {
        this.printable = printable;
    }

    public int getCurrentResidentsCount() {
        return currentResidentsCount;
    }

    public int getCapacity() {
        return capacity;
    }
}
