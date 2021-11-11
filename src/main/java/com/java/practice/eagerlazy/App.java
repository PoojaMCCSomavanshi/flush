package com.java.practice.eagerlazy;

import java.util.Collection;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		System.out.println( "Hello World!" );

		Laptop lp=new Laptop();
		lp.setLid(102);
		lp.setBrand("hp");
		lp.setPrice(100000);

		Alian a1=new Alian();
		a1.setAid(101);
		a1.setAname("pooja");
		a1.getLap().add(lp);

		Configuration conf=new Configuration().configure().addAnnotatedClass(Alian.class).addAnnotatedClass(Laptop.class);
		ServiceRegistry sfactory=new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		SessionFactory sf=conf.buildSessionFactory(sfactory);
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();

		System.out.println(a1.getAname());
		session.save(a1);
		session.save(lp);



		session.getTransaction().commit();

	}
}
