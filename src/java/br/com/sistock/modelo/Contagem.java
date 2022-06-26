package br.com.sistock.modelo;

import java.util.Date;

public class Contagem {

    private Integer id;    
    private Date data_contagem;
    private String tipo_movimentacao;
    private Integer qtd_movimentacao;
    private Integer saldo;
    private Integer contagem;
    private Integer diferenca;
    private String usuario;
    private String produto;
    
    private Date data_alteracao;
    private String data_string;

    public Contagem(Integer id, Date data_contagem, String tipo_movimentacao, Integer qtd_movimentacao, Integer saldo, Integer contagem, Integer diferenca, String usuario, String produto, Date data_alteracao, String data_string) {
        this.id = id;
        this.data_contagem = data_contagem;
        this.tipo_movimentacao = tipo_movimentacao;
        this.qtd_movimentacao = qtd_movimentacao;
        this.saldo = saldo;
        this.contagem = contagem;
        this.diferenca = diferenca;
        this.usuario = usuario;
        this.produto = produto;
        this.data_alteracao = data_alteracao;
        this.data_string = data_string;
    }

    public Contagem() {
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the data_contagem
     */
    public Date getData_contagem() {
        return data_contagem;
    }

    /**
     * @param data_contagem the data_contagem to set
     */
    public void setData_contagem(Date data_contagem) {
        this.data_contagem = data_contagem;
    }

    /**
     * @return the tipo_movimentacao
     */
    public String getTipo_movimentacao() {
        return tipo_movimentacao;
    }

    /**
     * @param tipo_movimentacao the tipo_movimentacao to set
     */
    public void setTipo_movimentacao(String tipo_movimentacao) {
        this.tipo_movimentacao = tipo_movimentacao;
    }

    /**
     * @return the qtd_movimentacao
     */
    public Integer getQtd_movimentacao() {
        return qtd_movimentacao;
    }

    /**
     * @param qtd_movimentacao the qtd_movimentacao to set
     */
    public void setQtd_movimentacao(Integer qtd_movimentacao) {
        this.qtd_movimentacao = qtd_movimentacao;
    }

    /**
     * @return the saldo
     */
    public Integer getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the contagem
     */
    public Integer getContagem() {
        return contagem;
    }

    /**
     * @param contagem the contagem to set
     */
    public void setContagem(Integer contagem) {
        this.contagem = contagem;
    }

    /**
     * @return the diferenca
     */
    public Integer getDiferenca() {
        return diferenca;
    }

    /**
     * @param diferenca the diferenca to set
     */
    public void setDiferenca(Integer diferenca) {
        this.diferenca = diferenca;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the produto
     */
    public String getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(String produto) {
        this.produto = produto;
    }    

    public Date getData_alteracao() {
        return data_alteracao;
    }

    public void setData_alteracao(Date data_alteracao) {
        this.data_alteracao = data_alteracao;
    }

    public String getData_string() {
        return data_string;
    }

    public void setData_string(String data_string) {
        this.data_string = data_string;
    }
    
    
    
}