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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author ADMIN
 */
@Named
@RequestScoped
public class VacanteForms {
    
    @Inject
    private Candidato candidato;
    Logger log = LogManager.getRootLogger();
    
    public void setCandidato(Candidato candidato){
        this.candidato = candidato;
    }
    
    public String enviar(){
        if (candidato.getNombre().equals("Juan")) {
            log.info("Entrando al caso de exito");
            return "exito";
        }else{
            log.info("Entrando al caso de FALLO");
            return "fallo";
        }
    }
    
}
