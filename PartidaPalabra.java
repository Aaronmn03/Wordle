import java.util.ArrayList;

public class PartidaPalabra {
    
    private Jugador ganador;
    private int turno;
    private ArrayList<Intento> listaIntentos;
    private Jugador[] listaJugadores = new Jugador[2];
    private Palabra palabraOculta;
    private final int MAXINTENTOS= 10;
    
    //CONSTRUCTORES//
    public PartidaPalabra(Jugador[]listaJugadores,Palabra palabraOculta){   
        this.listaJugadores = listaJugadores;
        this.palabraOculta = palabraOculta;
        listaIntentos = new ArrayList <>(MAXINTENTOS);
        turno = 0;
    }
    
    //GETTERS-SETTERS//
    public int getTurno(){
        return turno;
    }
    public void setTurno(int i){
       this.turno = i;
    }
    
    public ArrayList<Intento> getListaIntentos(){
        return listaIntentos;
    }
    
    private Jugador getJugadorTurno(){
        return listaJugadores[turno];
    }
    
    public Jugador getGanador(){
        if(getNumeroIntentosJugador(listaJugadores[0])>getNumeroIntentosJugador(listaJugadores[1])){
            return listaJugadores[1];
        }
        return listaJugadores[0];
    }
    
    private void setGanador(Jugador jugador){
        this.ganador = jugador;
    }
    
    private int getNumeroIntentosJugador(Jugador jugador){
        int intentos = 0;
        for(Intento inten:listaIntentos){
            if(inten.getJugador().equals(jugador)){
                intentos++;
            }
        }
        return intentos;
    }
    
    public Palabra getPalabraOculta(){
        return palabraOculta;
    }
    
    //METODOS//
    public void añadirIntentos(Palabra palabraUsuario) throws PartidaFinalizadaException{
        try{
            if(turno != 0 && turno != 1){
                throw new PartidaFinalizadaException();
            }
        
            Intento inten = crearNuevoIntento(palabraUsuario);
            listaIntentos.add(inten);
        
            if(inten.verificarPalabra(palabraOculta,inten.getPalabraUsuario()) || getNumeroIntentosJugador(getJugadorTurno()) == 5)
            {
               asignarPuntosJugador(getJugadorTurno());
               turno++;
            }
            }catch (PartidaFinalizadaException ex) {  
                setGanador(getGanador());
        }
    }
    
    private Intento crearNuevoIntento(Palabra palabraUsuario){
        Intento inten = new Intento(palabraOculta,palabraUsuario,getJugadorTurno());
        inten.setNumIntentos(getNumeroIntentosJugador(getJugadorTurno())+1);
        return inten;
    }
    
    private void asignarPuntosJugador(Jugador jugador){
       int nIntentos=getNumeroIntentosJugador(jugador);
       jugador.setPuntos(jugador.getPuntos()+(6-nIntentos));
    }
}