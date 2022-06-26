package br.com.sistock.dao;

import br.com.sistock.modelo.Movimentacao;
import br.com.sistock.modelo.Produto;
import br.com.sistock.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class SaidaDAO implements GenericDAO {
    private Connection conexao;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public SaidaDAO(){
        try{
            this.conexao = ConnectionFactory.conectar();
        }catch(Exception e){
            System.out.println("Erro ao criar conexão com o BD " + e.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> listar() throws Exception {
        List<Object> listaMovimentacao = new ArrayList<>();
        try{
                String sql = "SELECT * FROM movimentacao WHERE tipo_movimentacao = 'Saída' ORDER BY id_movimentacao DESC";
            this.stmt = this.conexao.prepareStatement(sql);
            this.rs = this.stmt.executeQuery();
            
            while(this.rs.next()){
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
        try{
            Produto produto = (Produto) object;
            String sql = "UPDATE produto SET saldo_estoque = saldo_estoque - ? WHERE id = ?";
            this.stmt = this.conexao.prepareStatement(sql);
            
            this.stmt.setInt(1, produto.getSaldo_estoque());
            this.stmt.setInt(2, produto.getId());
            
            this.stmt.executeUpdate();
            
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
