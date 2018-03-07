import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;

public class Piirtaja extends Pelilauta {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Solu[][] solut = Peli.solut;

	public Piirtaja() {
		super();
        
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lisaaSolu(e.getX(),e.getY());
                piirraSolut();
            }
        });

        /*addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                moveSquare(e.getX(),e.getY());
            }
        });*/
        //suorittaa metodin joka piirtää solut
        //piirraSolut();
    }
	
    public void lisaaSolu(int xSaatu, int ySaatu){
    	int x= xSaatu/Peli.solunKoko;
    	//if (xSaatu%Peli.solunKoko>4) x++;
    	int y= ySaatu/Peli.solunKoko;
    	//if (ySaatu%Peli.solunKoko>4) y++;
    	solut[x][y].vaihdaElossa();
    	
    }
}

