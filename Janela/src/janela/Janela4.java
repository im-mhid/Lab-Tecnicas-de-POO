package janela;

import java.awt.*;
import javax.swing.*;

public class Janela4 {
	Janela4() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		JFrame janela = new JFrame("Cadastro");
		janela.setSize(d);
		janela.setVisible(true);
	}
}
