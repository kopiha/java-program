import java.util.Scanner;

interface StackADT {
    void push(String item);
    String pop();
    boolean isEmpty();
}

class TextEditorStack implements StackADT {
    private String[] stack = new String[10];
    private int top = -1;

    public void push(String item) {
        if (top < stack.length - 1) stack[++top] = item;
    }

    public String pop() {
        return !isEmpty() ? stack[top--] : null;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class TextEditor {
    private String text = "";
    private TextEditorStack stack = new TextEditorStack();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n1. Insert Text");
            System.out.println("2. Undo");
            System.out.println("3. Display Text");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    insertText(scanner.nextLine());
                    break;
                case 2:
                    undo();
                    break;
                case 3:
                    System.out.println("Text: " + text);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void insertText(String s) {
        stack.push(text);
        text += s;
    }

    private void undo() {
        if (!stack.isEmpty()) text = stack.pop();
    }

    public static void main(String[] args) {
        new TextEditor().run();
    }
}
