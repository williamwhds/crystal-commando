import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cristal extends ObjetoAnimado
{
    // Animação
    private GreenfootImage[] animCintilante;
    
    // Atributos
    private int vida = 20;
    
    public Cristal () {
        animCintilante = super.gerarAnimacao("cristal", 10, 2);
        super.setAnimacaoAtual(animCintilante);
    }
    
    public void animar () {
        super.animar();
    }
    
    public void act()
    {
        animar();
    }
}
