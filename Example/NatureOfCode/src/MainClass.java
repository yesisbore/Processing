import processing.core.PApplet;

public class MainClass extends PApplet {
    public static PApplet processing;
    int bgColor;
    int[] randomCounts;
    Walker w;

    public static void main(String[] args) {
        PApplet.main("MainClass", args);
    }

    public void settings() {
        this.size(800, 800);
    }

    public void setup() {
        this.Initialize();
    }

    public void draw() {
        this.rect(100.0F, 200.0F, 100.0F, 100.0F);
    }

    void Initialize() {
        processing = this;
        this.bgColor = this.color(255);
        this.background(this.bgColor);
        this.w = new Walker();
        this.randomCounts = new int[20];
    }

    void Walk() {
        this.w.Step();
        this.w.Display();
    }

    void RandomCount() {
        this.bgColor = this.color(255);
        int index = (int)this.random((float)this.randomCounts.length);
        int var10002 = this.randomCounts[index]++;
        this.stroke(0);
        this.fill(175);
        int w = this.width / this.randomCounts.length;

        for(int x = 0; x < this.randomCounts.length; ++x) {
            this.rect((float)(x * w), (float)(this.height - this.randomCounts[x]), (float)(w - 1), (float)this.randomCounts[x]);
        }

    }
}