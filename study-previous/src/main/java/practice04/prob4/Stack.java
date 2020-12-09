package prob4;

public interface Stack {
	public void push(String str) throws RuntimeException;
	public String pop() throws RuntimeException;
	public boolean isEmpty();
	public int size();
}
