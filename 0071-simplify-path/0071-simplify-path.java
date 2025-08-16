class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();

        String[] fileNames = path.split("/+");

        for (String fileName : fileNames) {
            if (!fileName.isBlank()) {
                if (fileName.equals("..")) {
                    if (!stack.isEmpty())
                        stack.pop();
                }
                else if(!fileName.equals(".")) {
                    stack.push(fileName);
                }
            }
        }

        StringBuilder res = new StringBuilder();

        if(stack.isEmpty()) {
            return "/";
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            res.insert(0, stack.pop());
            res.insert(0, "/");
        }

        return res.toString();

    }
}