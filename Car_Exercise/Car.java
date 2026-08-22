package Car_Exercise;

public class Car {
    private String Brand;
    private String Model;
    private int Year;
    private double Price;

    Car(String brand, String model, int year, double price) {
        this.Brand = brand;
        this.Model = model;
        if (year > 1903 && year < 2030)
            this.Year = year;
        if (price > 0) {
            this.Price = price;
        }
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        if (year > 1903 && year < 2030)
            this.Year = year;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.Price = price;
        }
    }

    public String printCar() {
        return "Marca: " + this.Brand + "\nModelo: " + this.Model + "\nAno: " + this.Year + "\nPreço: " + this.Price;
    }
}
