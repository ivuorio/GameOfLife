import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.Timer;
import java.util.TimerTask;



public class Peli {
	//private static final String nimi = "ELÄMÄMPELI";
	//***********NÄMÄ ARVOT TÄYTYYNEE JÄTTÄÄ SÄÄDETTÄVIKSI**************
    public static final int solunKoko = 10;
    public static final int solujaPerRivi = 70;
    public static final int leveys = solunKoko * solujaPerRivi;
    public static final int korkeus = leveys;

    public static final Dimension koko = new Dimension(leveys, korkeus+10);
    //
    private static boolean RUNNING = true;
    //lähtötilanteessa peli on pysäytetty
    private static boolean BREAK = true;
    private JFrame ikkuna;
    public boolean piirt;
    
    //luodaan solu lista johon voidaan alustaa pelilaudan solut.
    public static Solu[][] solut = new Solu[solujaPerRivi][solujaPerRivi];

    //tähän laudan hallinta metodit
    public Peli(String s, boolean piirtaja, Solu[][] alku) {
    	//voidaanko soluja muuttaa
    	piirt=piirtaja;
    	//luodaan ikkuna
        ikkuna = new JFrame(s);
        //asetetaan sen koko  muuttujan koko mukaan
        ikkuna.setSize(koko);
        //asetetaan ikkuna keskelle näyttöä
        ikkuna.setLocationRelativeTo(null);
        //asetetaan close operaatio niin että ohjelma ei sulkeudu vaan vain ikkuna jossa peli pyörii.
        ikkuna.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        ikkuna.setVisible(true);
        
        
        alustaSolut();
        
        if (alku != null){
        	solut=alku;
        }
        //luodaan pelilauta olio
        final Pelilauta lauta = new Pelilauta(); 
        //luodaan nappi josta peli alkaa
        final JButton aloitaPeli = new JButton("Aloita peli");
        //asetetaan napille commandi.
        aloitaPeli.setActionCommand("pelaa");
        //toinene nappi tallennukseen
        final JButton tallennaPeli= new JButton("Tallenna peli");
        //ja sille käsky
        tallennaPeli.setActionCommand("tallenna");
        
        tallennaPeli.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		if ("tallenna".equals(e.getActionCommand())){
        			//keskeytetään peli
        			BREAK=true;
        			//Lataaja luokan tallennaNimi metodilla kysytään tallennettavan tiedoston nimi ja sen jälkkeen tallennetaan peli.
        			Lataaja.tallennusNimi(solut);
        			//aktivoidaan aloita peli nappula.
        			aloitaPeli.setEnabled(BREAK);
        		}
        	}
        });
        
        //jos pelilauta on konstruktoitu muokattavana ajetaan tämän iffin sisältö jolloin pelilautaa voidaan muokata enne pelaamista ja sen aikana.
        if(piirt){
        	//luodaan piirtaja luokan mukainene olio
        	final Piirtaja piir = new Piirtaja();
        	//lisätään ikkunaan nappulat ja pelilauta
        	ikkuna.add(aloitaPeli, BorderLayout.NORTH);
        	aloitaPeli.setEnabled(true);
        	ikkuna.add(piir);
        	ikkuna.add(tallennaPeli, BorderLayout.SOUTH);
        	//lisätään aloita peli näppäimeen action listener sen varalta että joku sitä painaa...
        	aloitaPeli.addActionListener(new ActionListener(){
            	public void actionPerformed(ActionEvent e) {
            		if ("pelaa".equals(e.getActionCommand())){
            			BREAK = false;
            			peliSilmukka(piir);
            			aloitaPeli.setEnabled(BREAK);
            		}
            	}
            });
        	
        }
        // jos pelaulaudasta ei haluttu muokattavaa ajetaan tämä silmukka
        if(!piirt){
        	//lisätään ikkunaan lauta ja pelin tallennus nappula. pelia alkaa automaattisesti pyöriä, onko tämä paha?
        	ikkuna.add(lauta);
        	ikkuna.add(tallennaPeli, BorderLayout.SOUTH);
        	BREAK = false;
        	peliSilmukka(lauta);
        }
        
        
        
        //Lisätään ikkunan toimintojen seuraaja
        ikkuna.addWindowListener(new WindowListener() {

            //@Override
        	//jos ikkuna suljetaan asetetaan BREAK jotta peli ei jää pyörimään ja tilanne muutu sillä välin kun ikkuna on kiinni.
            public void windowClosing(WindowEvent e) {
                BREAK=true;
                //System.out.println(BREAK + "RUNNING vaihdettu");
            }

            
            public void windowOpened(WindowEvent e) {}

            
            public void windowClosed(WindowEvent e) {}

            
            public void windowIconified(WindowEvent e) {}

            
            public void windowDeiconified(WindowEvent e) {}

             
            public void windowActivated(WindowEvent e) {}

             
            public void windowDeactivated(WindowEvent e) {
            	
            }

        });
        
        
    }
    //metodi alustaa kaikki pelilaudan solut kuolleiksi
    private static void alustaSolut() {
        for (int x = 0; x < solut.length; x++) {
            for (int y = 0; y < solut[x].length; y++) {
                if (solut[x][y] == null)
                	//luodaan taulukkoon uudet solu oliot
                    solut[x][y] = new Solu(x, y);
            }
        }
    }
    private static void peliSilmukka(final Pelilauta lauta) {
    	//lähtökohtaisesti BREAK on false jotta luuppi ei katkea
    	BREAK=false;
    	//luodaan taimer olio
        final Timer timer = new Timer();
        
        if (RUNNING) {
        	//timer luokan metodi scheduele ottaa parametreinaan TimerTaskin, ajan joka odotetaan enne aloitusta(long), ja ajan joko odotetaan onnistuneen suorituksen jälkeen(long)
            timer.scheduleAtFixedRate(new TimerTask() {
            	
                //@Override
                public void run() {
                	//jos BREAK on muutettu true niin katkaistaan pelin pyöriminen
                    if(BREAK) timer.cancel();
                	//solut päivitetään 
                    SoluTutkija.paivitys();
                    //lauta uudelleen maalataan
                    lauta.repaint();
                    
                    
                }

            }, 500, 500);
        }
    }
}
