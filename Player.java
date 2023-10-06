import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Jogador controlavel.
 * 
 * @author (William Oliveira) 
 * @version (a version number or a date)
 */

// A fazer:
// Prender o jogador na tela
// Colisão horizontal (se necessário)

public class Player extends ObjetoAnimado
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
    private int ultimoLado = 0;
    private boolean olhandoEsquerda = false;
    
    private GreenfootImage[] animPlayerParado = {new GreenfootImage("PlayerRifleParado.png")};
    
    private String estado = "parado";
    
    public Player (String leftKey, String upKey, String rightKey, String downKey) {
        this.upKey      = upKey;
        this.leftKey    = leftKey;
        this.downKey    = downKey;
        this.rightKey   = rightKey;
        
        animPlayerParado[0].scale(animPlayerParado[0].getWidth()*2, animPlayerParado[0].getWidth()*2);
    }
    
    public boolean noChao () {
        if (getOneObjectAtOffset(0, (getImage().getHeight()/2) + velVertical, Colisor.class) != null) {
            return true;
        }
        return false;
    }
    
    public boolean andando () {
        if (esqPressionado() || dirPressionado()) {
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
        
        lado = direito - esquerdo;  // -1 se estiver se movendo pra esquerda, 1 se direita, 0 se os dois ou nenhum.
        
        if (lado == 1) {
            ultimoLado = 1;
        } else if (lado == -1) {
            ultimoLado = -1;
        }
    }
    
    public void movimentar () {
        verificarLado();
        setLocation(getX() + (velHorizontal * lado), getY());
        
        if (!noChao()) {
            cair();
        } else {
            velVertical = 0;
            pulos = maxPulos;
        }
        
        verificarDirLado();
        verificarPulo();
    }
    
    public boolean getOlhandoEsquerda () {
        return this.olhandoEsquerda;
    }
    
    public GreenfootImage[] getAnimacaoAtual () {
        return super.getAnimacaoAtual();
    }
    
    public void animar () {
        super.animar();
    }
    
    public void setAnimacaoAtual (GreenfootImage[] anim) {
        super.setAnimacaoAtual(anim);
    }
    
    public void verificarDirLado() {
        if (ultimoLado == -1 && !olhandoEsquerda) { // Se o jogador estiver indo para a esquerda
            olhandoEsquerda = true;
        } else if (ultimoLado == 1 && olhandoEsquerda) { // Se o jogador estiver indo para a direita
            olhandoEsquerda = false;
        }
    }
    
    // Estados
    
    public void setEstado (String estado) {
        this.estado = estado;
    }
    
    public String getEstado () {
        return this.estado;
    }
    
    public void act()
    {
        movimentar();
        setAnimacaoAtual(animPlayerParado);
        animar();
    }
}
