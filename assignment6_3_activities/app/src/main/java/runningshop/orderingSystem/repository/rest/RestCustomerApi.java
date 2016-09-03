package runningshop.orderingSystem.repository.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import runningshop.orderingSystem.domain.customer.Customer;
import runningshop.orderingSystem.repository.RestApi;
import runningshop.orderingSystem.repository.customer.CustomerRepository;

/**
 * Created by Siraaj on 09/02/2016.
 */



public class RestCustomerApi implements RestApi<Customer,Long> {

    final String BASE_URL="http://148.100.5.73:8080/shop/";
    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();


    @Override
    public Customer get(Long id) {
        final String url = BASE_URL+"customer/"+id.toString();
        HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(requestHeaders);
        ResponseEntity<Customer> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Customer.class);
        Customer customer = responseEntity.getBody();
        return customer;
    }

    @Override
    public String post(Customer entity) {
        final String url = BASE_URL+"customer/create";
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Customer> httpEntity = new HttpEntity<>(entity,headers);
        String result = rest.postForObject(url, httpEntity, String.class);

        return result;
    }

    @Override
    public String put(Customer entity) {

        final String url = BASE_URL+"customer/update/"+entity.getCustomerCode().toString();
        HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Customer entity) {
       /* final String url = BASE_URL+"book/delete/"+entity.getCustomerCode().toString();
        HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();*/
        return null;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        final String url = BASE_URL+"customer/findAll";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Customer[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Customer[].class);
        Customer[] results = responseEntity.getBody();

        for (Customer c: results) {
            customers.add(c);
        }
        return customers;
    }
}
