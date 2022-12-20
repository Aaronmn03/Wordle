import java.util.logging.Level;
import java.util.logging.Logger;

public class PistaPalabra extends Pista {
    private Palabra palabra;
    private Jugador jugador;
    public static final int COSTEPISTAPALABRA = 5;

    public PistaPalabra(){
        super(COSTEPISTAPALABRA);
    }
    public Palabra getPalabra (Jugador player, PartidaPalabra partidaPalabra){
        if ((player.getPuntos()) < coste){
            try {
                throw new NoSuficientesPuntosException();
            }catch (NoSuficientesPuntosException ex) {
                Logger.getLogger(PistaPalabra.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        else{
        player.setPuntos((player.getPuntos()) - coste);
        } return partidaPalabra.getPalabraOculta();
    }
}