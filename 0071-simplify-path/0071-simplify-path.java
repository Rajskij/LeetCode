class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        for (String str : path.split("/")) {
            // 1. ignore "." and handle ".."
            if (str.equals(".") || str.equals("")) continue;
            // 2. Join stack with "/" for result
            if (str.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(str);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            String str = "/" + stack.pop();
            sb.insert(0, str);
        }

        return sb.isEmpty() ? "/" : sb.toString();
    }
}