package DataSrc;

public class User {
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String telefono;
    private String cedula;
    private String anionac;
    private String Work;
    private String Grade;
    private String Estrato;
    private boolean Trabajador;
    private long saldo;



    public User(String name, String lastName, String email, String password, String telephone, String cedula, String bornDate,boolean Trabajador) {
        this.nombre = name;
        this.apellido = lastName;
        this.email = email;
        this.password = password;
        this.telefono = telephone;
        this.cedula = cedula;
        this.anionac = bornDate;
        this.Trabajador = Trabajador;
    }

    public User(){
        this.nombre = null;
        this.apellido = null;
        this.email = null;
        this.password = null;
        this.telefono = null;
        this.cedula = null;
        this.anionac = null;
    }

    public User(String name, String lastName, String email, String password, String cedula, String bornDate) {
        this.nombre = name;
        this.apellido = lastName;
        this.email = email;
        this.password = password;

        this.cedula = cedula;
        this.anionac = bornDate;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public void setTrabajador(boolean Trabajador) {
        this.Trabajador = Trabajador;
    }
    
   public boolean getTrabajador(){
       return this.Trabajador;
   }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getAnionac() {
        return anionac;
    }

    public void setAnionac(String anionac) {
        this.anionac = anionac;
    }

    public String getWork() {
        return Work;
    }

    public void setWork(String work) {
        Work = work;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getEstrato() {
        return Estrato;
    }

    public void setEstrato(String estrato) {
        Estrato = estrato;
    }

    @Override
    public String toString () {
        return "User{" +
                "nombre='" + nombre + '\n' +
                ", email='" + email + '\n' +
                ", cedula='" + cedula + '\n';
    }
    
    @Override
    public int hashCode(){
        //para identificar unicamente a un usuario basta con tener su cédula
        int p = -1;
        try{
            p = Integer.parseInt(this.cedula);
        } catch ( NumberFormatException ex){
            //ex.printStackTrace();
        }
        return p;
    }
}
