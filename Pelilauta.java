//import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/*
public class Pelilauta extends Canvas {
	/**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;

	public Pelilauta() {
		super();
		
		this.setSize(Peli.leveys,Peli.korkeus);
		this.setBackground(Color.WHITE);
		this.setFocusable(true);
		this.setVisible(true);
		
	}

	public void paint(Graphics g){
		Graphics kuvio = this.getGraphics();
        kuvio.clearRect(0, 0, Peli.leveys, Peli.korkeus);
        kuvio.setColor(new Color(255,0,0));
		
        for (Solu[] Solut : Peli.solut) {
            for (Solu solu : Solut) {
                if (solu.annaElossa()) {
                  
                    kuvio.fillRect(solu.annaX() * Peli.solunKoko, solu.annaY() * Peli.solunKoko, Peli.solunKoko, Peli.solunKoko);
                }
            }
        }
	}
	
}*/


import javax.swing.JPanel;
import javax.swing.BorderFactory;

/*
public class Pelilauta {
    
    public Pelilauta(){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }

    private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
        SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.add(new MyPanel());
        f.pack();
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
    
}

class MyPanel extends JPanel {
*/
public class Pelilauta extends JPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Pelilauta() {
    	//Piirtää viivan pelilaudan ympärille. Onko turha?
        setBorder(BorderFactory.createLineBorder(Color.black));
        //suorittaa metodin joka piirtää solut
        piirraSolut();
    }
	
    public void piirraSolut(){
    	//käy läpi kaikki solut
    	for (Solu[] Solut : Peli.solut) {
            for (Solu solu : Solut) {
            	//jos elossa, niin piirretään 
                if (solu.annaElossa()) {
                	//piirretään  paikkaan (x*solunKoko, y*solunkoko) solunKoko kokoinen neliö
                    repaint(solu.annaX() * Peli.solunKoko, solu.annaY() * Peli.solunKoko, Peli.solunKoko, Peli.solunKoko);
                }
            }
        }
    }
  
    /*public Dimension getPreferredSize() {
        return new Dimension(700,700);
    }*/
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);       
        for (Solu[] Solut : Peli.solut) {
            for (Solu solu : Solut) {
                if (solu.annaElossa()) {
                	g.setColor(Color.RED);
                    g.fillRect(solu.annaX() * Peli.solunKoko, solu.annaY() * Peli.solunKoko, Peli.solunKoko, Peli.solunKoko);
                    g.setColor(Color.BLACK);
                    g.drawRect(solu.annaX() * Peli.solunKoko, solu.annaY() * Peli.solunKoko, Peli.solunKoko, Peli.solunKoko);
                }
            }
        }
    }  
}

	

