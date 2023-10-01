import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

// FAZER BALA SUMIR QUANDO ELA SAI DO CENARIO <<<<<<<<<<<<<<<<

public class Bala extends Actor
{
    int speed = 10;
    
    public Bala () {
    }
    /**
     * Act - do whatever the Bala wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(speed);
    }
}
