@FunctionalInterface
public interface ConsumerWrapper<T, E extends Exception> {
    void accept() throws IOException;
}
