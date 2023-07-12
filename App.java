/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class App {
     public static void main(String[] args){
        Pembayaran opsi1 = Pembayaran.getInstance();
        Barang_Toko opsi2 = Barang_Toko.getInstance();

        int menu;
        Scanner input = new Scanner(System.in);
        
        do {
            System.out.println("====================");
            System.out.println("MENU UTAMA");
            System.out.println("====================");
            System.out.println("Program Toko Sederhana");
            System.out.println("1. Beli");
            System.out.println("2. Data Barang Jualan");
            System.out.print("Pilih menu: ");
            menu = input.nextInt();
            input.nextLine();
            System.out.println("=======================");

            switch (menu) {
                case 1:
                    opsi2.clearScreen();
                    opsi1.displayMenu(opsi2);
                    break;
                case 2:
                    opsi2.clearScreen();
                    opsi2.displayMenu();
                    break;
            
                default:
                    break;
            }
        } while (menu != 3);
    }
}
