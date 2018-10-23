package oracleconn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import models.Departamento;

public class Main {

	public static void main(String[] args) {
		// Create typesafe ServiceRegistry object
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Departamento departamento = new Departamento();
		departamento.setIdDepartamento(7);
		departamento.setNombreDepartamento("BOGOTA");

		session.save(departamento);
		t.commit();
		System.out.println("successfully saved");
		factory.close();
		session.close();
	}

	/*
	 * public static void main(String[] args) { try { Connection conn =
	 * OraConn.connect(); Statement st = conn.createStatement();
	 * 
	 * ResultSet rs = st.executeQuery("SELECT * FROM CIUDAD");
	 * 
	 * while(rs.next()) {
	 * 
	 * System.out.println(rs.getInt(1)); System.out.println(rs.getString(2)); } }
	 * catch (Exception ex) { ex.printStackTrace(); } }
	 */
}
