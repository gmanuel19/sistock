package br.com.sistock.dao;

import br.com.sistock.modelo.Contagem;
import br.com.sistock.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ContagemProdutoDAO implements GenericDAO {
    
    private Connection conexao;
    private PreparedStatement stmt;
    private ResultSet rs;

    public ContagemProdutoDAO() {
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
            String sql = "select * from contagem WHERE produto LIKE ? ORDER BY id DESC";
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setString(1, '%' + contagem.getProduto() + '%');
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
