package com.obrero.cmycountry.dto;

/**
 * Created by Eefret on three/one/14.
 */
public class DrawerItem {
    private int icon;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DrawerItem(int icon,String title) {
        this.icon = icon;
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
