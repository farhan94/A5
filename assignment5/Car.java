package assignment5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Random;

public class Car {
	
	Graphics2D car;
	public int hPosition;
	private int oldH;
	public int vPosition;
	Rectangle body;
	Ellipse2D.Double frontTire;
	Ellipse2D.Double rearTire; 
	Point2D.Double sp1; 
	Point2D.Double sp2;
	Point2D.Double sp3; 
	Point2D.Double sp4;
	Point2D.Double sp5; 
	Point2D.Double sp6;
	Point2D.Double sp7; 
	Point2D.Double sp8;
	Point2D.Double sp9; 
	Point2D.Double sp10; 
	
	Point2D.Double r1; 
	Point2D.Double r2;
	Point2D.Double r3; 
	Point2D.Double r4;
	Line2D.Double frontWindshield;
	Line2D.Double roofTop;
	Line2D.Double spoke1;
	Line2D.Double spoke2;
	Line2D.Double spoke3;
	Line2D.Double spoke4;
	Line2D.Double spoke5;
	Line2D.Double spoke6;
	Line2D.Double spoke7;
	Line2D.Double spoke8;
	Line2D.Double rearWindshield; 
	int snX;
	int snY;
	int snX2;
	int snY2;
	int snX3;
	int snY3;
	int snX4;
	int snY4;
	Color track;
	Color carColor;
	String carNum;
	
	/*public Car(int vPosition, int carN){
		this.vPosition = vPosition;
		hPosition = 0;
		body = new Rectangle(0,vPosition, 60, 10); 
		frontTire = new Ellipse2D.Double(hPosition + 10, vPosition + 10, 10,10);
		rearTire = new Ellipse2D.Double(hPosition + 40, vPosition + 10, 10,10);
		snX = 15;
		snY = 20;
		sp1 = new Point2D.Double(hPosition+15,vPosition+15);
		sp2 = new Point2D.Double(hPosition+snX,vPosition+snY);
		snX2 = 10;
		snY2 = 15;
		sp3 = new Point2D.Double(hPosition+snX2,vPosition+snY2);
		snX3 = 15;
		snY3 = 10;
		sp4 = new Point2D.Double(hPosition+snX3,vPosition+snY3);
		snX4 = 20;
		snY4= 15;
		sp5 = new Point2D.Double(hPosition+snX4,vPosition+snY4);
		sp6 = new Point2D.Double(hPosition+45,vPosition+15);
		sp7 = new Point2D.Double(hPosition+snX+30,vPosition+snY);
		sp8 = new Point2D.Double(hPosition+snX2+30,vPosition+snY2);
		sp9 = new Point2D.Double(hPosition+snX3+30,vPosition+snY3);
		sp10 = new Point2D.Double(hPosition+snX4+30,vPosition+snY4);
		spoke1 = new Line2D.Double(sp1, sp2);
		spoke2 = new Line2D.Double(sp1, sp3);
		spoke3 = new Line2D.Double(sp1, sp4);
		spoke4 = new Line2D.Double(sp1, sp5);
		spoke5 = new Line2D.Double(sp6, sp7);
		spoke6 = new Line2D.Double(sp6, sp8);
		spoke7 = new Line2D.Double(sp6, sp9);
		spoke8 = new Line2D.Double(sp6, sp10);
		r1 = new Point2D.Double(hPosition + 10, vPosition);
		r2 = new Point2D.Double(hPosition + 20, vPosition-10);
		r3 = new Point2D.Double(hPosition + 40, vPosition-10);
		r4 = new Point2D.Double(hPosition + 50, vPosition);
		
		frontWindshield = new Line2D.Double(r1, r2);
		roofTop = new Line2D.Double(r2, r3);
		rearWindshield = new Line2D.Double(r3, r4);
		Random col = new Random();
		track = Color.white;
		float r = (float) 0.749;
		float g = (float) 0.3411;
		carColor = new Color(r,g, 0);
		col.nextInt(100);
		carNum = ((Integer)carN).toString();
	}
	*/
	public Car(int vPosition, int carN, Color colr) {
		this.vPosition = vPosition;	//vertical pos of car
		hPosition = 0;	//current h position
		body = new Rectangle(0,vPosition, 60, 10); 	// the following are various parts of the car
		frontTire = new Ellipse2D.Double(hPosition + 10, vPosition + 10, 10,10);
		rearTire = new Ellipse2D.Double(hPosition + 40, vPosition + 10, 10,10);
		snX = 15;
		snY = 20;		//spokes x and y
		sp1 = new Point2D.Double(hPosition+15,vPosition+15);	//these are for the rims of the car
		sp2 = new Point2D.Double(hPosition+snX,vPosition+snY);
		snX2 = 10;
		snY2 = 15;
		sp3 = new Point2D.Double(hPosition+snX2,vPosition+snY2);
		snX3 = 15;
		snY3 = 10;
		sp4 = new Point2D.Double(hPosition+snX3,vPosition+snY3);
		snX4 = 20;
		snY4= 15;
		sp5 = new Point2D.Double(hPosition+snX4,vPosition+snY4);
		sp6 = new Point2D.Double(hPosition+45,vPosition+15);
		sp7 = new Point2D.Double(hPosition+snX+30,vPosition+snY);
		sp8 = new Point2D.Double(hPosition+snX2+30,vPosition+snY2);
		sp9 = new Point2D.Double(hPosition+snX3+30,vPosition+snY3);
		sp10 = new Point2D.Double(hPosition+snX4+30,vPosition+snY4);
		spoke1 = new Line2D.Double(sp1, sp2);			//these create the rims 
		spoke2 = new Line2D.Double(sp1, sp3);
		spoke3 = new Line2D.Double(sp1, sp4);
		spoke4 = new Line2D.Double(sp1, sp5);
		spoke5 = new Line2D.Double(sp6, sp7);
		spoke6 = new Line2D.Double(sp6, sp8);
		spoke7 = new Line2D.Double(sp6, sp9);
		spoke8 = new Line2D.Double(sp6, sp10);
		r1 = new Point2D.Double(hPosition + 10, vPosition);				
		r2 = new Point2D.Double(hPosition + 20, vPosition-10);
		r3 = new Point2D.Double(hPosition + 40, vPosition-10);
		r4 = new Point2D.Double(hPosition + 50, vPosition);
		track = colr;	//track color
		frontWindshield = new Line2D.Double(r1, r2);
		roofTop = new Line2D.Double(r2, r3);
		rearWindshield = new Line2D.Double(r3, r4);
		Random col = new Random();	// for car number
		
		float r = (float) 0.749;	//for burnt orange colors
		float g = (float) 0.3411;
		carColor = new Color(r,g, 0);	// car color
		col.nextInt(100);
		carNum = ((Integer)carN).toString();
		
	}

	public String getCarN(){
		return carNum;
	}
	public void incrementPos(int x){
		oldH = hPosition;		//increment the horizontal position by x
		hPosition+= x;
	}
	public int gethPosition(){
		return hPosition;
	}
	public void update(Graphics2D g2){
		g2.setColor(track);			//going to remove last position of car by drawing it again in the track color
		g2.fill(body); 
		g2.fill(frontTire); 
		g2.fill(rearTire); 
		g2.draw(spoke1);
		g2.draw(spoke2);
		g2.draw(spoke3);
		g2.draw(spoke4);
		g2.draw(spoke5);
		g2.draw(spoke6);
		g2.draw(spoke7);
		g2.draw(spoke8);
		g2.draw(frontWindshield); 
		g2.draw(roofTop); 
		
		g2.draw(rearWindshield);
		g2.drawString(carNum, oldH + 30, vPosition + 10);
		g2.setColor(carColor);
			//the following code will update all the positions of the parts of the car 
		body = new Rectangle(hPosition,vPosition, 60, 10); 
		frontTire = new Ellipse2D.Double(hPosition + 10, vPosition + 10, 10,10);
		rearTire = new Ellipse2D.Double(hPosition + 40, vPosition + 10, 10,10);
		sp1 = new Point2D.Double(hPosition+15,vPosition+15);
		sp6 = new Point2D.Double(hPosition+45,vPosition+15);
		if (snX >=10 && snX < 15 && snY >= 15 && snY < 20){
			snX++;
			snY++;
		}
		else if (snX >=15 && snX < 20 && snY <= 20 && snY > 15){
			snX++;
			snY--;
		}
		else if (snX <=20 && snX > 15 && snY <= 15 && snY > 10){
			snX--;
			snY--;
		}
		else if (snX <=15 && snX > 10 && snY >= 10 && snY < 15){
			snX--;
			snY++;
		}
		if (snX2 >=10 && snX2 < 15 && snY2 >= 15 && snY2 < 20){
				snX2++;
				snY2++;
			}
		else if (snX2 >=15 && snX2 < 20 && snY2 <= 20 && snY2 > 15){
				snX2++;
				snY2--;
			}
		else if (snX2 <=20 && snX2 > 15 && snY2 <= 15 && snY2 > 10){
				snX2--;
				snY2--;
			}
		else if (snX2 <=15 && snX2 > 10 && snY2 >= 10 && snY2 < 15){
				snX2--;
				snY2++;
			}
		if (snX3 >=10 && snX3 < 15 && snY3 >= 15 && snY3 < 20){
					snX3++;
					snY3++;
				}
		else if (snX3 >=15 && snX3 < 20 && snY3 <= 20 && snY3 > 15){
					snX3++;
					snY3--;
				}
		else if (snX3 <=20 && snX3 > 15 && snY3 <= 15 && snY3 > 10){
					snX3--;
					snY3--;
				}
		else if (snX3 <=15 && snX3 > 10 && snY3 >= 10 && snY3 < 15){
					snX3--;
					snY3++;
				}
		if (snX4 >=10 && snX4 < 15 && snY4 >= 15 && snY4 < 20){
			snX4++;
			snY4++;
		}
		else if (snX4 >=15 && snX4 < 20 && snY4 <= 20 && snY4 > 15){
			snX4++;
			snY4--;
		}
		else if (snX4 <=20 && snX4 > 15 && snY4 <= 15 && snY4 > 10){
			snX4--;
			snY4--;
		}
		else if (snX4 <=15 && snX4 > 10 && snY4 >= 10 && snY4 < 15){
			snX4--;
			snY4++;
		}
		sp2 = new Point2D.Double(hPosition+snX,vPosition+snY);
		sp3 = new Point2D.Double(hPosition+snX2,vPosition+snY2);
		sp4 = new Point2D.Double(hPosition+snX3,vPosition+snY3);
		sp5 = new Point2D.Double(hPosition+snX4,vPosition+snY4);
		sp7 = new Point2D.Double(hPosition+snX+30,vPosition+snY);
		sp8 = new Point2D.Double(hPosition+snX2+30,vPosition+snY2);
		sp9 = new Point2D.Double(hPosition+snX3+30,vPosition+snY3);
		sp10 = new Point2D.Double(hPosition+snX4+30,vPosition+snY4);
		spoke1 = new Line2D.Double(sp1, sp2);
		spoke2 = new Line2D.Double(sp1, sp3);
		spoke3 = new Line2D.Double(sp1, sp4);
		spoke4 = new Line2D.Double(sp1, sp5);
		spoke5 = new Line2D.Double(sp6, sp7);
		spoke6 = new Line2D.Double(sp6, sp8);
		spoke7 = new Line2D.Double(sp6, sp9);
		spoke8 = new Line2D.Double(sp6, sp10);
		r1 = new Point2D.Double(hPosition + 10, vPosition);
		r2 = new Point2D.Double(hPosition + 20, vPosition-10);
		r3 = new Point2D.Double(hPosition + 40, vPosition-10);
		r4 = new Point2D.Double(hPosition + 50, vPosition);
		frontWindshield = new Line2D.Double(r1, r2);
		roofTop = new Line2D.Double(r2, r3);
		rearWindshield = new Line2D.Double(r3, r4);
		//now we will draw the car in the new positions
		g2.fill(body);
		g2.draw(frontWindshield); 
		g2.draw(roofTop); 
		g2.draw(rearWindshield);
		g2.setColor(Color.black);
		g2.fill(frontTire); 
		g2.fill(rearTire); 
		g2.drawString(carNum, hPosition + 30, vPosition +10 );
		g2.setColor(Color.white);
		
		g2.draw(spoke1);
		g2.draw(spoke2);
		g2.draw(spoke3);
		g2.draw(spoke4);
		g2.draw(spoke5);
		g2.draw(spoke6);
		g2.draw(spoke7);
		g2.draw(spoke8);
		g2.setColor(Color.black); //set the color back to black in case something else needs it

	}
}
