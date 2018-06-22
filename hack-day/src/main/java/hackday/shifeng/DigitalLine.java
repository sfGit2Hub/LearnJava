//package hackday.shifeng;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DigitalLine {
//    private List<Node> nodes;
//
//    public DigitalLine(String input) {
//        if (input == null) {
//            return;
//        }
//        this.nodes = new ArrayList<>();
//
//        if (input.length() <= 1) {
//            Node node;
//            if (input.length() == 0) {
//                node = new Node('\0', '\0');
//            } else {
//                node = new Node(input.charAt(0), '\0');
//            }
//            nodes.add(node);
//        } else {
//            for (int i = 0; i < input.length() - 1; i++) {
//                Node node = new Node(input.charAt(i), input.charAt(i+1));
//                nodes.add(node);
//            }
//        }
//    }
//
//    public DigitalLine(List<Node> nodes ) {
//        this.nodes = nodes;
//    }
//
//    public DigitalLine upLine() {
//        if (this.nodes == null)
//            return null;
//
//        char[] upChars = new char[this.nodes.size()];
//        for (int i = 0; i < nodes.size(); i++) {
//            upChars[i] = this.nodes.get(i).getUpLineChar();
//        }
//        return new DigitalLine(new String(upChars));
//    }
//
//    public String getResult() throws IllegalAccessException {
//        if (nodes == null) return null;
//
//        if (nodes.size() == 1) {
//            Node node = nodes.get(0);
//            return new String(new char[]{node.getUpLineChar()});
//        } else {
//            throw new IllegalAccessException("The line length is not 2");
//        }
//    }
//
//    public int size() {
//        if (nodes == null) return 0;
//        return nodes.size();
//    }
//
//
//    public class Node {
//        char head;
//        char tail;
//
//        public Node(char first, char last) {
//            this.head = first;
//            this.tail = last;
//        }
//
//        public char getUpLineChar() {
//            if (head == tail) return head;
//            if (head == '1' && tail == '2') return '3';
//            if (head == '1' && tail == '3') return '2';
//            if (head == '2' && tail == '1') return '3';
//            if (head == '2' && tail == '3') return '1';
//            if (head == '3' && tail == '1') return '2';
//            if (head == '3' && tail == '2') return '1';
//
//            //  空字符串输入
//            if (head == '\0'|| tail == '\0') return head;
//            return 0;
//        }
//    }
//}
