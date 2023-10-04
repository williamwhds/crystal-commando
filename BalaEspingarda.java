import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BalaEspingarda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BalaEspingarda extends Bala
{
    int contador = 0;
    /**
     * Act - do whatever the BalaEspingarda wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean foraDaTela () {
        return super.foraDaTela();
    }
    
    public void destruir () {
        super.destruir();
    }
    
    public void act()
    {
        super.act();
        contador += 1;
        
        if (foraDaTela() || contador == 15) destruir();
    }
}
