
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "UNIDADE_SAUDE")
public class UnidadeSaudeModel implements java.io.Serializable {

    @Id
    @Column(name = "UNIS_ID", nullable = false, precision = 11, scale = 0)
    private int UNIS_ID;

    @Column(name = "UNIS_NOME", nullable = false, length = 80)
    private String UNIS_NOME;

    @Column(name = "UNIS_ESTADO", nullable = false, length = 30)
    private String UNIS_ESTADO;

    @Column(name = "UNIS_CIDADE", nullable = false, length = 30)
    private String UNIS_CIDADE;
    
    @Column(name = "UNIS_GESTAO", nullable = false, length = 30)
    private String UNIS_GESTAO;

    @Column(name = "UNIS_ATENDE_SUS", precision = 1)
    private int UNIS_ATENDE_SUS;

    @Override
    public String toString() {
        return this.UNIS_NOME;
    }

    public UnidadeSaudeModel() {
    } 

    public UnidadeSaudeModel(int UNIS_ID, String UNIS_NOME, String UNIS_ESTADO, String UNIS_CIDADE, String UNIS_GESTAO, int UNIS_ATENDE_SUS) {
        this.UNIS_ID = UNIS_ID;
        this.UNIS_NOME = UNIS_NOME;
        this.UNIS_ESTADO = UNIS_ESTADO;
        this.UNIS_CIDADE = UNIS_CIDADE;
        this.UNIS_GESTAO = UNIS_GESTAO;
        this.UNIS_ATENDE_SUS = UNIS_ATENDE_SUS;
    }

    public int getUNIS_ID() {
        return UNIS_ID;
    }

    public void setUNIS_ID(int UNIS_ID) {
        this.UNIS_ID = UNIS_ID;
    }

    public String getUNIS_NOME() {
        return UNIS_NOME;
    }

    public void setUNIS_NOME(String UNIS_NOME) {
        this.UNIS_NOME = UNIS_NOME;
    }

    public String getUNIS_ESTADO() {
        return UNIS_ESTADO;
    }

    public void setUNIS_ESTADO(String UNIS_ESTADO) {
        this.UNIS_ESTADO = UNIS_ESTADO;
    }

    public String getUNIS_CIDADE() {
        return UNIS_CIDADE;
    }

    public void setUNIS_CIDADE(String UNIS_CIDADE) {
        this.UNIS_CIDADE = UNIS_CIDADE;
    }

    public String getUNIS_GESTAO() {
        return UNIS_GESTAO;
    }

    public void setUNIS_GESTAO(String UNIS_GESTAO) {
        this.UNIS_GESTAO = UNIS_GESTAO;
    }

    public int getUNIS_ATENDE_SUS() {
        return UNIS_ATENDE_SUS;
    }

    public void setUNIS_ATENDE_SUS(int UNIS_ATENDE_SUS) {
        this.UNIS_ATENDE_SUS = UNIS_ATENDE_SUS;
    }
    
    
}
