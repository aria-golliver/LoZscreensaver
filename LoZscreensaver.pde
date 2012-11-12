PImage img;

int imgPos = 0;

int imgHeight;
int imgWidth;
double scaleFactor;
int scaledWidth;
int scaledHeight;

int speed = 1;


void setup() {
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

void draw() {
  background(0);
  image(img,0,imgPos               ,scaledWidth,scaledHeight);
  image(img,0,imgPos + scaledHeight,scaledWidth,scaledHeight);
  
 imgPos -= speed; 
 imgPos = imgPos % scaledHeight;
}

void mouseMoved(){
  if(frameCount > 1) exit();
}
void keyPressed(){
  if(frameCount > 1) exit();
}
