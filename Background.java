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
        super(600, 400, 1, false);

        Actor jogador = new Jogador("left", "space", "right", "down");
        addObject(jogador, 300, 50);
        
        Administrador adm = new Administrador(this);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Bloco bloco = new Bloco();
        addObject(bloco,35,370);
        Bloco bloco2 = new Bloco();
        addObject(bloco2,575,370);
    }
}
