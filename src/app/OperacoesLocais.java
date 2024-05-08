package app;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import static java.lang.Math.sqrt;

public class OperacoesLocais {
    public static BufferedImage media3x3(BufferedImage imgEntrada){
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for(int h = 0; h<altura; h++) {
            for (int w = 0; w<largura ; w++) {
                if(ePixelBorda3x3(h, w, altura, largura)){ //borda evita o clone da imagem
                    int rgb = imgEntrada.getRGB(w, h);
                    imgSaida.setRGB(w, h, rgb);
                    continue;
                }
                int[] vizinhanca = obterVizinhanca3x3(imgEntrada, w, h);
                int media = Arrays.stream(vizinhanca).sum() / 9;
                Color novaCor = new Color(media, media, media); // o color quebra os bytes por cor
                imgSaida.setRGB(w,h,novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage mediana3x3(BufferedImage imgEntrada){
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for(int h = 0; h<altura; h++) {
            for (int w = 0; w<largura ; w++) {
                if(ePixelBorda3x3(h, w, altura, largura)){ //borda evita o clone da imagem
                    int rgb = imgEntrada.getRGB(w, h);
                    imgSaida.setRGB(w, h, rgb);
                    continue;
                }
                int[] vizinhanca = obterVizinhanca3x3(imgEntrada, w, h);
                Arrays.sort(vizinhanca);
                int mediana = vizinhanca[4];

                Color novaCor = new Color(mediana, mediana, mediana); // o color quebra os bytes por cor
                imgSaida.setRGB(w,h,novaCor.getRGB());
            }
        }
        return imgSaida;
    }
    private static int[] obterVizinhanca3x3(BufferedImage imgEntrada, int w, int h) {
        int[] vizinhanca= new int[9];
        int count = 0;
        for (int i=-1; i <= 1; i ++){// linha
            for(int j=-1; j <= 1; j ++){//coluna
                int rgb = imgEntrada.getRGB(w + j, h + i);
                Color corVizinho = new Color(rgb);
                vizinhanca[count++] = corVizinho.getRed();
            }
        }
        return vizinhanca;
    }
    private static boolean ePixelBorda3x3(int h, int w, int altura, int largura) {
        return h == 0 || w == 0 || h == altura - 1 || w == largura - 1;
    }
    public static BufferedImage media(BufferedImage imgEntrada, int tamanho) {
        int tamanho_borda = tamanho_borda(tamanho);
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for(int h = 0; h<altura; h++) {
            for (int w = 0; w<largura ; w++) {
                if(ePixelBorda(h, w, altura, largura, tamanho_borda)) {
                    int rgb = imgEntrada.getRGB(w, h);
                    imgSaida.setRGB(w, h, rgb);
                    continue;
                }
                int[] vizinhanca = obterVizinhanca(imgEntrada, w, h, tamanho);
                int media = Arrays.stream(vizinhanca).sum() / tamanho;
                Color novaCor = new Color(media, media, media);
                imgSaida.setRGB(w,h,novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage mediana(BufferedImage imgEntrada, int tamanho){
        int tamanho_borda = tamanho_borda(tamanho);
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for(int h = 0; h<altura; h++) {
            for (int w = 0; w<largura ; w++) {
                if(ePixelBorda(h, w, altura, largura, tamanho_borda)){
                    int rgb = imgEntrada.getRGB(w, h);
                    imgSaida.setRGB(w, h, rgb);
                    continue;
                }
                int[] vizinhanca = obterVizinhanca(imgEntrada, w, h, tamanho);
                Arrays.sort(vizinhanca);
                int mediana = vizinhanca[tamanho/2];

                Color novaCor = new Color(mediana, mediana, mediana);
                imgSaida.setRGB(w,h,novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    private static int[] obterVizinhanca(BufferedImage imgEntrada, int w, int h,int tamanho) {
        int[] vizinhanca= new int[tamanho];
        int tamanho_borda = tamanho_borda(tamanho);
        int count = 0;
        for (int i=-tamanho_borda; i <= tamanho_borda; i ++) {
            for(int j=-tamanho_borda; j <= tamanho_borda; j ++) {
                int rgb = imgEntrada.getRGB(w + j, h + i);
                Color corVizinho = new Color(rgb);
                vizinhanca[count++] = corVizinho.getRed();
            }
        }
        return vizinhanca;
    }

    private static boolean ePixelBorda(int h, int w, int altura, int largura, int tamanho_borda) {
        return h < tamanho_borda || w < tamanho_borda || h >= altura - tamanho_borda || w >= largura - tamanho_borda;
    }

    private static int tamanho_borda(int tamanho) {
        return (int) sqrt(tamanho)/2;
    }
    /*public static BufferedImage convolucao(BufferedImage imgEntrada, double[] kernel){
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for(int h = 0; h<altura; h++) {
            for (int w = 0; w<largura ; w++) {
                if(ePixelBorda(h, w, altura, largura)){ //borda evita o clone da imagem
                    int rgb = imgEntrada.getRGB(w, h);
                    imgSaida.setRGB(w, h, rgb);
                    continue;
                }
                int[] vizinhanca = obterVizinhanca(imgEntrada, w, h);
                double resultado = 0.0;

                for(int i=0; i<9; i++){
                    resultado+= vizinhanca[i] + kernel[i];
                }
                if (resultado > 255) resultado = 255;
                else if (resultado < 0) resultado = 0;

                Color novaCor = new Color((int)resultado, (int)resultado, (int)resultado); // o color quebra os bytes por cor
                imgSaida.setRGB(w,h,novaCor.getRGB());
            }
        }
        return imgSaida;
    }*/

}
