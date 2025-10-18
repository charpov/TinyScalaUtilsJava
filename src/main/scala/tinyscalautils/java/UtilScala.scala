package tinyscalautils.java

import tinyscalautils.util.pow
import tinyscalautils.util.isPowerOf2

private final class UtilScala:
   def pow(n: Int, m: Int): Int   = n.pow(m)
   def pow(n: Long, m: Int): Long = n.pow(m)

   def isPowerOf2(n: Int): Boolean = n.isPowerOf2
   def isPowerOf2(n: Long): Boolean = n.isPowerOf2
