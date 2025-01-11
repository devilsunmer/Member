package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;


@WebFilter("/LoginFilter")
public class LoginFilter extends HttpFilter implements Filter {
       
   
    public LoginFilter() {
        super();
        
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		/*
		 * request , response-->轉型
		 * 1.檢查看 member資料夾的網頁內容的條件
		 * 2.查 session的物件-->Member
		 * 3.有->!=null-->進入LoginSucces.jsp
		 * 4.沒有->errMessage.jsp
		 */
		
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		HttpSession session=req.getSession();
		
		Member member=(Member) session.getAttribute("Member");//後面部分是物件，所以要轉型
		
		if(member!=null)
		{
			//res.sendRedirect("/Gjun/member/loginSuccess.jsp");//這邊如果也設置的話會跟controller那邊起衝突
			chain.doFilter(request, response);//這裡只要記得在出現erro的話眠時才有作動即可
		}
		else
		{
			res.sendRedirect("/Gjun/errMessage.jsp");
		}
		
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
