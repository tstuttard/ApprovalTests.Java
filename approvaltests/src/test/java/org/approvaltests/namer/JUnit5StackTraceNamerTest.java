package org.approvaltests.namer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class JUnit5StackTraceNamerTest
{

  @Test
  public void testGetApprovalName()
  {
    StackTraceNamerUtils.assertNamerForFramework(getClass().getSimpleName(), "testGetApprovalName");
  }
  @ParameterizedTest
  @ValueSource(strings = {"A", "B"})
  public void parameterizedTest(String input)
  {
    StackTraceNamerUtils.assertParameterizedTest(getClass().getSimpleName(), "parameterizedTest", input);
  }
  @Nested
  class NestedTests
  {
    @Test
    void nestedTest()
    {
      String className = JUnit5StackTraceNamerTest.class.getSimpleName() + "." + getClass().getSimpleName();
      StackTraceNamerUtils.assertApprovalName(className, "nestedTest");
    }
  }
}
