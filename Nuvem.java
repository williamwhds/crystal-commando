import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Nuvem extends Actor
{
    private int counter = 0;
    private int velocidade;
    
    public Nuvem (int velocidade) {
        this.velocidade = velocidade;
    }
    
    public void mover () {
        counter += 1;
        if (counter >= 5) {
            counter = 0;
            move(-velocidade);
        } 
    }
    
    public void voltarPraTela () {
        if (getWorld() != null) {
            int largura = getWorld().getWidth();
            
            if (getX() < 0 - getImage().getWidth()) {
                setLocation(largura, getY());
            }
        }
    }
    
    public void act()
    {
        mover();
        voltarPraTela();
    }
}
