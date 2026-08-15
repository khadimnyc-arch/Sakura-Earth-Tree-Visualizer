import processing.core.PApplet;

public class Petal {

    private int xPos;
    private int yPos;
    private int speed;
    private int size;

    public Petal(){
        this.xPos = (int)(Math.random() * 600);
        this.yPos = (int)(Math.random() * -600);
        this.speed = (int)(Math.random() * 4 + 1);
        this.size = (int)(Math.random() * 2 + 1);
    }

    public void fall() {
        yPos += speed;
        xPos += (int)(Math.random()*10 - 5);
        if (yPos > 600) {
            yPos = 0;
        }
    }

    public void display(PApplet app){
        app.pushMatrix();
        app.translate(xPos, yPos);
        app.scale(size);
        app.noStroke();

        app.fill(255, 182, 193);
        for (int i = 0; i < 5; i++) {
            app.ellipse(0, -5, 5, 10);
            app.rotate(PApplet.TWO_PI / 5);
        }
        app.fill(255, 255, 150);
        app.ellipse(0, 0, 5, 5);

        app.popMatrix();
    }
}
