package pp.Backend;

public class InputAuthenticator {

    public static void main(String[] args) throws Exception {
        //Examples of use
        InputAuthenticator ia = new InputAuthenticator();

        System.out.println(ia.nameAuthenticator("rOger"));
        System.out.println(ia.nameAuthenticator("ronnor"));
        System.out.println(ia.nameAuthenticator("Roger"));
        System.out.println(ia.nameAuthenticator("RogeR"));

        String nameInput = "Roger";
        if(ia.nameAuthenticator(nameInput)) { // name authenticator returned true
            System.out.println("Name authentication succeeded.");
        }
        else{ // name authenticator returned false
            System.out.println("Name authentication failed.");
        }
    }

    public boolean nameAuthenticator(String name){
        if(Character.isUpperCase(name.charAt(0))){
            for(int i = 1; i < name.length(); i++){
                if(Character.isUpperCase(name.charAt(i))){
                    return false;
                }
                else if(!Character.isUpperCase(name.charAt(i)) && i == (name.length() - 1)){
                    return true;
                }
            }
        }
        return false;
    }
}
