package agenda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Agenda {
	//define objetos que serão utilizados
	public JFrame jfAgenda;
	public JButton btoInserir, btoExcluir, btoAlterar, btoConsultar;
	public JLabel lblNome, lblCelular;
	public JTextField tfNome, tfCelular;
	public JPanel pnBotao, pnDados;
	
	public void desenhaJanela() {
		//instanciando objetos
		btoInserir = new JButton("Inserir");
		btoConsultar = new JButton("Consultar");
		btoAlterar = new JButton("Alterar");
		btoExcluir = new JButton("Excluir");
		lblNome = new JLabel("Nome ");
		lblCelular = new JLabel("Celular ");
		tfNome = new JTextField(40);
		tfCelular = new JTextField(15);
		jfAgenda = new JFrame("Agenda");
		jfAgenda.setLayout(new BorderLayout());
		pnBotao = new JPanel();
		pnBotao.setLayout(new FlowLayout());;
		pnDados = new JPanel();
		pnDados.setLayout(new GridLayout(2,2));
		//adiciona os componentes nos paineis
		pnDados.add(lblNome);
		pnDados.add(tfNome);
		pnDados.add(lblCelular);
		pnDados.add(tfCelular);
		pnBotao.add(btoInserir);
		pnBotao.add(btoConsultar);
		pnBotao.add(btoAlterar);
		pnBotao.add(btoExcluir);
		//adiciona os paineis à janela
		jfAgenda.add(pnDados, BorderLayout.CENTER);
		jfAgenda.add(pnBotao, BorderLayout.SOUTH);
		//dimensiona a janela
		jfAgenda.setSize(400, 130);
		jfAgenda.setLocation(300,200);
		jfAgenda.setVisible(true);
		//instancia a classe interna para eventos de botão
		DisparaEventos de = new DisparaEventos();
		//adiciona o ouvidor de eventos aos botões
		btoInserir.addActionListener(de);
		btoConsultar.addActionListener(de);
		btoAlterar.addActionListener(de);
		btoExcluir.addActionListener(de);
	}
	
	
	//instancia a classe interna que implementa ActionListener para disparar evento
	public class DisparaEventos implements ActionListener {
		String msg;

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btoInserir){
				String nome = tfNome.getText();
				String celular = tfCelular.getText();
				BancoDados bd = new BancoDados();
				msg = bd.conectaBanco("jdbc:mysql://localhost:3306/agenda","root", "");
				System.out.println("Conexão banco: "+msg);
				System.out.println("Nome a ser inserido: "+nome);
				System.out.println("Celular a ser inserido: "+celular);
				msg = bd.insere("insert into tbusuario "+"values ('"+nome+"','"+celular+"')");
				System.out.println("Inserção de dados: "+msg);
				
			}
			
			/*********************************************************/
			if(e.getSource() == btoConsultar){
				BancoDados bd = new BancoDados();
				msg = bd.conectaBanco("jdbc:mysql://localhost:3306/agenda","root", "");
				System.out.println("Conexão banco: "+msg);
				bd.consulta("select nome, celular from tbusuario");
			}
			
			/*********************************************************/
			if(e.getSource() == btoAlterar){
				String novoNome = JOptionPane.showInputDialog("Digite o novo nome");
				String novoNumero = JOptionPane.showInputDialog("Digite o novo número do celular");
				String nome = tfNome.getText();
				String celular = tfCelular.getText();
				BancoDados bd = new BancoDados();
				msg = bd.conectaBanco("jdbc:mysql://localhost:3306/agenda","root", "");
				msg = bd.altera("UPDATE agenda.tbusuario SET nome = '"+novoNome+"', celular = '"+novoNumero+"' WHERE tbusuario.nome = '"+nome+"' AND tbusuario.celular = '"+celular+"' LIMIT 1 ;");
				System.out.println("Alteração de dados: "+msg);
			}
			
			/*********************************************************/
			if(e.getSource() == btoExcluir){
				String nome = tfNome.getText();
				BancoDados bd = new BancoDados();
				msg = bd.conectaBanco("jdbc:mysql://localhost:3306/agenda","root", "");
				System.out.println("Conexão banco: "+msg);
				bd.exclui("delete from tbusuario where nome='"+nome+"';");
			}

		}
	}
}
