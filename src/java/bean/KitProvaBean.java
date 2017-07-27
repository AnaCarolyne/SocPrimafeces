package bean;




import DAO.KitProvaDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Kitprova;




@ManagedBean
@SessionScoped
public class KitProvaBean extends CrudBean<Kitprova, KitProvaDAO> {

    private KitProvaDAO kitProvaDAO;
    
    @Override
    public KitProvaDAO getDao() {
        if(kitProvaDAO == null){
            kitProvaDAO = new KitProvaDAO();
        }
        return kitProvaDAO;
    }

    @Override
    public Kitprova criarNovaEntidade() {
        return new Kitprova();
    }

}

