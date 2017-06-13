/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CorridaDAO;
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
import modelo.Corrida;
import modelo.Organizador;

/**
 *
 * @author Ana Carolyne
 */
public class ManterCorridaController extends HttpServlet {

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
            Logger.getLogger(ManterCorridaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterCorridaController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterCorridaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterCorridaController.class.getName()).log(Level.SEVERE, null, ex);
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

    private void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {
        try {
            request.setAttribute("operacao", "Incluir");

            request.setAttribute("organizadores", OrganizadorDAO.obterInstancia().obterOrganizadores());

            RequestDispatcher view = request.getRequestDispatcher("/manterCorrida.jsp");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {

        try {

            int idCorrida = Integer.parseInt(request.getParameter("idCorrida"));
            String nomeCorrida = request.getParameter("nomeCorrida");
            String data = request.getParameter("data");
            String horario = request.getParameter("horario");
            int maximoAtletas = Integer.parseInt(request.getParameter("maximoAtletas"));
            String estado = request.getParameter("estado");

            Organizador organizador = OrganizadorDAO.obterInstancia().obterOrganizador(Integer.parseInt(request.getParameter("idOrganizador")));
            Corrida corrida = new Corrida(idCorrida, nomeCorrida, data, horario, maximoAtletas, estado);
            corrida.setOrganizadoridOrganizador(organizador);

            CorridaDAO.obterInstancia().gravar(corrida);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaCorridaController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    private void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {
        try {
            request.setAttribute("operacao", "Editar");

            int idCorrida = Integer.parseInt(request.getParameter("idCorrida"));
            Corrida corrida = CorridaDAO.obterInstancia().obterCorrida(idCorrida);
            request.setAttribute("corrida", corrida);
            request.setAttribute("organizadores", OrganizadorDAO.obterInstancia().obterOrganizadores());

            RequestDispatcher view = request.getRequestDispatcher("/manterCorrida.jsp");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {

        try {
            int idCorrida = Integer.parseInt(request.getParameter("idCorrida"));
            String nomeCorrida = request.getParameter("nomeCorrida");
            String data = request.getParameter("data");
            String horario = request.getParameter("horario");
            int maximoAtletas = Integer.parseInt(request.getParameter("maximoAtletas"));
            String estado = request.getParameter("estado");

            Organizador organizador = OrganizadorDAO.obterInstancia().obterOrganizador(Integer.parseInt(request.getParameter("idOrganizador")));
            Corrida corrida = new Corrida(idCorrida, nomeCorrida, data, horario, maximoAtletas, estado);
            corrida.setOrganizadoridOrganizador(organizador);

            CorridaDAO.obterInstancia().alterar(corrida);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaCorridaController");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {
        try {
            request.setAttribute("operacao", "Excluir");

            int idCorrida = Integer.parseInt(request.getParameter("idCorrida"));
            Corrida corrida = CorridaDAO.obterInstancia().obterCorrida(idCorrida);
            request.setAttribute("corrida", corrida);
            request.setAttribute("organizadores", OrganizadorDAO.obterInstancia().obterOrganizadores());

            RequestDispatcher view = request.getRequestDispatcher("/manterCorrida.jsp");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {

        try {
            int idCorrida = Integer.parseInt(request.getParameter("idCorrida"));
            String nomeCorrida = request.getParameter("nomeCorrida");
            String data = request.getParameter("data");
            String horario = request.getParameter("horario");
            int maximoAtletas = Integer.parseInt(request.getParameter("maximoAtletas"));
            String estado = request.getParameter("estado");

            Organizador organizador = OrganizadorDAO.obterInstancia().obterOrganizador(Integer.parseInt(request.getParameter("idOrganizador")));
            Corrida corrida = new Corrida(idCorrida, nomeCorrida, data, horario, maximoAtletas, estado);
            corrida.setOrganizadoridOrganizador(organizador);

            CorridaDAO.obterInstancia().excluir(corrida);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaCorridaController");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }
}
