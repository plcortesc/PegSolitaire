
public class Movimiento 
{
	private Casilla origen;
	private Direccion dir;
	public Movimiento(Casilla origen, Direccion dir)
	{
		this.origen = origen;
		this.dir = dir;
	}
	// Devuelve la casilla origen
	public Casilla getOrigen()
	{
		return origen;
	}
	// Devuelve la direccion del movimiento
	public Direccion getDir()
	{
		return dir;
	}
	// Devuelve la casilla destino del movimiento
	public Casilla getDestino()
	{
		Casilla destino;
		int x = origen.getX();
		int y = origen.getY();
		int xd;
		int yd;		
		if(dir==Direccion.NORTE){ 
			xd=x-2;
			yd=y;
			destino = new Casilla(xd,yd);
			return destino;
		}else if(dir==Direccion.SUR){
			xd=x+2;
			yd=y;
			destino = new Casilla(xd,yd);
			return destino;
		}else if(dir==Direccion.ESTE){
			xd=x;
			yd=y+2;
			destino = new Casilla(xd,yd);
			return destino;
		}else if(dir==Direccion.OESTE){
			xd=x;
			yd=y-2;
			destino = new Casilla(xd,yd);
			return destino;
		}
		return null;			
	}
	// Devuelve la casilla sobre la que saltaría el PEG al moverse
	public Casilla getSaltada()
	{
		Casilla saltada;
		int x = origen.getX();
		int y = origen.getY();
		int xs;
		int ys;
		if(dir==Direccion.NORTE){ 
			xs=x-1;
			ys=y;
			saltada = new Casilla(xs,ys);
			return saltada;
		}else if(dir==Direccion.SUR){
			xs=x+1;
			ys=y;
			saltada = new Casilla(xs,ys);
			return saltada;
		}else if(dir==Direccion.ESTE){
			xs=x;
			ys=y+1;
			saltada = new Casilla(xs,ys);
			return saltada;
		}else if(dir==Direccion.OESTE){
			xs=x;
			ys=y-1;
			saltada = new Casilla(xs,ys);
			return saltada;
		}
		return null;
	}
}