/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AtletaDAO;
import DAO.InscricaoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Atleta;
import modelo.Inscricao;

/**
 *
 * @author Ana Carolyne
 */

public class ManterAtletaController extends HttpServlet {
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
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterAtletaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterAtletaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterAtletaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterAtletaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         private void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("inscricao", InscricaoDAO.obterInstancia().obterInscricaos());
            RequestDispatcher view = request.getRequestDispatcher("/manterAtleta.jsp");
            view.forward(request, response);
                } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }
public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {

        int idAtleta = Integer.parseInt(request.getParameter("idAtleta"));
        String nomeAtleta = request.getParameter("nomeAtleta");
        String dataNascimento = request.getParameter("dataNascimento");
        String logradouro = request.getParameter("logradouro");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String complemento = request.getParameter("complemento");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        int cpf = Integer.parseInt(request.getParameter("cpf"));
        String rg = request.getParameter("rg");
        String sexo = request.getParameter("sexo");
        int telefone = Integer.parseInt(request.getParameter("telefone"));
        int celular = Integer.parseInt(request.getParameter("celular"));
        int  portDeficiencia  = Integer.parseInt(request.getParameter("portDeficiencia"));
         int  contEmergencia  = Integer.parseInt(request.getParameter("contEmergencia"));
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String email = request.getParameter("email");
        int cep = Integer.parseInt(request.getParameter("cep"));
        String tipoSanguineo = request.getParameter("tipoSanguineo");
       
            
            Inscricao inscricao = InscricaoDAO.obterInstancia().obterInscricao(Integer.parseInt(request.getParameter("idInscricao")));
            Atleta atleta = new Atleta( idAtleta, nomeAtleta,  dataNascimento,  logradouro,  numero,  complemento,  bairro,  cidade,  estado,  cpf,  rg,  sexo,  telefone,  celular,  portDeficiencia,  contEmergencia,  login,  senha,  email,  cep,  tipoSanguineo) ;
            atleta.setInscricaoidInscricao(inscricao);

            AtletaDAO.obterInstancia().gravar(atleta);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaAtletaController");
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

            int idAtleta = Integer.parseInt(request.getParameter("idAtleta"));
            Atleta atleta = AtletaDAO.obterInstancia().obterAtleta(idAtleta);
            request.setAttribute("atleta", atleta);
            request.setAttribute("inscricaos", InscricaoDAO.obterInstancia().obterInscricaos());

            RequestDispatcher view = request.getRequestDispatcher("/manterAtleta.jsp");
            view.forward(request, response);
                } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }
    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {

        try {
         int idAtleta = Integer.parseInt(request.getParameter("idAtleta"));
        String nomeAtleta = request.getParameter("nomeAtleta");
        String dataNascimento = request.getParameter("dataNascimento");
        String logradouro = request.getParameter("logradouro");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String complemento = request.getParameter("complemento");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        int cpf = Integer.parseInt(request.getParameter("cpf"));
        String rg = request.getParameter("rg");
        String sexo = request.getParameter("sexo");
        int telefone = Integer.parseInt(request.getParameter("telefone"));
        int celular = Integer.parseInt(request.getParameter("celular"));
        int  portDeficiencia  = Integer.parseInt(request.getParameter("portDeficiencia"));
         int  contEmergencia  = Integer.parseInt(request.getParameter("contEmergencia"));
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String email = request.getParameter("email");
        int cep = Integer.parseInt(request.getParameter("cep"));
        String tipoSanguineo = request.getParameter("tipoSanguineo");
         Inscricao inscricao = InscricaoDAO.obterInstancia().obterInscricao(Integer.parseInt(request.getParameter("idInscricao")));

            Atleta atleta = new Atleta( idAtleta, nomeAtleta,  dataNascimento,  logradouro,  numero,  complemento,  bairro,  cidade,  estado,  cpf,  rg,  sexo,  telefone,  celular,  portDeficiencia,  contEmergencia,  login,  senha,  email,  cep,  tipoSanguineo) ;
            atleta.setInscricaoidInscricao(inscricao);

            AtletaDAO.obterInstancia().alterar(atleta);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaAtletaController");
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

            int idAtleta = Integer.parseInt(request.getParameter("idAtleta"));
            Atleta atleta = AtletaDAO.obterInstancia().obterAtleta(idAtleta);
           
            request.setAttribute("atleta", atleta);
            request.setAttribute("inscricaos", InscricaoDAO.obterInstancia().obterInscricaos());

            RequestDispatcher view = request.getRequestDispatcher("/manterAtleta.jsp");
            view.forward(request, response);
              } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }
   
   

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
   public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
         int idAtleta = Integer.parseInt(request.getParameter("idAtleta"));
        String nomeAtleta = request.getParameter("nomeAtleta");
        String dataNascimento = request.getParameter("dataNascimento");
        String logradouro = request.getParameter("logradouro");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String complemento = request.getParameter("complemento");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        int cpf = Integer.parseInt(request.getParameter("cpf"));
        String rg = request.getParameter("rg");
        String sexo = request.getParameter("sexo");
        int telefone = Integer.parseInt(request.getParameter("telefone"));
        int celular = Integer.parseInt(request.getParameter("celular"));
        int  portDeficiencia  = Integer.parseInt(request.getParameter("portDeficiencia"));
         int  contEmergencia  = Integer.parseInt(request.getParameter("contEmergencia"));
       
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String email = request.getParameter("email");
        int cep = Integer.parseInt(request.getParameter("cep"));
        String tipoSanguineo = request.getParameter("tipoSanguineo");
         
       Inscricao inscricao = InscricaoDAO.obterInstancia().obterInscricao(Integer.parseInt(request.getParameter("idInscricao")));
      
          Atleta atleta = new Atleta( idAtleta, nomeAtleta,  dataNascimento,  logradouro,  numero,  complemento,  bairro,  cidade,  estado,  cpf,  rg,  sexo,  telefone,  celular,  portDeficiencia,  contEmergencia,  login,  senha,  email,  cep,  tipoSanguineo) ;
            atleta.setInscricaoidInscricao(inscricao);

            AtletaDAO.obterInstancia().excluir(atleta);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaAtletaController");
            view.forward(request, response);
               } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }
}