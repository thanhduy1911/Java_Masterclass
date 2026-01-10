package dev.duyhvt.test.potd;

import dev.duyhvt.coding.potd._712_MinimumASCIIDeleteSumForTwoStrings;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class _712_MinimumASCIIDeleteSumForTwoStringsTest {

  @Test
  void example1() {
    _712_MinimumASCIIDeleteSumForTwoStrings sol = new _712_MinimumASCIIDeleteSumForTwoStrings();
    assertEquals(231, sol.minimumDeleteSum("sea", "eat"));
  }

  @Test
  void example2() {
    _712_MinimumASCIIDeleteSumForTwoStrings sol = new _712_MinimumASCIIDeleteSumForTwoStrings();
    assertEquals(403, sol.minimumDeleteSum("delete", "leet"));
  }

  @Test
  void emptyString() {
    _712_MinimumASCIIDeleteSumForTwoStrings sol = new _712_MinimumASCIIDeleteSumForTwoStrings();
    assertEquals((int) 'a' + (int) 'b' + (int) 'c', sol.minimumDeleteSum("", "abc"));
  }

  @Test
  void alreadyEqual() {
    _712_MinimumASCIIDeleteSumForTwoStrings sol = new _712_MinimumASCIIDeleteSumForTwoStrings();
    assertEquals(0, sol.minimumDeleteSum("abc", "abc"));
  }
}
