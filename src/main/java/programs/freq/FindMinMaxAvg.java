package programs.freq;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindMinMaxAvg {
    public static void main(String[] args) {
        List<CityTemperature> cityTemperatureList = Arrays.asList(
                new CityTemperature("Delhi", 19.122),
                new CityTemperature("Bangalore", 18.321),
                new CityTemperature("Mumbai", 35.24),
                new CityTemperature("Delhi", 14.122),
                new CityTemperature("Bangalore", 27.82),
                new CityTemperature("Delhi", 40.76)
        );

        Map<String, List<CityTemperature>> frequencyMap = cityTemperatureList.stream()
                .collect(Collectors.groupingBy(CityTemperature::getCity));

        Map<String, TemperatureStats> resultMap = new HashMap<>();

        frequencyMap.forEach((city, tempList) -> {
            double min = tempList.stream().mapToDouble(CityTemperature::getTemperature).min().orElse(0);
            double max = tempList.stream().mapToDouble(CityTemperature::getTemperature).max().orElse(0);
            double avg = tempList.stream().mapToDouble(CityTemperature::getTemperature).average().orElse(0);
            resultMap.put(city, new TemperatureStats(min, max, avg));
        });

        System.out.println(resultMap);
    }
}

class CityTemperature {
    private String city;
    private Double temperature;

    public CityTemperature(String city, Double temperature) {
        this.city = city;
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "" + temperature;
    }
}


class TemperatureStats {
    private final double min;
    private final double max;
    private final double avg;

    public TemperatureStats(double min, double max, double avg) {
        this.min = min;
        this.max = max;
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "TemperatureStats{" +
                "min=" + min +
                ", max=" + max +
                ", avg=" + avg +
                '}';
    }
}