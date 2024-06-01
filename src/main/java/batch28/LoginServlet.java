package batch28;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter pw=res.getWriter();
		UserBean ub = new LoginDAO().login(req);
		if(ub!=null)
		{
			pw.println("Login SuccessFull.....");
			pw.println("Welcome UserName:"+ub.getuName());
			pw.println("Welcome UserPassword:"+ub.getpWord());
			pw.println("Welcome UserMail:"+ub.getMailId());
			pw.println("Welcome UserPhno:"+ub.getPhNo());
		}
		else {
			pw.println("Invalid UserName and Password");
		}
	}
}
