package br.com.sistock.dao;

import br.com.sistock.modelo.Movimentacao;
import br.com.sistock.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovimentacaoDAO implements GenericDAO {

    private Connection conexao;
    private PreparedStatement stmt;
    private ResultSet rs;

    public MovimentacaoDAO() {
        try {
            this.conexao = ConnectionFactory.conectar();
        } catch (Exception e) {
            System.out.println("Erro ao criar conexão com o BD " + e.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) throws Exception {
        try{
            Movimentacao movimentacao = (Movimentacao) object;
            String sql = "INSERT INTO movimentacao (produto, qtd_pacote, qtd_unidade, data_hora, usuario, tipo_movimentacao, romaneio, motivo, data_string) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            this.stmt = this.conexao.prepareStatement(sql);
            this.stmt.setString(1, movimentacao.getProduto());
            this.stmt.setInt(2, movimentacao.getQtd_pacote());
            this.stmt.setInt(3, movimentacao.getQtd_unidade());
            this.stmt.setDate(4, new java.sql.Date(movimentacao.getData_hora().getTime()));
            this.stmt.setString(5, movimentacao.getUsuario());
            this.stmt.setString(6, movimentacao.getTipo_movimentacao());
            this.stmt.setString(7, movimentacao.getRomaneio());
            this.stmt.setString(8, movimentacao.getMotivo());
            this.stmt.setString(9, movimentacao.getData_string());
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
        List<Object> listaMovimentacao = new ArrayList<>();
        try{
            String sql = "SELECT * FROM movimentacao ORDER BY id_movimentacao DESC";
            this.stmt = this.conexao.prepareStatement(sql);
            this.rs = this.stmt.executeQuery();
            
            while(this.rs.next()){
                Movimentacao moviment = new Movimentacao();
                
                moviment.setId_movimentacao(this.rs.getInt("id_movimentacao"));
                moviment.setProduto(this.rs.getString("produto"));
                moviment.setQtd_pacote(this.rs.getInt("qtd_pacote"));
                moviment.setQtd_unidade(this.rs.getInt("qtd_unidade"));
                moviment.setData_hora(this.rs.getDate("data_hora"));
                moviment.setData_string(this.rs.getString("data_string"));
                moviment.setUsuario(this.rs.getString("usuario"));
                moviment.setTipo_movimentacao(this.rs.getString("tipo_movimentacao"));
                moviment.setRomaneio(this.rs.getString("romaneio"));
                moviment.setMotivo(this.rs.getString("motivo"));

                listaMovimentacao.add(moviment);
            }
        }
        catch(Exception e){
            System.out.println("Erro ao listar movimentacaoDAO " + e.getMessage());
        }finally{
            ConnectionFactory.fecharConexao(conexao, stmt, rs);
        }
        
        return listaMovimentacao;
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
