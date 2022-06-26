package br.com.sistock.controle;

import br.com.sistock.dao.usuarioDAO;
import br.com.sistock.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/CadastrarUsuario"})
public class CadastrarUsuario extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            String email = request.getParameter("email");
            String cargo = request.getParameter("cargo");
            
            Usuario user = new Usuario();
            user.setNome(nome);
            user.setCpf(cpf);
            user.setUsuario(usuario);
            user.setSenha(senha);
            user.setEmail(email);
            user.setCargo(cargo);
            
            usuarioDAO usuariodao = new usuarioDAO();
            usuariodao.cadastrar(user);
            
        }
        catch(Exception e){
            System.out.println("Erro ao cadastrar usuarioCTR " + e.getMessage());
        }
        finally{
            //request.getRequestDispatcher("ListarUsuarios").forward(request, response);
            response.sendRedirect("ListarUsuarios");
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
