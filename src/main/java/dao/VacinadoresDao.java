
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.VacinadoresModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class VacinadoresDao implements GenericDao<VacinadoresModel> {

    @Override
    public void incluir(VacinadoresModel vacinadores) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(vacinadores);
        t.commit();
        session.close();
    }

    @Override
    public void alterar(VacinadoresModel vacinadores) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(vacinadores);
        t.commit();
        session.close();
    }

    @Override
    public ArrayList<VacinadoresModel> consultar(String filtro) {
        String sql = "from " + VacinadoresModel.class.getName() + filtro;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        ArrayList lista = (ArrayList<VacinadoresModel>) session.createQuery(sql).list();
        t.commit();
        session.close();
        return lista;
    }

    @Override
    public void excluir(VacinadoresModel vacinadores) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(vacinadores);
        t.commit();
        session.close();
    }

    @Override
    public VacinadoresModel get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (VacinadoresModel) session.load(VacinadoresModel.class, id);
    }
    
    
}

