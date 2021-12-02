
package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.VacinadoresModel;


public class VacinadoresTableModel extends AbstractTableModel {

    private ArrayList<VacinadoresModel> linhas;
    String[] colunas = {"ID", "Nome", "Registro Profissional", "Número de Cadastro", "Ativo"};

    public VacinadoresTableModel(ArrayList<VacinadoresModel> arrayVacinadores) {
        linhas = arrayVacinadores;
    }

    //Retorna a quantidade de colunas do modelo, que no caso será fixa
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    //Retorna a quantidade de linhas atual do objeto, que no caso é o tamnho da lista
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    //Retorna o nome da coluna, recebendo seu índice
    @Override
    public String getColumnName(int indiceColuna) {
        return colunas[indiceColuna];
    }

    @Override
    public Object getValueAt(int row, int col) {
        VacinadoresModel vacinadores = (VacinadoresModel) linhas.get(row);
        switch (col) {
            case 0:
                return vacinadores.getVAC_ID();
            case 1:
                return vacinadores.getVAC_NOME();
            case 2:
                return vacinadores.getVAC_REGISTRO_PROF();
            case 3:
                return vacinadores.getVAC_NUMERO_CADASTRO(); 
            case 4:
                return vacinadores.getVAC_ATIVO();
            default:
                return null;
        }
    }

    //Adicionamos várias linhas na tabela de uma vez, recebendo um List de VacinadoresModel
    public void addLista(ArrayList<VacinadoresModel> vacinadores) {
        int tamanhoAntigo = getRowCount();

        //Adiciona os usuários
        linhas.addAll(vacinadores);

        //Aqui reportamos a mudança para o JTable, assim ele pode se redesenhar, para visualizarmos a alteração
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
}
