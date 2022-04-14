import processing.core.PApplet;

public class Walker {
    public PApplet ps = MainClass.processing ;
    int x ;
    int y;
    Walker()
    {
        x = ps.width / 2 ;
        y = ps.height /2 ;
    }
    public void Display()
    {
        ps.stroke(0);
        ps.point(x,y);
    }
    void Step()
    {
        var stepX = (int)ps.random(3) -1;
        var stepY = (int)ps.random(3) -1;

        x += stepX;
        y += stepY;
    }

}
