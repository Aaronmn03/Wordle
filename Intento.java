public class Intento {
    
    private int numIntentos;
    public static final int MAXNUMINTENTOS = 5;
    private Palabra palabra;
    private Jugador jugador;
    private Palabra palabraUsuario;
    
    //CONSTRUCTORES//
    public Intento(Palabra palabraOculta){
        this.palabra = palabraOculta;
        numIntentos = 0;
    }
    
    public Intento (Palabra palabraOculta,Palabra palabraUsuario,Jugador jugador){
        this(palabraOculta);
        this.palabraUsuario = palabraUsuario;
        this.jugador = jugador;
    }
    
    //GETTER-SETTERS//
    public int getNumIntentos(){
        return numIntentos;
    }
    
    public void setNumIntentos(int numIntentos) {
        this.numIntentos = numIntentos;
    }
    
    public Palabra getPalabraUsuario(){
        return palabraUsuario;
    }
    
    public Palabra getPalabraOculta(){
        return palabra;
    }
    
    public Jugador getJugador(){
        return jugador;
    }
    
    //METODOS//  
    public boolean verificarPalabra(Palabra palabraOculta,Palabra palabraUsuario){
        for(int i = 0;i<Palabra.LETRAS;i++){
             if(palabraUsuario.verficacionPalabra(palabraOculta)[i] != Estado.ESTAENPOSICION){
                 return false;
             }
        }
        return true;
    }
    
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (objeto == null || getClass() != objeto.getClass()) return false;
        Intento intento = (Intento) objeto; 
        return this.getPalabraOculta().equals(intento.getPalabraOculta())
                && this.getNumIntentos() == intento.getNumIntentos()
                && this.getJugador().equals(intento.getJugador())
                && this.getPalabraUsuario().equals(intento.getPalabraUsuario());
    }
}