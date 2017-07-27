package bean;




import DAO.ObjetoKitDAO;
import DAO.OrganizadorDAO;
import DAO.SuprimentoDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Objetokit;
import modelo.Organizador;
import modelo.Suprimento;




@ManagedBean
@SessionScoped
public class SuprimentoBean extends CrudBean<Suprimento, SuprimentoDAO> {

    private SuprimentoDAO suprimentoDAO;
    
    @Override
    public SuprimentoDAO getDao() {
        if(suprimentoDAO == null){
           suprimentoDAO = new SuprimentoDAO();
        }
        return suprimentoDAO;
    }

    @Override
    public Suprimento criarNovaEntidade() {
        return new Suprimento();
    }

}

