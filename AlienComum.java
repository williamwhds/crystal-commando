import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class AlienComum extends Inimigo
{
    private int velVertical = 0;
    private int maxVelVertical = 16;
    private int gravidade = 1;
    private int velHorizontal = 1;
    private int dano = 1; // Dano causado no cristal
    
    private GreenfootImage[] animAndando;
    
    public AlienComum () {
        setVida(2);
        animAndando = super.gerarAnimacao("InimigoComum", 2, 2);
        super.setAnimacaoAtual(animAndando);
        super.setTempoEntreFrames(20);
    }
    
    public void remover () {
        if (getWorld() == null) return;
        getWorld().removeObject(this);
    }
    
    public void animar () {
        super.animar();
    }
    
    public int getVida () {
        return super.getVida();
    }
    
    public void setVida (int vida) {
        super.setVida(vida);
    }
    
    public Cristal tocouCristal () {
        return (Cristal)getOneObjectAtOffset(0, 0, Cristal.class);
    }
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
        if (vida <= 0) {
            remover();
            return;
        }
        
        Cristal cristal = tocouCristal();
        if (cristal != null) {
            cristal.setVida(cristal.getVida() - dano);
            cristal.atualizarTextoVida();
            remover();
            return; // Sem isso o jogo crasha. Sempre usar return no método act() quando remover atores.
        }
        
        if (!noChao()) {
            cair();
        } else velVertical = 0;
        
        moverMeio();
        animar();
    }
}
