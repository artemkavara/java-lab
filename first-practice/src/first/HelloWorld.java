package first;

public class HelloWorld {

    public static void main(String[] args) {
        PrintClass printClass = new PrintClass();
        printClass.printMethod();
    }

}

class PrintClass{

    public void printMethod(){
        System.out.println("Hello from Kyiv!");
    }

}
