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
import modelo.Inscricao;


/**
 *
 * @author Juliana
 */
public class InscricaoDAO implements CrudDAO<Inscricao>{

   private static InscricaoDAO instancia = new InscricaoDAO();

    public static InscricaoDAO obterInstancia() {
        return instancia;
    }

    public InscricaoDAO() {
    }

   @Override
    public List<Inscricao> buscar() {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Inscricao> inscricaos = null;
        try {
            tx.begin();
            TypedQuery<Inscricao> query = em.createQuery("select i from Inscricao i", Inscricao.class);
            inscricaos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return inscricaos;

    }
    public Inscricao getInscricao(int idInscricao) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Inscricao inscricao = new Inscricao();
        try {
            tx.begin();
            inscricao = em.find(Inscricao.class, idInscricao);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return inscricao;
    }
   @Override
     public void salvar(Inscricao inscricao) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(inscricao);
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
     public void excluir(Inscricao inscricao) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Inscricao.class, inscricao.getIdInscricao()));
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
