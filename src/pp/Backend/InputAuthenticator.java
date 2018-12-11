package pp.Backend;

public class InputAuthenticator {

    public static void main(String[] args) throws Exception {
        //Examples of use
        InputAuthenticator ia = new InputAuthenticator();

        System.out.println("Name authenticator:");
        System.out.println(ia.nameAuthenticator("rOger"));
        System.out.println(ia.nameAuthenticator("roger"));
        System.out.println(ia.nameAuthenticator("Rog3r"));
        System.out.println(ia.nameAuthenticator("R()ger"));
        System.out.println(ia.nameAuthenticator("Roger"));
        System.out.println(ia.nameAuthenticator("RogeR"));

        String nameInput = "Roger";
        if(ia.nameAuthenticator(nameInput)) { // name authenticator returned true
            System.out.println("Name authentication succeeded.");
        }
        else{ // name authenticator returned false
            System.out.println("Name authentication failed.");
        }
        System.out.println();
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
        System.out.println("Date authenticator:");
        System.out.println(ia.dateAuthenticator("5", "10","2018"));
        System.out.println(ia.dateAuthenticator("5ffg", "1gg0","20asd18"));
        System.out.println(ia.dateAuthenticator("50", "8","20180"));
    }

    //Extension of digitAuthenticator method. Returns true if day, month, and year contain only digits
    public boolean dateAuthenticator(String day, String month, String year){
        if(!digitAuthenticator(day) || !digitAuthenticator(month) || !digitAuthenticator(year)){
            return false;
        }
        else{
            System.out.println("Test");
            switch(month){
                case "8":
                    System.out.println("TEST");

            }

        }
        /*else if(day.length() != 2 || month.length() < 1 || month.length() > 2 || year.length() != 4){
            return false;
        }*/
        return true;
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
}
