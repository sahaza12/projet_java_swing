package Corps;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class Consultation {

    JFrame frmConsultation;
    private JTextField dateconsultation;
    private JTextField resultatexamen;
    private JComboBox<String> patientComboBox;
    private JComboBox<String> medecinComboBox;

    Connection con;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Consultation window = new Consultation();
                    window.frmConsultation.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Consultation() {
        Connexion.Connect();
        con = Connexion.con;
        initialize();
        loadPatients();
        loadMedecins();
    }

    private void initialize() {
        frmConsultation = new JFrame();
        frmConsultation.setBounds(100, 100, 828, 602);
        frmConsultation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmConsultation.getContentPane().setLayout(null);
        frmConsultation.setResizable(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(10, 11, 802, 550);
        frmConsultation.getContentPane().add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
        panel_1.setBounds(10, 11, 782, 60);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_3 = new JLabel("Veillez inserer tous les elements concernant la Consultation");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(24, 11, 410, 38);
        panel_1.add(lblNewLabel_3);

        JPanel panel_2 = new JPanel();
        panel_2.setToolTipText("");
        panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_2.setBounds(10, 82, 782, 450);
        panel.add(panel_2);
        panel_2.setLayout(null);

        JLabel dateconsult = new JLabel("Date Consultation  :");
        dateconsult.setHorizontalAlignment(SwingConstants.CENTER);
        dateconsult.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        dateconsult.setBounds(54, 87, 124, 18);
        panel_2.add(dateconsult);

        JButton btnNewButton = new JButton("ENREGISTRER");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String sql = "INSERT INTO public.consultation(nom_p, date_c, resultat_examen, nom_m) VALUES (?, ?, ?, ?)";
                    PreparedStatement psd = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                    String selectedPatient = patientComboBox.getSelectedItem().toString();
                    String selectedMedecin = medecinComboBox.getSelectedItem().toString();

                    psd.setString(1, selectedPatient);
                    psd.setString(2, dateconsultation.getText());
                    psd.setString(3, resultatexamen.getText());
                    psd.setString(4, selectedMedecin);

                    int rowsInserted = psd.executeUpdate();

                    if (rowsInserted > 0) {
                        ResultSet rs = psd.getGeneratedKeys();
                        if (rs.next()) {
                            int id = rs.getInt(1);
                            JOptionPane.showMessageDialog(null, "Insertion terminée avec l'identifiant: " + id);
                        }
                        viderChamps();
                        Ordonances newWindow = new Ordonances();
                        newWindow.frmordo.setVisible(true);
                        frmConsultation.dispose();
                    }

                    psd.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("Erreur de connexion");
                }
            }
        });
        btnNewButton.setBackground(SystemColor.textHighlight);
        btnNewButton.setBounds(201, 367, 150, 30);
        panel_2.add(btnNewButton);

        patientComboBox = new JComboBox<String>();
        patientComboBox.setBounds(220, 31, 400, 30);
        panel_2.add(patientComboBox);

        medecinComboBox = new JComboBox<String>();
        medecinComboBox.setBounds(220, 191, 400, 38);
        panel_2.add(medecinComboBox);

        dateconsultation = new JTextField();
        dateconsultation.setColumns(10);
        dateconsultation.setBounds(220, 80, 400, 30);
        panel_2.add(dateconsultation);

        JLabel lblNewLabel_1 = new JLabel("Resultat Examen :\r\n");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(66, 146, 109, 30);
        panel_2.add(lblNewLabel_1);

        resultatexamen = new JTextField();
        resultatexamen.setBounds(220, 135, 400, 30);
        panel_2.add(resultatexamen);
        resultatexamen.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Nom Medecin :");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(66, 199, 100, 30);
        panel_2.add(lblNewLabel_2);

        JButton btnRetour = new JButton("Retour");
        btnRetour.setBounds(20, 400, 100, 30);
        panel_2.add(btnRetour);

        JLabel lblNomPatient = new JLabel("Nom Patient :");
        lblNomPatient.setHorizontalAlignment(SwingConstants.CENTER);
        lblNomPatient.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNomPatient.setBounds(54, 39, 124, 18);
        panel_2.add(lblNomPatient);
        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnRetour) {
                    Acceuil newWindow = new Acceuil();
                    newWindow.frmMedocab.setVisible(true);
                    frmConsultation.dispose();
                }
            }
        });
    }

    private void loadPatients() {
        try {
            String queryPatients = "SELECT nom_p FROM public.patient";
            Statement statementPatients = con.createStatement();
            ResultSet resultSetPatients = statementPatients.executeQuery(queryPatients);
            while (resultSetPatients.next()) {
                String nomPatient = resultSetPatients.getString("nom_p");
                patientComboBox.addItem(nomPatient);
            }
            statementPatients.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void loadMedecins() {
        try {
            String queryMedecins = "SELECT nom_m FROM public.medecin";
            Statement statementMedecins = con.createStatement();
            ResultSet resultSetMedecins = statementMedecins.executeQuery(queryMedecins);
            while (resultSetMedecins.next()) {
                String nomMedecin = resultSetMedecins.getString("nom_m");
                medecinComboBox.addItem(nomMedecin);
            }
            statementMedecins.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void viderChamps() {
        patientComboBox.setSelectedIndex(-1);
        dateconsultation.setText("");
        resultatexamen.setText("");
        medecinComboBox.setSelectedIndex(-1);
    }
}
