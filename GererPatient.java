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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GererPatient {

	JFrame frmGererPatient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GererPatient window = new GererPatient();
					window.frmGererPatient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GererPatient() {
		initialize();
		//frmMedocab = (JFrame) SwingUtilities.getWindowAncestor(gerePatient.this);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGererPatient = new JFrame();
		frmGererPatient.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frmGererPatient.setTitle("GERER PATIENT");
		frmGererPatient.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\toky\\Pictures\\icone.png"));
		frmGererPatient.setBounds(100, 100, 777, 410);
		frmGererPatient.setResizable(true);
		frmGererPatient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGererPatient.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(127, 255, 212)));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 741, 46);
		frmGererPatient.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Voir ici toutes les information du patient");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(33, 11, 344, 24);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 64, 741, 296);
		frmGererPatient.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		InsererPatient inser = new InsererPatient ();
		JButton btnNewButton = new JButton("INSERER PATIENT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				inser.frmInsertionPatient.setVisible(true);
				frmGererPatient.dispose();
				
			}
		});
		btnNewButton.setForeground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(49, 28, 287, 40);
		panel_1.add(btnNewButton);
		
		JButton btnSupprimerPatient = new JButton("SUPPRIMER PATIENT");
		btnSupprimerPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuppPatient window = new SuppPatient();
                window.framesuppPatient.setVisible(true);
				frmGererPatient.dispose();
			}
		});
		btnSupprimerPatient.setForeground(new Color(0, 128, 0));
		btnSupprimerPatient.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnSupprimerPatient.setBounds(49, 106, 287, 40);
		panel_1.add(btnSupprimerPatient);

		
		

		JButton btnRetour = new JButton("Retour");
        btnRetour.setBounds(20, 250, 100, 30); // Adjust position for better placement
        panel_1.add(btnRetour);
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnRetour) {
     
                    Acceuil newWindow = new Acceuil();
                    newWindow.frmMedocab.setVisible(true);
                    
                    frmGererPatient.dispose(); 
                }
            }
        });

	}
}

