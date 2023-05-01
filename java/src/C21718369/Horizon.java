package C21718369;

//import ddf.minim.AudioBuffer;
import ie.tudublin.*;

import processing.core.PApplet;

public class Horizon extends PApplet {
    Audio1 a1;
    //AudioBuffer ab;
    //float average = 0;
    //float sum = 0;
    //float off = 0;
    //float smoothedAmplitude=0;
    // Calculate sum and average of the samples
    // Also lerp each element of buffer;

    public Horizon(Audio1 a1) {
        this.a1 = a1;
    }

    public void render() {
        // Calculate sum and average of the samples
        // Also lerp each element of buffer;
        a1.colorMode(RGB);

        a1.background(0);
        float cx = a1.width / 2;
        float cy = a1.height / 2;
        a1.strokeWeight(2);
        a1.noFill();
        a1.beginShape();
        for (float i = 0; i < TWO_PI; i += 0.01f) {
            a1.stroke(0);
            a1.strokeWeight(15);
            float r1 = a1.width / 1.5f;
            float x2 = r1 * cos(i);
            float y1 = r1 * pow(sin(i), 3) * 0.5f;
            // puts the eye in the center of the screen
            a1.vertex(x2 + cx, y1 + cy);

            a1.stroke(84, 143, 168);
            a1.strokeWeight(5);
            // make the ring go crazy and randomly but still on sync to music
            float r2 = a1.width / 9 + (a1.getSmoothedAmplitude() * random(10, 150) * 2);
            float x = r2 * cos(i);
            // center the ring
            a1.vertex(x + cx, 50 + cy);
        }
        a1.endShape(CLOSE);

			float r = map(a1.getSmoothedAmplitude(), 0, 0.5f, 100, 2000);
			a1.stroke(84, 143, 168);
			a1.circle(cx, cy, r + (a1.getSmoothedAmplitude() - 500));
			a1.circle(cx, cy, (r + 150) + (a1.getSmoothedAmplitude() - 500));
			a1.circle(cx, cy, (r - 150) + (a1.getSmoothedAmplitude() - 500));
    }
}
