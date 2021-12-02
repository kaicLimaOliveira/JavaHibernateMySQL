
package model;

import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import principal.FormMenu;
import util.HibernateUtil;


public class ValidacaoLogin {
    
    public static boolean Login(String username, String password){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        UsuarioModel usuario = (UsuarioModel) session.createCriteria(UsuarioModel.class)
                .add(Restrictions.eq("USU_LOGIN", username)).uniqueResult();
                
        
        if(usuario!=null){
            
            if(usuario.getUSU_SENHA().equals(password)){
                FormMenu formMenu = null;
                formMenu = new FormMenu();
                formMenu.setVisible(true);
                
            }else{
                JOptionPane.showMessageDialog(null, "Senha errada");
                return false;
            }
            
            session.close();
        }else{
            JOptionPane.showMessageDialog(null, "Senha errada");
            return false;
        }
        return false;
    }    
}
