package my_be_project;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;

/**
 *
 * @author Prativa
 */
public class Control {

    public static void main(String a[]) {
        System.out.println("Encryption starts here");
        DataPreparation.main(a);

        //Image Processing starts here
        try {
            Img.main(a);
        } catch (IOException e) {
        } catch (InterruptedException e) {
        }
    }
}
