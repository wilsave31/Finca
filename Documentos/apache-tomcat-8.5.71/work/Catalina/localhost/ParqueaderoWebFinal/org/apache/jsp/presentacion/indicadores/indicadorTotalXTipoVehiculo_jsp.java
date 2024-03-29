/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.71
 * Generated at: 2021-10-25 19:09:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.presentacion.indicadores;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import clases.Parqueo;
import clases.Parqueadero;
import clases.Persona;
import java.sql.ResultSet;

public final class indicadorTotalXTipoVehiculo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("clases.Parqueo");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("clases.Persona");
    _jspx_imports_classes.add("clases.Parqueadero");
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
      response.setContentType("text/html");
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

    HttpSession sesion=request.getSession();
    Persona USUARIO=null;
    if(sesion.getAttribute("usuario")==null) response.sendRedirect("../index.jsp?error=2");// 2=acceso no valido
    else USUARIO=(Persona) sesion.getAttribute("usuario");
    
    String filtro="identificacionAdministrador='"+USUARIO.getIdentificacion()+"'";
    Parqueadero parqueadero=Parqueadero.getListaEnObjetos(filtro).get(0);
    
    int total=0;
    String lista="";
    
    filtro="idParqueadero="+parqueadero.getId();
    if(request.getParameter("fechaInicio")!=null && request.getParameter("fechaFin")!=null && !request.getParameter("fechaInicio").equals("") 
        && !request.getParameter("fechaFin").equals("")){
        filtro+=" and fechaHoraFinalizacion between '" + request.getParameter("fechaInicio") + "' and '" + request.getParameter("fechaFin") + "' ";

    }
    
    ResultSet resultado = Parqueo.getTotalXTipoVehiculo(filtro);
  
    String datosGrafico="";
    int i=0;
    while(resultado.next()){
        lista+="<tr>";
        lista+="<td>" + resultado.getString("nombre") + "</td>";
        lista+="<td align='right'>" + resultado.getString("total") + "</td>";
        total+=resultado.getInt("total");
        lista+="</tr>";
        
        // Para preparar lo datos del grafico.
        if(i>0) datosGrafico+=", ";
        datosGrafico+="{";
        datosGrafico+="'tipoVehiculo': '" + resultado.getString("nombre") + "', ";
        datosGrafico+="'total': " + resultado.getString("total");
        datosGrafico+="}";
        i++;
    }
    

      out.write("\n");
      out.write("<h3>INGRESOS POR RANGO DE FECHA</h3>\n");
      out.write("<form name=\"formulario\" method=\"post\">\n");
      out.write("    Filtrar informacion desde <input type=\"datetime\" name=\"fechaInicio\" />\n");
      out.write("    hasta <input type=\"datetime\" name=\"fechaFin\" />\n");
      out.write("    <input type=\"submit\" value=\"Filtrar\" >\n");
      out.write("</form>\n");
      out.write("<p>\n");
      out.write("    \n");
      out.write("<table border=\"1\">\n");
      out.write("    <tr><th>Tipo de vehiculo</th><th>Valor</th></tr>\n");
      out.write("    ");
      out.print( lista );
      out.write("\n");
      out.write("    <tr><th>TOTAL</th><th align='right'>");
      out.print( total );
      out.write("</th></tr>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("    <div id=\"chartdiv\"></div>\n");
      out.write("    <script src=\"../librerias/amcharts4/core.js\"></script>\n");
      out.write("    <script src=\"../librerias/amcharts4/charts.js\"></script>\n");
      out.write("    <script src=\"../librerias/amcharts4/themes/animated.js\"></script>\n");
      out.write("    <!-- <script src=\"indicadores/simple-column-chart/index.js\"></script> -->\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        am4core.useTheme(am4themes_animated);\n");
      out.write("\n");
      out.write("var chart = am4core.createFromConfig({\n");
      out.write("  // Reduce saturation of colors to make them appear as toned down\n");
      out.write("  \"colors\": {\n");
      out.write("    \"saturation\": 0.3\n");
      out.write("  },\n");
      out.write("\n");
      out.write("  // Setting data\n");
      out.write("  \"data\": [\n");
      out.write("    ");
      out.print( datosGrafico );
      out.write("\n");
      out.write("    ],\n");
      out.write("\n");
      out.write("  // Add Y axis\n");
      out.write("  \"yAxes\": [{\n");
      out.write("    \"type\": \"ValueAxis\",\n");
      out.write("    \"renderer\": {\n");
      out.write("      \"maxLabelPosition\": 0.98\n");
      out.write("    }\n");
      out.write("  }],\n");
      out.write("\n");
      out.write("  // Add X axis\n");
      out.write("  \"xAxes\": [{\n");
      out.write("    \"type\": \"CategoryAxis\",\n");
      out.write("    \"renderer\": {\n");
      out.write("      \"minGridDistance\": 20,\n");
      out.write("      \"grid\": {\n");
      out.write("        \"location\": 0\n");
      out.write("      }\n");
      out.write("    },\n");
      out.write("    \"dataFields\": {\n");
      out.write("      \"category\": \"tipoVehiculo\"\n");
      out.write("    }\n");
      out.write("  }],\n");
      out.write("\n");
      out.write("  // Add series\n");
      out.write("  \"series\": [{\n");
      out.write("    // Set type\n");
      out.write("    \"type\": \"ColumnSeries\",\n");
      out.write("\n");
      out.write("    // Define data fields\n");
      out.write("    \"dataFields\": {\n");
      out.write("      \"categoryX\": \"tipoVehiculo\",\n");
      out.write("      \"valueY\": \"total\"\n");
      out.write("    },\n");
      out.write("\n");
      out.write("    // Modify default state\n");
      out.write("    \"defaultState\": {\n");
      out.write("      \"transitionDuration\": 1000\n");
      out.write("    },\n");
      out.write("\n");
      out.write("    // Set animation options\n");
      out.write("    \"sequencedInterpolation\": true,\n");
      out.write("    \"sequencedInterpolationDelay\": 100,\n");
      out.write("\n");
      out.write("    // Modify color appearance\n");
      out.write("    \"columns\": {\n");
      out.write("      // Disable outline\n");
      out.write("      \"strokeOpacity\": 0,\n");
      out.write("\n");
      out.write("      // Add adapter to apply different colors for each column\n");
      out.write("      \"adapter\": {\n");
      out.write("        \"fill\": function (fill, target) {\n");
      out.write("          return chart.colors.getIndex(target.dataItem.index);\n");
      out.write("        }\n");
      out.write("      }\n");
      out.write("    }\n");
      out.write("  }],\n");
      out.write("\n");
      out.write("  // Enable chart cursor\n");
      out.write("  \"cursor\": {\n");
      out.write("    \"type\": \"XYCursor\",\n");
      out.write("    \"behavior\": \"zoomX\"\n");
      out.write("  }\n");
      out.write("}, \"chartdiv\", \"XYChart\");\n");
      out.write("\n");
      out.write("    </script>");
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
