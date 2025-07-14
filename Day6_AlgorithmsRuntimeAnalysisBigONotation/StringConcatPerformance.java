package Day6_AlgorithmsRuntimeAnalysisBigONotation;

public class StringConcatPerformance {
    public static void main(String[] args) {
        int N = 1_000_000;
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) arr[i] = "hello";

        long start = System.nanoTime();
        String s = "";
        for (String str : arr) s += str;
        long end = System.nanoTime();
        System.out.println("String: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (String str : arr) sb.append(str);
        end = System.nanoTime();
        System.out.println("StringBuilder: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (String str : arr) sbuf.append(str);
        end = System.nanoTime();
        System.out.println("StringBuffer: " + (end - start) / 1_000_000.0 + " ms");
    }
}