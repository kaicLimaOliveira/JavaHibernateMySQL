
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.PacienteModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class PacienteDao implements GenericDao<PacienteModel> {

    @Override
    public void incluir(PacienteModel paciente) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(paciente);
        t.commit();
        session.close();
    }

    @Override
    public void alterar(PacienteModel paciente) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(paciente);
        t.commit();
        session.close();
    }

    
    public ArrayList<PacienteModel> consultar(String filtro) {
        String sql = "FROM " + PacienteModel.class.getName() + filtro;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        ArrayList lista = (ArrayList) session.createQuery(sql).list();

        t.commit();
        session.close();
        return lista;
    }

    @Override
    public void excluir(PacienteModel paciente) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(paciente);
        t.commit();
        session.close();
    }

    public PacienteModel get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (PacienteModel) session.load(PacienteModel.class, id);
    }


}
