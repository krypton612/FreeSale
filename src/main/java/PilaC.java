class PilaC extends Pila_ColaC
{
	private int tope;
	public  PilaC()
	{
		tope = 0;
	}
	public boolean esVacia()
	{
		if(tope == 0)
		   return true;
		else
		   return false;
	}
	public boolean esLlena()
	{
		if(tope == MAX)
		   return true;
		else
		   return false;
	}
	public void adicionar (String e)
	{
		
		if(esLlena())
		    System.out.println("Pila Llena");
		else
		{
			tope = tope + 1;
			v[tope]=e;
		}
	}
	public String eliminar ()
	{
		String e = "";
		if(esVacia())
		    System.out.println("Pila Vacia");
		else
		{
			e = v[tope];
			tope = tope - 1;
		}       
		return (e);
	}
	public void leer (int n)
	{
		String e;
		int i;
		for (i=1 ; i<=n ; i++)
		{
			System.out.print("Elemento? : ");
			e = Leer.dato ();
			adicionar (e);
		}
	}
	public void mostrar ()
	{
		String e;
		PilaC aux = new PilaC ();
		while(!esVacia())
		{
			e = eliminar ();
			System.out.print ("\n" + e);
			aux.adicionar (e);
		}
		vaciar (aux);
	}
	public int nroElems2 ()
	{
		int e, c = 0;
		PilaC aux = new PilaC ();
		while (!esVacia ())
		{
			aux.adicionar (eliminar());
			c++;
		}
		vaciar (aux);
		return (c);
	}
	public int nroElems1 ()
	{
		return (tope);
	}
	public void copiar (PilaC a)
	{
		PilaC p1 = new PilaC ();
		PilaC p2 = new PilaC ();
		String e;
		while (!a.esVacia ())
		{
			e = a.eliminar ();
			p1.adicionar (e);
			p2.adicionar (e);
		}
		vaciar (p1);
		a.vaciar (p2);
	}
	public int buscar (String x)
	{
		int sw = 0, pos = -1;
		String e;
		PilaC aux = new PilaC ();
		while (!esVacia ())
		{
			e = eliminar ();
			aux.adicionar (e);
			if (x.equals (e) && sw == 0)
			{
				sw = 1;
				pos = nroElems1 () + 1;
			}
		}
		vaciar (aux);
		return (pos);
	}
	public void vaciar (PilaC p)
	{
		while (!p.esVacia ())
		    adicionar (p.eliminar ());
	}
	public void elimina (int pos)
	{
		PilaC aux = new PilaC ();
		int c = 0;
		String e;
		aux.vaciar (this);
		while (!aux.esVacia ())
		{
			e = aux.eliminar ();
			c++;
			if(c!= pos)
			   adicionar (e);
		}
	}
	public void adicionALmetodo(String dato) {
		String e;
		PilaC aux = new PilaC();
		while (!esVacia()) {
				e = eliminar();
				aux.adicionar(e);
		}
		adicionar(dato);
		vaciar(aux);
	}
	public void apilandoExtra()
	{
		String e;

		System.out.print(" Digite su elemento a apilar : ");
		e = Leer.dato ();
		if ( e.charAt(0) == 'a' )  {
			adicionar(e);
			return;
		}
		if ( e.charAt(0) == 'e' )  {
			adicionar(e);
			return;
		}
		if ( e.charAt(0) == 'i' )  {
			adicionar(e);
			return;
		}
		if ( e.charAt(0) == 'o' )  {
			adicionar(e);
			return;
		}
		if ( e.charAt(0) == 'u' )  {
			adicionar(e);
			return;
		}
		
		adicionALmetodo(e);
		
	}
}
