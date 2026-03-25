public class BungaArtifisial extends Tanaman {
    private String bahan;

    public BungaArtifisial(String id, String nama, double harga, String bahan) {
        super(id, nama, harga);
        this.bahan = bahan;
    }

    public String getBahan() { return bahan; }
    public void setBahan(String bahan) { this.bahan = bahan; }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println(" | Bahan: " + bahan + " (Kategori: Bunga Artifisial)");
    }
}