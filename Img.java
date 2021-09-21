package my_be_project;

/**
 *
 * @author Prativa
 */
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.*;
import java.awt.image.*;
import java.util.*;
import java.lang.*;
import java.lang.String;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Img {

    public static int[][] imgMat;
    public static int imgH, imgW, embeddingPossible = 0;
    public static ArrayList<Integer> arrayRow = new ArrayList<Integer>();
    public static ArrayList<Integer> arrayCol = new ArrayList<Integer>();
    public static ArrayList<Character> data = new ArrayList<Character>();
    Boolean flag, flag1;
    public static int count = 0;
    static BufferedImage cat1, cat2;

    public static BufferedImage colorToGray(BufferedImage imgJPEG) {
        // Create a new buffer to BYTE_GRAY
        BufferedImage img = new BufferedImage(imgJPEG.getWidth(), imgJPEG.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = img.getRaster();
        WritableRaster rasterJPEG = imgJPEG.getRaster();
        // Foreach pixel we transofrm it to Gray Scale and put it on the same image
        for (int h = 0; h < imgJPEG.getHeight(); h++) {
            for (int w = 0; w < imgJPEG.getWidth(); w++) {
                int[] p = new int[4];
                rasterJPEG.getPixel(w, h, p);
                p[0] = (int) (0.3 * p[0]);
                p[1] = (int) (0.59 * p[1]);
                p[2] = (int) (0.11 * p[2]);
                int y = p[0] + p[1] + p[2];
                raster.setSample(w, h, 0, y);
            }
        }
        return img;
    }

    public static BufferedImage convertToBinary(BufferedImage imgJPEG) {
        // Create a new Binary Buffer
        BufferedImage img = new BufferedImage(imgJPEG.getWidth(), imgJPEG.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
        WritableRaster raster = img.getRaster();
        WritableRaster rasterPB = colorToGray(imgJPEG).getRaster();
        imgMat = new int[imgJPEG.getHeight()][imgJPEG.getWidth()];
        // Foreach pixel  check if the new one must be white or black
        for (int h = 0; h < imgJPEG.getHeight(); h++) {
            for (int w = 0; w < imgJPEG.getWidth(); w++) {
                int[] p = new int[1];
                rasterPB.getPixel(w, h, p);
                if (p[0] > 127) {
                    raster.setSample(w, h, 0, 1);
                    imgMat[h][w] = 1;
                } else {
                    raster.setSample(w, h, 0, 0);
                    imgMat[h][w] = 0;
                }
            }
        }
        for (int i = 0; i < imgJPEG.getHeight(); i++) {
            for (int j = 0; j < imgJPEG.getWidth(); j++) {
                System.out.print(imgMat[i][j]);
            }
            System.out.println();
        }
        System.out.println(imgJPEG.getHeight());
        System.out.println(imgJPEG.getWidth());
        return img;
    }

    public static BufferedImage convertToImage(BufferedImage imgJPEG) {
        // Create a new Binary Buffer

        BufferedImage img = new BufferedImage(imgJPEG.getWidth(), imgJPEG.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
        WritableRaster raster = img.getRaster();
        imgH = imgJPEG.getHeight();
        imgW = imgJPEG.getWidth();
        // Foreach pixel  check if the new one must be white or black

        System.out.println("Image After Embedding Data in it");
        for (int h = 0; h < imgJPEG.getHeight(); h++) {
            for (int w = 0; w < imgJPEG.getWidth(); w++) {
                System.out.print(imgMat[h][w]);
                if (imgMat[h][w] == 1) {
                    raster.setSample(w, h, 0, 1);

                } else {
                    raster.setSample(w, h, 0, 0);

                }
            }
            System.out.println();
        }
        return img;
    }

    public void countEmbeddable() {
        //Count and store embeddable blocks index
        arrayRow.clear();
        arrayCol.clear();
        int blk[][];
        int blkNew[][];
        blk = new int[3][3];
        blkNew = new int[3][3];
        System.out.println(Img.imgH);
        for (int i = 0; i < Img.imgH - 2; i += 3) {
            for (int j = 0; j < Img.imgW - 2; j += 3) {

                flag = false;
                flag1 = false;
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        blk[x][y] = Img.imgMat[i + x][j + y];
                        blkNew[x][y] = Img.imgMat[i + x][j + y];
                    }
                }

                flag = Block.checkConnectivity(blk);
                flag1 = Block.count(blk);
                //System.out.println(flag+" "+flag1);
                if (flag == true && flag1 == true) {

                    if (blkNew[1][1] == 1) {
                        blkNew[1][1] = 0;
                    } else {
                        blkNew[1][1] = 1;
                    }

                    flag = false;
                    flag1 = false;
                    flag = Block.checkConnectivity(blkNew);
                    flag1 = Block.count(blkNew);
                    if (flag == true && flag1 == true) {
                        count++;
                        System.out.println("Adding " + i + "  " + j);
                        arrayRow.add(i);
                        arrayCol.add(j);
                        System.out.println("Block is Embeddable " + i + "  " + j);
                        for (int x = 0; x < 3; x++) {
                            for (int y = 0; y < 3; y++) {
                                System.out.print(blk[x][y]);
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println("Not Considered " + i + "  " + j);
                        for (int x = 0; x < 3; x++) {
                            for (int y = 0; y < 3; y++) {
                                System.out.print(blk[x][y]);
                            }
                            System.out.println();
                        }
                    }
                } else {
                    System.out.println("Not Embeddable " + i + "  " + j);
                    for (int x = 0; x < 3; x++) {
                        for (int y = 0; y < 3; y++) {
                            System.out.print(blk[x][y]);
                        }
                        System.out.println();
                    }
                }

            }
        }
        System.out.println("Embeddable count=" + count);

        for (int k = 0; k < arrayRow.size(); k++) {
            System.out.print(arrayRow.get(k) + " ");
            System.out.println(arrayCol.get(k));
        }
        int cnt = 0;
        if (count < DataPreparation.finalLen * 8) {
            //   JOptionPane.showMessageDialog(rootPane, "Select another image.Embedding not possible in this image");
            embeddingPossible = 0;
            System.out.println("Select another image.Embedding not possible in this image");
        } else {
            System.out.println("Embedding possible");
            embeddingPossible = 1;
            int x, y;
            //char data[] = new char[8];
            System.out.print(DataPreparation.finalLen);
            System.out.println();
            //x=0;
            //y=0;
            for (int k = 0; k < DataPreparation.finalLen; k++) {
                for (int k1 = 0; k1 < 8; k1++) {
                    data.add(DataPreparation.finalData[k].charAt(k1));
                    System.out.print(DataPreparation.finalData[k].charAt(k1));
                }
            }


            System.out.print("Data to embed:" + data);
            for (int k = 0; k < data.size(); k++) {

                System.out.println();
                System.out.println("Block  " + (++cnt));
                x = arrayRow.get(k);
                y = arrayCol.get(k);
                int val;
                if (data.get(k) == '1') {
                    val = 1;
                } else {
                    val = 0;
                }


                if (imgMat[x + 1][y + 1] == val) {

                    //Print block before Embedding
                    System.out.println("Block Before Embedding");
                    for (int p = 0; p < 3; p++) {
                        for (int q = 0; q < 3; q++) {
                            System.out.print(imgMat[x + p][y + q]);
                        }
                        System.out.println();
                    }
                    System.out.println("No need to flip  " + x + " " + y + " " + imgMat[x + 1][y + 1] + " " + val);

                    //Print block after Embedding
                    System.out.println("Block After Embedding");
                    for (int p = 0; p < 3; p++) {
                        for (int q = 0; q < 3; q++) {
                            System.out.print(imgMat[x + p][y + q]);
                        }

                        System.out.println();
                    }

                } else {
                    //Print block before Embedding
                    System.out.println("Block Before Embedding");
                    for (int p = 0; p < 3; p++) {
                        for (int q = 0; q < 3; q++) {
                            System.out.print(imgMat[x + p][y + q]);
                        }

                        System.out.println();
                    }

                    System.out.println("Flipping at  " + x + " " + y + " " + imgMat[x + 1][y + 1] + " " + val);

                    if (val == 1) {
                        //System.out.println("fdnvmdfnm");
                        //     System.out.println("Before: " + imgMat[x + 1][y + 1]);
                        imgMat[x + 1][y + 1] = 1;
                        //   System.out.println("After : " + imgMat[x + 1][y + 1]);
                    } else {
                        // System.out.println("Before: " + imgMat[x + 1][y + 1]);
                        imgMat[x + 1][y + 1] = 0;
                        // System.out.println("After : " + imgMat[x + 1][y + 1]);
                    }

                    //Print block after Embedding
                    System.out.println("Block After Embedding");
                    for (int p = 0; p < 3; p++) {
                        for (int q = 0; q < 3; q++) {
                            System.out.print(imgMat[x + p][y + q]);
                        }
                        System.out.println();
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // Save the image file as a BufferedImage object
        Img im = new Img();

        //Original Image as cat_pure

        System.out.println("Original Image");
        //  cat1 = convertToBinary(ImageIO.read(new File("E:/BEPROJECT/MyProject/Original/FLOWER.jpg")));
        //System.out.print(embed.path);
        cat1 = convertToBinary(ImageIO.read(new File(embed.path)));
        ImageIO.write(cat1, "jpg", new File("E:/BEPROJECT/My_BE_Project/Pure/Cover.jpeg"));

        imgH = cat1.getHeight();
        imgW = cat1.getWidth();
        im.countEmbeddable();

        cat2 = convertToImage(cat1);
        ImageIO.write(cat2, "jpg", new File("E:/BEPROJECT/My_BE_Project/Stego/Stego.jpeg"));
    }
}
