
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "FABRICANTES")
public class FabricanteModel implements java.io.Serializable {

    @Id
    @Column(name = "FAB_ID", nullable = false, precision = 11, scale = 0)
    private int FAB_ID;

    @Column(name = "FAB_NOME_FABRICANTE", nullable = false, length = 60)
    private String FAB_NOME_FABRICANTE;

    @Column(name = "FAB_DATA_FABRICACAO", nullable = false, length = 20)
    private String FAB_DATA_FABRICACAO;

    @Column(name = "FAB_LOTE", nullable = false, precision = 11)
    private int FAB_LOTE;
    
    @Column(name = "FAB_NOME_VACINA", nullable = false, length = 30)
    private String FAB_NOME_VACINA;

    @Column(name = "FAB_ATIVO", precision = 1)
    private int FAB_ATIVO;

    @Override
    public String toString() {
        return this.FAB_NOME_FABRICANTE;
    }

    public FabricanteModel() {
    }

    public FabricanteModel(int FAB_ID, String FAB_NOME_FABRICANTE, String FAB_DATA_FABRICACAO, int FAB_LOTE, String FAB_NOME_VACINA, int FAB_ATIVO) {
        this.FAB_ID = FAB_ID;
        this.FAB_NOME_FABRICANTE = FAB_NOME_FABRICANTE;
        this.FAB_DATA_FABRICACAO = FAB_DATA_FABRICACAO;
        this.FAB_LOTE = FAB_LOTE;
        this.FAB_NOME_VACINA = FAB_NOME_VACINA;
        this.FAB_ATIVO = FAB_ATIVO;
    }

    public int getFAB_ID() {
        return FAB_ID;
    }

    public void setFAB_ID(int FAB_ID) {
        this.FAB_ID = FAB_ID;
    }

    public String getFAB_NOME_FABRICANTE() {
        return FAB_NOME_FABRICANTE;
    }

    public void setFAB_NOME_FABRICANTE(String FAB_NOME_FABRICANTE) {
        this.FAB_NOME_FABRICANTE = FAB_NOME_FABRICANTE;
    }

    public String getFAB_DATA_FABRICACAO() {
        return FAB_DATA_FABRICACAO;
    }

    public void setFAB_DATA_FABRICACAO(String FAB_DATA_FABRICACAO) {
        this.FAB_DATA_FABRICACAO = FAB_DATA_FABRICACAO;
    }

    public int getFAB_LOTE() {
        return FAB_LOTE;
    }

    public void setFAB_LOTE(int FAB_LOTE) {
        this.FAB_LOTE = FAB_LOTE;
    }

    public String getFAB_NOME_VACINA() {
        return FAB_NOME_VACINA;
    }

    public void setFAB_NOME_VACINA(String FAB_NOME_VACINA) {
        this.FAB_NOME_VACINA = FAB_NOME_VACINA;
    }

    public int getFAB_ATIVO() {
        return FAB_ATIVO;
    }

    public void setFAB_ATIVO(int FAB_ATIVO) {
        this.FAB_ATIVO = FAB_ATIVO;
    }

   
    
    
}
