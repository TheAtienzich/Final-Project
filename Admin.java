import java.util.*;

public class Admin extends Usuario {
    private String claveEmpresa;

    public Admin(String email, String contrasenya, String claveEmpresa, String nombre){
        super(email, contrasenya, nombre);
        this.claveEmpresa = "0000000F";
    }

    @Override
    public String AFichero(){
        return super.AFichero() + ";" +  claveEmpresa;
    }

    public String ToString(){
        return super.ToString() + " Clave Empresa: " + claveEmpresa;
    }
}
