
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "VACINADORES")
public class VacinadoresModel implements java.io.Serializable {

    @Id
    @Column(name = "VAC_ID", nullable = false, precision = 11, scale = 0)
    private int VAC_ID;

    @Column(name = "VAC_NOME", nullable = false, length = 80)
    private String VAC_NOME;

    @Column(name = "VAC_REGISTRO_PROF", nullable = false, precision = 11)
    private int VAC_REGISTRO_PROF;

    @Column(name = "VAC_NUMERO_CADASTRO", nullable = false, precision = 11)
    private int VAC_NUMERO_CADASTRO;

    @Column(name = "VAC_ATIVO", precision = 1)
    private int VAC_ATIVO;

    @Override
    public String toString() {
        return this.VAC_NOME;
    }

    public VacinadoresModel() {
    } 

    public VacinadoresModel(int VAC_ID, String VAC_NOME, int VAC_REGISTRO_PROF, int VAC_NUMERO_CADASTRO, int VAC_ATIVO) {
        this.VAC_ID = VAC_ID;
        this.VAC_NOME = VAC_NOME;
        this.VAC_REGISTRO_PROF = VAC_REGISTRO_PROF;
        this.VAC_NUMERO_CADASTRO = VAC_NUMERO_CADASTRO;
        this.VAC_ATIVO = VAC_ATIVO;
    }

    public int getVAC_ID() {
        return VAC_ID;
    }

    public void setVAC_ID(int VAC_ID) {
        this.VAC_ID = VAC_ID;
    }

    public String getVAC_NOME() {
        return VAC_NOME;
    }

    public void setVAC_NOME(String VAC_NOME) {
        this.VAC_NOME = VAC_NOME;
    }

    public int getVAC_REGISTRO_PROF() {
        return VAC_REGISTRO_PROF;
    }

    public void setVAC_REGISTRO_PROF(int VAC_REGISTRO_PROF) {
        this.VAC_REGISTRO_PROF = VAC_REGISTRO_PROF;
    }

    public int getVAC_NUMERO_CADASTRO() {
        return VAC_NUMERO_CADASTRO;
    }

    public void setVAC_NUMERO_CADASTRO(int VAC_NUMERO_CADASTRO) {
        this.VAC_NUMERO_CADASTRO = VAC_NUMERO_CADASTRO;
    }

    public int getVAC_ATIVO() {
        return VAC_ATIVO;
    }

    public void setVAC_ATIVO(int VAC_ATIVO) {
        this.VAC_ATIVO = VAC_ATIVO;
    }
    
    
}
