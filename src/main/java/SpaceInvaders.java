import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author
*/
public class SpaceInvaders extends JFrame implements Commons {
	
	/**
	 *
	 */
	private static final long serialVersionUID = -4905230094675077405L;

	
	
	private JButton start, help;

	/*
	 * Inicio
	 */
	private static final String TOP_MESSAGE = "Space ";
	private static final String TOP_MESSAGE2 = "  Invaders";

	private static final String INITIAL_MESSAGE = "WELLCOME TO OUR PROJECT !!!"
			
			+ "<br><br> - Pham Le Duc Thinh"
			+ "<br> - Nguyen Thanh Binh"
			+ "<br> - Huynh Tan Ho Duong"
			+ "<br> - Huynh Xuan Vu";
	/*
	 * Ajuda
	 */
	private static final String HELP_TOP_MESSAGE = "Controllers:";
	private static final String HELP_MESSAGE = 
								
							  "&#8593 &nbsp &thinsp: &ensp Move Up"
							+ "<br>&#8595 &nbsp &thinsp: &ensp Move Down"
							+ "<br>&#8592 &nbsp : &ensp Move Left"
							+ "<br>&#8594 &nbsp  : &ensp Move Right "
							+ "<br><br>Spacebar : Shoot";

	JFrame frame = new JFrame("Space Invaders");
	JFrame frame2 = new JFrame("Space Invaders");
	JFrame frame3 = new JFrame("HELP");

	/*
	 * Constructor
	 */
	public SpaceInvaders() {
		
		String topmessage = "<html><br>" + (TOP_MESSAGE + TOP_MESSAGE2) + "</html> ";
		String topmessage2 = "<html>" + TOP_MESSAGE2 + "</html>";
		String message = "<html>" + INITIAL_MESSAGE + "</html>";
		start = new JButton("START GAME");
		start.addActionListener(new ButtonListener());
		start.setBounds(400, 100, 100, 60);
		start.setBackground(Color.BLACK);
		start.setForeground(new java.awt.Color(51, 255, 51));
		start.setOpaque(true);
		
		help = new JButton("HELP");
		help.addActionListener(new HelpButton());
		help.setBackground(Color.BLACK);
		help.setForeground(new java.awt.Color(51, 255, 51));
		help.setOpaque(true);
		
		JLabel tekst = new JLabel(message, SwingConstants.CENTER);
		JLabel toptekst = new JLabel(topmessage, SwingConstants.CENTER);

		Font font = new Font("Helvetica", Font.BOLD, 13);
		tekst.setFont(font);

		Font font2 = new Font("Helvetica", Font.BOLD, 50);
		toptekst.setFont(font2);
		toptekst.setForeground(new java.awt.Color(51, 255, 51));
		tekst.setForeground(new java.awt.Color(255, 255, 255));
		frame2.setTitle("Space Invaders");

		frame2.add(tekst);

		frame2.add(toptekst, BorderLayout.PAGE_START);
		JPanel nedredel = new JPanel();
		nedredel.add(help);
		nedredel.add(start);
		
		frame2.add(nedredel, BorderLayout.PAGE_END);
		frame2.setSize(500, 500);
		frame2.getContentPane().setBackground(Color.BLACK);
		frame2.setLocationRelativeTo(null);
		frame2.setVisible(true);
		frame2.setResizable(false);

	}

	public void closeIntro() {
		frame2.dispose();
		frame3.dispose();
	}

	public void closeHelp() {
		frame3.dispose();
	}

	/*
	 * Main
	 */
	public static void main(String[] args) {
		new SpaceInvaders();
	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(BOARD_WIDTH, BOARD_HEIGTH);
			frame.getContentPane().add(new Board());
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			closeIntro();
		}
	}

	private class CloseHelp implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			closeHelp();
		}
	}

	private class HelpButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton close = new JButton("Close");
			close.setBackground(Color.BLACK);
			close.setBorderPainted(false);
			close.setForeground(new java.awt.Color(51, 255, 51));
			close.addActionListener(new CloseHelp());

			String topmessage = "<html><br>" + HELP_TOP_MESSAGE + "</html>";
			String message = "<html>" + HELP_MESSAGE + "</html> ";
			JLabel tekst = new JLabel(message, SwingConstants.CENTER);
			JLabel toptekst = new JLabel(topmessage, SwingConstants.CENTER);

			Font font = new Font("Helvetica", Font.BOLD, 13);
			tekst.setFont(font);

			Font font2 = new Font("Helvetica", Font.BOLD, 20);
			toptekst.setFont(font2);
			toptekst.setForeground(new java.awt.Color(255, 255, 255));
			tekst.setForeground(new java.awt.Color(255, 255, 255));
			frame3.add(tekst);

			frame3.add(toptekst, BorderLayout.PAGE_START);

			frame3.add(close, BorderLayout.PAGE_END);
			frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame3.setSize(250, 290);
			frame3.getContentPane().setBackground(Color.BLACK);
			frame3.setResizable(false);
			frame3.setLocationRelativeTo(null);
			frame3.setVisible(true);
			
		}
	}
}