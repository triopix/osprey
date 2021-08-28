package osprey.measurement;

import osprey.measurement.impl.Converter;

import static osprey.measurement.def.Category.TEMPERATURE;
import static osprey.measurement.def.UnitDefinition.*;

public class Demo {

    public static void main(String[] args) {
        Converter temperatureConverter = new Converter(TEMPERATURE, CELSIUS); // Type Temperature with BaseUnit Celsius
        double celsius = 32.0;
        double fahrenheit = temperatureConverter.convert(celsius, FAHRENHEIT);
        double kelvin = temperatureConverter.convert(celsius, KELVIN);
        System.out.println(celsius +"°C   =>   "+fahrenheit +"°F    =>   "+kelvin +"°K");
    }
}

