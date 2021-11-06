package e1;

public class PasswordUtils {

    public static boolean safePassword(String password){
        return hasEightCharacters(password) && hasUpperCase(password)
                && hasLowerCase(password) && hasDigit(password) && hasSpecialCharacters(password);
    }

    private static boolean hasEightCharacters(String password) {
        char[] passwordArray = password.toCharArray();
        return passwordArray.length > 7;
    }

    private static boolean hasUpperCase(String password){
        int aux = 0;
        char c;
        char[] passwordArray = password.toCharArray();
        for(int i = 0; i < passwordArray.length; i++){
            c = password.charAt(i);
            if(Character.isUpperCase(c))
                aux++;
        }
        return aux > 0;
    }

    private static boolean hasLowerCase(String password){
        int aux = 0;
        char c;
        char[] passwordArray = password.toCharArray();
        for(int i = 0; i < passwordArray.length; i++){
            c = password.charAt(i);
            if(Character.isLowerCase(c))
                aux++;
        }
        return aux > 0;
    }
    private static boolean hasDigit(String password){
        int aux = 0;
        char c;
        char[] passwordArray = password.toCharArray();
        for(int i = 0; i < passwordArray.length; i++){
            c = password.charAt(i);
            if(Character.isDigit(c))
                aux++;
        }
        return aux > 0;
    }

    private static boolean hasSpecialCharacters(String password){
        int aux = 0;
        char c;
        char[] passwordArray = password.toCharArray();
        for(int i = 0; i < passwordArray.length; i++){
            c = password.charAt(i);
            if(c == '@' || c == ',' || c == '?' || c == '#' || c == '.' || c == '$')
                aux++;
        }
        return aux > 0;
    }
}
