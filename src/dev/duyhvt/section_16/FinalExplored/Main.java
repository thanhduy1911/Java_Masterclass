package dev.duyhvt.section_16.FinalExplored;

import dev.duyhvt.section_16.FinalExplored.consumer.specific.ChildClass;
import dev.duyhvt.section_16.FinalExplored.external.util.Logger;
import dev.duyhvt.section_16.FinalExplored.generic.BaseClass;

public class Main {
    public static void main(String[] args) {
        BaseClass parent = new BaseClass();
        ChildClass child = new ChildClass();
        BaseClass childReferredToAsBase = new ChildClass();

        parent.recommendedMethod();
        System.out.println("-".repeat(50));
        childReferredToAsBase.recommendedMethod();
        System.out.println("-".repeat(50));
        child.recommendedMethod();

        System.out.println("-".repeat(50));
        parent.recommendedStatic();
        System.out.println("-".repeat(50));
        childReferredToAsBase.recommendedStatic();
        System.out.println("-".repeat(50));
        child.recommendedStatic();

        System.out.println("-".repeat(100));
        BaseClass.recommendedStatic();
        ChildClass.recommendedStatic();

        String xArgument = "This is all I've got to say about Section ";
        StringBuilder zArgument = new StringBuilder("Only saying this: Section ");
        doXYZ(xArgument, 16, zArgument);
        System.out.println("After Method, zArgument: " + zArgument);

        StringBuilder tracker = new StringBuilder("Step 1 is abc");
        Logger.logToConsole(tracker.toString());
        tracker.append(", Step 2 is xyz");
        Logger.logToConsole(tracker.toString());
        System.out.println("After Logging, tracker = " + tracker);
    }

    private static void doXYZ(String x, int y, StringBuilder z) {
        final String c = x + y;
        System.out.println("c = " + c);
        z.append(y);
    }
}
