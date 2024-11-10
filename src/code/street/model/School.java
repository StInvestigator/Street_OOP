package code.street.model;

import code.street.enums.SchoolType;
import code.street.service.school.SchoolPrintableFullImpl;
import code.street.service.shop.ShopPrintableFullImpl;
import code.street.utils.MyJsonParser;
import code.street.service.school.SchoolPrintable;

public class School extends House{
    private int studentsCount;
    private int capacity;
    private SchoolType type;
    private SchoolPrintable printable;

    public School(String Json) {
        super(Json);
    }

    public School(String address, int studentsCount, int capacity, SchoolType type, SchoolPrintable printable) {
        this.address = address;
        this.studentsCount = studentsCount;
        this.capacity = capacity;
        this.type = type;
        this.printable = printable;
    }


    @Override
    public void print() {
        printable.print(this);
    }

    @Override
    public void setFields(String dataJson) {
        address = MyJsonParser.extractValue(dataJson, "address");
        studentsCount = Integer.parseInt(MyJsonParser.extractValue(dataJson, "studentsCount"));
        capacity = Integer.parseInt(MyJsonParser.extractValue(dataJson, "capacity"));
        type = SchoolType.valueOf(MyJsonParser.extractValue(dataJson, "type"));
        printable = new SchoolPrintableFullImpl();
    }

    public void setPrintable(SchoolPrintable printable) {
        this.printable = printable;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public SchoolType getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }
}
