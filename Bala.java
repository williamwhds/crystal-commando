import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

// FAZER BALA SUMIR QUANDO ELA SAI DO CENARIO <<<<<<<<<<<<<<<<

public class Bala extends Actor
{
    int speed = 12;
    
    public Bala () {
    }
    
    public boolean foraDaTela () {
        if (getWorld() == null) return false;
        
        if (getX() > getWorld().getWidth() || getX() < 0 || getY() > getWorld().getHeight() || getY() < 0) {
            return true;
        }
        return false;
    }
    
    public void destruir () {
        if (getWorld() != null) {
            getWorld().removeObject(this);
        }
    }
    
    public void criarExplosao () {
        if (getWorld() != null) {
            getWorld().addObject(new Explosao(), getX(), getY());
        }
    }
    
    public void danificandoInimigo () { 
        Inimigo inimigo = (Inimigo)getOneIntersectingObject(Inimigo.class);
        if (inimigo != null) {
            inimigo.setVida(inimigo.getVida() - 1);
            criarExplosao();
            destruir();
        }
    }
    /**
     * Act - do whatever the Bala wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        danificandoInimigo();
        move(speed);
        if (foraDaTela()) destruir();
    }
}
