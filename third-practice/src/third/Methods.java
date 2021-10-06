package third;

import java.util.Calendar;
import java.util.List;

public class Methods {
    public static void expensiveCarsByYear(List<Car> cars, int year, double price){
        for(Car car: cars){
            if(car.getYearOfManufacture() == year && car.getPrice() > price) System.out.println(car);
        }
    }

    public static void oldCarsByBrand(List<Car> cars, String brand, int year){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for(Car car: cars){
            if(car.getBrand() == brand && (currentYear - car.getYearOfManufacture() > year)) System.out.println(car);
        }
    }

    public static void carsByModel(List<Car> cars, String model){
        for(Car car: cars){
            if(car.getModel() == model) System.out.println(car);
        }
    }
}
