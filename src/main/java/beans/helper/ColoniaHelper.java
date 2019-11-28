/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.helper;

import beans.model.Colonia;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author ADMIN
 */
@RequestScoped
@Named
public class ColoniaHelper {
    
    public List<Colonia> getColonias(){
        
        List<Colonia> colonias = new ArrayList<>();
        
        int coloniaId = 1;
        Colonia colonia = new Colonia(coloniaId++, "Bogota", 3810);
        colonias.add(colonia);
        
        colonia = new Colonia(coloniaId++, "Monserrate", 11530);
        colonias.add(colonia);
        
        colonia = new Colonia(coloniaId++, "Suba", 3100);
        colonias.add(colonia);
        
        return colonias;
    }
    
    public int getColoniaIdPOrNombre(String nombreColonia){
        
        int coloniaId=0;
        List<Colonia> colonias = this.getColonias();
        
        for (Colonia colonia : colonias) {
            if (colonia.getNombreColonia().equals(nombreColonia)) {
                coloniaId= colonia.getColoniaID();
                break;
            }
        }
        
        return coloniaId;
    }
    
    public int getColoniaIdPorCP(int codigoPostal){
        int coloniaId = 0;
        List<Colonia> colonias= getColonias();
        
        for (Colonia colonia : colonias) {
            if (colonia.getCodigoPostal() == codigoPostal) {
                coloniaId = colonia.getColoniaID();
                break;
            }
        }
        
        return coloniaId;
    }
    
    public List<SelectItem> getSelectItems(){
        List<SelectItem> selectItems = new ArrayList<>();
        List<Colonia> colonias = this.getColonias();
        
        for (Colonia colonia : colonias) {
            SelectItem selectItem = new SelectItem(colonia.getColoniaID(),
                                                colonia.getNombreColonia());
            selectItems.add(selectItem);
        }
        
        return selectItems;
    }
    
}
