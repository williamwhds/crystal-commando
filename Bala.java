import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bala extends Actor
{
    // Efeitos sonoros
    private GreenfootSound somExplosao = new GreenfootSound("explosion.mp3");
    private GreenfootSound somTiro = new GreenfootSound("gunshot.mp3");
    
    // Atributos
    private int speed = 12;
    
    public Bala () {
        somTiro.setVolume(50);
    }
    
    public void tocarSomExplosao () {
        if (somExplosao.isPlaying()) {
            somExplosao.stop();
        }
        somExplosao.play();
    }
    
    public void tocarSomTiro () {
        if (somTiro.isPlaying()) {
            somTiro.stop();
        }
        somTiro.play();
    }
    
    public boolean foraDaTela () {
        if (getWorld() == null) return false;
        
        if (getX() > getWorld().getWidth() || getX() < 0 || getY() > getWorld().getHeight() || getY() < 0) {
            return true;
        }
        return false;
    }
    
    public void destruir () {
        if (getWorld() != null) {
            getWorld().removeObject(this);
        }
    }
    
    public void criarExplosao () {
        if (getWorld() != null) {
            getWorld().addObject(new Explosao(), getX(), getY());
        }
    }
    
    public void danificandoInimigo () { 
        Inimigo inimigo = (Inimigo)getOneIntersectingObject(Inimigo.class);
        if (inimigo != null) {
            inimigo.setVida(inimigo.getVida() - 1);
            criarExplosao();
            tocarSomExplosao();
            destruir();
        }
    }
    
    protected void addedToWorld (World world) {
        tocarSomTiro();
    }
    
    public void act()
    {
        danificandoInimigo();
        move(speed);
        if (foraDaTela()) destruir();
    }
}
