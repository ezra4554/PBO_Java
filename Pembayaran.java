/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Pembayaran{
    private static Pembayaran instance = null;  //singleton
    ArrayList<Integer> stokKeranjang = new ArrayList<Integer>();
    int [] pilihanItem = new int[30]; //max 30 orderan
    int [] pilihanStok = new int[30];
    Scanner input = new Scanner(System.in);
    int n_order = 0;
    double harga = 0;

    public static Pembayaran getInstance(){ //singleton
        if (instance == null) {
            instance = new Pembayaran(); 
        }
        return instance;
    }
    public void prosesPembayaran(Barang_Toko opsi2){
        double hargaBaru =  stokKeranjang.get(n_order)* opsi2.daftarBarang.get(pilihanItem[n_order]-1).getHarga();
        harga = harga + hargaBaru;
    }

    public void keranjang(Barang_Toko opsi2){
        System.out.println("\n====================");
        System.out.println("\tKERANJANG");
        System.out.println("====================");
        if (pilihanItem[n_order] == 0 && pilihanStok[0] == 0){ // jika belum ada orderan
            System.out.println("- \t\t- \t-");
        }else{
            for(int i=0; i<n_order; i++){
                Barang barang = opsi2.daftarBarang.get(pilihanItem[i]-1);
                //1. coklat 100 pcs
                System.out.println((i+1) + ". " + barang.getNama() + "\t\t" + stokKeranjang.get(i) + "pcs");
            }
        }
        System.out.println("Total Harga: "+harga);
    }

    public void stokKeranjang(int pilihanStok){
        stokKeranjang.add(pilihanStok);
    }

    public void displayMenu(Barang_Toko opsi2){
        char pilihKeranjang;
        do{
            opsi2.displayDataBarang();
            keranjang(opsi2);
            System.out.print("\nPilih barang 1-" + opsi2.daftarBarang.size()+": ");
            pilihanItem[n_order] = input.nextInt();
            System.out.print("Berapa banyak: ");
            pilihanStok[n_order] = input.nextInt();
            stokKeranjang(pilihanStok[n_order]);  //tambah stok keranjang
            System.out.println("Barang telah masuk keranjang");

            System.out.print("Lanjut Ke Keranjang dan Bayar (y/n)? ");
            Barang stokBarangX = opsi2.daftarBarang.get(pilihanItem[n_order]-1);
            int updateStok = stokBarangX.getStok()-pilihanStok[n_order];
            opsi2.daftarBarang.get(pilihanItem[n_order]-1).setStok(updateStok);
            pilihKeranjang = input.next().charAt(0);
            prosesPembayaran(opsi2);
            if(pilihKeranjang == 'y' || pilihKeranjang == 'Y'){
                //
            }else{
                //kosong
            }
            n_order++;
            opsi2.clearScreen();  
        }while((pilihanItem[0]-1) < opsi2.daftarBarang.size() && (pilihKeranjang == 'y' || pilihKeranjang == 'Y'));
    }
}
