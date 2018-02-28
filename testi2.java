//package components;

//import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;

/*
 *PROJEKTIN LUOKKA JOSTA LÖYTYY MAIN METODI. SISÄLTÄÄ MYÖS PÄÄVALIKON.
 */
public class testi2 extends JPanel
                        implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton nappi;
    String label = "elämämpeli";
    public testi2() {

      nappi = new JButton("Aloita peli");
      nappi.setActionCommand("pelaa");

      //Kuunnellaan tuleeko napille painalluksia
      nappi.addActionListener(this);

      //ToolTippi joka näkyy jos hiiren jättää napin päälle...
      nappi.setToolTipText("Tätä nappia painamalla peli alkaa! Embrace your self!!");

      //tekstikenttä jossa ohjeita
      JLabel teksti = new JLabel("Valitse ladattava aloitus tilanne");
      //sijoitetaan keskelle rutua
      teksti.setAlignmentX(Component.CENTER_ALIGNMENT);
      

	    String[] choices = { "ELÄMÄNPELI TÄHTI", "CHOICE 2", "CHOICE 3", "CHOICE 4",
	                         "CHOICE 5", "LATAA OMA TALLENNUS" };

	    final JComboBox<String> droppi = new JComboBox<String>(choices);

	    droppi.setMaximumSize(droppi.getPreferredSize()); 
	    droppi.setAlignmentX(Component.CENTER_ALIGNMENT);
	    droppi.setActionCommand("lataus");
	    droppi.addActionListener(this);
	    

      //Lisätään luodut GUI oliot ikkunaan
      add(teksti);
      add(droppi);
      add(nappi);
      label=(String)droppi.getSelectedItem();
            }
	/*
	*metodi vaihtaa ikkunan otsikkoa, ideana olisi että valikosta valittu aloitus tilanne latautuisi pelilaudalle.
	*aloitus tilanteet pitäisi luoda ja tiedoston lataaja.
	*/
    public void actionPerformed(ActionEvent e) {
    	if ("pelaa".equals(e.getActionCommand())) {
    		if (label=="LATAA OMA TALLENNUS"){
			//Jos on valittu oman pelin tallennus luodaan lataaja olio joka on uusi ikkuna.
    			Lataaja lat =new Lataaja();
    			lat.aja();
    		}
    		else{
    			new Peli(label);
    		}
        }
    	if ("lataus".equals(e.getActionCommand())){
    		JComboBox<String> cb = (JComboBox<String>)e.getSource();
    	    label = (String)cb.getSelectedItem();

    	}
    	else {

        }

    }
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {

        //luodaan uusi ikkuna
        JFrame frame = new JFrame("ELÄMÄMPELI VALIKKO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        //Create and set up the content pane.
        testi2 newContentPane = new testi2();
        //Tällä saadaan allekkain teksti, drobvalikko ja nappi...
        newContentPane.setLayout(new BoxLayout(newContentPane, BoxLayout.Y_AXIS));
        newContentPane.setOpaque(true); //content panes must be opaque MUTTA MIKSI?
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
