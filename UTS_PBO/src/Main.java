import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Tanaman> DaftarTanaman = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- SISTEM PENJUALAN TOKO BUNGA ---");
            System.out.println("1. Tambah Stok Bunga");
            System.out.println("2. Cek Semua Stok");
            System.out.println("3. Edit Data Bunga");
            System.out.println("4. Hapus Bunga");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            if (!input.hasNextInt()) {
                System.out.println("Inputnya harus angka!");
                input.next();
                continue;
            }

            int pilihanMenu = input.nextInt();
            input.nextLine();

            if (pilihanMenu == 5) {
                System.out.println("Terima kasih!");
                break;
            }

            switch (pilihanMenu) {
                case 1 -> tambahTanaman();
                case 2 -> tampilkanTanaman();
                case 3 -> editTanaman();
                case 4 -> hapusTanaman();
                default -> System.out.println("Pilihan salah, coba lagi.");
            }
        }
    }

    static void tambahTanaman() {
        System.out.println("\n--- Input Bunga Baru ---");
        System.out.println("1. Bunga Hidup");
        System.out.println("2. Bunga Artifisial");
        System.out.print("Jenisnya apa? (1/2): ");
        int tipe = input.nextInt();
        input.nextLine();

        System.out.print("Kode/ID: ");
        String id = input.nextLine();
        System.out.print("Nama Bunga: ");
        String nama = input.nextLine();
        System.out.print("Harga: ");
        double harga = input.nextDouble();
        input.nextLine();

        if (tipe == 1) {
            System.out.print("Masa Segar (berapa hari): ");
            int hari = input.nextInt();
            input.nextLine();
            DaftarTanaman.add(new BungaHidup(id, nama, harga, hari));
        } else {
            System.out.print("Bahan (Plastik/Kain/dll): ");
            String bahan = input.nextLine();
            DaftarTanaman.add(new BungaArtifisial(id, nama, harga, bahan));
        }
        System.out.println("Data bunga berhasil disimpan!");
    }

    static void tampilkanTanaman() {
        if (DaftarTanaman.isEmpty()) {
            System.out.println("\nStok bunga di toko masih kosong.");
            return;
        }
        System.out.println("\n--- LIST STOK SAAT INI ---");
        for (Tanaman t : DaftarTanaman) {
            t.tampilkanData();
        }
    }

    static void editTanaman() {
        System.out.print("\nMasukkan ID bunga yang mau diubah: ");
        String cari = input.nextLine();
        boolean ada = false;

        for (Tanaman t : DaftarTanaman) {
            if (t.getId().equalsIgnoreCase(cari)) {
                System.out.print("Nama baru: ");
                t.setNama(input.nextLine());
                System.out.print("Harga baru: ");
                t.setHarga(input.nextDouble());
                input.nextLine();

                if (t instanceof BungaHidup) {
                    System.out.print("Masa segar baru (hari): ");
                    ((BungaHidup) t).setMasaSegar(input.nextInt());
                    input.nextLine();
                } else if (t instanceof BungaArtifisial) {
                    System.out.print("Bahan baru: ");
                    ((BungaArtifisial) t).setBahan(input.nextLine());
                }

                ada = true;
                System.out.println("Data berhasil diupdate!");
                break;
            }
        }
        if (!ada) System.out.println("ID tidak ditemukan.");
    }

    static void hapusTanaman() {
        System.out.print("\nMasukkan ID yang mau dihapus: ");
        String idHapus = input.nextLine();
        if (DaftarTanaman.removeIf(t -> t.getId().equalsIgnoreCase(idHapus))) {
            System.out.println("Bunga berhasil dihapus dari sistem.");
        } else {
            System.out.println("Gagal menghapus, ID tidak ditemukan.");
        }
    }
}