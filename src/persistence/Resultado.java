package persistence;

import javax.persistence.*;

@Entity
@Table(name = "resultados")
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String juego;
    private String descripcion;
    private boolean resuelto;
    private int pasos;

    public Resultado() {}

    public Resultado(String juego, String descripcion, boolean resuelto, int pasos) {
        this.juego = juego;
        this.descripcion = descripcion;
        this.resuelto = resuelto;
        this.pasos = pasos;
    }

    // Getters y setters necesarios (puedes generar automáticamente con tu IDE)
    public int getId() { return id; }

    public String getJuego() { return juego; }
    public void setJuego(String juego) { this.juego = juego; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public boolean isResuelto() { return resuelto; }
    public void setResuelto(boolean resuelto) { this.resuelto = resuelto; }

    public int getPasos() { return pasos; }
    public void setPasos(int pasos) { this.pasos = pasos; }
}
