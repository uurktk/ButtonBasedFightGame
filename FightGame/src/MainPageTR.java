import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class MainPageTR extends JFrame {

	private JPanel mainMenu;
    private JTextField player1;
    private JTextField player2;
    private JButton start_btn;
    private JLabel errorMessage;
    private JButton lang_btn;
    private int selectedLanguage = 0;
    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public MainPageTR() {
        setTitle("Savaş Oyunu");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setResizable(false);
        mainMenu = new JPanel();
        mainMenu.setBackground(new Color(0, 0, 0));
        mainMenu.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(mainMenu);
        mainMenu.setLayout(null);

        lang_btn = new JButton("TR");
        lang_btn.setForeground(Color.PINK);
        lang_btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lang_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lang_btn.setFocusPainted(false);
        lang_btn.setBackground(Color.BLACK);
        lang_btn.setBounds(28, 190, 70, 42);
        mainMenu.add(lang_btn);
        if(selectedLanguage == 0) {
        JLabel lblNewLabel = new JLabel("BUTON TABANLI SAVAS OYUNU");
        lblNewLabel.setForeground(new Color(0, 255, 0));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Lucida Sans", lblNewLabel.getFont().getStyle(), 25));
        lblNewLabel.setBounds(0, 24, 434, 47);
        mainMenu.add(lblNewLabel);

        JLabel player1_name = new JLabel("Oyuncu 1 :");
        player1_name.setForeground(new Color(255, 0, 0));
        player1_name.setFont(new Font("Tahoma", player1_name.getFont().getStyle(), 18));
        player1_name.setBounds(32, 92, 123, 42);
        mainMenu.add(player1_name);

        JLabel player1_name_1 = new JLabel("Oyuncu 2 :");
        player1_name_1.setForeground(new Color(0, 128, 255));
        player1_name_1.setBackground(new Color(255, 255, 255));
        player1_name_1.setFont(new Font("Tahoma", player1_name_1.getFont().getStyle(), 18));
        player1_name_1.setBounds(32, 127, 123, 47);
        mainMenu.add(player1_name_1);

        player1 = new JTextField();
        player1.setHorizontalAlignment(SwingConstants.LEFT);
        player1.setBackground(new Color(0, 0, 0));
        player1.setForeground(new Color(255, 255, 255));
        player1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        player1.setBounds(149, 104, 244, 23);
        player1.setColumns(10);
        mainMenu.add(player1);

        player2 = new JTextField();
        player2.setBackground(new Color(0, 0, 0));
        player2.setForeground(new Color(255, 255, 255));
        player2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        player2.setColumns(10);
        player2.setBounds(149, 141, 244, 23);
        mainMenu.add(player2);

        start_btn = new JButton("BAŞLA");
        start_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        start_btn.setFocusPainted(false);
        start_btn.setBackground(new Color(255, 128, 0));
        start_btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        start_btn.setForeground(new Color(40, 24, 87));
        start_btn.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
            if(player1.getText().length()>12 || player2.getText().length()>12
            	||	player1.getText().equals("") || player2.getText().equals("")) {
            	errorMessage.setVisible(true);
            }
            	else {
                String player1Name = player1.getText().trim();
                String player2Name = player2.getText().trim();
                GamePageTR frame = new GamePageTR(player1Name, player2Name);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();
            }
            }
        });
        start_btn.setBounds(193, 190, 123, 42);
        mainMenu.add(start_btn);

        errorMessage = new JLabel("GEÇERLİ BİR İSİM GİR");
        errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
        errorMessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
        errorMessage.setForeground(new Color(255, 0, 51));
        errorMessage.setBounds(149, 77, 244, 15);
        errorMessage.setVisible(false);
        mainMenu.add(errorMessage);
        }
        lang_btn.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                if (selectedLanguage == 1) {
                    selectedLanguage = 0;
                    lang_btn.setText("TR");
                    dispose(); // Close the current frame 

                    // Create a new instance of MainPageTR and show it
                    EventQueue.invokeLater(new Runnable() {
                        @Override
						public void run() {
                            try {
                                MainPageTR frame = new MainPageTR();
                                frame.setLocationRelativeTo(null);
                                frame.setVisible(true);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    });

                } else if (selectedLanguage == 0) {
                    selectedLanguage = 1;
                    lang_btn.setText("EN");
                    dispose(); // Close the current frame (MainPageTR)

                    // Create a new instance of Main and show it
                    EventQueue.invokeLater(new Runnable() {
                        @Override
						public void run() {
                            try {
                                Main frame = new Main();
                                frame.setLocationRelativeTo(null);
                                frame.setVisible(true);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
    }
}