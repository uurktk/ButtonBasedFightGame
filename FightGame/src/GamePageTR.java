import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GamePageTR extends JFrame {


	private JPanel contentPane;
    private JLabel player1_label;
    private JLabel player2_label;

    public int createNumber() {
        Random random = new Random();
        return random.nextInt(1, 21);
    }

    int whoseTurn = 0;
    private JLabel infoMessage;

    public GamePageTR(String player1Name, String player2Name) {
        setTitle("Fight Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 0));
        contentPane.setVisible(true);
        contentPane.setLayout(null);
        setContentPane(contentPane);

        player1_label = new JLabel();
        player1_label.setFont(new Font("Tahoma", Font.PLAIN, 18));
        player1_label.setForeground(new Color(255, 0, 0));
        player1_label.setBounds(30, 21, 236, 42);
        player1_label.setText(player1Name + ": 100");

        contentPane.add(player1_label);

        player2_label = new JLabel();
        player2_label.setFont(new Font("Tahoma", Font.PLAIN, 18));
        player2_label.setForeground(new Color(0, 128, 255));
        player2_label.setBounds(30, 61, 236, 42);
        player2_label.setText(player2Name + ": 100");
        contentPane.add(player2_label);

        infoMessage = new JLabel("");
        infoMessage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        infoMessage.setBackground(Color.BLACK);
        infoMessage.setForeground(new Color(255, 255, 0));
        infoMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
        infoMessage.setBounds(31, 148, 403, 42);
        contentPane.add(infoMessage);

        JLabel winnerMessage = new JLabel("");
        winnerMessage.setForeground(new Color(224, 176, 255));
        winnerMessage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        winnerMessage.setBounds(253, 35, 150, 49);
        contentPane.add(winnerMessage);

        JLabel turnMessage = new JLabel(player1Name+" hamle yap.");
        turnMessage.setForeground(new Color(255, 0, 0));
        turnMessage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        turnMessage.setBounds(253, 21, 171, 23);
        contentPane.add(turnMessage);

        JButton playagain_btn = new JButton("TEKRAR OYNA");
        playagain_btn.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
                MainPageTR frame = new MainPageTR();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
        		dispose();
        	}
        });
        playagain_btn.setToolTipText("");
        playagain_btn.setForeground(Color.ORANGE);
        playagain_btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
        playagain_btn.setFocusPainted(false);
        playagain_btn.setBackground(Color.BLACK);
        playagain_btn.setBounds(293, 153, 110, 37);
        playagain_btn.setVisible(false);
        contentPane.add(playagain_btn);

        JButton attack_btn = new JButton("SALDIR");
        attack_btn.setBounds(31, 201, 110, 37);
        contentPane.add(attack_btn);
        attack_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        attack_btn.setForeground(new Color(255, 0, 0));
        attack_btn.setBackground(new Color(0, 0, 0));
        attack_btn.setFocusPainted(false);
        attack_btn.setFont(new Font("Tahoma", Font.PLAIN, 16));

                JButton heal_btn = new JButton("İYİLEŞ");
                heal_btn.setBounds(162, 201, 110, 37);
                contentPane.add(heal_btn);
                heal_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                heal_btn.setBackground(new Color(0, 0, 0));
                heal_btn.setForeground(new Color(0, 255, 0));
                heal_btn.setFocusPainted(false);
                heal_btn.addActionListener(new ActionListener() {
                    @Override
					public void actionPerformed(ActionEvent e) {
                        int heal = createNumber();
                        int playerhp;
                        if (whoseTurn == 1) {
                            infoMessage.setText(player2Name+" kendini " + heal + " iyileştirdi");
                            playerhp = Integer.parseInt(player2_label.getText().split(":")[1].trim());
                            playerhp += heal;
                            player2_label.setText(player2Name + ": " + playerhp);
                            whoseTurn--;
                            turnMessage.setText(player1Name+" hamle yap.");
                            turnMessage.setForeground(new Color(255, 0, 0));
                        } else if (whoseTurn == 0) {
                        	infoMessage.setText(player1Name+" kendini " + heal + " iyileştirdi");
                            playerhp = Integer.parseInt(player1_label.getText().split(":")[1].trim());
                            playerhp += heal;
                            player1_label.setText(player1Name + ": " + playerhp);
                            whoseTurn++;
                            turnMessage.setText(player2Name+ " hamle yap.");
                            turnMessage.setForeground(new Color(0, 128, 255));
                        }
                    }
                });

                        heal_btn.setFont(new Font("Tahoma", Font.PLAIN, 16));

                                JButton surrender_btn = new JButton("TESLİM OL");
                                surrender_btn.setBounds(293, 201, 110, 37);
                                contentPane.add(surrender_btn);
                                surrender_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                surrender_btn.setForeground(new Color(140, 50, 255));
                                surrender_btn.setBackground(new Color(0, 0, 0));
                                surrender_btn.setToolTipText("");
                                surrender_btn.addActionListener(new ActionListener() {
                                    @Override
									public void actionPerformed(ActionEvent e) {
                                        if (whoseTurn == 1) {
                                            infoMessage.setText(player2Name + " teslim oldu.");
                                            player2_label.setText(player2Name + ": 0");
                                            whoseTurn = 5;
                                            turnMessage.setText("OYUN BİTTİ");
                                            winnerMessage.setText(player1Name + " KAZANDI!");
                                            playagain_btn.setVisible(true);
                                            turnMessage.setForeground(new Color(224, 176, 255));
                                        } else if (whoseTurn == 0) {
                                            infoMessage.setText(player1Name + " teslim oldu.");
                                            player1_label.setText(player1Name + ": 0");
                                            whoseTurn = 5;
                                            turnMessage.setText("OYUN BİTTİ");
                                            winnerMessage.setText(player2Name + " KAZANDI!");
                                            playagain_btn.setVisible(true);
                                            turnMessage.setForeground(new Color(224, 176, 255));
                                        }
                                    }
                                });
                                surrender_btn.setFocusPainted(false);
                                surrender_btn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        attack_btn.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                int damage = createNumber();
                int playerhp;
                if (whoseTurn == 1) {
                    infoMessage.setText(player2Name +" "+player1Name +"'e " + damage + " hasar verdi");
                    playerhp = Integer.parseInt(player1_label.getText().split(":")[1].trim());
                    playerhp -= damage;
                    if (playerhp <= 0) {

                        whoseTurn = 5;
                        turnMessage.setText("OYUN BİTTİ");
                        winnerMessage.setText(player2Name + " KAZANDI!");
                        turnMessage.setForeground(new Color(224, 176, 255));
                        playagain_btn.setVisible(true);
                    } else {
                        whoseTurn--;
                        turnMessage.setText(player1Name + " hamle yap.");
                        turnMessage.setForeground(new Color(255, 0, 0));
                    }
                    player1_label.setText(player1Name + ": " + playerhp);
                } else if (whoseTurn == 0) {
                	 infoMessage.setText(player1Name +" "+player2Name +"'e " + damage + " hasar verdi");
                    playerhp = Integer.parseInt(player2_label.getText().split(":")[1].trim());
                    playerhp -= damage;
                    if (playerhp <= 0) {

                        whoseTurn = 5;
                        turnMessage.setText("OYUN BİTTİ");
                        winnerMessage.setText(player1Name + " KAZANDI!");
                        playagain_btn.setVisible(true);
                        turnMessage.setForeground(new Color(224, 176, 255));

                    } else {
                        whoseTurn++;
                        turnMessage.setText( player2Name+" hamle yap.");
                        turnMessage.setForeground(new Color(0, 128, 255));
                    }
                    player2_label.setText(player2Name + ": " + playerhp);
                }
            }
        });
    }
}