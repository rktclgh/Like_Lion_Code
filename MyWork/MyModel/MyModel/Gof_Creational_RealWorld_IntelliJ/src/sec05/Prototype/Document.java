package sec05.Prototype;

public class Document implements Cloneable {
    private String content;

    public Document(String content) {
        this.content = content;
    }

    public void show() {
        System.out.println("Document: " + content);
    }

    public Document clone() {
        return new Document(this.content); //shallow copy
    }
}
