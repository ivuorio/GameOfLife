import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import java.util.Timer;
import java.util.TimerTask;





public class Peli {
	//private static final String nimi = "ELÄMÄMPELI";
	//***********NÄMÄ ARVOT TÄYTYYNEE JÄTTÄÄ SÄÄDETTÄVIKSI**************
    public static final int solunKoko = 10;
    public static final int solujaPerRivi = 50;
    public static final int leveys = solunKoko * solujaPerRivi;
    public static final int korkeus = leveys;

    public static final Dimension koko = new Dimension(leveys, korkeus);
    //mikä hitto tämä on???
    private static boolean RUNNING = true;
    //luodaan solu lista johon voidaan alustaa pelilaudan solut.
    public static final Solu[][] solut = new Solu[solujaPerRivi][solujaPerRivi];

    //tähän laudan hallinta metodit
    public Peli(String s) {
    	
    	//luodaan ikkuna
        JFrame ikkuna = new JFrame(s);
        //asetetaan sen koko  muuttujan koko mukaan
        ikkuna.setSize(koko);
        
        ikkuna.setLocationRelativeTo(null);
        //asetetaan close operaatio niin että ohjelma ei sulkeudu vaan vain ikkuna jossa peli pyörii.
        ikkuna.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //ikkuna.setWindowCommand("lataus");
        
        ikkuna.setVisible(true);
        
        
        alustaSolut();
        
        //NÄMÄ VAIN TESTIKSI JOTEN TILALLE PITÄISI LAITTAA JOKU LATAUS METODI.
        //*******************************************************************
        solut[10][10].asetaElossa(true);
        solut[10][11].asetaElossa(true);
        solut[10][12].asetaElossa(true);
        solut[11][10].asetaElossa(true);
        solut[12][10].asetaElossa(true);
        solut[12][11].asetaElossa(true);
        solut[12][12].asetaElossa(true);
        solut[11][12].asetaElossa(true);
        
        
        solut[20][11].asetaElossa(true);
        solut[20][12].asetaElossa(true);
        solut[20][13].asetaElossa(true);
        solut[19][13].asetaElossa(true);
        solut[18][12].asetaElossa(true);
        
        final Pelilauta lauta = new Pelilauta(); 
        //lauta.createBufferStrategy(3);
        ikkuna.add(lauta);
        
        //EI TOIMI VITTU SAATANA PERKELE!!!
        ikkuna.addWindowListener(new WindowListener() {

            //@Override
            public void windowClosing(WindowEvent e) {
                RUNNING=false;
                System.out.println(RUNNING + "RUNNING vaihdettu");
            }

            
            public void windowOpened(WindowEvent e) {}

            
            public void windowClosed(WindowEvent e) {}

            
            public void windowIconified(WindowEvent e) {}

            
            public void windowDeiconified(WindowEvent e) {}

             
            public void windowActivated(WindowEvent e) {}

             
            public void windowDeactivated(WindowEvent e) {
            	RUNNING=false;
                System.out.println(RUNNING + "RUNNING vaihdettu");
            }

        });
        peliSilmukka(lauta);
        
    }
    //metodi alustaa kaikki pelilaudan solut kuolleiksi
    private static void alustaSolut() {
        for (int x = 0; x < solut.length; x++) {
            for (int y = 0; y < solut[x].length; y++) {
                if (solut[x][y] == null)
                    solut[x][y] = new Solu(x, y);
            }
        }
    }
    private static void peliSilmukka(final Pelilauta lauta) {
        Timer timer = new Timer();
        if (RUNNING) {
        	//timer luokan metodi scheduele ottaa parametreinaan TimerTaskin, ajan joka odotetaan enne aloitusta(long), ja ajan joko odotetaan onnistuneen suorituksen jälkeen(long)
            timer.schedule(new TimerTask() {

                //@Override
                public void run() {
                    SoluTutkija.paivitys();
                    lauta.repaint();
                }

            }, 1700, 300);
        }
    }
    
    //latausmetodi olis tähän aika kova
    
    
}
