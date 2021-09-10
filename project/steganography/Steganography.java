/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steganography;

import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import steganography.ValueComparator;

public class Steganography extends JLabel {

    int height, width;
    int[] data;

    public Steganography() {

    }

    String path;
    Image image, gray, binary, encodedImage;
    int pixels[];
    ImageIcon ic;
    int binArray[];
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<Integer> countArray = new ArrayList<>();
    public String H1 = "";
    public String H2 = "";

    public void loadImage(String imagePath) throws Exception {
        path = imagePath;

        //setOpaque(true);
        ic = new ImageIcon(imagePath);
        System.out.println("imagePath : " + imagePath);

        image = ic.getImage();

        height = ic.getIconHeight();
        width = ic.getIconWidth();

        //setOpaque(false);		
        pixels = new int[width * height];
        binArray = new int[height * width];

        PixelGrabber pg = new PixelGrabber(image, 0, 0, width, height, pixels, 0, width);
        pg.grabPixels();

        if (image != null) {
            System.out.println(" image is there " + pixels[9]);

        }

    }

    public BufferedImage convertTogray() {
        System.out.println("Convert to gray ");
         BufferedImage bi = null;
        try {

            for (int i = 0; i < width * height; i++) {
                int p = pixels[i];
                int r = 0xff & (p >> 16);
                int g = 0xff & (p >> 8);
                int b = 0xff & (p);

                int q = (int) (0.56 * r + .33 * g + b * 0.11);

                pixels[i] = (0xff000000 | q << 16 | q << 8 | q);
            }
            System.out.println("pixel[0] " + pixels[0]);
            gray = createImage(new MemoryImageSource(width, height, pixels, 0, width));
            bi = convertToBufferedImage(gray);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Convert 2 Gray", JOptionPane.ERROR_MESSAGE);
        }
        return bi;
    } // END of function convert2gray

    public int convertToBinary() {
        for (int i = 0; i < width * height; i++) {
            int p = pixels[i];
            int r = 0xff & (p >> 16);
            int g = 0xff & (p >> 8);
            int b = 0xff & (p);

            int q = (int) (0.56 * r + .33 * g + b * 0.11);

            if (q > 200) {
                q = 255;
                binArray[i] = 1;
            } else {
                q = 0;
                binArray[i] = 0;
            }
            pixels[i] = (0xff000000 | q << 16 | q << 8 | q);
        }
        System.out.println("pixel in binary " + pixels[0]);
        binary = createImage(new MemoryImageSource(width, height, pixels, 0, width));

        String patternString[] = new String[width * height / 3];

        int k = 0;
        for (int m = 0; m < height / 3; m++) {
            for (int n = 0; n < width / 3; n++) {
                patternString[k] = "";

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        patternString[k] = patternString[k].concat(Integer.toString(binArray[(width * (3 * m + i)) + (3 * n + j)]));
                    }
                }
//                System.out.println("block pattern =" + patternString[k]);
                arrayList.add(patternString[k]);
                k++;
            }
        }

        for (String string : arrayList) {
            countArray.add(Integer.parseInt(string, 2));
        }

        arrayList.clear();
        for (Integer integer : countArray) {
            arrayList.add(String.format("%9s", Integer.toBinaryString(integer)).replace(' ', '0'));
        }

        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet(arrayList);
        ArrayList<String> al = new ArrayList<>(set);

        for (int l = 0; l < al.size(); l++) {
            int count = 0;
            for (int o = 0; o < arrayList.size(); o++) {
                if (al.get(l).contentEquals(arrayList.get(o))) {
                    count++;
                }
                map.put(al.get(l), count);
            }
        }

        ValueComparator bvc = new ValueComparator(map);
        TreeMap<String, Integer> treeMap = new TreeMap<>(bvc);
        treeMap.putAll(map);
        int count = 0;
        String headers[] = new String[2];
        int[] countOfHeaders = new int[2];

        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
//            System.out.println(key+" "+value);
        }
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            if (count == 2) {
                break;
            }
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " " + value);
            headers[count] = key;
            countOfHeaders[count] = value;
            count++;
        }

        H1 = headers[0];
        H2 = headers[1];
        System.out.println("H1 = " + H1 + " H2= " + H2);

//        String msgBinaryString = stringToBinary("hello");
//        String keyToBinary = stringToBinary("key");
//        System.out.println("message binary " + msgBinaryString + " " + msgBinaryString.length());
//        System.out.println("key in binary " + keyToBinary + " " + keyToBinary.length());
//        String encrypted = encrypt(msgBinaryString, keyToBinary);
//        System.out.println("Encrypted string " + encrypted + " " + encrypted.length());
//        String decrypted = decrypt(encrypted, keyToBinary);
//        System.out.println("Decrypted string " + decrypted + " " + decrypted.length());
//
//        encode(encrypted, H1, H2);
//        decode();
return 1;
    }

    String stringToBinary(String s) {
        byte[] bytes = s.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        return binary.toString();
    }

    public String encrypt(String stringForEncoding, String keyForEncoding) {
        String string = stringToBinary(stringForEncoding);
        String key = stringToBinary(keyForEncoding);
        int[] sourceString = new int[string.length()];
        int[] keyString = new int[key.length()];
        char[] cs = string.toCharArray();
        for (int i = 0; i < string.length(); i++) {
            sourceString[i] = Integer.parseInt(String.valueOf(cs[i]));
        }
        char[] keyArray = key.toCharArray();
        for (int i = 0; i < key.length(); i++) {
            keyString[i] = Integer.parseInt(String.valueOf(keyArray[i]));
        }
        int counter = 0;
        int[] result = new int[sourceString.length];
        for (int i = 0; i < keyArray.length; i++, counter++) {
            result[i] = sourceString[i] ^ keyArray[i];
        }
        for (int i = 0; i < counter; i++) {
            result[i] = result[i] - 48;
        }

        for (int i = counter; i < sourceString.length; i++) {
            result[i] = sourceString[i];
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sourceString.length; i++) {
            builder.append(result[i]);
        }

        return builder.toString();
    }

    public String decrypt(String source, String key) {
        char[] sourceString = source.toCharArray();
        char[] keyArray = key.toCharArray();

        int[] sourceStringInt = new int[sourceString.length];
        int[] keyArrayInt = new int[keyArray.length];
        int[] result = new int[sourceString.length];

        for (int i = 0; i < sourceString.length; i++) {
            sourceStringInt[i] = Integer.parseInt(String.valueOf(sourceString[i]));
        }

        for (int i = 0; i < key.length(); i++) {
            keyArrayInt[i] = Integer.parseInt(String.valueOf(keyArray[i]));
        }

        for (int i = 0; i < keyArray.length; i++) {
            result[i] = sourceStringInt[i] + 48;
        }
        for (int i = 0; i < keyArray.length; i++) {
            result[i] = result[i] ^ keyArray[i];
        }

        for (int i = keyArray.length; i < sourceString.length; i++) {
            result[i] = sourceStringInt[i];
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sourceString.length; i++) {
            builder.append(result[i]);
        }
        return builder.toString();
    }
    int[] location;

    public BufferedImage encode(String encrypted, String H1, String H2) {
        char[] array = encrypted.toCharArray();
        int[] intArray = new int[array.length];
        location = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            intArray[i] = Integer.parseInt(String.valueOf(array[i]));
        }

        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (arrayList.get(i).contentEquals(H1)) {
                pixels[i] = intArray[j];
                location[j] = i;
                j++;
            } else if (arrayList.get(i).contentEquals(H2)) {
                pixels[i] = intArray[j];
                location[j] = i;
                j++;
            }
        }
        encodedImage = createImage(new MemoryImageSource(width, height, pixels, 0, width));

        BufferedImage bi = convertToBufferedImage(encodedImage);

        return bi;
    }

    public static BufferedImage convertToBufferedImage(Image image) {
        BufferedImage newImage = new BufferedImage(
                image.getWidth(null), image.getHeight(null),
                BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }

    public String decode(String key) {
        int data[] = new int[location.length];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < location.length; i++) {
            data[i] = pixels[location[i]];
            builder.append(data[i]);
        }
        String keyBinary = stringToBinary(key);
        String decrypted = decrypt(builder.toString(), keyBinary);
        String output = toText(decrypted);
        System.out.println(output);
        return output;
    }

    public static String toText(String info) {
        String[] array = new String[info.length() / 8];
        int j = 0;
        for (int i = 0; i < info.length(); i = i + 8) {
            array[j] = info.substring(i, i + 8);
            j++;
        }

        int[] intArray = new int[array.length];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(array[i], 2);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < intArray.length; i++) {
            builder.append((char) intArray[i]);
        }
        return builder.toString();
    }
}
