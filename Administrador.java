import greenfoot.*;
/**
 * Write a description of class Administrador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Administrador  
{
    World world;
    public Administrador(World world)
    {
        this.world = world;
        System.out.println(world.getObjects(Alien.class));
        System.out.println(this.world);
    }
}
