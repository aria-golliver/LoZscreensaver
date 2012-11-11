import processing.core.*; 
import processing.data.*; 
import processing.opengl.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class LoZscreensaver extends PApplet {

PImage img;

int imgPos = 0;

int imgHeight;
int imgWidth;
double scaleFactor;
int scaledWidth;
int scaledHeight;


public void setup() {
  size(displayWidth,displayHeight);
  noCursor();
  
  img = loadImage("loz.jpg");
  imgWidth = img.width;
  imgHeight = img.height;
  scaleFactor = (double) displayWidth / (double) imgWidth;
  scaledWidth = (int)(imgWidth * scaleFactor);
  scaledHeight = (int)(imgHeight * scaleFactor);
  
  frameRate(60);
}

public void draw() {
  background(0);
  image(img,0,imgPos               ,scaledWidth,scaledHeight);
  image(img,0,imgPos + scaledHeight,scaledWidth,scaledHeight);
  
 imgPos -= 1; 
 imgPos = imgPos % scaledHeight;
}

public void mouseMoved(){
  if(frameCount > 1) exit();
}
public void keyPressed(){
  if(frameCount > 1) exit();
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--hide-stop", "LoZscreensaver" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
