package br.com.sistock.dao;

import br.com.sistock.modelo.Contagem;
import br.com.sistock.modelo.Movimentacao;
import br.com.sistock.modelo.Produto;
import br.com.sistock.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import static javax.xml.bind.DatatypeConverter.parseDate;

public class ContagemDAO implements GenericDAO {

    private Connection conexao;
    private PreparedStatement stmt;
    private ResultSet rs;

    public ContagemDAO() {
        try {
            this.conexao = ConnectionFactory.conectar();
        } catch (Exception e) {
            System.out.println("Erro ao criar conexão com o BD " + e.getMessage());
        }
    }

    int varSaldo;
    int varQtdProduto;

    @Override
    public Boolean cadastrar(Object object) throws Exception {
        try {
            
            Contagem contagem = (Contagem) object;
            
            String sql = "INSERT INTO contagem (produto, data_contagem, tipo_movimentacao, qtd_movimentacao, saldo, data_string) VALUES (?, ?, ?, ?, ?, ?)";

            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setString(1, contagem.getProduto());
            this.stmt.setDate(2, new java.sql.Date(contagem.getData_contagem().getTime()));
            this.stmt.setString(3, contagem.getTipo_movimentacao());
            this.stmt.setInt(4, contagem.getQtd_movimentacao());
            this.stmt.setInt(5, contagem.getSaldo());
            this.stmt.setString(6, contagem.getData_string());
            this.stmt.execute();
            
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar contagemDAO " + e.getMessage());
            return false;
        } finally {
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
    }

    @Override
    public List<Object> listar() throws Exception {
        List<Object> listaContagem = new ArrayList<>();
        try {
            String sql = "select * from contagem ORDER BY id DESC";
            this.stmt = this.conexao.prepareStatement(sql);
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
                cont.setData_string(this.rs.getString("data_string"));
                
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
        try{
            Contagem contagem = (Contagem) object;
            String sql = "UPDATE contagem SET contagem = ?, diferenca = ?, usuario = ? WHERE produto = ? AND data_contagem = ?";
            this.stmt = this.conexao.prepareStatement(sql);
            
            this.stmt.setInt(1, contagem.getContagem());
            this.stmt.setInt(2, contagem.getDiferenca());
            this.stmt.setString(3, contagem.getUsuario());
            this.stmt.setString(4, contagem.getProduto());
            this.stmt.setDate(5, new java.sql.Date(contagem.getData_alteracao().getTime()));
            this.stmt.executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println("Erro ao alterar movimentacaoDAO " + e.getMessage());
            return false;
        }finally{
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
    }

    @Override
    public Boolean excluir(Integer codigo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
