package Day4and5_LinearAndBinarySearch;

public class CompareStringBufferAndBuilder {
    public static void main(String[] args) {
        int n = 1_000_000;
        long start, end;

        StringBuffer sbuf = new StringBuffer();
        start = System.nanoTime();
        for (int i = 0; i < n; i++) sbuf.append("hello");
        end = System.nanoTime();
        System.out.println("StringBuffer time: " + (end - start) / 1_000_000 + " ms");

        StringBuilder sbuilder = new StringBuilder();
        start = System.nanoTime();
        for (int i = 0; i < n; i++) sbuilder.append("hello");
        end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start) / 1_000_000 + " ms");
    }
}