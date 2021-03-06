package main.edu.br.ifmt.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.edu.br.ifmt.model.entity.Nota;

public class NotaDAO {
	private static NotaDAO instance;
    protected EntityManager entityManager;
    
    public static NotaDAO getInstance(){
        if (instance == null){
           instance = new NotaDAO();
        }
        return instance;
    }
    
    private NotaDAO() {
        entityManager = getEntityManager();
      }
    
    
    private EntityManager getEntityManager() {
        EntityManagerFactory factory =
        Persistence.createEntityManagerFactory("qAcademico");
        if (entityManager == null) {
          entityManager = factory.createEntityManager();
        }

        return entityManager;
       }
    
    public Nota getById(final int id) {
        return entityManager.find(Nota.class, id);
     }
    
    @SuppressWarnings("unchecked")
    public List<Nota> findAll() {
      return  entityManager.createQuery("FROM " +
    		  Nota.class.getName()).getResultList();
    }
    
    public void persist(Nota nota) {
        try {
           entityManager.getTransaction().begin();
           entityManager.persist(nota);
           entityManager.getTransaction().commit();
        } catch (Exception ex) {
           ex.printStackTrace();
           entityManager.getTransaction().rollback();
        }
      }
    
    public void merge(Nota nota) {
        try {
           entityManager.getTransaction().begin();
           entityManager.merge(nota);
           entityManager.getTransaction().commit();
        } catch (Exception ex) {
           ex.printStackTrace();
           entityManager.getTransaction().rollback();
        }
      }
    
    public void remove(Nota nota) {
        try {
           entityManager.getTransaction().begin();
           nota = entityManager.find(Nota.class, nota.getId());
           entityManager.remove(nota);
           entityManager.getTransaction().commit();
        } catch (Exception ex) {
           ex.printStackTrace();
           entityManager.getTransaction().rollback();
        }
      }
    
    public void removeById(final int id) {
        try {
           Nota nota = getById(id);
           remove(nota);
        } catch (Exception ex) {
           ex.printStackTrace();
        }
      }
}
