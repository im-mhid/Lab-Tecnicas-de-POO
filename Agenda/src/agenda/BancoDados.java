package agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class BancoDados {
	public Connection conexao = null;
	public Statement stm = null;
	public ResultSet rs = null;
	public String conectaBanco(String servidor, String usuario, String senha) {
		String msg = "";
		try {
			//faz a conexão jdbc com a base de dados
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexao=DriverManager.getConnection(servidor, usuario, senha);
			//stm objeto que recebe a conexão
			stm = conexao.createStatement();
			//Caso não ocorra nenhum erro na conexão uma mensagem de erro será mostrada.
			msg = "Conexao com o banco de dados realizada com sucesso";
		}catch(Exception e){
			msg = "Erro de conexão com o banco de dados "+e.getMessage();
		}
		return msg;
	}
/*************************************************************/
	public String insere(String sql){
		String msg;
		try {
			stm.executeUpdate(sql);
			msg = "Comando executado com sucesso!";
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
			msg = "Erro na conexão com o banco de dados";
		}
		return msg;
	}
/*************************************************************/
	public void consulta(String sql){
		ResultSet rs = null;
		String msg;
		try {
			rs = stm.executeQuery(sql);
			// Imprime os dados
			while (rs.next()){
			String nome = rs.getString(1);
			String celular = rs.getString(2);
			System.out.print(nome + " - ");
			System.out.println(celular);
			}
			// catch usado para avisar se der algum erro na consulta SQL com um Exception
		}catch (Exception e){
			msg = "Erro na consulta " + e.getMessage();
		}
	}
/*************************************************************/
	public String altera(String sql){
		String msg;
		try{
		stm.executeUpdate(sql);
		msg = "Alteração com sucesso!";
		}
		catch(Exception e){
		msg = "Falha na alteração de dados";
		e.printStackTrace();
		}
		return msg;
	}
/*************************************************************/
	public String exclui(String sql){
		String msg;
		try{
		stm.executeUpdate(sql);
		msg="Exclusão efetuada com sucesso!";
		}catch(Exception e){
		e.printStackTrace();
		msg="Erro na exclusão";
		}
		return msg;
	}
}
