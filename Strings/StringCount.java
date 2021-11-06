package e1;

public class StringCount {

    public static int countWords(String text){

        int cont = 0;
        if(text == null) return 0;
        else if(text.isEmpty()) return 0;
        else{
            String[] storage = text.split("\\s+"); // Cada vez que encuentre un espacio o una cadena de espacios seguidos

            //Para probar output
            //int resultado = storage.length;
            //System.out.println(resultado);
            if(text.charAt(0) == ' ') return storage.length - 1;
            return storage.length;
        }
    }
    public static int countChar(String text, char c) {

        int cont = 0;
        if (text == null) return 0;
        else if (text.isEmpty()) return 0;
        else {
            char[] characterArray = text.toCharArray();
            if (text == null) return 0;
            for (char value : characterArray) {
                if (value == c) {
                    cont++;
                }
            }
            /* PARA PROBAR EL OUTPUT */ //System.out.println(cont);
            return cont;
        }
    }

    public static int countCharIgnoringCase(String text, char c){
        int cont = 0;

        if(text == null)return 0;
        else if(text.isEmpty()) return 0;
        else {
            char[] characterArray = text.toCharArray();
            for (char value : characterArray) {
                char lower = Character.toLowerCase(c);
                char upper = Character.toUpperCase(c);
                if (value == c || value == lower || value == upper) {
                    cont++;
                }
            }
        }
        System.out.println(cont);
        return cont;
    }

    public static boolean isPasswordSafe(String password) {
        return PasswordUtils.safePassword(password); //Metodo declarado en la clase PasswordUtils
    }

    public static void main(String[] args) {

        /* ZONA DE PRUEBAS OUTPUTS */
        /* countWords("prueba count words numero uno");
        countChar("el gran pepe", 'e');
        countCharIgnoringCase("El gran pépeè", 'e');
        if(isPasswordSafe("abcde"))
            System.out.println("primera si");
        System.out.println("primera no");
        if(isPasswordSafe("1Ae,.?#$@")){
            System.out.println("segunda si");
        } else {
            System.out.println("segunda no");
        }*/
    }
}
