package jhotel;
/**
 * Enumeration class StatusKamar
 * @author Derni Ageng
 * @version 2018
 */
        public enum StatusKamar {
    Status_1("Booked"),
    Status_2("Processed"),
    Status_3("Vacant");
    private String deskripsi;

    /**
     * Constructor for StatusKamar
     *
     * @param deskripsi status kamar
     */
    StatusKamar(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    /**
     * pengembalian nilai enum yang dipanggil
     *
     * @return status status kamar
     */
    public String toString() {
        return deskripsi;
    }
}
