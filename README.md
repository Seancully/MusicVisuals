# Music Visualiser Project
# CLASS GROUP: TU856/2

Name: Sean Culleton
Student Number: C21397083

Name: David McCormack
Student Number: C21755305

Name: Jack O' kelly
Student Number: C21461876

Name: John Hinch
Student Number: C21718369

# Description of the assignment
Our groups Music Visualizer compiles a montage of different visuals all inspired by the song "Eyelar" by Fred Again. The song was split into parts which transition using an in-built timer. These parts/animation showcase our creative and technical skills for object oriented programming in Java, as part of this music visualier project.

# Instructions
press fn + f5 and watch the code on VSC, also press spacebar and it begins.
or watch it here on Youtube: https://youtu.be/dfZdfHreKV8

# Screenshots of animations
### Eyelar Intro
![A different image](https://oopassignment.files.wordpress.com/2023/05/eyelar-1.jpeg?w=1024)

### Solar System
![A different image](https://oopassignment.files.wordpress.com/2023/05/solar.jpeg?w=1024)

### Horizon Vertex
![A different image](https://oopassignment.files.wordpress.com/2023/05/vertex.jpeg?w=1024)

### Eye
![A different image](https://oopassignment.files.wordpress.com/2023/05/eye.jpeg?w=1024)

### Eyelar Outro
![A different image](https://oopassignment.files.wordpress.com/2023/05/outro.jpeg?w=1024)

# How it works
### Timer
A timing system used throughout the program that dictates which visuals play at which time. Depending on the time set.

### Stars
We used a background(0) to create a black background and created a star class, this star class was then used to create stars in a for loop using a speed set by smoothedAmplitude.

### Eyelar intro
We used text that came letter by letter for eyelar using if and if else statements.

### Solar system
We used ellipses that rotate using a theta variable and translate() to create planets that rotate around one big planet

### Horizon Vertex
We used vertexes to create an animation of a blue horizon as if you are speeding through the horizon. The vertexes took parameters that changed in a for loop to create the animation.

### Eye
The eye is quite similiar to the vertex, we took in different parameters for the eye that changed the animation in a for loop. Also, there were 3 stars moving in random directions that only became visible when infront of the blue in the eye.

### Eyelar Outro
It is similiar also to the horizon vertex, the circles were removed and it gradually faded to the starry night alone again then into a black screen to finish the visuals off. The horizon was also made thinner.

# LIST OF CLASSES/ASSETS
| Class/asset | Source |
|-----------|-----------|
| Eyelar.java | Self written and modified from [reference](https://thecodingtrain.com/) |
| Star.java | modified from [reference](https://thecodingtrain.com/) |
| SolarSystem.java | Modified from [reference](http://learningprocessing.com/examples/chp14/example-14-16-solar-system) |
| Eye.java | Modified From [reference](https://www.youtube.com/watch?v=xAuwouEEJss) |
| Horizon.java| Modified From Eye.java class |
| EyeOutro.java | Modified From Horizon.java class|

# Each team member or individual needs to write a paragraph or two explaining what they contributed to the project
## Sean:
### WHAT I DID:
I created a solar system animation where planets rotate as if they are in space rotating around a centre point. It acts as though you should feel the mood and atmosphere of the music to be quite calming. This fits the solar system animation quite well.
### WHAT IM MOST PROUD OF:
- Working together as a team to overcome obstacles and to gain a sense of what it will feel like to work in coding teams in an internship next year (hopefully).
- How creative we became with coming up with and implementing the different visual animations with the music.
- How well the animations worked together all being linked by a starry night and a blue pallet of colours.
- Gaining a greater understanding of java processing systems.
- How I learned to yse translation and also pushMatrix(0 and popMatrix() for the planets transformations.
### WHAT I LEARNED:
- How to cause the planets to rotate around a centre pont using the translate() and also the rotate() method using a 'theta' variable 
- How other functions in Java Processing work such as pushMatrix(0 and popMatrix(), also experimented with 
- How to be creative, and work around issues by testing code repeatedly and coming up with new designs and implementing them too.

## Dave:
### What I did:
In this project i decided to make an intro to the video with a stars in the background to give it that space effect. I then added the title of the song on top of the background . Each few seconds at the start of the video a new letter pops up spelling out the name of the song. I added a second letter under each of the others with a different colour to make a 3D effect. I then added a welcome text with the same concept at the end of the intro. 
### What I am most proud of:
In this project I am most proud of all the work we got done as a group and what we achieved. 
### What I learned: 
In this project I learned more about java processing and how the different functions work. I also learned how to work better in a group by allocating each other different tasks to do.

## Jack:
### WHAT I DID:
I contributed to the project by creating the last visual in the video. I wanted to create something that looked like the vertex was starting to close because the song is coming to an end, and it acts as a nice closing for the visuals. 
### WHAT I AM MOST PROUD OF
What I am most proud of is that I learned how to work in a team better so I could get a better feeling on how next year in semester 2 will be when we go on our internships. 
### WHAT I LLEARNED
I learned how work can be delegated between the group and everyone had a task to complete. I also learned what you can really create using Java processing if you sit down for a few hours and test and edit code to create something amazing and unusual.

## John:

# References
* https://thecodingtrain.com
* http://learningprocessing.com/examples/chp14/example-14-16-solar-system
* https://processing.org/
* https://www.youtube.com/watch?v=xAuwouEEJss 
