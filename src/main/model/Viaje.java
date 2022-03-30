package es.upm.dit.isst.controller.model;

import java.sql.Date;

import javax.persistence.*;

import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.stereotype.Indexed;

@Entity
public class Viaje {
    @Id
    private int idviaje;
    private Date fecha;
    private int tiempo;
    private User id;
    private int status;
    @Lob
    private byte[] ubini;
    @Lob
    private byte[] ubifin;



    public Viaje() {

    }

    public int getIdviaje() {
        return this.idveh;
    }

    public void setIdviaje(int idviaje) {
        this.idviaje = idviaje;
    }

    public  Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha= fecha;
    }
    public int getTiempo() {
        return this.tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo= tiempo;
    }


    public User getId() {
        return this.id;
    }

    public void setId(User id) {
        this.id= id;
    }

    public byte[] Ubini() {
        return this.ubini;
    }

    public void setUbini(byte[] ubini) {
        this.ubini = ubini;
    }
    public byte[] Ubifin() {
        return this.ubifin;
    }

    public void setUbifin(byte[] ubifin) {
        this.ubifin = ubifin;
    }

}
