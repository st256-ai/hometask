package main.java;
import java.io.IOException;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Consumer<Handler> consumer = wrap(Handler::handle);
        Consumer<Handler> anotherConsumer = wrap(Handler::handleAnotherWay);
        Consumer<Handler> andAnotherConsumer = wrap(Handler::handleAndAnotherWay);

        Handler handler = new Handler();

        consumer.accept(handler); //expected output: 1
        anotherConsumer.accept(handler); //expected output: 2
        andAnotherConsumer.accept(handler); //expected output: 3
    }

    private static <T> Consumer<T> wrap(ConsumerWrapper<T, Exception> consumerWrapper) {
        return i -> {
            //(done)todo add implementation, an exception is caught and prints to console error code
            try {
                consumerWrapper.accept();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        };
    }

