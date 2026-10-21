import java.time.*;
import java.time.format.*;

class DateTime {
  public static void main(String[] args) {
    LocalDate d = LocalDate.now();
    System.out.println("Date: " + d);
    System.out.println("Year: " + d.getYear());
    System.out.println("Month: " + d.getMonth());
    System.out.println("Day: " + d.getDayOfMonth());
    System.out.println("Day of Week: " + d.getDayOfWeek());
    System.out.println("Leap Year: " + d.isLeapYear());
    System.out.println("Next Day: " + d.plusDays(1));
    System.out.println("Previous Month: " + d.minusMonths(1));

    System.out.println();

    LocalTime t = LocalTime.now();
    System.out.println("Time: " + t);
    System.out.println("Hour: " + t.getHour());
    System.out.println("Minute: " + t.getMinute());
    System.out.println("Second: " + t.getSecond());
    System.out.println("After 2 Hours: " + t.plusHours(2));
    System.out.println("After 30 Minutes: " + t.plusMinutes(30));

    System.out.println();

    LocalDateTime dt = LocalDateTime.now();
    System.out.println("Date and Time: " + dt);

    System.out.println();

    LocalDateTime dtn = LocalDateTime.now();
    DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm:ss");
    System.out.println(dtn.format(frmt));
  }
}
