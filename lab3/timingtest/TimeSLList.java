package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE

        AList<Integer> Ns = new AList<Integer>();
        Integer k = 1000;
        for (int i = 0; i < 5; i++) {
            Ns.addLast(k);
            k *= 2;
        }

        AList<Double> times = new AList<Double>();
        SLList<Integer> integerAList = new SLList<>();
//        Stopwatch stopwatch = new Stopwatch();
        for (int i = 0; i < Ns.size(); i++) {
            int N = Ns.get(i);

            for (int j = 0; j < N; j++) {
                integerAList.addLast(1);
            }
            Stopwatch stopwatch = new Stopwatch();
            for (int j = 0; j < 10000; j++) {
                integerAList.getLast();
            }
            double timeInSeconds = stopwatch.elapsedTime();
            times.addLast(timeInSeconds);
        }

        AList<Integer> opCounts = new AList<>();
        for (int i = 0; i < 5; i++) {
            opCounts.addLast(10000);
        }

        printTimingTable(Ns,times,opCounts);
    }

}
