/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistock.controle;

import br.com.sistock.dao.ContagemDAO;
import br.com.sistock.dao.MovimentacaoDAO;
import br.com.sistock.dao.ProdutoDAO;
import br.com.sistock.dao.SaidaDAO;
import br.com.sistock.dao.SaldoDAO;
import br.com.sistock.modelo.Contagem;
import br.com.sistock.modelo.Movimentacao;
import br.com.sistock.modelo.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilh
 */
@WebServlet(name = "CadastrarMovimentacao", urlPatterns = {"/CadastrarMovimentacao"})
public class CadastrarMovimentacao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{            
            Integer idProduto = Integer.parseInt(request.getParameter("produtoId"));
            Integer getProdSaldo = Integer.parseInt(request.getParameter("getProdutoSaldo"));
            
            String usuario = request.getParameter("usuario");
            String produto = request.getParameter("produto");
            String romaneio = request.getParameter("romaneio");
            String tipoMovimento = request.getParameter("movimento");
            String motivo = request.getParameter("motivo");
            Integer pacote = Integer.parseInt(request.getParameter("qtdPac"));
            Integer unidade = Integer.parseInt(request.getParameter("qtdUnd"));
            String dataCadastro = request.getParameter("lblData");
            
            Movimentacao movi = new Movimentacao();
            movi.setUsuario(usuario);
            movi.setProduto(produto);
            movi.setRomaneio(romaneio);
            movi.setTipo_movimentacao(tipoMovimento);
            movi.setMotivo(motivo);
            movi.setQtd_pacote(pacote);
            movi.setQtd_unidade(unidade);
            
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            movi.setData_hora(date.parse(dataCadastro));
           
            movi.setData_string(dataCadastro);
            
            MovimentacaoDAO dao = new MovimentacaoDAO();
            dao.cadastrar(movi);
            
            Produto produt = new Produto();
            produt.setSaldo_estoque(unidade);
            produt.setId(idProduto);
            
            
            Contagem contagem = new Contagem();
            contagem.setProduto(produto);
            
            contagem.setData_contagem(new java.util.Date());
            contagem.setTipo_movimentacao(tipoMovimento);
            contagem.setQtd_movimentacao(idProduto);
            contagem.setQtd_movimentacao(unidade);  
            contagem.setData_contagem(date.parse(dataCadastro));
            contagem.setData_string(dataCadastro);
            
            if("Entrada".equals(tipoMovimento)){        
                SaldoDAO dao2 = new SaldoDAO();
                dao2.alterar(produt);
                
                ContagemDAO daoCont = new ContagemDAO();
                contagem.setSaldo(getProdSaldo + unidade);
                daoCont.cadastrar(contagem);
            } else{
                SaidaDAO dao3 = new SaidaDAO();
                dao3.alterar(produt);
                
                ContagemDAO daoCont = new ContagemDAO();
                contagem.setSaldo(getProdSaldo - unidade);
                daoCont.cadastrar(contagem);
            }
            
            
            /*
            ContagemDAO dao2 = new ContagemDAO();
            dao2.cadastrar(cont);*/
            
            /*
            SaldoDAO dao3 = new SaldoDAO();
            dao3.alterar(cont);*/
        }
        catch(Exception e){
            System.out.println("Erro ao cadastrar movimentacaoCTR " + e.getMessage());
        }
        finally{
            //request.getRequestDispatcher("ListarMovimentacao").forward(request, response);
            response.sendRedirect("ListarMovimentacao");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
