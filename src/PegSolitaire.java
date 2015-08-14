import java.util.HashSet;
import java.util.ArrayList;
import java.lang.String;


public class PegSolitaire
{	
	private static int numEstados = 0, numVistos = 0;
	// Devuelve TRUE cuando resuelve el tablero. 
	// Resolucion del tablero mediante Backtracking.
	public static boolean resuelve(Tablero t, HashSet<String> visitados, int depth) 
	{
		if(t.solucionado()) return true;
		ArrayList<Movimiento> movs = t.getMovimientos();
		for(Movimiento m:movs){
			t.hazMovimiento(m);
			numEstados++;
			t.print();
			if(!visitados.contains(t.toString())){
				visitados.add(t.toString());
				numVistos = visitados.size();
				System.out.println("V: " + numVistos + ", " + (numVistos*100)/numEstados + "%");
				System.out.println("\n");
				if(resuelve(t,visitados,++depth))return true;
				t.deshazMovimiento(m);
				numEstados++;
				t.print();
			}
		}
		return false;			
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		HashSet<String> visitados = new HashSet<String>();
		Tablero t = new Tablero();
		t.print();
		visitados.add(t.toString());
		if (resuelve(t, visitados, 1))
		{
			System.out.println("Tablero resuelto");
			System.out.println("\n");
		}
		else
			System.out.println("Tablero NO resuelto");
			t.print();
			System.out.println("Estados: " + numEstados + " Vistos: " + numVistos +	" fracción: " + (numVistos*100)/numEstados + "%");
	}
}