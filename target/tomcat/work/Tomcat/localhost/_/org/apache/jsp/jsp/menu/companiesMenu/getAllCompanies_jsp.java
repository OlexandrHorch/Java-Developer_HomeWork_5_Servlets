/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-03-29 00:06:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.menu.companiesMenu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.StringJoiner;
import fromHibernate.entity.Company;
import fromHibernate.dao.CompanyDAO;

public final class getAllCompanies_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Інформація про всі компанії</title>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <table>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>\r\n");
      out.write("                    <form action=\"/menu/companiesMenu/companiesMenu\">\r\n");
      out.write("                        <button type=\"submit\" style=\"width:155px;height:30px\">Меню компаній</button>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </th>\r\n");
      out.write("                <th>\r\n");
      out.write("                   <form action=\"/\">\r\n");
      out.write("                        <button type=\"submit\" style=\"width:155px;height:30px\">Головне меню</button>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </th>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("\r\n");
      out.write("        <h1>Інформація про всі компанії</h1>\r\n");
      out.write("        <form action=\"/menu/companiesMenu/getAllCompanies\" method=\"GET\">\r\n");
      out.write("            <table border=\"1\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>Id</th>\r\n");
      out.write("                    <th>Name</th>\r\n");
      out.write("                    <th>Address</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("                ");

                    StringJoiner result = new StringJoiner("");
                    CompanyDAO companyDAO = new CompanyDAO();
                    List<Company> companies = companyDAO.getAllCompanies();
                    for(Company company: companies) {
                        result.add("<tr><th>");
                        result.add(String.valueOf(company.getId()));
                        result.add("</th><th>");
                        result.add(company.getName());
                        result.add("</th><th>");
                        result.add(company.getAddress());
                        result.add("</th></tr>");
                    }
                    out.println(result);
                
      out.write("\r\n");
      out.write("            </table>\r\n");
      out.write("        </form>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
