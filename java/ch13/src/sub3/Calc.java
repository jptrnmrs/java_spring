package sub3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Calc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCalc;
	private JTextField txtFunc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc frame = new Calc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCalc = new JTextField();
		txtCalc.setText("0");
		txtCalc.setEditable(false);
		txtCalc.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		txtCalc.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCalc.setBounds(12, 38, 280, 52);
		contentPane.add(txtCalc);
		txtCalc.setColumns(10);
		
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("1");
			}
		});
		btn1.setBounds(12, 298, 60, 60);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("2");
			}
		});
		btn2.setBounds(84, 298, 60, 60);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("3");
			}
		});
		btn3.setBounds(156, 298, 60, 60);
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("4");
			}
		});
		btn4.setBounds(12, 231, 60, 60);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("5");
			}
		});
		btn5.setBounds(84, 231, 60, 60);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("6");
			}
		});
		btn6.setBounds(156, 231, 60, 60);
		contentPane.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("7");
			}
		});
		btn7.setBounds(12, 164, 60, 60);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("8");
			}
		});
		btn8.setBounds(84, 164, 60, 60);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("9");
			}
		});
		btn9.setBounds(156, 164, 60, 60);
		contentPane.add(btn9);
		
		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("0");
			}
		});
		btn0.setBounds(12, 365, 60, 60);
		contentPane.add(btn0);
		
		JButton btnDiv = new JButton("÷");
		btnDiv.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCal("÷");
			}
		});
		btnDiv.setBounds(228, 97, 60, 60);
		contentPane.add(btnDiv);
		
		JButton btnMul = new JButton("×");
		btnMul.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCal("×");
			}
		});
		btnMul.setBounds(228, 164, 60, 60);
		contentPane.add(btnMul);
		
		JButton btnMin = new JButton("－");
		btnMin.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCal("－");
			}
		});
		btnMin.setBounds(228, 231, 60, 60);
		contentPane.add(btnMin);
		
		JButton btnAdd = new JButton("＋");
		btnAdd.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCal("＋");
			}
		});
		btnAdd.setBounds(228, 298, 60, 60);
		contentPane.add(btnAdd);
		
		JButton btnResult = new JButton("＝");
		btnResult.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num.add(Double.parseDouble(strNum));
				double result = num.get(0);
				String resultStr = "";

				boolean divide0 = false;
				for(int i = 1; i<num.size();i++) {
					double temp= num.get(i);
					String str = cal.get(i-1);
					if(str.equals("＋")) result += temp;
					if(str.equals("÷")) {
						if(temp==0) { 
							divide0= true;
							break;
						}else  result /= temp;
					}
					if(str.equals("×")) result *= temp;
					if(str.equals("－")) result -= temp;
				} 
				resultStr = ""+result;
				strNum=resultStr;
				func+=" =";
				txtFunc.setText(func);
				func=resultStr;
				if(divide0)resultStr="0으로 나눌 수 없습니다.";
				txtCalc.setText(resultStr);
				num.clear();
				cal.clear();
				end = true;
			}
		});
		btnResult.setBounds(228, 365, 60, 60);
		contentPane.add(btnResult);
		
		JButton btnReset = new JButton("C");
		btnReset.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				strNum = "";
				func="";
				txtFunc.setText("");
				txtCalc.setText("0");
				num.clear();
				cal.clear();
			}
		});
		btnReset.setBounds(84, 97, 60, 60);
		contentPane.add(btnReset);
		
		txtFunc = new JTextField();
		txtFunc.setEnabled(false);
		txtFunc.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFunc.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		txtFunc.setEditable(false);
		txtFunc.setColumns(10);
		txtFunc.setBounds(12, 7, 280, 24);
		contentPane.add(txtFunc);
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum(".");
			}
		});
		btnDot.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btnDot.setBounds(156, 365, 60, 60);
		contentPane.add(btnDot);
		
		JButton btn00 = new JButton("00");
		btn00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("00");
			}
		});
		btn00.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn00.setBounds(84, 365, 60, 60);
		contentPane.add(btn00);
		
		JButton btnDel = new JButton("←");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(strNum.length()>0) {
				strNum = strNum.substring(0, strNum.length()-1);
				func = func.substring(0, func.length()-1);
				txtFunc.setText(func);
				txtCalc.setText(strNum);}
			}
		});
		btnDel.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btnDel.setBounds(156, 97, 60, 60);
		contentPane.add(btnDel);
		
		JButton btnCmToM = new JButton("cm > m");
		btnCmToM.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnCmToM.setBounds(300, 97, 92, 60);
		contentPane.add(btnCmToM);
		
		JButton btnMileToM = new JButton("mile > m");
		btnMileToM.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnMileToM.setBounds(300, 164, 92, 60);
		contentPane.add(btnMileToM);
		
		JButton btnPyung = new JButton("㎡ > 평");
		btnPyung.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnPyung.setBounds(300, 231, 92, 60);
		contentPane.add(btnPyung);
		
		JButton btnFtoC = new JButton("℉ > ℃");
		btnFtoC.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnFtoC.setBounds(300, 298, 92, 60);
		contentPane.add(btnFtoC);
		
		JButton btnCtoF = new JButton("℃ > ℉");
		btnCtoF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double c = Double.parseDouble(strNum);
				double f = (c*9/5)+32;
				txtFunc.setText(""+c+"℃ =");
				txtCalc.setText(f+"℉");
				end=true;
			}
		});
		btnCtoF.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnCtoF.setBounds(300, 365, 92, 60);
		contentPane.add(btnCtoF);
	}
	
	public void addNum(String str){
		if(end) {
			strNum = "";
			func="";
			end=false;
		}
		strNum += str;
		func+=str;
		txtFunc.setText(func);
		txtCalc.setText(strNum);
	}
	
	public void addCal(String str) {
		if(num.isEmpty()&&str.equals("－")) {
			strNum+="-";
			func+=str;
			txtFunc.setText(func);
			txtCalc.setText(strNum);
			return;
		}
		end=false;
		num.add(Double.parseDouble(strNum));
		cal.add(str);
		strNum="";
		func+=str;
		txtFunc.setText(func);
	}
	boolean end = false;
	List<Double> num = new ArrayList<>();
	List<String> cal = new ArrayList<>();
	String func="";
	String strNum="";
}
