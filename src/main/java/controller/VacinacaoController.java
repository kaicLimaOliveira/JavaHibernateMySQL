
package controller;

import dao.VacinacaoDao;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.VacinacaoModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.ReportUtils;


public class VacinacaoController implements GenericController<VacinacaoModel> {

    VacinacaoDao vacinacaoDao;

    public VacinacaoController() {
        vacinacaoDao = new VacinacaoDao();
    }

    @Override
    public void incluir(VacinacaoModel obj) throws Exception{
        vacinacaoDao.incluir(obj);
    }

    @Override
    public void alterar(VacinacaoModel obj) throws Exception{
        vacinacaoDao.alterar(obj);
    }

    @Override
    public void excluir(VacinacaoModel obj) throws Exception{
        vacinacaoDao.excluir(obj);
    }

    @Override
    public ArrayList<VacinacaoModel> consultar(String filtro) {
        return vacinacaoDao.consultar(filtro);
    }

    @Override
    public void gravar(VacinacaoModel obj, String operacao) throws Exception{
        if (operacao.equals("incluir")) {
            incluir(obj);
        } else {
            alterar(obj);
        }
    }

    @Override
    public Exception imprimir() {
        Exception retorno = null;
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/RelatorioVacinacao.jasper");
//        btnPRIMEIRO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/primeiro.png"))); // NOI18N

        Map parametros = new HashMap();
        
        List dados = consultar("");
        
        // criando o datasource com os dados criados
        JRDataSource ds = new JRBeanCollectionDataSource(dados);

        try {
            // passando o datasource para o método de criação e exibição do relatório
            ReportUtils.openReport("Vacinação - Bean Collection Data Source", inputStream, parametros, ds);

        } catch (Exception ex) {
            retorno =  ex;
        }
        return retorno;
    }
}
