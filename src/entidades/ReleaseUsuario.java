/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Matheus
 */
public class ReleaseUsuario {
    private int id;
    private boolean fl_lido;
    private Usuario usuario;
    private Release release;

    public ReleaseUsuario() {
       
    }
    
    public ReleaseUsuario(int id,boolean fl_lido, Usuario usuario, Release release) {
       this.id = id;
       this.fl_lido = fl_lido;
       this.usuario = usuario;
       this.release = release;
    }

    /**
     * @return the fl_lido
     */
    public boolean isFl_lido() {
        return fl_lido;
    }

    /**
     * @param fl_lido the fl_lido to set
     */
    public void setFl_lido(boolean fl_lido) {
        this.fl_lido = fl_lido;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the release
     */
    public Release getRelease() {
        return release;
    }

    /**
     * @param release the release to set
     */
    public void setRelease(Release release) {
        this.release = release;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
