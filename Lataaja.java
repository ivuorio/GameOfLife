import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
//numerosarjan tallentaminen lataaminen tidostoon.
public class Lataaja {
	final static JTextField nimi= new JTextField("Kirjoita tallennuksen nimi tähän.");
	
	
	public static void tallennusNimi(final Solu[][] solut){
		JFrame ikkuna =new JFrame("Tallennus");
		JPanel paneeli = new JPanel();
		//JTextField nimi= new JTextField("Kirjoita tallennuksen nimi tähän.");
		JButton tallenna = new JButton("Tallenna!");
		tallenna.setActionCommand("tallenna");
		tallenna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ("tallenna".equals(e.getActionCommand())) {
					System.out.println("mennään tal");
					tallenna(solut,nimi.getText());
				}
			}
			
		});
		paneeli.add(nimi);
		paneeli.add(tallenna);
		//asetetaan sulkemis operaatio
        ikkuna.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //ja paikka
        ikkuna.setLocationRelativeTo(null);
        //Tällä saadaan allekkain teksti, drobvalikko ja nappi...
        paneeli.setLayout(new BoxLayout(paneeli, BoxLayout.Y_AXIS));
        paneeli.setOpaque(true); //content panes must be opaque MUTTA MIKSI?
        ikkuna.setContentPane(paneeli);

        //Tehdään ikkunansta pienin mahdollinen
        ikkuna.pack();
        //asetetaan näkyväksi
        ikkuna.setVisible(true);
		
	}
	public static void tallenna(Solu[][] solut, String polku){
		try{
			
			FileWriter fileWriter = new FileWriter(polku+".txt");
			//jostain syystä suositeltiin että fileWriter laitetaan bufferWriterin sisään
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			//luodaan tallennettavat numerot loopilla
			for(int x = 0;x<solut.length;x++){
				for(int y=0;y<solut[x].length;y++){
					String s;
					if (solut[y][x].annaElossa()==true){
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
			System.out.print("tallennettiin");
		}
		catch(IOException ex){//tiedosto ei ollu kelvollinen
			System.out.println("Jokin meni pielee!");
			//tulostetaan missä pinossa homma meni puihin.
			ex.printStackTrace();
		}
	}
	public static Solu[][] laturi(String polku){
		//virheilta välttymiseksi otetaan numerot stringinä ja parsitaan se
		String numero;
		Solu[][] lauta = new Solu[70][70];
		for (int x = 0; x < lauta.length; x++) {
            for (int y = 0; y < lauta[x].length; y++) {
                if (lauta[x][y] == null)
                	//luodaan taulukkoon uudet solu oliot
                    lauta[x][y] = new Solu(x, y);
            }
        }
		try{
			FileReader fileReader = new FileReader(polku+".txt");
			//jälleen käytetään bufferia
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			//while looppaillaan tidostoa kunnes rivi on tyhjä
			int laskuri = 0;
			int i = 0;
			//readLine kusee kun lukee koko rivin...
			
			while( (numero = bufferedReader.readLine())!= null){
				while (laskuri < 70){
						if(numero.charAt(laskuri)=='1'){
							lauta[laskuri][i].asetaElossa(true);
							System.out.println("("+i+","+laskuri+") asetettiin eloon"+laskuri);
						}
						laskuri = laskuri + 1;
				}
				laskuri = 0;
				
				i = i+1;
				//bufferedReader.newLine();
			}
			bufferedReader.close();
			System.out.println("hienosti ladattu!");
			return lauta;

		}
		catch(FileNotFoundException ex) {
            System.out.println(
                "Tiedostoa ei löydy '" +
                polku + "'");
            return lauta;
		}
		catch(IOException ex){
			System.out.println("Jokin meni pieleen!");
			ex.printStackTrace();
			return lauta;
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
