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
        super(640, 360, 1, false);
        //super(1280, 720, 1, false);
        Actor jogador = new PlayerRifle("left", "space", "right", "down", "z");
        addObject(jogador, 300, 50);
        
        
        prepare();
    }
    
    public Texto procurarTexto (String nomeTexto) {
        for (Texto texto : getObjects(Texto.class))
        {
            if (texto.nomeTexto == nomeTexto) return texto;
        }
        return null;
    }
    
    public void criarBala (int x, int y, int rotation, boolean espingarda) {
        if (espingarda) {
            Bala bala = new BalaEspingarda();
            addObject(bala, x, y);
            bala.setRotation(rotation);
        } else {
            Bala bala = new Bala();
            addObject(bala, x, y);
            bala.setRotation(rotation);
        }
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
        Alien alien = new Alien();
        addObject(alien,482,101);
        Alien alien2 = new Alien();
        addObject(alien2,121,112);
        
        Cristal cristal = new Cristal();
        addObject(cristal,356,194);
        cristal.setLocation(305,376);
    }
}
