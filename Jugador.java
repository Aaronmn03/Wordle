public class Jugador {
    private String nombreUsuario;
    private int puntos;
    private int partidasJugadas;
    private int partidasGanadas;
    private int partidasPerdidas;
    private int partidasEmpatadas;
    
    //CONSTRUCTORES//
    public Jugador (String nombre) {
        if (nombre != null){ 
            this.nombreUsuario = nombre;
        }
        else{
            this.nombreUsuario = "";
        }	
        this.puntos = 0;
        this.partidasJugadas = 0;
        this.partidasGanadas = 0;
        this.partidasPerdidas = 0;
        this.partidasEmpatadas = 0;
    }

    //GETTERS-SETTERS//
    public String getNombreUsuario(){
        return nombreUsuario;
    }
    
    public int getPuntos(){
        return puntos;
    }
    
    public int getPartidasJugadas(){
        return partidasJugadas;
    }
    
    public int getPartidasGanadas(){
        return partidasGanadas;
    }
    
    public int getPartidasPerdidas(){
        return partidasPerdidas;
    }
    
    public int getPartidasEmpatadas(){
        return partidasEmpatadas;
    }

    public void setNombreUsuario(String alias){
        nombreUsuario = alias;
    }
    
    public void setPuntos(int n){
            puntos = n;
    }
    
    public void setPartidasJugadas(int n){
        partidasJugadas = n;
    }
    
    public void setPartidasGanadas(int n){
        partidasGanadas = n;
    }
    
    public void setPartidasPerdidas(int n){
        partidasPerdidas = n;
    }
    
    public void setPartidasEmpatadas(int n){
        partidasEmpatadas = n;
    }

    @Override
    public String toString(){        
        String aux ;
        aux = nombreUsuario+", \n-Tienes: "+ puntos +"Ptos.\n-Has jugado" + partidasJugadas +" de las cuales has ganado: "+partidasGanadas+" y has perdido "+partidasPerdidas+"\n";
        return  aux;
    }
    
    @Override
    public boolean equals(Object objeto){
        if (this == objeto){
            return true;
	}
	if (objeto == null || getClass() != objeto.getClass ()){ 
            return false;
        }
        Jugador otroJugador = (Jugador) objeto;
	return this.nombreUsuario.equals(otroJugador.getNombreUsuario());
    }
}