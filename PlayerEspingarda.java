import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PlayerEspingarda extends Player
{
    // Animações
    private GreenfootImage[] animParadoDir = {new GreenfootImage("PlayerEspingardaParado.png")};
    private GreenfootImage[] animParadoEsq;
    private GreenfootImage[] animAndandoDir, animAndandoEsq;
    
    private String shootKey;
    
    public PlayerEspingarda (String leftKey, String upKey, String rightKey, String downKey, String shootKey) {
        super(leftKey, upKey, rightKey, downKey);
        this.shootKey = shootKey;
    }
    
    protected void addedToWorld (World world) {
        animParadoDir[0].scale(animParadoDir[0].getWidth()*2, animParadoDir[0].getWidth()*2);
        animParadoEsq = super.espelharAnimacao(animParadoDir);
        
        animAndandoDir = super.gerarAnimacao("PlayerEspingardaAndando", 4, 2);
        animAndandoEsq = super.espelharAnimacao(animAndandoDir);
    }
    
    public boolean andando () {
        return super.andando();
    }
    
    public boolean tiroPressionado () {
        return shootKey.equals(Greenfoot.getKey());
    }
    
    public boolean getOlhandoEsquerda () {
        return super.getOlhandoEsquerda();
    }
    
    public void verificarTiro () {
        if (getWorld() != null) {
            if (tiroPressionado()) {
                Background bg = (Background)getWorld();
                
                if (getOlhandoEsquerda()) {
                    bg.criarBalaEspingarda(getX(), getY(), 180);
                } else {
                    bg.criarBalaEspingarda(getX(), getY(), 0);
                }
            }
        }
    }
    
    public void animar () {
        super.animar();
    }
    
    public void movimentar () {
        super.movimentar();
    }
    
    public void setAnimacaoAtual(GreenfootImage[] anim) {
        super.setAnimacaoAtual(anim);
    }
    
    // Estado
    
    public void setEstado (String estado) {
        super.setEstado(estado);
    }
    
    public String getEstado () {
        return super.getEstado();
    }
    
    public void estadoParado () {
        if (getOlhandoEsquerda()) {
            setAnimacaoAtual(animParadoEsq);
        } else setAnimacaoAtual(animParadoDir);

        if (andando()) {
            setEstado("andando");
        }
    }
    
    public void estadoAndando () {
        if (getOlhandoEsquerda()) {
            setAnimacaoAtual(animAndandoEsq);
        } else setAnimacaoAtual(animAndandoDir);
        
        if (!andando()){
            setEstado("parado");
        }
    }
    
    public void act()
    {
        switch (getEstado()) {
            case "parado":
                estadoParado();
                break;
            case "andando":
                estadoAndando();
                break;
        }
        
        movimentar();
        verificarTiro();
        animar(); // Aplicando animação
    }
}
