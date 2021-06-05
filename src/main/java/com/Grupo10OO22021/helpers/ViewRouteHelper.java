package com.Grupo10OO22021.helpers;

public class ViewRouteHelper {
	
	//USER
	public static final String LOGIN_ROOT = "/login/";
	public static final String LOGIN = "/login";

	//HOME
	public static final String HOME = "home";
	//REDIRECT
	public static final String HOME_ROOT = "/";

	// MENUS
	public final static String MENU_ADMIN = "/menuadmin";
	public final static String MENU_AUDITOR = "/auditor/menuauditor";
	public final static String MENU_USER = "/menuuser";

	//ADMIN
	//REDIRECT
	public static final String ADMIN_ROOT = "/admin";
  
	//PERFIL
	public static final String PERFIL_INDEX = "perfil/index";
	public static final String PERFIL_NEW = "perfil/new";
	public static final String PERFIL_UPDATE ="perfil/update";
	
	//REDIRECT
	public static final String PERFIL_ROOT = "/perfil";

	//USUARIO
    public final static String USUARIO_LISTAR = "usuarios/listar";
    public final static String USUARIO_ALTA = "usuarios/alta";
    public final static String USUARIO_PRUEBA = "alta";
    public final static String USUARIO_MODIFICAR = "usuarios/modificar";

    // REDIRECT
	public final static String USUARIO_ROOT = "/usuario";
    
	//PERSONA
	public final static String PERSONA_NEW = "persona/alta";
	 public final static String PERSONA_PRUEBA = "/persona";

	// REDIRECT
	public final static String PERSONA_ROOT = "/persona";
	
	
	//PERMISO
	public final static String PERMISO_TRAER = "permiso/traer";
	public final static String PERMISO_TRAER_POR_PERSONA = "permiso/traerPorPersona";
	public final static String PERMISO_VISTA_TRAER_POR_PERSONA ="permiso/mostrarTraerPorPersona";
	public final static String PERMISO_TRAER_POR_RODADO = "permiso/traerPorRodado";
	public final static String PERMISO_TRAER_ACTIVOS = "permiso/traerActivos";

	//REDIRECT
	public final static String PERMISO_ROOT = "/permiso";

	//PERMISODIARIO
	public final static String PERMISODIARIO_NEW = "/permisodiario/alta";
	public final static String PERMISODIARIO_MOSTRAR = "permisodiario/mostrar";
	 
	//PERMISOPERIODO
	public final static String PERMISOPERIODO_NEW = "/permisoperiodo/alta";
	public final static String PERMISOPERIODO_PRUEBA = "/permisoperiodo";
	

  	//AUDITOR
    public final static String AUDITOR_LISTAR = "auditor/listar";

	// REDIRECT
	public final static String AUDITOR_ROOT = "/auditor";
	
	//RODADO
	public final static String RODADO_NEW ="/rodado/new";
	public final static String RODADO_PRUEBA = "/rodado";
	
	//REDIRECT 
	public final static String RODADO_ROOT="/rodado";
}
