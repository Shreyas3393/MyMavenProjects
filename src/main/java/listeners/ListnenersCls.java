package listeners;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.ListenersProg.class)

public class ListnenersCls {
	
  @Test
  public void A() 
  {
	  Reporter.log("A is Running", true);
  }
	
  @Test
  public void B() 
  {
	  Assert.fail();
	  Reporter.log("B is Running", true); 
  }
	
  @Test(dependsOnMethods = {"B"}) 
  public void C() 
  {
	  Reporter.log("C is Running", true);
  }
	
  @Test
  public void D() 
  {
	  Reporter.log("D is Running", true);
  }

}
