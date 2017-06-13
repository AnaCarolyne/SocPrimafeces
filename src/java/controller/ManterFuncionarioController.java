/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CargoDAO;
import DAO.CorridaDAO;
import DAO.FuncionarioDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cargo;
import modelo.Corrida;
import modelo.Funcionarios;

/**
 *
 * @author Ana Carolyne
 */
public class ManterFuncionarioController extends HttpServlet {

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
            request.setAttribute("corridas", CorridaDAO.obterInstancia().obterCorridas());
            request.setAttribute("cargos", CargoDAO.obterInstancia().obterCargos());
            RequestDispatcher view = request.getRequestDispatcher("/manterFuncionario.jsp");
            view.forward(request, response);
                } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }
    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {

        int idFuncionarios = Integer.parseInt(request.getParameter("idFuncionarios"));
        String nomeFuncionario = request.getParameter("nomeFuncionario");
        String nascimento = request.getParameter("nascimento");
        String cpf = request.getParameter("cpf");
        String rg = request.getParameter("rg");
        String sexo = request.getParameter("sexo");
        int telefone = Integer.parseInt(request.getParameter("telefone"));
        int celular = Integer.parseInt(request.getParameter("celular"));
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String logradouro = request.getParameter("logradouro");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        
        Cargo cargo = CargoDAO.obterInstancia().obterCargo(Integer.parseInt(request.getParameter("idCargo")));
        Corrida corrida = CorridaDAO.obterInstancia().obterCorrida(Integer.parseInt(request.getParameter("idCorrida")));
            
            Funcionarios funcionario = new Funcionarios(idFuncionarios,  nomeFuncionario,  nascimento,  cpf,  rg,  sexo, telefone, celular,  login,  senha,  logradouro,  bairro,  cidade,  uf);
            funcionario.setCorridaidCorrida(corrida);
            funcionario.setCargoidCargo(cargo);

            FuncionarioDAO.obterInstancia().gravar(funcionario);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaFuncionarioController");
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

            int idFuncionarios = Integer.parseInt(request.getParameter("idFuncionarios"));
             Funcionarios funcionario = FuncionarioDAO.obterInstancia().obterFuncionario(idFuncionarios);
              request.setAttribute("funcionario", funcionario);
              
             request.setAttribute("corridas", CorridaDAO.obterInstancia().obterCorridas());
            request.setAttribute("cargos", CargoDAO.obterInstancia().obterCargos());
            RequestDispatcher view = request.getRequestDispatcher("/manterFuncionario.jsp");
            view.forward(request, response);
                } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {

        try {
            int idFuncionarios = Integer.parseInt(request.getParameter("idFuncionarios"));
        String nomeFuncionario = request.getParameter("nomeFuncionario");
        String nascimento = request.getParameter("nascimento");
        String cpf = request.getParameter("cpf");
        String rg = request.getParameter("rg");
        String sexo = request.getParameter("sexo");
        int telefone = Integer.parseInt(request.getParameter("telefone"));
        int celular = Integer.parseInt(request.getParameter("celular"));
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String logradouro = request.getParameter("logradouro");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");

           Cargo cargo = CargoDAO.obterInstancia().obterCargo(Integer.parseInt(request.getParameter("idCargo")));
        Corrida corrida = CorridaDAO.obterInstancia().obterCorrida(Integer.parseInt(request.getParameter("idCorrida")));

            Funcionarios funcionario = new Funcionarios(idFuncionarios,  nomeFuncionario,  nascimento,  cpf,  rg,  sexo, telefone, celular,  login,  senha,  logradouro,  bairro,  cidade,  uf);
            funcionario.setCorridaidCorrida(corrida);
            funcionario.setCargoidCargo(cargo);
            FuncionarioDAO.obterInstancia().alterar(funcionario);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaFuncionarioController");
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
             int idFuncionarios = Integer.parseInt(request.getParameter("idFuncionarios"));
            
             Funcionarios funcionario = FuncionarioDAO.obterInstancia().obterFuncionario(idFuncionarios);
              request.setAttribute("funcionario", funcionario);
            request.setAttribute("corridas", CorridaDAO.obterInstancia().obterCorridas());
            request.setAttribute("cargos", CargoDAO.obterInstancia().obterCargos());
            RequestDispatcher view = request.getRequestDispatcher("/manterFuncionario.jsp");
            view.forward(request, response);
               } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
             int idFuncionarios = Integer.parseInt(request.getParameter("idFuncionarios"));
        String nomeFuncionario = request.getParameter("nomeFuncionario");
        String nascimento = request.getParameter("nascimento");
        String cpf = request.getParameter("cpf");
        String rg = request.getParameter("rg");
        String sexo = request.getParameter("sexo");
        int telefone = Integer.parseInt(request.getParameter("telefone"));
        int celular = Integer.parseInt(request.getParameter("celular"));
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String logradouro = request.getParameter("logradouro");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");

             Cargo cargo = CargoDAO.obterInstancia().obterCargo(Integer.parseInt(request.getParameter("idCargo")));
        Corrida corrida = CorridaDAO.obterInstancia().obterCorrida(Integer.parseInt(request.getParameter("idCorrida")));

            Funcionarios funcionario = new Funcionarios(idFuncionarios,  nomeFuncionario,  nascimento,  cpf,  rg,  sexo, telefone, celular,  login,  senha,  logradouro,  bairro,  cidade,  uf);
            funcionario.setCorridaidCorrida(corrida);
            funcionario.setCargoidCargo(cargo);

            FuncionarioDAO.obterInstancia().excluir(funcionario);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaFuncionarioController");
            view.forward(request, response);
                } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            throw ex;
        }
    }
}

    
    
   