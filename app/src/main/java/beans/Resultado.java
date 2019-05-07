package beans;

/**
 * Created by antonio on 20/09/2017.
 */

public class Resultado {
    private double media;
    private int aprobados;

    public Resultado(double media, int aprobados) {
        this.media = media;
        this.aprobados = aprobados;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public int getAprobados() {
        return aprobados;
    }

    public void setAprobados(int aprobados) {
        this.aprobados = aprobados;
    }
}
