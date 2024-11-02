package org.generation.italy.esempiCorso.sql.aereoporto;

public class Ticket {
    private int id;
    private String code;
    private int passeggero_id;

    public Ticket(int id, String code, int passeggero_id) {
        this.id = id;
        this.code = code;
        this.passeggero_id=passeggero_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPasseggero_id() {
        return passeggero_id;
    }

    public void setPasseggero_id(int passeggero_id) {
        this.passeggero_id = passeggero_id;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
