import processing.core.PApplet;

import java.util.Random;

public class MainClass extends PApplet {
    public static PApplet processing;
    int bgColor;
    int[] randomCounts;

    float t =0;

    Walker w;
    Random generator;

    public static void main(String[] args) {
        PApplet.main("MainClass", args);
    }

    public void settings() {
        this.size(640 , 360);
    }

    public void setup() {
        this.Initialize();SecondPerinNoise();
    }

    public void draw() {
        //PerinNoise ();
    }

    void Initialize() {
        processing = this;
        this.bgColor = this.color(255);
        this.background(this.bgColor);
        this.w = new Walker();
        this.randomCounts = new int[20];
        generator = new Random();
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

    void GaussianCircle(){
        // Double 형을 반환하는 0 - 1의 정규 분포
        float num = ( float) generator.nextGaussian();

        float sd = 60 ;
        float mean = 320;

        // 표준 편차를 더하고 평균을 곱해준다.
        float x = sd * num + mean;

        noStroke();
        fill(0,10);
        ellipse(x,180,16,16);
    }

    void PerinNoise (){
        // Noise(num) 함수는 연속된 값을 내보낸다
        float n = noise(t);

        float x = map (n,0,1,0,width);
        ellipse(x,180,16,16);
        t += 0.01f;
    }
    void MakePixel(){
        loadPixels();
        for (int x = 0; x < width; x ++){
            for (int y = 0; y < height; y ++) {
                float bright  = random(255);
                pixels[x + y * width] = color(bright);
            }
        }
        updatePixels();
    }
    void SecondPerinNoise(){
        float xoff = 0.0f;
        loadPixels();
        for (int x = 0; x < width; x ++){
            float yoff = 0.0f;
            for (int y = 0; y < height; y ++) {
                float bright  = map(noise(xoff,yoff),0,1,0,255);
                pixels[x + y * width] = color(bright);
                yoff += 0.01f;
            }
            xoff += 0.01f;
        }
        updatePixels();
    }
}