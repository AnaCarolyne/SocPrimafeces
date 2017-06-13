package controller;

import DAO.OrganizadorDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Organizador;

public class ManterOrganizadorController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else if (acao.equals("confirmarIncluir")) {
            confirmarIncluir(request, response);
        } else if (acao.equals("prepararEditar")) {
            prepararEditar(request, response);
        } else if (acao.equals("confirmarEditar")) {
            confirmarEditar(request, response);
        } else if (acao.equals("prepararExcluir")) {
            prepararExcluir(request, response);
        } else if (acao.equals("confirmarExcluir")) {
            confirmarExcluir(request, response);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterOrganizadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterOrganizadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterOrganizadorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterOrganizadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException, ServletException {
        try {
            request.setAttribute("operacao", "Incluir");

            RequestDispatcher view = request.getRequestDispatcher("/manterOrganizador.jsp");
            view.forward(request, response);
         } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException, ServletException {
        try {
            int idOrganizador = Integer.parseInt(request.getParameter("idOrganizador"));
            String cpf = request.getParameter("cpf");
            String senha = request.getParameter("senha");

            Organizador organizador = new Organizador(idOrganizador, cpf, senha);
            OrganizadorDAO.obterInstancia().gravar(organizador);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaOrganizadorController");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    private void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException, ServletException {
        try {
            request.setAttribute("operacao", "Editar");

            Organizador organizador = OrganizadorDAO.obterInstancia().obterOrganizador(Integer.parseInt(request.getParameter("idOrganizador")));
            request.setAttribute("organizador", organizador);

            RequestDispatcher view = request.getRequestDispatcher("/manterOrganizador.jsp");
            view.forward(request, response);
         } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException, ServletException {

        try {
            int idOrganizador = Integer.parseInt(request.getParameter("idOrganizador"));
            String cpf = request.getParameter("cpf");
            String senha = request.getParameter("senha");

            Organizador organizador = new Organizador(idOrganizador, cpf, senha);
            OrganizadorDAO.obterInstancia().alterar(organizador);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaOrganizadorController");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        try {
            request.setAttribute("operacao", "Excluir");

            Organizador organizador = OrganizadorDAO.obterInstancia().obterOrganizador(Integer.parseInt(request.getParameter("idOrganizador")));
            request.setAttribute("organizador", organizador);

            RequestDispatcher view = request.getRequestDispatcher("/manterOrganizador.jsp");
            view.forward(request, response);
         } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int idOrganizador = Integer.parseInt(request.getParameter("idOrganizador"));
            String cpf = request.getParameter("cpf");
            String senha = request.getParameter("senha");

            Organizador organizador = new Organizador(idOrganizador, cpf, senha);
            OrganizadorDAO.obterInstancia().excluir(organizador);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaOrganizadorController");
            view.forward(request, response);
         } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }
}
