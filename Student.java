public class Student {

    private String name;
    private String address;
    private int year;
    private double feeOfYear;

    public Student(String name, String address, int year) {
        this.name = name;
        this.address = address;
        this.year = year;
        this.feeOfYear = 3000 + (year-1) * 100;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getYear() {
        return year;
    }

    public double getFeeOfTerm() {
        return feeOfYear/2;
    }

    public String toString() {
        return "name = " + name + ",address = " + address + ",years = " + year
                + ",pay = $" + String.format("%.2f", feeOfYear);
    }

}

