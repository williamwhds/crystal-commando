import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Jogador controlavel.
 * 
 * @author (William Oliveira) 
 * @version (a version number or a date)
 */

// A fazer:
// Função key touch (retorna true somente uma vez ao pressionar)
// Armas
// Prender o jogador na tela
// Colisão horizontal (se necessário)

public class Jogador extends Actor
{
    private String upKey, leftKey, downKey, rightKey;
    private int velVertical = 0;
    private int maxVelVertical = 16;
    private int velHorizontal = 3;
    private int gravidade = 1;
    private int maxPulos = 1;
    private int pulos = 1;
    private int alturaPulo = 10;
    private int lado = 0;
    
    public Jogador (String leftKey, String upKey, String rightKey, String downKey) {
        this.upKey      = upKey;
        this.leftKey    = leftKey;
        this.downKey    = downKey;
        this.rightKey   = rightKey;
    }
    
    public boolean noChao () {
        if (getOneObjectAtOffset(0, (getImage().getHeight()/2) + velVertical, Colisor.class) != null) {
            return true;
        }
        return false;
    }
    
    public boolean cimaPressionado () {
        return Greenfoot.isKeyDown(upKey);
    }
    
    public boolean esqPressionado () {
        return Greenfoot.isKeyDown(leftKey);
    }
    
    public boolean dirPressionado () {
        return Greenfoot.isKeyDown(rightKey);
    }
    
    public boolean baixoPressionado () {
        return Greenfoot.isKeyDown(downKey);
    }
    
    public void cair () {
        if (velVertical > maxVelVertical) velVertical = maxVelVertical;
        setLocation(getX(), getY() + velVertical);
        velVertical += gravidade;
    }
    
    public void verificarPulo () {
        if (cimaPressionado()  && pulos>0) {
            velVertical = -alturaPulo;
            setLocation(getX(), getY() + velVertical);
            pulos = pulos - 1;
        }
    }
    
    public void verificarLado () {
        int esquerdo = esqPressionado() ? 1 : 0;    // Se a condicional for true, retorne 1.
        int direito = dirPressionado() ? 1 : 0;     // Caso contrário, retorne 0.
        
        lado = esquerdo - direito;  // -1 se estiver se movendo pra esquerda, 1 se direita, 0 se os dois ou nenhum.
    }
    
    public void movimentar () {
        verificarLado();
        setLocation(getX() - (velHorizontal * lado), getY());
        
        if (!noChao()) {
            cair();
        } else {
            velVertical = 0;
            pulos = maxPulos;
        }
        
        verificarPulo();
    }
    
    public void act()
    {
        movimentar();
    }
}
