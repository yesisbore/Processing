import processing.core.PApplet;

public class MainClass extends PApplet {
    public static PApplet processing;
    public static void main(String[] args)
    {
        PApplet.main("MainClass",args);
    }

    int bgColor ;
    int[] randomCounts;
    Walker w;

    @Override
    public void settings()
    {
        size(800,800);
    }
    @Override
    public void setup()
    {
        Initialize();
    }
    @Override
    public void draw()
    {

    }

    void Initialize()
    {
        processing = this;
        bgColor = color(255);
        background(bgColor);
        w = new Walker();
        randomCounts = new int[20];
    }
    void Walk()
    {
        w.Step();
        w.Display();
    }
    void RandomCount()
    {
        bgColor = color(255);

        int index = (int)random(randomCounts.length);
        randomCounts[index]++;

        stroke(0);
        fill(175);
        int w = width / randomCounts.length;

        for(int x = 0; x < randomCounts.length; x++){
            rect(x * w, height - randomCounts[x], w - 1 , randomCounts[x]);
        }
    }
}
