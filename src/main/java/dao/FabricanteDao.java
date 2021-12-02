
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.FabricanteModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class FabricanteDao implements GenericDao<FabricanteModel> {

    @Override
    public void incluir(FabricanteModel fabricante) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(fabricante);
        t.commit();
        session.close();
    }

    @Override
    public void alterar(FabricanteModel fabricante) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(fabricante);
        t.commit();
        session.close();
    }

    @Override
    public ArrayList<FabricanteModel> consultar(String filtro) {
        String sql = "FROM " + FabricanteModel.class.getName() + filtro;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        ArrayList lista = (ArrayList<FabricanteModel>) session.createQuery(sql).list();
        t.commit();
        session.close();
        return lista;
    }

    @Override
    public void excluir(FabricanteModel fabricante) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(fabricante);
        t.commit();
        session.close();
    }

    @Override
    public FabricanteModel get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (FabricanteModel) session.load(FabricanteModel.class, id);
    }
    
    
}
