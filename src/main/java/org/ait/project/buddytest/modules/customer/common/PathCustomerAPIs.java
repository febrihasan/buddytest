package org.ait.project.buddytest.modules.customer.common;

public class PathCustomerAPIs {

    /**
    * Base endpoint for customer controller
    */
    public static final String base = "/customers";

    /**
     * Endpoint for find all data customers
     * @return all data customers
     */
    public static final String findAll = base;

    /**
     * Endpoint for find one data customer by id
     * @param id customer
     * @return one data customer
     */
    public static final String findOne = base +  "/customers/{id}";

    /**
     * Endpoint for create a new customer
     * @param new customer
     * @return data new customer
     */
    public static final String create = base +  "/customers";

    /**
     * Endpoint for update data customer by id
     * @param data customer
     * @param id customer
     * @return update data customer
     */
    public static final String update = base +  "/customers/{id}";

    /**
     * Endpoint for delete data customer by id
     * @param id customer
     * @return delete data customer
     */
    public static final String delete = base +  "/customers/{id}";

}
