package com.xiaoyi.springmvc.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.xiaoyi.springmvc.configuration.HibernateConfiguration;

public class CreateHibernateSessionFactoryExample {

	public static void main( String[] args )
    {
        Session session = HibernateConfiguration.getSessionFactory().openSession();

        Query query = session.createQuery("from LineDefence where id = :id ");
        query.setParameter("id", 2);

        // You can replace the above to commands with this one
        // Query query = session.createQuery("from Student where studentId = 1 ");
        List<?> list = query.list();

      //  Student student = (Student)list.get(0);

        System.out.println(list.size());
    }

}
