package Steps;

import com.google.gson.Gson;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;


public class MySteps {

    @Test
    @Given("^I have http client$")
    public void iHaveHttpClient() throws Throwable {


    }

    @When("^Call (\\S+) healthcheck$")
    public void callSimpleCalculationHealthcheck(String serviceName) throws Throwable {


    }


    @Then("^http client return true$")
    public void httpClientReturnTrue() throws Throwable {

    }
}
