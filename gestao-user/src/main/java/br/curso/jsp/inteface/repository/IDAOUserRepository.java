package br.curso.jsp.inteface.repository;

import java.sql.SQLException;
import java.util.List;

import br.curso.jsp.model.Usuario;

public interface IDAOUserRepository {
    
	
	 Usuario salvar(Usuario dadosUsuario , long id_Admin) throws SQLException;
	 Usuario buscarUsuario(String login ) throws SQLException;
	 Usuario buscarUsuario(long id ) throws SQLException;


	 List<Usuario> getTodoUsuario() throws SQLException;
	 List<Usuario> pesquisarUsuariosPorData(String  data) throws SQLException;
	 List<Usuario> pesquisarUsuariosPorNome(String nome  ,long id_admin)throws SQLException;
	 Usuario pesquisarUsuariosPorEmail(String email)throws SQLException;

	 boolean existeUsuario(Usuario usuario) throws SQLException;

	int deletar(String id, long id_Adm) throws SQLException;

	 

	 
	 
}
