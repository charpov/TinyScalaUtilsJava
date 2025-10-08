import org.junit.jupiter.api.Test;
import tinyscalautils.java.Text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static tinyscalautils.java.Text.*;

public class TextSuite {
  private String thread() {
    return Thread.currentThread().getName();
  }

  @Test
  void testSilent() {
    assertTrue(printout(() -> SILENT_MODE.print("X")).isEmpty());
    assertTrue(printout(() -> SILENT_MODE.println("X")).isEmpty());
    assertTrue(printout(() -> SILENT_MODE.println()).isEmpty());
    assertTrue(printout(() -> SILENT_MODE.printf("%s", "X")).isEmpty());
  }

  @Test
  void testStandard() {
    assertEquals("X", printout(() -> STANDARD_MODE.print("X")));
    assertEquals("X\n", printout(() -> STANDARD_MODE.println("X")));
    assertEquals("\n", printout(() -> STANDARD_MODE.println()));
    assertEquals("X", printout(() -> STANDARD_MODE.printf("%s", "X")));
  }

  @Test
  void testThread() {
    assertEquals(thread() + ": X", printout(() -> THREAD_MODE.print("X")));
    assertEquals(thread() + ": X\n", printout(() -> THREAD_MODE.println("X")));
    assertEquals(thread() + ": X", printout(() -> THREAD_MODE.printf("%s", "X")));
  }

  @Test
  void testTime() {
    var str = printout(() -> TIME_MODE.print("X"));
    assertTrue(str.startsWith("at ") && str.endsWith(": X"));
    str = printout(() -> TIME_MODE.println("X"));
    assertTrue(str.startsWith("at ") && str.endsWith(": X\n"));
    str = printout(() -> TIME_MODE.printf("%s", "X"));
    assertTrue(str.startsWith("at ") && str.endsWith(": X"));
  }

  @Test
  void testTimeDemo() {
    var str = printout(() -> TIME_DEMO_MODE.print("X"));
    assertTrue(str.startsWith("at XX:XX:") && str.endsWith(": X"));
    str = printout(() -> TIME_DEMO_MODE.println("X"));
    assertTrue(str.startsWith("at XX:XX:") && str.endsWith(": X\n"));
    str = printout(() -> TIME_DEMO_MODE.printf("%s", "X"));
    assertTrue(str.startsWith("at XX:XX:") && str.endsWith(": X"));
  }

  @Test
  void testThreadTime() {
    var str = printout(() -> THREAD_TIME_MODE.print("X"));
    assertTrue(str.startsWith(thread() + " at ") && str.endsWith(": X"));
    str = printout(() -> THREAD_TIME_MODE.println("X"));
    assertTrue(str.startsWith(thread() + " at ") && str.endsWith(": X\n"));
    str = printout(() -> THREAD_TIME_MODE.printf("%s", "X"));
    assertTrue(str.startsWith(thread() + " at ") && str.endsWith(": X"));
  }

  @Test
  void testThreadTimeDemo() {
    var str = printout(() -> THREAD_TIME_DEMO_MODE.print("X"));
    assertTrue(str.startsWith(thread() + " at XX:XX:") && str.endsWith(": X"));
    str = printout(() -> THREAD_TIME_DEMO_MODE.println("X"));
    assertTrue(str.startsWith(thread() + " at XX:XX:") && str.endsWith(": X\n"));
    str = printout(() -> THREAD_TIME_DEMO_MODE.printf("%s", "X"));
    assertTrue(str.startsWith(thread() + " at XX:XX:") && str.endsWith(": X"));
  }

  @Test
  void testPlural() {
    assertEquals("cat", plural(1, "cat"));
    assertEquals("cats", plural(2, "cat"));
    assertEquals("DOGS", plural(2L, "DOG"));
    assertEquals("platypuses", plural(2.3, "platypus"));
    assertEquals("mice", plural(2, "mouse", "mice"));
  }

  @Test
  void testInfo() {
    var lines = printout(Text::info).lines().toList();
    assertEquals(4, lines.size());
    assertTrue(lines.get(0).contains("Java"));
    assertTrue(lines.get(2).endsWith("processors") || lines.get(2).endsWith("processor"));
    assertTrue(lines.get(3).endsWith("maximum memory"));
  }

  @Test
  void testInfoNewlines() {
    var lines = printout(() -> Text.info(2)).lines().toList();
    assertEquals(6, lines.size());
    assertTrue(lines.get(0).contains("Java"));
    assertTrue(lines.get(2).endsWith("processors") || lines.get(2).endsWith("processor"));
    assertTrue(lines.get(3).endsWith("maximum memory"));
    assertTrue(lines.get(4).isEmpty());
    assertTrue(lines.get(5).isEmpty());
  }

  @Test
  void testTimeString() {
    assertEquals("3 minutes, 20 milliseconds", timeString(180.02));
    assertEquals("1 hour, 10 seconds", timeString(3609.732));
    assertEquals("1 hour, 9 seconds, 732 milliseconds", timeString(3609.732, 3));
    assertEquals("1 hour", timeString(3609.732, 1));
  }
}
