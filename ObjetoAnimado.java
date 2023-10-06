import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ObjetoAnimado extends Actor {
    // Declarar animações antes de usar gerarAnimacao().
    // Caso a animação tenha apenas uma imagem, crie uma array
    // com um elemento só.
    // Ex.: private GreenfootImage[] animacao = {new GreenfootImage("PlayerRifleParado.png")};
    
    //private GreenfootImage[] animacaoAndar;
    private GreenfootImage[] animacaoAtual;
    private int frameAtual = 0;
    private int tempoEntreFrames = 8; // Ajuste de acordo com a velocidade desejada da animação
    private int contador = 0;
    
    public GreenfootImage[] gerarAnimacao (String nomeImagem, int nImagens) {
        int index = nImagens - 1;
        GreenfootImage[] animacao = new GreenfootImage[index];
        for (int i = 0; i < index ; i++) {
            animacao[i] = new GreenfootImage(nomeImagem + i + ".png");
        }
        
        return animacao;
    }
    
    public GreenfootImage[] gerarAnimacao (String nomeImagem, int nImagens, int escala) {
        // Essa sobrecarga troca a escala/tamanho das imagens
        int index = nImagens - 1;
        GreenfootImage[] animacao = new GreenfootImage[index];
        for (int i = 0; i < index ; i++) {
            animacao[i] = new GreenfootImage(nomeImagem + i + ".png");
            animacao[i].scale(animacao[i].getWidth()*escala, animacao[i].getWidth()*escala);
        }
        
        return animacao;
    }
    
    public void animar() {
        if (animacaoAtual != null) {
        contador++;
            if (contador >= tempoEntreFrames) {
                frameAtual = (frameAtual + 1) % animacaoAtual.length;
                setImage(animacaoAtual[frameAtual]);
                contador = 0;
            }
        }
    }
    
    public GreenfootImage[] getAnimacaoAtual () {
        return this.animacaoAtual;
    }
    
    public void setAnimacaoAtual (GreenfootImage[] animacao) {
        this.animacaoAtual = animacao;
    }
    
    public GreenfootImage[] espelharAnimacao (GreenfootImage[] anim) {
        GreenfootImage[] animEspelhada = new GreenfootImage[anim.length];
        for (int i = 0; i < anim.length; i++) {
            animEspelhada[i] = new GreenfootImage(anim[i]);
            animEspelhada[i].mirrorHorizontally();
        }
        return animEspelhada;
    }
    
    public ObjetoAnimado () {
        //this.animacaoAndar = gerarAnimacao("PlayerRifleAndando", 4);
        //setAnimacaoAtual(animacaoAndar);
    }
    
    public void act() {
        animar();
    }
}

