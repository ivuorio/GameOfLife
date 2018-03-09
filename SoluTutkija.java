import java.util.ArrayList;


public class SoluTutkija {
	//metodi joka etsii ympäröivät elävät solu
	public static void paivitys(){
		ArrayList<Solu> asetaEloon = new ArrayList<Solu>();
		ArrayList<Solu> asetaKuolleeksi = new ArrayList<Solu>();
		for (Solu[] rivi : Peli.solut){
			for (Solu solu: rivi){
				int n=naapuriSolut(solu);
				if (n==2); //System.out.println("ei muuteta"); //S2
				else if (n==3) {asetaEloon.add(solu); } //S3 ja B3
				else asetaKuolleeksi.add(solu);
			}
			
		}
		for (Solu s:asetaEloon){
			s.asetaElossa(true);
		}
		for (Solu s:asetaKuolleeksi){
			s.asetaElossa(false);
		}
		
	}
	public static int naapuriSolut(Solu s){
		int maara=0;
		int omaX=s.annaX();
		int omaY=s.annaY();
		//
		
		for(int x=omaX-1; x<=omaX+1; x++){
			//
			for (int y=omaY-1;y<=omaY+1;y++){
				//
				if (x>=0 && x<Peli.solujaPerRivi && y>=0 && y<Peli.solujaPerRivi &&(x!=omaX || y!=omaY)){
					if((Peli.solut[x][y]).annaElossa()){
						maara++;
					}
					
				}
			}
		}
		return maara;
	}
}

