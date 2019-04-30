public class Quote{

    private int wordCount;
    private int sum;
    private int count;
    private String text;

    Quote(String quote){
        this.text = quote;
        this.sum = 0;
        this.wordCount = quote.split(" ").length;
        this.count = 0;
    }
}