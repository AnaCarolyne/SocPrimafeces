/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Objetokit;

/**
 *
 * @author Juliana
 */
public class ObjetoKitDAO implements CrudDAO<Objetokit>{
    
    private static ObjetoKitDAO instancia = new ObjetoKitDAO();

    public static ObjetoKitDAO obterInstancia() {
        return instancia;
    }

    public ObjetoKitDAO() {
    }

    @Override
    public List<Objetokit> buscar() {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Objetokit> objetokits = null;
        try {
            tx.begin();
            TypedQuery<Objetokit> query = em.createQuery("select o from Objetokit o", Objetokit.class);
            objetokits = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return objetokits;

    }

    public Objetokit getObjetokit(int idObjetokit) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Objetokit objetokit = new Objetokit();
        try {
            tx.begin();
            objetokit = em.find(Objetokit.class, idObjetokit);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return objetokit;
    }

    @Override
    public void salvar(Objetokit objetokit) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(objetokit);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }

  

    @Override
    public void excluir(Objetokit objetokit) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Objetokit.class, objetokit.getIdObjetoKit()));
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }

}
