package osprey.measurement.impl;


import osprey.measurement.def.Category;
import osprey.measurement.def.UnitDefinition;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Converter {

    public  static final String[] ABBREVIATIONS      = { "k", "M", "G", "T", "P", "E", "Z", "Y" };
    public  static final int MAX_NO_OF_DECIMALS = 12;
    private static final EnumMap<Category, UnitDefinition> BASE_UNITS = new EnumMap<Category, UnitDefinition>(Category.class) {
        {
            put(Category.ACCELERATION, UnitDefinition.METER_PER_SQUARE_SECOND);
            put(Category.ANGLE, UnitDefinition.RADIAN);
            put(Category.AREA, UnitDefinition.SQUARE_METER);
            put(Category.CURRENT, UnitDefinition.AMPERE);
            put(Category.DATA, UnitDefinition.BIT);
            put(Category.ELECTRIC_CHARGE, UnitDefinition.ELEMENTARY_CHARGE);
            put(Category.ENERGY, UnitDefinition.JOULE);
            put(Category.FORCE, UnitDefinition.NEWTON);
            put(Category.HUMIDITY, UnitDefinition.PERCENTAGE);
            put(Category.LENGTH, UnitDefinition.METER);
            put(Category.LUMINANCE, UnitDefinition.CANDELA_SQUARE_METER);
            put(Category.LUMINOUS_FLUX, UnitDefinition.LUX);
            put(Category.MASS, UnitDefinition.KILOGRAM);
            put(Category.PRESSURE, UnitDefinition.PASCAL);
            put(Category.SPEED, UnitDefinition.METER_PER_SECOND);
            put(Category.TEMPERATURE, UnitDefinition.KELVIN);
            put(Category.TEMPERATURE_GRADIENT, UnitDefinition.KELVIN_PER_SECOND);
            put(Category.TIME, UnitDefinition.SECOND);
            put(Category.TORQUE, UnitDefinition.NEWTON_METER);
            put(Category.VOLUME, UnitDefinition.CUBIC_METER);
            put(Category.VOLTAGE, UnitDefinition.VOLT);
            put(Category.WORK, UnitDefinition.WATT);
            put(Category.BLOOD_GLUCOSE, UnitDefinition.MILLIMOL_PER_LITER);
        }
    };

    private UnitDefinition baseUnitDefinition;
    private final Unit bean;
    private Locale locale;
    private int decimals;
    private String formatString;


    // ******************** Constructors **************************************
    public Converter(final Category UNIT_TYPE) {
        this(UNIT_TYPE, BASE_UNITS.get(UNIT_TYPE));
    }

    public Converter(final Category UNIT_TYPE, final UnitDefinition BASE_UNIT_DEFINITION) {
        baseUnitDefinition = BASE_UNIT_DEFINITION;
        bean               = BASE_UNITS.get(UNIT_TYPE).UNIT;
        locale             = Locale.US;
        decimals           = 2;
        formatString       = "%.2f";
    }


    // ******************** Methods *******************************************
    public Category getUnitType() { return bean.getCategory(); }

    public UnitDefinition getBaseUnitDefinition() { return baseUnitDefinition; }
    public void setBaseUnitDefinition(final UnitDefinition BASE_UNIT_DEFINITION) {
        if (BASE_UNIT_DEFINITION.UNIT.getCategory() == getUnitType()) { baseUnitDefinition = BASE_UNIT_DEFINITION; }
    }

    public BigDecimal getFactor() { return bean.getFactor(); }

    public BigDecimal getOffset() { return bean.getOffset(); }

    public String getUnitName() { return bean.getUnitName(); }

    public String getUnitShort() { return bean.getUnitShort(); }

    public Locale getLocale() { return locale; }
    public void setLocale(final Locale LOCALE) { locale = LOCALE; }

    public int getDecimals() { return decimals; }
    public void setDecimals(final int DECIMALS) {
        if (DECIMALS < 0 ) {
            decimals = 0;
        } else decimals = Math.min(DECIMALS, MAX_NO_OF_DECIMALS);
        formatString = "%." + decimals + "f";
    }

    public String getFormatString() { return formatString; }

    public final boolean isActive() { return bean.isActive(); }
    public final void setActive(final boolean ACTIVE) { bean.setActive(ACTIVE); }

    public final double convert(final double VALUE, final UnitDefinition UNIT_DEFINITION) {
        if (UNIT_DEFINITION.UNIT.getCategory() != getUnitType()) { throw new IllegalArgumentException("units have to be of the same type"); }
        return ((((VALUE + baseUnitDefinition.UNIT.getOffset().doubleValue()) * baseUnitDefinition.UNIT.getFactor().doubleValue()) + bean.getOffset().doubleValue()) * bean.getFactor().doubleValue()) / UNIT_DEFINITION.UNIT
            .getFactor().doubleValue() - UNIT_DEFINITION.UNIT.getOffset().doubleValue();
    }

    public final String convertToString(final double VALUE, final UnitDefinition UNIT_DEFINITION) {
        return String.join(" ", String.format(locale, formatString, convert(VALUE, UNIT_DEFINITION)), UNIT_DEFINITION.UNIT.getUnitShort());
    }

    public final double convertToBaseUnit(final double VALUE, final UnitDefinition UNIT_DEFINITION) {
        return ((((VALUE + UNIT_DEFINITION.UNIT.getOffset().doubleValue()) * UNIT_DEFINITION.UNIT.getFactor().doubleValue()) + bean.getOffset().doubleValue()) * bean.getFactor().doubleValue()) / baseUnitDefinition.UNIT
            .getFactor().doubleValue() - baseUnitDefinition.UNIT.getOffset().doubleValue();
    }

    public final Pattern getPattern() {
        final StringBuilder PATTERN_BUILDER = new StringBuilder();
        PATTERN_BUILDER.append("^([-+]?\\d*\\.?\\d*)\\s?(");

        for (UnitDefinition unitDefinition : UnitDefinition.values()) {
            PATTERN_BUILDER.append(unitDefinition.UNIT.getUnitShort().replace("*", "\\*")).append("|");
        }

        PATTERN_BUILDER.deleteCharAt(PATTERN_BUILDER.length() - 1);

        //PATTERN_BUILDER.append("){1}$");
        PATTERN_BUILDER.append(")?$");

        return Pattern.compile(PATTERN_BUILDER.toString());
    }

    public final List<Unit> getAvailableUnits(final Category UNIT_DEFINITION) {
        return getAllUnitDefinitions().get(UNIT_DEFINITION).stream().map(unitDefinition -> unitDefinition.UNIT).collect(Collectors.toList());
    }

    public final EnumMap<Category, ArrayList<UnitDefinition>> getAllUnitDefinitions() {
        final EnumMap<Category, ArrayList<UnitDefinition>> UNIT_TYPES    = new EnumMap<>(Category.class);
        final ArrayList<Category>                          CATEGORY_LIST = new ArrayList<>(Category.values().length);
        CATEGORY_LIST.addAll(Arrays.asList(Category.values()));
        CATEGORY_LIST.forEach(category -> UNIT_TYPES.put(category, new ArrayList<>()));
        for (UnitDefinition unitDefinition : UnitDefinition.values()) {
            UNIT_TYPES.get(unitDefinition.UNIT.getCategory()).add(unitDefinition);
        }
        return UNIT_TYPES;
    }

    public final EnumMap<Category, ArrayList<UnitDefinition>> getAllActiveUnitDefinitions() {
        final EnumMap<Category, ArrayList<UnitDefinition>> UNIT_DEFINITIONS = new EnumMap<>(Category.class);
        final ArrayList<Category>                          CATEGORY_LIST    = new ArrayList<>(Category.values().length);
        CATEGORY_LIST.addAll(Arrays.asList(Category.values()));
        CATEGORY_LIST.forEach(category -> UNIT_DEFINITIONS.put(category, new ArrayList<>()));
        for (UnitDefinition unitDefinition : UnitDefinition.values()) {
            if (unitDefinition.UNIT.isActive()) { UNIT_DEFINITIONS.get(unitDefinition.UNIT.getCategory()).add(unitDefinition); }
        }
        return UNIT_DEFINITIONS;
    }

    public static String format(final double NUMBER, final int DECIMALS) {
        return format(NUMBER, clamp(DECIMALS), Locale.US);
    }
    public static String format(final double NUMBER, final int DECIMALS, final Locale LOCALE) {
        String formatString = "%." + clamp(DECIMALS) + "f";
        double value;
        for(int i = ABBREVIATIONS.length - 1 ; i >= 0; i--) {
            value = Math.pow(1000, i+1);
            if (Double.compare(NUMBER, -value) <= 0 || Double.compare(NUMBER, value) >= 0) {
                return String.format(LOCALE, formatString, (NUMBER / value)) + ABBREVIATIONS[i];
            }
        }
        return String.format(LOCALE, formatString, NUMBER);
    }

    private static int clamp(final int VALUE) {
        if (VALUE < 0) return 0;
        return Math.min(VALUE, 12);
    }

    @Override public String toString() { return getUnitType().toString(); }
}
