package dev.duyhvt.section_11.InterfaceChallenge;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Mappable> mappables = new ArrayList<>();

        mappables.add(newBuilding("Sydney Town Hall", UsageType.GOVERNMENT));
        mappables.add(newBuilding("Sydney Opera House", UsageType.ENTERTAINMENT));
        mappables.add(newBuilding("Stadium", UsageType.SPORTS));

        mappables.add(newUtility("College St", UtilityType.FIBER_OPTIC));
        mappables.add(newUtility("Olympic Blvd", UtilityType.WATER));

        for (var m : mappables) {
            Mappable.mapIt(m);
        }
    }
    private static Building newBuilding(String name, UsageType usageType) {
        return new Building(name, usageType);
    }

    private static UtilityLine newUtility(String name, UtilityType type) {
        return new UtilityLine(name, type);
    }
}
