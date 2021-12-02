
package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.VacinacaoModel;


public class VacinacaoTableModel extends AbstractTableModel {

    private ArrayList<VacinacaoModel> linhas;
    String[] colunas = {"ID", "Nome", "Paciente", "Posto de Saúde", "Lote", "Fabricante", "Registro Profissional", "Data Vacina", "Dose"};

    public VacinacaoTableModel(ArrayList<VacinacaoModel> arrayVacinacao) {
        linhas = arrayVacinacao;
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
        VacinacaoModel vacinacao = (VacinacaoModel) linhas.get(row);
        switch (col) {
            case 0:
                return vacinacao.getVNC_ID();
            case 1:
                return vacinacao.getVNC_NOME();
            case 2:
                return vacinacao.getVNC_PACIENTE();
            case 3:
                return vacinacao.getVNC_POSTO_SAUDE();  
            case 4:
                return vacinacao.getVNC_LOTE();
            case 5:
                return vacinacao.getVNC_FABRICANTE();
            case 6:
                return vacinacao.getVNC_REGISTRO_PROF();
            case 7:
                return vacinacao.getVNC_DATA_VACINA();
            case 8:
                return vacinacao.getVNC_DOSE();
            default:
                return null;
        }
    }

    //Adicionamos várias linhas na tabela de uma vez, recebendo um List de VacinacaoModel
    public void addLista(ArrayList<VacinacaoModel> vacinacao) {
        int tamanhoAntigo = getRowCount();

        //Adiciona os usuários
        linhas.addAll(vacinacao);

        //Aqui reportamos a mudança para o JTable, assim ele pode se redesenhar, para visualizarmos a alteração
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
}
