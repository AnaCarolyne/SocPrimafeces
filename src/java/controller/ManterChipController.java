/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ChipDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Chip;

/**
 *
 * @author Ana Carolyne
 */
public class ManterChipController extends HttpServlet {

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
            Logger.getLogger(ManterAlimentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterAlimentoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterAlimentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterAlimentoController.class.getName()).log(Level.SEVERE, null, ex);
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
            //request.setAttribute("suprimentos", SuprimentoDAO.obterInstancia().obterSuprimentos());
            RequestDispatcher view = request.getRequestDispatcher("/manterChip.jsp");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {

            int idChip = Integer.parseInt(request.getParameter("idChip"));
            String numeroDePeito = request.getParameter("numeroDePeito");
            int tempo = Integer.parseInt(request.getParameter("tempo"));

            //Suprimento suprimento = new Suprimento(Integer.parseInt(request.getParameter("idSuprimento")));
            Chip chip = new Chip(idChip, numeroDePeito, tempo);
            //alimento.setSuprimentoidSuprimento(suprimento);

            ChipDAO.obterInstancia().gravar(chip);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaChipController");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    private void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {
        try {
            request.setAttribute("operacao", "Editar");

            int idChip = Integer.parseInt(request.getParameter("idChip"));
            Chip chip = ChipDAO.obterInstancia().obterChip(idChip);
            request.setAttribute("chip", chip);
            //request.setAttribute("suprimentos", SuprimentoDAO.obterInstancia().obterSuprimentos());

            RequestDispatcher view = request.getRequestDispatcher("/manterChip.jsp");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {

        try {
            int idChip = Integer.parseInt(request.getParameter("idChip"));
            String numeroDePeito = request.getParameter("numeroDePeito");
            int tempo = Integer.parseInt(request.getParameter("tempo"));

            //Suprimento suprimento = new Suprimento(Integer.parseInt(request.getParameter("idSuprimento")));
            Chip chip = new Chip(idChip, numeroDePeito, tempo);
            //alimento.setSuprimentoidSuprimento(suprimento);

            ChipDAO.obterInstancia().alterar(chip);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaChipController");
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

            int idChip = Integer.parseInt(request.getParameter("idChip"));
            Chip chip = ChipDAO.obterInstancia().obterChip(idChip);
            request.setAttribute("chip", chip);
            //request.setAttribute("suprimentos", SuprimentoDAO.obterInstancia().obterSuprimentos());

            RequestDispatcher view = request.getRequestDispatcher("/manterChip.jsp");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int idChip = Integer.parseInt(request.getParameter("idChip"));
            Chip chip = ChipDAO.obterInstancia().obterChip(idChip);
            request.setAttribute("chip", chip);

            //Suprimento suprimento = new Suprimento(Integer.parseInt(request.getParameter("idSuprimento")));
            //alimento.setSuprimentoidSuprimento(suprimento);
            ChipDAO.obterInstancia().excluir(chip);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaChipController");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }
}
