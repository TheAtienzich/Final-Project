public class Admin extends Usuario {
    private String claveEmpresa;

    public Admin(String email, String contrasenya, String nombre){
        super(email, contrasenya, nombre);
        this.claveEmpresa = "000000F";
    }

    @Override
    public String AFichero(){
        return super.AFichero() + ";" +  claveEmpresa;
    }
    @Override
    public String ToString(){

        return super.ToString() + " Clave Empresa: " + claveEmpresa;
    }
}
