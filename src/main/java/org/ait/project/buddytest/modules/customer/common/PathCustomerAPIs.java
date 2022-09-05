package org.ait.project.buddytest.modules.customer.common;

public class PathCustomerAPIs {

    /**
    * Base endpoint for customer controller
    */
    public static final String BASE_CUSTOMER = "/customers";

    /**
     * Endpoint for find all data customers
     * @method GET
     * @return all data customers
     */
    public static final String FIND_ALL = BASE_CUSTOMER;

    /**
     * Endpoint for find all data customers for pagination
     * @method GET
     * @return all data customers
     */
    public static final String FIND_ALL_WITH_PAGE = BASE_CUSTOMER + "/page";

    /**
     * Endpoint for find one data customer by id
     * @method GET
     * @param id customer
     * @return one data customer
     */
    public static final String FIND_ONE = BASE_CUSTOMER +  "/{id}";

    /**
     * Endpoint for create a new customer
     * @method POST
     * @param new customer
     * @return data new customer
     */
    public static final String CREATE = BASE_CUSTOMER;

    /**
     * Endpoint for update data customer by id
     * @method PUT
     * @param data customer
     * @param id customer
     * @return update data customer
     */
    public static final String UPDATE = BASE_CUSTOMER + "/update/{id}";

    /**
     * Endpoint for delete data customer by id
     * @method DELETE
     * @param id customer
     * @return delete data customer
     */
    public static final String DELETE = BASE_CUSTOMER + "/delete/{id}";

}
