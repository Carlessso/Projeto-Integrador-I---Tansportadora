package entidades;
// Generated 11/09/2018 09:51:52 by Hibernate Tools 4.3.1

import org.hibernate.envers.Audited;




/**
 * Erro generated by hbm2java
 */
@Audited
public class Erro  implements java.io.Serializable {


     private int id;
     private Usuario usuario;
     private String descricao;

    public Erro() {
    }

    public Erro(int id, Usuario usuario, String descricao) {
       this.id = id;
       this.usuario = usuario;
       this.descricao = descricao;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }




}


