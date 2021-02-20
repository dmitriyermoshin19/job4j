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

            Account account1 = Account.of("Alex");
            Account account2 = Account.of("Nikolay");
            Account account3 = Account.of("Nikita");

            Candidate one = Candidate.of(account1.getUserName(), 1, 80, account1);
            Candidate two = Candidate.of(account2.getUserName(), 2, 100, account2);
            Candidate three = Candidate.of(account3.getUserName(), 5, 200, account3);

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
                    .executeUpdate();

            Query query = session.createQuery("from Candidate");
            for (Object st : query.list()) {
                System.out.println(st);
            }

            Query query = session.createQuery("select c from Candidate c where c.id = 5", Candidate.class);
            System.out.println(query.uniqueResult());*/

            Candidate rsl = session.createQuery(
                    "select distinct c from Candidate c "
                            + "join fetch c.account a "
                            + "join fetch a.vacancyList "
                            + "where c.id = :sId", Candidate.class
            ).setParameter("sId", 4).uniqueResult();
            System.out.println(rsl);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
