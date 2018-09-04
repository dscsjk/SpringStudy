package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Dxm01;

public class LoginService {

	private MemberDao memberDao = new MemberDao();

	public User login(String id, String password) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			Dxm01 dxm01 = memberDao.getCheckUser(conn, id, password);
			if (dxm01 == null) {
				throw new LoginFailException();
			}
			return new User(dxm01.getU_id(), dxm01.getU_name());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
