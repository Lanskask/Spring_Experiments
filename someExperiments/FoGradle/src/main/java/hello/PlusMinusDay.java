package hello;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PlusMinusDay {
  SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

  public static void main(String[] args) {
    PlusMinusDay plusMinusDay = new PlusMinusDay();
    plusMinusDay.run();
  }

  void run() {
//    this.dateGetTime();
//    System.out.println("Parsed Err: " + this.parsedDate());
    System.out.println("Change days: 1 " + this.plusDate(1));
    System.out.println("Change days: -1 " + this.plusDate(-1));
  }

  Date dateGetTime() {
    return new Date((new Date()).getTime());
  }

  Date parsedDate() {
    Date parsedRes = new Date();
    try {
      parsedRes = formater.parse("2017-10-24");
    } catch (ParseException pe) {
      pe.printStackTrace();
    }
    return parsedRes;
  }

  Date plusDate(int numOfDays) {
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DATE, numOfDays);
    date = calendar.getTime();

    return date;
  }

}
