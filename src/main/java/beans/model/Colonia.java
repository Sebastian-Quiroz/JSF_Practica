/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.model;

/**
 *
 * @author ADMIN
 */
public class Colonia {
    
    private int coloniaID;
    private String nombreColonia;
    private int codigoPostal;

    public Colonia() {
    }

    public Colonia(int coloniaID, String nombreColonia, int codigoPostal) {
        this.coloniaID = coloniaID;
        this.nombreColonia = nombreColonia;
        this.codigoPostal = codigoPostal;
    }

    public int getColoniaID() {
        return coloniaID;
    }

    public void setColoniaID(int coloniaID) {
        this.coloniaID = coloniaID;
    }

    public String getNombreColonia() {
        return nombreColonia;
    }

    public void setNombreColonia(String nombreColonia) {
        this.nombreColonia = nombreColonia;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
    
}
