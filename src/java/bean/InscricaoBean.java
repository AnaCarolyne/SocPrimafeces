package bean;




import DAO.InscricaoDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Inscricao;




@ManagedBean
@SessionScoped
public class InscricaoBean extends CrudBean<Inscricao, InscricaoDAO> {

    private InscricaoDAO inscricaoDAO;
    
    @Override
    public InscricaoDAO getDao() {
        if(inscricaoDAO == null){
            inscricaoDAO = new InscricaoDAO();
        }
        return inscricaoDAO;
    }

    @Override
    public Inscricao criarNovaEntidade() {
        return new Inscricao();
    }

}

