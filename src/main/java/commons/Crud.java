package commons;

import models.Model;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import commons.OracleFactory;
import models.Departamento;

public class Crud {
  private SessionFactory factory;
  private Session session;
  private Model model;

  public Crud(Model model) {
    this.model = model;
  }

  public boolean insertOrUpdate() {
    this.start();
    Transaction t = session.beginTransaction();
    session.saveOrUpdate(this.model);
    t.commit();
    this.finish();
    return true;
  }

  public boolean delete() {
    this.start();
    Transaction t = session.beginTransaction();
    session.delete(this.model);
    t.commit();
    this.finish();
    return true;
  }

  private void start() {
    this.factory = OracleFactory.getOracleFactory();
    this.session = factory.openSession();
  }

  private void finish() {
    this.factory.close();
    this.session.close();
  }

}
