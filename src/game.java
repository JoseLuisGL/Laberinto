
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;

public class game {

	private JFrame frame;

	public int player_x = 10;
	public int player_y = 20;
	public int last_press;
	Recta jugador;
	private Recta[] paredes;
    private long Tiempo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					game window = new game();
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
	public game() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 128));
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JPanel Juego = new JPanel();
		frame.getContentPane().add(Juego, BorderLayout.CENTER);
		Juego.add(new MyGraphics());
		
		Juego.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e.getKeyCode());
				
				int deltaX = 0;
			    int deltaY = 0;

			    if (e.getKeyCode() == KeyEvent.VK_W) {
			        deltaY = -10;
			    }
			    else if (e.getKeyCode() == KeyEvent.VK_S) {
			        deltaY = 10;
			    }
			    else if (e.getKeyCode() == KeyEvent.VK_D) {
			        deltaX = 10;
			    }
			    else if (e.getKeyCode() == KeyEvent.VK_A) {
			        deltaX = -10;
			    }

			    int nuevaX = player_x + deltaX;
			    int nuevaY = player_y + deltaY;

			    Recta jugadorNuevo = new Recta(nuevaX, nuevaY, 20, 20, Color.red);
			    
			    boolean colision = false;

	            for (Recta pared : paredes) {
	                if (jugadorNuevo.colision(pared)) {
	                    colision = true;
	                    break;
	                }
	            }

	            if (!colision) {
	                player_x = nuevaX;
	                player_y = nuevaY;
	            }
				Juego.repaint();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		Juego.setFocusable(true);
		Juego.requestFocus();
		
		JButton btnNewButton = new JButton("Reiniciar juego");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player_x = 10; 
			    player_y = 20;
			    Tiempo = System.currentTimeMillis();
				Juego.requestFocus();
			}
		});
		panel.add(btnNewButton);
		
		JButton Juego2 = new JButton("Nivel 2");
		Juego2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player_x = 10; 
			    player_y = 20;
			    Tiempo = System.currentTimeMillis();
				juego2();
				
			}
		});
		panel.add(Juego2);
		Tiempo = System.currentTimeMillis();

		
		
	}
	
	private void juego2() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 128));
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JPanel Juego = new JPanel();
		frame.getContentPane().add(Juego, BorderLayout.CENTER);
		Juego.add(new MyGraphics2());
		
		Juego.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e.getKeyCode());
				
				int deltaX = 0;
			    int deltaY = 0;

			    if (e.getKeyCode() == KeyEvent.VK_W) {
			        deltaY = -10;
			    }
			    else if (e.getKeyCode() == KeyEvent.VK_S) {
			        deltaY = 10;
			    }
			    else if (e.getKeyCode() == KeyEvent.VK_D) {
			        deltaX = 10;
			    }
			    else if (e.getKeyCode() == KeyEvent.VK_A) {
			        deltaX = -10;
			    }

			    int nuevaX = player_x + deltaX;
			    int nuevaY = player_y + deltaY;

			    Recta jugadorNuevo = new Recta(nuevaX, nuevaY, 20, 20, Color.red);
			    
			    boolean colision = false;

	            for (Recta pared : paredes) {
	                if (jugadorNuevo.colision(pared)) {
	                    colision = true;
	                    break;
	                }
	            }

	            if (!colision) {
	                player_x = nuevaX;
	                player_y = nuevaY;
	            }
				Juego.repaint();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		Juego.setFocusable(true);
		Juego.requestFocus();
		frame.revalidate();
		
	}
	
	public class MyGraphics extends JComponent {
	  

        private static final long serialVersionUID = 1L;

        MyGraphics() {
            setPreferredSize(new Dimension(500, 480));
            paredes = new Recta[124]; // Crear un arreglo de paredes
            //Verticales
            paredes[0] = new Recta(0, 10, 10, 485, Color.black);
            paredes[3] = new Recta(490, 10, 10, 440, Color.black);
            paredes[5] = new Recta(30, 40, 10, 60, Color.black);
            paredes[6] = new Recta(30, 120, 10, 60, Color.black);
            paredes[9] = new Recta(60, 120, 10, 30, Color.black);
            paredes[10] = new Recta(60, 170, 10, 60, Color.black);
            paredes[12] = new Recta(30, 240, 10, 70, Color.black);
            paredes[18] = new Recta(460, 70, 10, 100, Color.black);
            paredes[19] = new Recta(460, 190, 10, 100, Color.black);
            paredes[20] = new Recta(460, 310, 10, 110, Color.black);
            paredes[22] = new Recta(340, 290, 10, 110, Color.black);
            paredes[23] = new Recta(310, 310, 10, 40, Color.black);
            paredes[25] = new Recta(240, 340, 10, 40, Color.black);
            paredes[26] = new Recta(210, 340, 10, 40, Color.black);
            paredes[27] = new Recta(180, 340, 10, 70, Color.black);
            paredes[28] = new Recta(180, 430, 10, 10, Color.black);
            paredes[29] = new Recta(150, 380, 10, 60, Color.black);
            paredes[31] = new Recta(80, 340, 10, 50, Color.black);
            paredes[32] = new Recta(150, 340, 10, 20, Color.black);
            paredes[34] = new Recta(80, 340, 10, 50, Color.black);
            paredes[35] = new Recta(50, 320, 10, 70, Color.black);
            paredes[36] = new Recta(20, 320, 10, 70, Color.black);
            paredes[37] = new Recta(50, 410, 10, 40, Color.black);
            paredes[38] = new Recta(80, 390, 10, 60, Color.black);
            paredes[39] = new Recta(110, 410, 10, 60, Color.black);
            paredes[40] = new Recta(270, 310, 10, 40, Color.black);
            paredes[41] = new Recta(280, 230, 10, 90, Color.black);
            paredes[42] = new Recta(310, 230, 10, 60, Color.black);
            paredes[43] = new Recta(310, 370, 10, 30, Color.black);
            paredes[56] = new Recta(370, 200, 10, 90, Color.black);
            paredes[57] = new Recta(400, 230, 10, 60, Color.black);
            paredes[58] = new Recta(430, 230, 10, 60, Color.black);
            paredes[59] = new Recta(110, 280, 10, 40, Color.black);
            paredes[60] = new Recta(150, 250, 10, 90, Color.black);
            paredes[61] = new Recta(180, 250, 10, 60, Color.black);
            paredes[62] = new Recta(110, 340, 10, 20, Color.black);
            paredes[75] = new Recta(330, 80, 10, 90, Color.black);
            paredes[76] = new Recta(430, 80, 10, 50, Color.black);
            paredes[77] = new Recta(340, 190, 10, 80, Color.black);
            paredes[78] = new Recta(270, 50, 10, 90, Color.black);
            paredes[79] = new Recta(310, 190, 10, 40, Color.black);
            paredes[80] = new Recta(280, 160, 10, 50, Color.black);
            paredes[81] = new Recta(300, 80, 10, 40, Color.black);
            paredes[82] = new Recta(110, 20, 10, 20, Color.black);
            paredes[83] = new Recta(430, 20, 10, 20, Color.black);
            paredes[84] = new Recta(80, 40, 10, 30, Color.black);
            paredes[85] = new Recta(180, 70, 10, 100, Color.black);
            paredes[86] = new Recta(180, 190, 10, 60, Color.black);
            paredes[87] = new Recta(250, 190, 10, 30, Color.black);
            paredes[95] = new Recta(210, 80, 10, 20, Color.black);
            paredes[96] = new Recta(210, 130, 10, 60, Color.black);
            paredes[97] = new Recta(150, 190, 10, 40, Color.black);
            paredes[98] = new Recta(120, 160, 10, 30, Color.black);
            paredes[102] = new Recta(120, 230, 10, 20, Color.black);
            paredes[103] = new Recta(90, 130, 10, 130, Color.black);
            paredes[104] = new Recta(80, 260, 10, 20, Color.black);
            paredes[105] = new Recta(40, 250, 10, 10, Color.black);
            paredes[106] = new Recta(220, 160, 20, 10, Color.black);
            paredes[107] = new Recta(120, 100, 10, 60, Color.black);
            paredes[108] = new Recta(150, 120, 10, 40, Color.black);
            paredes[109] = new Recta(150, 80, 10, 20, Color.black);
            paredes[112] = new Recta(310, 420, 10, 20, Color.black);
            paredes[113] = new Recta(340, 420, 10, 20, Color.black);
            paredes[114] = new Recta(280, 380, 10, 60, Color.black);
            paredes[115] = new Recta(210, 380, 10, 60, Color.black);
            paredes[116] = new Recta(310, 370, 10, 30, Color.black);
            paredes[117] = new Recta(370, 370, 10, 50, Color.black);
            paredes[118] = new Recta(400, 320, 10, 60, Color.black);
            paredes[119] = new Recta(240, 380, 10, 40, Color.black);
            paredes[120] = new Recta(430, 320, 10, 80, Color.black);


            
            //Horizontales
            paredes[1] = new Recta(0, 0, 500, 20, Color.black); 
            paredes[2] = new Recta(0, 470, 500, 10, Color.black);
            paredes[4] = new Recta(10, 40, 30, 10, Color.black);
            paredes[7] = new Recta(10, 200, 30, 10, Color.black);
            paredes[8] = new Recta(40, 170, 20, 10, Color.black);
            paredes[11] = new Recta(30, 230, 40, 10, Color.black);
            paredes[13] = new Recta(10, 310, 30, 10, Color.black);
            paredes[14] = new Recta(60, 40, 30, 10, Color.black);
            paredes[15] = new Recta(80, 70, 70, 10, Color.black);
            paredes[16] = new Recta(420, 440, 70, 10, Color.black);
            paredes[17] = new Recta(150, 440, 270, 10, Color.black);
            paredes[21] = new Recta(320, 310, 140, 10, Color.black);
            paredes[24] = new Recta(240, 370, 80, 10, Color.black);
            paredes[30] = new Recta(80, 380, 80, 10, Color.black);
            paredes[33] = new Recta(110, 350, 50, 10, Color.black);
            paredes[44] = new Recta(280, 230, 30, 10, Color.black);
            paredes[45] = new Recta(310, 390, 30, 10, Color.black);
            paredes[46] = new Recta(180, 310, 70, 10, Color.black);
            paredes[47] = new Recta(370, 190, 90, 10, Color.black);
            paredes[48] = new Recta(400, 220, 40, 10, Color.black);
            paredes[49] = new Recta(430, 280, 30, 10, Color.black);
            paredes[50] = new Recta(150, 250, 130, 10, Color.black);
            paredes[51] = new Recta(210, 280, 80, 10, Color.black);
            paredes[52] = new Recta(110, 280, 40, 10, Color.black);
            paredes[53] = new Recta(10, 310, 100, 10, Color.black);
            paredes[54] = new Recta(10, 410, 50, 10, Color.black);
            paredes[55] = new Recta(30, 440, 30, 10, Color.black);
            paredes[63] = new Recta(110, 40, 80, 10, Color.black);
            paredes[64] = new Recta(150, 70, 40, 10, Color.black);
            paredes[65] = new Recta(210, 70, 70, 10, Color.black);
            paredes[66] = new Recta(210, 40, 70, 10, Color.black);
            paredes[67] = new Recta(330, 40, 110, 10, Color.black);
            paredes[68] = new Recta(460, 40, 10, 30, Color.black);
            paredes[69] = new Recta(300, 70, 140, 10, Color.black);
            paredes[70] = new Recta(340, 160, 120, 10, Color.black);
            paredes[71] = new Recta(360, 130, 80, 10, Color.black);
            paredes[72] = new Recta(360, 100, 80, 10, Color.black);
            paredes[73] = new Recta(340, 190, 30, 10, Color.black);
            paredes[74] = new Recta(320, 260, 20, 10, Color.black);
            paredes[88] = new Recta(290, 160, 40, 10, Color.black);
            paredes[89] = new Recta(190, 190, 90, 10, Color.black);
            paredes[90] = new Recta(210, 220, 50, 10, Color.black);
            paredes[91] = new Recta(220, 130, 50, 10, Color.black);
            paredes[92] = new Recta(210, 100, 40, 10, Color.black);
            paredes[93] = new Recta(120, 160, 60, 10, Color.black);
            paredes[94] = new Recta(120, 190, 30, 10, Color.black);
            paredes[99] = new Recta(120, 220, 30, 10, Color.black);
            paredes[100] = new Recta(90, 240, 30, 10, Color.black);
            paredes[101] = new Recta(40, 280, 50, 10, Color.black);
            paredes[110] = new Recta(60, 140, 30, 10, Color.black);
            paredes[111] = new Recta(90, 100, 40, 10, Color.black);
            paredes[121] = new Recta(250, 410, 10, 10, Color.black);
            paredes[122] = new Recta(380, 410, 80, 10, Color.black);
            paredes[123] = new Recta(340, 340, 40, 10, Color.black);
            
 
        }

        
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //fondo
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 0, 500, 500);
            //player
            jugador = new Recta(player_x, player_y, 20, 20, Color.red);
            
            g.setColor(jugador.c);
            g.fillRect(jugador.x, jugador.y, jugador.w, jugador.h);
            
            //ganar         
            if (jugador.colision(new Recta(480, 450, 20, 20, Color.yellow))) {
                long Fin = System.currentTimeMillis();
                long TiempoTranscurrido = (Fin - Tiempo) / 1000; // convertir a segundos
                JOptionPane.showMessageDialog(null, "¡Ganaste en " + TiempoTranscurrido + " segundos!", "¡Felicidades!", JOptionPane.INFORMATION_MESSAGE);
            }
            
            //paredes
            for (Recta pared : paredes) {
                g.setColor(pared.c);
                g.fillRect(pared.x, pared.y, pared.w, pared.h);
                jugador.colision(pared);
            }
            
        }
    }
	
	public class Recta {
	    int x = 0;
	    int y = 0;
	    int w = 0;
	    int h = 0;
	    Color c = Color.black;
	    boolean colision = false;

	    Recta(int x, int y, int w, int h, Color c) {
	        this.x = x;
	        this.y = y;
	        this.w = w;
	        this.h = h;
	        this.c = c;
	    }

	    public boolean colision(Recta target) {
	        if (this.x < target.x + target.w && this.x + this.w > target.x &&
	            this.y < target.y + target.h && this.y + this.h > target.y) {
	            //System.out.println("true");
	            colision = true;
	            return true;
	        }
	        //System.out.println("false");
	        colision = false;
	        return false;
	    }
	}

	public class MyGraphics2 extends JComponent {
		  

        private static final long serialVersionUID = 1L;

        MyGraphics2() {
            setPreferredSize(new Dimension(500, 480));
            paredes = new Recta[124]; // Crear un arreglo de paredes
            //Verticales
            paredes[0] = new Recta(0, 10, 10, 440, Color.black);
            paredes[3] = new Recta(490, 10, 10, 480, Color.black);
            paredes[5] = new Recta(30, 40, 10, 60, Color.black);
            paredes[6] = new Recta(30, 120, 10, 60, Color.black);
            paredes[9] = new Recta(60, 120, 10, 30, Color.black);
            paredes[10] = new Recta(60, 170, 10, 60, Color.black);
            paredes[12] = new Recta(30, 240, 10, 70, Color.black);
            paredes[18] = new Recta(460, 70, 10, 100, Color.black);
            paredes[19] = new Recta(460, 190, 10, 100, Color.black);
            paredes[20] = new Recta(460, 310, 10, 110, Color.black);
            paredes[22] = new Recta(310, 230, 10, 110, Color.black);
            paredes[23] = new Recta(310, 310, 10, 40, Color.black);
            paredes[25] = new Recta(240, 340, 10, 40, Color.black);
            paredes[26] = new Recta(210, 340, 10, 40, Color.black);
            paredes[27] = new Recta(180, 340, 10, 70, Color.black);
            paredes[28] = new Recta(180, 430, 10, 10, Color.black);
            paredes[29] = new Recta(150, 380, 10, 60, Color.black);
            paredes[31] = new Recta(80, 340, 10, 50, Color.black);
            paredes[32] = new Recta(150, 340, 10, 20, Color.black);
            paredes[34] = new Recta(80, 340, 10, 50, Color.black);
            paredes[35] = new Recta(50, 320, 10, 70, Color.black);
            paredes[36] = new Recta(20, 320, 10, 70, Color.black);
            paredes[37] = new Recta(50, 410, 10, 40, Color.black);
            paredes[38] = new Recta(80, 390, 10, 60, Color.black);
            paredes[39] = new Recta(110, 390, 10, 80, Color.black);
            paredes[40] = new Recta(270, 310, 10, 40, Color.black);
            paredes[41] = new Recta(280, 230, 10, 90, Color.black);
            paredes[42] = new Recta(310, 230, 10, 60, Color.black);
            paredes[43] = new Recta(310, 370, 10, 30, Color.black);
            paredes[56] = new Recta(370, 200, 10, 90, Color.black);
            paredes[57] = new Recta(400, 230, 10, 60, Color.black);
            paredes[58] = new Recta(430, 230, 10, 60, Color.black);
            paredes[59] = new Recta(110, 280, 10, 40, Color.black);
            paredes[60] = new Recta(150, 250, 10, 90, Color.black);
            paredes[61] = new Recta(180, 250, 10, 60, Color.black);
            paredes[62] = new Recta(110, 340, 10, 20, Color.black);
            paredes[75] = new Recta(330, 80, 10, 90, Color.black);
            paredes[76] = new Recta(430, 80, 10, 50, Color.black);
            paredes[77] = new Recta(340, 190, 10, 80, Color.black);
            paredes[78] = new Recta(270, 50, 10, 90, Color.black);
            paredes[79] = new Recta(310, 190, 10, 40, Color.black);
            paredes[80] = new Recta(280, 160, 10, 50, Color.black);
            paredes[81] = new Recta(300, 80, 10, 40, Color.black);
            paredes[82] = new Recta(110, 20, 10, 20, Color.black);
            paredes[83] = new Recta(430, 20, 10, 20, Color.black);
            paredes[84] = new Recta(80, 40, 10, 30, Color.black);
            paredes[85] = new Recta(180, 70, 10, 100, Color.black);
            paredes[86] = new Recta(180, 190, 10, 60, Color.black);
            paredes[87] = new Recta(250, 190, 10, 30, Color.black);
            paredes[95] = new Recta(210, 80, 10, 20, Color.black);
            paredes[96] = new Recta(210, 130, 10, 60, Color.black);
            paredes[97] = new Recta(150, 190, 10, 40, Color.black);
            paredes[98] = new Recta(120, 160, 10, 30, Color.black);
            paredes[102] = new Recta(120, 230, 10, 20, Color.black);
            paredes[103] = new Recta(90, 130, 10, 130, Color.black);
            paredes[104] = new Recta(80, 260, 10, 20, Color.black);
            paredes[105] = new Recta(40, 250, 10, 10, Color.black);
            paredes[106] = new Recta(220, 160, 20, 10, Color.black);
            paredes[107] = new Recta(120, 100, 10, 60, Color.black);
            paredes[108] = new Recta(150, 120, 10, 40, Color.black);
            paredes[109] = new Recta(150, 80, 10, 20, Color.black);
            paredes[112] = new Recta(310, 420, 10, 20, Color.black);
            paredes[113] = new Recta(340, 420, 10, 20, Color.black);
            paredes[114] = new Recta(280, 380, 10, 60, Color.black);
            paredes[115] = new Recta(210, 380, 10, 60, Color.black);
            paredes[116] = new Recta(310, 370, 10, 30, Color.black);
            paredes[117] = new Recta(370, 370, 10, 50, Color.black);
            paredes[118] = new Recta(400, 320, 10, 60, Color.black);
            paredes[119] = new Recta(240, 380, 10, 40, Color.black);
            paredes[120] = new Recta(430, 320, 10, 80, Color.black);


            
            //Horizontales
            paredes[1] = new Recta(0, 0, 500, 20, Color.black); 
            paredes[2] = new Recta(0, 470, 500, 10, Color.black);
            paredes[4] = new Recta(10, 40, 30, 10, Color.black);
            paredes[7] = new Recta(10, 200, 30, 10, Color.black);
            paredes[8] = new Recta(40, 170, 20, 10, Color.black);
            paredes[11] = new Recta(30, 230, 40, 10, Color.black);
            paredes[13] = new Recta(10, 310, 30, 10, Color.black);
            paredes[14] = new Recta(60, 40, 30, 10, Color.black);
            paredes[15] = new Recta(80, 70, 70, 10, Color.black);
            paredes[16] = new Recta(420, 440, 50, 10, Color.black);
            paredes[17] = new Recta(150, 440, 270, 10, Color.black);
            paredes[21] = new Recta(320, 310, 140, 10, Color.black);
            paredes[24] = new Recta(240, 370, 80, 10, Color.black);
            paredes[30] = new Recta(80, 380, 80, 10, Color.black);
            paredes[33] = new Recta(110, 350, 50, 10, Color.black);
            paredes[44] = new Recta(280, 230, 30, 10, Color.black);
            paredes[45] = new Recta(310, 390, 30, 10, Color.black);
            paredes[46] = new Recta(180, 310, 70, 10, Color.black);
            paredes[47] = new Recta(370, 190, 90, 10, Color.black);
            paredes[48] = new Recta(400, 220, 40, 10, Color.black);
            paredes[49] = new Recta(430, 280, 30, 10, Color.black);
            paredes[50] = new Recta(150, 250, 130, 10, Color.black);
            paredes[51] = new Recta(210, 280, 80, 10, Color.black);
            paredes[52] = new Recta(110, 280, 40, 10, Color.black);
            paredes[53] = new Recta(10, 310, 100, 10, Color.black);
            paredes[54] = new Recta(10, 410, 50, 10, Color.black);
            paredes[55] = new Recta(30, 440, 30, 10, Color.black);
            paredes[63] = new Recta(110, 40, 80, 10, Color.black);
            paredes[64] = new Recta(150, 70, 40, 10, Color.black);
            paredes[65] = new Recta(210, 70, 70, 10, Color.black);
            paredes[66] = new Recta(210, 40, 70, 10, Color.black);
            paredes[67] = new Recta(330, 40, 110, 10, Color.black);
            paredes[68] = new Recta(460, 40, 10, 30, Color.black);
            paredes[69] = new Recta(300, 70, 140, 10, Color.black);
            paredes[70] = new Recta(340, 160, 120, 10, Color.black);
            paredes[71] = new Recta(360, 130, 80, 10, Color.black);
            paredes[72] = new Recta(360, 100, 80, 10, Color.black);
            paredes[73] = new Recta(340, 190, 30, 10, Color.black);
            paredes[74] = new Recta(320, 260, 20, 10, Color.black);
            paredes[88] = new Recta(290, 160, 40, 10, Color.black);
            paredes[89] = new Recta(190, 190, 90, 10, Color.black);
            paredes[90] = new Recta(210, 220, 50, 10, Color.black);
            paredes[91] = new Recta(220, 130, 50, 10, Color.black);
            paredes[92] = new Recta(210, 100, 40, 10, Color.black);
            paredes[93] = new Recta(120, 160, 60, 10, Color.black);
            paredes[94] = new Recta(120, 190, 30, 10, Color.black);
            paredes[99] = new Recta(120, 220, 30, 10, Color.black);
            paredes[100] = new Recta(90, 240, 30, 10, Color.black);
            paredes[101] = new Recta(40, 280, 50, 10, Color.black);
            paredes[110] = new Recta(60, 140, 30, 10, Color.black);
            paredes[111] = new Recta(90, 100, 40, 10, Color.black);
            paredes[121] = new Recta(250, 410, 10, 10, Color.black);
            paredes[122] = new Recta(380, 410, 80, 10, Color.black);
            paredes[123] = new Recta(340, 340, 40, 10, Color.black);
            
         

        }

        
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //fondo
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 0, 500, 500);
            //player
            jugador = new Recta(player_x, player_y, 20, 20, Color.red);
            
            g.setColor(jugador.c);
            g.fillRect(jugador.x, jugador.y, jugador.w, jugador.h);
            
            //ganar         
            if (jugador.colision(new Recta(-20, 450, 20, 20, Color.yellow))) {
                long Fin = System.currentTimeMillis();
                long TiempoTranscurrido = (Fin - Tiempo) / 1000; // convertir a segundos
                JOptionPane.showMessageDialog(null, "¡Ganaste en " + TiempoTranscurrido + " segundos!", "¡Felicidades!", JOptionPane.INFORMATION_MESSAGE);
            }
            
            //paredes
            for (Recta pared : paredes) {
                g.setColor(pared.c);
                g.fillRect(pared.x, pared.y, pared.w, pared.h);
                jugador.colision(pared);
            }
            
        }
    }

}
