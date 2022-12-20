import java.util.logging.Level;
import java.util.logging.Logger;

public class PistaLetra extends Pista{
    protected char letra;
    private boolean usada;
    public static final int COSTEPISTALETRA= 2;
    
    //CONSTRUCTORES//
    public PistaLetra(){
        super(COSTEPISTALETRA);
    }
    
    //GETTERS-SETTERS//
    public char getLetra(){
        return letra;
    }
    
    public char getLetraAleatoria(Jugador player, PartidaPalabra partidaPalabra){
        if ((player.getPuntos()) < coste){
            try {
                throw new NoSuficientesPuntosException();
            }catch (NoSuficientesPuntosException ex) {
                Logger.getLogger(PistaPalabra.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        else{
        player.setPuntos((player.getPuntos()) - coste );
        }
        return partidaPalabra.getPalabraOculta().getChar(getNumAleatorio());
    }
    
    public int getNumAleatorio(){
        int numRandom=(int)Math.round(Math.random() * Palabra.LETRAS);
        return numRandom;
    }
    
    //METODOS//
    public void Usar(){
        this.usada = true;
    }
}