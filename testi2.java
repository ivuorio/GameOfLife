//package components;

//import javax.swing.AbstractButton;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
//import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;


public class testi2 extends JPanel
                        implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	boolean muokkaus=false;
	boolean ladattava=false;
	Solu[][] solut= null;
    String label = "elämämpeli";
    String[] choices = { "ELÄMÄNPELI TÄHTI", "CHOICE 2", "CHOICE 3", "CHOICE 4",
            "PIIRRÄ", "LATAA OMA TALLENNUS" };
    //Luodaan elementit ikkunaa varten
    protected JButton nappi;
    protected JButton lataa;
    protected JTextField polku= new JTextField("Kirjoita ladattavan tilanteen polku tähän.");
  	protected JLabel teksti = new JLabel("Valitse ladattava aloitustilanne");
  	final JCheckBox piirto= new JCheckBox("Muokkaa aloitustilannetta ennen aloitusta.");
  	final JComboBox<String> droppi = new JComboBox<String>(choices);
  	
  	//kostruktori
    public testi2() {
    	//*********************NAPPIEN ASETUKSET*******************
    	nappi = new JButton("Aloita peli");
		//b1.setVerticalTextPosition(AbstractButton.CENTER);
		//nappi.setHorizontalTextPosition(AbstractButton.); //aka LEFT, for left-to-right locales
		//b1.setMnemonic(KeyEvent.VK_D);
    	//luodaan nappiin käsky joka annetaan painettaessa.
		nappi.setActionCommand("pelaa");
		//Kuunnellaan tuleeko napille painalluksia
		nappi.addActionListener(this);
		//ToolTippi joka näkyy jos hiiren jättää napin päälle...
		nappi.setToolTipText("Tätä nappia painamalla peli alkaa! Embrace your self!!");
		
		lataa = new JButton("Lataa oma tallennus");
		lataa.setActionCommand("lataa");
		lataa.addActionListener(this);
		lataa.setToolTipText("Onhan polku oikein? Ettei nyt vaan sattuisi mitään!");
		//lataa.setHorizontalTextPosition(AbstractButton.WEST);
		
		
		
		//************************TEKSTI ASETUKSET*************************
		//sijoitetaan keskelle rutua
		teksti.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    //*********************PIIRTO ASETUKSET*******************
		//Sijoitetaan piirtovalinta keskelle ikkunaan
	    piirto.setAlignmentX(Component.CENTER_ALIGNMENT);
	    piirto.addItemListener(new ItemListener(){
	    	public void itemStateChanged(ItemEvent e) {
	    		if(e.getItemSelectable() == piirto) muokkaus=true;
	    	}
	    });
	    //piirto.addActionListener(this);

	    //*********************POLKU ASETUKSET*******************
	    /*
	    polku.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(polku.getText() != "Kirjoita ladattaven pelin polku tähän.") {
					ladattava=true;
					System.out.print(ladattava);
					lataa.setEnabled(true);
				}
			}
	    });
	    */
	    
	    //*********************DROPPI ASETUKSET*******************
	    droppi.setMaximumSize(droppi.getPreferredSize()); // added code
	    droppi.setAlignmentX(Component.CENTER_ALIGNMENT);// added code
	    droppi.setActionCommand("lataus");
	    droppi.addActionListener(this);
	    
        //*********
	    add(teksti);
	    add(droppi);
	    add(polku);
	    add(piirto);
	    polku.setEnabled(false);
	    
	    add(polku);
	    lataa.setEnabled(true);
	    add(lataa);
	    add(nappi);
	    
	    label=(String)droppi.getSelectedItem();
            }
 
    public void actionPerformed(ActionEvent e) {
    	//TÄHÄN PITÄIS LISÄTÄ VAIHTOEHDOT KAIKILLE LATAUKSILLE JA TEHDÄ HYVÄ SYSTEEMI OMAN PELIN LATAUKSEEN... FILEREADER???
    	if ("pelaa".equals(e.getActionCommand())) {
    		if (label=="LATAA OMA TALLENNUS"){
    			// TÄMÄ OSA PITÄISI KORJATA NIIN ETTÄ LATADAAN PELI ANNETUSTA POLUSTA. 
    			new Peli(label, muokkaus, solut);
    		}
    		else{
    			new Peli(label,muokkaus,solut);
    		}
        }
    	if ("lataus".equals(e.getActionCommand())){
    		if (e.getSource() instanceof JComboBox){
    			JComboBox<String> cb = (JComboBox<String>)e.getSource();
    			label = (String)cb.getSelectedItem();
    			if (label == "LATAA OMA TALLENNUS") polku.setEnabled(true);
    		}
    		else;
    	}
    	if ("lataa".equals(e.getActionCommand())){
    		//lataaja joka toimii FileReaderilla....
    		//lataaja()
    		System.out.print(polku.getText());
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
