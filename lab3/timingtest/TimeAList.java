package timingtest;


import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> a = new AList<>();
        AList<Double> b = new AList<>();
        AList<Integer> c = new AList<>();
        int testAListLength = 100;
        for (int p = 0; p < 15; p++) {
            if (p> 0){
                testAListLength *= 2;
            }
            a.addLast(testAListLength);
            AList<Integer> testAList = new AList<>();
            Stopwatch sw = new Stopwatch();
            for (int i = 0; i < testAListLength; i++) {
               testAList.addLast(1);
            }
            double timeInSeconds = sw.elapsedTime();
            b.addLast(timeInSeconds);
            c.addLast(testAListLength);
        }
        printTimingTable(a,b,c);
    }
}
