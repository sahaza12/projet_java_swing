package Corps;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Acceuil {

	 JFrame frmMedocab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil window = new Acceuil();
					window.frmMedocab.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Acceuil() {
		initialize();
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMedocab = new JFrame();
		frmMedocab.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\toky\\Pictures\\icone.png"));
		frmMedocab.setFont(new Font("Times New Roman", Font.BOLD, 26));
		frmMedocab.setTitle("MEDOCAB");
		frmMedocab.setResizable(true);
		frmMedocab.setBounds(100, 100, 773, 481);
		frmMedocab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMedocab.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.CYAN));
		panel.setBounds(10, 74, 708, 66);
		frmMedocab.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTION DU CABINET ");
		lblNewLabel.setBounds(10, 11, 664, 44);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		panel_1.setBounds(10, 11, 708, 35);
		frmMedocab.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel acceuil = new JLabel("Acceuil");
		acceuil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmMedocab.setVisible(true);

				
			}
		});
		acceuil.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		acceuil.setHorizontalAlignment(SwingConstants.CENTER);
		acceuil.setBounds(10, 11, 92, 14);
		panel_1.add(acceuil);
		
		JLabel contacternous = new JLabel("Contactez-nous");
		contacternous.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contacternous.setHorizontalAlignment(SwingConstants.CENTER);
		contacternous.setBounds(115, 10, 126, 16);
		panel_1.add(contacternous);
		
		JLabel identifier = new JLabel("Identifier");
		identifier.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		identifier.setHorizontalAlignment(SwingConstants.CENTER);
		identifier.setBounds(583, 11, 92, 16);
		panel_1.add(identifier);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		panel_2.setBounds(183, 179, 535, 185);
		frmMedocab.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		
		GererPatient newWindow = new GererPatient();
		JButton gererPatient = new JButton("GERER \r\nPATIENT");
		gererPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				newWindow.frmGererPatient.setVisible(true);
				frmMedocab.dispose();
				
			}
			
		});
		
		gererPatient.setBackground(new Color(128, 128, 128));
		gererPatient.setFont(new Font("Times New Roman", Font.BOLD, 17));
		gererPatient.setForeground(new Color(0, 128, 0));
		gererPatient.setBounds(52, 29, 186, 119);
		panel_2.add(gererPatient);
		
		GererMedecin fenetre = new GererMedecin();
		JButton gererMedecin = new JButton("GERER \r\nMEDECIN");
		gererMedecin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				fenetre.frmgereMedecin.setVisible(true);
				frmMedocab.dispose();
				
			}
		});
		gererMedecin.setForeground(new Color(0, 128, 0));
		gererMedecin.setFont(new Font("Times New Roman", Font.BOLD, 17));
		gererMedecin.setBackground(Color.GRAY);
		gererMedecin.setBounds(310, 29, 186, 119);
		panel_2.add(gererMedecin);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 255)));
		panel_3.setBackground(SystemColor.inactiveCaption);
		panel_3.setBounds(10, 179, 163, 185);
		frmMedocab.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		Consultation consul = new Consultation ();
		JButton btnNewButton = new JButton("CONSULTATION");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				consul.frmConsultation.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 27, 143, 118);
		panel_3.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(20, 375, 10, 10);
		frmMedocab.getContentPane().add(panel_4);
	}

		
	
}
