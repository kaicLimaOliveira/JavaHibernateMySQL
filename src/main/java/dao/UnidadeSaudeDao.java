
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.UnidadeSaudeModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class UnidadeSaudeDao implements GenericDao<UnidadeSaudeModel> {

    @Override
    public void incluir(UnidadeSaudeModel unidadeSaude) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(unidadeSaude);
        t.commit();
        session.close();
    }

    @Override
    public void alterar(UnidadeSaudeModel unidadeSaude) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(unidadeSaude);
        t.commit();
        session.close();
    }

    @Override
    public ArrayList<UnidadeSaudeModel> consultar(String filtro) {
        String sql = "from " + UnidadeSaudeModel.class.getName() + filtro;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        ArrayList lista = (ArrayList<UnidadeSaudeModel>) session.createQuery(sql).list();
        t.commit();
        session.close();
        return lista;
    }

    @Override
    public void excluir(UnidadeSaudeModel unidadeSaude) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(unidadeSaude);
        t.commit();
        session.close();
    }

    @Override
    public UnidadeSaudeModel get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (UnidadeSaudeModel) session.load(UnidadeSaudeModel.class, id);
    }
    
    
}

