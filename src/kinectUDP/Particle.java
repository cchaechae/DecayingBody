package kinectUDP;

import processing.core.PApplet;
import processing.core.PVector;


public class Particle {
	PVector location;
	PVector velocity;
	PVector referenceV;
	PVector referenceL;
	
	int impatience = 0;
	int clr;
	int velocityY = 1;
	PApplet app;
	boolean clicked = false;
	
	public Particle(PApplet app, int x, int y, int clr){
		this.app = app;
		location = new PVector(x,y);
		velocity = new PVector();
		referenceV = new PVector();
		referenceL = new PVector(x,y);
	    this.clr = clr;
	}
	
	public void mouseClicked(){
		clicked = true;
	}
	
	public void update(){

		int x = PApplet.round(location.x);
		int y = PApplet.round(location.y);
		PVector newLoc = PVector.add(location,velocity);
		int newX = PApplet.round(newLoc.x);
		int newY = PApplet.round(newLoc.y);
		// it is moving
		if(clicked){
		if((x==newX && y == newY) == false){
			if(newX < 0 || newX >= app.width){
				velocity.x *= -0.5;
			}else if(newY < 0 || newY >= app.height){
		        velocity.y *= -0.3;
		      }else{
		          PVector delta = PVector.sub(referenceV,velocity);
		          delta.mult((float)0.8);
		          float heat = impatience/3f;
		          delta.add(new PVector(app.random(-heat,heat), app.random(-heat,heat)));
		          velocity.add(delta);
		          referenceV.sub(delta);
		          impatience++;
		          if(impatience > 4){
		        	  impatience = 4;
		          }
		          location = newLoc;
		      }
			}
		velocity.y += 0.1;	
		}
		
		app.set((int)location.x, (int)location.y, clr);
	}	
}

