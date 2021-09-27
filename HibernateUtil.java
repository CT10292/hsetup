package in.marcusa.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static StandardServiceRegistry ssr;
	private static Metadata meta;
	private static SessionFactory factory;
	static {
		ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		meta = new MetadataSources(ssr).getMetadataBuilder().build();
		factory = meta.getSessionFactoryBuilder().build();
	}
	public static Session getSession() {
		Session session = factory.openSession();
		return session;
	}
	public static void shutdown() {
		// Close caches and connection pools
		factory.close();
	}
}
