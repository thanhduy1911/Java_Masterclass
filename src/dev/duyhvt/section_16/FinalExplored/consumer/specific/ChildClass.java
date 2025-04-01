package dev.duyhvt.section_16.FinalExplored.consumer.specific;

import dev.duyhvt.section_16.FinalExplored.generic.BaseClass;

public class ChildClass extends BaseClass {
    @Override
    protected void optionalMethod() {
        System.out.println("[Child:optionalMethod]: EXTRA Stuff Here");
        super.optionalMethod();
    }

    public static void recommendedStatic() {
        System.out.println("[ChildClass.recommendedStatic]: BEST Way to Do it");
        optionalStatic();
//        mandatoryStatic();
    }

//    @Override
//    public void recommendedMethod() {
//        System.out.println("[Child:recommendedMethod]: I'll do things my way");
//        optionalMethod();
//    }
}
