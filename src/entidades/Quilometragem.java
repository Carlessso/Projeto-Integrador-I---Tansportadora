/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author ramon
 */
public class Quilometragem {
    private String origem;
    private String destino;
    private String quilometragem;
    private int metragem;
    private String tempo;
    
    public Quilometragem(){
        this.origem = "";
        this.destino = "";
        this.quilometragem = "";
        this.tempo = "";
        this.metragem = 0;
    }
    
    public Quilometragem(String origem, String destino, String quilometragem, String tempo, int metragem){
        this.origem = origem;
        this.destino = destino;
        this.quilometragem = quilometragem;
        this.tempo = tempo;
        this.metragem = metragem;
    }

    /**
     * @return the origem
     */
    public String getOrigem() {
        return origem;
    }

    /**
     * @param origem the origem to set
     */
    public void setOrigem(String origem) {
        this.origem = origem;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the quilometragem
     */
    public String getQuilometragem() {
        return quilometragem;
    }

    /**
     * @param quilometragem the quilometragem to set
     */
    public void setQuilometragem(String quilometragem) {
        this.quilometragem = quilometragem;
    }

    /**
     * @return the tempo
     */
    public String getTempo() {
        return tempo;
    }

    /**
     * @param tempo the tempo to set
     */
    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    /**
     * @return the metragem
     */
    public int getMetragem() {
        return metragem;
    }

    /**
     * @param metragem the metragem to set
     */
    public void setMetragem(int metragem) {
        this.metragem = metragem;
    }
}
