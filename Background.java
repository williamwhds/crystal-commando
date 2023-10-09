import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Background extends World
{
    // Cristal
    private Cristal cristal;
    
    // Efeitos sonoros
    GreenfootSound somMusica = new GreenfootSound("Press Play.mp3");
    
    public Background()
    {
        super(640, 360, 1, false);
        //super(1280, 720, 1, false);
        
        somMusica.setVolume(20);
        
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
    
    public void setCristal (Cristal cristal) {
        this.cristal = cristal;
    }
    
    public Cristal getCristal () {
        return this.cristal;
    }

    private void prepare()
    {
        // Tocar música
        somMusica.play();
        
        // Nuvens
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
        
        // Cristal
        Cristal cristal = new Cristal();
        addObject(cristal,309,292);
        
        // Jogadores
        //Actor jogadorRifle = new PlayerRifle("left", "/", "right", "down", "*");
        //addObject(jogadorRifle, 300, 50);
        
        Actor jogadorEspingarda = new PlayerEspingarda("a", "g", "d", "s", "h");
        addObject(jogadorEspingarda, 300, 50);
        
        // Plataformas
        Bloco bloco = new Bloco();
        addObject(bloco,179,342);

        Bloco bloco2 = new Bloco();
        addObject(bloco2,539,342);
        
        //
        Inimigo alien = new AlienComum();
        addObject(alien,482,101);
        Inimigo alien2 = new AlienComum();
        addObject(alien2,121,112);
        
        
    }
}
