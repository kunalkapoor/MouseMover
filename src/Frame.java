import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Frame extends JFrame implements ActionListener, WindowListener
{
	JPanel panel;
	JButton start, stop;
	Thread thread;
	MouseMover mouseMover;
	
    public void run()
    {
    	mouseMover = new MouseMover();
        thread = new Thread(mouseMover);
        
    	setTitle("Stay awake");
        setSize(200, 80);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addWindowListener(this);
        setVisible(true);
        
        panel = new JPanel();
        
        start = new JButton("Start");
        start.setSize(50, 50);
        start.setLocation(50, 50);
        start.addActionListener(this);
        panel.add(start);
        
        stop = new JButton("Stop");
        stop.setSize(50, 50);
        stop.setLocation(100, 50);
        stop.addActionListener(this);
        panel.add(stop);
        
        add(panel);
    }
    
    public static void main(String[] args) 
    {
        Frame frame = new Frame();
        frame.run();
    }

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == start)
		{
			System.out.println("Starting Thread...");
			mouseMover.start();
			if(!thread.isAlive())
				thread.start();
		}
		else
		{
			System.out.println("Stopping Thread...");
			mouseMover.stop();
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) 
	{
		System.out.println("Window Closing...");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}