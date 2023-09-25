import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien extends Actor
{
    private int velVertical = 0;
    private int maxVelVertical = 16;
    private int gravidade = 1;
    private int velHorizontal = 1;
    /**
     * Act - do whatever the Alien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean noChao () {
        if (getOneObjectAtOffset(0, (getImage().getHeight()/2) + velVertical, Bloco.class) != null) {
            return true;
        }
        return false;
    }
    
    public void cair () {
        if (velVertical > maxVelVertical) velVertical = maxVelVertical;
        setLocation(getX(), getY() + velVertical);
        velVertical += gravidade;
    }
    
    public void moverMeio () {
        if (getX() > 302) {
            setLocation(getX() - velHorizontal, getY());
        } else setLocation(getX() + velHorizontal, getY());
    }
    
    public void act()
    {
        if (!noChao()) {
            cair();
        } else velVertical = 0;
        
        moverMeio();
    }
}
