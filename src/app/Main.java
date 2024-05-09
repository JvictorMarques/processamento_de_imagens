package app;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        int limiar = 200;
        String banda = "blue";
        int tamanho = 7*7;
        double kernel_gaussiano [] = {0.0625, 0.125, 0.0625, 0.125, 0.25, 0.125, 0.0625, 0.125, 0.0625};
        int kernel_horizontal [] = {-1, -2, -1, 0, 0, 0, 1, 2, 1};
        int kernel_vertical [] = {-1, 0, 1, -2, 0, 2, -1, 0, 1};
        int kernel_linhas_oeste [] = {1, 1, -1, 1, -2, -1, 1, 1, -1};
        int kernel_laplaciano [] = {0, -1, 0, -1, 4, -1, 0, -1, 0};
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
            //OperacoesLocais.media(imagem), //media3x3
            //OperacoesLocais.mediana(imagem), //mediana3x3
            //OperacoesLocais.media(imagem,tamanho),
            //OperacoesLocais.mediana(imagem,tamanho),
            OperacoesLocais.convolucao(imagem, kernel_gaussiano),
            OperacoesLocais.convolucao(imagem, kernel_horizontal),
            OperacoesLocais.convolucao(imagem, kernel_vertical),
            OperacoesLocais.convolucao(imagem, kernel_linhas_oeste),
            OperacoesLocais.convolucao(imagem, kernel_laplaciano)
            );
    }
}