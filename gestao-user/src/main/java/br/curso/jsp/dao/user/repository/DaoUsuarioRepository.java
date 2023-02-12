package br.curso.jsp.dao.user.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;

import br.curso.jsp.conect.banco.user.DaoConectBanco;
import br.curso.jsp.inteface.repository.IDAOUserRepository;
import br.curso.jsp.model.Usuario;

public class DaoUsuarioRepository implements IDAOUserRepository {

	private Connection conect;

	public DaoUsuarioRepository() {
		this.conect = DaoConectBanco.getConnection();
	}

	@Override
	public Usuario salvar(Usuario dadosUsuario, long id_Adm) throws SQLException {
		String sqlInsert = "insert into tabela_usuario (nome , email , data_nascimento, login , senha  , id_admin) values (?,?,?,?,?,?)";

		if (dadosUsuario.novoUsuario()) { // novo registro
			PreparedStatement preparedStatement = conect.prepareStatement(sqlInsert);
			preparedStatement.setString(1, dadosUsuario.getNome());
			preparedStatement.setString(2, dadosUsuario.getEmail());
			preparedStatement.setDate(3, dadosUsuario.getDataNascimento());
			preparedStatement.setString(4, dadosUsuario.getLogin());
			preparedStatement.setString(5, dadosUsuario.getSenha());
			preparedStatement.setLong(6, id_Adm);

			preparedStatement.execute();
			conect.commit();

			if (dadosUsuario.getFoto() != null && !dadosUsuario.getFoto().isEmpty()) {
				sqlInsert = "update  tabela_usuario   set  foto=? where login = ? ";
				PreparedStatement execute = conect.prepareStatement(sqlInsert);
				execute.setString(1, dadosUsuario.getFoto());
				execute.setString(2, dadosUsuario.getLogin());
				execute.execute();
				conect.commit();
			}
		} else {// atualiza registro
			sqlInsert = " UPDATE tabela_usuario   SET  nome=?, email=?, data_nascimento=?, login=?, senha=? WHERE id =?";
			PreparedStatement preparedStatement = conect.prepareStatement(sqlInsert);
			preparedStatement.setString(1, dadosUsuario.getNome());
			preparedStatement.setString(2, dadosUsuario.getEmail());
			preparedStatement.setDate(3, dadosUsuario.getDataNascimento());

			preparedStatement.setString(4, dadosUsuario.getLogin());
			preparedStatement.setString(5, dadosUsuario.getSenha());
			preparedStatement.setLong(6, dadosUsuario.getId());

			preparedStatement.executeUpdate();
			conect.commit();

			if (dadosUsuario.getFoto() != null && !dadosUsuario.getFoto().isEmpty()) {
				sqlInsert = "update tabela_usuario set foto=? where id = ? ";
				PreparedStatement execute = conect.prepareStatement(sqlInsert);
				execute.setString(1, dadosUsuario.getFoto());
				execute.setLong(2, dadosUsuario.getId());
				execute.execute();
				conect.commit();
			}
		}

		return this.bucarUsuarioSalvo(dadosUsuario.getLogin());
	}

	@Override
	public int deletar(String id , long id_Adm) throws SQLException {
		String sqolDelete = "DELETE  FROM tabela_usuario   WHERE id_admin = ? and id = ?";
		PreparedStatement preparedStatement = conect.prepareStatement(sqolDelete);
		preparedStatement.setLong(1, id_Adm);
		preparedStatement.setLong(2, Long.parseLong(id));
	    int deletou  = 	preparedStatement.executeUpdate();
	    conect.commit();
		return deletou;
	}

	@Override
	public Usuario buscarUsuario(String login) throws SQLException {

		String sqlBusca = "select  * from tabela_usuario  where login = ?";
		PreparedStatement preparedStatement = conect.prepareStatement(sqlBusca);
		preparedStatement.setString(1, login);
		Usuario usuario = new Usuario();
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {

			usuario.setId(resultSet.getLong("id"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setEmail(resultSet.getString("email"));
			usuario.setLogin(resultSet.getString("login"));
			usuario.setSenha(resultSet.getString("senha"));
			usuario.setFoto(resultSet.getString("foto"));
			usuario.setAdministrador(resultSet.getBoolean("administrador"));
			usuario.setDataNascimento(resultSet.getDate("data_nascimento"));


		}

		return usuario;
	}

	private Usuario bucarUsuarioSalvo(String dados) throws SQLException {

		String sqlBusca = "select  * from tabela_usuario  where login =? ";
		PreparedStatement preparedStatement = conect.prepareStatement(sqlBusca);
		preparedStatement.setString(1, dados);
		ResultSet resultSet = preparedStatement.executeQuery();
		Usuario usuario = new Usuario();

		while (resultSet.next()) {

			usuario.setId(resultSet.getLong("id"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setEmail(resultSet.getString("email"));
			usuario.setLogin(resultSet.getString("login"));
			usuario.setSenha(resultSet.getString("senha"));
			usuario.setDataNascimento(resultSet.getDate("data_nascimento"));
			usuario.setFoto(resultSet.getString("foto"));

		}
		return usuario;

	}



	@Override
	public List<Usuario> pesquisarUsuariosPorNome(String nome , long id_admin) throws SQLException {
		List<Usuario> lista = new ArrayList<>();
		String sqlConsulta = "select * from tabela_usuario as notAdmin where upper(nome) like upper(?) and  id_admin=?  and   notAdmin.administrador = false ";
		PreparedStatement preparedStatement = conect.prepareStatement(sqlConsulta);
		preparedStatement.setString(1, "" + nome + "%");
		preparedStatement.setLong(2, id_admin);

        ResultSet resultado = preparedStatement.executeQuery();
        while(resultado.next()) {
        	Usuario usuario = new Usuario();
        	usuario.setId(resultado.getLong("id"));
        	usuario.setNome(resultado.getString("nome"));
        	usuario.setEmail(resultado.getString("email"));
            lista.add(usuario);

        }
		return lista;
	}




	@Override
	public boolean existeUsuario(Usuario usuario) throws SQLException {

		String sqlValidator = "select  count(1)>0  as existe from tabela_usuario  where login  = ?  or  senha=? or email = ?";

		PreparedStatement preparedStatement = conect.prepareStatement(sqlValidator);
		preparedStatement.setString(1, usuario.getLogin());
		preparedStatement.setString(2, usuario.getSenha());
		preparedStatement.setString(3, usuario.getEmail());

		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return resultSet.getBoolean("existe");
		}

		return false;
	}

	public long getIDAdmin(String nomeUsuario) throws SQLException {
		String sqlBusca = "select  * from tabela_usuario  where nome =?";
		PreparedStatement preparedStatement = conect.prepareStatement(sqlBusca);
		preparedStatement.setString(1, nomeUsuario);
		ResultSet resultSet = preparedStatement.executeQuery();
		long idAdmin = 0;
		while (resultSet.next()) {
			idAdmin = resultSet.getLong("id");
		}

		return idAdmin;
	}

	

	@Override
	public List<Usuario> pesquisarUsuariosPorData(String data) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public Usuario pesquisarUsuariosPorEmail(String email) throws SQLException {
		
		return null;
		
	}
	
	
	@Override
	public List<Usuario> getTodoUsuario() throws SQLException {
		// TpainODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarUsuario(long id) throws SQLException {

		String sqlBusca = "select  * from tabela_usuario  where id =? ";
		PreparedStatement preparedStatement = conect.prepareStatement(sqlBusca);
		preparedStatement.setLong(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		Usuario usuario = new Usuario();

		while (resultSet.next()) {

			usuario.setId(resultSet.getLong("id"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setEmail(resultSet.getString("email"));
			usuario.setLogin(resultSet.getString("login"));
			usuario.setSenha(resultSet.getString("senha"));
			usuario.setDataNascimento(resultSet.getDate("data_nascimento"));
			usuario.setFoto(resultSet.getString("foto"));

		}
		return usuario;
	}
}
