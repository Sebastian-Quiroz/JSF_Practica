/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author ADMIN
 */
@Named
@RequestScoped
public class Candidato {
    
    private String nombre = "Introduce tu nombre";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
