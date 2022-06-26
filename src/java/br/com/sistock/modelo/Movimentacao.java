package br.com.sistock.modelo;

import java.util.Date;

public class Movimentacao {
    private Integer id_movimentacao;
    private String produto;
    private Integer qtd_pacote;
    private Integer qtd_unidade;
    private Date data_hora;
    private String data_string;
    private String usuario;
    private String tipo_movimentacao;
    private String romaneio;
    private String motivo;
    
    public Movimentacao(){}
    
    public Movimentacao(Integer id_movimentacao, String produto, Integer qtd_pacote, Integer qtd_unidade, Date data_hora, String data_string, String usuario, String tipo_movimentacao, String romaneio, String motivo){
        this.id_movimentacao = id_movimentacao;
        this.produto = produto;
        this.qtd_pacote = qtd_pacote;
        this.qtd_unidade = qtd_unidade;
        this.data_hora = data_hora;
        this.data_string = data_string;
        this.usuario = usuario;
        this.tipo_movimentacao = tipo_movimentacao;
        this.romaneio = romaneio;
        this.motivo = motivo;
    }

    public String getData_string() {
        return data_string;
    }

    public void setData_string(String data_string) {
        this.data_string = data_string;
    }
    
    

    public Integer getId_movimentacao() {
        return id_movimentacao;
    }

    public void setId_movimentacao(Integer id_movimentacao) {
        this.id_movimentacao = id_movimentacao;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getQtd_pacote() {
        return qtd_pacote;
    }

    public void setQtd_pacote(Integer qtd_pacote) {
        this.qtd_pacote = qtd_pacote;
    }

    public Integer getQtd_unidade() {
        return qtd_unidade;
    }

    public void setQtd_unidade(Integer qtd_unidade) {
        this.qtd_unidade = qtd_unidade;
    }

    public Date getData_hora() {
        return data_hora;
    }

    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTipo_movimentacao() {
        return tipo_movimentacao;
    }

    public void setTipo_movimentacao(String tipo_movimentacao) {
        this.tipo_movimentacao = tipo_movimentacao;
    }

    public String getRomaneio() {
        return romaneio;
    }

    public void setRomaneio(String romaneio) {
        this.romaneio = romaneio;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    
}