package util;

import entidades.Viagem;
import java.io.Serializable;
import java.util.Date;

public class SocketData 
    implements 
        Serializable
{
    private String notificacao;
    private Date data;
    private int idViagem;

    public SocketData(String notificacao, Date data, int idViagem){
        this.notificacao = notificacao;
        this.data = data;
        this.idViagem = idViagem;
    }

    /**
     * @return the notificacao
     */
    public String getNotificacao() {
        return notificacao;
    }

    /**
     * @param notificacao the notificacao to set
     */
    public void setNotificacao(String notificacao) {
        this.notificacao = notificacao;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the idViagem
     */
    public int getIdViagem() {
        return idViagem;
    }

    /**
     * @param idViagem the idViagem to set
     */
    public void setIdViagem(int idViagem) {
        this.idViagem = idViagem;
    }
}