package main.edu.br.ifmt.model.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.edu.br.ifmt.model.entity.Frequencia;

public class FrequenciaDAO {
	private static FrequenciaDAO instance;
    protected EntityManager entityManager;
    
    public static FrequenciaDAO getInstance(){
        if (instance == null){
           instance = new FrequenciaDAO();
        }
        return instance;
    }
    
    private FrequenciaDAO() {
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
    
    public Frequencia getById(final int id) {
        return entityManager.find(Frequencia.class, id);
     }
    
    @SuppressWarnings("unchecked")
    public List<Frequencia> findAll() {
      return entityManager.createQuery("FROM " +
    		  Frequencia.class.getName()).getResultList();
    }
    
    public void persist(Frequencia frequencia) {
        try {
           entityManager.getTransaction().begin();
           entityManager.persist(frequencia);
           entityManager.getTransaction().commit();
        } catch (Exception ex) {
           ex.printStackTrace();
           entityManager.getTransaction().rollback();
        }
      }
    
    public void merge(Frequencia frequencia) {
        try {
           entityManager.getTransaction().begin();
           entityManager.merge(frequencia);
           entityManager.getTransaction().commit();
        } catch (Exception ex) {
           ex.printStackTrace();
           entityManager.getTransaction().rollback();
        }
      }
    
    public void remove(Frequencia frequencia) {
        try {
           entityManager.getTransaction().begin();
           frequencia = entityManager.find(Frequencia.class, frequencia.getId());
           entityManager.remove(frequencia);
           entityManager.getTransaction().commit();
        } catch (Exception ex) {
           ex.printStackTrace();
           entityManager.getTransaction().rollback();
        }
      }
    
    public void removeById(final int id) {
        try {
           Frequencia frequencia = getById(id);
           remove(frequencia);
        } catch (Exception ex) {
           ex.printStackTrace();
        }
      }
}
