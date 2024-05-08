package app;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class OperacoesPontuais {

    /*public static BufferedImage deepCopy(BufferedImage original) {
        BufferedImage copy = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
        for (int y = 0; y < original.getHeight(); y++) {
            for (int x = 0; x < original.getWidth(); x++) {
                copy.setRGB(x, y, original.getRGB(x, y));
            }
        }
        return copy;
    }*/
    public static BufferedImage bandaRed(BufferedImage imgEntrada) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();
        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);

                int red = cor.getRed();
                Color novaCor = new Color(red, 0, 0);

                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage bandaGreen(BufferedImage imgEntrada) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);

                int green = cor.getGreen();
                Color novaCor = new Color(0, green, 0);

                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage bandaBlue(BufferedImage imgEntrada) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);

                int blue = cor.getBlue();
                Color novaCor = new Color(0, 0, blue);

                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage negativo(BufferedImage imgEntrada) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);

                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                Color novaCor = new Color(255 - red, 255 - green, 255 - blue);

                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage greyScaleRed(BufferedImage imgEntrada) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);

                int red = cor.getRed();
                Color novaCor = new Color(red, red, red);

                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage greyScaleGreen(BufferedImage imgEntrada) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);

                int green = cor.getGreen();
                Color novaCor = new Color(green, green, green);

                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage greyScaleBlue(BufferedImage imgEntrada) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);

                int blue = cor.getBlue();
                Color novaCor = new Color(blue, blue, blue);

                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage greyScaleMedia(BufferedImage imgEntrada) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);

                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                int media = (red + green + blue) / 3;
                Color novaCor = new Color(media, media, media);

                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage binarizacao(BufferedImage imgEntrada, int limiar) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);

                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                int media = (red + green + blue) / 3;
                int valor = media > limiar ? 255 : 0;
                Color novaCor = new Color(valor, valor, valor);

                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage alteraTonalidade(BufferedImage imgEntrada, String banda, int limiar) {
        if (!banda.equalsIgnoreCase("red")
                && !banda.equalsIgnoreCase("green")
                && !banda.equalsIgnoreCase("blue")
        ) {
            throw new IllegalArgumentException("Banda inválida");
        }

        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);

                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                if (banda.equalsIgnoreCase("red")) red = validaLimiteRGB(red, limiar);
                else if (banda.equalsIgnoreCase("green")) green = validaLimiteRGB(green, limiar);
                else blue = validaLimiteRGB(blue, limiar);

                Color novaCor = new Color(red, green, blue);

                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage brilhoAditivo(BufferedImage imgEntrada, int limiar) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);

                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                red = validaLimiteRGB(red, limiar);
                green = validaLimiteRGB(green, limiar);
                blue = validaLimiteRGB(blue, limiar);

                Color novaCor = new Color(red, green, blue);

                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage brilhoMultiplicativo(BufferedImage imgEntrada, float limiar) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);

                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                red = validaLimiteRGB(red, limiar);
                green = validaLimiteRGB(green, limiar);
                blue = validaLimiteRGB(blue, limiar);

                Color novaCor = new Color(red, green, blue);

                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage negativoY(BufferedImage imgEntrada) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);

                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                int y = (int) (0.299 * red + 0.587 * green + 0.114 * blue);
                int i = (int) (0.596 * red - 0.274 * green - 0.322 * blue);
                int q = (int) (0.211 * red - 0.523 * green + 0.312 * blue);

                y = (y > 255) ? 255 : 0;
                i = (i > 255) ? 255 : 0;
                q = (q > 255) ? 255 : 0;

                Color novaCor = new Color(255 - y, i, q);

                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage brilhoAditivoY(BufferedImage imgEntrada, int limiar) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);

                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                int y = (int) (0.299 * red + 0.587 * green + 0.114 * blue);
                int i = (int) (0.596 * red - 0.274 * green - 0.322 * blue);
                int q = (int) (0.211 * red - 0.523 * green + 0.312 * blue);

                y = validaLimiteRGB(y, limiar);
                i = validaLimiteRGB(i, limiar);
                q = validaLimiteRGB(q, limiar);

                Color novaCor = new Color(y, i, q);

                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage brilhoMultiplicativoY(BufferedImage imgEntrada, float limiar) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = imgEntrada.getRGB(w, h);
                Color cor = new Color(rgb);

                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                int y = (int) (0.299 * red + 0.587 * green + 0.114 * blue);
                int i = (int) (0.596 * red - 0.274 * green - 0.322 * blue);
                int q = (int) (0.211 * red - 0.523 * green + 0.312 * blue);

                y = validaLimiteRGB(y, limiar);
                i = validaLimiteRGB(i, limiar);
                q = validaLimiteRGB(q, limiar);

                Color novaCor = new Color(y, i, q);

                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    private static int validaLimiteRGB(int banda, int acrescimo) {
        banda += acrescimo;
        banda = banda < 0 ? 0 : banda;
        banda = banda > 255 ? 255 : banda;
        return banda;
    }

    private static int validaLimiteRGB(int banda, double acrescimo) {
        float result = banda *= acrescimo;
        result = result < 0 ? 0 : result;
        result = result > 255 ? 255 : result;
        return (int) result;
    }

    /*public static BufferedImage media3x3(BufferedImage imgEntrada) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = calcularMedia(imgEntrada, h, w);
                imgSaida.setRGB(w, h, rgb);
            }
        }
        return imgSaida;
    }

    private static int calcularMedia(BufferedImage img, int h, int w) {
        double vermelho = 0, verde = 0, azul = 0;
        int i = 0;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int nx = Math.min(Math.max(w + dx, 0), img.getWidth() - 1);
                int ny = Math.min(Math.max(h + dy, 0), img.getHeight() - 1);
                Color color = new Color(img.getRGB(nx, ny));

                vermelho += color.getRed();
                verde += color.getGreen();
                azul += color.getBlue();
                i++;
            }
        }
        int vermelhoMedia = (int) (vermelho / i);
        int verdeMedia = (int) (verde / i);
        int azulMedia = (int) (azul / i);

        int novaCor = new Color(vermelhoMedia, verdeMedia, azulMedia).getRGB();
        return novaCor;
    }
    public static BufferedImage mediana(BufferedImage imgEntrada) {
        int altura = imgEntrada.getHeight();
        int largura = imgEntrada.getWidth();

        BufferedImage imgSaida = new BufferedImage(largura, altura, imgEntrada.getType());
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                int rgb = calcularMediana(imgEntrada, h, w);
                imgSaida.setRGB(w, h, rgb);
            }
        }
        return imgSaida;
    }

    private static int calcularMediana(BufferedImage img, int h, int w) {
        int[] vermelho = new int[9];
        int[] verde = new int[9];
        int[] azul = new int[9];

        int i = 0;
        for (int dy = -1; dy <= 1; dy++) {
            for (int dx = -1; dx <= 1; dx++) {
                int nx = Math.max(0, Math.min(w + dx, img.getWidth() - 1));
                int ny = Math.max(0, Math.min(h + dy, img.getHeight() - 1));
                Color color = new Color(img.getRGB(nx, ny));

                vermelho[i] = color.getRed();
                verde[i] = color.getGreen();
                azul[i] = color.getBlue();
                i++;
            }
        }
        Arrays.sort(vermelho);
        Arrays.sort(verde);
        Arrays.sort(azul);

        int medianaVermelho = vermelho[4];
        int medianaVerde = verde[4];
        int medianaAzul = azul[4];

        int novaCor = new Color(medianaVermelho, medianaVerde, medianaAzul).getRGB();
        return novaCor;
    }*/

}
