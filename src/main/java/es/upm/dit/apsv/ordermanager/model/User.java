package es.upm.dit.apsv.ordermanager.model;

import javax.persistence.*;

@Entity
public class User{
    @Id
    private String email;
	private String pass;
	private String nombre;
	private String apellido;
    private Vehiculo veh;
    
    public User() {

    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Vehiculo getVeh() {
        return this.veh;
    }
    public void setVeh(Vehiculo veh){
        this.veh=veh;
    }

    public void setId(Vehiculo veh) {
        this.veh = veh;
    }

}

