package mehmetozbay.utilities;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Helper {
	Cursor cr;

	public Helper() {
	}

	public boolean validateEmail(String input) {
		String emailRegex = "^[A-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[A-Z0-9.-]+$";
		Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailPattern.matcher(input);
		return matcher.find();
	}

	public ImageIcon iconDimension(int w, int h, String path) {
		ImageIcon Icon = new ImageIcon(getClass().getResource(path));
		Image img = Icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
		Icon = new ImageIcon(img);
		return Icon;
	}

	public static void centreWindow(java.awt.Frame frame) {

		java.awt.Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dim.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dim.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);

	}

	// //----------Panel -Label Hover----------------->>>
	public void panelBackgraundChange(JPanel panel, JLabel label) {
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// label.setOpaque(true);
				panel.setBackground(new Color(58, 81, 107));
				cr = new Cursor(Cursor.HAND_CURSOR);
				label.setCursor(cr);
				label.repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// label.setOpaque(true);
				panel.setBackground(new Color(27, 37, 64));

				label.setCursor(Cursor.getDefaultCursor());
				label.repaint();
			}

		});
	}

	public static void optionPaneChangeText() {
		UIManager.put("OptionPane.cancelButtonText", "iptal");
		UIManager.put("OptionPane.noButtonText", "Hayir");
		UIManager.put("OptionPane.yesButtonText", "Evet");
		UIManager.put("OptionPane.okButtonText", "Tamam");

	}

	public static void showMsg(String str) {
		String msg;
		optionPaneChangeText();
		switch (str) {
		case "fill":
			msg = "Lutfen alanlari doldurunuz";
			JOptionPane.showMessageDialog(null, msg, "Mesaj", JOptionPane.ERROR_MESSAGE);
			break;
		case "error":
			msg = "Islem sirasinda bir hata olustu";
			JOptionPane.showMessageDialog(null, msg, "Mesaj", JOptionPane.ERROR_MESSAGE);
			break;
		case "success":
			msg = "Islem basari ile gerceklesti";
			JOptionPane.showMessageDialog(null, msg, "Mesaj", JOptionPane.INFORMATION_MESSAGE);
			break;
		default:
			msg = str;
			JOptionPane.showMessageDialog(null, msg, "Mesaj", JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}

	public static boolean confirm(String str) {
		optionPaneChangeText();
		String msg;
		switch (str) {
		case "sure":
			msg = "Bu islemi gerceklestirmek istiyor musunuz?";
			break;

		default:
			msg = str;
			break;
		}
		int res = JOptionPane.showConfirmDialog(null, msg, "Dikkat!", JOptionPane.YES_NO_OPTION);
		if (res == 0) {
			return true;
		} else {
			return false;
		}
	}

}
