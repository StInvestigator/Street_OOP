package code.street.model;

abstract public class House implements IHouse {
    protected String address;

    public House() {
    }

    public House(String Json) {
        setFields(Json);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    /**
     * Функция "конвертирующая" адрес в дабл, чтобы адреса можно было корректно сравнивать
     * (1 < 1a < 2 < ... < 10)
     */
    public Double addressComparator() {
        double number = Double.parseDouble(this.address.replaceAll("[^0-9]", ""));
        String letters = this.address.replaceAll("[^a-zA-Z]", "");
        if (!letters.isEmpty()) {
            return number + letters.charAt(0) / 100.;
        } else {
            return number;
        }
    }
}
