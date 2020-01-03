package com.study.web.jpa;

import com.study.web.jpa.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPATest_Query {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em= emf.createEntityManager();
        
        List list = em.createQuery("select u from User u").getResultList();
        System.out.println(list);
        
        List<User> list1 = em.createQuery("select u from User u",User.class).getResultList();
        System.out.println(list1);
        
        String sql = "Select u from User u Where u.age = :age";
        Query query = em.createQuery(sql);
        query.setParameter("age", 20);
        System.out.println(query.getResultList());
        
        //----------------------------------------------------------------------------------------
        
        List list2 = em.createNamedQuery("User.findAll").getResultList();
        System.out.println(list2);
        
        Query query2 = em.createNamedQuery("User.findByage");
        query2.setParameter("age", 20);
        System.out.println(query2.getResultList());
        
        Query query3 = em.createNamedQuery("User.findByName");
        query3.setParameter("name", "haruka");
        System.out.println(query3.getResultList());
    }
}
