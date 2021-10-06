package third;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static ArrayList<Car> createListOfCars(){
        ArrayList<Car> listOfCars = new ArrayList<>();
        listOfCars.add(new Car("BMW", "i8", 2000 , Color.GREEN,100000.0, "AA0000AA"));
        listOfCars.add(new Car("BMW", "x5", 2018, Color.RED,50000.0, "AA1111AA"));
        listOfCars.add(new Car("BMW", "x5", 2020, Color.BLUE,75000.0, "AA1010AA"));
        listOfCars.add(new Car("Mercedes-Benz", "s600", 2017, Color.RED, 50000.0, "AI0000IA"));
        listOfCars.add(new Car("Mazda", "RX7", 2000, Color.GREEN,25000.0, "AA0220AA"));
        return listOfCars;
    }

    public static void main(String[] args){
        List<Car> listOfCars = createListOfCars();
        System.out.println("ALL CARS\n");
        for(Car car: listOfCars) System.out.println(car);
        System.out.println("\nCARS BY MODEL\n");
        for (Car car: Methods.carsByModel(listOfCars, "x5")) System.out.println(car);
        System.out.println("\nOLD CARS BY BRAND\n");
        for (Car car: Methods.oldCarsByBrand(listOfCars, "BMW", 2)) System.out.println(car);
        System.out.println("\nEXPENSIVE CARS BY YEAR\n");
        for (Car car: Methods.expensiveCarsByYear(listOfCars, 2020, 50000.0)) System.out.println(car);
    }

}
