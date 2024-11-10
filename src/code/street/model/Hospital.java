package code.street.model;

import code.street.enums.HospitalDepartment;
import code.street.service.hospital.HospitalPrintableFullImpl;
import code.street.service.shop.ShopPrintableFullImpl;
import code.street.utils.MyJsonParser;
import code.street.service.hospital.HospitalPrintable;

public class Hospital extends House {
    private HospitalDepartment[] departments;
    private HospitalPrintable printable;

    public Hospital(String Json) {
        super(Json);
    }

    public Hospital(String address, HospitalDepartment[] departments, HospitalPrintable printable) {
        this.address = address;
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
        String[] departmentStrings = MyJsonParser.extractArray(dataJson, "departments");
        departments = new HospitalDepartment[departmentStrings.length];

        for (int i = 0; i < departmentStrings.length; i++) {
            departments[i] = HospitalDepartment.valueOf(departmentStrings[i]);
        }
        printable = new HospitalPrintableFullImpl();
    }

    public void setPrintable(HospitalPrintable printable) {
        this.printable = printable;
    }

    public HospitalDepartment[] getDepartments() {
        return departments;
    }
}
