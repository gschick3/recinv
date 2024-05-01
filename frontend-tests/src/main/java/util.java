import java.io.File;

public class util
{

	public static String getLastSubDirectory(String pagePath){
		int slashPosition = pagePath.indexOf("/"); //find the first slash
		while(slashPosition != -1){ //until there are no more slashes
			pagePath = pagePath.substring(slashPosition+1); //cut off everything before the slash
			slashPosition = pagePath.indexOf("/"); //find the first slash
		}
		return pagePath;
	}
	public static String webPagePath(String pagePath){
		return preparePathForDriver(appendPath(pagePath));
	}

	public String frontEndPath(){
		return preparePathForDriver(buildPathToFrontEnd());
	}
	private static String buildPathToFrontEnd(){
		File file = new File(".");
		String directory = file.getAbsolutePath(); //get entire path of where this project is

		return directory.substring(0, directory.length() - 8) //trim path to be .../frontend
						.concat("/"); //then add a slash to the end
	}

	private static String appendPath(String pagePath){
		return buildPathToFrontEnd().concat(pagePath);
	}

	private static String preparePathForDriver(String pagePath){
		return "file:///".concat(pagePath);
	}

}
