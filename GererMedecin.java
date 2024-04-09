package Corps;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GererMedecin {

	JFrame frmgereMedecin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GererMedecin window = new GererMedecin();
					window.frmgereMedecin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public GererMedecin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmgereMedecin = new JFrame();
		frmgereMedecin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frmgereMedecin.setTitle("GERE MEDECIN");
		frmgereMedecin.getContentPane().setBackground(Color.WHITE);
		frmgereMedecin.getContentPane().setLayout(null);
		frmgereMedecin.setResizable(true);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.textHighlight));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 11, 769, 48);
		frmgereMedecin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel medacceuil = new JLabel("Acceuil");
		medacceuil.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		medacceuil.setHorizontalAlignment(SwingConstants.CENTER);
		medacceuil.setBounds(0, 11, 92, 14);
		panel.add(medacceuil);
		
		JLabel medContact = new JLabel("Contacter-nous");
		medContact.setHorizontalAlignment(SwingConstants.LEFT);
		medContact.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		medContact.setBounds(107, 11, 122, 14);
		panel.add(medContact);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(10, 91, 769, 289);
		frmgereMedecin.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(10, 11, 749, 238);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton inserermedecin = new JButton("INSERER MEDECIN");
		inserermedecin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				InsererMedecin window = new InsererMedecin();
				window.frameInsertMedecin.setVisible(true);
                
				frmgereMedecin.dispose(); 
				
			}
		});
		inserermedecin.setForeground(new Color(255, 0, 0));
		inserermedecin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		inserermedecin.setBounds(54, 28, 420, 56);
		panel_2.add(inserermedecin);
		
		JButton supprimermedecin = new JButton("SUPPRIMER MEDECIN");
		supprimermedecin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				SupprMedecin window = new SupprMedecin();
                window.framesuppmed.setVisible(true);
                
                frmgereMedecin.dispose ();
			}
		});
		
		supprimermedecin.setForeground(Color.RED);
		supprimermedecin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		supprimermedecin.setBounds(54, 95, 420, 56);
		panel_2.add(supprimermedecin);
		
		JButton btnmodifiermedecin = new JButton("MODIFIER MEDECIN");
		btnmodifiermedecin.setForeground(Color.RED);
		btnmodifiermedecin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnmodifiermedecin.setBounds(54, 162, 420, 56);
		panel_2.add(btnmodifiermedecin);
		frmgereMedecin.setBackground(Color.GREEN);
		frmgereMedecin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\toky\\Pictures\\icone.png"));
		frmgereMedecin.setBounds(100, 100, 805, 454);
		frmgereMedecin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
