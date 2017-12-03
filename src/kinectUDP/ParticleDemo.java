package kinectUDP;
import processing.core.PApplet;


public class ParticleDemo extends PApplet{
	
	Particle[] field;
	
	static final int BOX_SIZE = 50;
	
	float radx;   // Radius
	float rady;
	float angle1; // angle
	float x;      // result
	float y;
	float minus = 40;
	
	public void settings() {
		size(300,400);
	}
	
	public void setup(){
		background(0);
		field = new Particle[5000];
		
		  for (int i=0; i < 5000; i++) {
			    radx=random(30);
			    rady=random(30);
			    angle1= random(359);
			   
			    x=(radx*cos(radians(angle1)))+width/2;
			    y=(radx*sin(radians(angle1)))+height/2;

			    field[i] = new Particle(this,(int)x,(int)y,color(random(0,255),random(0,255),random(0,255)));
		  }
	}
		
	public void draw(){
		background(0);
		if(mousePressed){
			for(int i=0;i<field.length;i++){
				if(field[i].location.y < height/2 - minus)
					field[i].mouseClicked();
			}
			minus = minus - 5;
		}
		for(int i=0;i<field.length;i++){
			if(field[i] != null)
				field[i].update();
		}
	}
	
	public static void main(String[] args) {
		PApplet.main(ParticleDemo.class.getName());
	}
}
