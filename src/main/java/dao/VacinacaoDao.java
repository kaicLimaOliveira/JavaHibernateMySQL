
package dao;

import java.util.ArrayList;
import model.VacinacaoModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class VacinacaoDao implements GenericDao<VacinacaoModel> {

    @Override
    public void incluir(VacinacaoModel vacinacao) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(vacinacao);
        t.commit();
        session.close();
    }

    @Override
    public void alterar(VacinacaoModel vacinacao) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(vacinacao);
        t.commit();
        session.close();
    }

    @Override
    public ArrayList<VacinacaoModel> consultar(String filtro) {
        String sql = "from " + VacinacaoModel.class.getName() + filtro;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        ArrayList lista = (ArrayList<VacinacaoModel>) session.createQuery(sql).list();
        t.commit();
        session.close();
        return lista;
    }

    @Override
    public void excluir(VacinacaoModel vacinacao) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(vacinacao);
        t.commit();
        session.close();
    }

    @Override
    public VacinacaoModel get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (VacinacaoModel) session.load(VacinacaoModel.class, id);
    }
}
