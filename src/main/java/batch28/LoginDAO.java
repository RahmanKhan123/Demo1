package batch28;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class LoginDAO {

	public UserBean login(HttpServletRequest req)
	{
		UserBean ub=null;
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("select * from user_info where username=? and pword=?");
            ps.setString(1, req.getParameter("uname"));
            ps.setString(2, req.getParameter("pword"));
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
            	ub=new UserBean();
            	ub.setuName(rs.getString(1));
            	ub.setpWord(rs.getString(2));
            	ub.setMailId(rs.getString(3));
            	ub.setPhNo(rs.getLong(4));
            }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ub;
			}
}
