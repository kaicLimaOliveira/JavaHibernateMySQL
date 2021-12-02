
package controller;

import dao.PacienteDao;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.PacienteModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.ReportUtils;

public class PacienteController implements GenericController<PacienteModel> {

    PacienteDao pacienteDao;

    public PacienteController() {
        pacienteDao = new PacienteDao();
    }

    @Override
    public void incluir(PacienteModel obj) throws Exception{
        pacienteDao.incluir(obj);
    }

    @Override
    public void alterar(PacienteModel obj) throws Exception{
        pacienteDao.alterar(obj);
    }

    @Override
    public void excluir(PacienteModel obj) throws Exception{
        pacienteDao.excluir(obj);
    }

    @Override
    public ArrayList<PacienteModel> consultar(String filtro) {
        return pacienteDao.consultar(filtro);
    }

    @Override
    public void gravar(PacienteModel obj, String operacao) throws Exception{
        if (operacao.equals("incluir")) {
            incluir(obj);
        } else {
            alterar(obj);
        }
    }

    @Override
    public Exception imprimir() {
        Exception retorno = null;
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/RelatorioPaciente.jasper");
//        btnPRIMEIRO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/primeiro.png"))); // NOI18N

        Map parametros = new HashMap();
        
        List dados = consultar("");
        
        // criando o datasource com os dados criados
        JRDataSource ds = new JRBeanCollectionDataSource(dados);

        try {
            // passando o datasource para o método de criação e exibição do relatório
            ReportUtils.openReport("Pacientes - Bean Collection Data Source", inputStream, parametros, ds);

        } catch (Exception ex) {
            retorno =  ex;
        }
        return retorno;
    }
}

