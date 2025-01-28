package oving1;

public class LineEditor {
    private String text;
    private int insertionIndex;

    public LineEditor() {
        this.text = "";
        this.insertionIndex = 0;
    }

    public void left() {
        if (insertionIndex > 0) {
            insertionIndex--;
        }
    }

    public void right() {
        if (insertionIndex < text.length()) {
            insertionIndex++;
        }
    }

    public void insertString(String s) {
        if (s.isEmpty()) {
            return;
        }

        text = text.substring(0, insertionIndex) + s + text.substring(insertionIndex);
        insertionIndex += s.length();
    }

    public void deleteLeft() {
        if (insertionIndex > 0) {
            text = text.substring(0, insertionIndex - 1) + text.substring(insertionIndex);
            insertionIndex--;
        }
    }

    public void deleteRight() {
        if (insertionIndex < text.length()) {
            text = text.substring(0, insertionIndex) + text.substring(insertionIndex + 1);
        }
    }

    public String getText() {
        return this.text;
    }

    public void setText(String string) {
        this.text = string;
    }

    public int getInsertionIndex() {
        return this.insertionIndex;
    }

    public void setInsertionIndex(int index) {
        this.insertionIndex = index;
    }

    @Override
    public String toString() {
        return text.substring(0, insertionIndex) + "|" + text.substring(insertionIndex);
    }

    public static void main(String[] args) {
        LineEditor lineEditor = new LineEditor();
        lineEditor.insertString("J");
        System.out.println(lineEditor.toString());
        System.out.println(lineEditor.getInsertionIndex());
        System.out.println(lineEditor.text.length());
        lineEditor.setInsertionIndex(0);
        System.out.println(lineEditor.toString());
        lineEditor.deleteRight();
        System.out.println(lineEditor.toString());
    }
}