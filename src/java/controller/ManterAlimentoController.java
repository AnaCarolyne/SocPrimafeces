package controller;

import DAO.AlimentoDAO;
import DAO.SuprimentoDAO;
import modelo.Alimento;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Suprimento;

public class ManterAlimentoController extends HttpServlet {

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
            request.setAttribute("suprimentos", SuprimentoDAO.obterInstancia().obterSuprimentos());
            RequestDispatcher view = request.getRequestDispatcher("/manterAlimento.jsp");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {

            int idAlimento = Integer.parseInt(request.getParameter("idAlimento"));
            String nomeAlimento = request.getParameter("nomeAlimento");
            int calorias = Integer.parseInt(request.getParameter("calorias"));
            int qtdCarboidrato = Integer.parseInt(request.getParameter("qtdcarboidrato"));
            int porcao = Integer.parseInt(request.getParameter("porcao"));
            
            Suprimento suprimento = SuprimentoDAO.obterInstancia().obterSuprimento(Integer.parseInt(request.getParameter("idSuprimento")));
            

            Alimento alimento = new Alimento(idAlimento, nomeAlimento, calorias, qtdCarboidrato, porcao);
            alimento.setSuprimentoidSuprimento(suprimento);

            AlimentoDAO.obterInstancia().gravar(alimento);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaAlimentoController");
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

            int idAlimento = Integer.parseInt(request.getParameter("idAlimento"));
            Alimento alimento = AlimentoDAO.obterInstancia().obterAlimento(idAlimento);
            request.setAttribute("alimento", alimento);
            request.setAttribute("suprimentos", SuprimentoDAO.obterInstancia().obterSuprimentos());

            RequestDispatcher view = request.getRequestDispatcher("/manterAlimento.jsp");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {

        try {
            int idAlimento = Integer.parseInt(request.getParameter("idAlimento"));
            String nomeAlimento= request.getParameter("nomeAlimento");
            int calorias = Integer.parseInt(request.getParameter("calorias"));
            int qtdCarboidrato = Integer.parseInt(request.getParameter("qtdcarboidrato"));
            int porcao = Integer.parseInt(request.getParameter("porcao"));

           Suprimento suprimento = SuprimentoDAO.obterInstancia().obterSuprimento(Integer.parseInt(request.getParameter("idSuprimento")));
            Alimento alimento = new Alimento(idAlimento, nomeAlimento, calorias, qtdCarboidrato, porcao);
            alimento.setSuprimentoidSuprimento(suprimento);

            AlimentoDAO.obterInstancia().alterar(alimento);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaAlimentoController");
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

            int idAlimento = Integer.parseInt(request.getParameter("idAlimento"));
            Alimento alimento = AlimentoDAO.obterInstancia().obterAlimento(idAlimento);
            request.setAttribute("alimento", alimento);
            request.setAttribute("suprimentos", SuprimentoDAO.obterInstancia().obterSuprimentos());

            RequestDispatcher view = request.getRequestDispatcher("/manterAlimento.jsp");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int idAlimento = Integer.parseInt(request.getParameter("idAlimento"));
            String nomeAlimento = request.getParameter("nomeAlimento");
            int calorias = Integer.parseInt(request.getParameter("calorias"));
            int qtdCarboidrato = Integer.parseInt(request.getParameter("qtdcarboidrato"));
            int porcao = Integer.parseInt(request.getParameter("porcao"));

           Suprimento suprimento = SuprimentoDAO.obterInstancia().obterSuprimento(Integer.parseInt(request.getParameter("idSuprimento")));
            Alimento alimento = new Alimento(idAlimento, nomeAlimento, calorias, qtdCarboidrato, porcao);
            alimento.setSuprimentoidSuprimento(suprimento);

            AlimentoDAO.obterInstancia().excluir(alimento);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaAlimentoController");
            view.forward(request, response);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }
}
