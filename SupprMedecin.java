package Corps;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;

public class SupprMedecin {

    JFrame framesuppmed;
    private JComboBox<String> ComboBox;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SupprMedecin window = new SupprMedecin();
                    window.framesuppmed.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SupprMedecin() {
        initialize();
        Connexion.Connect(); // Appel de la méthode Connect() de la classe Connexion
        loadMedecins();
    }

    private void initialize() {
        framesuppmed = new JFrame();
        framesuppmed.setTitle("Supprimer Medecin");
        framesuppmed.getContentPane().setBackground(new Color(0, 255, 255));
        framesuppmed.setBounds(100, 100, 810, 438);
        framesuppmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framesuppmed.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(32, 178, 170));
        panel.setBorder(new LineBorder(new Color(0, 0, 255)));
        panel.setBounds(10, 11, 774, 32);
        framesuppmed.getContentPane().add(panel);
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
        framesuppmed.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Saisissez le nom du Médecin");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(76, 62, 192, 32);
        panel_1.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Supprimer");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                    try {
                        
                    		
                            // Le médecin existe, supprimer
                            String deleteQuery = "DELETE FROM public.medecin WHERE nom_m=?";
                            
                            String selectedMedecin = ComboBox.getSelectedItem().toString();

                            PreparedStatement pstDelete = Connexion.con.prepareStatement(deleteQuery);
                            pstDelete.setString(1, selectedMedecin);
                            int rowsDeleted = pstDelete.executeUpdate();
                            if (rowsDeleted > 0) {
                                System.out.println("Médecin supprimé avec succès.");
                            } else {
                                System.out.println("Échec de la suppression du médecin.");
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
        
        
      
        
         ComboBox = new JComboBox<String>();
        ComboBox.setBounds(113, 105, 397, 49);
        panel_1.add(ComboBox);
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnRetour) {

                    Acceuil newWindow = new Acceuil();
                    newWindow.frmMedocab.setVisible(true);

                    framesuppmed.dispose();
                }
            }
        });

    }
    private void loadMedecins() {
        try {
            String queryMedecins = "SELECT nom_m FROM public.medecin";
            Statement statementMedecins = Connexion.con.createStatement();
            ResultSet resultSetMedecins = statementMedecins.executeQuery(queryMedecins);
            while (resultSetMedecins.next()) {
                String nomMedecin = resultSetMedecins.getString("nom_m");
                ComboBox.addItem(nomMedecin);
            }
            statementMedecins.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
