package medium;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {
	public String simplifyPath(String path) {
		List<String> stack = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int i  = 0;
		while (i <= path.length()){
			if(i == path.length() || path.charAt(i) == '/'){
				if(sb.length() > 0){
					String one = sb.toString();
					if(one.equals("..")){
						if(stack.size() > 0)stack.remove(stack.size() - 1);
					}else if(!one.equals(".")){
						stack.add(one);
					}
					sb = new StringBuilder();
				}
			}else {
				sb.append(path.charAt(i));
			}
			i++;
		}
		sb = new StringBuilder();
		for(String each : stack){
			sb.append("/");
			sb.append(each);
		}
		if(sb.length() == 0)return "/";
		return sb.toString();
	}

	public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath("/."));
	}
}
