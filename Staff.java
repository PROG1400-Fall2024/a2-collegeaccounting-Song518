public class Staff {

    private String name;
    private String address;
    private int yearsOfService;
    private double payOfYear;

    public Staff(String name, String address, int yearsOfService) {
        this.name = name;
        this.address = address;
        this.yearsOfService = yearsOfService;
        this.payOfYear = 50000 + yearsOfService * 500;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public double getWeeklyPay(){
        return payOfYear/26;
    }

    public String toString() {
        return "name = " + name + ",address = " + address + ",years = " + yearsOfService
                + ",pay = $" + String.format("%.2f", payOfYear);
    }

}

