import processing.core.PApplet;

import java.util.Random;

public class MainClass extends PApplet {
    int bgColor;
    int[] randomNum;
    int randomIndex =20;
    public static PApplet processing;
    public static void main(String[] args)
    {
        PApplet.main("MainClass",args);
    }

    @Override
    public void settings()
    {
        size(640 , 360);
    }
    @Override
    public void setup()
    {
        Initialize();
    }
    @Override
    public void draw()
    {
        ShowNum();
    }
    void Initialize() {
        processing = this;
        bgColor = 255;
        background(bgColor);
        randomNum = new int [randomIndex];
        for(int i = 0; i < randomIndex ; i++){
            randomNum[i] = (int)random(100);
        }
        frameRate(5);
    }
    void ShowNum(){
        int index = (int)random(randomIndex);
        int x= (int)random(width);
        int y = (int)random(height);
        fill((int)random(255)+1,(int)random(255)+1,(int)random(255)+1);
        ellipse(x,y,randomNum[index]*2,randomNum[index]*2);
        fill(255);
        textSize(randomNum[index]/2 + 1);
        textAlign(CENTER,CENTER);
        text(randomNum[index],x,y);

    }
}