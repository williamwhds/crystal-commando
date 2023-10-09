import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Inimigo extends ObjetoAnimado
{
    int vida = 1; // Trocar de acordo com inimigo
    
    public void setVida (int vida) {
        this.vida = vida;
    }
    
    public int getVida () {
        return this.vida;
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
