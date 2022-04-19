//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import processing.core.PApplet;

public class Walker {
    public PApplet ps;
    int x;
    int y;

    Walker() {
        this.ps = MainClass.processing;
        this.x = this.ps.width / 2;
        this.y = this.ps.height / 2;
    }

    public void Display() {
        this.ps.stroke(0);
        this.ps.point((float)this.x, (float)this.y);
    }

    void Step() {
        int stepX = (int)this.ps.random(3.0F) - 1;
        int stepY = (int)this.ps.random(3.0F) - 1;
        this.x += stepX;
        this.y += stepY;
    }
}
