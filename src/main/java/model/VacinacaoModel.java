
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "VACINACAO")
public class VacinacaoModel implements java.io.Serializable {

    @Id
    @Column(name = "VNC_ID", nullable = false, precision = 11, scale = 0)
    private int VNC_ID;

    @Column(name = "VNC_NOME", nullable = false, length = 80)
    private String VNC_NOME;

    @Column(name = "VNC_PACIENTE", nullable = false, length = 20)
    private String VNC_PACIENTE;

    @Column(name = "VNC_POSTO_SAUDE", nullable = false, length = 20)
    private String VNC_POSTO_SAUDE;
    
    @Column(name = "VNC_LOTE", nullable = false, precision = 10)
    private int VNC_LOTE;
    
    @Column(name = "VNC_FABRICANTE", nullable = false, length = 20)
    private String VNC_FABRICANTE;
    
    @Column(name = "VNC_REGISTRO_PROF", nullable = false, precision = 10)
    private int VNC_REGISTRO_PROF;
    
    @Column(name = "VNC_DATA_VACINA", nullable = false, length = 10)
    private String VNC_DATA_VACINA;

    @Column(name = "VNC_DOSE", nullable = false, length = 20)
    private String VNC_DOSE;

    @Override
    public String toString() {
        return this.VNC_NOME;
    }

    public VacinacaoModel() {
    }

    public VacinacaoModel(int VNC_ID, String VNC_NOME, String VNC_PACIENTE, String VNC_POSTO_SAUDE, int VNC_LOTE, String VNC_FABRICANTE, int VNC_REGISTRO_PROF, String VNC_DATA_VACINA, String VNC_DOSE) {
        this.VNC_ID = VNC_ID;
        this.VNC_NOME = VNC_NOME;
        this.VNC_PACIENTE = VNC_PACIENTE;
        this.VNC_POSTO_SAUDE = VNC_POSTO_SAUDE;
        this.VNC_LOTE = VNC_LOTE;
        this.VNC_FABRICANTE = VNC_FABRICANTE;
        this.VNC_REGISTRO_PROF = VNC_REGISTRO_PROF;
        this.VNC_DATA_VACINA = VNC_DATA_VACINA;
        this.VNC_DOSE = VNC_DOSE;
    }

    public int getVNC_ID() {
        return VNC_ID;
    }

    public void setVNC_ID(int VNC_ID) {
        this.VNC_ID = VNC_ID;
    }

    public String getVNC_NOME() {
        return VNC_NOME;
    }

    public void setVNC_NOME(String VNC_NOME) {
        this.VNC_NOME = VNC_NOME;
    }

    public String getVNC_PACIENTE() {
        return VNC_PACIENTE;
    }

    public void setVNC_PACIENTE(String VNC_PACIENTE) {
        this.VNC_PACIENTE = VNC_PACIENTE;
    }

    public String getVNC_POSTO_SAUDE() {
        return VNC_POSTO_SAUDE;
    }

    public void setVNC_POSTO_SAUDE(String VNC_POSTO_SAUDE) {
        this.VNC_POSTO_SAUDE = VNC_POSTO_SAUDE;
    }

    public int getVNC_LOTE() {
        return VNC_LOTE;
    }

    public void setVNC_LOTE(int VNC_LOTE) {
        this.VNC_LOTE = VNC_LOTE;
    }

    public String getVNC_FABRICANTE() {
        return VNC_FABRICANTE;
    }

    public void setVNC_FABRICANTE(String VNC_FABRICANTE) {
        this.VNC_FABRICANTE = VNC_FABRICANTE;
    }

    public int getVNC_REGISTRO_PROF() {
        return VNC_REGISTRO_PROF;
    }

    public void setVNC_REGISTRO_PROF(int VNC_REGISTRO_PROF) {
        this.VNC_REGISTRO_PROF = VNC_REGISTRO_PROF;
    }

    public String getVNC_DATA_VACINA() {
        return VNC_DATA_VACINA;
    }

    public void setVNC_DATA_VACINA(String VNC_DATA_VACINA) {
        this.VNC_DATA_VACINA = VNC_DATA_VACINA;
    }

    public String getVNC_DOSE() {
        return VNC_DOSE;
    }

    public void setVNC_DOSE(String VNC_DOSE) {
        this.VNC_DOSE = VNC_DOSE;
    }
    
    
}
