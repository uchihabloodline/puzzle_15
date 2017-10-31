import java.net.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*<applet code="games.java" height=500 width =500> </applet> */

public class games extends Applet implements ActionListener, MouseListener, MouseMotionListener {
	
	static final int n=4;
	Button b[] = new Button[16];
	String left,right,top,bottom;
	URL url;
	AudioClip ac;

	public void init(){

   int i,j =15;
   url = getCodeBase();
   try
   {
     url = new URL(url+"/ding.wav");
   }

   catch(MalformedURLException e)
   {
     System.out.println("Sorry specified URL not found");

   }

   ac = getAudioClip(url);
   setLayout(new GridLayout(n , n));
   setFont(new Font("SansSerif",Font.BOLD,30));
   for(i=0;i<15;i++) {

    add(b[i]=new Button(String.valueOf( (long) j)));
    j--;
    b[i].addActionListener(this);
  }

  add(b[i] = new Button(""));
  b[i].addActionListener(this);
  addMouseListener(this);
  addMouseMotionListener(this);

}


public void actionPerformed(ActionEvent ae){

  String st = ae.getActionCommand();
  String s;
  int i;

  for(i=0;i<16;i++){

    s = b[i].getLabel();
    if(st.equals(s))
      break;

  }

  switch(i){

    case 0:
    right = b[i+1].getLabel();
    bottom = b[i+4].getLabel();
    if(right.equals(""))
    {

      b[i+1].setLabel(st);
      b[i].setLabel("");

    }

    else if(bottom.equals("")){
      b[i+4].setLabel(st);
      b[i].setLabel("");
    }

    break;

    case 1:

    case 2:
    left = b[i-1].getLabel();
    right = b[i+1].getLabel();
    bottom = b[i+4].getLabel();

    if(left.equals("")){

      b[i-1].setLabel(st);
      b[i].setLabel("");

    }

    else if(bottom.equals("")){

      b[i+4].setLabel(st);

      b[i].setLabel("");

    }

    if(right.equals("")){
      b[i+1].setLabel(st);
      b[i].setLabel("");
    }

    break;
    case 3:

    left = b[i-1].getLabel();
    bottom = b[i+4].getLabel();
    if(left.equals(""))
    {
      b[i-1].setLabel(st);
      b[i].setLabel("");

    }
    break;

    case 4:
    case 8:

    right = b[i+1].getLabel();
    top = b[i-4].getLabel();
    bottom = b[i+4].getLabel();

    if(right.equals("")){

     b[i+1].setLabel(st);
     b[i].setLabel("");
   }   

   else if(top.equals("")){

     b[i-4].setLabel(st);
     b[i].setLabel("");

   }

   else if(bottom.equals("")){

     b[i+4].setLabel(st);
     b[i].setLabel("");

   }
   break;
   case 5:
   case 6:
   case 9:
   case 10:

   left = b[i-1].getLabel();
   right = b[i+1].getLabel();
   top = b[i-4].getLabel();
   bottom = b[i+4].getLabel();

   if(left.equals("")){

    b[i-1].setLabel(st);
    b[i].setLabel("");

  }

  else if(bottom.equals("")){

    b[i+4].setLabel(st);
    b[i].setLabel("");

  }    

  if(right.equals("")){

    b[i+1].setLabel(st);
    b[i].setLabel("");
  }

  else if(top.equals("")){

    b[i-4].setLabel(st);
    b[i].setLabel("");

  }
  break;

  case 7:
  case 11:

  left = b[i-1].getLabel();
  top = b[i-4].getLabel();
  bottom = b[i+4].getLabel();
  
  if(left.equals("")){
    b[i-1].setLabel(st);
    b[i].setLabel("");
  }

  else if(bottom.equals("")){
    b[i+4].setLabel(st);
    b[i].setLabel("");
  }
  break;

  case 12:

  right = b[i+1].getLabel();
  top = b[i-4].getLabel();

  if(right.equals("")){

    b[i+1].setLabel(st);
    b[i].setLabel("");
  } 

  else if(top.equals("")){
    b[i-4].setLabel(st);
    b[i].setLabel("");
  } 
  break;

  case 13:

  case 14:

  left = b[i-1].getLabel();
  right = b[i+1].getLabel();
  top  = b[-4].getLabel();
  if(left.equals("")){

   b[i-1].setLabel(st);
   b[i].setLabel("");
 }

 if(right.equals("")){

   b[i+1].setLabel(st);
   b[i].setLabel("");
 }

 else if(top.equals("")){

   b[i-4].setLabel(st);
   b[i].setLabel("");
 }

 break;

 case 15:
 
 left = b[i-1].getLabel();
 top = b[i-4].getLabel();

 if(left.equals("")){

   b[i-1].setLabel(st);
   b[i].setLabel("");
 }    

 else if(top.equals("")){

   b[i-4].setLabel(st);
   b[i].setLabel("");
 }

 break;
}

ac.play();
}

public void mouseEntered(MouseEvent me) {}
public void mouseExited(MouseEvent me) {}
public void mouseClicked(MouseEvent me) {}
public void mousePressed(MouseEvent me) {}
public void mouseReleased(MouseEvent me) {}
public void mouseDragged(MouseEvent me) {}
public void mouseMoved(MouseEvent me) {}


}