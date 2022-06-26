package br.com.sistock.dao;

import br.com.sistock.modelo.Movimentacao;
import br.com.sistock.modelo.Produto;
import br.com.sistock.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class SaldoDAO implements GenericDAO {

    private Connection conexao;
    private PreparedStatement stmt;
    private ResultSet rs;

    public SaldoDAO() {
        try {
            this.conexao = ConnectionFactory.conectar();
        } catch (Exception e) {
            System.out.println("Erro ao criar conexão com o BD " + e.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(Integer codigo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object object) throws Exception {
        try {
            Produto produto = (Produto) object;
            String sql = "UPDATE produto SET saldo_estoque = saldo_estoque + ? WHERE id = ?";
            this.stmt = this.conexao.prepareStatement(sql);

            this.stmt.setInt(1, produto.getSaldo_estoque());
            this.stmt.setInt(2, produto.getId());
            this.stmt.executeUpdate();

            return true;
            
        } catch (Exception e) {
            System.out.println("Erro ao alterar produtoDAO " + e.getMessage());
            return false;
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
    }

    @Override
    public Boolean excluir(Integer codigo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
