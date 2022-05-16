package com.example.repository;

import com.example.entity.Customer;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerRepositoryImpl {

    private EntityManagerFactory entityManagerFactory;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void insert(Customer customer){

        EntityManager entityManager=this.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
    }

    public int remove(Long phoneNo){
        int i=0;
        EntityManager entityManager=this.entityManagerFactory.createEntityManager();
        try
        {
            entityManager.getTransaction().begin();
            Customer cust=entityManager.find(Customer.class,phoneNo);
            entityManager.remove(cust);
            i=1;
            entityManager.getTransaction().commit();
        }catch (DataAccessException e){
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
        return i;
    }

    public List<Customer> getall(){
        EntityManager entityManager=this.entityManagerFactory.createEntityManager();
        Query query=entityManager.createQuery("select c from Customer c");
        return (List<Customer>) query.getResultList();
    }

    public void update(Long phoneNo,String name){
        EntityManager entityManager=this.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Customer cust=entityManager.find(Customer.class,phoneNo);
        cust.setName(name);
        entityManager.getTransaction().commit();
    }
}
