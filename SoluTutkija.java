import java.util.ArrayList;


public class SoluTutkija {
	//metodi joka etsii ympäröivät elävät solu
	public static void paivitys(){
		ArrayList<Solu> asetaEloon = new ArrayList<Solu>();
		ArrayList<Solu> asetaKuolleeksi = new ArrayList<Solu>();
		for (Solu[] rivi : Peli.solut){
			for (Solu solu: rivi){
				ArrayList<Solu> naapurisolut = new ArrayList<Solu>();
				naapurisolut=naapurisolut(solu);
				if (naapurisolut.size()==2); //System.out.println("ei muuteta"); //S2
				else if (naapurisolut.size()==3) {asetaEloon.add(solu); } //S3 ja B3
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
	public static ArrayList<Solu> naapurisolut(Solu s){
		ArrayList<Solu> naapurit=new ArrayList<Solu>();
		int omaX=s.annaX();
		int omaY=s.annaY();
		//System.out.print(" tutkitaan solua"+ omaX +","+omaY );
		
		for(int x=omaX-1; x<=omaX+1; x++){
			//System.out.print("Tutkitaan riviä"+x );
			for (int y=omaY-1;y<=omaY+1;y++){
				//System.out.print(tytkitaan riviä x );
				if (x>=0 && x<Peli.solujaPerRivi && y>=0 && y<Peli.solujaPerRivi &&(x!=omaX || y!=omaY)){
					if((Peli.solut[x][y]).annaElossa()){
						naapurit.add(Peli.solut[x][y]);
						//System.out.println("Solu" +x+","+y+ "lisätty. ");
					}
					
				}
			}
		}
		//if (naapurit.size()>0) System.out.println("Naapurit solulle "+omaX+","+omaY+". ");
		return naapurit;
	}
	public static void paivita(){
		Peli.solut[10][10].asetaElossa(true);
		Peli.solut[10][11].asetaElossa(true);
		Peli.solut[10][12].asetaElossa(false);
		Peli.solut[11][10].asetaElossa(false);
		Peli.solut[12][10].asetaElossa(true);
		Peli.solut[12][11].asetaElossa(true);
		Peli.solut[12][12].asetaElossa(true);
        Peli.solut[11][12].asetaElossa(true);
	}
}

