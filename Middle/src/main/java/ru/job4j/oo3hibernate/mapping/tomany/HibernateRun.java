package ru.job4j.oo3hibernate.mapping.tomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();
            Integer idF = (Integer) session.save(new Car("type1"));
            Integer idG = (Integer) session.save(new Car("type2"));
            Integer idL = (Integer) session.save(new Car("type3"));
            Integer idM = (Integer) session.save(new Car("type4"));
            Integer idN = (Integer) session.save(new Car("type5"));
            CarBrand bmb = new CarBrand("volvo");
            bmb.addCar(session.load(Car.class, idF));
            bmb.addCar(session.load(Car.class, idG));
            bmb.addCar(session.load(Car.class, idL));
            bmb.addCar(session.load(Car.class, idM));
            bmb.addCar(session.load(Car.class, idN));
            session.save(bmb);
            session.getTransaction().commit();
            session.close();
        } catch (
                Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
