package assignment5;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/** the purpose of this example applet it to draw a boxy car out of basic graphical shapes (rectangles, circles and lines) on the applet window. It's position and size has been predetermined by sketching it out on graph paper first. The specific values of the coordinates of the shapes have been arbitrarily chosen. */

public class JavaCars extends Applet implements ActionListener {
	
	Dimension dim;	//stores dimmension of Applet window
	boolean StartFlag = false;	//Startflag for button
	Button button1 = new Button("Start Race");	//button that starts race
	Car a;	//cars
	Car b;
	Car c;
	Car d;
	Car e;
	Random rand = new Random();
	
	public void init()  
	     {	
			add(button1);					//setting up button and what to do when it is clicked
			button1.addActionListener(this);
	     }
	
	public void paint(Graphics g) { 
		int vp = 260;	//vertical position for drawstrings
		button1.setLocation(150, 200);	//setting the button location
		Graphics2D g2 = (Graphics2D)g; 
		// the following code sets up the finish line graphic
        int row;   // Row number, from 0 to 7
        int col;   // Column number, from 0 to 7
        int x,y;   // Top-left corner of square
        for (row = 0; row <5; row++){	
        	x = 0;
        	y = row * 45;
        	if (row%2 == 1){
        		g2.setColor(Color.lightGray);
        		g2.fillRect(x,y, 360, 45);
        	}
        	else{
        		g2.setColor(Color.darkGray);
        		g2.fillRect(x,y, 360, 45);
        	}
        }
     
        for ( row = 0;  row < 23;  row++ ) {	//finish line
        
           for ( col = 0;  col < 4;  col++) {
              x = col * 10 + 360;
              y = row * 10;
              if ( (row % 2) == (col % 2) )
                 g.setColor(Color.lightGray);
              else
                 g.setColor(Color.darkGray);
              g.fillRect(x, y, 10, 10);
           } 
        }
		if(StartFlag){
			remove(button1);	//get rid of button if race is starting
			for (row = 0; row <5; row++){	// remake the track over the button, since it leaves a white spot
	        	x = 0;
	        	y = row * 45;
	        	if (row%2 == 1){
	        		g2.setColor(Color.lightGray);
	        		g2.fillRect(x,y, 360, 45);
	        	}
	        	else{
	        		g2.setColor(Color.darkGray);
	        		g2.fillRect(x,y, 360, 45);
	        	}
	        }
			
			a.update(g2);		//update the positions of the cars
			b.update(g2);
			c.update(g2);
			d.update(g2);
			e.update(g2);
			Rectangle light = new Rectangle(170, 20,  40, 100); 	//setting up the ready set go light graphic
			Ellipse2D l1 = new Ellipse2D.Double(180, 30, 20 ,20);
			Ellipse2D l2 = new Ellipse2D.Double(180, 60, 20 ,20);
			Ellipse2D l3 = new Ellipse2D.Double(180, 90, 20 ,20);
			g2.setColor(Color.black);
			g2.fill(light);
			g2.setColor(Color.darkGray);
			g2.fill(l1);
			g2.fill(l2);
			g2.fill(l3);
			g2.setColor(Color.yellow);
			g2.fill(l1);
			StopWatch ti = new StopWatch();
			ti.start();
			while (ti.getElapsedTime() <= 1000){

			}
			ti.stop();
			ti.reset();
			g2.setColor(Color.darkGray);
			g2.fill(l1);
			g2.setColor(Color.yellow);
			g2.fill(l2);
			ti.start();
			while (ti.getElapsedTime() <= 1000){

			}
			ti.stop();
			ti.reset();
			g2.setColor(Color.darkGray);
			g2.fill(l2);
			g2.setColor(Color.green);
			g2.fill(l3);
			ti.start();
			while (ti.getElapsedTime() <= 1000){

			}
			ti.stop();
			ti.reset();
			 for (row = 0; row <5; row++){
		        	x = 0;
		        	y = row * 45;
		        	if (row%2 == 1){
		        		g2.setColor(Color.lightGray);
		        		g2.fillRect(x,y, 360, 45);
		        	}
		        	else{
		        		g2.setColor(Color.darkGray);
		        		g2.fillRect(x,y, 360, 45);
		        	}
		        }
			g2.setColor(Color.black);
			// now the race starts
			ti.start();// to time race
			while(StartFlag){
				a.incrementPos(rand.nextInt(5) + 1);	//increment the positions of cars by random amount not including 0
				b.incrementPos(rand.nextInt(5) + 1);
				c.incrementPos(rand.nextInt(5) + 1);
				d.incrementPos(rand.nextInt(5) + 1);
				e.incrementPos(rand.nextInt(5) + 1);
				a.update(g2);	//update car positions
				b.update(g2);
				c.update(g2);
				d.update(g2);
				e.update(g2);
				StopWatch timer = new StopWatch();	//create a new stopwatch to add a delay
				timer.start();
				while (timer.getElapsedTime() <= 100){	//this delay is to make the animation of cars moving look smoother

				}
				timer.stop();
				timer.reset();
				if (a.gethPosition() +60 >= 360){	//checking for victory
					StartFlag = false;	//if a car has won set the start flag to false so the while loop won't continue
					g2.drawString("Congrats to Car "+ a.carNum + " for winning!", 120, vp);	//print out congratulations
					vp+=12;	//increment vertical positions in case there are other winning cars

				}
				if (b.gethPosition()+60 >= 360){	// same as above
					StartFlag = false;
					g2.drawString("Congrats to Car "+ b.carNum + " for winning!", 120, vp);
					vp+=12;

				}
				if (c.gethPosition()+60 >= 360){
					StartFlag = false;
					g2.drawString("Congrats to Car "+ c.carNum + " for winning!", 120, vp);
					vp+=12;

				}
				if (d.gethPosition()+60 >= 360){
					StartFlag = false;
					g2.drawString("Congrats to Car "+ d.carNum + " for winning!", 120, vp);
					vp+=12;

				}
				if (e.gethPosition()+60 >= 360){
					StartFlag = false;
					g2.drawString("Congrats to Car "+ e.carNum + " for winning!", 120, vp);
					vp+=12;
				}


				
			} 
			ti.stop();	//stop timer
			g2.drawString("Race Time: " + ((double)ti.getElapsedTime()/1000) +" seconds", 120, vp); //print final race time in seconds
			ti.reset();	//reset timer
			add(button1);	//add button back in for next race
			
			//long time = ti.getElapsedTime();
			//g2.drawString(clock.getElapsedTime() , 0, 200);
			StartFlag = false;	//make sure startflag is false
		}
		// end of paint 
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		StartFlag = true;	//if button pressed the start flag is set to true
		
		int carNum = rand.nextInt(100);	//cars are created again
		a = new Car(20, carNum, Color.darkGray);
		while(Integer.parseInt(a.getCarN()) == carNum){
			carNum = rand.nextInt(100);
		}
		b = new Car(65, carNum, Color.lightGray);
		while(Integer.parseInt(a.getCarN()) == carNum || Integer.parseInt(b.getCarN()) == carNum){
			carNum = rand.nextInt(100);
		}
		c = new Car (110, carNum, Color.darkGray);
		while(Integer.parseInt(a.getCarN()) == carNum || Integer.parseInt(b.getCarN()) == carNum || Integer.parseInt(c.getCarN()) == carNum){
			carNum = rand.nextInt(100);
		}
		d = new Car(155, carNum, Color.lightGray);
		while(Integer.parseInt(a.getCarN()) == carNum || Integer.parseInt(b.getCarN()) == carNum || Integer.parseInt(c.getCarN()) == carNum || Integer.parseInt(d.getCarN()) == carNum){
			carNum = rand.nextInt(100);
		}
		e = new Car (200, carNum, Color.darkGray);
		repaint();	//race can start now, so repaint
		
	}
}
// end of CarDrawer 

