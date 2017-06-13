/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CorridaDAO;
import DAO.InscricaoDAO;
import DAO.KitProvaDAO;
import DAO.LoteDAO;
import DAO.ModalidadeDAO;
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
import modelo.Inscricao;
import modelo.Kitprova;
import modelo.Lote;
import modelo.Modalidade;

/**
 *
 * @author Ana Carolyne
 */
public class ManterInscricaoController extends HttpServlet {

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

            request.setAttribute("corridas", CorridaDAO.obterInstancia().obterCorridas());
            request.setAttribute("modalidades", ModalidadeDAO.obterInstancia().obterModalidades());
            request.setAttribute("kitprovas", KitProvaDAO.obterInstancia().obterKitprovas());
            request.setAttribute("lotes", LoteDAO.obterInstancia().obterLotes());
            RequestDispatcher view = request.getRequestDispatcher("/manterInscricao.jsp");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {

            int idInscricao = Integer.parseInt(request.getParameter("idInscricao"));
            int boleto = Integer.parseInt(request.getParameter("boleto"));
            String numeroDePeito = request.getParameter("numeroDePeito");

            Modalidade modalidade = ModalidadeDAO.obterInstancia().obterModalidade(Integer.parseInt(request.getParameter("idModalidade")));
            Kitprova kitprova = KitProvaDAO.obterInstancia().obterKitprova(Integer.parseInt(request.getParameter("idKitProva")));
            Corrida corrida = CorridaDAO.obterInstancia().obterCorrida(Integer.parseInt(request.getParameter("idCorrida")));
            Lote lote = LoteDAO.obterInstancia().obterLote(Integer.parseInt(request.getParameter("idLote")));

            Inscricao inscricao = new Inscricao(idInscricao, boleto, numeroDePeito);
            inscricao.setCorridaidCorrida(corrida);
            inscricao.setKitProvaidKitProva(kitprova);
            inscricao.setLoteidLote(lote);
            inscricao.setModalidadeidModalidade(modalidade);

            InscricaoDAO.obterInstancia().gravar(inscricao);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaInscricaoController");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
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
            Logger.getLogger(ManterInscricaoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterInscricaoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterInscricaoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterInscricaoController.class.getName()).log(Level.SEVERE, null, ex);
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

    private void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {
        try {
            request.setAttribute("operacao", "Editar");

            int idInscricao = Integer.parseInt(request.getParameter("idInscricao"));
            
            request.setAttribute("inscricaos", InscricaoDAO.obterInstancia().obterInscricao(idInscricao));
            request.setAttribute("corridas", CorridaDAO.obterInstancia().obterCorridas());
            request.setAttribute("modalidades", ModalidadeDAO.obterInstancia().obterModalidades());
            request.setAttribute("kitprovas", KitProvaDAO.obterInstancia().obterKitprovas());
            request.setAttribute("lotes", LoteDAO.obterInstancia().obterLotes());
            RequestDispatcher view = request.getRequestDispatcher("/manterInscricao.jsp");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {

        try {

            int idInscricao = Integer.parseInt(request.getParameter("idInscricao"));
            int boleto = Integer.parseInt(request.getParameter("boleto"));
            String numeroDePeito = request.getParameter("numeroDePeito");

            Modalidade modalidade = ModalidadeDAO.obterInstancia().obterModalidade(Integer.parseInt(request.getParameter("idModalidade")));
            Kitprova kitprova = KitProvaDAO.obterInstancia().obterKitprova(Integer.parseInt(request.getParameter("idKitProva")));
            Corrida corrida = CorridaDAO.obterInstancia().obterCorrida(Integer.parseInt(request.getParameter("idCorrida")));
            Lote lote = LoteDAO.obterInstancia().obterLote(Integer.parseInt(request.getParameter("idLote")));

            Inscricao inscricao = new Inscricao(idInscricao, boleto, numeroDePeito);
            inscricao.setCorridaidCorrida(corrida);
            inscricao.setKitProvaidKitProva(kitprova);
            inscricao.setLoteidLote(lote);
            inscricao.setModalidadeidModalidade(modalidade);
            InscricaoDAO.obterInstancia().alterar(inscricao);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaInscricaoController");
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
            int idInscricao = Integer.parseInt(request.getParameter("idInscricao"));
            request.setAttribute("inscricaos", InscricaoDAO.obterInstancia().obterInscricao(idInscricao));
            request.setAttribute("corridas", CorridaDAO.obterInstancia().obterCorridas());
            request.setAttribute("modalidades", ModalidadeDAO.obterInstancia().obterModalidades());
            request.setAttribute("kitprovas", KitProvaDAO.obterInstancia().obterKitprovas());
            request.setAttribute("lotes", LoteDAO.obterInstancia().obterLotes());
            RequestDispatcher view = request.getRequestDispatcher("/manterInscricao.jsp");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int idInscricao = Integer.parseInt(request.getParameter("idInscricao"));
            int boleto = Integer.parseInt(request.getParameter("boleto"));
            String numeroDePeito = request.getParameter("numeroDePeito");

            Modalidade modalidade = ModalidadeDAO.obterInstancia().obterModalidade(Integer.parseInt(request.getParameter("idModalidade")));
            Kitprova kitprova = KitProvaDAO.obterInstancia().obterKitprova(Integer.parseInt(request.getParameter("idKitProva")));
            Corrida corrida = CorridaDAO.obterInstancia().obterCorrida(Integer.parseInt(request.getParameter("idCorrida")));
            Lote lote = LoteDAO.obterInstancia().obterLote(Integer.parseInt(request.getParameter("idLote")));

            Inscricao inscricao = new Inscricao(idInscricao, boleto, numeroDePeito);
            inscricao.setCorridaidCorrida(corrida);
            inscricao.setKitProvaidKitProva(kitprova);
            inscricao.setLoteidLote(lote);
            inscricao.setModalidadeidModalidade(modalidade);

            InscricaoDAO.obterInstancia().excluir(inscricao);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaInscricaoController");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }
}
