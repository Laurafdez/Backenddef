package es.upm.dit.isst.controller.model;

import javax.persistence.*;

import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;

@Entity
public class Vehiculo {
    @Id
    private int idveh;
    private boolean aparcadoOk;

    @Lob
    private byte[] ubicacion;



    public Vehiculo() {

    }


    public int getIdveh() {
        return this.idveh;
    }

    public void setIdveh(int idveh) {
        this.idveh = idveh;
    }

    public boolean getAparcadoOk() {
        return this.idveh;
    }

    public void setAparcadoOk(boolean aparcadoOk) {
        this.aparcadoOk = aparcadoOk;
    }

    public byte[] Ubicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(byte[] ubicacion) {
        this.ubicacion = ubicacion;
    }

    
}
