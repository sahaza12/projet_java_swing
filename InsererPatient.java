package Corps;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Toolkit;

public class InsererPatient {

    JFrame frmInsertionPatient;
    private JTextField addressepatient;
    private JTextField poidspatient;
    private JTextField datenaissancepatient;
    private JTextField sexep;
    private JTextField nompatient;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InsererPatient window = new InsererPatient();
                    window.frmInsertionPatient.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    Connection con;

    public InsererPatient() {
        initialize();
        Connexion.Connect(); // Connexion à la base de données
        con = Connexion.con;
    }

    private void viderChamps() {
        addressepatient.setText("");
        nompatient.setText("");
        datenaissancepatient.setText("");
        sexep.setText("");
        poidspatient.setText("");
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmInsertionPatient = new JFrame();
        frmInsertionPatient.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\toky\\Pictures\\icone.png"));
        frmInsertionPatient.setTitle("INSERTION PATIENT");
        frmInsertionPatient.setBounds(100, 100, 828, 602);
        frmInsertionPatient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmInsertionPatient.getContentPane().setLayout(null);
        frmInsertionPatient.setResizable(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(10, 11, 802, 550);
        frmInsertionPatient.getContentPane().add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
        panel_1.setBounds(10, 11, 782, 60);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Saisissez tous les informations du patient ");
        lblNewLabel_1.setForeground(new Color(255, 0, 0));
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(30, 11, 506, 17);
        panel_1.add(lblNewLabel_1);

        JPanel panel_2 = new JPanel();
        panel_2.setToolTipText("");
        panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_2.setBounds(10, 82, 782, 450);
        panel.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nom Patient :");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel.setBounds(54, 33, 100, 18);
        panel_2.add(lblNewLabel);

        JLabel lblAddressePatient = new JLabel("Addresse Patient :");
        lblAddressePatient.setHorizontalAlignment(SwingConstants.CENTER);
        lblAddressePatient.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblAddressePatient.setBounds(54, 87, 124, 18);
        panel_2.add(lblAddressePatient);

        addressepatient = new JTextField();
        addressepatient.setHorizontalAlignment(SwingConstants.LEFT);
        addressepatient.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        addressepatient.setColumns(10);
        addressepatient.setBounds(188, 82, 400, 30);
        panel_2.add(addressepatient);

        JLabel lblNewLabel_1_1 = new JLabel("Poids Patient :");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_1_1.setBounds(54, 140, 100, 18);
        panel_2.add(lblNewLabel_1_1);

        poidspatient = new JTextField();
        poidspatient.setHorizontalAlignment(SwingConstants.LEFT);
        poidspatient.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        poidspatient.setColumns(10);
        poidspatient.setBounds(188, 135, 400, 30);
        panel_2.add(poidspatient);

        JLabel lblNewLabel_1_2_1 = new JLabel("Date de Naissance");
        lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_1_2_1.setBounds(54, 257, 124, 18);
        panel_2.add(lblNewLabel_1_2_1);

        datenaissancepatient = new JTextField();
        datenaissancepatient.setToolTipText("AAAA/MM/JJ");
        datenaissancepatient.setHorizontalAlignment(SwingConstants.LEFT);
        datenaissancepatient.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        datenaissancepatient.setColumns(10);
        datenaissancepatient.setBounds(188, 247, 400, 30);
        panel_2.add(datenaissancepatient);

        JLabel sexepatient = new JLabel("Sexe :");
        sexepatient.setHorizontalAlignment(SwingConstants.CENTER);
        sexepatient.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        sexepatient.setBounds(54, 300, 100, 18);
        panel_2.add(sexepatient);

        JButton btnNewButton = new JButton("ENREGISTRER");
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    String sql = "INSERT INTO public.patient(nom_p, dtns_p, sexe_p, poids_p, adresse_p) VALUES (?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?)";
                    PreparedStatement psd = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                    psd.setString(1, nompatient.getText());
                    psd.setString(2, datenaissancepatient.getText());
                    psd.setString(3, sexep.getText());
                    psd.setInt(4, Integer.parseInt(poidspatient.getText()));
                    psd.setString(5, addressepatient.getText());

                    int rows = psd.executeUpdate();

                    if (rows > 0) {
                        ResultSet rs = psd.getGeneratedKeys();
                        if (rs.next()) {
                            int id = rs.getInt(1);
                            JOptionPane.showMessageDialog(null, "Insertion terminée avec l'identifiant: " + id);
                        }
                        viderChamps();
                    } else {
                        JOptionPane.showMessageDialog(null, "Échec de l'insertion", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }

                    psd.close();
                } catch (Exception e2) {
                    System.out.println(e2);
                }
            }
        });
        btnNewButton.setBackground(SystemColor.textHighlight);
        btnNewButton.setBounds(201, 367, 150, 30);
        panel_2.add(btnNewButton);

        sexep = new JTextField();
        sexep.setBounds(188, 300, 86, 20);
        panel_2.add(sexep);
        sexep.setColumns(10);

        JButton btnRetour = new JButton("Retour");
        btnRetour.setBounds(20, 400, 100, 30);
        panel_2.add(btnRetour);

        nompatient = new JTextField();
        nompatient.setHorizontalAlignment(SwingConstants.LEFT);
        nompatient.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        nompatient.setColumns(10);
        nompatient.setBounds(188, 33, 400, 30);
        panel_2.add(nompatient);
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnRetour) {
                    Acceuil newWindow = new Acceuil();
                    newWindow.frmMedocab.setVisible(true);
                    frmInsertionPatient.dispose();
                }
            }
        });
    }
}
