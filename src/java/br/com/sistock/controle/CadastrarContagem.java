/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistock.controle;

import br.com.sistock.dao.ContagemDAO;
import br.com.sistock.modelo.Contagem;
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
@WebServlet(name = "CadastrarContagem", urlPatterns = {"/CadastrarContagem"})
public class CadastrarContagem extends HttpServlet {

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
        try {
            String usuario = request.getParameter("usuario");
            Integer getProdSaldo = Integer.parseInt(request.getParameter("getProdutoSaldo"));
            String produto = request.getParameter("produto");
            String dataContagem = request.getParameter("dataContagem"); 
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            Integer qtdContagem = Integer.parseInt(request.getParameter("qtdContagem"));
            Integer diferenca = getProdSaldo - qtdContagem;

            Contagem contagem = new Contagem();
            contagem.setContagem(qtdContagem);
            contagem.setDiferenca(diferenca);
            contagem.setUsuario(usuario);
            contagem.setProduto(produto);
            contagem.setData_alteracao(date.parse(dataContagem));            
            
            ContagemDAO dao = new ContagemDAO();
            dao.alterar(contagem);

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar contagemCTR " + e.getMessage());
        } finally {
            response.sendRedirect("ListarContagem");
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
