
package controller;

import dao.VacinadoresDao;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.VacinadoresModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.ReportUtils;


public class VacinadoresController implements GenericController<VacinadoresModel> {

    VacinadoresDao vacinadoresDao;

    public VacinadoresController() {
        vacinadoresDao = new VacinadoresDao();
    }

    @Override
    public void incluir(VacinadoresModel obj) throws Exception{
        vacinadoresDao.incluir(obj);
    }

    @Override
    public void alterar(VacinadoresModel obj) throws Exception{
        vacinadoresDao.alterar(obj);
    }

    @Override
    public void excluir(VacinadoresModel obj) throws Exception{
        vacinadoresDao.excluir(obj);
    }

    @Override
    public ArrayList<VacinadoresModel> consultar(String filtro) {
        return vacinadoresDao.consultar(filtro);
    }

    @Override
    public void gravar(VacinadoresModel obj, String operacao) throws Exception{
        if (operacao.equals("incluir")) {
            incluir(obj);
        } else {
            alterar(obj);
        }
    }

    @Override
    public Exception imprimir() {
        Exception retorno = null;
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/RelatorioVacinadores.jasper");
//        btnPRIMEIRO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/primeiro.png"))); // NOI18N

        Map parametros = new HashMap();
        
        List dados = consultar("");
        
        // criando o datasource com os dados criados
        JRDataSource ds = new JRBeanCollectionDataSource(dados);

        try {
            // passando o datasource para o método de criação e exibição do relatório
            ReportUtils.openReport("Vacinadores - Bean Collection Data Source", inputStream, parametros, ds);

        } catch (Exception ex) {
            retorno =  ex;
        }
        return retorno;
    }
}
