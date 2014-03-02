package com.obrero.cmycountry.dto;

/**
 * Created by BlackShadow on 3/1/14.
 */
public class Picture {
    private String title;
    private String path;
    private String descripcion;

    public Picture(String title, String path, String descripcion) {
        this.title = title;
        this.path = path;
        this.descripcion = descripcion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
