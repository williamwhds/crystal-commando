import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class AlienComum extends Inimigo
{
    // Atributos
    private int velVertical = 0;
    private int maxVelVertical = 16;
    private int gravidade = 1;
    private int velHorizontal = 1;
    private int dano = 1; // Dano causado no cristal
    
    // Animação
    private GreenfootImage[] animAndando;
    
    // Efeitos sonoros
    private GreenfootSound somNasceu = new GreenfootSound("aliencomum_nasceu.wav");
    private GreenfootSound somMorreu = new GreenfootSound("aliencomum_morreu.wav"); // AlienComum impede esse som de tocar pois está sendo deletado. Ver soluções depois.
    
    // Mover até cristal (DESENVOLVER MÉTODO PRA DETECTAR CRISTAL E IR EM DIREÇÃO DELE)
    private int destinoX = 309;
    //private int destinoY;
    
    public AlienComum () {
        setVida(2);
        animAndando = super.gerarAnimacao("InimigoComum", 2, 2);
        super.setAnimacaoAtual(animAndando);
        super.setTempoEntreFrames(20);
        
        somNasceu.setVolume(70);
        somMorreu.setVolume(80);
    }
    
    protected void addedToWorld (World world) {
        somNasceu.play();
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
    
    public void moverAteCristal() {
        if (getX() < destinoX) {
            setLocation(getX() + velHorizontal, getY());
        } else if (getX() > destinoX) {
            setLocation(getX() - velHorizontal, getY());
        }
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
            cristal.atualizarTxtVida();
            cristal.tocarSomImpacto();
            somMorreu.play();
            remover();
            return; // Sem isso o jogo crasha. Sempre usar return no método act() quando precisar usar remover() atores porém ainda há comandos.
        }
        
        if (!noChao()) {
            cair();
        } else velVertical = 0;
        
        moverAteCristal();
        animar();
        
    }
}
