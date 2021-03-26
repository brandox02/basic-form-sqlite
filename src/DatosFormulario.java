// 
// Decompiled by Procyon v0.5.36
// 

package RealFormulario;

public class DatosFormulario
{
    private String id;
    private String nombre;
    private String apellidos;
    private String email;
    private String celular;
    private String direccion;
    private String sexo;
    private String imagen;
    
    public DatosFormulario(final String id, final String nombre, final String apellidos, final String email, final String celular, final String direccion, final String sexo, final String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.celular = celular;
        this.direccion = direccion;
        this.sexo = sexo;
        this.imagen = imagen;
    }
    
    public String getID() {
        return this.id;
    }
    
    public void setID(final String id) {
        this.id = id;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(final String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
    
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(final String celular) {
        this.celular = celular;
    }
    
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(final String direccion) {
        this.direccion = direccion;
    }
    
    public String getsexo() {
        return this.sexo;
    }
    
    public void setSexo(final String sexo) {
        this.sexo = sexo;
    }
    
    public String getImagen() {
        return this.imagen;
    }
    
    public void setImagen(final String imagen) {
        this.imagen = imagen;
    }
}
