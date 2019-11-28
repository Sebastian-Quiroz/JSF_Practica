/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.backing;

import beans.helper.ColoniaHelper;
import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
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

    private boolean comentarioEnviado;

    @Inject
    private ColoniaHelper coloniaHelper;

    Logger log = LogManager.getRootLogger();

    public VacanteForms() {
        log.info("Creando el Objeto VacanteForm");
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public String enviar() {
        if (this.candidato.getNombre().equals("Juan")) {
            if (this.candidato.getApellido().equals("Perez")) {
                String msg = "Gracias, Pero Juan Perez ya trabajo con nosotros";
                FacesMessage faceMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
                FacesContext facesContext = FacesContext.getCurrentInstance();

                String componentId = null; //ESte es un mensaje Global
                facesContext.addMessage(componentId, faceMessage);
                return "index";
            }
            log.info("Entrando al caso de exito");
            return "exito";
        } else {
            log.info("Entrando al caso de FALLO");
            return "fallo";
        }
    }

    public void codigoPostalListener(ValueChangeEvent valueChangeEvent) {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        UIViewRoot uiViewRoot = facesContext.getViewRoot();

        int nuevoCodigoPostal =  ((Long)valueChangeEvent.getNewValue()).intValue();

        //leemos el id del FORM de nuestro index 
        UIInput coloniaIDInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:coloniaID");
        int nuevaColoniaID = this.coloniaHelper.getColoniaIdPorCP(nuevoCodigoPostal);
        coloniaIDInputText.setValue(nuevaColoniaID);
        coloniaIDInputText.setSubmittedValue(nuevaColoniaID);

        UIInput ciudadInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:ciudad");
        String nuevaCiudad = "Ciudad de Mexico";
        ciudadInputText.setValue(nuevaCiudad);
        ciudadInputText.setSubmittedValue(nuevaCiudad);

        //enviamos la respuesta
        facesContext.renderResponse();

    }

    public void ocultarComentario(ActionEvent actionEvent) {
        this.comentarioEnviado = !this.comentarioEnviado;
    }

    public boolean isComentarioEnviado() {
        return comentarioEnviado;
    }

    public void setComentarioEnviado(boolean comentarioEnviado) {
        this.comentarioEnviado = comentarioEnviado;
    }

    public ColoniaHelper getColoniaHelper() {
        return coloniaHelper;
    }

    public void setColoniaHelper(ColoniaHelper coloniaHelper) {
        this.coloniaHelper = coloniaHelper;
    }

}
