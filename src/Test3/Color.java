package Test3;

import java.util.Objects;

public final class Color {
    /*成员变量*/
    private int red;
    private int green;
    private int blue;
    /*构造器*/
    public Color(int r,int g,int b){
        if (r < 0 || g < 0 || b < 0) {
            throw new IllegalArgumentException("颜色值不能为负");
        }
        if (r > 255 || g > 255 || b > 255) {
            throw new IllegalArgumentException("颜色值过大");
        }

        this.red=r;
        this.green=g;
        this.blue=b;
    }
    Color(){

    }
    Color(Color o){
        red=o.red;
        green=o.green;
        blue=o.blue;
    }
    /*get*/
    public int getBlue() {
        return blue;
    }

    public int getGreen() {
        return green;
    }

    public int getRed() {
        return red;
    }
    /*set*/
    public void setBlue(int blue) {
        if (blue<0) {
            throw new IllegalArgumentException("颜色值不能为负");
        }
        if (blue>255) {
            throw new IllegalArgumentException("颜色值过大");
        }
        this.blue = blue;
    }

    public void setGreen(int green) {
        if (green < 0) {
            throw new IllegalArgumentException("颜色值不能为负");
        }
        if (green > 255) {
            throw new IllegalArgumentException("颜色值过大");
        }
        this.green = green;
    }

    public void setRed(int red) {
        if (red < 0) {
            throw new IllegalArgumentException("颜色值不能为负");
        }
        if (red > 255) {
            throw new IllegalArgumentException("颜色值过大");
        }
        this.red = red;
    }

    public void setColor(int RGB){
        red = RGB >> 16;
        RGB -= red << 16;
        green = RGB >> 8;
        RGB -= green << 8;
        blue = RGB;
    }
    int toInt(){
        return (red << 16) + (green << 8) + blue;
    }
    String toHex(){
        return Integer.toHexString(toInt());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return red == color.red &&
                green == color.green &&
                blue == color.blue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue);
    }

    @Override
    public String toString() {
        return "rgb(" +
                "" + red +
                ", " + green +
                ", " + blue +
                ')';
    }
}
