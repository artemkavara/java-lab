package third;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.atomic.AtomicInteger;

enum Color{
    RED("red"),
    GREEN("green"),
    BLUE("blue");

    private final String color;

    Color(String color){
        this.color = color;
    }

    public String toString(){
        return color;
    }
}

public class Car {

    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String brand;
    private String model;
    private Calendar yearOfManufacture;
    private Color color;
    private double price;
    private String registrationNumber;

    public Car(String brand, String model, int yearOfManufacture,
               Color color, double price, String registrationNumber){

        this.id = count.incrementAndGet();
        this.brand = brand;
        this.model = model;
        this.yearOfManufacture = new GregorianCalendar(yearOfManufacture, 1, 1);
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;

    }

    public String getColor(){
        return this.color.toString();
    }

    public String getBrand(){
        return this.brand;
    }

    public String getModel(){
        return this.model;
    }

    public int getYearOfManufacture(){
        return this.yearOfManufacture.get(Calendar.YEAR);
    }

    public double getPrice(){
        return this.price;
    }

    public String toString(){
        return String.format("Id: %d\nBrand: %s\nModel: %s\nYear of manufacture: %d\nColor: %s\nPrice: %.2f\nRegistration number: %s\n",
                id, brand, model, yearOfManufacture.get(Calendar.YEAR), color.toString(), price, registrationNumber);
    }

}
