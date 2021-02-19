package ru.job4j.oo3hibernate.hql.ohql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class HbmRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction(); /*

            Candidate one = Candidate.of("Alex", 1, 80);
            Candidate two = Candidate.of("Nikolay", 2, 100);
            Candidate three = Candidate.of("Nikita", 5, 200);

            session.save(one);
            session.save(two);
            session.save(three);

            Query query = session.createQuery("from Candidate c where c.id = 1");
            System.out.println(query.uniqueResult());

            query = session.createQuery("from Candidate c where c.name = :fName");
            query.setParameter("fName", "Nikita");
            System.out.println(query.uniqueResult());

            session.createQuery("update Candidate c set c.name = :newName, c.expirience = :newExp, c.salary = :newSalary "
                    + "where c.id = :fId")
                    .setParameter("newName", "name")
                    .setParameter("newExp", 0)
                    .setParameter("newSalary", 0)
                    .setParameter("fId", 1)
                    .executeUpdate();

            session.createQuery("delete from Candidate where id = :fId")
                    .setParameter("fId", 1)
                    .executeUpdate();*/

            Query query = session.createQuery("from Candidate");
            for (Object st : query.list()) {
                System.out.println(st);
            }

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
