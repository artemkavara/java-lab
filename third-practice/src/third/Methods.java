package third;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Methods {
    public static ArrayList<Car> expensiveCarsByYear(List<Car> cars, int year, double price){
        ArrayList<Car> selectedCars = new ArrayList<>();
        for(Car car: cars){
            if(car.getYearOfManufacture() == year && car.getPrice() > price) selectedCars.add(car);
        }
        return selectedCars;
    }

    public static ArrayList<Car> oldCarsByBrand(List<Car> cars, String brand, int year){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        ArrayList<Car> selectedCars = new ArrayList<>();
        for(Car car: cars){
            if(car.getBrand() == brand && (currentYear - car.getYearOfManufacture() > year)) selectedCars.add(car);
        }
        return selectedCars;
    }

    public static ArrayList<Car> carsByModel(List<Car> cars, String model){
        ArrayList<Car> selectedCars = new ArrayList<>();
        for(Car car: cars){
            if(car.getModel() == model) selectedCars.add(car);
        }
        return selectedCars;
    }
}
