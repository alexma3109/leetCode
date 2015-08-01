public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0){
			return path;
		}
		String[] strings = path.split("/");
		StringBuilder sb = new StringBuilder("/");
		ArrayList<String> paths = new ArrayList<String>();
		for(String s : strings){
			if(s.equals("..")){
				if(paths.size() > 0){
					paths.remove(paths.size() - 1);
				}
			}
			else if(!s.equals(".") && !s.equals("")){
				paths.add(s);
			}
		}
		for(String s : paths){
			sb.append(s);
			if(s != paths.get(paths.size() - 1)){
				sb.append("/");				
			}
		}
		return sb.toString();
    }
}