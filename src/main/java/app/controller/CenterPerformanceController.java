package app.controller;


import app.ui.console.utils.CSVConverter;
import app.ui.gui.Utils.Sum;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * The type Center performance controller.
 */
public class CenterPerformanceController {
    private CSVConverter converter;

    /**
     * Instantiates a new Center performance controller.
     */
    public CenterPerformanceController(){
        converter = new CSVConverter();
    }


    /**
     * Maxsumsublist array list.
     *
     * @param sublist the sublist
     * @return the array list
     */
//MDISC
    public ArrayList<Integer> maxsumsublist (ArrayList<Integer>  sublist) {
        ArrayList<Integer> maxsumsublist = new ArrayList<>();
        int somamax = 0;
        int imax=0;
        int jmax=0;
        for (int i = 0; i < ((sublist.size()) - 1); i++) {
            int soma = 0;
            for (int j = i; j < ((sublist.size()) - 1); j++) {
                soma = soma + sublist.get(j);
                if (somamax < soma) {
                    somamax = soma;
                    imax=i;
                    jmax=j;
                }
            }

        }
        for (int p=imax; p<=jmax; p++){
            maxsumsublist.add(sublist.get(p));
        }
        return maxsumsublist;
    }


    /**
     * Maxsum int.
     *
     * @param sublist the sublist
     * @return the int
     */
    public int maxsum (ArrayList<Integer>  sublist) {
        int somamax = 0;
        for (int i = 0; i < ((sublist.size()) - 1); i++) {
            int soma = 0;
            for (int j = i; j < ((sublist.size()) - 1); j++) {
                soma = soma + sublist.get(j);
                if (somamax < soma) {
                    somamax = soma;
                }
            }

        }

        return somamax;
    }

    /**
     * Interval start int.
     *
     * @param sublist the sublist
     * @return the int
     */
    public int intervalStart (ArrayList<Integer>  sublist) {
        int somamax = 0;
        int imax = 0;
        for (int i = 0; i < ((sublist.size()) ); i++) {
            int soma = 0;
            for (int j = i; j < ((sublist.size()) ); j++) {
                soma = soma + sublist.get(j);
                if (somamax < soma) {
                    somamax = soma;
                    imax = i;
                }
            }

        }

        return imax;
    }

    /**
     * Interval end int.
     *
     * @param sublist the sublist
     * @return the int
     */
    public int intervalEnd (ArrayList<Integer>  sublist) {
        int somamax = 0;
        int jmax = 0;
        for (int i = 0; i < ((sublist.size()) ); i++) {
            int soma = 0;
            for (int j = i; j < ((sublist.size())); j++) {
                soma = soma + sublist.get(j);
                if (somamax < soma) {
                    somamax = soma;
                    jmax = j;
                }
            }

        }

        return jmax;
    }


    /**
     * Time interval of sublist string.
     *
     * @param performanceList the performance list
     * @return the string
     */
    public String timeIntervalOfSublist(ArrayList<Integer> performanceList, String filepath, int m) throws IOException {
        Calendar timeSlotS = converter.timeSlot(filepath);
        timeSlotS.set(Calendar.HOUR, 8);
        timeSlotS.set(Calendar.MINUTE, 0);
        timeSlotS.add(Calendar.MINUTE,intervalStart(maxsumsublist(performanceList))*m);
        Calendar timeSlotE = converter.timeSlot(filepath);
        timeSlotE.set(Calendar.HOUR, 8);
        timeSlotE.set(Calendar.MINUTE, 0);
        timeSlotE.add(Calendar.MINUTE,intervalEnd(maxsumsublist(performanceList))*m);

        return ("["+timeSlotS.getTime()+","+timeSlotE.getTime()+"]");
    }


    /**
     * Read info from csv array list.
     *
     * @param filePath the file path
     * @param m        the m
     * @return the array list
     */
    public ArrayList<Integer> readInfoFromCSV(String filePath, int m){
        return converter.readInfoFromCSV(filePath,m);
    }

    public void benchmarkComparrission(ArrayList<Integer> performanceList, long runtime) {
        int[] example = new int[]{29, -32, -9, -25, 44, 12, -61, 51, -9, 44, 74, 4};
        int[] result = Sum.Max(example);
        long benchmarkEnd = (System.currentTimeMillis());
        System.out.println("Benchmark algorithm execution: ");
        System.out.print(Math.subtractExact(benchmarkEnd,runtime));
        System.out.print(" millissecons");
        maxsumsublist(performanceList);
        long oursEnd = System.currentTimeMillis();
        System.out.println("");
        System.out.println("Our algorithm execution: ");
        System.out.print(Math.subtractExact(oursEnd, runtime));
        System.out.print(" millissecons");
    }
}
