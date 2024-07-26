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
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

public class CalcApp extends JFrame {

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
					CalcApp frame = new CalcApp();
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
	public CalcApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		txtFunc = new JTextField();
		txtFunc.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFunc.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		txtFunc.setEditable(false);
		txtFunc.setColumns(10);
		txtFunc.setBounds(12, 10, 280, 25);
		contentPane.add(txtFunc);
		
		txtCalc = new JTextField();
		txtCalc.setText("0");
		txtCalc.setEditable(false);
		txtCalc.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		txtCalc.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCalc.setBounds(12, 35, 280, 50);
		contentPane.add(txtCalc);
		txtCalc.setColumns(10);
		
		
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("1");
			}
		});
		btn1.setBounds(15, 305, 60, 60);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("2");
			}
		});
		btn2.setBounds(85, 305, 60, 60);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("3");
			}
		});
		btn3.setBounds(155, 305, 60, 60);
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("4");
			}
		});
		btn4.setBounds(15, 235, 60, 60);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("5");
			}
		});
		btn5.setBounds(85, 235, 60, 60);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("6");
			}
		});
		btn6.setBounds(155, 235, 60, 60);
		contentPane.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("7");
			}
		});
		btn7.setBounds(15, 165, 60, 60);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("8");
			}
		});
		btn8.setBounds(85, 165, 60, 60);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("9");
			}
		});
		btn9.setBounds(155, 165, 60, 60);
		contentPane.add(btn9);
		
		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("0");
			}
		});
		btn0.setBounds(15, 375, 60, 60);
		contentPane.add(btn0);
		
		JButton btnDiv = new JButton("÷");
		btnDiv.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCal("÷");
			}
		});
		btnDiv.setBounds(225, 95, 60, 60);
		contentPane.add(btnDiv);
		
		JButton btnMul = new JButton("×");
		btnMul.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCal("×");
			}
		});
		btnMul.setBounds(225, 165, 60, 60);
		contentPane.add(btnMul);
		
		JButton btnMinus = new JButton("－");
		btnMinus.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCal("－");
			}
		});
		btnMinus.setBounds(225, 235, 60, 60);
		contentPane.add(btnMinus);
		
		JButton btnAdd = new JButton("＋");
		btnAdd.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCal("＋");
			}
		});
		btnAdd.setBounds(225, 305, 60, 60);
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
		btnResult.setBounds(225, 375, 60, 60);
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
		btnReset.setBounds(85, 95, 60, 60);
		contentPane.add(btnReset);
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum(".");
			}
		});
		btnDot.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btnDot.setBounds(155, 375, 60, 60);
		contentPane.add(btnDot);
		
		JButton btn00 = new JButton("00");
		btn00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNum("00");
			}
		});
		btn00.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		btn00.setBounds(85, 375, 60, 60);
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
		btnDel.setBounds(155, 95, 60, 60);
		contentPane.add(btnDel);
		
		
		JButton btnMm = new JButton("mm");
		btnMm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(unit.isBlank()) {
					txtFunc.setText(strNum+" mm =");
					txtCalc.setText("변환할 단위를 골라주세요");
					unit="mm";
				}else if(Arrays.asList(len).contains(unit)){
					double a = Double.parseDouble(strNum);
					switch (unit) {
						case "mile":a*=1.60934;
						case "km":	a*=1000;
						case "m":	a*=100;
						case "cm":	a*=10;
									break;
						case "inch":a*=25.4;
									break;
						case "yard":a*=914.4;
									break;
						case "feet":a*=304.8;
									break;
						default:	break;
					}
					strNum=""+a;
					txtCalc.setText(strNum+" mm");
					unit="";
					end=true;
				
				}else {
					txtCalc.setText("올바른 입력이 아닙니다.");
				}
			}
		});
		btnMm.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnMm.setBounds(305, 95, 60, 60);
		contentPane.add(btnMm);
		
		JButton btnCm = new JButton("cm");
		btnCm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(unit.isBlank()) {
					txtFunc.setText(strNum+" cm =");
					txtCalc.setText("변환할 단위를 골라주세요");
					unit="cm";
				}else if(Arrays.asList(len).contains(unit)){
					double a = Double.parseDouble(strNum);
					switch (unit) {
						case "mile":a*=1.60934;
						case "km":	a*=1000;
						case "m":	a*=100;
									break;
						case "mm":	a/=10;
									break;
						case "inch":a*=2.54;
									break;
						case "yard":a*=91.44;
									break;
						case "feet":a*=30.48;
									break;
						default:	break;
					}
					strNum=""+a;
					txtCalc.setText(strNum+" cm");
					unit="";
					end=true;
				}else {
					txtCalc.setText("올바른 입력이 아닙니다.");
				}
			}
		});
		btnCm.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnCm.setBounds(375, 95, 60, 60);
		contentPane.add(btnCm);
		
		JButton btnM = new JButton("m");
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(unit.isBlank()) {
					txtFunc.setText(strNum+" m =");
					txtCalc.setText("변환할 단위를 골라주세요");
					unit="m";
				}else if(Arrays.asList(len).contains(unit)){
					double a = Double.parseDouble(strNum);
					switch (unit) {
						case "mile":a*=1.60934;
						case "km":	a*=1000;
									break;
						case "cm":	a/=100;
						case "mm":	a/=10;
									break;
						case "inch":a/=39.37;
									break;
						case "yard":a*=9.144;
									break;
						case "feet":a*=3.048;
									break;
						default:	break;
					}
					strNum=""+a;
					txtCalc.setText(strNum+" m");
					unit="";
					end=true;
				}else {
					txtCalc.setText("올바른 입력이 아닙니다.");
				}
			}
		});
		btnM.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnM.setBounds(445, 95, 60, 60);
		contentPane.add(btnM);

		JButton btnKm = new JButton("km");
		btnKm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(unit.isBlank()) {
					txtFunc.setText(strNum+" km =");
					txtCalc.setText("변환할 단위를 골라주세요");
					unit="km";
				}else if(Arrays.asList(len).contains(unit)){
					double a = Double.parseDouble(strNum);
					switch (unit) {
						case "mile":a*=1.60934;
									break;
						case "m":	a/=1000;
						case "cm":	a/=100;
						case "mm":	a/=10;
									break;
						case "inch":a/=39370;
									break;
						case "yard":a*=91.44;
									break;
						case "feet":a*=30.48;
									break;
						default:	break;
					}
					strNum=""+a;
					txtCalc.setText(strNum+" km");
					unit="";
					end=true;
				}else {
					txtCalc.setText("올바른 입력이 아닙니다.");
				}
			}
		});
		btnKm.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnKm.setBounds(515, 95, 60, 60);
		contentPane.add(btnKm);
		
		
		JButton btnMile = new JButton(" mile");
		btnMile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(unit.isBlank()) {
					txtFunc.setText(strNum+"mile =");
					txtCalc.setText("변환할 단위를 골라주세요");
					unit="mile";
				}else if(Arrays.asList(len).contains(unit)){
					double a = Double.parseDouble(strNum);
					switch (unit) {
						case "mm":	a/=10;
						case "cm":	a/=100;
						case "m":	a/=1000;
						case "km":	a/=1.069;
									break;
						case "yard":a/=1760;
									break;
						case "feet":a/=5280;
									break;
						case "inch":a/=63360;
									break;
						default:	break;
					}
					strNum=""+a;
					txtCalc.setText(strNum+"mile");
					unit="";
					end=true;
				}else {
					txtCalc.setText("올바른 입력이 아닙니다.");
				}
			}
		});
		btnMile.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		btnMile.setBounds(305, 165, 60, 60);
		contentPane.add(btnMile);
		
		JButton btnYard = new JButton("yard");
		btnYard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(unit.isBlank()) {
					txtFunc.setText(strNum+" yd =");
					txtCalc.setText("변환할 단위를 골라주세요");
					unit="yard";
				}else if(Arrays.asList(len).contains(unit)){
					double a = Double.parseDouble(strNum);
					switch (unit) {
						case "mm":	a/=10;
						case "cm":	a/=100;
						case "m":	a/=1000;
						case "km":	a*=1093.61;
									break;
						case "mile":a*=1760;
									break;
						case "inch":a/=12;
						case "feet":a/=3;
									break;
						default:	break;
					}
					strNum=""+a;
					txtCalc.setText(strNum+" yd");
					unit="";
					end=true;
				}else {
					txtCalc.setText("올바른 입력이 아닙니다.");
				}
			}
		});
		btnYard.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnYard.setBounds(375, 165, 60, 60);
		contentPane.add(btnYard);
		
		JButton btnFeet = new JButton("feet");
		btnFeet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(unit.isBlank()) {
					txtFunc.setText(strNum+" ft =");
					txtCalc.setText("변환할 단위를 골라주세요");
					unit="feet";
				}else if(Arrays.asList(len).contains(unit)){
					double a = Double.parseDouble(strNum);
					switch (unit) {
						case "mm":	a/=10;
						case "cm":	a/=100;
						case "m":	a/=1000;
						case "km":	a*=3280.84;
									break;
						case "mile":a*=1760;
						case "yard":a*=3;
									break;
						case "inch":a/=12;
									break;
						default:	break;
					}
					strNum=""+a;
					txtCalc.setText(strNum+" ft");
					unit="";
					end=true;
				}else {
					txtCalc.setText("올바른 입력이 아닙니다.");
				}
			}
		});
		btnFeet.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnFeet.setBounds(445, 165, 60, 60);
		contentPane.add(btnFeet);
		
		JButton btnInch = new JButton("inch");
		btnInch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(unit.isBlank()) {
					txtFunc.setText(strNum+" in =");
					txtCalc.setText("변환할 단위를 골라주세요");
					unit="inch";
				}else if(Arrays.asList(len).contains(unit)){
					double a = Double.parseDouble(strNum);
					switch (unit) {
						case "mm":	a/=10;
						case "cm":	a/=100;
						case "m":	a/=1000;
						case "km":	a*=39370.1;
									break;
						case "mile":a*=1760;
						case "yard":a*=3;
						case "feet":a*=12;
									break;
						default:	break;
					}
					strNum=""+a;
					txtCalc.setText(strNum+" in");
					unit="";
					end=true;
				}else {
					txtCalc.setText("올바른 입력이 아닙니다.");
				}
			}
		});
		btnInch.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnInch.setBounds(515, 165, 60, 60);
		contentPane.add(btnInch);
		
		
		JButton btnG = new JButton("g");
		btnG.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnG.setBounds(305, 235, 60, 60);
		contentPane.add(btnG);
		
		JButton btnKg = new JButton("kg");
		btnKg.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnKg.setBounds(375, 235, 60, 60);
		contentPane.add(btnKg);
		
		JButton btnPd = new JButton("lb");
		btnPd.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnPd.setBounds(445, 235, 60, 60);
		contentPane.add(btnPd);
		
		JButton btnOz = new JButton("Oz");
		btnOz.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnOz.setBounds(515, 235, 60, 60);
		contentPane.add(btnOz);
		
		
		JButton btnSec = new JButton("sec");
		btnSec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(unit.isBlank()) {
					txtFunc.setText(strNum+" 초 =");
					txtCalc.setText("변환할 단위를 골라주세요");
					unit="sec";
				}else if(Arrays.asList(time).contains(unit)){
					double a = Double.parseDouble(strNum);
					switch (unit) {
						case "day":a*=24;
						case "hour":a*=60;
						case "min":a*=60;
									break;
						default:	break;
					}
					strNum=""+a;
					txtCalc.setText(strNum+" 초");
					unit="";
					end=true;
				}else {
					txtCalc.setText("올바른 입력이 아닙니다.");
				}
			}
		});
		btnSec.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnSec.setBounds(305, 305, 60, 60);
		contentPane.add(btnSec);
		
		JButton btnMin = new JButton("min");
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(unit.isBlank()) {
					txtFunc.setText(strNum+" 분 =");
					txtCalc.setText("변환할 단위를 골라주세요");
					unit="min";
				}else if(Arrays.asList(time).contains(unit)){
					double a = Double.parseDouble(strNum);
					switch (unit) {
						case "day":a*=24;
						case "hour":a*=60;
									break;
						case "sec":a/=60;
						default:	break;
					}
					strNum=""+a;
					txtCalc.setText(strNum+" 분");
					unit="";
					end=true;
				}else {
					txtCalc.setText("올바른 입력이 아닙니다.");
				}
			}
		});
		btnMin.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnMin.setBounds(375, 305, 60, 60);
		contentPane.add(btnMin);
		
		JButton btnHour = new JButton("hour");
		btnHour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(unit.isBlank()) {
					txtFunc.setText(strNum+" 시간 =");
					txtCalc.setText("변환할 단위를 골라주세요");
					unit="hour";
				}else if(Arrays.asList(time).contains(unit)){
					double a = Double.parseDouble(strNum);
					switch (unit) {
						case "day":a*=24;
									break;
						case "sec":a/=60;
						case "min":a/=60;
						default:	break;
					}
					strNum=""+a;
					txtCalc.setText(strNum+" 시간");
					unit="";
					end=true;
				}else {
					txtCalc.setText("올바른 입력이 아닙니다.");
				}
			}
		});
		btnHour.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnHour.setBounds(445, 305, 60, 60);
		contentPane.add(btnHour);
		
		JButton btnDay = new JButton("day");
		btnDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(unit.isBlank()) {
					txtFunc.setText(strNum+" 일 =");
					txtCalc.setText("변환할 단위를 골라주세요");
					unit="day";
				}else if(Arrays.asList(time).contains(unit)){
					double a = Double.parseDouble(strNum);
					switch (unit) {
						case "sec":a/=60;
						case "min":a/=60;
						case "hour":a/=24;
						default:	break;
					}
					strNum=""+a;
					txtCalc.setText(strNum+" 일");
					unit="";
					end=true;
				}else {
					txtCalc.setText("올바른 입력이 아닙니다.");
				}
			}
		});
		btnDay.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnDay.setBounds(515, 305, 60, 60);
		contentPane.add(btnDay);
		
		JButton btnC = new JButton("℃");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(unit.isBlank()) {
					txtFunc.setText(strNum+"℃ =");
					txtCalc.setText("변환할 단위를 골라주세요");
					unit="C";
				}else if(Arrays.asList(tem).contains(unit)){
					double c = Double.parseDouble(strNum);
					switch (unit) {
						case "K": c-=273.15;
									break;
						case "F": c=(c-32)*5/9;
						default:	break;
					}
					strNum=""+c;
					txtCalc.setText(strNum+"℃");
					unit="";
					end=true;
				}else {
					txtCalc.setText("올바른 입력이 아닙니다.");
				}
			}
		});
		btnC.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnC.setBounds(305, 375, 60, 60);
		contentPane.add(btnC);
		
		JButton btnF = new JButton("℉");
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(unit.isBlank()) {
					txtFunc.setText(strNum+"℉ =");
					txtCalc.setText("변환할 단위를 골라주세요");
					unit="F";
				}else if(Arrays.asList(tem).contains(unit)){
					double f = Double.parseDouble(strNum);
					switch (unit) {
						case "K": f-=273.15;
						case "C": f=(f*9/5)+32;
						default:	break;
					}
					strNum=""+f;
					txtCalc.setText(strNum+"℉");
					unit="";
					end=true;
				}else {
					txtCalc.setText("올바른 입력이 아닙니다.");
				}
			}
		});
		btnF.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnF.setBounds(375, 375, 60, 60);
		contentPane.add(btnF);

		JButton btnK = new JButton("K");
		btnK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(unit.isBlank()) {
					txtFunc.setText(strNum+"K =");
					txtCalc.setText("변환할 단위를 골라주세요");
					unit="K";
				}else if(Arrays.asList(tem).contains(unit)){
					double k = Double.parseDouble(strNum);
					switch (unit) {
						case "F": k=(k-32)*5/9;
						case "C": k+=273.15;
						default:	break;
					}
					strNum=""+k;
					txtCalc.setText(strNum+"K");
					unit="";
					end=true;
				}else {
					txtCalc.setText("올바른 입력이 아닙니다.");
				}
			}
		});
		btnK.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnK.setBounds(445, 375, 60, 60);
		contentPane.add(btnK);
		
		JButton btnP = new JButton("㎡/평");
		btnP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(unit.isBlank()) {
					txtFunc.setText(strNum+" ㎡ =");
					double p = Double.parseDouble(strNum)*0.3025;
					strNum=""+p;
					txtCalc.setText(strNum+" 평");
					end=true;
				}else {
					txtCalc.setText("올바른 입력이 아닙니다.");
				}
			}
		});
		btnP.setFont(new Font("나눔고딕", Font.PLAIN, 11));
		btnP.setBounds(515, 375, 60, 60);
		contentPane.add(btnP);
		
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
		if(strNum.equals("")&&str.equals("－")) {
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
	String[] len = {"mm","cm","m","km","inch","feet","yard","mile"};
	String[] time = {"sec","min","hour","day"};
	String[] weight = {"g","kg","lb","oz"};
	String[] tem = {"F","C","K"};
	
	String unit = "";
	boolean end = false;
	List<Double> num = new ArrayList<>();
	List<String> cal = new ArrayList<>();
	String func="";
	String strNum="";
}
