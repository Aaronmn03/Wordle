import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Partida {
    private int numPalabras;
    private int ganadasJugador1;
    private int ganadasJugador2;
    private ArrayList<PartidaPalabra> listaPartidasPalabras;
    private Jugador[] listaJugadores;
    private Palabra[] listaPalabrasOcultas;
    
    //CONSTRUCTORES//
    public Partida(int nPalabras, Jugador[] listaJugadores){
        this.numPalabras = nPalabras;
        listaPartidasPalabras = new ArrayList <>(numPalabras);
        ganadasJugador1 = 0;
        ganadasJugador2 = 0;
        this.listaJugadores = listaJugadores;
    }
    
    //GETTERS-SETTERS//
    public ArrayList<PartidaPalabra> getListaPartidas(){
        return listaPartidasPalabras;
    }
    
    private Palabra[] getPalabrasOcultas(int nPalabras){
        Palabra[] listaPalabra = new Palabra[nPalabras];
        for (int i = 0; i<nPalabras;i++){
            listaPalabra[i] = new Palabra();
        }
        return listaPalabra;
    }
    
    private Palabra getPalabra(int index){
        return getPalabrasOcultas(numPalabras)[index];
    }
    
    private Jugador getJugador(int index){
        return listaJugadores[index];
    }

    public int getGanadasJugador1() {
        return ganadasJugador1;
    }

    public void setGanadasJugador1(int ganadasJugador1) {
        this.ganadasJugador1 = ganadasJugador1;
    }

    public int getGanadasJugador2() {
        return ganadasJugador2;
    }

    public void setGanadasJugador2(int ganadasJugador2) {
        this.ganadasJugador2 = ganadasJugador2;
    }
    
    
    //METODOS//
    public void anadirPartidaPalabra(){
        
        for (int i = 0;i < numPalabras;i++){
            PartidaPalabra partidaPalabra = crearPartidaPalabra(getPalabra(i));
            listaPartidasPalabras.add(partidaPalabra);
            sumarGanadosJugador(partidaPalabra.getGanador());
        }
    }
    
    private PartidaPalabra crearPartidaPalabra(Palabra palabraOculta){
        PartidaPalabra partidaPalabra = new PartidaPalabra(listaJugadores,palabraOculta);
        return partidaPalabra;
    } 
    
    public void sumarGanadosJugador(Jugador jugador){
        if (getJugador(0).equals(jugador)){
            setGanadasJugador1(getGanadasJugador1()+1);
        }else{
            setGanadasJugador2(getGanadasJugador2()+1);
        }
    }
}