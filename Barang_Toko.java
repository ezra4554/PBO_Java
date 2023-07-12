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
public class Barang_Toko {
    private static Barang_Toko instance = null;
    ArrayList<Barang> daftarBarang = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    BarangFactory makananFactory = new MakananFactory();
    BarangFactory minumanFactory = new MinumanFactory();

    private Barang_Toko() {
        // Tambahkan beberapa barang awal
        BarangFactory makananFactory = new MakananFactory();
        BarangFactory minumanFactory = new MinumanFactory();

        Barang makanan1 = makananFactory.createBarang();
        makanan1.setNama("Makanan 1");
        makanan1.setStok(10);
        makanan1.setHarga(1000);

        Barang makanan2 = makananFactory.createBarang();
        makanan2.setNama("Makanan 2");
        makanan2.setStok(20);
        makanan2.setHarga(2000);

        Barang minuman1 = minumanFactory.createBarang();
        minuman1.setNama("Minuman 1");
        minuman1.setStok(30);
        minuman1.setHarga(3000);

        daftarBarang.add(makanan1);
        daftarBarang.add(makanan2);
        daftarBarang.add(minuman1);
    }

    public static Barang_Toko getInstance() {
        if (instance == null) {
            instance = new Barang_Toko();
        }
        return instance;
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void displayDataBarang() {
        System.out.println("====================");
        System.out.println("DATA BARANG JUALAN");
        System.out.println("====================");
        System.out.println("Nama Barang \tStok \tHarga");
        if (daftarBarang.isEmpty()) {
            System.out.println("- \t\t- \t-");
        } else {
            for (int i = 0; i < daftarBarang.size(); i++) {
                Barang barang = daftarBarang.get(i);
                System.out.println((i + 1) + ". " + barang.getNama() + "\t" + barang.getStok() + " pcs\t" + barang.getHarga());
            }
        }
    }

    public void tambahDataBarang() {
        System.out.println("\nTAMBAH DATA BARANG");
        System.out.print("Jenis Barang (Makanan/Minuman): ");
        String jenis = input.nextLine();

        BarangFactory factory;
        if (jenis.equalsIgnoreCase("Makanan")) {
            factory = makananFactory;
        } else if (jenis.equalsIgnoreCase("Minuman")) {
            factory = minumanFactory;
        } else {
            System.out.println("Jenis Barang tidak valid!");
            return;
        }

        Barang barang = factory.createBarang();

        System.out.print("Input Nama Barang: ");
        barang.setNama(input.nextLine());
        System.out.print("Input Stok: ");
        barang.setStok(input.nextInt());
        System.out.print("Input Harga: ");
        barang.setHarga(input.nextInt());
        input.nextLine(); // skip newline

        daftarBarang.add(barang);
        System.out.println("Data Barang berhasil ditambahkan!\n");
    }

    public void updateDataBarang() {
        System.out.println("\nUPDATE DATA BARANG");
        if (daftarBarang.isEmpty()) {
            System.out.println("Tambah Data Barang Terlebih Dahulu!\n");
        } else {
            System.out.print("Pilih Barang Nomor: ");
            int barangNo = input.nextInt();
            input.nextLine(); // skip newline

            if (barangNo <= daftarBarang.size() && barangNo > 0) {
                Barang barang = daftarBarang.get(barangNo - 1);

                System.out.print("Update Stok: ");
                barang.setStok(input.nextInt());
                input.nextLine(); // skip newline

                System.out.print("Update Harga: ");
                barang.setHarga(input.nextInt());
                input.nextLine(); // skip newline

                clearScreen();
                System.out.println("Data Barang berhasil diupdate!\n");
            } else {
                System.out.println("Barang Nomor " + barangNo + " Tidak ada, Silahkan Ulangi!\n");
            }
        }
    }

    public void displayMenu() {
        int menuBarangToko;

        do {
            displayDataBarang();
            System.out.println("\n1. Update Data Barang");
            System.out.println("2. Tambah Data Barang");
            System.out.println("3. Menu Utama");
            System.out.print("Pilih menu: ");
            menuBarangToko = input.nextInt();
            input.nextLine();

            switch (menuBarangToko) {
                case 1:
                    updateDataBarang();
                    break;
                case 2:
                    tambahDataBarang();
                    clearScreen();
                    break;

                default:
                    clearScreen();
                    break;
            }
        } while (menuBarangToko != 3);
    }
}
