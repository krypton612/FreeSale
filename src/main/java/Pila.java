class Pila extends Pila_Cola{
    private int tope;
    // constructor
    
    public Pila(){
        tope = 0;
    }
    
    public boolean esVacia(){
        if (tope == 0){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean esLlena(){
        if (tope == MAX){
            return true;
        }
        else {
            return false;
        }
    }
    public void adicionar(int e){
        if (esLlena()){
            System.out.println(" Pila Llena !");
        }
        else {
            tope = tope + 1;
            v[tope] = e;
        }
    }
    public int eliminar(){
        int e = Integer.MIN_VALUE;
        if (esVacia()) {
            
        }
        else {
            e = v[tope];
            tope = tope - 1;
        }
        return e;
    }
    public void leer(int n){
        int i,e;
        for (i = 0; i < n; i++) {
            System.out.print("Elemento? : ");
            e = Leer.datoInt();
            adicionar(e);
        }
    }
    
    public void mostrar(){
        int e;
        Pila aux = new Pila();
        
        while (!esVacia()){
            e = eliminar();
            System.out.print("\n"+e);
            aux.adicionar(e);
        }
        vaciar(aux);
    }
    public int nroElems2(){
        int e, c = 0;
        Pila aux = new Pila();
        while (!esVacia()){
            aux.adicionar(eliminar());
            c++;
        }
        vaciar(aux);
        return c;
    }
    public int nroElems1(){
        return (tope);
    }
    public void eliminar(int e){
        Pila aux = new Pila();
        int d;
        while (!esVacia()){
            d = eliminar();
            if (d != e) {
                aux.adicionar(d);
            }
        }
        vaciar(aux);
    }
    public void copiar(Pila a){
        Pila p1 = new Pila();
        Pila p2 = new Pila();
        int e;
        while (!a.esVacia()){
            e = a.eliminar();
            p1.adicionar(e);
            p2.adicionar(e);
        }
        vaciar(p1);
        a.vaciar(p2);
    }
    public void vaciar(Pila p){
        while (!p.esVacia()){
            adicionar (p.eliminar());
        }
        return;
    }
    public int buscar(int x){
        int e, sw = 0, pos = -1;
        Pila aux = new Pila();
        while (!esVacia()) {
            e = eliminar();
            aux.adicionar(e);
            if (x == e && sw == 0) {
                sw = 1;
                pos = nroElems1() + 1;
            }
        }
        vaciar(aux);
        return (pos);
    }
    
    public void elimina(int pos){
        Pila aux = new Pila();
        int c = 0;
        int e;
        aux.vaciar(this);
        while (!aux.esVacia()){
            e = aux.eliminar();
            c++;
            if (c != pos) {
                adicionar(e);
            }
            
        }
    }
    public void eliPares(){
        Pila aux = new Pila();
        int e;
        while(nroElems1() != 0){
            e = eliminar();
            if (e%2 == 0 ) {
                aux.adicionar(e);
            }
            vaciar(aux);
        }
    }
    public int minimo(){
        int min = Integer.MAX_VALUE, e;
        Pila aux = new Pila();
        if (nroElems2() > 0) {
            min = eliminar();
            aux.adicionar(min);
            while (!esVacia()){
                e = eliminar();
                if (e < min) {
                    min = e;
                }
            }
            vaciar(aux);
            
        }
        return (min);
    }
    public void eliminar_repetidos(){
        Pila pnr = new Pila();
        Pila aux = new Pila();
        
        int e1, e2;
        
        while (!esVacia()){
            e1 = eliminar();
            pnr.adicionar(e1);
            while(!esVacia()){
                e2 = eliminar();
                if (e2 != e1) {
                    aux.adicionar(e2);
                }
            }
            vaciar(aux);
            
        }
        vaciar(pnr);
    }
    public void destroy(){
        for (int i = 0; i < v.length; i++) {
            eliminar();
        }
        v = new int[MAX];
    }
    public void ultimaPosicion(){
        int e;
        int ultimaPos=0;
        Pila aux = new Pila();
        
        while (!esVacia()){
            if (ultimaPos == aux.nroElems1()) {
                e = aux.eliminar();
            }
            else {
                e = aux.eliminar();
                ultimaPos++;
            }
        }
        vaciar(aux);
    }
    public void borrarUltimpElemento(int n){
        int e;
        Pila aux = new Pila();
        
        for (int i = 1; i < v.length; i++) {
            if (i == n) {
                
            }
        }
        vaciar(aux);
    }
    public void borrarElementoMayor(int n){
        int e, mayor=0;
        Pila aux = new Pila();
        
        for (int i = 1; i < v.length; i++) {
            if (i == n) {
                elimina(buscar(mayor));
                break;
            }
            else {
                if (v[i] > mayor) {
                    mayor = v[i];
                }
            }
        }
        vaciar(aux);
    }
    public void ApilandoEnOrdenFinal() {
        
    }
    public void apilandoEnOrden() {
        Pila aux = new Pila();
        int e, cantidad=0;        
        for (int k = 0; k < nroElems1(); k++) {

            e = eliminar();
            cantidad++;
            for (int j = 1; j <= nroElems1(); j++) {
                
                if (e == v[j]) {
                    cantidad++;

                }

            }
            for (int i = 0; i < cantidad; i++) {
                aux.adicionar(e);
            }
            cantidad=0;
            
        }
        destroy();
        vaciar(aux);
    }
}
