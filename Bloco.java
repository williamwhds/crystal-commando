import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bloco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bloco extends Actor
{
    public Bloco () {
        GreenfootImage sprite = getImage(); // Pegando sprite
        sprite.scale(300,sprite.getHeight()*2); // Alterando largura e altura
    }
    public void act()
    {
        
    }
}
