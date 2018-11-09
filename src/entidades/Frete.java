package entidades;
// Generated 11/09/2018 09:51:52 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.envers.Audited;

/**
 * Frete generated by hbm2java
 */
@Audited
public class Frete implements java.io.Serializable {

    private int id;
    private Endereco endereco;
    private EstadoFrete estadoFrete;
    private Pessoa pessoaByRefDetinatario;
    private Pessoa pessoaByRefSolicitante;
    private Unidade unidade;
    private Usuario usuario;
    private BigDecimal valor;
    private Date dataPedido;
    private Date dataEntrega;
    private Set freteViagems = new HashSet(0);
    private Set produtosFretes = new HashSet(0);
    private String quilometragem;
    private int metragem;
    private String tempo;
    private Unidade unidadeAtual;

    public Frete() {
    }

    public Frete(int id, Endereco endereco, EstadoFrete estadoFrete, Pessoa pessoaByRefDetinatario, Pessoa pessoaByRefSolicitante, Unidade unidade, Usuario usuario, BigDecimal valor, Date dataPedido, String quilometragem, int metragem, String tempo, Unidade unidadeAtual) {
        this.id = id;
        this.endereco = endereco;
        this.estadoFrete = estadoFrete;
        this.pessoaByRefDetinatario = pessoaByRefDetinatario;
        this.pessoaByRefSolicitante = pessoaByRefSolicitante;
        this.unidade = unidade;
        this.usuario = usuario;
        this.valor = valor;
        this.dataPedido = dataPedido;
        this.quilometragem = quilometragem;
        this.metragem = metragem;
        this.tempo = tempo;
        this.unidadeAtual = unidadeAtual;
    }

    public Frete(int id, Endereco endereco, EstadoFrete estadoFrete, Pessoa pessoaByRefDetinatario, Pessoa pessoaByRefSolicitante, Unidade unidade, Usuario usuario, BigDecimal valor, Date dataPedido, Date dataEntrega, Set freteViagems, Set produtosFretes, String quilometragem, int metragem, String tempo, Unidade unidadeAtual) {
        this.id = id;
        this.endereco = endereco;
        this.estadoFrete = estadoFrete;
        this.pessoaByRefDetinatario = pessoaByRefDetinatario;
        this.pessoaByRefSolicitante = pessoaByRefSolicitante;
        this.unidade = unidade;
        this.usuario = usuario;
        this.valor = valor;
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.freteViagems = freteViagems;
        this.produtosFretes = produtosFretes;
        this.quilometragem = quilometragem;
        this.metragem = metragem;
        this.tempo = tempo;
        this.unidadeAtual = unidadeAtual;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public EstadoFrete getEstadoFrete() {
        return this.estadoFrete;
    }

    public void setEstadoFrete(EstadoFrete estadoFrete) {
        this.estadoFrete = estadoFrete;
    }

    public Pessoa getPessoaByRefDetinatario() {
        return this.pessoaByRefDetinatario;
    }

    public void setPessoaByRefDetinatario(Pessoa pessoaByRefDetinatario) {
        this.pessoaByRefDetinatario = pessoaByRefDetinatario;
    }

    public Pessoa getPessoaByRefSolicitante() {
        return this.pessoaByRefSolicitante;
    }

    public void setPessoaByRefSolicitante(Pessoa pessoaByRefSolicitante) {
        this.pessoaByRefSolicitante = pessoaByRefSolicitante;
    }

    public Unidade getUnidade() {
        return this.unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataPedido() {
        return this.dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataEntrega() {
        return this.dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Set getFreteViagems() {
        return this.freteViagems;
    }

    public void setFreteViagems(Set freteViagems) {
        this.freteViagems = freteViagems;
    }

    public Set getProdutosFretes() {
        return this.produtosFretes;
    }

    public void setProdutosFretes(Set produtosFretes) {
        this.produtosFretes = produtosFretes;
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

    public Unidade getUnidadeAtual() {
        return this.unidadeAtual;
    }

    public void setUnidadeAtual(Unidade unidadeAtual) {
        this.unidadeAtual = unidadeAtual;
    }

}
