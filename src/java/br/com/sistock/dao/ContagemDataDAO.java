/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistock.dao;

import br.com.sistock.modelo.Contagem;
import br.com.sistock.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guilh
 */
public class ContagemDataDAO implements GenericDAO {
    
    private Connection conexao;
    private PreparedStatement stmt;
    private ResultSet rs;

    public ContagemDataDAO() {
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

    public List<Object> listarFiltro(Object object) throws Exception {
        Contagem contagem = (Contagem) object;
        List<Object> listaContagem = new ArrayList<>();
        try {
            String sql = "select * from contagem WHERE data_contagem = ? ORDER BY id DESC";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setDate(1, new java.sql.Date(contagem.getData_alteracao().getTime()));
            this.rs = this.stmt.executeQuery();

            while (this.rs.next()) {
                Contagem cont = new Contagem();

                cont.setId(this.rs.getInt("id"));
                cont.setProduto(this.rs.getString("produto"));
                cont.setData_contagem(this.rs.getDate("data_contagem"));
                cont.setTipo_movimentacao(this.rs.getString("tipo_movimentacao"));
                cont.setQtd_movimentacao(this.rs.getInt("qtd_movimentacao"));
                cont.setSaldo(this.rs.getInt("saldo"));
                cont.setContagem(this.rs.getInt("contagem"));
                cont.setDiferenca(this.rs.getInt("diferenca"));
                cont.setUsuario(this.rs.getString("usuario"));
                
                listaContagem.add(cont);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar movimentacaoDAO " + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }

        return listaContagem;
    }

    @Override
    public Object carregar(Integer codigo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean excluir(Integer codigo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
