package Corps;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.postgresql.Driver;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;

public class Ordonnance {

    private JFrame frmordonance;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ordonnance window = new Ordonnance();
                    window.frmordonance.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Ordonnance() {
        initialize();
        Connect();
        loadPatientsAndMedicaments();
    }

    Connection con;

    public void Connect() {
        try {
            Class.forName("org.postgresql.Driver");
            Driver pilote = (Driver) Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            DriverManager.registerDriver(pilote);
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Original", "postgres",
                    "nomenjanahary");
            if (con != null) {
                System.out.println("Connecté ");
            } else {
                System.out.println("Non connecté");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void loadPatientsAndMedicaments() {
        try {
            // Charger les noms des patients dans le JComboBox comboBox_1
            String queryPatients = "SELECT nom_p FROM public.patients";
            Statement statementPatients = con.createStatement();
            ResultSet resultSetPatients = statementPatients.executeQuery(queryPatients);
            while (resultSetPatients.next()) {
                String nomPatient = resultSetPatients.getString("nom_patient");
                comboBox_1.addItem(nomPatient);
            }
            statementPatients.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private JComboBox<String> comboBox_1;
    

    private void initialize() {
        frmordonance = new JFrame();
        frmordonance.getContentPane().setBackground(Color.LIGHT_GRAY);
        frmordonance.setBounds(100, 100, 831, 519);
        frmordonance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmordonance.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 795, 35);
        frmordonance.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Choisissez les détails de la Consultation");
        lblNewLabel_2.setForeground(new Color(0, 0, 255));
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(43, 11, 384, 14);
        panel.add(lblNewLabel_2);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(8, 60, 795, 385);
        frmordonance.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nom Patient");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel.setBounds(37, 21, 100, 14);
        panel_1.add(lblNewLabel);

       
       

        JButton btnNewButton = new JButton("Enregistrer");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		loadPatientsAndMedicaments();
        		
        	}
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnNewButton.setBounds(237, 278, 150, 30);
        panel_1.add(btnNewButton);

        comboBox_1 = new JComboBox<String>();
        comboBox_1.setBounds(130, 14, 288, 30);
        panel_1.add(comboBox_1);

      
    }
}
