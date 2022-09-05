package org.ait.project.buddytest.modules.customer.common;

/**.
 * Class Path Customer APIs
 */
public class PathCustomerAPIs {

    /**.
    * Base endpoint for customer controller
    */
    public static final String BASE_CUSTOMER = "/customers";

    /**.
     * Endpoint for find all data customers
     * Method type GET
     */
    public static final String FIND_ALL = BASE_CUSTOMER;

    /**.
     * Endpoint for find all data customers for pagination
     */
    public static final String FIND_ALL_WITH_PAGE = BASE_CUSTOMER + "/page";

    /**.
     * Endpoint for find one data customer by id
     * Method type GET
     */
    public static final String FIND_ONE = BASE_CUSTOMER +  "/{id}";

    /**.
     * Endpoint for create a new customer
     * Method type POST
     */
    public static final String CREATE = BASE_CUSTOMER + "/create";

    /**.
     * Endpoint for update data customer by id
     * Method type PUT
     */
    public static final String UPDATE = BASE_CUSTOMER + "/update/{id}";

    /**.
     * Endpoint for delete data customer by id
     * Method type DELETE
     */
    public static final String DELETE = BASE_CUSTOMER + "/delete/{id}";

}
