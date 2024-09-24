import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.text.DecimalFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.google.common.base.Stopwatch;

public class Timezz {

	private JFrame frame;
	int mouseX, mouseY;
	int opaque;
	int toggle = 0;
	int toggler = 0;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Timezz window = new Timezz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Timezz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame. 
	 */
	private JPanel panel, panel_1, panel_2, panel_3, panel_4;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	ZonedDateTime zdt;
	private JLabel lblNewLabel_7;
	public JLabel lblNewLabel_10;
	public Stopwatch sw = Stopwatch.createUnstarted();
	public Thread t1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	int second, minute, hour;
	Timer timer, timer_1;
	DecimalFormat dFormat = new DecimalFormat("00");
	String ddSecond, ddMinute, ddHour;
	JLabel lblNewLabel_9;
	private void initialize() {
		frame = new JFrame();
		frame.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				if(toggle == 1) {
					frame.setOpacity(1.0f);
				}
			}
			public void windowLostFocus(WindowEvent e) {
				if(toggle == 1) {
					frame.setOpacity(0.5f);
				}
			}
		});
		frame.setBounds(100, 100, 305, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setAlwaysOnTop(true);
		frame.setUndecorated(true);
		frame.setResizable(false);
		
		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setIcon(new ImageIcon("Icons\\Icon_Clock.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout)(panel.getLayout());
				c1.show(panel, "name_33287313004700"); 
				}
		});
		btnNewButton_1.setBounds(10, 35, 70, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton();
		btnNewButton_2.setIcon(new ImageIcon("Icons\\Icon_Stopwatch_2.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c3 = (CardLayout)(panel.getLayout());
				c3.show(panel, "name_33287325345500");
			}
		});
		btnNewButton_2.setBounds(76, 35, 76, 34);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton();
		btnNewButton_3.setIcon(new ImageIcon("Icons\\Icon_Timer.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c2 = (CardLayout)(panel.getLayout());
				c2.show(panel, "name_33287336956200");
			}
		});
		btnNewButton_3.setBounds(151, 35, 76, 34);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton();
		btnNewButton_4.setIcon(new ImageIcon("Icons\\Icon_Settings.png"));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c4 = (CardLayout)(panel.getLayout());
				c4.show(panel, "name_33287347791700");
			}
		});
		btnNewButton_4.setBounds(225, 35, 70, 34);
		frame.getContentPane().add(btnNewButton_4);
		
		panel = new JPanel();
		panel.setBounds(10, 80, 285, 299);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		panel.setOpaque(true);
		
		panel_1 = new JPanel();
		DateAndTime();
		timer_1.start();
		panel_1.setBackground(new Color(255, 255, 255));
		panel.add(panel_1, "name_33287313004700");
		panel_1.setLayout(null);
		panel_1.setOpaque(true);
		JLabel lblNewLabel = new JLabel("Clock");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 79, 26);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date :");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_1.setBounds(20, 237, 51, 26);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Time :");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2.setBounds(20, 122, 51, 20);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Zone :");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_3.setBounds(20, 61, 51, 20);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("date");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_4.setBounds(10, 262, 264, 26);
		panel_1.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("time");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblNewLabel_5.setBounds(10, 140, 264, 62);
		panel_1.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("zone");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_6.setBounds(10, 84, 264, 14);
		panel_1.add(lblNewLabel_6);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 48, 264, 2);
		panel_1.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 109, 264, 2);
		panel_1.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 224, 264, 2);
		panel_1.add(separator_5);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel.add(panel_2, "name_33287325345500");
		panel_2.setLayout(null);
		
		JLabel lblStopwatch = new JLabel("StopWatch");
		lblStopwatch.setForeground(Color.BLACK);
		lblStopwatch.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblStopwatch.setBounds(10, 11, 110, 26);
		panel_2.add(lblStopwatch);
		
		lblNewLabel_10 = new JLabel("00 s");
		lblNewLabel_10.setForeground(new Color(0, 0, 0));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_10.setBounds(10, 80, 264, 96);
		panel_2.add(lblNewLabel_10);
		
		JButton btnNewButton_5 = new JButton("Start");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sw.start();
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_5.setBounds(10, 225, 89, 23);
		panel_2.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("Stop");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sw.stop();
			}
		});
		btnNewButton_5_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_5_1.setBounds(96, 225, 95, 23);
		panel_2.add(btnNewButton_5_1);
		
		JButton btnNewButton_5_2 = new JButton("Reset");
		btnNewButton_5_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sw.reset();
			}
		});
		btnNewButton_5_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_5_2.setBounds(185, 225, 89, 23);
		panel_2.add(btnNewButton_5_2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 48, 264, 2);
		panel_2.add(separator_2);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel.add(panel_3, "name_33287336956200");
		panel_3.setLayout(null);
		
		JLabel lblTimer = new JLabel("Timer");
		lblTimer.setForeground(Color.BLACK);
		lblTimer.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblTimer.setBounds(10, 11, 110, 26);
		panel_3.add(lblTimer);
		
		JButton btnNewButton_5_3 = new JButton("Start");
		btnNewButton_5_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				countdownTimer();
				timer.start();
			}
		});
		btnNewButton_5_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_5_3.setBounds(10, 226, 89, 23);
		panel_3.add(btnNewButton_5_3);
		
		JButton btnNewButton_5_1_1 = new JButton("Stop");
		btnNewButton_5_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
			}
		});
		btnNewButton_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_5_1_1.setBounds(96, 226, 89, 23);
		panel_3.add(btnNewButton_5_1_1);
		
		JButton btnNewButton_5_2_1 = new JButton("Reset");
		btnNewButton_5_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				timer.stop();
				textField.setText("00");
				textField_1.setText("00");
				textField_2.setText("00");
				lblNewLabel_9.setText("00:00:00");
			}
		});
		btnNewButton_5_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_5_2_1.setBounds(186, 226, 89, 23);
		panel_3.add(btnNewButton_5_2_1);
		lblNewLabel_9 = new JLabel("00:00:00 s");
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(20, 127, 254, 88);
		panel_3.add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setText("00");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(20, 77, 38, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("00");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(82, 77, 38, 20);
		panel_3.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("00");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(147, 77, 38, 20);
		panel_3.add(textField_2);
		
		JLabel lblNewLabel_8 = new JLabel(":");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(57, 78, 30, 14);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel(":");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8_1.setBounds(120, 78, 30, 14);
		panel_3.add(lblNewLabel_8_1);
		
		JButton btnNewButton_6 = new JButton("Load");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hour = Integer.parseInt(textField.getText());
				minute = Integer.parseInt(textField_1.getText());
				second = Integer.parseInt(textField_2.getText());
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);	
				ddHour = dFormat.format(hour);
				lblNewLabel_9.setText(ddHour + ":" + ddMinute + ":" + ddSecond + " s");
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_6.setBounds(198, 74, 77, 23);
		panel_3.add(btnNewButton_6);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 48, 265, 2);
		panel_3.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 127, 265, 2);
		panel_3.add(separator_1);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel.add(panel_4, "name_33287347791700");
		panel_4.setLayout(null);
		
		lblNewLabel_7 = new JLabel("Settings");
		lblNewLabel_7.setForeground(new Color(0, 0, 0));
		lblNewLabel_7.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_7.setBounds(10, 11, 92, 26);
		panel_4.add(lblNewLabel_7);
		
		JButton btnNewButton_7 = new JButton("Close");
		btnNewButton_7.setForeground(new Color(0, 0, 0));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnNewButton_7.setBounds(10, 200, 264, 88);
		panel_4.add(btnNewButton_7);
		
		JSlider slider = new JSlider();
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				opaque = slider.getValue();
				frame.setOpacity(opaque * 0.01f);
			}
		});
		slider.setMinorTickSpacing(5);
		slider.setMajorTickSpacing(20);
		slider.setMinimum(20);
		slider.setValue(100);
		slider.setBounds(45, 144, 200, 45);
		panel_4.add(slider);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Translucent");
		tglbtnNewToggleButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(toggle == 0)
					toggle = 1;
				else 
					toggle = 0;
			}
		});
		tglbtnNewToggleButton.setBounds(79, 114, 134, 23);
		panel_4.add(tglbtnNewToggleButton);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(10, 48, 264, 2);
		panel_4.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(10, 101, 264, 2);
		panel_4.add(separator_7);
		
		JLabel lblNewLabel_14 = new JLabel("Timezz by Sowmya");
		lblNewLabel_14.setForeground(new Color(255, 0, 0));
		lblNewLabel_14.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 20));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setBounds(10, 55, 264, 35);
		panel_4.add(lblNewLabel_14);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				frame.setLocation(frame.getX() + e.getX() - mouseX, frame.getY() + e.getY() - mouseY);
				System.out.println(frame.getX());
				System.out.println(e.getX());
				System.out.println(mouseX);
			}
		});
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		panel_5.setBackground(new Color(85, 73, 148));
		panel_5.setBounds(0, 0, 305, 28);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel();
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setIcon(new ImageIcon("Icons\\Icon_Exit.png"));
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_11.setBounds(282, 4, 18, 18);
		panel_5.add(lblNewLabel_11);
		
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setIcon(new ImageIcon("Icons\\Icon_Minimize_2.png"));
		lblNewLabel_13.setForeground(new Color(255, 255, 255));
		lblNewLabel_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_13.setBounds(258, 2, 26, 25);
		panel_5.add(lblNewLabel_13);
		
		JLabel lblNewLabel_12 = new JLabel("Timezz");
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setIcon(null);
		lblNewLabel_12.setBounds(0, 0, 58, 27);
		panel_5.add(lblNewLabel_12);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(246, 117, 168));
		panel_6.setBounds(0, 0, 305, 390);
		frame.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				
				while(true) {
					
					String s;
					s = sw.toString();
					lblNewLabel_10.setText(s);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
				}
			}
		});
		t1.start();
		Thread t = new Thread(new Runnable() {
			
						@Override
						public void run() {
							while(true) {
								if(toggler == 0) {
									toggler = 1;
									lblNewLabel_14.setForeground(new Color(192, 192, 192));
								}
								else  {
									lblNewLabel_14.setForeground(new Color(255, 0, 0));
									toggler = 0;
								}
									
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							}
							
						}
						
					});
					t.start();
	}
	
	public void countdownTimer() {
		
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				second--;
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);
				ddHour = dFormat.format(hour);
				lblNewLabel_9.setText(ddHour + ":" + ddMinute + ":" + ddSecond + " s");
				
				
				if(second==-1) {
					second = 59;
					minute--;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);	
					lblNewLabel_9.setText(ddHour + ":" + ddMinute + ":" + ddSecond + " s");
				}
				if(minute == -1) {
					minute = 59;
					hour--;
					ddHour = dFormat.format(hour);
					ddMinute = dFormat.format(minute);	
					lblNewLabel_9.setText(ddHour + ":" + ddMinute + ":" + ddSecond + " s");
				}
				if(hour == 0 && minute==0 && second==0) {
					timer.stop();
					lblNewLabel_9.setText("Time Over!");
				}
			}
		});		
	}
	public void DateAndTime() {
		timer_1 = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zdt = ZonedDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss.S a");
				lblNewLabel_4.setText(zdt.toLocalDate().toString());
				lblNewLabel_5.setText(zdt.toLocalTime().format(formatter).toString());
				lblNewLabel_6.setText(zdt.getZone().toString());
				
				}
		});
	}
}