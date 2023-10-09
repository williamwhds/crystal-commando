import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cristal extends ObjetoAnimado
{
    // Animação
    private GreenfootImage[] animCintilante;
    
    // Efeitos sonoros
    private GreenfootSound somImpacto = new GreenfootSound("impact.wav");
    
    // Atributos
    private int vida = 20;
    
    // Texto
    private Texto txtVida = new Texto("VIDA DO CRISTAL: " + String.valueOf(vida), 32, "Cristal.vida");
    
    public Cristal () {
        animCintilante = super.gerarAnimacao("cristal", 10, 2);
        super.setAnimacaoAtual(animCintilante);
        
        if (getWorld() != null) {
            Background bg = (Background)getWorld();
            bg.setCristal(this);
        }
        
        somImpacto.setVolume(80);
    }
    
    public void tocarSomImpacto () {
        if (somImpacto.isPlaying()) {
            somImpacto.stop();
        }
        somImpacto.play();
    }
    
    protected void addedToWorld (World world) {
        getWorld().addObject(txtVida, getX(), getY() - 250);
    }
    
    public void atualizarTxtVida () {
        if (getWorld() != null) {
            Background bg = (Background)getWorld();
            Texto txt = bg.procurarTexto("Cristal.vida");
            txt.setImage(new GreenfootImage("VIDA DO CRISTAL: " + String.valueOf(vida), 32, null, null));
        }
    }
    
    public int getVida () {
        return this.vida;
    }
    
    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public void animar () {
        super.animar();
    }
    
    public void act()
    {
        animar();
    }
}
