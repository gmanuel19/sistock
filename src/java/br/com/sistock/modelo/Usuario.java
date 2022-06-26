package br.com.sistock.modelo;

public class Usuario {
   private Integer id;
   private String nome;
   private String usuario;
   private String cargo;
   private String email;
   private String cpf;
   private String senha;
   
   public Usuario(){}
   
   public Usuario(Integer id, String nome, String usuario, String cargo, String email, String cpf, String senha){
       this.id = id;
       this.nome = nome;
       this.usuario = usuario;
       this.cargo = cargo;
       this.email = email;
       this.cpf = cpf;
       this.senha = senha;
   }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
   
   
}
