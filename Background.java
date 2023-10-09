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
        
        prepare();
    }
    
    public Texto procurarTexto (String nomeTexto) {
        for (Texto texto : getObjects(Texto.class))
        {
            if (texto.nomeTexto == nomeTexto) return texto;
        }
        return null;
    }
    
    public void criarBalaRifle (int x, int y, int rotation) {
        Bala bala = new Bala();
        addObject(bala, x, y);
        bala.setRotation(rotation);
    }
    
    public void criarBalaEspingarda (int x, int y, int rotation) {
        Bala bala = new BalaEspingarda();
        addObject(bala, x, y);
        bala.setRotation(rotation);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Cristal cristal = new Cristal();
        addObject(cristal,309,292);
        
        Actor jogador = new PlayerRifle("left", "space", "right", "down", "z");
        addObject(jogador, 300, 50);
        
        Inimigo alien = new AlienComum();
        addObject(alien,482,101);
        Inimigo alien2 = new AlienComum();
        addObject(alien2,121,112);

        //Cristal cristal = new Cristal();
        //addObject(cristal,356,194);
        //cristal.setLocation(305,376);

        Bloco bloco = new Bloco();
        addObject(bloco,179,342);

        Bloco bloco2 = new Bloco();
        addObject(bloco2,539,342);

        NuvemMedia nuvemMedia = new NuvemMedia(1);
        addObject(nuvemMedia,580,115);

        NuvemMedia nuvemMedia2 = new NuvemMedia(1);
        addObject(nuvemMedia2,109,35);

        NuvemPequena nuvemPequena = new NuvemPequena(2);
        addObject(nuvemPequena,434,53);

        NuvemPequena nuvemPequena2 = new NuvemPequena(2);
        addObject(nuvemPequena2,181,136);

        NuvemMedia nuvemMedia3 = new NuvemMedia(1);
        addObject(nuvemMedia3,326,82);
        
        
    }
}
