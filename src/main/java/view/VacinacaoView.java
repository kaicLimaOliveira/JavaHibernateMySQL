package view;

import controller.UsuarioController;
import controller.VacinacaoController;
import dao.FabricanteDao;
import dao.PacienteDao;
import dao.UnidadeSaudeDao;
import dao.VacinadoresDao;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.FabricanteModel;
import model.PacienteModel;
import model.UnidadeSaudeModel;
import model.UsuarioModel;
import model.VacinacaoModel;
import model.VacinadoresModel;

public class VacinacaoView extends javax.swing.JFrame {

    private String operacao;
    private ArrayList<VacinacaoModel> array;
    private VacinacaoTableModel mtb;
    private VacinacaoController vacinacaoController;

    private String getOperacao() {
        return operacao;
    }

    private void setOperacao(String operacao) {
        Boolean ativar = (operacao.equals("") ? false : true);
        // operacao=""(consulta), operacao="incluir"(inclusão), operacao="alterar"(alteração)
        this.operacao = operacao;
        btnGRAVAR.setEnabled(ativar);
        btnGRAVAR.setEnabled(ativar);
    }

    public VacinacaoView() {
        vacinacaoController = new VacinacaoController();
        this.setPreferredSize(new Dimension(750, 650));
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); 

        initComponents();
        setOperacao(""); // inicializa o form no modo CONSULTA
        setLocationRelativeTo(null);
        
        setPaciente();
        setFabricante();
        setVacinadores();
        setUnidadeSaude();
        
        consultar();
        // adiciona evento para que qdo navegar no JTable, atualize o registro nos JTextField´s
        tblConsulta.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) {
                    return;
                }
                int selecionado = tblConsulta.getSelectedRow();
                if (selecionado >= 0) {
                    mostrar(array.get(selecionado));
                }
            }
        });
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnPRIMEIRO = new javax.swing.JButton();
        btnANTERIOR = new javax.swing.JButton();
        btnPROXIMO = new javax.swing.JButton();
        btnULTIMO = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnINCLUIR = new javax.swing.JButton();
        btnALTERAR = new javax.swing.JButton();
        btnEXCLUIR = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnGRAVAR = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnSAIR = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblUSU_ID = new javax.swing.JLabel();
        lblUSU_NOME = new javax.swing.JLabel();
        lblUSU_LOGIN = new javax.swing.JLabel();
        edtVNC_ID = new javax.swing.JTextField();
        edtVNC_DATA = new javax.swing.JTextField();
        lblUSU_SENHA = new javax.swing.JLabel();
        lblUSU_SENHA1 = new javax.swing.JLabel();
        edtVNC_VACINA = new javax.swing.JComboBox<>();
        edtVNC_UNIS = new javax.swing.JComboBox<>();
        edtVNC_LOTE = new javax.swing.JComboBox<>();
        lblUSU_NOME1 = new javax.swing.JLabel();
        lblUSU_NOME2 = new javax.swing.JLabel();
        lblUSU_NOME3 = new javax.swing.JLabel();
        lblUSU_NOME4 = new javax.swing.JLabel();
        edtVNC_PAC = new javax.swing.JComboBox<>();
        edtVNC_FAB = new javax.swing.JComboBox<>();
        edtVNC_REG = new javax.swing.JComboBox<>();
        edtVNC_DOSE = new javax.swing.JComboBox<>();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblCONS_ID = new javax.swing.JLabel();
        edtCONS_ID1 = new javax.swing.JTextField();
        lblCodigo2 = new javax.swing.JLabel();
        edtCONS_ID2 = new javax.swing.JTextField();
        btnConsulta = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        lblCONS_NOME = new javax.swing.JLabel();
        edtCONS_PAC = new javax.swing.JTextField();
        lblCONS_LOGIN = new javax.swing.JLabel();
        edtCONS_DATA = new javax.swing.JTextField();
        lblCONS_NOME1 = new javax.swing.JLabel();
        lblCONS_LOGIN1 = new javax.swing.JLabel();
        edtCONS_DOSE = new javax.swing.JTextField();
        edtCONS_FAB = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblConsulta = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MVC - Cadastro de Usuários");
        setFocusable(false);
        getContentPane().setLayout(null);

        jToolBar1.setRollover(true);

        btnPRIMEIRO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/primeiro.png"))); // NOI18N
        btnPRIMEIRO.setText("Primeiro");
        btnPRIMEIRO.setFocusable(false);
        btnPRIMEIRO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPRIMEIRO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPRIMEIRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPRIMEIROActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPRIMEIRO);

        btnANTERIOR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/anterior.png"))); // NOI18N
        btnANTERIOR.setText("Anterior");
        btnANTERIOR.setFocusable(false);
        btnANTERIOR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnANTERIOR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnANTERIOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnANTERIORActionPerformed(evt);
            }
        });
        jToolBar1.add(btnANTERIOR);

        btnPROXIMO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/proximo.png"))); // NOI18N
        btnPROXIMO.setText("Próximo");
        btnPROXIMO.setFocusable(false);
        btnPROXIMO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPROXIMO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPROXIMO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPROXIMOActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPROXIMO);

        btnULTIMO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ultimo.png"))); // NOI18N
        btnULTIMO.setText("Último");
        btnULTIMO.setFocusable(false);
        btnULTIMO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnULTIMO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnULTIMO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnULTIMOActionPerformed(evt);
            }
        });
        jToolBar1.add(btnULTIMO);

        jSeparator1.setSeparatorSize(new java.awt.Dimension(30, 30));
        jToolBar1.add(jSeparator1);

        btnINCLUIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        btnINCLUIR.setText("Novo");
        btnINCLUIR.setFocusable(false);
        btnINCLUIR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnINCLUIR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnINCLUIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnINCLUIRActionPerformed(evt);
            }
        });
        jToolBar1.add(btnINCLUIR);

        btnALTERAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        btnALTERAR.setText("Alterar");
        btnALTERAR.setFocusable(false);
        btnALTERAR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnALTERAR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnALTERAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnALTERARActionPerformed(evt);
            }
        });
        jToolBar1.add(btnALTERAR);

        btnEXCLUIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        btnEXCLUIR.setText("Excluir");
        btnEXCLUIR.setFocusable(false);
        btnEXCLUIR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEXCLUIR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEXCLUIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEXCLUIRActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEXCLUIR);

        jSeparator2.setSeparatorSize(new java.awt.Dimension(30, 30));
        jToolBar1.add(jSeparator2);

        btnGRAVAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/gravar.png"))); // NOI18N
        btnGRAVAR.setText("Gravar");
        btnGRAVAR.setFocusable(false);
        btnGRAVAR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGRAVAR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGRAVAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGRAVARActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGRAVAR);

        jSeparator4.setSeparatorSize(new java.awt.Dimension(30, 30));
        jToolBar1.add(jSeparator4);

        btnSAIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sair.png"))); // NOI18N
        btnSAIR.setText("Sair");
        btnSAIR.setFocusable(false);
        btnSAIR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSAIR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSAIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSAIRActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSAIR);

        getContentPane().add(jToolBar1);
        jToolBar1.setBounds(0, 0, 730, 71);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setText("Cadastro de Vacinação com DAO/MVC/Hibernate");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(60, 80, 590, 29);

        lblUSU_ID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUSU_ID.setText("ID");

        lblUSU_NOME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUSU_NOME.setText("Nome da Vacina");

        lblUSU_LOGIN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUSU_LOGIN.setText("Data");

        edtVNC_ID.setEditable(false);
        edtVNC_ID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        edtVNC_DATA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblUSU_SENHA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUSU_SENHA.setText("Unidade");

        lblUSU_SENHA1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUSU_SENHA1.setText("Lote");

        edtVNC_VACINA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtVNC_VACINAActionPerformed(evt);
            }
        });

        edtVNC_UNIS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtVNC_UNISActionPerformed(evt);
            }
        });

        edtVNC_LOTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtVNC_LOTEActionPerformed(evt);
            }
        });

        lblUSU_NOME1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUSU_NOME1.setText("Paciente");

        lblUSU_NOME2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUSU_NOME2.setText("Fabricante");

        lblUSU_NOME3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUSU_NOME3.setText("Registro Profissional");

        lblUSU_NOME4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUSU_NOME4.setText("Dose");

        edtVNC_PAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtVNC_PACActionPerformed(evt);
            }
        });

        edtVNC_FAB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtVNC_FABActionPerformed(evt);
            }
        });

        edtVNC_REG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtVNC_REGActionPerformed(evt);
            }
        });

        edtVNC_DOSE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Primeira Dose", "Segunda Dose" }));
        edtVNC_DOSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtVNC_DOSEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblUSU_ID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtVNC_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblUSU_LOGIN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtVNC_DATA))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblUSU_SENHA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(edtVNC_UNIS, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblUSU_NOME)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtVNC_VACINA, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblUSU_SENHA1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(edtVNC_LOTE, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUSU_NOME1)
                            .addComponent(lblUSU_NOME2))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edtVNC_FAB, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtVNC_PAC, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUSU_NOME3)
                            .addComponent(lblUSU_NOME4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edtVNC_DOSE, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtVNC_REG, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtVNC_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUSU_ID)
                    .addComponent(lblUSU_LOGIN)
                    .addComponent(edtVNC_DATA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUSU_NOME1)
                    .addComponent(edtVNC_PAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUSU_NOME)
                    .addComponent(edtVNC_VACINA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUSU_NOME2)
                    .addComponent(edtVNC_FAB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUSU_SENHA)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edtVNC_UNIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblUSU_NOME3)
                        .addComponent(edtVNC_REG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edtVNC_LOTE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblUSU_NOME4))
                    .addComponent(lblUSU_SENHA1)
                    .addComponent(edtVNC_DOSE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados do Usuário", jPanel1);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 110, 710, 200);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCONS_ID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCONS_ID.setText("ID");

        edtCONS_ID1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblCodigo2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCodigo2.setText("à");

        edtCONS_ID2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnConsulta.setText("Consulta");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpa");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        lblCONS_NOME.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCONS_NOME.setText("Paciente");

        edtCONS_PAC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblCONS_LOGIN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCONS_LOGIN.setText("Data");

        edtCONS_DATA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblCONS_NOME1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCONS_NOME1.setText("Fabricante");

        lblCONS_LOGIN1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCONS_LOGIN1.setText("Dose");

        edtCONS_DOSE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        edtCONS_FAB.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCONS_NOME)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCONS_PAC, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCONS_NOME1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCONS_FAB, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblCONS_ID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtCONS_ID1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCodigo2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCONS_ID2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCONS_LOGIN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCONS_DATA, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCONS_LOGIN1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCONS_DOSE, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCONS_ID)
                    .addComponent(edtCONS_ID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo2)
                    .addComponent(edtCONS_ID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsulta)
                    .addComponent(edtCONS_DATA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCONS_LOGIN)
                    .addComponent(lblCONS_LOGIN1)
                    .addComponent(edtCONS_DOSE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtCONS_PAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCONS_NOME)
                    .addComponent(btnLimpar)
                    .addComponent(lblCONS_NOME1)
                    .addComponent(edtCONS_FAB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane2.setViewportView(tblConsulta);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Consulta", jPanel2);

        getContentPane().add(jTabbedPane2);
        jTabbedPane2.setBounds(10, 330, 720, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setPaciente(){
        PacienteDao paciente = new PacienteDao();
        
        edtVNC_PAC.addItem("Selecione...");
        
        ArrayList<PacienteModel> array = paciente.consultar("");
        
        for(PacienteModel obj : array){
            edtVNC_PAC.addItem(obj.getPAC_NOME());
        }
    }
    
    private void setFabricante(){
        FabricanteDao fabricante = new FabricanteDao();
        
        edtVNC_FAB.addItem("Selecione...");
        edtVNC_LOTE.addItem("Selecione...");
        edtVNC_VACINA.addItem("Selecione...");
        
        ArrayList<FabricanteModel> array = fabricante.consultar("");
        
        for(FabricanteModel obj : array){
            edtVNC_FAB.addItem(obj.getFAB_NOME_FABRICANTE());
            edtVNC_LOTE.addItem(String.valueOf(obj.getFAB_LOTE()));
            edtVNC_VACINA.addItem(obj.getFAB_NOME_VACINA());
        }
    }
    
    private void setUnidadeSaude(){
        UnidadeSaudeDao unidadeSaude = new UnidadeSaudeDao();
        
        edtVNC_UNIS.addItem("Selecione...");
        
        ArrayList<UnidadeSaudeModel> array = unidadeSaude.consultar("");
        
        for(UnidadeSaudeModel obj : array){
            edtVNC_UNIS.addItem(obj.getUNIS_NOME());
        }
    }
    
    private void setVacinadores(){
        VacinadoresDao vacinadores = new VacinadoresDao();
        
        edtVNC_REG.addItem("Selecione...");
        
        ArrayList<VacinadoresModel> array = vacinadores.consultar("");
        
        for(VacinadoresModel obj : array){
            edtVNC_REG.addItem(String.valueOf(obj.getVAC_REGISTRO_PROF()));
        }
    }
    
    private void btnPRIMEIROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPRIMEIROActionPerformed
        if (array.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não Existem Vacinações Cadastrados !");
        } else {
            int selecionado = 0;
            tblConsulta.changeSelection(selecionado, 0, false, false);
        }
    }//GEN-LAST:event_btnPRIMEIROActionPerformed

    private void btnINCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnINCLUIRActionPerformed
        limpar();
        setOperacao("incluir");
        edtVNC_VACINA.setFocusable(true);
    }//GEN-LAST:event_btnINCLUIRActionPerformed

    private void btnGRAVARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGRAVARActionPerformed
        String mensagem;
        if (JOptionPane.showConfirmDialog(null, "Confirma Gravação deste Usuário ?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            VacinacaoModel vacinacaoModel = new VacinacaoModel();
            vacinacaoModel.setVNC_ID(Integer.parseInt(edtVNC_ID.getText()));
            vacinacaoModel.setVNC_NOME(edtVNC_VACINA.getSelectedItem().toString());
            vacinacaoModel.setVNC_DATA_VACINA(edtVNC_DATA.getText());
            vacinacaoModel.setVNC_PACIENTE(edtVNC_PAC.getSelectedItem().toString());
            vacinacaoModel.setVNC_POSTO_SAUDE(edtVNC_UNIS.getSelectedItem().toString());
            vacinacaoModel.setVNC_LOTE(Integer.parseInt(edtVNC_LOTE.getSelectedItem().toString()));
            vacinacaoModel.setVNC_FABRICANTE(edtVNC_FAB.getSelectedItem().toString());
            vacinacaoModel.setVNC_REGISTRO_PROF(Integer.parseInt(edtVNC_REG.getSelectedItem().toString()));
            vacinacaoModel.setVNC_DOSE(edtVNC_DOSE.getSelectedItem().toString());

            try {
                vacinacaoController.gravar(vacinacaoModel, getOperacao());
                mensagem = "Dados Gravados com Sucesso";
            } catch (Exception ex) {
                mensagem = "Erro na Gravação da Vacinação \n" + ex.getMessage();
            }
            JOptionPane.showMessageDialog(null, mensagem);
            consultar();
        }
    }//GEN-LAST:event_btnGRAVARActionPerformed

    private void btnALTERARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnALTERARActionPerformed
        setOperacao("alterar");
    }//GEN-LAST:event_btnALTERARActionPerformed

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        consultar();
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void btnSAIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSAIRActionPerformed
        dispose();
    }//GEN-LAST:event_btnSAIRActionPerformed

    private void btnANTERIORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnANTERIORActionPerformed
        int selecionado = tblConsulta.getSelectedRow() - 1;
        if (selecionado >= 0) {
            tblConsulta.changeSelection(selecionado, 0, false, false);
        }
    }//GEN-LAST:event_btnANTERIORActionPerformed

    private void limpar() {
        edtVNC_ID.setText("0");
        edtVNC_VACINA.setSelectedItem(null);
        edtVNC_PAC.setSelectedItem(null);
        edtVNC_UNIS.setSelectedItem(null);
        edtVNC_LOTE.setSelectedItem(null);
        edtVNC_FAB.setSelectedItem(null);
        edtVNC_REG.setSelectedItem(null);
        edtVNC_DATA.setText("");
        edtVNC_DOSE.setSelectedItem(false);
    }

    private void mostrar(VacinacaoModel vacinacao) {
        edtVNC_ID.setText(String.valueOf(vacinacao.getVNC_ID()));
        edtVNC_VACINA.setSelectedItem(vacinacao.getVNC_NOME());
        edtVNC_UNIS.setSelectedItem(vacinacao.getVNC_POSTO_SAUDE());
        edtVNC_LOTE.setSelectedItem(String.valueOf(vacinacao.getVNC_LOTE()));
        edtVNC_FAB.setSelectedItem(vacinacao.getVNC_FABRICANTE());
        edtVNC_REG.setSelectedItem(String.valueOf(vacinacao.getVNC_REGISTRO_PROF()));
        edtVNC_DATA.setText(vacinacao.getVNC_DATA_VACINA());
        edtVNC_DOSE.setSelectedItem(vacinacao.getVNC_DOSE());
    }

    
    
    private String filtrar() {
        String condicao = "";
        if (!edtCONS_ID1.getText().trim().equals("")) {
            condicao += "(VNC_ID >= " + edtCONS_ID1.getText() + ")";
        }
        if (!edtCONS_ID2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(VNC_ID <= " + edtCONS_ID2.getText() + ")";
        }
        if (!edtCONS_PAC.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "( upper(VNC_PACIENTE) LIKE ('%" + edtCONS_PAC.getText().toUpperCase() + "%'))";
        }
        if (!edtCONS_DATA.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "( upper(VNC_DATA_VACINA) LIKE ('%" + edtCONS_DATA.getText().toUpperCase() + "%'))";
        }
        if (!edtCONS_DOSE.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "( upper(VNC_DOSE) LIKE ('%" + edtCONS_DOSE.getText().toUpperCase() + "%'))";
        }
        if (!edtCONS_FAB.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "( upper(VNC_FABRICANTE) LIKE ('%" + edtCONS_FAB.getText().toUpperCase() + "%'))";
        }
        if (!condicao.trim().equals("")) {
            condicao = " WHERE " + condicao;
        }
        return condicao;
    }

    private void consultar() {
        String condicao = filtrar();
        array = null;
        array = vacinacaoController.consultar(condicao);
        if (array.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não Existem Vacinações Cadastrados !");
        } else {
            mtb = new VacinacaoTableModel(array);
            tblConsulta.setModel(mtb);
            tblConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tblConsulta.changeSelection(0, 0, false, false);
            mostrar();
        }
    }

    private void mostrar() {
        int selecionado = tblConsulta.getSelectedRow();
        if (selecionado >= 0) {
            mostrar(array.get(selecionado));
        }
    }
    private void btnPROXIMOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPROXIMOActionPerformed
        int selecionado = tblConsulta.getSelectedRow() + 1;
        if (selecionado < array.size()) {
            tblConsulta.changeSelection(selecionado, 0, false, false);
        }
    }//GEN-LAST:event_btnPROXIMOActionPerformed

    private void btnULTIMOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnULTIMOActionPerformed
        int selecionado = array.size() - 1;
        tblConsulta.changeSelection(selecionado, 0, false, false);
    }//GEN-LAST:event_btnULTIMOActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        edtCONS_ID1.setText("");
        edtCONS_ID2.setText("");
        edtCONS_PAC.setText("");
        edtCONS_DATA.setText("");
        edtCONS_DOSE.setText("");
        edtCONS_FAB.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnEXCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEXCLUIRActionPerformed
        String mensagem;
        setOperacao("");
        if (JOptionPane.showConfirmDialog(null, "Confirma Exclusão desta Vacinação ?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            VacinacaoModel vacinacaoModel = new VacinacaoModel();
            vacinacaoModel.setVNC_ID(Integer.parseInt(edtVNC_ID.getText()));
            vacinacaoModel.setVNC_NOME(edtVNC_VACINA.getSelectedItem().toString());
            vacinacaoModel.setVNC_DATA_VACINA(edtVNC_DATA.getText());
            vacinacaoModel.setVNC_PACIENTE(edtVNC_PAC.getSelectedItem().toString());
            vacinacaoModel.setVNC_POSTO_SAUDE(edtVNC_UNIS.getSelectedItem().toString());
            vacinacaoModel.setVNC_LOTE(Integer.parseInt(edtVNC_LOTE.getSelectedItem().toString()));
            vacinacaoModel.setVNC_FABRICANTE(edtVNC_FAB.getSelectedItem().toString());
            vacinacaoModel.setVNC_REGISTRO_PROF(Integer.parseInt(edtVNC_REG.getSelectedItem().toString()));
            vacinacaoModel.setVNC_DOSE(edtVNC_DOSE.getSelectedItem().toString());

            try {
                vacinacaoController.excluir(vacinacaoModel);
                mensagem = "Vacinação Excluído com Sucesso";
            } catch (Exception ex) {
                mensagem = "Erro na Exclusão da Vacinação \n" + ex.getMessage();
            }
            JOptionPane.showMessageDialog(null, mensagem);
            consultar();
        }
    }//GEN-LAST:event_btnEXCLUIRActionPerformed

    private void edtVNC_VACINAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtVNC_VACINAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtVNC_VACINAActionPerformed

    private void edtVNC_UNISActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtVNC_UNISActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtVNC_UNISActionPerformed

    private void edtVNC_LOTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtVNC_LOTEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtVNC_LOTEActionPerformed

    private void edtVNC_PACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtVNC_PACActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtVNC_PACActionPerformed

    private void edtVNC_FABActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtVNC_FABActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtVNC_FABActionPerformed

    private void edtVNC_REGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtVNC_REGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtVNC_REGActionPerformed

    private void edtVNC_DOSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtVNC_DOSEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtVNC_DOSEActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnALTERAR;
    private javax.swing.JButton btnANTERIOR;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnEXCLUIR;
    private javax.swing.JButton btnGRAVAR;
    private javax.swing.JButton btnINCLUIR;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPRIMEIRO;
    private javax.swing.JButton btnPROXIMO;
    private javax.swing.JButton btnSAIR;
    private javax.swing.JButton btnULTIMO;
    private javax.swing.JTextField edtCONS_DATA;
    private javax.swing.JTextField edtCONS_DOSE;
    private javax.swing.JTextField edtCONS_FAB;
    private javax.swing.JTextField edtCONS_ID1;
    private javax.swing.JTextField edtCONS_ID2;
    private javax.swing.JTextField edtCONS_PAC;
    private javax.swing.JTextField edtVNC_DATA;
    private javax.swing.JComboBox<String> edtVNC_DOSE;
    private javax.swing.JComboBox<String> edtVNC_FAB;
    private javax.swing.JTextField edtVNC_ID;
    private javax.swing.JComboBox<String> edtVNC_LOTE;
    private javax.swing.JComboBox<String> edtVNC_PAC;
    private javax.swing.JComboBox<String> edtVNC_REG;
    private javax.swing.JComboBox<String> edtVNC_UNIS;
    private javax.swing.JComboBox<String> edtVNC_VACINA;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblCONS_ID;
    private javax.swing.JLabel lblCONS_LOGIN;
    private javax.swing.JLabel lblCONS_LOGIN1;
    private javax.swing.JLabel lblCONS_NOME;
    private javax.swing.JLabel lblCONS_NOME1;
    private javax.swing.JLabel lblCodigo2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUSU_ID;
    private javax.swing.JLabel lblUSU_LOGIN;
    private javax.swing.JLabel lblUSU_NOME;
    private javax.swing.JLabel lblUSU_NOME1;
    private javax.swing.JLabel lblUSU_NOME2;
    private javax.swing.JLabel lblUSU_NOME3;
    private javax.swing.JLabel lblUSU_NOME4;
    private javax.swing.JLabel lblUSU_SENHA;
    private javax.swing.JLabel lblUSU_SENHA1;
    private javax.swing.JTable tblConsulta;
    // End of variables declaration//GEN-END:variables
}
