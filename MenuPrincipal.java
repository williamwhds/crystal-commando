import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MenuPrincipal extends World
{
    public MenuPrincipal()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 360, 1);
        GreenfootSound musica = new GreenfootSound("Press Play.mp3");
        musica.setVolume(75);
        musica.playLoop();
    }
}
