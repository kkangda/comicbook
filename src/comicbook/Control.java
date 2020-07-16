 package comicbook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

public class Control extends Thread {
	String select;
	String loginId;

	public void con(View view, InputBook input, Join join, Login login) {
		DB db = new DB(view);
		ActionListener inBook = new ActionListener() { // 입고 버튼
			public void actionPerformed(ActionEvent e) {
				if (input.bookNum.getText().equals("") || input.bookName.getText().equals("")
						|| input.bookPage.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "모두 입력해주세요");
				} else {
					input.num = input.bookNum.getText();
					input.bookNum.setText("");
					input.title = input.bookName.getText();
					input.bookName.setText("");
					input.page = input.bookPage.getText();
					input.bookPage.setText("");
					input.setVisible(false);
					noti();
				}
			}
		};
		input.inBtn.addActionListener(inBook);

		ActionListener jo = new ActionListener() { // 회원가입 버튼
			public void actionPerformed(ActionEvent e) {
				if (join.idTxt.getText().equals("") || join.pwTxt.getText().equals("")
						|| join.nameTxt.getText().equals("") || join.numTxt.getText().equals("")
						|| join.adrTxt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "모두 입력해주세요");
				} else {
					join.id = join.idTxt.getText();
					join.idTxt.setText("");
					join.pw = join.pwTxt.getText();
					join.pwTxt.setText("");
					join.name = join.nameTxt.getText();
					join.nameTxt.setText("");
					join.num = join.numTxt.getText();
					join.numTxt.setText("");
					join.adr = join.adrTxt.getText();
					join.adrTxt.setText("");
					join.setVisible(false);
					noti();
				}
			}
		};
		join.joinBtn.addActionListener(jo);

		class MyKeyListener extends KeyAdapter { // 메인 텍스트 입력 창
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (view.inTxt.getText().contentEquals("")) {

				} else if (keyCode == KeyEvent.VK_ENTER) {
					select = view.inTxt.getText();
					view.inTxt.setText("");
					noti();
				}
			}
		}
		view.inTxt.addKeyListener(new MyKeyListener());

		// 시작부분
		while (true) {
			view.inTxt.requestFocus();
			view.sysTxt.append("\n================\n");
			view.sysTxt.append("1. 관리자모드\n");
			view.sysTxt.append("2. 회원가입\n");
			view.sysTxt.append("3. 로그인\n");
			view.sysTxt.append("=================\n");
			view.sysTxt.append("4. 시스템 종료\n");
			view.sysTxt.setCaretPosition(view.sysTxt.getDocument().getLength());
			
			try {
				synchronized (this) {
					wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			switch (select) {

			case "1":// 관리자
				while (true) {
					view.sysTxt.append("\n=== 관리자 모드 ===\n");
					view.sysTxt.append("1. 회원 목록 확인\n");
					view.sysTxt.append("2. 도서 목록 확인\n");
					view.sysTxt.append("3. 대여 목록 확인\n");
					view.sysTxt.append("4. 책 입고\n");
					view.sysTxt.append("=================\n");
					view.sysTxt.append("5. 처음으로\n");
					view.sysTxt.setCaretPosition(view.sysTxt.getDocument().getLength());
					try {
						synchronized (this) {
							wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					switch (select) {
					case "1":// 회원목록
						view.dataTxt.append("======= 회원 목록 =======\n");
						db.showAllMemberList();
						view.dataTxt.setCaretPosition(view.dataTxt.getDocument().getLength());
						continue;
					case "3":// 대여목록
						view.dataTxt.append("======= 대여 목록 =======\n");
						db.showAllRentalList();
						view.dataTxt.setCaretPosition(view.dataTxt.getDocument().getLength());
						continue;
					case "2":// 책목록
						view.dataTxt.append("======= 도서목록 =======\n");
						db.showAllBook();
						view.dataTxt.setCaretPosition(view.dataTxt.getDocument().getLength());
						continue;
					case "4":// 입고
						input.setVisible(true);
						try {
							synchronized (this) {
								wait();
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						String fee = "";
						if (Integer.parseInt(input.page) > 250)
							fee = "500";
						else
							fee = "300";
						db.bookInput(input.num, input.title, input.page, fee);
						view.sysTxt.append(
								"\n입고 확인 ( no." + input.num + "  ,  " + input.title + "  ,  " + input.page + "P )\n");
						continue;
					case "5":
						break;
					default:
						view.sysTxt.append("\n다시 입력해 주세요");
						continue;
					}
					break;
				}
				break;

			case "2": // 회원가입
				join.setVisible(true);
				try {
					synchronized (this) {
						wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				db.memberInput(join.id, join.pw, join.name, join.num, join.adr);

				break;

			case "3": // 로그인
				login.setVisible(true);
				login.idTxt.requestFocus();
				ActionListener log = new ActionListener() { // 로그인 버튼
					public void actionPerformed(ActionEvent e) {
						if (login.idTxt.getText().equals("") || login.pwTxt.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "모두 입력해주세요");
						} else {
							if (db.login(login.idTxt.getText(), login.pwTxt.getText())) {
								loginId = login.idTxt.getText();
								login.idTxt.setText("");
								login.pwTxt.setText("");
								login.setVisible(false);
								noti();
								login.loginBtn.removeActionListener(this);
							} else {
								JOptionPane.showMessageDialog(null, "잘 못 입력하였습니다");
							}
						}
					}
				};
				login.loginBtn.addActionListener(log);

				try {
					synchronized (this) {
						wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				while (true) {
					view.sysTxt.append("\n\n=== 로그인 완료 ===\n");
		               view.sysTxt.append("1. 도서 목록 조회\n");
		               view.sysTxt.append("2. 대여 목록 조회\n");
		               view.sysTxt.append("3. 대여 실행\n");
		               view.sysTxt.append("4. 반납 실행\n");
		               view.sysTxt.append("=================\n");
		               view.sysTxt.append("5. 로그아웃\n");
		               view.sysTxt.setCaretPosition(view.sysTxt.getDocument().getLength());

					try {
						synchronized (this) {
							wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					switch (select) {
		               case "1":// 책목록
		                  view.dataTxt.append("======= 도서목록 =======\n");
		                  db.showEnableBook();
		                  view.dataTxt.setCaretPosition(view.dataTxt.getDocument().getLength());
		                  continue;
		               case "2":
		                  view.dataTxt.append("==== 대여 목록 ====\n");
		                  db.memberRentalList(loginId);
		                  view.dataTxt.setCaretPosition(view.dataTxt.getDocument().getLength());
		                  continue;
		               case "3":// 대여
		                  view.dataTxt.append("======= 대여 가능 도서 목록 =======\n");
		                  db.showEnableBook();
		                  view.dataTxt.setCaretPosition(view.dataTxt.getDocument().getLength());
		                  view.sysTxt.append("\n대여할 도서 번호를 입력하세요\n");
		                  view.sysTxt.setCaretPosition(view.sysTxt.getDocument().getLength());
		                  try {
		                     synchronized (this) {
		                        wait();
		                     }
		                  } catch (InterruptedException e) {
		                     e.printStackTrace();
		                  }
		                  db.rental(select);
		                  db.rentalDetail(select, loginId);
		                  db.showFee(select);
		                  continue;
		               case "4":// 반납
		                  view.dataTxt.append("==== 대여 목록 ====\n");
		                  db.memberRentalList(loginId);
		                  view.dataTxt.setCaretPosition(view.dataTxt.getDocument().getLength());
		                  view.sysTxt.append("\n반납할 도서 번호를 입력하세요\n");
		                  view.sysTxt.setCaretPosition(view.sysTxt.getDocument().getLength());
		                  try {
		                     synchronized (this) {
		                        wait();
		                     }
		                  } catch (InterruptedException e) {
		                     e.printStackTrace();
		                  }
		                  db.returnBook(select);
		                  db.returnDetail(select);
		                  continue;
		               case "5": // 처음으로
		                  break;
		               default:
		                  view.sysTxt.append("\n다시 입력해 주세요");
		                  continue;
		               }
					break;
				}
				break;
			case "4":
				System.exit(0);
			default:
				view.sysTxt.append("\n다시 입력해 주세요");
				break;
			}
		}

	}

	public void noti() {
		synchronized (this) {
			notifyAll();
		}
	}

}
