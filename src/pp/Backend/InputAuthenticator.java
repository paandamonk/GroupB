package pp.Backend;

import java.util.Date;

public class InputAuthenticator {

    public static void main(String[] args) throws Exception {
        //Examples of use
        InputAuthenticator ia = new InputAuthenticator();

        ////////////// NAME AUTHENTICATION //////////////

        System.out.println("Name authenticator:");
        System.out.println(ia.nameAuthenticator("rOger"));
        System.out.println(ia.nameAuthenticator("roger"));
        System.out.println(ia.nameAuthenticator("Rog3r"));
        System.out.println(ia.nameAuthenticator("R()ger"));
        System.out.println(ia.nameAuthenticator("Roger"));
        System.out.println(ia.nameAuthenticator("RogeR"));

        String nameInput = "Roger";
        if(ia.nameAuthenticator(nameInput)) { // name authenticator returned true
            String nameForStorage = "'" + nameInput + "'";
            System.out.println("Name authentication succeeded. Value being stored is: " + nameForStorage);
        }
        else{ // name authenticator returned false
            System.out.println("Name authentication failed.");
        }
        System.out.println();

        ////////////// DIGIT AUTHENTICATION //////////////

        System.out.println("Digit authenticator:");
        System.out.println(ia.digitAuthenticator("123FOUR5"));
        System.out.println(ia.digitAuthenticator("aab456"));
        System.out.println(ia.digitAuthenticator("12345"));
        System.out.println(ia.digitAuthenticator("!@#$5^&*("));

        String digitInput = "12345";
        if(ia.digitAuthenticator(digitInput)) { // name authenticator returned true
            int digitsForStorage = Integer.valueOf(digitInput);
            System.out.println("Digit authentication succeeded. Value being stored is: " + digitsForStorage);
            System.out.println("Proof that input is now an integer, here's the input - 1: " + (digitsForStorage - 1));
        }
        else{ // name authenticator returned false
            System.out.println("Name authentication failed.");
        }
        System.out.println();

        ////////////// DATE AUTHENTICATION //////////////

        System.out.println("Date authenticator:");
        System.out.println("1: " + ia.dateAuthenticator("5", "10","201"));
        System.out.println("2: " + ia.dateAuthenticator("29", "2","2019"));
        System.out.println("3: " + ia.dateAuthenticator("29", "2","2020"));
        System.out.println("4: " + ia.dateAuthenticator("31", "6","2018"));
        System.out.println("5: " + ia.dateAuthenticator("5ffg", "1gg0","20asd18"));
        System.out.println("6: " + ia.dateAuthenticator("50", "8","20180"));
        System.out.println("7: " + ia.dateAuthenticator("50", "03","20180"));

        String day = "25"; String month = "12"; String year = "2018";
        if(ia.dateAuthenticator(day,month,year)) { // name authenticator returned true
            String dateForStorage = ia.dateForDatabase(day,month,year);
            System.out.println("Date authentication succeeded. Value being stored is: " + dateForStorage);

            if(ia.dateAuthenticator("11","2","2019")){
                String dateForStorage2 = ia.dateForDatabase("11","2","2019");

                DateCalculator db = new DateCalculator();
                System.out.println("The number of months between these two dates is: " + db.dateCalculator(dateForStorage,dateForStorage2));

            }
        }
        else{ // name authenticator returned false
            System.out.println("Date authentication failed.");
        }
        System.out.println();
    }

    //Extension of digitAuthenticator method. Returns true if day, month, and year contain only digits
    public boolean dateAuthenticator(String day, String month, String year){
        DateCalculator dc = new DateCalculator();
        if(digitAuthenticator(day) && digitAuthenticator(month) && digitAuthenticator(year)){
            // ensures months can only be numbered from 1 to 12
            if(year.length() == 4) {
                if (Integer.valueOf(month) >= 1 && Integer.valueOf(month) <= 12) {
                    switch (month) {
                        // Months with 31 days.
                        case "1":
                        case "01": // January
                        case "3":
                        case "03": // March
                        case "5":
                        case "05": // May
                        case "7":
                        case "07": // July
                        case "8":
                        case "08": // August
                        case "10": // October
                        case "12": { // December
                            if (Integer.valueOf(day) >= 1 && Integer.valueOf(day) <= 31) {
                                return true;
                            }
                        }
                        break;
                        // Months with 30 days.
                        case "4":
                        case "04": // April
                        case "6":
                        case "06": // June
                        case "9":
                        case "09": // September
                        case "11": { // November
                            if (Integer.valueOf(day) >= 1 && Integer.valueOf(day) <= 30) {
                                return true;
                            }
                        }
                        break;
                        // Month with 28 or 29 days, depending on if it's a leap year.
                        case "2":
                        case "02": { // February
                            //Year input is a leap year
                            if (dc.isLeapYear(Integer.valueOf(year))) {
                                if (Integer.valueOf(day) >= 1 && Integer.valueOf(day) <= 29) {
                                    //System.out.println("Day input must be between 1 and 29 when it is a leap year.");
                                    return true;
                                }
                            }
                            //Year input is not a leap year
                            else if (Integer.valueOf(day) >= 1 && Integer.valueOf(day) <= 28) {
                                //System.out.println("Day input must be between 1 and 28 when it is not a leap year.");
                                return true;
                            }
                        }
                        break;
                    }
                }
            }
        }
        return false;
    }

    //Returns true if string passed contains only numbers
    public boolean monthAuthenticator(String month){

        return false;
    }

    //Returns true if string passed contains only numbers
    public boolean digitAuthenticator(String digits){
        for(int i = 0; i < digits.length(); i++){
            if(!Character.isDigit(digits.charAt(i))){
                return false;
            }
            else if(Character.isDigit(digits.charAt(i)) && i == (digits.length() - 1)){
                return true;
            }
        }
        return false;
    }

    //Returns true if string passed contains only letters, with the first letter being uppercase and the remaining lowercase.
    public boolean nameAuthenticator(String name){
        if(Character.isUpperCase(name.charAt(0))){
            for(int i = 1; i < name.length(); i++){
                if(Character.isUpperCase(name.charAt(i)) || !Character.isLetter(name.charAt(i))){
                    return false;
                }
                else if(!Character.isUpperCase(name.charAt(i)) && i == (name.length() - 1) && Character.isLetter(name.charAt(name.length() - 1))){
                    return true;
                }
            }
        }
        return false;
    }

    public String dateForDatabase(String day, String month, String year){
        if(month.length() == 1){
            return year + "-" + "0" + month + "-" + day;
        }else {
            return year + "-" + month + "-" + day;
        }
    }
}
