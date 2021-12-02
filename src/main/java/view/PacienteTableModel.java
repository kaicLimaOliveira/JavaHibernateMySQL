
package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.PacienteModel;


public class PacienteTableModel extends AbstractTableModel {

    private ArrayList<PacienteModel> linhas;
    String[] colunas = {"ID", "Nome", "Cpf", "Endereço", "Ativo"};

    public PacienteTableModel(ArrayList<PacienteModel> arrayPaciente) {
        linhas = arrayPaciente;
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
        PacienteModel paciente = (PacienteModel) linhas.get(row);
        switch (col) {
            case 0:
                return paciente.getPAC_ID();
            case 1:
                return paciente.getPAC_NOME();
            case 2:
                return paciente.getPAC_CPF();
            case 3:
                return paciente.getPAC_END();  
            case 4:
                return paciente.getPAC_ATIVO();
            default:
                return null;
        }
    }

    //Adicionamos várias linhas na tabela de uma vez, recebendo um List de PacienteModel
    public void addLista(ArrayList<PacienteModel> paciente) {
        int tamanhoAntigo = getRowCount();

        //Adiciona os pacientes
        linhas.addAll(paciente);

        //Aqui reportamos a mudança para o JTable, assim ele pode se redesenhar, para visualizarmos a alteração
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
}
