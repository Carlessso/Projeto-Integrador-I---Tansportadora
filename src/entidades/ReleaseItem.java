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
public class ReleaseItem {
    private int id;
    private String descricao;
    private Release release;

    public ReleaseItem() {
       
    }
    
    public ReleaseItem(int id,String descricao, Release release) {
       this.id = id;
       this.descricao = descricao;
       this.release = release;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
}
