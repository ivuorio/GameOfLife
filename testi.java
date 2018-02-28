/*public class testi{
	public static void main(String[] a){
		Pelilauta peli = new Pelilauta();
	}
}*/

/*

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
import java.util.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout; // added code
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class testi  {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
		public void run(){

	    JFrame frame = new JFrame("A Simple GUI");
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(500, 500);
	    frame.setLocation(430, 100);

	    JPanel panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // added code

	    frame.add(panel);
	    /*
	    JLabel lbl = new JLabel("Select one of the possible choices and click OK");
	    lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
	    //lbl.setVisible(true); // Not needed

	    panel.add(lbl);

	    String[] choices = { "CHOICE 1", "CHOICE 2", "CHOICE 3", "CHOICE 4",
	                         "CHOICE 5", "CHOICE 6" };

	    final JComboBox<String> cb = new JComboBox<String>(choices);

	    cb.setMaximumSize(cb.getPreferredSize()); // added code
	    cb.setAlignmentX(Component.CENTER_ALIGNMENT);// added code
	    //cb.setVisible(true); // Not needed
	    panel.add(cb);
	     */
	    JButton btn = new JButton("OK");
	    btn.setAlignmentX(Component.CENTER_ALIGNMENT); // added code
	    
	    btn.setMnemonic(KeyEvent.VK_D);
	    btn.setActionCommand("pelaa");
	    btn.setActionListener(this);
	    panel.add(btn);
	    
	    frame.setVisible(true); // added code
		}
	});
}
	public void actionPerformed(ActionEvent e) {
	    if ("pelaa".equals(e.getActionCommand())) {
	        new Pelilauta();
	    } else {
	        
	    }
	}
}
	/*
	    btn.addActionListener(new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            JButton btnn =  (JButton) e.getSource();
	            btnn.setText(btnn.isSelected() ? "pushed" : "push me");
	        }
	    });
}
    /*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                luoGUI(); 
            }
        });
    }

    private static void luoGUI() {
        System.out.println("Created GUI on EDT? "+
        SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("ELÄMÄMPELI VALIKKO");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.add(new Ikkuna());
        f.pack();
        f.setVisible(true);
    } 
}

class Ikkuna extends JPanel {

    private int squareX = 300;
    private int squareY = 300;
    private int squareW = 20;
    private int squareH = 20;

    public Ikkuna() {

        setBorder(BorderFactory.createLineBorder(Color.black));
      
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                newSquare(e.getX(),e.getY());
                Pelilauta peli = new Pelilauta();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                moveSquare(e.getX(),e.getY());
            }
        });
        
    }
    
    private void moveSquare(int x, int y) {
        int OFFSET = 1;
        if ((squareX!=x) || (squareY!=y)) {
            repaint(squareX,squareY,squareW+OFFSET,squareH+OFFSET);
            squareX=x-10;
            squareY=y-10;
            repaint(squareX,squareY,squareW+OFFSET,squareH+OFFSET);
        } 
    }
    private void newSquare(int x, int y) {
        int OFFSET = 1;
        if ((squareX!=x) || (squareY!=y)) {
        	paintImmediately(squareX,squareY,squareW+OFFSET,squareH+OFFSET);
            squareX=x-10;
            squareY=y-10;
            paintImmediately(squareX,squareY,squareW+OFFSET,squareH+OFFSET);
        } 
    }
    

    public Dimension getPreferredSize() {
        return new Dimension(400,400);
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);       
        g.drawString("Elamampeli!",10,20);
        g.setColor(Color.GREEN);
        g.fillRect(squareX,squareY,squareW,squareH);
        g.setColor(Color.BLACK);
        g.drawRect(squareX,squareY,squareW,squareH);
    }  
}
/*
//luodaan luokka jossa määritellään pelilaudan ruudukko
class grid{
	int hSoluja = 400/20; //PITÄÄ KORJATA JOS laudan asetuksia muutetaan.
	int wSoluja = 400/20;
	List<List<Solu>> grid = new ArrayList<List<Solu>>();
	public grid (){
		for (int i = 0; i < hSoluja; i++){
			for(int a = 0; a < wSoluja; a++){
				grid[i][a]=0; //asetetaan kaikki solut kuolleksi
				
			}
		}
	}
}
//luokassa solu määritellää yleinen ranenne kaikille pelilaudan soluille.
class Solu{
	int x;
	int y;
	boolean elossa = false;
	ArrayList<Solu> ymparoivat;
	public Solu(int x, int y, boolean elossa){
		this.x=x;
		this.y=y;
	}
	
}

*/