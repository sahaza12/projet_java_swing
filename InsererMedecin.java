package Corps;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import javax.swing.JTextField;
import javax.swing.JButton;

public class InsererMedecin {

    JFrame frameInsertMedecin;
    private JTextField NomMedecin;
    private JTextField specialite;
    private JTextField AdressMedecin;
    private JTextField Numtelephone;
    private JTextField heureconsultation;
    private JTextField NumOrdonance;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InsererMedecin window = new InsererMedecin();
                    window.frameInsertMedecin.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InsererMedecin() {
        initialize();
        Connexion.Connect(); // Connexion à la base de données
    }

    Connection con;

    private void viderChamps() {
        NomMedecin.setText("");
        specialite.setText("");
        AdressMedecin.setText("");
        Numtelephone.setText("");
        heureconsultation.setText("");
        String.valueOf(NumOrdonance);
    }

    private void initialize() {
        frameInsertMedecin = new JFrame();
        frameInsertMedecin.getContentPane().setBackground(new Color(144, 238, 144));
        frameInsertMedecin.setBounds(100, 100, 829, 600);
        frameInsertMedecin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameInsertMedecin.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBounds(10, 11, 793, 42);
        frameInsertMedecin.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Inserer tous les elements du medecin ");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(74, 11, 289, 14);
        panel.add(lblNewLabel_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 128, 0)));
        panel_1.setBounds(10, 64, 793, 450);
        frameInsertMedecin.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nom Medecin :");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel.setBounds(35, 23, 130, 14);
        panel_1.add(lblNewLabel);

        NomMedecin = new JTextField();
        NomMedecin.setBounds(169, 21, 400, 25);
        panel_1.add(NomMedecin);
        NomMedecin.setColumns(10);

        JLabel lblSpcialit = new JLabel("Spécialité :");
        lblSpcialit.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblSpcialit.setBounds(35, 70, 130, 14);
        panel_1.add(lblSpcialit);

        specialite = new JTextField();
        specialite.setColumns(10);
        specialite.setBounds(169, 68, 400, 25);
        panel_1.add(specialite);

        JButton Enregistrer = new JButton("Enregistrer");
        Enregistrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String nomMedecin = NomMedecin.getText();
                    String specialiteMedecin = specialite.getText();
                    String adresseMedecin = AdressMedecin.getText();
                    String numeroTelephone = Numtelephone.getText();

                    String horaireConsultationStr = heureconsultation.getText();
                    
                    Time horaireConsultation = Time.valueOf(horaireConsultationStr);
                    
                    int numeroOrdonance = Integer.parseInt(NumOrdonance.getText());

                    String query = "INSERT INTO public.medecin(nom_m, specialite_m, adresse_m, numtel_m, horraire_consultation, numero_ordonance) " +
                                    "VALUES (?, ?, ?, ?, ?, ?)";

                    PreparedStatement pst = Connexion.con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

                    pst.setString(1, nomMedecin);
                    pst.setString(2, specialiteMedecin);
                    pst.setString(3, adresseMedecin);
                    pst.setString(4, numeroTelephone);
                    
                    pst.setTime(5, horaireConsultation);
                    
                    pst.setInt(6, numeroOrdonance);

                    int rows = pst.executeUpdate();

                    if (rows > 0) {
                        ResultSet rs = pst.getGeneratedKeys();
                        if (rs.next()) {
                            int id = rs.getInt(1);
                            JOptionPane.showMessageDialog(null, "Insertion terminée avec l'identifiant: " + id);
                        }
                        viderChamps();
                    }

                    pst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frameInsertMedecin, "Erreur lors de l'enregistrement du médecin.", "Erreur", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frameInsertMedecin, "Erreur de format pour le numéro d'ordonnance.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        Enregistrer.setBackground(new Color(0, 255, 127));
        Enregistrer.setForeground(new Color(255, 0, 0));
        Enregistrer.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        Enregistrer.setBounds(254, 396, 120, 30);
        panel_1.add(Enregistrer);
        

        JButton btnRetour = new JButton("Retour");
        btnRetour.setBounds(20,390, 100, 30); // Adjust position for better placement
        panel_1.add(btnRetour);
        
        JLabel lblAdresseMedecin = new JLabel("Adresse Medecin :");
        lblAdresseMedecin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblAdresseMedecin.setBounds(35, 129, 130, 14);
        panel_1.add(lblAdresseMedecin);
        
        AdressMedecin = new JTextField();
        AdressMedecin.setColumns(10);
        AdressMedecin.setBounds(169, 127, 400, 25);
        panel_1.add(AdressMedecin);
        
        JLabel lblNumroTelephone = new JLabel("Numéro telephone");
        lblNumroTelephone.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNumroTelephone.setBounds(35, 177, 130, 14);
        panel_1.add(lblNumroTelephone);
        
        Numtelephone = new JTextField();
        Numtelephone.setColumns(10);
        Numtelephone.setBounds(169, 175, 400, 25);
        panel_1.add(Numtelephone);
        
        JLabel lblHorraireConsultation = new JLabel("Horraire Consultation :");
        lblHorraireConsultation.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblHorraireConsultation.setBounds(35, 232, 130, 14);
        panel_1.add(lblHorraireConsultation);
        
        heureconsultation = new JTextField();
        heureconsultation.setColumns(10);
        heureconsultation.setBounds(169, 230, 400, 25);
        panel_1.add(heureconsultation);
        
        JLabel lblNumeroOrdonance = new JLabel("Numero Ordonance ");
        lblNumeroOrdonance.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNumeroOrdonance.setBounds(35, 292, 130, 14);
        panel_1.add(lblNumeroOrdonance);
        
        NumOrdonance = new JTextField();
        NumOrdonance.setColumns(10);
        NumOrdonance.setBounds(169, 290, 400, 25);
        panel_1.add(NumOrdonance);
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnRetour) {
     
                    Acceuil newWindow = new Acceuil();
                    newWindow.frmMedocab.setVisible(true);
                    
                    frameInsertMedecin.dispose(); 
                }
            }
        });
        
        
    }
}
