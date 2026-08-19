package com.mycompany.biblioteca;

public class Material {
    protected String codigo;
    protected String titulo;
    protected int anioPublic;

    public Material(String codigo, String titulo, int anioPublic) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anioPublic = anioPublic;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioPublic() {
        return anioPublic;
    }

    public void setAnioPublic(int anioPublic) {
        this.anioPublic = anioPublic;
    }

    @Override
    public String toString() {
        return "Material{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", anioPublic=" + anioPublic +
                '}';
    }
}