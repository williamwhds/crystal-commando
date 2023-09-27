import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cristal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cristal extends Colisor
{
    private int vida = 20;
    
    
    private Texto textoVida = new Texto("VIDA DO CRISTAL: " + String.valueOf(vida), 32, "cristal.vida");
    
    public Cristal () {
        GreenfootImage sprite = getImage(); // Pegando sprite
        sprite.scale(sprite.getWidth()/2,sprite.getHeight()/2); // Alterando largura e altura
    }
    
    protected void addedToWorld (World world) {
        getWorld().addObject(textoVida, getX(), getY());
    }
    
    public void atualizarTextoVida () {
        if (getWorld() != null) {
            Background bg = (Background)getWorld(); 
            Texto txt = bg.procurarTexto("cristal.vida");
            txt.setImage(new GreenfootImage("VIDA DO CRISTAL: " + String.valueOf(vida), 32, null, null));
        }
    }
    
    public void act()
    {
       
    }
    
    public void setVida (int vida) {
        this.vida = vida;
    }
    
    public int getVida () {
        return this.vida;
    }
}
