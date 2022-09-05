package org.ait.project.buddytest.modules.product.common;

/**.
 * Class Path Product APIs
 */
public class PathProductAPIs {

    /**.
    * Base endpoint for product controller
    */
    public static final String BASE_PRODUCT = "/products";

    /**.
     * Endpoint for find all data products
     * Method type GET
     */
    public static final String FIND_ALL = BASE_PRODUCT;

    /**.
     * Endpoint for find all data products for pagination
     * Method type GET
     */
    public static final String FIND_ALL_WITH_PAGE = BASE_PRODUCT + "/page";

    /**.
     * Endpoint for find one data product by id
     * Method type GET
     */
    public static final String FIND_ONE = BASE_PRODUCT +  "/{id}";

    /**.
     * Endpoint for create a new product
     * Method type POST
     */
    public static final String CREATE = BASE_PRODUCT + "/create";

    /**.
     * Endpoint for update data product by id
     * Method type PUT
     */
    public static final String UPDATE = BASE_PRODUCT + "/update/{id}";

    /**.
     * Endpoint for delete data product by id
     * Method type DELETE
     */
    public static final String DELETE = BASE_PRODUCT + "/delete/{id}";

}
