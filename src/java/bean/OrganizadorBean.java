package bean;




import DAO.OrganizadorDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Organizador;




@ManagedBean
@SessionScoped
public class OrganizadorBean extends CrudBean<Organizador, OrganizadorDAO> {

    private OrganizadorDAO organizadorDAO;
    
    @Override
    public OrganizadorDAO getDao() {
        if(organizadorDAO == null){
            organizadorDAO = new OrganizadorDAO();
        }
        return organizadorDAO;
    }

    @Override
    public Organizador criarNovaEntidade() {
        return new Organizador();
    }

}

