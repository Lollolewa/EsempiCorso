package eserciziInterfaccia;

public abstract class OperaArte {
    protected String nome, autore;
    protected int anno, costo;
    public OperaArte(String nome, String autore, int anno, int costo){
        this.nome = nome;
        this.autore = autore;
        this.anno = anno;
        this.costo = costo;
    }

    public String getNome() {
        return nome;
    }

    public String getAutore() {
        return autore;
    }

    public int getAnno() {
        return anno;
    }

    public int getCosto() {
        return costo;
    }
}
