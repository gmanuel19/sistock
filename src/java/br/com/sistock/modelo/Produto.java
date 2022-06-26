package br.com.sistock.modelo;

public class Produto {

    private Integer id;
    private String codigo;
    private String descricao;
    private String familia;
    private Integer saldo_estoque;

    public Produto() {
    }

    public Produto(Integer id) {
        this.id = id;
    }        

    public Produto(Integer id, String codigo, String descricao, String familia, Integer saldo_estoque) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.familia = familia;
        this.saldo_estoque = saldo_estoque;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public Integer getSaldo_estoque() {
        return saldo_estoque;
    }

    public void setSaldo_estoque(Integer saldo_estoque) {
        this.saldo_estoque = saldo_estoque;
    }
    
    

}
