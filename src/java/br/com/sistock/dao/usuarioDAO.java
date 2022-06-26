package br.com.sistock.dao;

import br.com.sistock.modelo.Usuario;
import br.com.sistock.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class usuarioDAO implements GenericDAO{
    private Connection conexao;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public usuarioDAO(){
        try{
            this.conexao = ConnectionFactory.conectar();
        }catch(Exception e){
            System.out.println("Erro ao criar conexão com o BD " + e.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) throws Exception {
        try{
            Usuario usuario = (Usuario) object;
            String sql = "INSERT INTO usuario (nome, usuario, cpf, senha, cargo, email) VALUES (?, ?, ?, md5(?), ?, ?)";
            
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setString(1, usuario.getNome());
            this.stmt.setString(2, usuario.getUsuario());
            this.stmt.setString(3, usuario.getCpf());
            this.stmt.setString(4, usuario.getSenha());
            this.stmt.setString(5, usuario.getCargo());
            this.stmt.setString(6, usuario.getEmail());
            this.stmt.execute();
            
            return true;
        }
        catch(Exception e){
            System.out.println("Erro ao cadastrar usuarioDAO " + e.getMessage());
            return false;
        }
        finally{
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
    }

    @Override
    public List<Object> listar() throws Exception {
        List<Object> listaUsuarios = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM usuario ORDER BY id DESC";
            this.stmt = this.conexao.prepareStatement(sql);
            this.rs = this.stmt.executeQuery();
            
            while(this.rs.next()){
                Usuario usuarios = new Usuario();
                
                usuarios.setId(this.rs.getInt("id"));
                usuarios.setNome(this.rs.getString("nome"));
                usuarios.setUsuario(this.rs.getString("usuario"));
                usuarios.setCargo(this.rs.getString("cargo"));
                usuarios.setEmail(this.rs.getString("email"));

                listaUsuarios.add(usuarios);
            }
        }
        catch(Exception e){
            System.out.println("Erro ao listar usuarioDAO " + e.getMessage());
        }finally{
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        
        return listaUsuarios;
    }

    @Override
    public Object carregar(Integer codigo) throws Exception {
        Usuario usuario = new Usuario();
        
        try{
            String sql = "SELECT * FROM usuario WHERE id = ?";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, codigo);
            
            this.rs = this.stmt.executeQuery();
            rs.next();
            
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setCpf(rs.getString("cpf"));
            usuario.setCargo(rs.getString("cargo"));
            usuario.setEmail(rs.getString("email"));
            usuario.setUsuario(rs.getString("usuario"));
        }
        catch(Exception e){
            System.out.println("Erro ao carregar usuarioDAO" + e.getMessage());
        }finally{
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        
        return usuario; 
    }

    @Override
    public Boolean alterar(Object object) throws Exception {
        try{
            Usuario usuario = (Usuario) object;
            String sql = "UPDATE usuario SET nome = ?, cpf = ?, senha = ?, cargo = ?, email = ?, usuario = ? WHERE id = ?";
            this.stmt = this.conexao.prepareStatement(sql);
            
            this.stmt.setString(1, usuario.getNome());
            this.stmt.setString(2, usuario.getCpf());
            this.stmt.setString(3, usuario.getSenha());
            this.stmt.setString(4, usuario.getCargo());
            this.stmt.setString(5, usuario.getEmail());
            this.stmt.setString(6, usuario.getUsuario());
            this.stmt.setInt(7, usuario.getId());
            
            this.stmt.executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println("Erro ao alterar usuarioDAO " + e.getMessage());
            return false;
        }finally{
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
    }

    @Override
    public Boolean excluir(Integer codigo) throws Exception {
        try {
            String sql = "DELETE FROM usuario WHERE id = ?";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, codigo);
            this.stmt.execute();

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao excluir usuarioDAO" + e.getMessage());
            return false;
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
    }
    
    public Usuario logar(Usuario obj) throws Exception{
        Usuario user = new Usuario();
        
        try{
            String sql = "SELECT * FROM usuario WHERE email = ? AND senha = md5(?)";
            this.stmt = this.conexao.prepareStatement(sql);
            
            this.stmt.setString(1, obj.getEmail());
            this.stmt.setString(2, obj.getSenha());
            
            this.rs = this.stmt.executeQuery();
            
            if(this.rs.next()){
                user.setId(this.rs.getInt("id"));
                user.setNome(this.rs.getString("nome"));
                user.setUsuario(this.rs.getString("usuario"));
                user.setCargo(this.rs.getString("cargo"));
                user.setEmail(this.rs.getString("email"));
                user.setSenha(this.rs.getString("senha"));
            }
        }
        catch(Exception e){
            System.out.println("Erro ao conectar usuárioDAO " + e.getMessage());
        } finally{
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        return user;
    }
    
}
