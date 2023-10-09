import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class NuvemMedia extends Nuvem
{
    public NuvemMedia (int velocidade) {
        super(velocidade);
        getImage().scale(getImage().getWidth()*2, getImage().getHeight()*2);
    }
    public void act()
    {
        super.act();
    }
}
