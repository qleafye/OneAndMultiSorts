package org.example;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.apache.commons.math3.*;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


import javax.swing.*;
import java.awt.*;



import javax.swing.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.awt.*;

public class GraphForSorts {


    static void compareOneThreadSortsMid() {
        Random random = new Random();
        List<Integer> arraySizes = new ArrayList<>();
        for (int i = 500000; i <= 10000000; i += 500000) {
            arraySizes.add(i);
        }




        Map<String, List<Integer>> sortTimes = TimesForSorts.OneThreadTimeMid();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, List<Integer>> entry : sortTimes.entrySet()) {
            String sortName = entry.getKey();
            List<Integer> times = entry.getValue();
            for (int i = 0; i < times.size(); i++) {
                dataset.addValue(times.get(i), sortName, Integer.toString(arraySizes.get(i) / 100));
            }
        }

        JFreeChart lineChart = ChartFactory.createLineChart(
                "Время выполнения сортировок",
                "Размер массива / 100",
                "Время (МкС)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);


        addRegressionLines(sortTimes, arraySizes, lineChart);
        JFrame frame = new JFrame("Сравнение алгоритмов сортировки");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        ChartPanel chartPanel = new ChartPanel(lineChart);
        frame.add(chartPanel);
        frame.setVisible(true);
        System.out.println(dataset);

    }


    static void compareOneThreadSortsWorst() {
        Random random = new Random();
        List<Integer> arraySizes = new ArrayList<>();
        for (int i = 500000; i <= 10000000; i += 500000) {
            arraySizes.add(i);
        }




        Map<String, List<Integer>> sortTimes = TimesForSorts.OneThreadTimeWorst();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, List<Integer>> entry : sortTimes.entrySet()) {
            String sortName = entry.getKey();
            List<Integer> times = entry.getValue();
            for (int i = 0; i < times.size(); i++) {
                dataset.addValue(times.get(i), sortName, Integer.toString(arraySizes.get(i) / 100));
            }
        }

        JFreeChart lineChart = ChartFactory.createLineChart(
                "Время выполнения сортировок",
                "Размер массива / 100",
                "Время (МкС)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);


        addRegressionLines(sortTimes, arraySizes, lineChart);
        JFrame frame = new JFrame("Сравнение алгоритмов сортировки");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        ChartPanel chartPanel = new ChartPanel(lineChart);
        frame.add(chartPanel);
        frame.setVisible(true);
        System.out.println(dataset);

    }
    static void compareOneThreadSortsBest() {
        Random random = new Random();
        List<Integer> arraySizes = new ArrayList<>();
        for (int i = 500000; i <= 10000000; i += 500000) {
            arraySizes.add(i);
        }




        Map<String, List<Integer>> sortTimes = TimesForSorts.OneThreadTimeBest();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, List<Integer>> entry : sortTimes.entrySet()) {
            String sortName = entry.getKey();
            List<Integer> times = entry.getValue();
            for (int i = 0; i < times.size(); i++) {
                dataset.addValue(times.get(i), sortName, Integer.toString(arraySizes.get(i) / 100));
            }
        }

        JFreeChart lineChart = ChartFactory.createLineChart(
                "Время выполнения сортировок",
                "Размер массива / 100",
                "Время (МкС)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);


        addRegressionLines(sortTimes, arraySizes, lineChart);
        JFrame frame = new JFrame("Сравнение алгоритмов сортировки");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        ChartPanel chartPanel = new ChartPanel(lineChart);
        frame.add(chartPanel);
        frame.setVisible(true);
        System.out.println(dataset);

    }
    static void compareMultiThreadSortsBest() {
        Random random = new Random();
        List<Integer> arraySizes = new ArrayList<>();
        for (int i = 500000; i <= 10000000; i += 500000) {
            arraySizes.add(i);
        }

        Map<String, List<Integer>> sortTimes = TimesForSorts.MultiThreadTimeBest();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, List<Integer>> entry : sortTimes.entrySet()) {
            String sortName = entry.getKey();
            List<Integer> times = entry.getValue();
            for (int i = 0; i < times.size(); i++) {
                dataset.addValue(times.get(i), sortName, Integer.toString(arraySizes.get(i) / 100));
            }
        }

        JFreeChart lineChart = ChartFactory.createLineChart(
                "Время выполнения сортировок",
                "Размер массива / 100",
                "Время (МкС)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);


        addRegressionLines(sortTimes, arraySizes, lineChart);
        JFrame frame = new JFrame("Сравнение алгоритмов сортировки");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        ChartPanel chartPanel = new ChartPanel(lineChart);
        frame.add(chartPanel);
        frame.setVisible(true);
    }
    static void compareMultiThreadSortsMid() {
        Random random = new Random();
        List<Integer> arraySizes = new ArrayList<>();
        for (int i = 500000; i <= 10000000; i += 500000) {
            arraySizes.add(i);
        }

        Map<String, List<Integer>> sortTimes = TimesForSorts.MultiThreadTimeMid();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, List<Integer>> entry : sortTimes.entrySet()) {
            String sortName = entry.getKey();
            List<Integer> times = entry.getValue();
            for (int i = 0; i < times.size(); i++) {
                dataset.addValue(times.get(i), sortName, Integer.toString(arraySizes.get(i) / 100));
            }
        }

        JFreeChart lineChart = ChartFactory.createLineChart(
                "Время выполнения сортировок",
                "Размер массива / 100",
                "Время (МкС)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);


        addRegressionLines(sortTimes, arraySizes, lineChart);
        JFrame frame = new JFrame("Сравнение алгоритмов сортировки");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        ChartPanel chartPanel = new ChartPanel(lineChart);
        frame.add(chartPanel);
        frame.setVisible(true);
    }
    static void compareMultiThreadSortsWorst() {
        Random random = new Random();
        List<Integer> arraySizes = new ArrayList<>();
        for (int i = 500000; i <= 10000000; i += 500000) {
            arraySizes.add(i);
        }

        Map<String, List<Integer>> sortTimes = TimesForSorts.MultiThreadTimeWorst();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, List<Integer>> entry : sortTimes.entrySet()) {
            String sortName = entry.getKey();
            List<Integer> times = entry.getValue();
            for (int i = 0; i < times.size(); i++) {
                dataset.addValue(times.get(i), sortName, Integer.toString(arraySizes.get(i) / 100));
            }
        }

        JFreeChart lineChart = ChartFactory.createLineChart(
                "Время выполнения сортировок",
                "Размер массива / 100",
                "Время (МкС)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);


        addRegressionLines(sortTimes, arraySizes, lineChart);
        JFrame frame = new JFrame("Сравнение алгоритмов сортировки");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        ChartPanel chartPanel = new ChartPanel(lineChart);
        frame.add(chartPanel);
        frame.setVisible(true);
    }

    static void addRegressionLines(Map<String, List<Integer>> sortTimes, List<Integer> arraySizes, JFreeChart chart) {
        XYSeriesCollection regressionDataset = new XYSeriesCollection();

        for (Map.Entry<String, List<Integer>> entry : sortTimes.entrySet()) {
            String sortName = entry.getKey();
            List<Integer> times = entry.getValue();

            WeightedObservedPoints obs = new WeightedObservedPoints();
            for (int i = 0; i < arraySizes.size(); i++) {
                double logSize = Math.log(arraySizes.get(i)); // Преобразование размера массива
                obs.add(logSize, times.get(i));
            }

            // Линейная регрессия на логарифмированных данных
            PolynomialCurveFitter fitter = PolynomialCurveFitter.create(2); // Линейная регрессия
            double[] coeffs = fitter.fit(obs.toList());


            // Построение логарифмической функции
            XYSeries regressionSeries = new XYSeries(sortName + " Log Regression");
            for (int size : arraySizes) {
                double logSize = Math.log(size);
                double predictedTime = coeffs[2] + coeffs[1] * logSize + coeffs[0] * logSize * logSize; // a + b*log(x)
                regressionSeries.add(size, predictedTime);
            }
            regressionDataset.addSeries(regressionSeries);
        }

        JFreeChart regressionChart = ChartFactory.createXYLineChart(
                "Логарифмические регрессии",
                "Размер массива",
                "Время (МкС)",
                regressionDataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);

        JFrame regressionFrame = new JFrame("Логарифмические регрессии");
        regressionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        regressionFrame.setSize(800, 600);
        ChartPanel regressionChartPanel = new ChartPanel(regressionChart);
        regressionFrame.add(regressionChartPanel);
        regressionFrame.setVisible(true);
    }
    static void compareOneAndMulti(Map<String, List<Integer>> sortTimesOne, List<Integer> arraySizesOne,
                                   Map<String, List<Integer>> sortTimesMulti, List<Integer> arraySizesMulti, String type){
        XYSeriesCollection regressionDataset = new XYSeriesCollection();

        for (Map.Entry<String, List<Integer>> entry : sortTimesOne.entrySet()) {
            String sortName = entry.getKey();
            List<Integer> times = entry.getValue();

            WeightedObservedPoints obs = new WeightedObservedPoints();
            for (int i = 0; i < arraySizesOne.size(); i++) {
                double logSize = Math.log(arraySizesOne.get(i)); // Преобразование размера массива
                obs.add(logSize, times.get(i));
            }

            // Линейная регрессия на логарифмированных данных
            PolynomialCurveFitter fitter = PolynomialCurveFitter.create(2); // Линейная регрессия
            double[] coeffs = fitter.fit(obs.toList());


            // Построение логарифмической функции
            XYSeries regressionSeries = new XYSeries(sortName + " Log Regression");
            for (int size : arraySizesOne) {
                double logSize = Math.log(size);
                double predictedTime = coeffs[2] + coeffs[1] * logSize + coeffs[0] * logSize * logSize; // a + b*log(x)
                regressionSeries.add(size, predictedTime);
            }
            regressionDataset.addSeries(regressionSeries);
        }
        for (Map.Entry<String, List<Integer>> entry : sortTimesMulti.entrySet()) {
            String sortName = entry.getKey();
            List<Integer> times = entry.getValue();

            WeightedObservedPoints obs = new WeightedObservedPoints();
            for (int i = 0; i < arraySizesMulti.size(); i++) {
                double logSize = Math.log(arraySizesMulti.get(i)); // Преобразование размера массива
                obs.add(logSize, times.get(i));
            }

            // Линейная регрессия на логарифмированных данных
            PolynomialCurveFitter fitter = PolynomialCurveFitter.create(2); // Линейная регрессия
            double[] coeffs = fitter.fit(obs.toList());


            // Построение логарифмической функции
            XYSeries regressionSeries = new XYSeries(sortName + " Log Regression");
            for (int size : arraySizesMulti) {
                double logSize = Math.log(size);
                double predictedTime = coeffs[2] + coeffs[1] * logSize + coeffs[0] * logSize * logSize; // a + b*log(x)
                regressionSeries.add(size, predictedTime);
            }
            regressionDataset.addSeries(regressionSeries);
        }

        JFreeChart regressionChart = ChartFactory.createXYLineChart(
                "Логарифмические регрессии" + type,
                "Размер массива",
                "Время (МкС)",
                regressionDataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);

        JFrame regressionFrame = new JFrame("Логарифмические регрессии");
        regressionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        regressionFrame.setSize(800, 600);
        ChartPanel regressionChartPanel = new ChartPanel(regressionChart);
        regressionFrame.add(regressionChartPanel);
        regressionFrame.setVisible(true);



        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, List<Integer>> entry : sortTimesOne.entrySet()) {
            String sortName = entry.getKey();
            List<Integer> times = entry.getValue();
            for (int i = 0; i < times.size(); i++) {
                dataset.addValue(times.get(i), sortName, Integer.toString(arraySizesOne.get(i) / 100));
            }
        }
        for (Map.Entry<String, List<Integer>> entry : sortTimesMulti.entrySet()) {
            String sortName = entry.getKey();
            List<Integer> times = entry.getValue();
            for (int i = 0; i < times.size(); i++) {
                dataset.addValue(times.get(i), sortName, Integer.toString(arraySizesMulti.get(i) / 100));
            }
        }

        JFreeChart lineChart = ChartFactory.createLineChart(
                "Время выполнения сортировок" + type,
                "Размер массива / 100",
                "Время (МкС)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);



        JFrame frame = new JFrame("Сравнение алгоритмов сортировки");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        ChartPanel chartPanel = new ChartPanel(lineChart);
        frame.add(chartPanel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Создание набора данных
//        TimesForSorts.OneThreadTimeMid();
//        TimesForSorts.OneThreadTimeBest();
//        TimesForSorts.OneThreadTimeWorst();
//        System.out.println("Multui");
//        TimesForSorts.MultiThreadTimeBest();
//        TimesForSorts.MultiThreadTimeMid();
//        TimesForSorts.MultiThreadTimeWorst();
        Random random = new Random();
        List<Integer> arraySizes = new ArrayList<>();
        for (int i = 10000; i <= 10000000; i += 500000) {
            arraySizes.add(i);
        }
        compareOneAndMulti(TimesForSorts.OneThreadTimeMid(), arraySizes,
                TimesForSorts.MultiThreadTimeMid(), arraySizes, "MID");
        compareOneAndMulti(TimesForSorts.OneThreadTimeWorst(), arraySizes,
                TimesForSorts.MultiThreadTimeWorst(), arraySizes, "WORST");
        compareOneAndMulti(TimesForSorts.OneThreadTimeBest(), arraySizes,
                TimesForSorts.MultiThreadTimeBest(), arraySizes, "BEST");
//        compareMultiThreadSortsBest();
//        compareMultiThreadSortsMid();
//        compareMultiThreadSortsWorst();
//        compareOneThreadSortsBest();
//        compareOneThreadSortsMid();
//        compareOneThreadSortsWorst();





    }
}
