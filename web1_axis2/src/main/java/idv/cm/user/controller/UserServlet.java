package idv.cm.user.controller;

import java.io.IOException;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import idv.cm.db.listener.DbFinder;
import idv.cm.user.model.UserDAO;
import idv.cm.user.model.UserVO;
import idv.cm.utli.ReadXmlDomParser;
import sun.rmi.server.Dispatcher;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Logger LOGGER = LogManager.getLogger(this.getClass());
	

	public UserServlet() {
//		ReadXmlDomParser dbReader = new ReadXmlDomParser();
		
	
//		dbStr = dbReader.getDBPath(webPath);
	}

	@Override
	public void destroy() {
		LOGGER.traceExit();
	}

	@Override
	public void init() throws ServletException {
		LOGGER.traceEntry();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		LOGGER.info("user Servlet is called");
		
		List<String> dbStrs = (List<String>) req.getServletContext().getAttribute("dbStr");
		System.out.println("-------------user servlet call --------------");
		dbStrs.forEach(p->System.out.println(p));
		LOGGER.info("dbStr - "+dbStrs);
		UserDAO user = new UserDAO(dbStrs.get(1));
		LOGGER.info("user DAO is called");
		List<UserVO> userList = user.getAllUser();
		Iterator<UserVO> it = userList.iterator();
		while(it.hasNext()) {
			out.println("UserName");
			out.println(it.next().getName());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
