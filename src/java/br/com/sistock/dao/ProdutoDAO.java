package br.com.sistock.dao;

import br.com.sistock.modelo.Produto;
import br.com.sistock.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO implements GenericDAO{
    private Connection conexao;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public ProdutoDAO(){
        try{
            this.conexao = ConnectionFactory.conectar();
        }catch(Exception e){
            System.out.println("Erro ao criar conexão com o BD " + e.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) throws Exception {
        try{
            Produto produto = (Produto) object;
            String sql = "INSERT INTO produto (descricao, familia, codigo, saldo_estoque) VALUES (?, ?, ?, ?)";
            
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setString(1, produto.getDescricao());
            this.stmt.setString(2, produto.getFamilia());
            this.stmt.setString(3, produto.getCodigo());
            this.stmt.setInt(4, produto.getSaldo_estoque());
            this.stmt.execute();
            
            return true;
        }
        catch(Exception e){
            System.out.println("Erro ao cadastrar produtoDAO " + e.getMessage());
            return false;
        }
        finally{
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
    }

    @Override
    public List<Object> listar() throws Exception {
        List<Object> listaProdutos = new ArrayList<>();
        try{
            String sql = "SELECT * FROM produto ORDER BY id DESC";
            this.stmt = this.conexao.prepareStatement(sql);
            this.rs = this.stmt.executeQuery();
            
            while(this.rs.next()){
                Produto produtos = new Produto();
                
                produtos.setId(this.rs.getInt("id"));
                produtos.setCodigo(this.rs.getString("codigo"));
                produtos.setDescricao(this.rs.getString("descricao"));
                produtos.setFamilia(this.rs.getString("familia"));
                produtos.setSaldo_estoque(this.rs.getInt("saldo_estoque"));

                listaProdutos.add(produtos);
            }
        }
        catch(Exception e){
            System.out.println("Erro ao listar usuarioDAO " + e.getMessage());
        }finally{
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        
        return listaProdutos;
    }

    @Override
    public Object carregar(Integer codigo) throws Exception {
        Produto produto = new Produto();
        
        try{
            String sql = "SELECT * FROM produto WHERE id = ?";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, codigo);
            
            this.rs = this.stmt.executeQuery();
            rs.next();
            
            produto.setId(rs.getInt("id"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setFamilia(rs.getString("familia"));
            produto.setCodigo(rs.getString("codigo"));
            produto.setSaldo_estoque(rs.getInt("saldo_estoque"));
        }
        catch(Exception e){
            System.out.println("Erro ao carregar produtoDAO" + e.getMessage());
        }finally{
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        
        return produto; 
    }

    @Override
    public Boolean alterar(Object object) throws Exception {
        try{
            Produto produto = (Produto) object;
            String sql = "UPDATE produto SET codigo = ?, descricao = ?, familia = ? WHERE id = ?";
            this.stmt = this.conexao.prepareStatement(sql);
            
            this.stmt.setString(1, produto.getCodigo());
            this.stmt.setString(2, produto.getDescricao());
            this.stmt.setString(3, produto.getFamilia());
            this.stmt.setInt(4, produto.getId());
            
            this.stmt.execute();
            
            return true;
        }catch(Exception e){
            System.out.println("Erro ao alterar produtoDAO " + e.getMessage());
            return false;
        }finally{
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
    }

    @Override
    public Boolean excluir(Integer codigo) throws Exception {
        try {
            String sql = "DELETE FROM produto WHERE id = ?";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setInt(1, codigo);
            this.stmt.execute();

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao excluir produtoDAO" + e.getMessage());
            return false;
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
    }
    
}
