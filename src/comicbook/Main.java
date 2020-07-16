package comicbook;

public class Main {
	public static void main(String[] args) {
		Control cont = new Control();
		View frame = new View();
		Join join = new Join();
		Login login = new Login();
		InputBook frame2 = new InputBook();
		frame.setVisible(true);
		cont.con(frame, frame2,join,login);
	}
}

