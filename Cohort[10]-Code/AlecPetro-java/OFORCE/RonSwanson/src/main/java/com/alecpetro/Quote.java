package com.alecpetro;

public class Quote {

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

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	

}


