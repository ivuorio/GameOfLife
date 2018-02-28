import java.util.ArrayList;


public class SoluTutkija {
	//metodi joka etsii ympäröivät elävät solu
	public static void paivitys(){
		/*for (Solu[] rivi : Peli.solut){
			for (Solu solu: rivi){
				if (naapurisolut(solu).size()==2) continue;
				else if (naapurisolut(solu).size()==3) solu.asetaElossa(true);
				else solu.asetaElossa(false);
			}
			
		}*/
	}
	public static ArrayList<Solu> naapurisolut(Solu s){
		ArrayList<Solu> naapurit=new ArrayList<Solu>();
		int omaX=s.annaX();
		int omaY=s.annaY();
		
		for (int x=omaX-1;x>=omaX+1;x++){
			for (int y=omaY-1;y>=omaY+1;y++){
				if (x>0 && x<Peli.solujaPerRivi && y>0 && y<Peli.solujaPerRivi){
					if(Peli.solut[x][y].annaElossa()) naapurit.add(Peli.solut[x][y]);
				}
			}
		}
		return naapurit;
	}
}

