package ua.petstore.services;

public class ViewURL {
	private static final String URL_ROOT = "WEB-INF/";
	private static final String URL_FOLDER = URL_ROOT + "views/";
	private static final String URL_COMPONENTS = URL_FOLDER + "components/";
	private static final String URL_PAGE = URL_FOLDER + "page/";
	private static final String EXTENSION = ".jsp";

	public static final String URL_HOME = URL_PAGE + "home" + EXTENSION;
	public static final String URL_SHOP = URL_PAGE + "shop" + EXTENSION;
	public static final String URL_SERVICES = URL_PAGE + "services" + EXTENSION;
	public static final String URL_HOTEL = URL_PAGE + "hotel" + EXTENSION;
	public static final String URL_CONTACTS = URL_PAGE + "contacts" + EXTENSION;
	public static final String URL_ACCOUNT = URL_PAGE + "account" + EXTENSION;
	public static final String URL_CART = URL_PAGE + "cart" + EXTENSION;
	
	public static final String CART = "cart";
}
