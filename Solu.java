
public class Solu {
	private int x;
	private int y;
	private boolean elossa = false; //lähtöarvoisesti solu on kuollut
	
	public Solu(int x, int y){
		this.x=x;
		this.y=y;
	}
	//************getterit****************
	public int annaX(){
		return x;
	}
	public int annaY(){
		return y;
	}
	public boolean annaElossa(){
		return elossa;
	}
	//***************setterit**************
	public void asetaElossa(boolean elossa){
		this.elossa=elossa;
	}
	public void asetaX(int x){
		this.x=x;
	}
	public void asetaY(int y){
		this.y=y;
	}
	//vaihtaa solun tilan
	public void vaihdaElossa(){
		this.elossa = !this.elossa;
	}
}
