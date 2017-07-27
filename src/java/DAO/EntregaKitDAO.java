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
import modelo.Entregakit;

/**
 *
 * @author Juliana
 */
public class EntregaKitDAO implements CrudDAO<Entregakit> {
   
       private static EntregaKitDAO instancia = new EntregaKitDAO();

    public static EntregaKitDAO obterInstancia() {
        return instancia;
    }

    public EntregaKitDAO() {
    }

       @Override
    public List<Entregakit> buscar() {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Entregakit> entregaKits = null;
        try {
            tx.begin();
            TypedQuery<Entregakit> query = em.createQuery("select e from Entregakit e", Entregakit.class);
            entregaKits = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return entregaKits;

    }
    
    public Entregakit getEntregaKit(int idEntregaKit) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
       Entregakit entregaKit = new Entregakit();
        try {
            tx.begin();
            entregaKit = em.find(Entregakit.class, idEntregaKit);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return entregaKit;
    }

       @Override
    public void salvar(Entregakit entregaKit) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entregaKit);
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
    public void excluir(Entregakit entregaKit) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference( Entregakit.class,  entregaKit.getIdEntregaKit()));
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
