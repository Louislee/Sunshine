package android.lee.sunshine;

import android.test.suitebuilder.TestSuiteBuilder;

import junit.framework.Test;

/**
 * Created by chuanl on 8/7/14.
 */
public class FullTestSuite {

   public static Test suite(){
      return new TestSuiteBuilder(FullTestSuite.class)
              .includeAllPackagesUnderHere().build();
   }

   public FullTestSuite(){
      super();
   }
}
