package hackday.shifeng;

public class DigitalLine2 {
    private String elements;

    public DigitalLine2(String input) {
        elements = input;
    }


    public DigitalLine2 upLine() {
        if (this.elements == null)
            return null;
        if (this.elements.length() <= 1)
            return null;

        char[] upChars = new char[this.elements.length() - 1];
        for (int i = 0; i < elements.length() - 1; i++) {
            upChars[i] = getUpLineChar(elements.charAt(i), elements.charAt(i+1));
        }
        return new DigitalLine2(new String(upChars));
    }

    public char getUpLineChar(char head, char tail) {
        if (head == tail) return head;
        if (head == '1' && tail == '2') return '3';
        if (head == '1' && tail == '3') return '2';
        if (head == '2' && tail == '1') return '3';
        if (head == '2' && tail == '3') return '1';
        if (head == '3' && tail == '1') return '2';
        if (head == '3' && tail == '2') return '1';

        //  空字符串输入
        if (head == '\0'|| tail == '\0') return head;
        return '\0';
    }

    public String getResult() throws IllegalAccessException {
        return elements;
    }

    public int size() {
        if (elements == null) return 0;
        return elements.length();
    }

}
