package tinyscalautils.java;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Java wrappers for text functions.
 * <p>
 * This class cannot be instantiated.
 * </p>
 *
 * @see <a href="https://charpov.github.io/TinyScalaUtils/tinyscalautils/text.html">
 * tinyscalautils.text
 * </a>
 * @since 1.0
 */
public final class Text {
  private Text() {
    throw new AssertionError("this class cannot be instantiated");
  }

  /**
   * Silent mode.
   *
   * @see <a href="https://charpov.github.io/TinyScalaUtils/tinyscalautils/text/silentdMode$.html">
   * tinyscalautils.text.silentMode
   * </a>
   */
  public final static class SILENT_MODE {
    private SILENT_MODE() {
      throw new AssertionError("this class cannot be instantiated");
    }

    public static void print(Object ignoredArg) {
    }

    public static void println(Object ignoredArg) {
    }

    // added so SILENT_MODE.println() can easily replace STANDARD_MODE.println()
    public static void println() {
    }

    public static void printf(String ignoredFormat, Object... ignoredArgs) {
    }
  }

  /**
   * Standard mode.
   *
   * @see <a href="https://charpov.github.io/TinyScalaUtils/tinyscalautils/text/standardMode$.html">
   * tinyscalautils.text.standardMode
   * </a>
   */
  public final static class STANDARD_MODE {
    private STANDARD_MODE() {
      throw new AssertionError("this class cannot be instantiated");
    }

    public static void print(Object arg) {
      textScala.standardMode().print(arg, false);
    }

    public static void println(Object arg) {
      textScala.standardMode().print(arg, true);
    }

    // added so STANDARD_MODE.println() can easily replace System.out.println()
    public static void println() {
      println("");
    }

    public static void printf(String format, Object... arg) {
      textScala.standardMode().print(String.format(format, arg), false);
    }
  }

  /**
   * Thread mode.
   *
   * @see <a href="https://charpov.github.io/TinyScalaUtils/tinyscalautils/text/threadMode$.html">
   * tinyscalautils.text.threadMode
   * </a>
   */
  public final static class THREAD_MODE {
    private THREAD_MODE() {
      throw new AssertionError("this class cannot be instantiated");
    }

    public static void print(Object arg) {
      textScala.threadMode().print(arg, false);
    }

    public static void println(Object arg) {
      textScala.threadMode().print(arg, true);
    }

    public static void printf(String format, Object... arg) {
      textScala.threadMode().print(String.format(format, arg), false);
    }
  }

  /**
   * Thread-time (demo) mode.
   *
   * @see 
   * <a href="https://charpov.github.io/TinyScalaUtils/tinyscalautils/text/threadTimeDemoMode$.html">
   * tinyscalautils.text.threadTimeDemoMode
   * </a>
   */
  public final static class THREAD_TIME_DEMO_MODE {
    private THREAD_TIME_DEMO_MODE() {
      throw new AssertionError("this class cannot be instantiated");
    }

    public static void print(Object arg) {
      textScala.threadTimeDemoMode().print(arg, false);
    }

    public static void println(Object arg) {
      textScala.threadTimeDemoMode().print(arg, true);
    }

    public static void printf(String format, Object... arg) {
      textScala.threadTimeDemoMode().print(String.format(format, arg), false);
    }
  }

  /**
   * Thread-time mode.
   *
   * @see 
   * <a href="https://charpov.github.io/TinyScalaUtils/tinyscalautils/text/threadTimeMode$.html">
   * tinyscalautils.text.threadTimeMode
   * </a>
   */
  public final static class THREAD_TIME_MODE {
    private THREAD_TIME_MODE() {
      throw new AssertionError("this class cannot be instantiated");
    }

    public static void print(Object arg) {
      textScala.threadTimeMode().print(arg, false);
    }

    public static void println(Object arg) {
      textScala.threadTimeMode().print(arg, true);
    }

    public static void printf(String format, Object... arg) {
      textScala.threadTimeMode().print(String.format(format, arg), false);
    }
  }

  /**
   * Time (demo) mode.
   *
   * @see <a href="https://charpov.github.io/TinyScalaUtils/tinyscalautils/text/timeDemoMode$.html">
   * tinyscalautils.text.timeDemoMode
   * </a>
   */
  public final static class TIME_DEMO_MODE {
    private TIME_DEMO_MODE() {
      throw new AssertionError("this class cannot be instantiated");
    }

    public static void print(Object arg) {
      textScala.timeDemoMode().print(arg, false);
    }

    public static void println(Object arg) {
      textScala.timeDemoMode().print(arg, true);
    }

    public static void printf(String format, Object... arg) {
      textScala.timeDemoMode().print(String.format(format, arg), false);
    }
  }

  /**
   * Time mode.
   *
   * @see <a href="https://charpov.github.io/TinyScalaUtils/tinyscalautils/text/timeMode$.html">
   * tinyscalautils.text.timeMode
   * </a>
   */
  public final static class TIME_MODE {
    private TIME_MODE() {
      throw new AssertionError("this class cannot be instantiated");
    }

    public static void print(Object arg) {
      textScala.timeMode().print(arg, false);
    }

    public static void println(Object arg) {
      textScala.timeMode().print(arg, true);
    }

    public static void printf(String format, Object... arg) {
      textScala.timeMode().print(String.format(format, arg), false);
    }
  }

  private static final TextScala textScala = new TextScala();

  /**
   * @apiNote Contrary to the Scala variant, this method sets {@code includeSystem} to true by
   * default.
   */
  public static String printout(Runnable code) {
    return printout(false, true, StandardCharsets.UTF_8, code);
  }

  public static String printout(boolean includeErr, boolean includeSystem, Runnable code) {
    return printout(includeErr, includeSystem, StandardCharsets.UTF_8, code);
  }

  public static String printout(boolean includeErr, boolean includeSystem, Charset charset,
                                Runnable code) {
    return textScala.printout(code, includeErr, includeSystem, charset);
  }

  public static void info() {
    textScala.info();
  }

  public static void info(int newlines) {
    textScala.info(newlines);
  }

  public static String plural(Number x, String singularForm, String pluralForm) {
    return textScala.plural(x, singularForm, pluralForm);
  }

  public static String plural(Number x, String singularForm) {
    return textScala.plural(x, singularForm);
  }

  public static String timeString(double seconds, int unitsCount) {
    return textScala.timeString(seconds, unitsCount);
  }

  public static String timeString(double seconds) {
    return timeString(seconds, 2);
  }
}
