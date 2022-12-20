import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

enum Estado
{
    ESTAENPOSICION,NOESTAENPALABRA,ESTAENPALABRAYNOPOSICION;
}

public class Palabra {
    public final static int LETRAS=5;
    private char[] palabra = new char[LETRAS];
    
    public Palabra (){
            palabra= new char[LETRAS];
    }
    
    public Palabra(char p[]){
        this.palabra=p;
    }
    
    public Palabra(String s){
        this();
        for (int i = 0; i <LETRAS; i++){
            palabra[i]=s.charAt(i);
        }
    }
    
    //GETTERS-SETTERS//
    public char[] getPalabra(){
        return palabra;
    }
    
    public char getChar(int i){
        return palabra[i];
    }
    
    public void setPalabra(char[] palabra){
        this.palabra = palabra;
    }
    
    //METODOS//
    @Override
    public String toString() {
        String aux = "palabra: ";
        for (int i = 0; i < LETRAS;i++){
            aux += palabra[i];
        }
        return aux;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Palabra p = (Palabra) o; 
        return (Arrays.equals(this.getPalabra(), p.getPalabra()));
    }
    
    public boolean pertenece(char c)
    {
        for(int i = 0;i<LETRAS;i++){
            if(this.getChar(i)== c){
                return true;
            }
        }
        return false;
    }
    
    public Estado[] verficacionPalabra(Palabra p){
        Estado[] aux = new Estado[LETRAS];
        try{
            for(int i = 0 ; i < LETRAS ; i++){
                if (getChar(i)<'a' || getChar(i)> 'z'){
                    throw new OtroSimboloException();
                }
        }
        for(int i = 0;i<LETRAS;i++){
            if(this.getPalabra()[i] == p.getPalabra()[i]){
                aux[i] = Estado.ESTAENPOSICION;
            }else if(this.pertenece(p.getChar(i))){
                aux[i] = Estado.ESTAENPALABRAYNOPOSICION;
            }else{
                aux[i] = Estado.NOESTAENPALABRA;
            } 
        }
        
        }catch(OtroSimboloException ex){
            Logger.getLogger(Palabra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }
}