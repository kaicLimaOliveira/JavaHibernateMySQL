/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kaic1
 */

@Entity
@Table(name = "PACIENTE")
public class PacienteModel implements java.io.Serializable {

    @Id
    @Column(name = "PAC_ID", nullable = false, precision = 11, scale = 0)
    private int PAC_ID;

    @Column(name = "PAC_NOME", nullable = false, length = 80)
    private String PAC_NOME;

    @Column(name = "PAC_CPF", nullable = false, precision = 11)
    private int PAC_CPF;

    @Column(name = "PAC_END", nullable = false, length = 20)
    private String PAC_END;

    @Column(name = "PAC_ATIVO", precision = 1)
    private int PAC_ATIVO;
    
    @Override
    public String toString() {
        return this.PAC_NOME;
    }

    public PacienteModel() {
    }

    public PacienteModel(int PAC_ID, String PAC_NOME, int PAC_CPF, String PAC_END, int PAC_ATIVO) {
        this.PAC_ID = PAC_ID;
        this.PAC_NOME = PAC_NOME;
        this.PAC_CPF = PAC_CPF;
        this.PAC_END = PAC_END;
        this.PAC_ATIVO = PAC_ATIVO;
    }

    public int getPAC_ID() {
        return PAC_ID;
    }

    public void setPAC_ID(int PAC_ID) {
        this.PAC_ID = PAC_ID;
    }

    public String getPAC_NOME() {
        return PAC_NOME;
    }

    public void setPAC_NOME(String PAC_NOME) {
        this.PAC_NOME = PAC_NOME;
    }

    public int getPAC_CPF() {
        return PAC_CPF;
    }

    public void setPAC_CPF(int PAC_CPF) {
        this.PAC_CPF = PAC_CPF;
    }

    public String getPAC_END() {
        return PAC_END;
    }

    public void setPAC_END(String PAC_END) {
        this.PAC_END = PAC_END;
    }

    public int getPAC_ATIVO() {
        return PAC_ATIVO;
    }

    public void setPAC_ATIVO(int PAC_ATIVO) {
        this.PAC_ATIVO = PAC_ATIVO;
    }
    
    
}

