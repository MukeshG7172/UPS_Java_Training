import java.util.Scanner;

public class TemperatureConverter {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("1. Celsius to Fahrenheit");
    System.out.println("2. Fahrenheit to Celsius");
    System.out.print("Choose an option: ");

    int choice = sc.nextInt();

    switch (choice) {
      case 1:
        System.out.print("Enter temperature in Celsius: ");
        double celsius = sc.nextDouble();

        double fahrenheit = (celsius * 9.0 / 5.0) + 32;

        System.out.printf("Temperature in Fahrenheit: %.2f%n", fahrenheit);
        break;

      case 2:
        System.out.print("Enter temperature in Fahrenheit: ");
        double f = sc.nextDouble();

        double c = (f - 32) * 5.0 / 9.0;

        System.out.printf("Temperature in Celsius: %.2f%n", c);
        break;

      default:
        System.out.println("Invalid option.");
    }
  }
}
