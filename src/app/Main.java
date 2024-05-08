package app;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        int limiar = 200;
        String banda = "blue";
        int tamanho = 7*7;
        BufferedImage imagem = ManipulaImagem.abrirImagem("teste.png");
        ManipulaImagem.exibirImagem(imagem,
            //OperacoesPontuais.bandaRed(imagem)
            //OperacoesPontuais.bandaBlue(imagem),
            //OperacoesPontuais.bandaGreen(imagem)
            //OperacoesPontuais.negativo(imagem),
            //OperacoesPontuais.greyScaleRed(imagem),
            //OperacoesPontuais.greyScaleGreen(imagem),
            //OperacoesPontuais.greyScaleBlue(imagem),
            //OperacoesPontuais.greyScaleMedia(imagem),
            //OperacoesPontuais.binarizacao(imagem,limiar),
            //OperacoesPontuais.alteraTonalidade(imagem,banda,limiar),
            //OperacoesPontuais.brilhoAditivo(imagem,limiar),
            //OperacoesPontuais.brilhoMultiplicativo(imagem,limiar),
            //OperacoesPontuais.negativoY(imagem),
            //OperacoesPontuais.brilhoAditivoY(imagem,limiar),
            //OperacoesPontuais.brilhoMultiplicativoY(imagem,limiar),
            OperacoesLocais.media3x3(imagem),
            OperacoesLocais.mediana3x3(imagem),
            OperacoesLocais.media(imagem,tamanho),
            OperacoesLocais.mediana(imagem,tamanho));

    }
}