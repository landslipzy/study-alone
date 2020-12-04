package stream;

import java.util.stream.IntStream;

/**
 * @author zhongying
 * @description
 * @date 2020/12/4
 */
public class Test1 {
    public static void main(String[] args) {
//        IntStream numbers = numbers();
//        int head = head(numbers);
//        IntStream filtered = tail(numbers).filter(n -> n % head != 0);
//        IntStream primes = primes(filtered);

        LazyList<Integer> numbers = from(2);
        int two = numbers.head();
        int three = numbers.tail().head();
        int four = numbers.tail().tail().head();
        System.out.println(two + " " + three + " " + four);


    }

    public static LazyList<Integer> from(int n) {
        return new LazyList<>(n, () -> from(n + 1));
    }

    static IntStream primes(IntStream numbers) {
        int head = head(numbers);
        return IntStream.concat(
                IntStream.of(head),
                primes(tail(numbers).filter(n -> n % head != 0))
        );
    }

    static IntStream numbers() {
        return IntStream.iterate(2, n -> n + 1);
    }

    static int head(IntStream stream) {
        return stream.findFirst().getAsInt();

    }

    static IntStream tail(IntStream numbers) {
        return numbers.skip(1);
    }

}
