import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Texto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Texto extends Actor
{
    public String nomeTexto; // Para identificar o objeto
    public Texto (String texto, int tamanhoFonte, String nomeTexto) {
        setImage(new GreenfootImage(texto, tamanhoFonte, null, null));
        this.nomeTexto = nomeTexto;
    }
    public void act()
    {
        // Add your action code here.
    }
}
