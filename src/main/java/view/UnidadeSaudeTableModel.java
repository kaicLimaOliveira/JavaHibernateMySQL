
package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.UnidadeSaudeModel;

public class UnidadeSaudeTableModel extends AbstractTableModel {

    private ArrayList<UnidadeSaudeModel> linhas;
    String[] colunas = {"ID", "Unidade de Saúde", "Estado", "Cidade", "Gestão", "Atende SUS"};

    public UnidadeSaudeTableModel(ArrayList<UnidadeSaudeModel> arrayUnidadeSaude) {
        linhas = arrayUnidadeSaude;
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
        UnidadeSaudeModel unidadeSaude = (UnidadeSaudeModel) linhas.get(row);
        switch (col) {
            case 0:
                return unidadeSaude.getUNIS_ID();
            case 1:
                return unidadeSaude.getUNIS_NOME();
            case 2:
                return unidadeSaude.getUNIS_ESTADO();
            case 3:
                return unidadeSaude.getUNIS_CIDADE();  
            case 4:
                return unidadeSaude.getUNIS_GESTAO(); 
            case 5:
                return unidadeSaude.getUNIS_ATENDE_SUS(); 
            default:
                return null;
        }
    }

    //Adicionamos várias linhas na tabela de uma vez, recebendo um List de UnidadeSaudeModel
    public void addLista(ArrayList<UnidadeSaudeModel> unidadeSaude) {
        int tamanhoAntigo = getRowCount();

        //Adiciona os usuários
        linhas.addAll(unidadeSaude);

        //Aqui reportamos a mudança para o JTable, assim ele pode se redesenhar, para visualizarmos a alteração
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
}
