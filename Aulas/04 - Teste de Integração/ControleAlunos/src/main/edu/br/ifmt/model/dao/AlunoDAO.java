package main.edu.br.ifmt.model.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.edu.br.ifmt.model.entity.Aluno;

public class AlunoDAO {
	private static AlunoDAO instance;
    protected EntityManager entityManager;
    
    public static AlunoDAO getInstance(){
        if (instance == null){
           instance = new AlunoDAO();
        }
        return instance;
    }
    
    private AlunoDAO() {
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
    
    public Aluno getById(final int id) {
        return entityManager.find(Aluno.class, id);
     }
    
    @SuppressWarnings("unchecked")
    public List<Aluno> findAll() {
      return  entityManager.createQuery("FROM " +
    		  Aluno.class.getName()).getResultList();
    }
    
    public void persist(Aluno aluno) {
        try {
           entityManager.getTransaction().begin();
           entityManager.persist(aluno);
           entityManager.getTransaction().commit();
        } catch (Exception ex) {
           ex.printStackTrace();
           entityManager.getTransaction().rollback();
        }
      }
    
    public void merge(Aluno aluno) {
        try {
           entityManager.getTransaction().begin();
           entityManager.merge(aluno);
           entityManager.getTransaction().commit();
        } catch (Exception ex) {
           ex.printStackTrace();
           entityManager.getTransaction().rollback();
        }
      }
    
    public void remove(Aluno aluno) {
        try {
           entityManager.getTransaction().begin();
           aluno = entityManager.find(Aluno.class, aluno.getId());
           entityManager.remove(aluno);
           entityManager.getTransaction().commit();
        } catch (Exception ex) {
           ex.printStackTrace();
           entityManager.getTransaction().rollback();
        }
      }
    
    public void removeById(final int id) {
        try {
           Aluno aluno = getById(id);
           remove(aluno);
        } catch (Exception ex) {
           ex.printStackTrace();
        }
      }
}
