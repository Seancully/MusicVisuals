package C2175505;

import ie.tudublin.*;

import processing.core.PApplet;

public class Eye extends PApplet {
    Audio1 a1;    
    float speed;


	public Eye(Audio1 a1)
    {
        this.a1=a1;
    }

    void star(float x, float y, float radius1, float radius2, int npoints) {
		float angle = TWO_PI / npoints;
		float halfAngle = (float) (angle / 2.0);
		beginShape();
		for (float a = 0; a < TWO_PI; a += angle) {
			float sx = x + cos(a) * radius2;
			float sy = y + sin(a) * radius2;
			vertex(sx, sy);
			sx = x + cos(a + halfAngle) * radius1;
			sy = y + sin(a + halfAngle) * radius1;
			vertex(sx, sy);
		}
		endShape(CLOSE);
	}
    public void render(){
        // eye animation
			// here is where the main eye is made too

			a1.colorMode(RGB);
			background(0, 255, 0);

			float halfH = a1.height / 2;
            float halfW=a1.width/2;

			float amplitude=0;
			float smoothedAmplitude = 0;
			/*for (int i = 0; i < ab.size(); i++) {
				total += abs(ab.get(i));
			}
			amplitude = total / ab.size();
			smoothedAmplitude = lerp(getSmoothedAmplitude(), amplitude, 0.1f);
			*/
			a1.calculateAverageAmplitude();
			// make visualizer more intense
			smoothedAmplitude =a1.getSmoothedAmplitude();
			smoothedAmplitude =smoothedAmplitude* 3;

			// backgound colour
			a1.background(0, 0, 0);

			// drawing the ring inside the eye
			a1.noFill();
			a1.beginShape();
			for (float i = 0; i < TWO_PI; i += 0.01f) {
				a1.stroke(0);
				a1.strokeWeight(15);
				float r1 = width / 2.5f;
				float x2 = r1 * cos(i);
				float y1 = r1 * pow(sin(i), 3) * 0.5f;
				// puts the eye in the center of the screen
				vertex(x2 + halfW, y1 + halfH);

				a1.stroke(84, 143, 168);
				a1.strokeWeight(5);
				// make the ring go crazy and randomly but still on sync to music
				float r = width / 9 + (smoothedAmplitude * random(10, 150) * 2);
				float x = r * cos(i);
				float y = r * sin(i);
				// center the ring
				a1.vertex(x + halfW, y + halfH);
			}
			a1.endShape(CLOSE);

			// create the iris
			a1.strokeWeight(10);
			// the iris
			float radius = map(smoothedAmplitude, 0, 0.6f, a1.width / 4, 500);
			a1.fill(255, 255, 255);
			a1.circle(halfW, halfH, radius);

			// draw the pupil for the eye
			float radius2 = map(smoothedAmplitude * 1.5f, 0, 0.7f, a1.width / 20, 500);
			a1.fill(0);
			a1.circle(halfW, halfH, radius2 + 125);

			a1.fill(0, 0, 255);
			a1.circle(halfW, halfH, smoothedAmplitude);
			// drawing 3 random stars
			a1.strokeWeight(2);
			for (int i = 0; i < 6; i++) {
				a1.fill(0);
				a1.stroke(0);
				star(random(a1.width), random(a1.height), 10, 19, 5);
				a1.delay(10);
			}
		}
       
    }

