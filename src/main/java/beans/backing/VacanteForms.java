/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    
    public VacanteForms(){
        log.info("Creando el Objeto VacanteForm");
    }
    
    @Inject
    private Candidato candidato;
    Logger log = LogManager.getRootLogger();
    
    public void setCandidato(Candidato candidato){
        this.candidato = candidato;
    }
    
    public String enviar(){
        if (this.candidato.getNombre().equals("Juan")) {
            if (this.candidato.getApellido().equals("Perez")) {
                String msg = "Gracias, Pero Juan Perez ya trabajo con nosotros";
                FacesMessage faceMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg,msg);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                
                //String componentId = null; //ESte es un mensaje Global
                //facesContext.addMessage(componentId, faceMessage);
                return "index";
            }
            log.info("Entrando al caso de exito");
            return "exito";
        }else{
            log.info("Entrando al caso de FALLO");
            return "fallo";
        }
    }
    
}
