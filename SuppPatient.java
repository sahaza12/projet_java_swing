package Corps;

import java.awt.EventQueue;
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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

public class SuppPatient {

    JFrame framesuppPatient;
    private JTextArea nomsuppmed;
    private Connection con;
    private JComboBox<String> comboBox;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SuppPatient window = new SuppPatient();
                    window.framesuppPatient.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SuppPatient() {
        initialize();
        Connexion.Connect();
        con = Connexion.con; // Récupérer la connexion établie par Connexion.Connect()
        loadPatients();
    }

    private void initialize() {
        framesuppPatient = new JFrame();
        framesuppPatient.setTitle("Supprimer Patient");
        framesuppPatient.getContentPane().setBackground(new Color(0, 255, 255));
        framesuppPatient.setBounds(100, 100, 810, 438);
        framesuppPatient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framesuppPatient.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(32, 178, 170));
        panel.setBorder(new LineBorder(new Color(0, 0, 255)));
        panel.setBounds(10, 11, 774, 32);
        framesuppPatient.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Completez les informations");
        lblNewLabel.setForeground(new Color(255, 0, 0));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 0, 725, 25);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(255, 0, 0)));
        panel_1.setBounds(10, 54, 774, 275);
        framesuppPatient.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Saisissez le nom du patient à supprimer");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(85, 62, 300, 32);
        panel_1.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Supprimer");

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedPatient = comboBox.getSelectedItem().toString();

                    String deleteQuery = "DELETE FROM public.patient WHERE nom_p=?";
                    PreparedStatement pstDelete = con.prepareStatement(deleteQuery);
                    pstDelete.setString(1, selectedPatient);
                    int rowsDeleted = pstDelete.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println("Patient supprimé avec succès.");
                        JOptionPane.showMessageDialog(null, "Suppression terminée : ");
                    } else {
                        System.out.println("Échec de la suppression du Patient.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnNewButton.setBackground(new Color(192, 192, 192));
        btnNewButton.setForeground(new Color(255, 0, 0));
        btnNewButton.setBounds(302, 188, 130, 30);
        panel_1.add(btnNewButton);

        JButton btnRetour = new JButton("Retour");
        btnRetour.setBounds(50, 200, 150, 30); // Adjust position for better placement
        panel_1.add(btnRetour);

        comboBox = new JComboBox<String>();
        comboBox.setBounds(76, 101, 570, 32);
        panel_1.add(comboBox);
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnRetour) {
                    Acceuil newWindow = new Acceuil();
                    newWindow.frmMedocab.setVisible(true);
                    framesuppPatient.dispose();
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
                comboBox.addItem(nomPatient);
            }
            statementPatients.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
