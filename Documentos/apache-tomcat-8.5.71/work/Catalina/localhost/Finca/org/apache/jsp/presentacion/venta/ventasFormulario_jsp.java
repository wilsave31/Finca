/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.71
 * Generated at: 2021-10-27 07:39:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.presentacion.venta;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Clases.Producto;
import ClasesGenericas.Fechas;
import Clases.TipoPersona;
import Clases.Persona;
import Clases.Venta;

public final class ventasFormulario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("Clases.Persona");
    _jspx_imports_classes.add("Clases.TipoPersona");
    _jspx_imports_classes.add("ClasesGenericas.Fechas");
    _jspx_imports_classes.add("Clases.Producto");
    _jspx_imports_classes.add("Clases.Venta");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

    //validar
    HttpSession sesion= request.getSession();
    Persona USUARIO=null;
    if(sesion.getAttribute("usuario")==null)response.sendRedirect("../index.jsp?Error=2");//acceso no valido
    else USUARIO=(Persona) sesion.getAttribute("usuario");
    
    //String lista="";
    //String filtro="identificacionAdministrador='"+USUARIO.getIdentificacion()+"'";
    //Tipoventa tipoventa=Tipoventa.getListaEnObjetos(filtro).get(0);
    String titulo="Adicionar";
    Venta venta=null;
    if(request.getParameter("id")!=null){
        titulo="Modificar";
        venta=new Venta(request.getParameter("id"));
    }else venta=new Venta();
        
 
      out.write("\n");
      out.write(" \n");
      out.write(" <h3>");
      out.print(titulo.toUpperCase());
      out.write(" VENTAS</h3>\n");
      out.write(" <form id=\"for\" class=\"form-agregar\" name=\"formulario\" method=\"post\" action=\"principal.jsp?CONTENIDO=venta/ventasActualizar.jsp\">\n");
      out.write("     <table border=\"1\">\n");
      out.write("         <tr><th>Id Usuario(*)</th><td><select name=\"idPersona\">");
      out.print(Persona.getListaEnOptions(""));
      out.write("</select></td></tr>\n");
      out.write("         <tr><th>Fecha(*)</th><td><input class=\"formu\" type=\"text\" name=\"fecha\" value=\"");
      out.print(Fechas.obtenerFechaActual());
      out.write("\"></td></tr>\n");
      out.write("         <tr><th>Nombre(*)</th><td><select name=\"idNombre\">");
      out.print(Producto.getListaEnOptions(""));
      out.write("</select></td></tr>\n");
      out.write("         <tr><th>Marca(*)</th><td ><input class=\"formu\" type=\"text\" name=\"marca\" value=\"");
      out.print(venta.getMarca());
      out.write("\"></td></tr>\n");
      out.write("         <tr><th>Valor(*)</th><td><input class=\"formu\" type=\"text\" name=\"valor\" value=\"");
      out.print(venta.getValor());
      out.write("\" size=\"50\" maxlength=\"80\" required></td></tr>\n");
      out.write("         <tr><th>Cantidad(*)</th><td><input class=\"formu\" type=\"text\" name=\"cantidad\" value=\"");
      out.print(venta.getCantidad());
      out.write("\" size=\"50\" maxlength=\"80\" required></td></tr>\n");
      out.write("     </table><p>\n");
      out.write("         \n");
      out.write("         <input type=\"hidden\" name=\"id\" value=\"");
      out.print(venta.getId());
      out.write("\">\n");
      out.write("         <input type=\"submit\" name=\"accion\" value=\"");
      out.print(titulo);
      out.write("\">\n");
      out.write("     \n");
      out.write(" </form>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
