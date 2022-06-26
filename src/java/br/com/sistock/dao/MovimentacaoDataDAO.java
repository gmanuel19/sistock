/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistock.dao;

import br.com.sistock.modelo.Contagem;
import br.com.sistock.modelo.Movimentacao;
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
public class MovimentacaoDataDAO implements GenericDAO {
    
     
    private Connection conexao;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public MovimentacaoDataDAO(){
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
        List<Object> listaMovimentacao = new ArrayList<>();
        try {
            String sql = "select * from movimentacao WHERE data_hora = ? ORDER BY id_movimentacao DESC";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setDate(1, new java.sql.Date(contagem.getData_alteracao().getTime()));
            this.rs = this.stmt.executeQuery();

            while (this.rs.next()) {
                Movimentacao moviment = new Movimentacao();
                
                moviment.setId_movimentacao(this.rs.getInt("id_movimentacao"));
                moviment.setProduto(this.rs.getString("produto"));
                moviment.setQtd_pacote(this.rs.getInt("qtd_pacote"));
                moviment.setQtd_unidade(this.rs.getInt("qtd_unidade"));
                moviment.setData_hora(this.rs.getDate("data_hora"));
                moviment.setUsuario(this.rs.getString("usuario"));
                moviment.setTipo_movimentacao(this.rs.getString("tipo_movimentacao"));
                moviment.setRomaneio(this.rs.getString("romaneio"));
                moviment.setMotivo(this.rs.getString("motivo"));

                listaMovimentacao.add(moviment);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar movimentacaoDAO " + e.getMessage());
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }

        return listaMovimentacao;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean excluir(Integer codigo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
