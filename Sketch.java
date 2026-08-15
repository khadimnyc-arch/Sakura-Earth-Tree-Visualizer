import processing.core.PApplet;

public class Sketch extends PApplet {

  Petal[] petals = new Petal[80];

  int startingLength = 180;  
  int minLength = 10;       
  float shrinkFactor = 0.67f;  
  int branchAngle = 45;     

  public void settings() {
    size(600, 600);
  }

  public void setup() {
    background(180, 220, 255);

    for(int i = 0; i < petals.length; i++){
        petals[i] = new Petal(); 
    }
  }

public void draw() {
    background(180, 220, 255);
    
    pushMatrix(); 
        translate(width/2, height);
        drawBranch(startingLength);
    popMatrix(); 

    noStroke();
    for(Petal p : petals){
        p.fall();  
        p.display(this); 
    }
}

  public void drawBranch(float length) {

    stroke(80, 50, 20);
    strokeWeight(length / 2);
    line(0, 0, 0, -length);

    translate(0, -length);

    if (length < minLength) {
      stroke(255, 182, 193);
      fill(255, 182, 193);

      for (int i = 0; i < 5; i++) {
          ellipse(0, -5, 5, 15);
          rotate(TWO_PI / 5);
      }

      fill(255, 255, 150);
      ellipse(0, 0, 10, 10);
      return;
    }

    pushMatrix();
    rotate(radians(branchAngle));
    drawBranch(length * shrinkFactor);
    popMatrix();

    pushMatrix();
    rotate(radians(-branchAngle));
    drawBranch(length * shrinkFactor);
    popMatrix();
  }

  public void drawPetal(){
    stroke(255, 182, 193);
    fill(255, 182, 193);

    for (int i = 0; i < 5; i++) {
        ellipse(0, -5, 5, 10);
        rotate(TWO_PI / 5);
    }

    fill(255, 255, 150);
    ellipse(0, 0, 5, 5);
  }
}
