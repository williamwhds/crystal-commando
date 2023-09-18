import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{

    /**
     * Constructor for objects of class Background.
     * 
     */
    public Background()
    {
        super(600, 400, 1);
        
        Actor bloco = new Bloco();
        addObject(bloco, 300, 300);
        
        Actor jogador = new Jogador("left", "up", "right", "down");
        addObject(jogador, 300, 50);
    }
}
