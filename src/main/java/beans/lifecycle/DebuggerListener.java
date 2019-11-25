/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.lifecycle;


import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author ADMIN
 */


public class DebuggerListener implements javax.faces.event.PhaseListener{
    
    Logger log = LogManager.getRootLogger();
    
    @Override
    public void beforePhase(PhaseEvent pe) {
        
        if (log.isInfoEnabled()) {
            log.info("Antes de la fase: "+ pe.getPhaseId().toString());
        }
        
    }
    
    @Override
    public void afterPhase(PhaseEvent pe) {
        
        if (log.isInfoEnabled()) {
            log.info("Despues de la fase: "+ pe.getPhaseId().toString());
        }
        
    }

    @Override
    public PhaseId getPhaseId() {
        
        return PhaseId.ANY_PHASE;
        
    }
    
}
