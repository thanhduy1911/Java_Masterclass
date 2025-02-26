package dev.duyhvt.section_11.InterfaceExercise;

import java.util.List;

public interface ISaveable {
    List<String> write();
    void read(List<String> list);
}
