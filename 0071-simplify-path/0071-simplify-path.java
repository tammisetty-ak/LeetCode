class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();

        String[] fileNames = path.split("/+");

        for (String fileName : fileNames) {
            if(fileName.equals(".") || fileName.isEmpty()) {
                continue;
            }
            else if (fileName.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(fileName);
            }
        }

        StringBuilder res = new StringBuilder();

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        
        for (String str: stack) {
            sb.append("/").append(str);
        }
        return sb.toString();

    }
}