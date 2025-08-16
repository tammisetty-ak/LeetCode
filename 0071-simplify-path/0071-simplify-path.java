class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque();

        String[] fileNames = path.split("/+");

        for (String fileName : fileNames) {
            if (fileName.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (!fileName.isBlank() && !fileName.equals(".")) {
                stack.push(fileName);
            }
        }

        StringBuilder res = new StringBuilder();

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        Iterator<String> it = stack.descendingIterator();
        while (it.hasNext()) {
            sb.append("/").append(it.next());
        }
        return sb.toString();

    }
}