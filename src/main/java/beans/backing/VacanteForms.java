/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ADMIN
 */
@Named
@RequestScoped
public class VacanteForms {
    
    @Inject
    private Candidato candidato;
    
    public void setCandidato(Candidato candidato){
        this.candidato = candidato;
    }
    
    public String enviar(){
        if (candidato.getNombre().equals("Juan")) {
            
            return "exito";
        }else{
            return "fallo";
        }
    }
    
}
