import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//numerosarjan tallentaminen lataaminen tidostoon.
public class Lataaja {
	public static void tallenna(Solu[][] solut, String polku){
		try{
			FileWriter fileWriter = new FileWriter("tallennus.txt");
			//jostain syystä suositeltiin että fileWriter laitetaan bufferWriterin sisään
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			//luodaan tallennettavat numerot loopilla
			for(int x = 0;x<solut.length;x++){
				for(int y=0;y<solut[x].length;y++){
					String s;
					if (solut[x][y].annaElossa()==true){
						s = "1";
					}
					else s = "0";
					bufferedWriter.write(s);
					
					
				}
				//uusi rivi täytyy luoda erillisellä komennolla!!
				bufferedWriter.newLine();
				
			}
			//suljetaan bufferedWriter ettei aiheudu muistivuotoja
			bufferedWriter.close();
		}
		catch(IOException ex){//tiedosto ei ollu kelvollinen
			System.out.println("Jokin meni pielee!");
			//tulostetaan missä pinossa homma meni puihin.
			ex.printStackTrace();
		}
	}
	public static int lueNumerot(String polku){
		//virheilta välttymiseksi otetaan numerot stringinä ja parsitaan se 
		String numero;
		int summa = 0;
		try{
			FileReader fileReader = new FileReader(polku);
			//jälleen käytetään bufferia
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			//while looppaillaan tidostoa kunnes rivi on tyhjä
			while( (numero = bufferedReader.readLine())!= null){
				summa=summa+(Integer.parseInt(numero));
			}
			bufferedReader.close();
			
			return summa;
			
		}
		catch(FileNotFoundException ex) {
            System.out.println(
                "Tiedostoa ei löydy '" + 
                polku + "'"); 
            return 0;
		}
		catch(IOException ex){
			System.out.println("Jokin meni pieleen!");
			ex.printStackTrace();
			return 0;
		}
		
	}
	/*
	public static void main(String[] args){
		//tylsä testailu 
		kirjoitaNumerot(3, "OOP/numerot.txt");
		System.out.println("tallennettiin numerot!");
		int sum = lueNumerot("OOP/numerot.txt");
		System.out.println("ladattujen numeroiden summa: " + sum);
	}
	*/

}




/*import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;


public class Lataaja extends JPanel
		implements ActionListener {
	/**
	 * 
	 */
	/*private static final long serialVersionUID = 1L;
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
			new Peli(label,true,"");
		}
		else{
		}
	} 


	/**
	* Create the GUI and show it.  For thread safety, 
	* this method should be invoked from the 
	* event-dispatching thread.
	*/
	/*private static void createAndShowLATURI() {
	
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
}*/
