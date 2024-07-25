package sub2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class ComponentTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUid;
	private JTextField txtName;
	private JTextField txtHp;
	private JTextField txtAddA;
	private JTextField txtAddB;
	private JTextField txtAddC;
	private JTextField txtMinA;
	private JTextField txtMinB;
	private JTextField txtMinC;
	private JTextField txtMulA;
	private JTextField txtMulB;
	private JTextField txtMulC;
	private JTextField txtDivA;
	private JTextField txtDivB;
	private JTextField txtDivC;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComponentTest frame = new ComponentTest();
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
	public ComponentTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("컴포넌트 실습");
		lblNewLabel.setBounds(12, 10, 76, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("버튼 실습");
		lblNewLabel_1.setBounds(12, 35, 57, 15);
		contentPane.add(lblNewLabel_1);

		JButton btn1 = new JButton("확인1");
		btn1.setBounds(35, 60, 97, 23);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 1 입력...");
			}
		});
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("확인2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "버튼 2 클릭...");
			}
		});
		btn2.setBounds(167, 60, 97, 23);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("확인3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(null, "버튼 3 클릭...", "확인대화상자", JOptionPane.YES_NO_OPTION);
				if(answer==0) {
					System.out.println("yes 클릭");
				}else {
					System.out.println("no 클릭");
				}
			}
		});
		btn3.setBounds(299, 60, 97, 23);
		contentPane.add(btn3);
		
		JLabel lblNewLabel_1_1 = new JLabel("텍스트 필드 실습");
		lblNewLabel_1_1.setBounds(12, 107, 117, 15);
		contentPane.add(lblNewLabel_1_1);
		
		txtUid = new JTextField();
		txtUid.setBounds(55, 132, 116, 21);
		contentPane.add(txtUid);
		txtUid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("아이디");
		lblNewLabel_2.setBounds(12, 135, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lbResultUid = new JLabel("결과 :");
		lbResultUid.setBounds(247, 135, 126, 15);
		contentPane.add(lbResultUid);
		
		JButton btnUid = new JButton("확인");
		btnUid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uid = txtUid.getText();
				lbResultUid.setText("결과 : " + uid);
			}
		});
		btnUid.setBounds(174, 131, 70, 23);
		contentPane.add(btnUid);
		
		JLabel lblNewLabel_2_2 = new JLabel("이름");
		lblNewLabel_2_2.setBounds(12, 163, 57, 15);
		contentPane.add(lblNewLabel_2_2);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(55, 160, 116, 21);
		contentPane.add(txtName);
		
		JLabel lbResultName = new JLabel("결과 :");
		lbResultName.setBounds(247, 163, 126, 15);
		contentPane.add(lbResultName);
		
		JButton btnName = new JButton("확인");
		btnName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				lbResultName.setText("결과 : " + name);
			}
		});
		btnName.setBounds(174, 159, 70, 23);
		contentPane.add(btnName);
		
		JLabel lblNewLabel_2_3 = new JLabel("휴대폰");
		lblNewLabel_2_3.setBounds(12, 192, 57, 15);
		contentPane.add(lblNewLabel_2_3);
		
		txtHp = new JTextField();
		txtHp.setColumns(10);
		txtHp.setBounds(55, 189, 116, 21);
		contentPane.add(txtHp);
		
		JLabel lbResultHp = new JLabel("결과 :");
		lbResultHp.setBounds(247, 192, 126, 15);
		contentPane.add(lbResultHp);
		
		JButton btnHp = new JButton("확인");
		btnHp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hp = txtHp.getText();
				lbResultHp.setText("결과 : "+hp);
			}
		});
		btnHp.setBounds(174, 188, 70, 23);
		contentPane.add(btnHp);
		
		JLabel lbAdd = new JLabel("덧셈");
		lbAdd.setBounds(31, 243, 47, 15);
		contentPane.add(lbAdd);
		
		txtAddA = new JTextField();
		txtAddA.setColumns(10);
		txtAddA.setBounds(76, 239, 70, 23);
		contentPane.add(txtAddA);
		
		JLabel lbAddEmoji = new JLabel("＋");
		lbAddEmoji.setHorizontalAlignment(SwingConstants.CENTER);
		lbAddEmoji.setBounds(146, 243, 21, 15);
		contentPane.add(lbAddEmoji);
		
		txtAddB = new JTextField();
		txtAddB.setColumns(10);
		txtAddB.setBounds(168, 239, 66, 23);
		contentPane.add(txtAddB);
		
		JLabel lbAddEq = new JLabel("=");
		lbAddEq.setHorizontalAlignment(SwingConstants.CENTER);
		lbAddEq.setBounds(236, 243, 19, 15);
		contentPane.add(lbAddEq);
		
		txtAddC = new JTextField();
		txtAddC.setColumns(10);
		txtAddC.setBounds(256, 239, 71, 23);
		contentPane.add(txtAddC);
		
		JButton btnAdd = new JButton("확인");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(txtAddA.getText());
				int b = Integer.parseInt(txtAddB.getText());
				txtAddC.setText(""+(a+b));
			}
		});
		btnAdd.setBounds(339, 239, 68, 23);
		contentPane.add(btnAdd);
		
		JLabel lbMin = new JLabel("뺄셈");
		lbMin.setBounds(31, 272, 47, 15);
		contentPane.add(lbMin);
		
		txtMinA = new JTextField();
		txtMinA.setColumns(10);
		txtMinA.setBounds(76, 268, 70, 23);
		contentPane.add(txtMinA);
		
		JLabel lbMinEmoji = new JLabel("－");
		lbMinEmoji.setHorizontalAlignment(SwingConstants.CENTER);
		lbMinEmoji.setBounds(146, 272, 21, 15);
		contentPane.add(lbMinEmoji);
		
		txtMinB = new JTextField();
		txtMinB.setColumns(10);
		txtMinB.setBounds(168, 268, 66, 23);
		contentPane.add(txtMinB);
		
		JLabel lbMinEq = new JLabel("=");
		lbMinEq.setHorizontalAlignment(SwingConstants.CENTER);
		lbMinEq.setBounds(236, 272, 19, 15);
		contentPane.add(lbMinEq);
		
		txtMinC = new JTextField();
		txtMinC.setColumns(10);
		txtMinC.setBounds(256, 268, 71, 23);
		contentPane.add(txtMinC);
		
		JButton btnMin = new JButton("확인");
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int a = Integer.parseInt(txtMinA.getText());
				int b = Integer.parseInt(txtMinB.getText());
				txtMinC.setText(""+(a-b));
			}
		});
		btnMin.setBounds(339, 268, 68, 23);
		contentPane.add(btnMin);
		
		JLabel lbMul = new JLabel("곱셈");
		lbMul.setBounds(31, 301, 47, 15);
		contentPane.add(lbMul);
		
		txtMulA = new JTextField();
		txtMulA.setColumns(10);
		txtMulA.setBounds(76, 297, 70, 23);
		contentPane.add(txtMulA);
		
		JLabel lbMulEmoji = new JLabel("×");
		lbMulEmoji.setHorizontalAlignment(SwingConstants.CENTER);
		lbMulEmoji.setBounds(146, 301, 21, 15);
		contentPane.add(lbMulEmoji);
		
		txtMulB = new JTextField();
		txtMulB.setColumns(10);
		txtMulB.setBounds(168, 297, 66, 23);
		contentPane.add(txtMulB);
		
		JLabel lbMulEq = new JLabel("=");
		lbMulEq.setHorizontalAlignment(SwingConstants.CENTER);
		lbMulEq.setBounds(236, 301, 19, 15);
		contentPane.add(lbMulEq);
		
		txtMulC = new JTextField();
		txtMulC.setColumns(10);
		txtMulC.setBounds(256, 297, 71, 23);
		contentPane.add(txtMulC);
		
		JButton btnMul = new JButton("확인");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(txtMulA.getText());
				int b = Integer.parseInt(txtMulB.getText());
				txtMulC.setText(""+(a*b));
			}
		});
		btnMul.setBounds(339, 297, 68, 23);
		contentPane.add(btnMul);
		
		JLabel lbDiv = new JLabel("나눗셈");
		lbDiv.setBounds(31, 330, 47, 15);
		contentPane.add(lbDiv);
		
		txtDivA = new JTextField();
		txtDivA.setColumns(10);
		txtDivA.setBounds(76, 326, 70, 23);
		contentPane.add(txtDivA);
		
		JLabel lbDivEmoji = new JLabel("÷");
		lbDivEmoji.setHorizontalAlignment(SwingConstants.CENTER);
		lbDivEmoji.setBounds(146, 330, 21, 15);
		contentPane.add(lbDivEmoji);
		
		txtDivB = new JTextField();
		txtDivB.setColumns(10);
		txtDivB.setBounds(168, 326, 66, 23);
		contentPane.add(txtDivB);
		
		JLabel lbDivEq = new JLabel("=");
		lbDivEq.setHorizontalAlignment(SwingConstants.CENTER);
		lbDivEq.setBounds(236, 330, 19, 15);
		contentPane.add(lbDivEq);
		
		txtDivC = new JTextField();
		txtDivC.setColumns(10);
		txtDivC.setBounds(256, 326, 71, 23);
		contentPane.add(txtDivC);
		
		JButton btnDiv = new JButton("확인");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(txtDivA.getText());
				int b = Integer.parseInt(txtDivB.getText());
				txtDivC.setText(""+(a/b));
			}
		});
		btnDiv.setBounds(339, 326, 68, 23);
		contentPane.add(btnDiv);
		
		JLabel lblNewLabelChk = new JLabel("체크박스 실습");
		lblNewLabelChk.setBounds(12, 370, 117, 15);
		contentPane.add(lblNewLabelChk);
		
		JCheckBox chk1 = new JCheckBox("서울");
		chk1.setBounds(12, 391, 57, 23);
		contentPane.add(chk1);
		
		JCheckBox chk2 = new JCheckBox("대전");
		chk2.setBounds(81, 391, 57, 23);
		contentPane.add(chk2);
		
		JCheckBox chk3 = new JCheckBox("대구");
		chk3.setBounds(150, 391, 57, 23);
		contentPane.add(chk3);
		
		JCheckBox chk4 = new JCheckBox("부산");
		chk4.setBounds(219, 391, 57, 23);
		contentPane.add(chk4);
		
		JCheckBox chk5 = new JCheckBox("광주");
		chk5.setBounds(288, 391, 57, 23);
		contentPane.add(chk5);
		
		JLabel lbResultChk = new JLabel("결과 : ");
		lbResultChk.setBounds(15, 420, 358, 15);
		contentPane.add(lbResultChk);
		
		JButton btnChk = new JButton("확인");
		btnChk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> cities = new ArrayList<>();
				
				if(chk1.isSelected())cities.add(chk1.getText());
				if(chk2.isSelected())cities.add(chk2.getText());
				if(chk3.isSelected())cities.add(chk3.getText());
				if(chk4.isSelected())cities.add(chk4.getText());
				if(chk5.isSelected())cities.add(chk5.getText());
				
				lbResultChk.setText("결과 : "+cities);
				
			}
		});
		btnChk.setBounds(357, 391, 62, 23);
		contentPane.add(btnChk);
		
		JLabel lbTb = new JLabel("테이블 실습");
		lbTb.setBounds(12, 445, 117, 15);
		contentPane.add(lbTb);
		
		// 테이블 설정
		String[] columnNames = {"아이디","이름","나이","휴대폰"};
		table = new JTable(null,columnNames);
		table.setBounds(35, 471, 361, 87);
		contentPane.add(table);

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
	
		
		JButton btnTable = new JButton("출력");
		btnTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Person> persons = new ArrayList<Person>();
				persons.add(new Person("a101", "김유신", 23, "010-1234-1001"));
				persons.add(new Person("a102", "김춘추", 21, "010-1234-1002"));
				persons.add(new Person("a103", "장보고", 33, "010-1234-1003"));
				persons.add(new Person("a104", "강감찬", 43, "010-1234-1004"));
				persons.add(new Person("a105", "이순신", 53, "010-1234-1005"));
				
				for(Person p : persons) {
					Object[] rowData = {p.getId(),p.getName(),p.getAge(),p.getHp()};
					model.addRow(rowData);
				}
			}
		});
		btnTable.setBounds(55, 568, 76, 23);
		contentPane.add(btnTable);
	}
}
