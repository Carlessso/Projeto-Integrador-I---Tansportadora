/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import org.hibernate.envers.Audited;

/**
 *
 * @author Ramon
 */
@Audited
public class Auditar implements java.io.Serializable {
    
    private int id;
    private boolean auditar;
    
    public Auditar() {

    }
    
    public Auditar(int id, boolean auditar) {
        this.id = id;
        this.auditar = auditar;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public boolean getAuditar() {
        return this.auditar;
    }
    
    public void setAuditar(boolean auditar) {
        this.auditar = auditar;
    }
}