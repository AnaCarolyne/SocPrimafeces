package bean;




import DAO.ModalidadeDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Modalidade;




@ManagedBean
@SessionScoped
public class ModalidadeBean extends CrudBean<Modalidade, ModalidadeDAO> {

    private ModalidadeDAO modalidadeDAO;
    
    @Override
    public ModalidadeDAO getDao() {
        if(modalidadeDAO == null){
            modalidadeDAO = new ModalidadeDAO();
        }
        return modalidadeDAO;
    }

    @Override
    public Modalidade criarNovaEntidade() {
        return new Modalidade();
    }

}

