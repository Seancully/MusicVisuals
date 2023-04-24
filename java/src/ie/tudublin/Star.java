package ie.tudublin;

import java.util.Random;
import processing.core.*;

public class Star {

    float x;
    float y;
    float z;
    float pz;
    float speed;
    Random rand = new Random();
    PApplet pa;

    Star(PApplet pa, float w, float h, float s) {
        this.pa = pa;
        x = rand.nextFloat() * (-w - w) + w;
        y = rand.nextFloat() * (-h - h) + h;
        z = rand.nextFloat() * w;
        pz = z;
        speed = s;
    }

    void update() {
        z = z - speed;
        if (z < 1) {
            z = pa.width;
            x = pa.random(-pa.width, pa.width);
            y = pa.random(-pa.height, pa.height);
            pz = z;
        }
    }

    void show() {
        pa.fill(255);
        pa.noStroke();

        float sx = PApplet.map(x / z, 0, 1, 0, pa.width);
        float sy = PApplet.map(y / z, 0, 1, 0, pa.height);

        float r = PApplet.map(z, 0, pa.width, 16, 0);
        pa.ellipse(sx, sy, r, r);

        float px = PApplet.map(x / pz, 0, 1, 0, pa.width);
        float py = PApplet.map(y / pz, 0, 1, 0, pa.height);

        pz = z;

        pa.stroke(255);
        pa.line(px, py, sx, sy);
    }
}