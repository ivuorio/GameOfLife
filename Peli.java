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
    //mikä hitto tämä on???
    private static boolean RUNNING = true;
    private static boolean BREAK = false;
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
        //NÄMÄ VAIN TESTIKSI JOTEN TILALLE PITÄISI LAITTAA JOKU LATAUS METODI.
        //*******************************************************************
        /*solut[10][10].asetaElossa(true);
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
        solut[18][12].asetaElossa(true);*/
        
        final Pelilauta lauta = new Pelilauta(); 
        
        final JButton aloitaPeli = new JButton("Aloita peli");
        aloitaPeli.setActionCommand("pelaa");
        final JButton tallennaPeli= new JButton("Tallenna peli");
        tallennaPeli.setActionCommand("tallenna");
        tallennaPeli.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		if ("tallenna".equals(e.getActionCommand())){
        			Lataaja.tallenna(solut, "");
        			System.out.print("tallennetaan!");
        		}
        	}
        });
        
        //lauta.createBufferStrategy(3);
        if(piirt){
        	final Piirtaja piir = new Piirtaja();
        	ikkuna.add(aloitaPeli, BorderLayout.NORTH);
        	ikkuna.add(piir);
        	ikkuna.add(tallennaPeli, BorderLayout.SOUTH);
        	aloitaPeli.addActionListener(new ActionListener(){
            	public void actionPerformed(ActionEvent e) {
            		if ("pelaa".equals(e.getActionCommand())){
            			peliSilmukka(piir);
            		}
            	}
            });
        	
        }
        if(!piirt){
        	ikkuna.add(lauta);
        	ikkuna.add(tallennaPeli, BorderLayout.SOUTH);
        	peliSilmukka(lauta);
        }
        
        
        
        
        //EI TOIMI VITTU SAATANA PERKELE!!! HÄHÄHÄÄ TOIMII SITTENKIN!
        ikkuna.addWindowListener(new WindowListener() {

            //@Override
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
                    solut[x][y] = new Solu(x, y);
            }
        }
    }
    private static void peliSilmukka(final Pelilauta lauta) {
    	//(Peli.ikkuna).add(lauta);
    	BREAK=false;
        final Timer timer = new Timer();
        if (RUNNING) {
        	//timer luokan metodi scheduele ottaa parametreinaan TimerTaskin, ajan joka odotetaan enne aloitusta(long), ja ajan joko odotetaan onnistuneen suorituksen jälkeen(long)
            timer.scheduleAtFixedRate(new TimerTask() {
            	
                //@Override
                public void run() {
                    SoluTutkija.paivitys();
                    lauta.repaint();
                    if(BREAK) timer.cancel();
                    
                }

            }, 500, 500);
        }
    }
    
    //latausmetodi olis tähän aika kova
    
    
}
