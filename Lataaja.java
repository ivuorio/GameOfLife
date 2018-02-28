import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
/*
 *TÄLLÄ LUOKALLA LUODAAN TALLENNETUN PELIN LATAUSIKKUNA, 
 *EHKÄ SAMAN LUOKAN ALLE VOISI LAITTAA METODIN JOSSA OLISI TALLENNETUN PELIN LATAUS??
 */


public class Lataaja extends JPanel
		implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton b1, b2, b3;
	String label = "elämämpeli";
	public Lataaja() {
	
		b1 = new JButton("Lataa peli");
		b1.setActionCommand("pelaa");
		
		//Listen for actions on buttons 1
		b1.addActionListener(this);
		
		b1.setToolTipText("Tätä nappia painamalla peli alkaa! Embrace your self!!");
		
		JLabel teksti = new JLabel("Valitse ladattava aloitus tilanne");
		teksti.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		add(teksti);
		
		JTextField polku= new JTextField("Kirjoita ladattaven pelin polku tähän.");
		add(polku);
		//Add Components to this container, using the default FlowLayout.
		add(b1);
		
		label="OMA HIENO ELÄMÄMPELI!!";
	}

	public void actionPerformed(ActionEvent e) {
		if ("pelaa".equals(e.getActionCommand())) {
			//try-catch-lause fileReaderiin. Jos polkua ei löydy heitä herjaa!
			new Peli(label);
		}
		else{
		}
	} 


	/**
	* Create the GUI and show it.  For thread safety, 
	* this method should be invoked from the 
	* event-dispatching thread.
	*/
	private static void createAndShowLATURI() {
	
		//luodaan uusi ikkuna
		JFrame frame = new JFrame("ELÄMÄMPELI LATAAJA");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(new Dimension(500,300));
		frame.setLocationRelativeTo(null);
		
		
		//Create and set up the content pane.
		Lataaja newContentPane = new Lataaja();
		//Tällä saadaan allekkain teksti, drobvalikko ja nappi...
		newContentPane.setLayout(new BoxLayout(newContentPane, BoxLayout.Y_AXIS)); 
		newContentPane.setOpaque(true); //content panes must be opaque MUTTA MIKSI?
		frame.setContentPane(newContentPane);
		
		//Display the window.
		//frame.pack();
		frame.setVisible(true);
	}
	
	public void aja() {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowLATURI(); 
			}
		});
	}
}
