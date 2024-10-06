package game;

import javax.swing.*;

public class ballframe extends JFrame{
	Mypanel panel = new Mypanel();		
	ballframe(){ 	
this.add(panel);
panel.requestFocusInWindow();
this.pack();
this.setResizable(false);
this.setLocationRelativeTo(null);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
}
}
