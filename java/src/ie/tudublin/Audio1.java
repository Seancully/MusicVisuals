package ie.tudublin;

//import example.*;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet {
	Minim minim;
	AudioPlayer ap;
	AudioInput ai;
	AudioBuffer ab;
	public Timer timer;

	int mode = 0;

	float y = 0;
	float smoothedY = 0;
	float smoothedAmplitude = 0;

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
	}

	public void settings() {
		//size(1024, 1024, P3D);
		fullScreen(P3D, SPAN);
	}

	public void setup() {
		minim = new Minim(this);
		// Uncomment this to use the microphone
		// ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
		// ab = ai.mix;

		timer = new Timer(this);
		// And comment the next two lines out
		ap = minim.loadFile("Eyelar.mp3", 1024);
		ap.play();
		ab = ap.mix;
		// colorMode(HSB);

		y = height / 2;
		smoothedY = y;

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
		// background(0);
		float halfH = height / 2;
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

		timer.start();
		int seconds = timer.seconds();
		System.out.println(timer.seconds());
		switch (mode) {
			case (0):
				background(0);
				for (int i = 0; i < ab.size(); i++) {
					// float c = map(ab.get(i), -1, 1, 0, 255);
					float c = map(i, 0, ab.size(), 0, 255);
					stroke(c, 255, 255);
					float f = ab.get(i) * halfH;
					line(i, halfH + f, i, halfH - f);
				}
				break;
			case (1):
				background(0);
				colorMode(HSB);
				for (int i = 0; i < ab.size(); i++) {
					float c = map(ab.get(i), -1, 1, 0, 255);
					// float c = map(i, 0, ab.size(), 0, 255);
					stroke(c, 255, 255);
					float f = ab.get(i) * halfH;
					line(i, halfH + f, halfH - f, i);
				}
				break;
			case 2:
				background(0);
				for (int i = 0; i < ab.size(); i++) {

					float c = map(i, 0, ab.size(), 0, 255);
					stroke(c, 255, 255);
					float f = ab.get(i) * halfH;
					line(i, 0 + f, i, 0 - f);
					line(0 + f, i, 0 - f, i);
					line(height + f, i, height - f, i);
					line(i, 1000 + f, i, 1000 - f);
				}
				break;

			case 3:
				background(0);
				strokeWeight(2);
				noFill();
				float r = map(smoothedAmplitude, 0, 0.5f, 100, 2000);
				float c = map(smoothedAmplitude, 0, 0.5f, 0, 255);
				stroke(c, 255, 255);
				circle(cx, cy, r+(smoothedAmplitude-500));
				circle(cx, cy, (r+150)+(smoothedAmplitude-500));
				circle(cx, cy, (r-150)+(smoothedAmplitude-500));
				break;

			case 4:
				background(0);
				strokeWeight(2);
				noFill();
				float point = map(smoothedAmplitude, 0, 0.5f, 100, 2000);
				float colour = map(smoothedAmplitude, 0, 0.5f, 0, 255);
				stroke(colour, 255, 255);
				rectMode(CENTER);
				rect(cx, cy, point, point);
				break;
			case 5:
				background(0);
				for (int i = 0; i < ab.size(); i++) {

					float color = map(i, 0, ab.size(), 0, 255);
					stroke(color, 255, 255);
					float f = ab.get(i) * halfH;
					line(i, 0 + f, i, 0 - f);
					line(0 + f, i, 0 - f, i);
					line(height + f, i, height - f, i);
					line(i, 1000 + f, i, 1000 - f);

				}
				strokeWeight(2);
				noFill();
				float radius = map(smoothedAmplitude, 0, 0.5f, 100, 2000);
				float l = map(smoothedAmplitude, 0, 0.5f, 0, 255);
				stroke(l, 255, 255);
				circle(cx, cy, radius);
				break;
			case 6:
				// here is where the main eye is made too

				colorMode(RGB);
				background(0, 255, 0);

				float halfW = width / 2;
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

				// make background up in intensity depending on music
				colour = smoothedAmplitude * 1500;

				// backgound colour
				background(0, 0, 0);

				// drawing the ring inside the eye
				noFill();
				beginShape();
				for (float i = 0; i < TWO_PI; i += 0.01f) {
					stroke(0);
					strokeWeight(15);
					float r1 = width / 2.5f;
					float x1 = r1 * cos(i);
					float y1 = r1 * pow(sin(i), 3) * 0.5f;
					// puts the eye in the center of the screen
					vertex(x1 + halfW, y1 + halfH);

					stroke(84, 143, 168);
					strokeWeight(5);
					// make the ring go crazy and randomly but still on sync to music
					r = width / 9 + (smoothedAmplitude * random(10, 150) * 2);
					float x = r * cos(i);
					float y = r * sin(i);
					// center the ring
					vertex(x + halfW, y + halfH);
				}
				endShape(CLOSE);

				// create the iris
				strokeWeight(10);
				// float colors = map(smoothedAmplitude, 0, 0.5f, 0, 255);
				for (int i = 0; i < ab.size(); i++) {
					// the iris
					radius = map(smoothedAmplitude, 0, 0.6f, width / 4, 500);
					fill(255, 255, 255);
					circle(halfW, halfH, radius);

					// draw the pupil for the eye
					float radius2 = map(smoothedAmplitude * 1.5f, 0, 0.7f, width / 20, 500);
					fill(0);
					circle(halfW, halfH, radius2+125);

					fill(0,0,255);
					circle(halfW, halfH, smoothedAmplitude);
				}
				// drawing 3 random stars
				strokeWeight(2);
				for (int i = 0; i < 6; i++) {
					fill(0);
					stroke(0); 
					//circle(random(width), random(height), random(width));
					star(random(width),random(height),10,19,5);
					delay(10);
				}

				break;
		}

	}
}
