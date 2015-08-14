import java.util.ArrayList;
import java.lang.String;

class Tablero
{
	private String[][] t;	
	Tablero()
	{
		this.t = new String[7][7];
		for(int i=0;i<t.length;i++){
			for(int j=0;j<t.length;j++){
				t[i][j] = "·";
			}
		}
		t[0][0] = " ";
		t[0][1] = " ";
		t[0][5] = " ";
		t[0][6] = " ";
		t[1][0] = " ";
		t[1][1] = " ";
		t[1][5]= " ";
		t[1][6]= " ";
		t[3][3]= "o";
		t[5][0]= " ";
		t[5][1]= " ";
		t[5][5]= " ";
		t[5][6]= " ";
		t[6][0]= " ";
		t[6][1]= " ";
		t[6][5]= " ";
		t[6][6]= " ";
	}
	// Devuelve el número actual de pegs en el tablero
	public int numPegs()
	{
		int peg = 0;
		for(int i=0;i<t.length;i++){
			for(int j=0;j<t.length;j++){
				if(t[i][j]=="·") peg++;
			}
		}
		return peg;
	}
	// Devuelve true si el tablero está solucionado
	// un tablero solucionado es aquel que queda un solo peg
	// y está situado en el centro del tablero (tablero inglés).
	public boolean solucionado()
	{
		int p = numPegs();
		if(p==1&&t[3][3]=="·")return true;
		return false;
	}
	// Determina si el movimiento “m” es legal en el tablero
	// Debe comprobar que existe un peg en el origen del movimiento
	// que casilla saltada existe un peg
	// que el movimiento es horizontal o vertical con salto de 2
	// y que hay hueco en el destino
	public boolean esMovimientoLegal(Movimiento m) 
	{
		Casilla destino = m.getDestino();
		Casilla saltada = m.getSaltada();
		Casilla origen = m.getOrigen();
		int xd = destino.getX();
		int yd = destino.getY();
		int xs = saltada.getX();
		int ys = saltada.getY();	
		int xo = origen.getX();
		int yo = origen.getY();
		if(xd>=0&&xd<=6&&yd>=0&&yd<=6&&xo>=0&&xo<=6&&yo>=0&&yo<=6&&xs>=0&&xs<=6&&ys>=0&&ys<=6){
				if((t[xd][yd]=="o")&&(t[xs][ys]=="·")&&(t[xo][yo]=="·")){
					return true;
				}
		}return false;
	}
	// Devuelve un array con los movimientos
	// legales del tablero
	public ArrayList<Movimiento> getMovimientos() 
	{
		Direccion[] dir = new Direccion[]{Direccion.NORTE,Direccion.SUR,Direccion.ESTE,Direccion.OESTE};
		ArrayList<Movimiento> movs = new ArrayList<Movimiento>();
		for(int i=0;i<t.length;i++){
			for(int j=0;j<t.length;j++){
				for(int d=0;d<dir.length;d++){
					Casilla casilla = new Casilla(i,j);
					Movimiento mov = new Movimiento(casilla,dir[d]);
					if(esMovimientoLegal(mov)) movs.add(mov);
				}
			}
		}		
		return movs;
	}
	// Realiza el movimiento “m” sobre el tablero si “m” es legal
	// Deja hueco en casilla origen e intermedio
	// pone un peg en destino
	public void hazMovimiento(Movimiento m) 
	{
		if(esMovimientoLegal(m)){
			Casilla origen = m.getOrigen();
			Casilla destino = m.getDestino();
			Casilla saltada = m.getSaltada();
			t[origen.getX()][origen.getY()] = "o";
			t[destino.getX()][destino.getY()] = "·";
			t[saltada.getX()][saltada.getY()] = "o";	
		}		
	}
	// Realiza el inverso del movimiento “m” sobre el tablero
	// Deja hueco en casilla destino
	// pone un peg en destino e intermedio
	public void deshazMovimiento(Movimiento m)
	{
		Casilla origen = m.getOrigen();
		Casilla destino = m.getDestino();
		Casilla saltada = m.getSaltada();
		t[origen.getX()][origen.getY()] = "·";
		t[destino.getX()][destino.getY()] = "o";
		t[saltada.getX()][saltada.getY()] = "·";
	}
	// Genera una representación única del tablero en forma de String
	@Override
	public String toString()
	{		
		String tablero = null;
		for(int i=0;i<t.length;i++){
			for(int j=0;j<t.length;j++){
				tablero+=t[i][j];
			}
		}		
		return tablero;		
	}
	// Imprime por la salida standard el tablero
	public void print()
	{
		for(int i=0;i<t.length;i++){
			for(int j=0;j<t.length;j++){
				//for(int n=0;n<d;n++){
					System.out.print(t[i][j]+"\t");
				}
			//}
			System.out.println("\n");			
		}System.out.println("\n");
	}
}