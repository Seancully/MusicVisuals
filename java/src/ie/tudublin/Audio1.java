package ie.tudublin;

// Navy Blue		Blue Grotto			Blue Green			Baby Blue
// (5, 68, 94)		(24, 154, 180)		(117, 230, 218)		(212, 241, 244)

//import example.*;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Audio1 extends PApplet {
	Minim minim;
	AudioPlayer ap;
	AudioInput ai;
	AudioBuffer ab;
	public Timer timer;

	int mode = 0;
	float seconds = 0;
	float theta=0;

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

	public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
			if (ap.isPlaying()) {
				ap.pause();
			} else {
				ap.rewind();
				ap.play();
			}
		}
		if (keyCode == '7') {
			seconds = 0;
		}
	}

	public void settings() {
		// size(2560 ,1600);
		fullScreen(P3D, SPAN);
	}

	public void setup() {
		minim = new Minim(this);

		timer = new Timer(this);
		// Load Music file
		ap = minim.loadFile("Eyelar.mp3", 1024);
		ap.play();
		ab = ap.mix;

		y = height / 2;
		smoothedY = y;

		for (int i = 0; i < 800; i++) {
			stars.add(new Star());
		}

		globe = new PVector[total + 1][total + 1];
		for (int i = 0; i < total + 1; i++) {
			float lat = map(i, 0, total, 0, PI);
			for (int j = 0; j < total + 1; j++) {
				float lon = map(j, 0, total, 0, TWO_PI);
				float x = r * sin(lat) * cos(lon);
				float y = r * sin(lat) * sin(lon);
				float z = r * cos(lat);
				globe[i][j] = new PVector(x, y, z);
			}
		}

	}

	float off = 0;

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

	public void draw() {
		// timer.update();
		float halfH = height / 2;
		float halfW = width / 2;
		float average = 0;
		float sum = 0;
		off += 1;
		// Calculate sum and average of the samples
		// Also lerp each element of buffer;
		for (int i = 0; i < ab.size(); i++) {
			sum += abs(ab.get(i));
		}
		average = sum / (float) ab.size();

		smoothedAmplitude = lerp(smoothedAmplitude, average, 0.2f);

		float cx = width / 2;
		float cy = height / 2;

		seconds = millis() / 1000.0f;
		System.out.println(seconds);
		
		//Intro
		if (seconds >= 2 && seconds < 6) {

			speed = map(50, 0, width, 0, 50);
			background(0);

			for (int i = 0; i < stars.size(); i++) {
				stars.get(i).update();
				stars.get(i).show();
			}

			strokeWeight(1);

			rectMode(PApplet.CENTER);

			fill(0, 0, 255);
			textSize(200);
			text("E", width / 2 - 350, height / 2 + 80);

		}

		else if (seconds >= 6 && seconds < 9) {

			speed = map(50, 0, width, 0, 50);
			background(0);

			for (int i = 0; i < stars.size(); i++) {
				stars.get(i).update();
				stars.get(i).show();
			}

			strokeWeight(1);

			rectMode(PApplet.CENTER);

			fill(5, 92, 242);
			textSize(200);
			text("EY", width / 2 - 350, height / 2 + 80);

		}

		else if (seconds >= 9 && seconds < 12) {

			speed = map(50, 0, width, 0, 50);
			background(0);

			for (int i = 0; i < stars.size(); i++) {
				stars.get(i).update();
				stars.get(i).show();
			}

			strokeWeight(1);

			rectMode(PApplet.CENTER);

			fill(12, 71, 173);
			textSize(200);
			text("EYE", width / 2 - 350, height / 2 + 80);

		}

		else if (seconds >= 12 && seconds < 15) {

			speed = map(50, 0, width, 0, 50);
			background(0);

			for (int i = 0; i < stars.size(); i++) {
				stars.get(i).update();
				stars.get(i).show();
			}

			strokeWeight(1);

			rectMode(PApplet.CENTER);
			fill(59, 127, 245);
			textSize(200);
			text("EYEL", width / 2 - 350, height / 2 + 80);

		}

		else if (seconds >= 15 && seconds < 18) {

			speed = map(50, 0, width, 0, 50);
			background(0);

			for (int i = 0; i < stars.size(); i++) {
				stars.get(i).update();
				stars.get(i).show();
			}

			strokeWeight(1);

			rectMode(PApplet.CENTER);
			fill(14, 52, 117);
			textSize(200);
			text("EYELA", width / 2 - 350, height / 2 + 80);

		}
		//End Intro
		else if (seconds >= 18 && seconds < 20) {

			speed = map(50, 0, width, 0, 50);
			background(0);
			for (int i = 0; i < stars.size(); i++) {
				stars.get(i).update();
				stars.get(i).show();
			}

			strokeWeight(1);

			rectMode(PApplet.CENTER);
			fill(12, 98, 245);
			textSize(200);
			text("EYELAR", width / 2 - 350, height / 2 + 80);

			
			//Solar System
		} else if (seconds >= 20 && seconds < 35) {
			float r = map(smoothedAmplitude, 0, 0.5f, 100, 2000);
			background(0);
			stroke(0);
			speed = map(80, 0, width, 0, 50);

			for (int i = 0; i < stars.size(); i++) {
				stars.get(i).update();
				stars.get(i).show();
			}

			// Translate to center of window to draw the sun.
			translate(width / 2, height / 2);
			fill(84, 143, 168);
			ellipse(0, 0, 320, 320);
			fill(0);
			ellipse(0, 0,((r + 150) + (smoothedAmplitude - 500))/2,((r + 150) + (smoothedAmplitude - 500))/2);

			// The earth rotates around the sun
			pushMatrix();
			rotate(theta);
			translate(250, 0);
			fill(5, 68, 94);
			ellipse(0, 0, 160, 160);
			
			// Moon #1 rotates around the earth
			// pushMatrix() is called to save the transformation state before drawing moon
			// #1.
			// This way we can pop and return to earth before drawing moon #2.
			// Both moons rotate around the earth (which itself is rotating around the sun).
			//pushMatrix();
			rotate(-theta * 4);
			translate(150, 0);
			fill(24, 154, 180);
			ellipse(0, 0, 60, 60);
			//popMatrix();

			// Moon #2 also rotates around the earth
			//pushMatrix();
			rotate(theta * 2);
			translate(100, 0);
			fill(212, 241, 244);
			ellipse(0, 0, 30, 30);
			//popMatrix();

			//pushMatrix();
			rotate(-theta * 4);
			translate(230, 0);
			fill(50, 255, 200);
			ellipse(0, 0, 45, 45);
			//popMatrix();

			//pushMatrix();
			rotate(-theta * 4);
			translate(285, 0);
			fill(117, 230, 218);
			ellipse(0, 0, 90, 90);
			//popMatrix();

			popMatrix();

			theta += 0.01;

		}// else if (seconds >= 25 && seconds < 35) {

		//}

		// Horizon vertex animation
		else if (seconds >= 35 && seconds < 45) {
			background(0);
			strokeWeight(2);
			noFill();
			beginShape();
			for (float i = 0; i < TWO_PI; i += 0.01f) {
				stroke(0);
				strokeWeight(15);
				float r1 = width / 1.5f;
				float x2 = r1 * cos(i);
				float y1 = r1 * pow(sin(i), 3) * 0.5f;
				// puts the eye in the center of the screen
				vertex(x2 + cx, y1 + halfH);

				stroke(84, 143, 168);
				strokeWeight(5);
				// make the ring go crazy and randomly but still on sync to music
				float r2 = width / 9 + (smoothedAmplitude * random(10, 150) * 2);
				float x = r2 * cos(i);
				// center the ring
				vertex(x + cx, 50 + halfH);
			}
			endShape(CLOSE);

			float r = map(smoothedAmplitude, 0, 0.5f, 100, 2000);
			stroke(84, 143, 168);
			circle(cx, cy, r + (smoothedAmplitude - 500));
			circle(cx, cy, (r + 150) + (smoothedAmplitude - 500));
			circle(cx, cy, (r - 150) + (smoothedAmplitude - 500));

		}

		else if (seconds >= 45 && seconds < 48) {
			background(0);
		}

		// eye animation
		else if (seconds >= 48) {
			// here is where the main eye is made too

			colorMode(RGB);
			background(0, 255, 0);

			halfH = height / 2;

			float total = 0;
			float amplitude = 0;
			float smoothedAmplitude = 0;
			for (int i = 0; i < ab.size(); i++) {
				total += abs(ab.get(i));
			}
			amplitude = total / ab.size();
			smoothedAmplitude = lerp(smoothedAmplitude, amplitude, 0.1f);
			// make visualizer more intense
			smoothedAmplitude = smoothedAmplitude * 3;

			// backgound colour
			background(0, 0, 0);

			// drawing the ring inside the eye
			noFill();
			beginShape();
			for (float i = 0; i < TWO_PI; i += 0.01f) {
				stroke(0);
				strokeWeight(15);
				float r1 = width / 2.5f;
				float x2 = r1 * cos(i);
				float y1 = r1 * pow(sin(i), 3) * 0.5f;
				// puts the eye in the center of the screen
				vertex(x2 + halfW, y1 + halfH);

				stroke(84, 143, 168);
				strokeWeight(5);
				// make the ring go crazy and randomly but still on sync to music
				float r = width / 9 + (smoothedAmplitude * random(10, 150) * 2);
				float x = r * cos(i);
				float y = r * sin(i);
				// center the ring
				vertex(x + halfW, y + halfH);
			}
			endShape(CLOSE);

			// create the iris
			strokeWeight(10);
			// the iris
			float radius = map(smoothedAmplitude, 0, 0.6f, width / 4, 500);
			fill(255, 255, 255);
			circle(halfW, halfH, radius);

			// draw the pupil for the eye
			float radius2 = map(smoothedAmplitude * 1.5f, 0, 0.7f, width / 20, 500);
			fill(0);
			circle(halfW, halfH, radius2 + 125);

			fill(0, 0, 255);
			circle(halfW, halfH, smoothedAmplitude);
			// drawing 3 random stars
			strokeWeight(2);
			for (int i = 0; i < 6; i++) {
				fill(0);
				stroke(0);
				star(random(width), random(height), 10, 19, 5);
				delay(10);
			}
		}
	}

	class Star {
		float x;
		float y;
		float z;
		float pz;

		Star() {
			x = random(-width / 2, width / 2);
			y = random(-height / 2, height / 2);
			z = random(width / 2);
			pz = z;
		}

		void update() {
			z = z - speed;
			if (z < 1) {
				z = width / 2;
				x = random(-width / 2, width / 2);
				y = random(-height / 2, height / 2);
				pz = z;
			}
		}

		void show() {
			fill(255);
			noStroke();

			float sx = map(x / z, 0, 1, 0, width);
			float sy = map(y / z, 0, 1, 0, height);

			float r = map(z, 0, width / 2, 8, 0);
			ellipse(sx, sy, r, r);

			float px = map(x / pz, 0, 1, 0, width);
			float py = map(y / pz, 0, 1, 0, height);

			stroke(255);
			line(px, py, sx, sy);

			pz = z;
		}
	}
}