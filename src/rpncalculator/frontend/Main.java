package rpncalculator.frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.*;

import rpncalculator.backend.FacadeButtons;
import rpncalculator.backend.FacadeDisplay;


public class Main {

	public static JTextField tbWorking, tbStack4, tbStack3, tbStack2, tbStack1;
	public static List<JTextField> tbList = new ArrayList<JTextField>();
	public static List<JTextField> tbRegisterList = new ArrayList<JTextField>();
	public static JLabel lblRadDegStateTitle, lblRadDegState, 
						 lblTrigonometryStateTitle, lblTrigonometryState, 
						 lblRpnCalcModeTitle, lblRpnCalcMode,
						 lblErrorMsgTitle, lblErrorMsg; 	
	
	public static JFrame frame, registersFrame, aboutFrame;
	
	public static final String aboutPageString = "Design Patterns Homework 5 - RPN Calculator\n\n"
			+ "Developed by Stefan Trajkovic\n\n"
			+ "Faculty of Information Technologies and Computer Science\n"
			+ "Major: Software Engineering\n"
			+ "Skopje, Republic of Macedonia";
	
	
	
	public static void main(String[] args) {
				
		frame = new JFrame("RPN Calculator");
		
		JPanel basePanel = new JPanel();
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();

		JMenuBar menuBar;
		JMenu menu;
		JMenuItem exitMenuItem, aboutMenuItem, registersMenuItem;

		menuBar = new JMenuBar();		
		menu = new JMenu("Menu");
		menuBar.add(menu);

		registersMenuItem = new JMenuItem("Registers"); 
		aboutMenuItem = new JMenuItem("About"); 
		exitMenuItem = new JMenuItem("Exit");

		menu.add(registersMenuItem);
		menu.add(aboutMenuItem);
		menu.add(exitMenuItem);

		// Init register TextBoxes
		for(int i=0; i<10; i++) 
		{
			JTextField reg = new JTextField(5);
			reg.setEditable(false);
			Font f = new Font("Veranda", Font.BOLD, 16);	reg.setFont(f);
			reg.setHorizontalAlignment(JTextField.RIGHT);
			tbRegisterList.add(reg);
		}
		
		registersMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(registersFrame != null && registersFrame.isVisible()) return;
				initRegisterFrame();
							
			}
		});
		
		aboutMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(aboutFrame != null && aboutFrame.isVisible()) return;
				
				aboutFrame = new JFrame("About");
				
				Font f = new Font("Veranda", Font.BOLD, 14);
				
				JTextPane txtPane = new JTextPane();
				txtPane.setText(aboutPageString);
				txtPane.setForeground(Color.WHITE);
				txtPane.setFont(f);
				txtPane.setBackground(new Color(0x333333));
				
				aboutFrame.getContentPane().setBackground(new Color(0x333333));
				aboutFrame.getContentPane().add(new JScrollPane(txtPane));
				aboutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				aboutFrame.setSize(500, 170);
				aboutFrame.setResizable(false);	
				aboutFrame.setLocationRelativeTo(frame);
				aboutFrame.setVisible(true);
			}
		});
		
		exitMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		basePanel.setBackground(new Color(0x333333));
		basePanel.setLayout(new GridBagLayout());
		GridBagConstraints gbcBasis = new GridBagConstraints();
		gbcBasis.weightx = 1.0;
		
		gbcBasis.gridx = 0;
		gbcBasis.gridy = 0;
		gbcBasis.weighty = 1.0;
		gbcBasis.fill = GridBagConstraints.BOTH;
		basePanel.add(topPanel, gbcBasis);
		
		gbcBasis.gridx = 0;
		gbcBasis.gridy = 1;
		gbcBasis.weighty = 2.0;
		gbcBasis.fill = GridBagConstraints.BOTH;
		basePanel.add(bottomPanel, gbcBasis);

		topPanel.setBackground(new Color(0x333333));
		bottomPanel.setBackground(new Color(0x333333));
		
		initTopPanel(topPanel);
		initBottomPanel(bottomPanel);
		
		frame.add(basePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 400);
		frame.setJMenuBar(menuBar);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);		
		
		initRegisterFrame();

	}
	
	
	public static void initTopPanel(JPanel panel)
	{
		GridBagConstraints gbc = new GridBagConstraints();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(new Color(0x333333));
		
		JPanel stackPanel = new JPanel(new GridBagLayout());
		JPanel workingPanel = new JPanel(new GridBagLayout());
		
		gbc.weightx = 1.0;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 2.0;
		gbc.fill = GridBagConstraints.BOTH;
		stackPanel.setBackground(new Color(0x333333));
		panel.add(stackPanel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		workingPanel.setBackground(new Color(0x333333));
		panel.add(workingPanel, gbc);
		
		
		/// Setup Working Panel ///////////////
		
		GridBagConstraints gbcWorking = new GridBagConstraints(); 
		
		gbcWorking.weightx = 1.0;
		gbcWorking.weighty = 1.0;
		gbcWorking.fill = GridBagConstraints.BOTH;
		gbcWorking.insets = new Insets(5,5,5,5);
		tbWorking = new JTextField(20);
		tbWorking.setEditable(false);
		Font fontWorking = new Font("Verdana", Font.BOLD, 23);
		tbWorking.setFont(fontWorking);
		workingPanel.add(tbWorking, gbcWorking);
		
		
		/// Setup Stack Panel ///////////////
		
		GridBagConstraints gbcStack = new GridBagConstraints(); 
		
		JPanel leftPanel = new JPanel(new GridBagLayout());
		JPanel rightPanel = new JPanel(new GridBagLayout()); 
		
		gbcStack.weightx = 1.0;
		gbcStack.weighty = 1.0;
		gbcStack.gridwidth = 1;
		gbcStack.gridheight = 1;
		
		gbcStack.gridx = 0;
		gbcStack.gridy = 0;
		gbcStack.fill = GridBagConstraints.BOTH;
		leftPanel.setBackground(new Color(0x333333)); // Color.BLUE new Color(0x333333)
		stackPanel.add(leftPanel, gbcStack);
		
		gbcStack.gridx = 1;
		gbcStack.gridy = 0;
		gbcStack.fill = GridBagConstraints.BOTH;
		//gbcStack.insets = new Insets(5,0,0,5);
		rightPanel.setBackground(new Color(0x333333)); // Color.RED new Color(0x333333)
		stackPanel.add(rightPanel, gbcStack);
		
		
		GridBagConstraints gbcLeft = new GridBagConstraints();
	
		gbcLeft.weightx = 1.0;
		gbcLeft.weighty = 1.0;
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 0;
		gbcLeft.anchor = GridBagConstraints.NORTHWEST;
		gbcLeft.insets = new Insets(10,10,10,10);
		
		JPanel statesDashboard = new JPanel();
		GridLayout gl = new GridLayout(4,2);
		gl.setVgap(10);
		statesDashboard.setLayout(gl);
		
		lblRadDegStateTitle = new JLabel("ANGLE: "); 
		lblRadDegState = new JLabel("RAD"); 
		lblTrigonometryStateTitle = new JLabel("TRIG. MODE: "); 
		lblTrigonometryState = new JLabel("NORMAL");
		lblRpnCalcModeTitle = new JLabel("RPN MODE: ");
		lblRpnCalcMode = new JLabel("BASIC");
		lblErrorMsgTitle = new JLabel("ERROR: ");
		lblErrorMsg = new JLabel("");
		Font lblFont = new Font("Veranda", Font.BOLD, 12);
		
		lblRadDegStateTitle.setForeground(Color.GRAY); // new Color(0x333333) 
		lblRadDegStateTitle.setFont(lblFont);
		lblTrigonometryStateTitle.setForeground(Color.GRAY);
		lblTrigonometryStateTitle.setFont(lblFont);		
		lblRpnCalcModeTitle.setForeground(Color.GRAY);
		lblRpnCalcModeTitle.setFont(lblFont);
		lblErrorMsgTitle.setForeground(Color.GRAY);
		lblErrorMsgTitle.setFont(lblFont);
		
		lblRadDegState.setForeground(Color.WHITE);
		lblTrigonometryState.setForeground(Color.WHITE);
		lblRpnCalcMode.setForeground(Color.WHITE);
		lblErrorMsg.setForeground(Color.ORANGE);	
		
		statesDashboard.add(lblRpnCalcModeTitle); 		statesDashboard.add(lblRpnCalcMode);	
		statesDashboard.add(lblRadDegStateTitle); 		statesDashboard.add(lblRadDegState);
		statesDashboard.add(lblTrigonometryStateTitle); statesDashboard.add(lblTrigonometryState);
		statesDashboard.add(lblErrorMsgTitle);			statesDashboard.add(lblErrorMsg);
		
		statesDashboard.setBackground(new Color(0x333333));
				
		leftPanel.add(statesDashboard, gbcLeft);
		
		
		
		GridBagConstraints gbcRight = new GridBagConstraints();
		
		gbcRight.weightx = 1.0;
		gbcRight.weighty = 1.0;
		gbcRight.anchor = GridBagConstraints.NORTHEAST;
		gbcRight.insets = new Insets(5, 0, 0, 5); 
		
		Font fontStackLabel = new Font("Verdana", Font.BOLD, 18);
		Font fontStack = new Font("Verdana", Font.BOLD, 20);
		
		int stackTextFieldsColumns = 17;
		
		// row 1
		gbcRight.gridx = 0;
		gbcRight.gridy = 0;
		JLabel lblS4 = new JLabel("4:");
		lblS4.setFont(fontStackLabel);
		lblS4.setForeground(Color.WHITE);
		rightPanel.add(lblS4, gbcRight);
		
		gbcRight.gridx = 1;
		gbcRight.gridy = 0;
		tbStack4 = new JTextField(stackTextFieldsColumns);
		tbStack4.setFont(fontStack);
		tbStack4.setEditable(false);
		rightPanel.add(tbStack4, gbcRight);
		
		
		// row 2
		gbcRight.gridx = 0;
		gbcRight.gridy = 1;
		JLabel lblS3 = new JLabel("3:");
		lblS3.setFont(fontStackLabel);
		lblS3.setForeground(Color.WHITE);
		rightPanel.add(lblS3, gbcRight);
		
		gbcRight.gridx = 1;
		gbcRight.gridy = 1;
		tbStack3 = new JTextField(stackTextFieldsColumns);
		tbStack3.setFont(fontStack);
		tbStack3.setEditable(false);
		rightPanel.add(tbStack3, gbcRight);
		
		
		// row 3
		gbcRight.gridx = 0;
		gbcRight.gridy = 2;
		JLabel lblS2 = new JLabel("2:");
		lblS2.setFont(fontStackLabel);
		lblS2.setForeground(Color.WHITE);
		rightPanel.add(lblS2, gbcRight);
		
		gbcRight.gridx = 1;
		gbcRight.gridy = 2;
		tbStack2 = new JTextField(stackTextFieldsColumns);
		tbStack2.setFont(fontStack);
		tbStack2.setEditable(false);
		rightPanel.add(tbStack2, gbcRight);
		
		
		
		// row 4
		gbcRight.gridx = 0;
		gbcRight.gridy = 3;
		JLabel lblS1 = new JLabel("1:");
		lblS1.setFont(fontStackLabel);
		lblS1.setForeground(Color.WHITE);
		rightPanel.add(lblS1, gbcRight);
		
		gbcRight.gridx = 1;
		gbcRight.gridy = 3;
		tbStack1 = new JTextField(stackTextFieldsColumns);
		tbStack1.setFont(fontStack);
		tbStack1.setEditable(false);
		rightPanel.add(tbStack1, gbcRight);
				
		/*Font fontStack = new Font("Verdana", Font.BOLD, 18);
		
		tbStack4 = new JTextField(20);		tbStack4.setEditable(false);	tbStack4.setFont(fontStack);
		tbStack3 = new JTextField(20);		tbStack3.setEditable(false);   	tbStack3.setFont(fontStack);
		tbStack2 = new JTextField(20);		tbStack2.setEditable(false);   	tbStack2.setFont(fontStack);
		tbStack1 = new JTextField(20);		tbStack1.setEditable(false);   	tbStack1.setFont(fontStack);
		
		rightPanel.add(tbStack4);
		rightPanel.add(tbStack3);
		rightPanel.add(tbStack2);
		rightPanel.add(tbStack1);	*/		
		
		tbWorking.setHorizontalAlignment(JTextField.RIGHT);
		tbStack1.setHorizontalAlignment(JTextField.RIGHT);
		tbStack2.setHorizontalAlignment(JTextField.RIGHT);
		tbStack3.setHorizontalAlignment(JTextField.RIGHT);
		tbStack4.setHorizontalAlignment(JTextField.RIGHT);
		
		tbList.add(tbStack1);
		tbList.add(tbStack2);
		tbList.add(tbStack3);
		tbList.add(tbStack4);
		
	}
	
	public static void initBottomPanel(JPanel panel)
	{
		GridLayout gl = new GridLayout(4,4);
		gl.setHgap(6); 
		gl.setVgap(6);
		JPanel numPadPanel = new JPanel(gl);
		numPadPanel.setBackground(new Color(0x333333));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		panel.setLayout(new GridBagLayout());
		
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(3,3,3,3);
		gbc.anchor = GridBagConstraints.LINE_START;
		
		
		/// First Row /////////////////////
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JButton btnInv = new JButton("Inv");
		panel.add(btnInv, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		JButton btnRedo = new JButton("REDO");
		panel.add(btnRedo, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		JButton btnUndo = new JButton("UNDO");
		panel.add(btnUndo, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		JButton btnSwap = new JButton("SWAP");
		panel.add(btnSwap, gbc);
		
		
		// # Mestenje na numPad
		
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.gridheight = 4;
		
		JButton btn7 = new JButton("7");		numPadPanel.add(btn7);
		JButton btn8 = new JButton("8");		numPadPanel.add(btn8);
		JButton btn9 = new JButton("9");		numPadPanel.add(btn9);
		JButton btnDiv = new JButton("/");		numPadPanel.add(btnDiv);
		
		JButton btn4 = new JButton("4");		numPadPanel.add(btn4);
		JButton btn5 = new JButton("5");		numPadPanel.add(btn5);
		JButton btn6 = new JButton("6");		numPadPanel.add(btn6);
		JButton btnMulti = new JButton("*");	numPadPanel.add(btnMulti);
		
		JButton btn1 = new JButton("1");		numPadPanel.add(btn1);
		JButton btn2 = new JButton("2");		numPadPanel.add(btn2);
		JButton btn3 = new JButton("3");		numPadPanel.add(btn3);
		JButton btnMinus = new JButton("-");	numPadPanel.add(btnMinus);
		
		JButton btnChs = new JButton("CHS");	numPadPanel.add(btnChs);
		JButton btn0 = new JButton("0");		numPadPanel.add(btn0);
		JButton btnDot = new JButton(".");		numPadPanel.add(btnDot);
		JButton btnPlus = new JButton("+");		numPadPanel.add(btnPlus);
		
		panel.add(numPadPanel, gbc);
		
		
		
		
		
		
		/// Second Row /////////////////////
		
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		JButton btnSin = new JButton("Sin");
		panel.add(btnSin, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		JButton btnRadDeg = new JButton("RAD/DEG");
		panel.add(btnRadDeg, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		JButton btnClear = new JButton("AC");
		panel.add(btnClear, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 1;
		JButton btnDrop = new JButton("DROP");
		panel.add(btnDrop, gbc);
		

		
		/// Third Row //////////////////////
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		JButton btnCos = new JButton("Cos");
		panel.add(btnCos, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		JButton btnProg = new JButton("PROG");
		panel.add(btnProg, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		JButton btnSto = new JButton("STO");
		panel.add(btnSto, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.gridheight = GridBagConstraints.REMAINDER;
		JButton btnEnter = new JButton("ENTER");
		panel.add(btnEnter, gbc);
		
		
		
		/// Fourth Row //////////////////////
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		JButton btnTng = new JButton("Tng");
		panel.add(btnTng, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		JButton btnExe = new JButton("EXE");
		panel.add(btnExe, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 3;
		JButton btnRcl = new JButton("RCL");
		panel.add(btnRcl, gbc);
		
		
		
		
		List<JButton> btnList = new ArrayList<JButton>();
		btnList.add(btnInv);
		btnList.add(btnRedo);
		btnList.add(btnUndo);
		btnList.add(btnSwap);
		btnList.add(btn7);
		btnList.add(btn8);
		btnList.add(btn9);
		btnList.add(btnDiv);
		btnList.add(btnSin);
		btnList.add(btnRadDeg);
		btnList.add(btnClear);
		btnList.add(btnDrop);
		btnList.add(btn4);
		btnList.add(btn5);
		btnList.add(btn6);
		btnList.add(btnMulti);
		btnList.add(btnCos);
		btnList.add(btnProg);
		btnList.add(btnSto);
		btnList.add(btnEnter);
		btnList.add(btn1);
		btnList.add(btn2);
		btnList.add(btn3);
		btnList.add(btnMinus);
		btnList.add(btnTng);
		btnList.add(btnExe);
		btnList.add(btnRcl);
		btnList.add(btnChs);
		btnList.add(btn0);
		btnList.add(btnDot);
		btnList.add(btnPlus);
		
		
		setBtnStyle(btnList);
		setBtnActionListener(btnList);
		
	}
	
	public static void initRegisterFrame()
	{
		registersFrame = new JFrame("Registers");
		
		JPanel panel = new JPanel(new GridLayout(10,2, 5, 5));
		panel.setBackground(new Color(0x333333));			
		
		JLabel lblZero = new JLabel("REG_0 ::", JLabel.RIGHT);	 
		JLabel lblOne = new JLabel("REG_1 ::", JLabel.RIGHT);	 
		JLabel lblTwo = new JLabel("REG_2 ::", JLabel.RIGHT);	
		JLabel lblThree = new JLabel("REG_3 ::", JLabel.RIGHT);	 
		JLabel lblFour = new JLabel("REG_4 ::", JLabel.RIGHT);	 
		JLabel lblFive = new JLabel("REG_5 ::", JLabel.RIGHT);	 
		JLabel lblSix = new JLabel("REG_6 ::", JLabel.RIGHT);	 
		JLabel lblSeven = new JLabel("REG_7 ::", JLabel.RIGHT);	 
		JLabel lblEight = new JLabel("REG_8 ::", JLabel.RIGHT);	 
		JLabel lblNine = new JLabel("REG_9 ::", JLabel.RIGHT);	 
		
		lblZero.setForeground(Color.WHITE);
		lblOne.setForeground(Color.WHITE);
		lblTwo.setForeground(Color.WHITE);
		lblThree.setForeground(Color.WHITE);
		lblFour.setForeground(Color.WHITE);
		lblFive.setForeground(Color.WHITE);
		lblSix.setForeground(Color.WHITE);
		lblSeven.setForeground(Color.WHITE);
		lblEight.setForeground(Color.WHITE);
		lblNine.setForeground(Color.WHITE);
				
		
		panel.add(lblZero);		panel.add(tbRegisterList.get(0));
		panel.add(lblOne); 		panel.add(tbRegisterList.get(1));
		panel.add(lblTwo); 		panel.add(tbRegisterList.get(2));
		panel.add(lblThree); 	panel.add(tbRegisterList.get(3));
		panel.add(lblFour); 	panel.add(tbRegisterList.get(4));
		panel.add(lblFive); 	panel.add(tbRegisterList.get(5));
		panel.add(lblSix); 		panel.add(tbRegisterList.get(6));
		panel.add(lblSeven); 	panel.add(tbRegisterList.get(7));
		panel.add(lblEight); 	panel.add(tbRegisterList.get(8));
		panel.add(lblNine); 	panel.add(tbRegisterList.get(9));
		
		registersFrame.add(panel);
		registersFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		registersFrame.setSize(150, 400);
		registersFrame.setResizable(false);	
		
		registersFrame.setLocationRelativeTo(frame);
		Point p = registersFrame.getLocation();
		int frameHeight = frame.getSize().height;
		int frameWidth = frame.getSize().width;
		p.x += (int) ((frameWidth + registersFrame.getSize().width) / 2) + 3;
		p.y += (int) ((frameHeight - registersFrame.getSize().height) / 2); 
		registersFrame.setLocation(p);
		
		registersFrame.setVisible(true);
	}
	
	
	public static ActionListener getBtnActionListener()
	{
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				
				if("0".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.Number0Pressed();
				}
				else if("1".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.Number1Pressed();
				}
				else if("2".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.Number2Pressed();
				}
				else if("3".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.Number3Pressed();
				}
				else if("4".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.Number4Pressed();
				}
				else if("5".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.Number5Pressed();
				}
				else if("6".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.Number6Pressed();
				}
				else if("7".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.Number7Pressed();
				}
				else if("8".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.Number8Pressed();
				}
				else if("9".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.Number9Pressed();
				}
				else if(".".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.DotPressed();
				}
				else if("+".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.AddPressed();
				}
				else if("-".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.SubPressed();
				}
				else if("/".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.DivPressed();
				}
				else if("*".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.MulPressed();
				}
				else if("CHS".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.ChsPressed();
				}
				else if("DROP".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.DropPressed();
				}
				else if("SWAP".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.SwapPressed();
				}
				else if("ENTER".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.EnterPressed();
				}
				else if("RCL".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.RclPressed();
				}
				else if("STO".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.StoPressed();
				}
				else if("AC".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.AcPressed();
				}
				else if("UNDO".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.UndoPressed();
				}
				else if("REDO".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.RedoPressed();
				}
				else if("RAD/DEG".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.RadDegPressed();
				}
				else if("PROG".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.ProgPressed();
				}
				else if("EXE".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.ExePressed();
				}
				else if("Inv".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.InvPressed();
				}
				else if("Sin".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.SinPressed();
				}
				else if("Cos".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.CosPressed();
				}
				else if("Tng".equalsIgnoreCase(e.getActionCommand()))
				{
					FacadeButtons.TngPressed();
				}
				
				refreshTextBoxes();
			}
		};
	}
	
	public static void setBtnActionListener(List<JButton> btnList)
	{
		ActionListener al = getBtnActionListener();
		
		for(JButton btn : btnList)
		{
			btn.addActionListener(al);
		}	
	}
	
	public static void setBtnStyle(List<JButton> btnList)
	{
		for(JButton btn : btnList)
		{
			Font btnFont = new Font("Veranda", Font.BOLD, 16);
			btn.setFont(btnFont);
			btn.setForeground(Color.WHITE);
			btn.setBackground(Color.GRAY);
		}		
	}

	public static void refreshTextBoxes()
	{
		/// REFRESH WORKING TEXTBOX ///////////
		
		String working = FacadeDisplay.getWorking();
		tbWorking.setText(working);
		
				
		/// REFRESH STACK REPRESENTATION ///////////
		
		// Clear text-boxes
		for(int i=0; i<4; i++) tbList.get(i).setText("");		
		
		// Get stack representation and fill the text-boxes
		Stack<String> stack = FacadeDisplay.getStack();
		for(int i=0; i<4; i++)
		{
			String result = "";
			if(!stack.empty()) result = stack.pop();
			
			tbList.get(i).setText(result);
		}
		
		
		/// REFRESH RAD/DEG LABEL ///////////
		
		String radDegState = FacadeDisplay.getRadDegState();
		lblRadDegState.setText(radDegState);
		
		
		/// REFRESH TRIGONOMETRY FUNCTION LABEL ///////////
				
		String trigFunc = FacadeDisplay.getInvOrNormalTrigonometryState();
		lblTrigonometryState.setText(trigFunc);
		
		
		/// REFRESH TRIGONOMETRY FUNCTION LABEL ///////////
		
		String rpnMode = FacadeDisplay.getRpnModeState();
		lblRpnCalcMode.setText(rpnMode);
		
		
		/// REFRESH ERROR MSG LABEL ///////////
		
		String err = FacadeDisplay.getErrorMassage();
		lblErrorMsg.setText(err);
		
		
		/// REFRESH REGISTERS TEXTBOXES ///////////
		double[] registers = FacadeDisplay.getRegisters();
		for (int i=0; i<10; i++) {
			String reg = String.valueOf(registers[i]);
			tbRegisterList.get(i).setText(reg);
		}
		
		
	}
	
}
