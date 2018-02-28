import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;


public class Pelilauta extends Canvas {
	/**
	 * 
	 */
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
	
}
	

