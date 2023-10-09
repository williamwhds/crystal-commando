import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class NuvemPequena extends Nuvem
{
    public NuvemPequena (int velocidade) {
        super(velocidade);
        getImage().scale(getImage().getWidth()*2, getImage().getHeight()*2);
    }
    public void act()
    {
        super.act();
    }
}
