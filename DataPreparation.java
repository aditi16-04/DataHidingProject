package my_be_project;

/**
 *
 * @author Prativa
 */
public class DataPreparation {

    private String data;
    private String key1, key2;
    private String[] dataMat;
    private String[] key1Mat;
    private String[] key2Mat;
    private String[] cipherMat;
    private String[] header;
    public static String[] finalData;
    public static int finalLen;

    DataPreparation() {
        dataMat = new String[50];
        key1Mat = new String[50];
        key2Mat = new String[50];
        cipherMat = new String[50];
        header = new String[50];
        finalData = new String[52];
    }

    public String[] convertToMatrix(String d) {
        String temp;
        String splitTemp[];
        int i;
        temp = BinaryOperation.T2B(d);
        splitTemp = temp.split(" ");
        return splitTemp;
    }

    public static void main(String a[]) {
        DataPreparation d = new DataPreparation();
        int i, j, k;
        String temp;

        //Convert To Matrix
    /*    d.dataMat = d.convertToMatrix("ABCD");
        d.key1Mat = d.convertToMatrix("P");
        d.key2Mat = d.convertToMatrix("X");*/

        d.dataMat = d.convertToMatrix(embed.secret);
        d.key1Mat = d.convertToMatrix(embed.key1);
        d.key2Mat = d.convertToMatrix(embed.key2);

        //Display Matrix
        System.out.println("Data Matrix");
        for (i = 0; i < d.dataMat.length; i++) {
            System.out.println(d.dataMat[i]);
        }

        System.out.println("Key1 Matrix");
        for (i = 0; i < d.key1Mat.length; i++) {
            System.out.println(d.key1Mat[i]);
        }

        System.out.println("Key2 Matrix");
        for (i = 0; i < d.key2Mat.length; i++) {
            System.out.println(d.key2Mat[i]);
        }

        //First Encryption
        for (i = 0, k = 0; i < d.dataMat.length; i++) {
            temp = "";
            k = i % d.key1Mat.length;
            for (j = 0; j < 8; j++) {
                if (d.dataMat[i].charAt(j) == d.key1Mat[k].charAt(j)) {
                    temp += "0";
                } else {
                    temp += "1";
                }
            }
            d.cipherMat[i] = "";
            d.cipherMat[i] += temp;
        }

        //Display Matrix after first Encryption
        System.out.println("Cipher Matrix");
        for (i = 0; i < d.dataMat.length; i++) {
            System.out.println(d.cipherMat[i]);
        }

        //Header Preparation

        temp = BinaryOperation.D2B(d.dataMat.length);
        d.header[0] = "";
        j = 0;
        while (j != (8 - temp.length())) {
            d.header[0] += "0";
            j++;
        }
        d.header[0] += temp;
        j = 0;
        k = 1;
        while (j < d.dataMat.length) {
            d.header[k] = "";
            d.header[k] += d.cipherMat[j];
            k++;
            j++;
        }

        System.out.println("Header");
        for (int i1 = 0; i1 < (1 + d.dataMat.length); i1++) {
            System.out.println(d.header[i1]);
        }

        //Second Encryption
        for (i = 0, k = 0; i < (d.dataMat.length + 1); i++) {
            temp = "";
            k = i % d.key2Mat.length;
            for (j = 0; j < 8; j++) {
                if (d.header[i].charAt(j) == d.key2Mat[k].charAt(j)) {
                    temp += "0";
                } else {
                    temp += "1";
                }
            }
            d.finalData[i] = "";
            d.finalData[i] += temp;
        }

        d.finalLen = d.dataMat.length + 1;
        // System.out.println(d.finalLen);
        System.out.println("Final Data");
        for (i = 0; i < 1 + d.dataMat.length; i++) {
            System.out.println(d.finalData[i]);

        }
    }
}
