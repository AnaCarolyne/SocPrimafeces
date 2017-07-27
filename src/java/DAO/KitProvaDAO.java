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
import modelo.Kitprova;

/**
 *
 * @author Juliana
 */
public class KitProvaDAO implements CrudDAO<Kitprova>{
     private static KitProvaDAO instancia = new KitProvaDAO();

    public static KitProvaDAO obterInstancia() {
        return instancia;
    }

    public KitProvaDAO() {
    }

     @Override
    public List<Kitprova> buscar() {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Kitprova> kitprovas = null;
        try {
            tx.begin();
            TypedQuery<Kitprova> query = em.createQuery("select k from Kitprova k", Kitprova.class);
            kitprovas = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return kitprovas;

    }
public Kitprova getKitprova(int idKitprova) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Kitprova kitprova = new Kitprova();
        try {
            tx.begin();
            kitprova = em.find(Kitprova.class, idKitprova);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return kitprova;
    }

     @Override
    public void salvar(Kitprova kitprova) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(kitprova);
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
    public void excluir(Kitprova kitprova) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Kitprova.class, kitprova.getIdKitProva()));
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
       