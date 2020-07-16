﻿package comicbook;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class View extends JFrame {

   JPanel contentPane;
   JTextField inTxt;
   JTextArea dataTxt;
   JTextArea sysTxt;

   public View() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 773, 741);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      inTxt = new JTextField();
      inTxt.setBounds(12, 672, 732, 21);
      contentPane.add(inTxt);
      inTxt.setColumns(10);

      JScrollPane scrollPane_1 = new JScrollPane();
      scrollPane_1.setBounds(12, 10, 732, 379);
      contentPane.add(scrollPane_1);

      dataTxt = new JTextArea();
      scrollPane_1.setViewportView(dataTxt);
      dataTxt.setEditable(false);

      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(12, 399, 732, 263);
      contentPane.add(scrollPane);

      sysTxt = new JTextArea();
      scrollPane.setViewportView(sysTxt);
      sysTxt.setEditable(false);
      
      

   }


   public String GetNum() {
      String txt = inTxt.getText();
      if(txt.contentEquals("exit")) {
         this.setVisible(false);
      }
      inTxt.setText("");
      return txt;
      
   }
}

class InputBook extends JFrame {

   private JPanel contentPane;
   private JTextField textField;
   private JTextField textField_1;
   private JTextField textField_2;
   JTextField bookNum;
   JTextField bookName;
   JTextField bookPage;
   JButton inBtn;
   
   String num;
   String title;
   String page;
   String fee;

   public InputBook() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 213, 171);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      textField = new JTextField();
      textField.setEditable(false);
      textField.setText("책번호");
      textField.setEnabled(false);
      textField.setBounds(12, 10, 45, 21);
      contentPane.add(textField);
      textField.setColumns(10);
      
      textField_1 = new JTextField();
      textField_1.setEditable(false);
      textField_1.setText("책제목");
      textField_1.setEnabled(false);
      textField_1.setBounds(12, 41, 45, 21);
      contentPane.add(textField_1);
      textField_1.setColumns(10);
      
      textField_2 = new JTextField();
      textField_2.setEditable(false);
      textField_2.setText("페이지");
      textField_2.setEnabled(false);
      textField_2.setBounds(12, 72, 45, 21);
      contentPane.add(textField_2);
      textField_2.setColumns(10);
      
      bookNum = new JTextField();
      bookNum.setBounds(69, 10, 116, 21);
      contentPane.add(bookNum);
      bookNum.setColumns(10);
      
      bookName = new JTextField();
      bookName.setBounds(69, 41, 116, 21);
      contentPane.add(bookName);
      bookName.setColumns(10);
      
      bookPage = new JTextField();
      bookPage.setBounds(69, 72, 116, 21);
      contentPane.add(bookPage);
      bookPage.setColumns(10);
      
      inBtn = new JButton("입고");
      inBtn.setBounds(12, 103, 173, 23);
      contentPane.add(inBtn);
      
      
   }
   
   public void Close() {
      this.setVisible(false);
   }
   public void Open() {
      this.setVisible(true);
   }
}


class Join extends JFrame {

    JPanel contentPane;
    JTextField txtId;
    JTextField txtPw;
    JTextField textField_2;
    JTextField txtPh;
    JTextField textField_4;
    JTextField idTxt;
    JTextField pwTxt;
    JTextField nameTxt;
    JTextField numTxt;
    JTextField adrTxt;
    JButton joinBtn;
    
    String id;
    String pw;
    String name;
    String num;
    String adr;

   public Join() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 345, 236);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      txtId = new JTextField();
      txtId.setEditable(false);
      txtId.setHorizontalAlignment(SwingConstants.RIGHT);
      txtId.setText("ID");
      txtId.setEnabled(false);
      txtId.setBounds(12, 10, 58, 21);
      contentPane.add(txtId);
      txtId.setColumns(10);
      
      txtPw = new JTextField();
      txtPw.setEditable(false);
      txtPw.setHorizontalAlignment(SwingConstants.RIGHT);
      txtPw.setText("PW");
      txtPw.setEnabled(false);
      txtPw.setColumns(10);
      txtPw.setBounds(12, 41, 58, 21);
      contentPane.add(txtPw);
      
      textField_2 = new JTextField();
      textField_2.setEditable(false);
      textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
      textField_2.setText("이름");
      textField_2.setEnabled(false);
      textField_2.setColumns(10);
      textField_2.setBounds(12, 72, 58, 21);
      contentPane.add(textField_2);
      
      txtPh = new JTextField();
      txtPh.setEditable(false);
      txtPh.setHorizontalAlignment(SwingConstants.RIGHT);
      txtPh.setText("전화번호");
      txtPh.setEnabled(false);
      txtPh.setColumns(10);
      txtPh.setBounds(12, 103, 58, 21);
      contentPane.add(txtPh);
      
      textField_4 = new JTextField();
      textField_4.setEditable(false);
      textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
      textField_4.setText("주소");
      textField_4.setEnabled(false);
      textField_4.setColumns(10);
      textField_4.setBounds(12, 134, 58, 21);
      contentPane.add(textField_4);
      
      idTxt = new JTextField();
      idTxt.setBounds(82, 10, 234, 21);
      contentPane.add(idTxt);
      idTxt.setColumns(10);
      
      pwTxt = new JTextField();
      pwTxt.setBounds(82, 41, 234, 21);
      contentPane.add(pwTxt);
      pwTxt.setColumns(10);
      
      nameTxt = new JTextField();
      nameTxt.setBounds(82, 72, 234, 21);
      contentPane.add(nameTxt);
      nameTxt.setColumns(10);
      
      numTxt = new JTextField();
      numTxt.setBounds(82, 103, 234, 21);
      contentPane.add(numTxt);
      numTxt.setColumns(10);
      
      adrTxt = new JTextField();
      adrTxt.setBounds(82, 134, 234, 21);
      contentPane.add(adrTxt);
      adrTxt.setColumns(10);
      
      joinBtn = new JButton("회원 가입");
      joinBtn.setBounds(12, 165, 304, 23);
      contentPane.add(joinBtn);
   }

}

class Login extends JFrame {

    JPanel contentPane;
    JTextField txtId;
    JTextField txtPw;
    JTextField idTxt;
    JTextField pwTxt;
    JButton loginBtn;

   public Login() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 207, 140);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      txtId = new JTextField();
      txtId.setEditable(false);
      txtId.setHorizontalAlignment(SwingConstants.CENTER);
      txtId.setText("ID");
      txtId.setEnabled(false);
      txtId.setBounds(12, 10, 38, 21);
      contentPane.add(txtId);
      txtId.setColumns(10);
      
      txtPw = new JTextField();
      txtPw.setEditable(false);
      txtPw.setHorizontalAlignment(SwingConstants.CENTER);
      txtPw.setText("PW");
      txtPw.setEnabled(false);
      txtPw.setBounds(12, 41, 38, 21);
      contentPane.add(txtPw);
      txtPw.setColumns(10);
      
      idTxt = new JTextField();
      idTxt.setBounds(62, 10, 116, 21);
      contentPane.add(idTxt);
      idTxt.setColumns(10);
      
      pwTxt = new JTextField();
      pwTxt.setBounds(62, 41, 116, 21);
      contentPane.add(pwTxt);
      pwTxt.setColumns(10);
      
      loginBtn = new JButton("Login");
      loginBtn.setBounds(12, 72, 166, 23);
      contentPane.add(loginBtn);
   }

}