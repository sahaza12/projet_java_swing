package Corps;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ConsulterFrame extends JFrame {

    public ConsulterFrame(String[] elements) {
        setTitle("Consulter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setFont(new Font("Times New Roman", Font.BOLD, 20));

        JPanel contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);

        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html"); // Définir le type de contenu comme HTML
        textPane.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        textPane.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textPane);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        StringBuilder sb = new StringBuilder();
        sb.append("<html><body style=\"text-align: center;\">");

        sb.append("Nom Patient :<br>");
        if (elements[0] != null) {
            sb.append(elements[0]).append("<br><br>");
        }

        sb.append("Médicaments :<br>");
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] != null) {
                sb.append(elements[i]).append("<br>");
            }
        }

        sb.append("</body></html>");

        textPane.setText(sb.toString());

    }

    public static void main(String[] args) {
        String[] elements = {"Nom Patient", "Médicament 1", "Médicament 2", "Médicament 3"};
        ConsulterFrame frame = new ConsulterFrame(elements);
        frame.setVisible(true);
    }
}
