package C21397083;

import java.util.ArrayList;
import ddf.minim.*;
import ie.tudublin.*;
import processing.core.PApplet;
import processing.core.PVector;

public class SolarSystem extends PApplet {
    Audio1 a1;
    Minim minim;
	AudioPlayer ap;
	AudioInput ai;
	AudioBuffer ab;
	public Timer timer; 

	int mode = 0;
	float seconds = 0;
	float theta = 0;

	float y = 0;
	float smoothedY = 0;
	float smoothedAmplitude = 0;
	ArrayList<Star> stars = new ArrayList<Star>();
	float speed;

	PVector[][] globe;
	int r = 200;
	int total = 25;
	float angleX = 0;
	float angleY = 0; 

    public SolarSystem(Audio1 a1) {
        this.a1 = a1;
    }

    public void render() {
        float r = map(a1.getSmoothedAmplitude(), 0, 0.5f, 100, 2000);
			a1.background(0);
			a1.stroke(0);
			speed = map(80, 0, a1.width, 0, 50);

			for (int i = 0; i < stars.size(); i++) {
				stars.get(i).update();
				stars.get(i).show();
			}

			a1.translate(a1.width / 2, a1.height / 2);
			a1.fill(84, 143, 168);
			a1.ellipse(0, 0, 320, 320);
			a1.fill(0);
			a1.ellipse(0, 0, ((r + 150) + (a1.getSmoothedAmplitude() - 500)) / 2, ((r + 150) + (smoothedAmplitude - 500)) / 2);

			a1.pushMatrix();
			a1.rotate(theta);
			a1.translate(250, 0);
			a1.fill(5, 68, 94);
			a1.ellipse(0, 0, 160, 160);

			a1.rotate(-theta * 4);
			a1.translate(150, 0);
			a1.fill(212, 241, 244);
			a1.ellipse(-40, -40, 40, 40);
			a1.fill(24, 154, 180);
			a1.ellipse(0, 0, 60, 60);

			a1.rotate(theta * 2);
			a1.translate(100, 0);
			a1.fill(50, 255, 200);
			a1.ellipse(-30, 30, 15, 15);
			a1.fill(212, 241, 244);
			a1.ellipse(0, 0, 30, 30);

			a1.rotate(-theta * 4);
			a1.translate(230, 0);
			a1.fill(212, 241, 244);
			a1.ellipse(-55, 55, 30, 30);
			a1.fill(50, 255, 200);
			a1.ellipse(0, 0, 45, 45);
	
			a1.rotate(-theta * 4);
			a1.translate(285, 0);
			a1.fill(212, 241, 244);
			a1.ellipse(-65, 65, 55, 55);
			a1.fill(117, 230, 218);
			a1.ellipse(0, 0, 90, 90);

			a1.popMatrix();

			theta += 0.01;

    }

    class Star {
        float x;
        float y;
        float z;
        float pz;
    
        Star() {
            x = random(-a1.width / 2, a1.width / 2);
            y = random(-a1.height / 2, a1.height / 2);
            z = random(a1.width / 2);
            pz = z;
        }
    
        void update() {
            z = z - speed;
            if (z < 1) {
                z = a1.width / 2;
                x = random(-a1.width / 2, a1.width / 2);
                y = random(-a1.height / 2, a1.height / 2);
                pz = z;
            }
        }
    
        void show() {
            fill(255);
            noStroke();
    
            float sx = map(x / z, 0, 1, 0, a1.width);
            float sy = map(y / z, 0, 1, 0, a1.height);
    
            float r = map(z, 0, a1.width / 2, 8, 0);
            ellipse(sx, sy, r, r);
    
            float px = map(x / pz, 0, 1, 0, a1.width);
            float py = map(y / pz, 0, 1, 0, a1.height);
    
            stroke(255);
            line(px, py, sx, sy);
    
            pz = z;
        }
    }

}
