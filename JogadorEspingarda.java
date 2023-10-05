import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JogadorRifle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JogadorEspingarda extends Jogador
{
    private String shootKey;
    public JogadorEspingarda (String leftKey, String upKey, String rightKey, String downKey, String shootKey) {
        super(leftKey, upKey, rightKey, downKey);
        this.shootKey = shootKey;
    }
    
    public boolean tiroPressionado () {
        return shootKey.equals(Greenfoot.getKey());
    }
    
    public void verificarTiro () {
        if (getWorld() != null) {
            if (tiroPressionado()) {
                int angulo = -35; 
                Background bg = (Background)getWorld();
                for(int i = 0; i < 7; i++){
                    bg.criarBala(getX(), getY(), angulo, true);
                    angulo += 10;
                }
            }
        }
    }
    /**
     * Act - do whatever the JogadorRifle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.movimentar();
        verificarTiro();
    }
}
