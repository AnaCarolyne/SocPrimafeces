package bean;




import DAO.FuncionarioDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.Funcionarios;



@ManagedBean
@SessionScoped
public class FuncionarioBean extends CrudBean<Funcionarios, FuncionarioDAO> {

    private FuncionarioDAO funcionarioDAO;
    
    @Override
    public FuncionarioDAO getDao() {
        if(funcionarioDAO == null){
            funcionarioDAO = new FuncionarioDAO();
        }
        return funcionarioDAO;
    }

    @Override
    public Funcionarios criarNovaEntidade() {
        return new Funcionarios();
    }

}

