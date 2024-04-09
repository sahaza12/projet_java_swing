package Corps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Ordonances {

    JFrame frmordo;
    private JList<String> list;
    private JList<String> list_1;
    private JList<String> list_2;
    private DefaultListModel<String> model;
    private DefaultListModel<String> model_1;
    private DefaultListModel<String> model_2;
    private JList<String> listForme;
    private JList<String> listDosage;
    private JList<String> listForme1;
    private JList<String> listDosage1;
    private DefaultListModel<String> modelForme;
    private DefaultListModel<String> modelDosage;
    private DefaultListModel<String> modelForme1;
    private DefaultListModel<String> modelDosage1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ordonances window = new Ordonances();
                    window.frmordo.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Ordonances() {
        initialize();
        Connexion.Connect();
        testRequete();
    }

    private void initialize() {
        frmordo = new JFrame();
        frmordo.getContentPane().setBackground(Color.LIGHT_GRAY);
        frmordo.setBounds(100, 100, 831, 519);
        frmordo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmordo.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 795, 35);
        frmordo.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Choisissez les detailes du Consultation");
        lblNewLabel_2.setForeground(new Color(0, 0, 255));
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(43, 11, 384, 14);
        panel.add(lblNewLabel_2);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(8, 60, 795, 385);
        frmordo.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nom Patient");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel.setBounds(37, 21, 100, 14);
        panel_1.add(lblNewLabel);

        model_1 = new DefaultListModel<>();
        list_1 = new JList<>(model_1);
        list_1.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane1 = new JScrollPane(list_1);
        scrollPane1.setBounds(130, 54, 200, 30);
        panel_1.add(scrollPane1);

        JLabel lblNewLabel_4 = new JLabel("Forme");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_4.setBounds(370, 115, 46, 14);
        panel_1.add(lblNewLabel_4);

        modelForme = new DefaultListModel<>();
        listForme = new JList<>(modelForme);
        listForme.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPaneForme = new JScrollPane(listForme);
        scrollPaneForme.setBounds(444, 107, 130, 30);
        panel_1.add(scrollPaneForme);

        JLabel lblNewLabel_5 = new JLabel("Dosage");
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_5.setBounds(600, 107, 50, 25);
        panel_1.add(lblNewLabel_5);

        modelDosage = new DefaultListModel<>();
        listDosage = new JList<>(modelDosage);
        listDosage.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPaneDosage = new JScrollPane(listDosage);
        scrollPaneDosage.setBounds(650, 107, 130, 30);
        panel_1.add(scrollPaneDosage);

        JLabel lblNewLabel_41 = new JLabel("Forme");
        lblNewLabel_41.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_41.setBounds(370, 65, 46, 14);
        panel_1.add(lblNewLabel_41);

        modelForme1 = new DefaultListModel<>();
        listForme1 = new JList<>(modelForme1);
        listForme1.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPaneFormes = new JScrollPane(listForme1);
        scrollPaneFormes.setBounds(444, 65, 130, 30);
        panel_1.add(scrollPaneFormes);

        JLabel lblNewLabel_51 = new JLabel("Dosage");
        lblNewLabel_51.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_51.setBounds(600, 65, 50, 25);
        panel_1.add(lblNewLabel_51);

        modelDosage1 = new DefaultListModel<>();
        listDosage1 = new JList<>(modelDosage1);
        listDosage1.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPaneDosages = new JScrollPane(listDosage1);
        scrollPaneDosages.setBounds(650, 65, 130, 30);
        panel_1.add(scrollPaneDosages);

        JLabel lblMedicament = new JLabel("Médicament");
        lblMedicament.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblMedicament.setBounds(37, 61, 100, 14);
        panel_1.add(lblMedicament);

        model_2 = new DefaultListModel<>();
        list_2 = new JList<>(model_2);
        list_2.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane2 = new JScrollPane(list_2);
        scrollPane2.setBounds(130, 104, 200, 30);
        panel_1.add(scrollPane2);

        JLabel lblMedicament_1 = new JLabel("Médicament");
        lblMedicament_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblMedicament_1.setBounds(37, 114, 100, 14);
        panel_1.add(lblMedicament_1);

        JButton btnNewButton = new JButton("Enregistrer");
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnNewButton.setBounds(237, 278, 150, 30);
        panel_1.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Récupérer les éléments sélectionnés dans les JList
                    String patient = (list.getSelectedValue() != null) ? list.getSelectedValue().toString() : "";
                    String medicament1 = (list_1.getSelectedValue() != null) ? list_1.getSelectedValue().toString() : "";
                    String forme1 = (listForme.getSelectedValue() != null) ? listForme.getSelectedValue().toString() : "";
                    String dosage1 = (listDosage.getSelectedValue() != null) ? listDosage.getSelectedValue().toString() : "";

                    String medicament2 = (list_2.getSelectedValue() != null) ? list_2.getSelectedValue().toString() : "";
                    String forme2 = (listForme1.getSelectedValue() != null) ? listForme1.getSelectedValue().toString() : "";

                    String dosage2 = (listDosage1.getSelectedValue() != null) ? listDosage1.getSelectedValue().toString() : "";

                    // Créer une nouvelle instance de la fenêtre "Consulter" et l'afficher
                    String[] elements = {patient, medicament1, medicament2, forme1, forme2, dosage1, dosage2};
                    ConsulterFrame consulterFrame = new ConsulterFrame(elements);
                    consulterFrame.setVisible(true);
                } catch (NullPointerException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frmordo, "Veuillez sélectionner les valeurs pour tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        model = new DefaultListModel<>();
        list = new JList<>(model);
        list.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(130, 14, 200, 30);
        scrollPane.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        panel_1.add(scrollPane);
        
        JButton btnRetour = new JButton("Retour");
        btnRetour.setBounds(50, 330, 150, 30); // Adjust position for better placement
        panel_1.add(btnRetour);
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnRetour) {
                    Acceuil newWindow = new Acceuil();
                    newWindow.frmMedocab.setVisible(true);
                    frmordo.dispose(); 
                }
            }
        });
    }

    private void testRequete() {
        try {
            String selectionMedicament = "SELECT nom_med FROM public.medicament";
            String selectionPatient = "SELECT nom_p FROM public.patient";
            String selectionForm = "SELECT  forme_med FROM public.medicament";
            String selectionDosage = "SELECT dose_med FROM public.medicament";

            Statement statement = Connexion.con.createStatement();
            ResultSet resultSetMedicament = statement.executeQuery(selectionMedicament);

            model.clear();
            model_1.clear();
            model_2.clear();

            while (resultSetMedicament.next()) {
                String nomMedicament = resultSetMedicament.getString("nom_med");
                model_1.addElement(nomMedicament);
                model_2.addElement(nomMedicament);
            }

            ResultSet resultSetPatient = statement.executeQuery(selectionPatient);

            while (resultSetPatient.next()) {
                String nomPatient = resultSetPatient.getString("nom_p");
                model.addElement(nomPatient);
            }

            modelForme.clear();
            modelForme1.clear();
            ResultSet resultSetFrom = statement.executeQuery(selectionForm);

            while (resultSetFrom.next()) {
                String formed = resultSetFrom.getString("forme_med");
                modelForme.addElement(formed);
                modelForme1.addElement(formed);

            }

            modelDosage.clear();
            modelDosage1.clear();
            ResultSet resultSetDosage = statement.executeQuery(selectionDosage);

            while (resultSetDosage.next()) {
                String dosage = resultSetDosage.getString("dose_med");
                modelDosage.addElement(dosage);
                modelDosage1.addElement(dosage);

            }

            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frmordo, "Erreur lors de la récupération des données.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
