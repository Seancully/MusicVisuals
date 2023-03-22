package c21718369;

import example.MyVisual;
import ie.tudublin.*;

//importing the processing for the 
import processing.core.PApplet;

public class Sphere
{   
    MyVisual sv;

    //setting up the variables
    float box = 200;
    float rotation = 0;
    float WindW;
    float WindH;

    public Sphere(MyVisual sv) {
        this.sv = sv;
    }
    
    public void render() {

        //finding the middle of the window
        WindW = sv.width/2;
        WindH = sv.height/2;

        sv.pushMatrix(); 
        sv.noFill();
        //setting the position of the shapes
        sv.translate(WindW, WindH, 0);
        //setting the rotation of the shapes
        sv.rotateX(rotation); 
        sv.rotateY(rotation);
        //setting the line thickness to 1
        sv.strokeWeight(1);
        //changing the colours of the lines in relation to the Amplitude of the song
        sv.stroke(PApplet.map(sv.getSmoothedAmplitude()*2, 0, 1, 0, 255), 255, 255);
        //incrementing rotatioin so the shapes turn slightly each frame
        /*if (sv.timer.seconds() <= 145)
        {
            rotation += 0.01f;
        }
        else if(sv.timer.seconds() > 145 && sv.timer.seconds() <= 247)
        {
            rotation += 0.02f;
        }
        else
        {
            rotation += 0.04f;
        }*/
        
        //making the shapes
        sv.box(box);
        sv.sphere(150/2 * sv.getSmoothedAmplitude() * 5); //Declaring the sphere to half the size of the box to make sure it will fit inside
        sv.popMatrix(); 

        //adding smaller box/shpere on the left side
        //setting the width to 1/4 the way accross the window
        WindW = sv.width/4;
        sv.pushMatrix();
        //setting the position of the new shapes
        sv.translate(WindW, WindH, 0);
        //making the shapes rotate
        sv.rotateX(rotation);
        sv.rotateY(rotation);
        //making the smaller shapes
        sv.box(box/2);
        sv.sphere(150/4 * sv.getSmoothedAmplitude() * 5);
        sv.popMatrix();

        //adding smaller box/shpere on the right side
        //setting the width to 3/4 the way accross the window
        WindW = (sv.width*3)/4;
        sv.pushMatrix();
        //setting the position of the new shapes
        sv.translate(WindW, WindH, 0);
        //making the shapes rotate
        sv.rotateX(rotation);
        sv.rotateY(rotation);
        //making the smaller shapes
        sv.box(box/2);
        sv.sphere(150/4 * sv.getSmoothedAmplitude() * 5);
        sv.popMatrix();

        
    }
}

