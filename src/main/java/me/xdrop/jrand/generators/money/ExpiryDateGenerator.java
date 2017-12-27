package me.xdrop.jrand.generators.money;

import me.xdrop.jrand.Generator;
import me.xdrop.jrand.generators.basics.NaturalGenerator;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class ExpiryDateGenerator extends Generator<String>{
    private boolean longVersion;
    private boolean expired;
    private NaturalGenerator nat;

    public ExpiryDateGenerator() {
        this.nat = new NaturalGenerator();
        longVersion = false;
        expired = false;
    }

    public ExpiryDateGenerator longVersion() {
        return longVersion(true);
    }

    public ExpiryDateGenerator longVersion(boolean longVersion) {
        this.longVersion = longVersion;
        return this;
    }

    public ExpiryDateGenerator expired() {
        return expired(true);
    }

    public ExpiryDateGenerator expired(boolean enabled) {
        this.expired = enabled;
        return this;
    }

    @Override
    public String gen() {
        DateTime now = new DateTime();
        if (expired) {
            now = now.minusYears(nat.range(1,2).gen());
        } else {
            now = now.plusYears(nat.range(1,5).gen());
        }
        now = now.minusMonths(nat.range(0,12).gen());
        return formatDate(now, longVersion);
    }

    protected static String formatDate(DateTime now, boolean longVersion) {
        if (longVersion) {
            DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/yyyy");
            return formatter.print(now);
        } else {
            DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/yy");
            return formatter.print(now);
        }
    }
}
