
package controller;

import dao.UnidadeSaudeDao;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.UnidadeSaudeModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.ReportUtils;


public class UnidadeSaudeController implements GenericController<UnidadeSaudeModel> {

    UnidadeSaudeDao unidadeSaudeDao;

    public UnidadeSaudeController() {
        unidadeSaudeDao = new UnidadeSaudeDao();
    }

    @Override
    public void incluir(UnidadeSaudeModel obj) throws Exception{
        unidadeSaudeDao.incluir(obj);
    }

    @Override
    public void alterar(UnidadeSaudeModel obj) throws Exception{
        unidadeSaudeDao.alterar(obj);
    }

    @Override
    public void excluir(UnidadeSaudeModel obj) throws Exception{
        unidadeSaudeDao.excluir(obj);
    }

    @Override
    public ArrayList<UnidadeSaudeModel> consultar(String filtro) {
        return unidadeSaudeDao.consultar(filtro);
    }

    @Override
    public void gravar(UnidadeSaudeModel obj, String operacao) throws Exception{
        if (operacao.equals("incluir")) {
            incluir(obj);
        } else {
            alterar(obj);
        }
    }

    @Override
    public Exception imprimir() {
        Exception retorno = null;
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/RelatorioUnidadeSaude.jasper");
//        btnPRIMEIRO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/primeiro.png"))); // NOI18N

        Map parametros = new HashMap();
        
        List dados = consultar("");
        
        // criando o datasource com os dados criados
        JRDataSource ds = new JRBeanCollectionDataSource(dados);

        try {
            // passando o datasource para o método de criação e exibição do relatório
            ReportUtils.openReport("Unidade Saude - Bean Collection Data Source", inputStream, parametros, ds);

        } catch (Exception ex) {
            retorno =  ex;
        }
        return retorno;
    }
}
