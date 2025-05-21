import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public abstract class Usuario {
    protected String email;
    protected String passWord;
    protected String name;

    public Usuario(String email, String passWord, String name){
        this.email = email;
        this.passWord = passWord;
        this.name = name;
    }
    public String getName(){return name;}
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public static boolean emailValido(String email){
        Pattern p = Pattern.compile("^[a-zA-Z0-9._%+-]+@(gmail\\.com|@hotmail\\.com|@onFire\\.com)$");
        Matcher m = p.matcher(email);

        if(!m.find())
        {
            do {

                System.out.println("Invalid email,Try again...");
                Scanner sc = new Scanner(System.in);
                email = sc.nextLine();
            }
            while(!m.find());
            return false;
        }
        return true;
    }

    public void setEmail(String email) {
            this.email = email;
    }

    public String AFichero(){
        return email + ";" + passWord + ";" + name;
    }


    public String ToString(){
        return "email: " + email + " Nombre: " + name;
    }

    public static void guardarUsuario(String fichero, String contenido)
    {

    }
}
