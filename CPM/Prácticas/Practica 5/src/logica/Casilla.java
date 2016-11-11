package logica;

public class Casilla {
	
	private int valor;
	private boolean tree;
	private boolean blackHole;
	
	public Casilla() 
	{
		setValor (50);
		tree= false;
		blackHole= false;
	}
	
	public boolean hasTree()
	{
		return tree;
	}
	
	public boolean hasBlackHole()
	{
		return blackHole;
	}
	
	public void setBlackHole(boolean blackHole)
	{
		this.blackHole= blackHole;
	}
	
	public void setTree(boolean isTree)
	{
		this.tree= isTree;
	}
	
	public int getValor() {
		return valor;
	}
	
	private void setValor(int valor) {
		this.valor = valor;
	}

}
