package com.bukhari.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/***
 * 
 * @author shuja
 * 
 * For Storing the Data into the Database!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        Student student = new Student(1,"Sameer", "Ahmed", 22);
    	
        
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        
        // To save the Data into the Database
        session.save(student);
        // To cmmit changes
        tx.commit();
        
       
    }
}
