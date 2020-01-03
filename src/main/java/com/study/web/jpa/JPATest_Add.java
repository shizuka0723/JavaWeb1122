package com.study.web.jpa;

import com.study.web.jpa.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPATest_Add {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em= emf.createEntityManager();
        
        User user = new User();
        user.setName("noa");
        user.setAge(20);
        
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        
        System.out.println(em);
    }
}
