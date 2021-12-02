
package controller;

import dao.FabricanteDao;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FabricanteModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.ReportUtils;


public class FabricanteController implements GenericController<FabricanteModel> {

    FabricanteDao fabricanteDao;

    public FabricanteController() {
        fabricanteDao = new FabricanteDao();
    }

    @Override
    public void incluir(FabricanteModel obj) throws Exception{
        fabricanteDao.incluir(obj);
    }

    @Override
    public void alterar(FabricanteModel obj) throws Exception{
        fabricanteDao.alterar(obj);
    }

    @Override
    public void excluir(FabricanteModel obj) throws Exception{
        fabricanteDao.excluir(obj);
    }

    @Override
    public ArrayList<FabricanteModel> consultar(String filtro) {
        return fabricanteDao.consultar(filtro);
    }

    @Override
    public void gravar(FabricanteModel obj, String operacao) throws Exception{
        if (operacao.equals("incluir")) {
            incluir(obj);
        } else {
            alterar(obj);
        }
    }

    @Override
    public Exception imprimir() {
        Exception retorno = null;
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/RelatorioFabricante.jasper");
//        btnPRIMEIRO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/primeiro.png"))); // NOI18N

        Map parametros = new HashMap();
        
        List dados = consultar("");
        
        // criando o datasource com os dados criados
        JRDataSource ds = new JRBeanCollectionDataSource(dados);

        try {
            // passando o datasource para o método de criação e exibição do relatório
            ReportUtils.openReport("Fabricante - Bean Collection Data Source", inputStream, parametros, ds);

        } catch (Exception ex) {
            retorno =  ex;
        }
        return retorno;
    }
}
