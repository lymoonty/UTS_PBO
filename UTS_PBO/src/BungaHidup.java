public class BungaHidup extends Tanaman {
    private int masaSegar;

    public BungaHidup(String id, String nama, double harga, int masaSegar) {
        super(id, nama, harga);
        this.masaSegar = masaSegar;
    }

    public int getMasaSegar() { return masaSegar; }
    public void setMasaSegar(int masaSegar) { this.masaSegar = masaSegar; }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println(" | Ketahanan: " + masaSegar + " hari (Kategori: Bunga Hidup)");
    }
}