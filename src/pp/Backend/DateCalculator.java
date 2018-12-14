package pp.Backend;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class DateCalculator {

    public static void main(String[] args) throws Exception {
        DateCalculator db = new DateCalculator();
        //Year, month, day
        String inputDate1 = "2017-06-30";
        String inputDate2 = "2018-05-23";

        int monthDifference = db.dateCalculator(inputDate1, inputDate2);
        System.out.println("Month difference is: " + monthDifference);

        //sb.dateBuilder("11","05","2018");

        System.out.println(db.isLeapYear(2018));

    }

    public boolean isLeapYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
    }

    public int dateCalculator(String inputDate1, String inputDate2){
        DateCalculator db = new DateCalculator();
        String[] dateSplit1 = inputDate1.split("-");
        String[] dateSplit2 = inputDate2.split("-");
        int monthDifference = 0;

        if(Integer.valueOf(dateSplit1[0]) < Integer.valueOf(dateSplit2[0])){
            monthDifference = db.RearrangeDatesThenCalculate(inputDate1, inputDate2);
        }
        else if(Integer.valueOf(dateSplit1[0]) > Integer.valueOf(dateSplit2[0])){
            monthDifference = db.RearrangeDatesThenCalculate(inputDate2, inputDate1);
        }
        else {
            if(Integer.valueOf(dateSplit1[1]) < Integer.valueOf(dateSplit2[1])){
                monthDifference = db.RearrangeDatesThenCalculate(inputDate1, inputDate2);
            }
            else if(Integer.valueOf(dateSplit1[1]) > Integer.valueOf(dateSplit2[1])){
                monthDifference = db.RearrangeDatesThenCalculate(inputDate2, inputDate1);
            }
            else{
                if(Integer.valueOf(dateSplit1[2]) < Integer.valueOf(dateSplit2[2])){
                    monthDifference = db.RearrangeDatesThenCalculate(inputDate1, inputDate2);
                }
                else if(Integer.valueOf(dateSplit1[2]) > Integer.valueOf(dateSplit2[2])){
                    monthDifference = db.RearrangeDatesThenCalculate(inputDate2, inputDate1);
                }
            }
        }

        return monthDifference;
    }

    public int RearrangeDatesThenCalculate(String mostRecentDate, String leastRecentDate){
        long daysBetween = ChronoUnit.MONTHS.between(
                LocalDate.parse(mostRecentDate).withDayOfMonth(1),
                LocalDate.parse(leastRecentDate).withDayOfMonth(1));
        //System.out.println(daysBetween); //3
        int monthDifference = (int)daysBetween;
        return monthDifference;
    }

}
