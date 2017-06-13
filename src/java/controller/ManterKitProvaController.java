/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ChipDAO;
import DAO.EntregaKitDAO;
import DAO.KitProvaDAO;
import DAO.ObjetoKitDAO;
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
import modelo.Entregakit;
import modelo.Kitprova;
import modelo.Objetokit;

/**
 *
 * @author Ana Carolyne
 */
public class ManterKitProvaController extends HttpServlet {

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

    private void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {
        try {

            request.setAttribute("operacao", "Incluir");
            request.setAttribute("chip", ChipDAO.obterInstancia().obterChips());
            request.setAttribute("entregaKits", EntregaKitDAO.obterInstancia().obterEntregaKits());
            request.setAttribute("objetoKits", ObjetoKitDAO.obterInstancia().obterObjetokits());
            RequestDispatcher view = request.getRequestDispatcher("/manterKitProva.jsp");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            int idKitProva = Integer.parseInt(request.getParameter("idKitProva"));
            String tamanho = request.getParameter("tamanho");
            String sexo = request.getParameter("sexo");

            Entregakit entregakit = EntregaKitDAO.obterInstancia().obterEntregaKit(Integer.parseInt(request.getParameter("idEntregaKit")));
            Chip chip = ChipDAO.obterInstancia().obterChip(Integer.parseInt(request.getParameter("idChip")));
            Objetokit objetokit = ObjetoKitDAO.obterInstancia().obterObjetokit(Integer.parseInt(request.getParameter("idObjetoKit")));

            Kitprova kitProva = new Kitprova(idKitProva, tamanho, sexo);
            kitProva.setEntregaKitidEntregaKit(entregakit);
            kitProva.setChipidChip(chip);
            kitProva.setObjetoKitidObjetoKit(objetokit);

            KitProvaDAO.obterInstancia().gravar(kitProva);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaKitProvaController");
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

            int idKitProva = Integer.parseInt(request.getParameter("idKitProva"));

            Kitprova kitprova = KitProvaDAO.obterInstancia().obterKitprova(idKitProva);
            request.setAttribute("kitprova", kitprova);

            request.setAttribute("chip", ChipDAO.obterInstancia().obterChips());
            request.setAttribute("entregaKits", EntregaKitDAO.obterInstancia().obterEntregaKits());
            request.setAttribute("objetoKits", ObjetoKitDAO.obterInstancia().obterObjetokits());
            RequestDispatcher view = request.getRequestDispatcher("/manterKitProva.jsp");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {

        try {
            int idKitProva = Integer.parseInt(request.getParameter("idKitProva"));
            String tamanho = request.getParameter("tamanho");
            String sexo = request.getParameter("sexo");

            Entregakit entregakit = new Entregakit(Integer.parseInt(request.getParameter("idEntregaKit")));
            Chip chip = new Chip(Integer.parseInt(request.getParameter("idChip")));
            Objetokit objetokit = new Objetokit(Integer.parseInt(request.getParameter("idObjetoKit")));

            Kitprova kitprova = new Kitprova(idKitProva, tamanho, sexo);
            kitprova.setEntregaKitidEntregaKit(entregakit);
            kitprova.setChipidChip(chip);
            kitprova.setObjetoKitidObjetoKit(objetokit);
            KitProvaDAO.obterInstancia().alterar(kitprova);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaKitProvaController");
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

            int idKitProva = Integer.parseInt(request.getParameter("idKitProva"));

            Kitprova kitprova = KitProvaDAO.obterInstancia().obterKitprova(idKitProva);
            request.setAttribute("kitprova", kitprova);

            request.setAttribute("chip", ChipDAO.obterInstancia().obterChips());
            request.setAttribute("entregaKits", EntregaKitDAO.obterInstancia().obterEntregaKits());
            request.setAttribute("objetoKits", ObjetoKitDAO.obterInstancia().obterObjetokits());
            RequestDispatcher view = request.getRequestDispatcher("/manterKitProva.jsp");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int idKitProva = Integer.parseInt(request.getParameter("idKitProva"));
            String tamanho = request.getParameter("tamanho");
            String sexo = request.getParameter("sexo");

            Entregakit entregakit = new Entregakit(Integer.parseInt(request.getParameter("idEntregaKit")));
            Chip chip = new Chip(Integer.parseInt(request.getParameter("idChip")));
            Objetokit objetokit = new Objetokit(Integer.parseInt(request.getParameter("idObjetoKit")));

            Kitprova kitprova = new Kitprova(idKitProva, tamanho, sexo);
            kitprova.setEntregaKitidEntregaKit(entregakit);
            kitprova.setChipidChip(chip);
            kitprova.setObjetoKitidObjetoKit(objetokit);

            KitProvaDAO.obterInstancia().excluir(kitprova);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaKitProvaController");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
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
            Logger.getLogger(ManterKitProvaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterKitProvaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterKitProvaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterKitProvaController.class.getName()).log(Level.SEVERE, null, ex);
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
}
