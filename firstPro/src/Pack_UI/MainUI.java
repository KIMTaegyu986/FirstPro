package Pack_UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPasswordField;
import java.awt.Panel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import Pack_Model.LoginDAO;
import Pack_Model.PlayerTableModel;
import Pack_Model.TeamComboModel;
import Pack_Player.PlayerDAO;
import Pack_Player.PlayerVO;

import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class MainUI extends JFrame {

	private JPanel contentPane;

	JPanel panel_CreateUser = new JPanel();
	Panel panel_Initial = new Panel();
	JPanel panel_MainMenu = new JPanel();
	JPanel panel_InsertPlayer = new JPanel();
	JPanel panel_DeletePlayer = new JPanel();
	JPanel panel_SelectPlayer = new JPanel();
	JPanel panel_UpdatePlayer = new JPanel();

	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textCreateId;
	private JTextField textCreatePno1;
	private JTextField textCreateName;
	private JTextField textCreateYear;
	private JTextField textCreateMonth;
	private JTextField textCreateDay;
	private JTextField textCreatePno2;
	private JTextField textCreatePno3;
	private JPasswordField passwordFieldCreatePw;
	private final JButton btnMenuInsertPlayer = new JButton("\uC120 \uC218 \uCD94 \uAC00");
	private final JButton btnMenuDeletePlayer = new JButton("\uC120 \uC218 \uC0AD \uC81C");
	private final JButton btnMenuUpdatePlayer = new JButton("\uC120 \uC218 \uC218 \uC815");
	private final JButton btnMenuSelectPlayer = new JButton("\uC120 \uC218 \uAC80 \uC0C9");
	private final JButton btnMenuExit = new JButton("\uD504 \uB85C \uADF8 \uB7A8  \uC885 \uB8CC");
	private final JLabel lblNewLabel4_1 = new JLabel("\uC774\uB984");
	private final JLabel lblNewLabel4_2 = new JLabel("\uD300\uBA85");
	private final JLabel lblNewLabel4_3 = new JLabel("\uD0A4");
	private final JLabel lblNewLabel4_4 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
	private final JLabel lblNewLabel4_5 = new JLabel("\uBAB8\uBB34\uAC8C");
	private final JLabel lblNewLabel4_6 = new JLabel("\uD3EC\uC9C0\uC158");
	private final JLabel lblNewLabel4_7 = new JLabel("\uB4F1\uBC88\uD638");
	private final JTextField textField_4_PlayerName = new JTextField();
	private final JComboBox comboBox_4_Team = new JComboBox();
	private final JTextField textField_4_Height = new JTextField();
	private final JTextField textField_4_Year = new JTextField();
	private final JTextField textField_4_Month = new JTextField();
	private final JTextField textField_4_Day = new JTextField();
	private final JLabel lblNewLabel_3 = new JLabel("ex) 1990 01 01");
	private final JTextField textField_4_Weigth = new JTextField();
	private final JTextField textField_4_BackNum = new JTextField();
	private final JComboBox comboBox_4_Position = new JComboBox();
	private final JButton btn_4_Back = new JButton("\uBA54 \uB274 \uB85C  \uC774 \uB3D9");
	private final JButton btn_4_InsertPlayer = new JButton("\uC120 \uC218 \uCD94 \uAC00");
	private final JLabel lblNewLabel_5 = new JLabel("팀 코드");
	private final JTextField textField_5_PlayerName = new JTextField();
	private JTable table_5_SearchResult;

	int playerNum = 0;
	private JTextField textField_7_PlayerName;
	private JTable table_7_ResultPlayer;
	private JTextField textField_6_P_code;
	private JTextField textField_6_Pname;
	private JTextField textField_6_Pheigth;
	private JTextField textField_6_Year;
	private JTextField textField_6_Weight;
	private JTextField textField_6_Backno;
	private JTextField textField_6_Month;
	private JTextField textField_6_Day;
	private JTextField textField_6_P_no;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainUI() {
		textField_4_Year.setBounds(221, 215, 84, 21);
		textField_4_Year.setColumns(10);
		textField_4_Height.setBounds(221, 177, 215, 21);
		textField_4_Height.setColumns(10);
		textField_4_PlayerName.setBounds(221, 95, 215, 21);
		textField_4_PlayerName.setColumns(10);
		setTitle("KBO 리그 선수 데이터 관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane.setLayout(null);
								
								//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ1. 로그인 패널ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
										panel_Initial.setBounds(0, 0, 637, 501);
										contentPane.add(panel_Initial);
										panel_Initial.setLayout(null);
										
												JLabel lblNewLabel = new JLabel("야구선수 관리 시스템");
												lblNewLabel.setBounds(160, 30, 340, 35);
												lblNewLabel.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 30));
												panel_Initial.add(lblNewLabel);
												
														JLabel lblNewLabel_1 = new JLabel("ID");
														lblNewLabel_1.setBounds(200, 115, 30, 30);
														lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 18));
														panel_Initial.add(lblNewLabel_1);
														
																JLabel lblNewLabel_1_1 = new JLabel("PW");
																lblNewLabel_1_1.setBounds(200, 170, 30, 30);
																lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 18));
																panel_Initial.add(lblNewLabel_1_1);
																
																		textField = new JTextField();
																		textField.setBounds(230, 115, 200, 30);
																		textField.setColumns(10);
																		panel_Initial.add(textField);
																		
																				JButton btnLogin = new JButton("로 그 인");
																				btnLogin.addMouseListener(new MouseAdapter() {
																					@Override
																					public void mouseClicked(MouseEvent e) {
																						LoginDAO dao = new LoginDAO();
																						try {
																							if (dao.searchId(textField.getText(), passwordField.getText())) {
																								JOptionPane.showMessageDialog(MainUI.this, "로그인에 성공했습니다.");
																								panel_Initial.setVisible(false);
																								panel_CreateUser.setVisible(false);
																								panel_MainMenu.setVisible(true);
																							} else {
																								JOptionPane.showMessageDialog(MainUI.this, "로그인에 실패했습니다. ID나 PW를 다시 확인해주세요");
																							}
																						} catch (SQLException e1) {
																							// TODO Auto-generated catch block
																							e1.printStackTrace();
																						}
																					}
																				});
																				btnLogin.setBounds(200, 250, 230, 30);
																				btnLogin.setFont(new Font("굴림", Font.BOLD, 20));
																				panel_Initial.add(btnLogin);
																				
																						JButton btnCreateUser = new JButton("회 원 가 입");
																						btnCreateUser.addMouseListener(new MouseAdapter() {
																							@Override
																							public void mouseClicked(MouseEvent e) {
																								panel_MainMenu.setVisible(false);
																								panel_Initial.setVisible(false);
																								panel_DeletePlayer.setVisible(false);
																								panel_SelectPlayer.setVisible(false);
																								panel_UpdatePlayer.setVisible(false);
																								panel_InsertPlayer.setVisible(false);
																								panel_CreateUser.setVisible(true);

																							}
																						});
																						btnCreateUser.setBounds(200, 300, 230, 30);
																						btnCreateUser.setFont(new Font("굴림", Font.BOLD, 20));
																						panel_Initial.add(btnCreateUser);
																						
																								passwordField = new JPasswordField();
																								passwordField.setBounds(230, 170, 200, 30);
																								panel_Initial.add(passwordField);
						
						//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ2. 회원가입 패널ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
								panel_CreateUser.setBounds(0, 0, 637, 501);
								contentPane.add(panel_CreateUser);
								panel_CreateUser.setLayout(null);
								
										JLabel lblNewLabe2 = new JLabel("\uD68C \uC6D0 \uAC00 \uC785");
										lblNewLabe2.setBounds(233, 28, 187, 35);
										lblNewLabe2.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 30));
										panel_CreateUser.add(lblNewLabe2);
										
												JLabel lblNewLabel2_1 = new JLabel("ID");
												lblNewLabel2_1.setBounds(137, 94, 25, 30);
												lblNewLabel2_1.setFont(new Font("굴림", Font.BOLD, 18));
												panel_CreateUser.add(lblNewLabel2_1);
												
														JLabel lblNewLabel2_1_1 = new JLabel("PW");
														lblNewLabel2_1_1.setFont(new Font("굴림", Font.BOLD, 18));
														lblNewLabel2_1_1.setBounds(137, 135, 36, 30);
														panel_CreateUser.add(lblNewLabel2_1_1);
														
																JLabel lblNewLabel2_1_2 = new JLabel("성 별");
																lblNewLabel2_1_2.setFont(new Font("굴림", Font.BOLD, 18));
																lblNewLabel2_1_2.setBounds(137, 224, 50, 30);
																panel_CreateUser.add(lblNewLabel2_1_2);
																
																		JLabel lblNewLabel2_1_3 = new JLabel("휴대전화");
																		lblNewLabel2_1_3.setFont(new Font("굴림", Font.BOLD, 18));
																		lblNewLabel2_1_3.setBounds(116, 308, 80, 30);
																		panel_CreateUser.add(lblNewLabel2_1_3);
																		
																				JLabel lblNewLabel2_1_4 = new JLabel("생년월일");
																				lblNewLabel2_1_4.setFont(new Font("굴림", Font.BOLD, 18));
																				lblNewLabel2_1_4.setBounds(116, 266, 79, 30);
																				panel_CreateUser.add(lblNewLabel2_1_4);
																				
																						JLabel lblNewLabel2_1_5 = new JLabel("이름");
																						lblNewLabel2_1_5.setFont(new Font("굴림", Font.BOLD, 18));
																						lblNewLabel2_1_5.setBounds(137, 177, 50, 30);
																						panel_CreateUser.add(lblNewLabel2_1_5);
																						
																								JComboBox comboCreateGender = new JComboBox();
																								comboCreateGender.setModel(new DefaultComboBoxModel(new String[] { "남", "여" }));
																								comboCreateGender.setSelectedIndex(0);
																								comboCreateGender.setBounds(207, 225, 119, 23);
																								panel_CreateUser.add(comboCreateGender);
																								
																										JButton btnOverlapchk = new JButton("중복확인");
																										btnOverlapchk.addMouseListener(new MouseAdapter() {
																											@Override
																											public void mouseClicked(MouseEvent e) {
																												LoginDAO dao = new LoginDAO();
																												try {
																													if (dao.checkId(textCreateId.getText())) {
																														JOptionPane.showMessageDialog(MainUI.this, "ID가 중복됩니다. 다른 ID를 사용해주세요.");
																														textCreateId.setText("");
																													} else {
																														JOptionPane.showMessageDialog(MainUI.this, "사용가능한 ID입니다.");
																													}

																												} catch (HeadlessException | SQLException e1) {
																													// TODO Auto-generated catch block
																													e1.printStackTrace();
																												}
																											}
																										});
																										btnOverlapchk.setBounds(450, 95, 97, 23);
																										panel_CreateUser.add(btnOverlapchk);
																										
																												JButton btnCreate = new JButton("\uD68C \uC6D0 \uAC00 \uC785");
																												btnCreate.addMouseListener(new MouseAdapter() {
																													@Override
																													public void mouseClicked(MouseEvent e) {
																														String birth = textCreateYear.getText() + "-" + textCreateMonth.getText() + "-" + textCreateDay.getText();
																														String pno = textCreatePno1.getText() + "-" + textCreatePno2.getText() + "-" + textCreatePno3.getText();
																														char[] pw = passwordFieldCreatePw.getPassword();
																														String password = String.valueOf(pw);
																														LoginDAO dao = new LoginDAO();
																														dao.createUser(textCreateId.getText(), password , textCreateName.getText(), (String) comboCreateGender.getSelectedItem(), birth, pno);
																														JOptionPane.showMessageDialog(MainUI.this, "회원가입이 완료되었습니다.");
																														panel_CreateUser.setVisible(false);
																														panel_Initial.setVisible(true);

																													}
																												});
																												btnCreate.setFont(new Font("굴림", Font.PLAIN, 15));
																												btnCreate.setBounds(341, 388, 135, 35);
																												panel_CreateUser.add(btnCreate);
																												
																												textCreateId = new JTextField();
																												textCreateId.setBounds(207, 96, 231, 25);
																												panel_CreateUser.add(textCreateId);
																												textCreateId.setColumns(10);
																												
																												textCreateName = new JTextField();
																												textCreateName.setColumns(10);
																												textCreateName.setBounds(207, 177, 231, 25);
																												panel_CreateUser.add(textCreateName);
																												
																														textCreateYear = new JTextField();
																														textCreateYear.setBounds(207, 268, 79, 25);
																														panel_CreateUser.add(textCreateYear);
																														textCreateYear.setColumns(10);
																														
																																textCreateMonth = new JTextField();
																																textCreateMonth.setColumns(10);
																																textCreateMonth.setBounds(296, 268, 65, 25);
																																panel_CreateUser.add(textCreateMonth);
																																
																																		textCreateDay = new JTextField();
																																		textCreateDay.setColumns(10);
																																		textCreateDay.setBounds(373, 268, 65, 25);
																																		panel_CreateUser.add(textCreateDay);
																																		
																																				textCreatePno1 = new JTextField();
																																				textCreatePno1.setColumns(10);
																																				textCreatePno1.setBounds(207, 308, 50, 25);
																																				panel_CreateUser.add(textCreatePno1);
																																				
																																				textCreatePno2 = new JTextField();
																																				textCreatePno2.setColumns(10);
																																				textCreatePno2.setBounds(270, 308, 75, 25);
																																				panel_CreateUser.add(textCreatePno2);
																																				
																																						textCreatePno3 = new JTextField();
																																						textCreatePno3.setColumns(10);
																																						textCreatePno3.setBounds(361, 308, 75, 25);
																																						panel_CreateUser.add(textCreatePno3);
																																						
																																								passwordFieldCreatePw = new JPasswordField();
																																								passwordFieldCreatePw.setBounds(207, 137, 231, 21);
																																								panel_CreateUser.add(passwordFieldCreatePw);
																																								
																																										JButton btnCreateBack = new JButton("\uB4A4 \uB85C \uAC00 \uAE30 ");
																																										btnCreateBack.addMouseListener(new MouseAdapter() {
																																											@Override
																																											public void mouseClicked(MouseEvent e) {
																																												panel_CreateUser.setVisible(false);
																																												panel_Initial.setVisible(true);
																																											}
																																										});
																																										btnCreateBack.setFont(new Font("굴림", Font.PLAIN, 15));
																																										btnCreateBack.setBounds(171, 388, 135, 35);
																																										panel_CreateUser.add(btnCreateBack);

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ3. 메뉴 패널ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

		panel_MainMenu.setBounds(0, 0, 637, 501);
		contentPane.add(panel_MainMenu);
		panel_MainMenu.setLayout(null);

		JLabel lblNewLabel3 = new JLabel("야구선수 관리 시스템");
		panel_MainMenu.add(lblNewLabel3);
		lblNewLabel3.setBounds(157, 27, 342, 35);
		lblNewLabel3.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 30));
		btnMenuInsertPlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_MainMenu.setVisible(false);
				panel_CreateUser.setVisible(false);
				panel_Initial.setVisible(false);
				panel_DeletePlayer.setVisible(false);
				panel_SelectPlayer.setVisible(false);
				panel_UpdatePlayer.setVisible(false);
				panel_InsertPlayer.setVisible(true);

			}
		});
		btnMenuInsertPlayer.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		btnMenuInsertPlayer.setBounds(219, 100, 212, 48);

		panel_MainMenu.add(btnMenuInsertPlayer);
		btnMenuDeletePlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_MainMenu.setVisible(false);
				panel_CreateUser.setVisible(false);
				panel_Initial.setVisible(false);
				panel_SelectPlayer.setVisible(false);
				panel_UpdatePlayer.setVisible(false);
				panel_InsertPlayer.setVisible(false);
				panel_DeletePlayer.setVisible(true);
			}
		});
		btnMenuDeletePlayer.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		btnMenuDeletePlayer.setBounds(219, 187, 212, 48);

		panel_MainMenu.add(btnMenuDeletePlayer);
		btnMenuUpdatePlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_MainMenu.setVisible(false);
				panel_CreateUser.setVisible(false);
				panel_Initial.setVisible(false);
				panel_SelectPlayer.setVisible(false);
				panel_InsertPlayer.setVisible(false);
				panel_DeletePlayer.setVisible(false);
				panel_UpdatePlayer.setVisible(true);
			}
		});
		btnMenuUpdatePlayer.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		btnMenuUpdatePlayer.setBounds(219, 270, 212, 48);

		panel_MainMenu.add(btnMenuUpdatePlayer);
		btnMenuSelectPlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_MainMenu.setVisible(false);
				panel_CreateUser.setVisible(false);
				panel_Initial.setVisible(false);
				panel_InsertPlayer.setVisible(false);
				panel_DeletePlayer.setVisible(false);
				panel_UpdatePlayer.setVisible(false);
				panel_SelectPlayer.setVisible(true);
			}
		});
		btnMenuSelectPlayer.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		btnMenuSelectPlayer.setBounds(219, 353, 212, 48);

		panel_MainMenu.add(btnMenuSelectPlayer);
		btnMenuExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnMenuExit.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 18));
		btnMenuExit.setBounds(219, 432, 212, 48);

		panel_MainMenu.add(btnMenuExit);

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ4. 선수 추가 패널ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

		panel_InsertPlayer.setBounds(0, 0, 637, 501);
		contentPane.add(panel_InsertPlayer);
		panel_InsertPlayer.setLayout(null);

		JLabel lblNewLabel4 = new JLabel("선수 추가");
		lblNewLabel4.setBounds(234, 20, 172, 35);
		lblNewLabel4.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 30));
		panel_InsertPlayer.add(lblNewLabel4);
		lblNewLabel4_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel4_1.setBounds(144, 92, 65, 21);

		panel_InsertPlayer.add(lblNewLabel4_1);
		lblNewLabel4_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel4_2.setBounds(144, 133, 65, 21);

		panel_InsertPlayer.add(lblNewLabel4_2);
		lblNewLabel4_3.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel4_3.setBounds(144, 174, 65, 21);

		panel_InsertPlayer.add(lblNewLabel4_3);
		lblNewLabel4_4.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel4_4.setBounds(144, 215, 65, 21);

		panel_InsertPlayer.add(lblNewLabel4_4);
		lblNewLabel4_5.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel4_5.setBounds(144, 257, 65, 21);

		panel_InsertPlayer.add(lblNewLabel4_5);
		lblNewLabel4_6.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel4_6.setBounds(144, 300, 65, 21);

		panel_InsertPlayer.add(lblNewLabel4_6);
		lblNewLabel4_7.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel4_7.setBounds(144, 342, 65, 21);

		panel_InsertPlayer.add(lblNewLabel4_7);

		panel_InsertPlayer.add(textField_4_PlayerName);
		comboBox_4_Team.setBounds(221, 135, 215, 23);

		comboBox_4_Team.setModel(new TeamComboModel());
		panel_InsertPlayer.add(comboBox_4_Team);

		panel_InsertPlayer.add(textField_4_Height);

		panel_InsertPlayer.add(textField_4_Year);
		textField_4_Month.setColumns(10);
		textField_4_Month.setBounds(317, 215, 53, 21);

		panel_InsertPlayer.add(textField_4_Month);
		textField_4_Day.setColumns(10);
		textField_4_Day.setBounds(375, 215, 61, 21);

		panel_InsertPlayer.add(textField_4_Day);
		lblNewLabel_3.setBounds(452, 215, 133, 15);

		panel_InsertPlayer.add(lblNewLabel_3);
		textField_4_Weigth.setColumns(10);
		textField_4_Weigth.setBounds(221, 257, 215, 21);

		panel_InsertPlayer.add(textField_4_Weigth);
		textField_4_BackNum.setColumns(10);
		textField_4_BackNum.setBounds(221, 342, 215, 21);

		panel_InsertPlayer.add(textField_4_BackNum);
		comboBox_4_Position.setModel(new DefaultComboBoxModel(new String[] { "내야수", "외야수","투수", "포수" }));
		comboBox_4_Position.setSelectedIndex(0);
		comboBox_4_Position.setBounds(221, 298, 215, 23);

		panel_InsertPlayer.add(comboBox_4_Position);
		btn_4_Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_InsertPlayer.setVisible(false);
				panel_MainMenu.setVisible(true);
			}
		});
		btn_4_Back.setFont(new Font("굴림", Font.PLAIN, 15));
		btn_4_Back.setBounds(144, 411, 133, 35);
		panel_InsertPlayer.add(btn_4_Back);

		btn_4_InsertPlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String p_birth = textField_4_Year.getText() + "/" + textField_4_Month.getText() + "/" + textField_4_Day.getText();
				String t_codes = (String)comboBox_4_Team.getSelectedItem();
				String[] t_code = t_codes.split("\\(");
				
				PlayerDAO dao = new PlayerDAO();
				try {
					dao.insertPlayer( t_code[0], textField_4_PlayerName.getText(), textField_4_Height.getText(), p_birth, textField_4_Weigth.getText(), (String)comboBox_4_Position.getSelectedItem(), textField_4_BackNum.getText() );
					JOptionPane.showMessageDialog( MainUI.this, "선수 추가가 완료되었습니다.");
					textField_4_PlayerName.setText("");
					textField_4_BackNum.setText("");
					textField_4_Day.setText("");
					textField_4_Height.setText("");
					textField_4_Month.setText("");
					textField_4_Weigth.setText("");
					textField_4_Year.setText("");
					
					panel_InsertPlayer.setVisible( false );
					panel_MainMenu.setVisible( true );
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog( MainUI.this, "값이 이상합니다 다시 입력해주세요.");
					textField_4_PlayerName.setText("");
					textField_4_BackNum.setText("");
					textField_4_Day.setText("");
					textField_4_Height.setText("");
					textField_4_Month.setText("");
					textField_4_Weigth.setText("");
					textField_4_Year.setText("");
					e1.printStackTrace();
				}
			}
		});
		btn_4_InsertPlayer.setFont(new Font("굴림", Font.PLAIN, 15));
		btn_4_InsertPlayer.setBounds(335, 411, 133, 35);
		panel_InsertPlayer.add(btn_4_InsertPlayer);

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ5. 선수 삭제 패널ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

		panel_DeletePlayer.setBounds(0, 0, 637, 501);
		contentPane.add(panel_DeletePlayer);
		panel_DeletePlayer.setLayout(null);

		JLabel lblNewLabel5 = new JLabel("선 수 삭 제");
		lblNewLabel5.setBounds(233, 28, 200, 35);
		lblNewLabel5.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 30));
		panel_DeletePlayer.add(lblNewLabel5);
		lblNewLabel_5.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(104, 94, 91, 25);

		panel_DeletePlayer.add(lblNewLabel_5);

		JComboBox textField_5_PlayerName = new JComboBox();
		textField_5_PlayerName.setModel(new DefaultComboBoxModel(new String[] { "K1", "K2" }));
		textField_5_PlayerName.setSelectedIndex(0);
		textField_5_PlayerName.setBounds(190, 94, 250, 23);
		panel_DeletePlayer.add(textField_5_PlayerName);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 142, 613, 259);
		panel_DeletePlayer.add(scrollPane);

		table_5_SearchResult = new JTable();
		scrollPane.setViewportView(table_5_SearchResult);

		JButton btn_5_Search = new JButton("\uAC80 \uC0C9");
		btn_5_Search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String playerName = (String) textField_5_PlayerName.getSelectedItem();

				table_5_SearchResult.setModel(new PlayerTableModel(playerName));

			}
		});

		table_5_SearchResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playerNum = Integer .parseInt((String) table_5_SearchResult.getValueAt(table_5_SearchResult.getSelectedRow(), 0));
			}
		});

		btn_5_Search.setFont(new Font("굴림", Font.PLAIN, 15));
		btn_5_Search.setBounds(451, 94, 119, 25);
		panel_DeletePlayer.add(btn_5_Search);

		JButton btn_5_Menu = new JButton("\uBA54 \uB274");
		btn_5_Menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_DeletePlayer.setVisible(false);
				panel_MainMenu.setVisible(true);
			}
		});
		btn_5_Menu.setFont(new Font("굴림", Font.PLAIN, 15));
		btn_5_Menu.setBounds(144, 411, 133, 35);
		panel_DeletePlayer.add(btn_5_Menu);

		JButton btn_5_Delete = new JButton("삭 제");
		btn_5_Delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PlayerDAO dao = new PlayerDAO();
				String playerName = (String) textField_5_PlayerName.getSelectedItem();
				dao.deletePlayer(playerNum);
				JOptionPane.showMessageDialog(MainUI.this, "선수 삭제가 완료되었습니다. 다시 검색해보세요.");

			}
		});
		btn_5_Delete.setFont(new Font("굴림", Font.PLAIN, 15));
		btn_5_Delete.setBounds(335, 411, 133, 35);
		panel_DeletePlayer.add(btn_5_Delete);

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ6. 선수 수정 패널ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uC120\uC218 \uC815\uBCF4\uB97C \uC218\uC815\uD574\uC8FC\uC138\uC694", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(91, 105, 495, 280);
		panel_UpdatePlayer.add(panel);
		panel.setLayout(null);

		panel_UpdatePlayer.setBounds(0, 0, 637, 501);
		contentPane.add(panel_UpdatePlayer);
		panel_UpdatePlayer.setLayout(null);

		JLabel lblNewLabel_6_1 = new JLabel("\uC120 \uC218 \uC218 \uC815");
		lblNewLabel_6_1.setFont(new Font("HY헤드라인M", Font.BOLD, 30));
		lblNewLabel_6_1.setBounds(236, 10, 184, 47);
		panel_UpdatePlayer.add(lblNewLabel_6_1);

		JLabel lblNewLabel_7_2 = new JLabel("\uC120 \uC218 \uBC88 \uD638");
		lblNewLabel_7_2.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_7_2.setBounds(77, 72, 77, 23);
		panel_UpdatePlayer.add(lblNewLabel_7_2);

		textField_6_P_code = new JTextField();
		textField_6_P_code.setBounds(166, 71, 278, 23);
		panel_UpdatePlayer.add(textField_6_P_code);
		textField_6_P_code.setColumns(10);

		JComboBox comboBox_6_Position = new JComboBox();
		comboBox_6_Position.setBounds(75, 210, 250, 21);
		panel.add(comboBox_6_Position);
		comboBox_6_Position.setModel(new DefaultComboBoxModel(new String[] { "내야수", "외야수","투수", "포수" }));

		JComboBox comboBox_6_Tcode = new JComboBox();
		comboBox_6_Tcode.setBounds(75, 60, 250, 23);
		panel.add(comboBox_6_Tcode);

		JButton btn_6_SearchPlayer = new JButton("\uAC80 \uC0C9");
		btn_6_SearchPlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer pNumber = Integer.parseInt(textField_6_P_code.getText());
				ArrayList<PlayerVO> to = new ArrayList<PlayerVO>();
				PlayerDAO dao = new PlayerDAO();
				to = dao.searchPlayer_6(pNumber);

				comboBox_6_Tcode.setModel(new TeamComboModel());
				int i = 0;
				for (i = 0; i < comboBox_6_Tcode.getItemCount(); i++) {
					if (comboBox_6_Tcode.getItemAt(i).toString().contains(to.get(0).getT_code())) {
						break;
					}
				}
				int j = 0;
				for (j = 0; j < comboBox_6_Tcode.getItemCount(); j++) {
					if (comboBox_6_Position.getItemAt(j).toString().contains(to.get(0).getP_pos())) {
						break;
					}
				}
				String[] p_birth = to.get(0).getP_birth().split("/");

				comboBox_6_Tcode.setSelectedIndex(i);
				textField_6_P_no.setText(to.get(0).getP_no());
				textField_6_Pname.setText(to.get(0).getP_name());
				textField_6_Pheigth.setText(to.get(0).getP_length());
				textField_6_Year.setText(p_birth[0]);
				textField_6_Month.setText(p_birth[1]);
				textField_6_Day.setText(p_birth[2]);
				textField_6_Weight.setText(to.get(0).getP_weight());
				comboBox_6_Position.setSelectedIndex(j);
				textField_6_Backno.setText(to.get(0).getP_backno());

			}
		});
		btn_6_SearchPlayer.setBounds(464, 72, 97, 23);
		panel_UpdatePlayer.add(btn_6_SearchPlayer);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("번 호");
		lblNewLabel_7_1_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_7_1_1.setBounds(12, 30, 42, 18);
		panel.add(lblNewLabel_7_1_1);

		JLabel lblNewLabel_7_2_1 = new JLabel("\uD300\uCF54\uB4DC");
		lblNewLabel_7_2_1.setBounds(12, 60, 42, 18);
		panel.add(lblNewLabel_7_2_1);
		lblNewLabel_7_2_1.setFont(new Font("굴림", Font.PLAIN, 15));

		JLabel lblNewLabel_7_2_2 = new JLabel("\uC774 \uB984");
		lblNewLabel_7_2_2.setBounds(12, 90, 33, 18);
		panel.add(lblNewLabel_7_2_2);
		lblNewLabel_7_2_2.setFont(new Font("굴림", Font.PLAIN, 15));

		JLabel lblNewLabel_7_2_3 = new JLabel("\uD0A4");
		lblNewLabel_7_2_3.setBounds(12, 120, 51, 23);
		panel.add(lblNewLabel_7_2_3);
		lblNewLabel_7_2_3.setFont(new Font("굴림", Font.PLAIN, 15));

		JLabel lblNewLabel_7_2_3_1 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lblNewLabel_7_2_3_1.setBounds(12, 150, 56, 18);
		panel.add(lblNewLabel_7_2_3_1);
		lblNewLabel_7_2_3_1.setFont(new Font("굴림", Font.PLAIN, 15));

		JLabel lblNewLabel_7_2_3_2 = new JLabel("\uBAB8\uBB34\uAC8C");
		lblNewLabel_7_2_3_2.setBounds(12, 180, 42, 18);
		panel.add(lblNewLabel_7_2_3_2);
		lblNewLabel_7_2_3_2.setFont(new Font("굴림", Font.PLAIN, 15));

		JLabel lblNewLabel_7_2_3_2_1 = new JLabel("\uD3EC\uC9C0\uC158");
		lblNewLabel_7_2_3_2_1.setBounds(12, 210, 42, 18);
		panel.add(lblNewLabel_7_2_3_2_1);
		lblNewLabel_7_2_3_2_1.setFont(new Font("굴림", Font.PLAIN, 15));

		JLabel lblNewLabel_7_2_3_2_1_1 = new JLabel("\uB4F1\uBC88\uD638");
		lblNewLabel_7_2_3_2_1_1.setBounds(12, 240, 42, 18);
		panel.add(lblNewLabel_7_2_3_2_1_1);
		lblNewLabel_7_2_3_2_1_1.setFont(new Font("굴림", Font.PLAIN, 15));
		
		textField_6_P_no = new JTextField();
		textField_6_P_no.setColumns(10);
		textField_6_P_no.setBounds(75, 30, 250, 23);
		panel.add(textField_6_P_no);

		textField_6_Pname = new JTextField();
		textField_6_Pname.setBounds(75, 90, 250, 21);
		panel.add(textField_6_Pname);
		textField_6_Pname.setColumns(10);

		textField_6_Pheigth = new JTextField();
		textField_6_Pheigth.setBounds(75, 120, 250, 21);
		panel.add(textField_6_Pheigth);
		textField_6_Pheigth.setColumns(10);

		textField_6_Year = new JTextField();
		textField_6_Year.setBounds(75, 150, 100, 21);
		panel.add(textField_6_Year);
		textField_6_Year.setColumns(10);

		textField_6_Weight = new JTextField();
		textField_6_Weight.setBounds(75, 180, 250, 21);
		panel.add(textField_6_Weight);
		textField_6_Weight.setColumns(10);

		textField_6_Backno = new JTextField();
		textField_6_Backno.setBounds(75, 240, 250, 21);
		panel.add(textField_6_Backno);
		textField_6_Backno.setColumns(10);

		textField_6_Month = new JTextField();
		textField_6_Month.setBounds(180, 150, 50, 21);
		panel.add(textField_6_Month);
		textField_6_Month.setColumns(10);

		textField_6_Day = new JTextField();
		textField_6_Day.setBounds(240, 150, 50, 21);
		panel.add(textField_6_Day);
		textField_6_Day.setColumns(10);

		JLabel lblNewLabel_7_2_1_1 = new JLabel("ex) 1999 01 01");
		lblNewLabel_7_2_1_1.setBounds(355, 150, 137, 23);
		panel.add(lblNewLabel_7_2_1_1);
		lblNewLabel_7_2_1_1.setFont(new Font("굴림", Font.PLAIN, 15));

		JButton btn_6_Menu = new JButton("\uBA54 \uB274");
		btn_6_Menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_UpdatePlayer.setVisible(false);
				panel_MainMenu.setVisible(true);
			}
		});
		btn_6_Menu.setFont(new Font("굴림", Font.BOLD, 23));
		btn_6_Menu.setBounds(121, 410, 158, 47);
		panel_UpdatePlayer.add(btn_6_Menu);

		JButton btn_6_UpdatePlayer = new JButton("\uC120 \uC218 \uC218 \uC815");
		btn_6_UpdatePlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PlayerDAO dao = new PlayerDAO();
				String[] t_code = comboBox_6_Tcode.getSelectedItem().toString().split("\\(");
				String t_birth = textField_6_Year.getText() + "/" + textField_6_Month.getText() + "/" + textField_6_Day.getText();
				try {
					dao.updatePlayer(
								Integer.parseInt(textField_6_P_code.getText()),
								Integer.parseInt(textField_6_P_no.getText()),
								t_code[0],
								textField_6_Pname.getText(),
								textField_6_Pheigth.getText(),
								t_birth,
								textField_6_Weight.getText(),
								(String) comboBox_6_Position.getSelectedItem(),
								textField_6_Backno.getText());

					JOptionPane.showMessageDialog(MainUI.this, "선수 수정이 완료되었습니다. 메뉴에서 선수검색을 해보세요.");
					panel_UpdatePlayer.setVisible(false);
					panel_MainMenu.setVisible(true);

				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_6_UpdatePlayer.setFont(new Font("굴림", Font.BOLD, 23));
		btn_6_UpdatePlayer.setBounds(332, 410, 158, 47);
		panel_UpdatePlayer.add(btn_6_UpdatePlayer);

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ7. 선수 검색 패널ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

		panel_SelectPlayer.setBounds(0, 0, 637, 501);
		contentPane.add(panel_SelectPlayer);
		panel_SelectPlayer.setLayout(null);

		JLabel lblNewLabel_7_1 = new JLabel("팀 선 수 조 회");
		lblNewLabel_7_1.setFont(new Font("HY헤드라인M", Font.BOLD, 30));
		lblNewLabel_7_1.setBounds(220, 30, 250, 50);
		panel_SelectPlayer.add(lblNewLabel_7_1);

		JLabel lblNewLabel_7 = new JLabel("팀 코드");
		lblNewLabel_7.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(121, 110, 74, 22);
		panel_SelectPlayer.add(lblNewLabel_7);
		
		JComboBox textField_7_PlayerName = new JComboBox();
		textField_7_PlayerName.setModel(new DefaultComboBoxModel(new String[] { "K1", "K2" }));
		textField_7_PlayerName.setSelectedIndex(0);
		textField_7_PlayerName.setBounds(186, 110, 250, 23);
		panel_SelectPlayer.add(textField_7_PlayerName);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(12, 165, 613, 241);
		panel_SelectPlayer.add(scrollPane_1);

		table_7_ResultPlayer = new JTable();
		scrollPane_1.setViewportView(table_7_ResultPlayer);

		JButton btn_7_SearchPlayer = new JButton("\uAC80 \uC0C9");
		btn_7_SearchPlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String pName = (String) textField_7_PlayerName.getSelectedItem();
				table_7_ResultPlayer.setModel(new PlayerTableModel(pName));
			}
		});
		btn_7_SearchPlayer.setFont(new Font("굴림", Font.PLAIN, 15));
		btn_7_SearchPlayer.setBounds(448, 110, 97, 24);
		panel_SelectPlayer.add(btn_7_SearchPlayer);

		JButton btn_7_Menu = new JButton("\uBA54 \uB274");
		btn_7_Menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_SelectPlayer.setVisible(false);
				panel_MainMenu.setVisible(true);
			}
		});
		btn_7_Menu.setFont(new Font("굴림", Font.PLAIN, 20));
		btn_7_Menu.setBounds(240, 427, 146, 52);
		panel_SelectPlayer.add(btn_7_Menu);
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ끝ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	}
}