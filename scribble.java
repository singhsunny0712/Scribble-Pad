import java.applet.*;
import java.awt.*;

public class scribble extends Applet{
	private int last_x,last_y;
	private Color current_color = Color.black;
	private Button clear_button;
	private Choice color_choices;
	
	//this method is called to initillize the applet
	public void init(){
	this.setBackground(Color.white);
	clear_button = new Button("clear");
	clear_button.setForeground(Color.black);
	clear_button.setBackground(Color.lightGray);
	this.add(clear_button);
	
	//creat a name of color and add it to tge applet
	//also set the menue color and add label
	color_choices = new Choice();
	color_choices.addItem("black");
	color_choices.addItem("yellow");
	color_choices.addItem("blue");
	color_choices.addItem("red");
	color_choices.addItem("pink");
	color_choices.setForeground(Color.black);
	color_choices.setBackground(Color.lightGray);
	this.add(new Label("Color"));
	this.add(color_choices);
	}
	//this method is called when the user clicks the mouse to start a scribble
	public boolean mouseDown(Event e,int x,int y){
		last_x=x;last_y=y;
		return true;
	}
	//this method is called when the user drags the mouse
	public boolean mouseDrag(Event e,int x,int y){
		Graphics g=this.getGraphics();
		g.setColor(current_color);
		g.drawLine(last_x,last_y,x,y);
		last_x=x;
		last_y=y;
		return true;
	}
	
	//this method is called when the user click the button or choose a color
	public boolean action(Event event,Object arg){
	if(event.target == clear_button){
		Graphics g=this.getGraphics();
		Rectangle r=this.bounds();
		g.setColor(this.getBackground());
		g.fillRect(r.x,r.y,r.width,r.height);
		return true;
	}
	else if(event.target == color_choices){
		if(arg.equals("black")) current_color=Color.black;
		else if(arg.equals("yellow")) current_color=Color.yellow;
		else if(arg.equals("blue")) current_color=Color.blue;
		else if(arg.equals("red")) current_color=Color.red;
		else if(arg.equals("pink")) current_color=Color.pink;
		return true;
	}
	//otherwise,let the superclass handle it.
	else return super.action(event,arg);
	}
}