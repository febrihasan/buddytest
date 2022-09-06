package org.ait.project.buddytest.modules.order.common;

/**.
 * Class Path Order APIs
 */
public class PathOrderAPIs {

    /**.
    * Base endpoint for order controller
    */
    public static final String BASE_ORDER = "/orders";

    /**.
     * Endpoint for find all data orders
     * Method type GET
     */
    public static final String FIND_ALL = BASE_ORDER;

    /**.
     * Endpoint for find all data order details
     * Method type GET
     */
    public static final String FIND_ALL_DETAIL = BASE_ORDER + "/{orderId}/order-details";

    /**.
     * Endpoint for find all data orders for pagination
     * Method type GET
     */
    public static final String FIND_ALL_WITH_PAGE = BASE_ORDER + "/page";

    /**.
     * Endpoint for find one data order by id
     * Method type GET
     */
    public static final String FIND_ONE = BASE_ORDER + "/{id}";

    /**.
     * Endpoint for find one data order by id
     * Method type GET
     */
    public static final String FIND_ONE_DETAIL = BASE_ORDER + "/{orderId}/order-details/{id}";

    /**.
     * Endpoint for create a new order
     * Method type POST
     */
    public static final String CREATE = BASE_ORDER + "/create";

    /**.
     * Endpoint for create a new order detail
     * Method type POST
     */
    public static final String CREATE_DETAIL = BASE_ORDER + "/create/{orderId}/order-details";

    /**.
     * Endpoint for update data order by id
     * Method type PUT
     */
    public static final String UPDATE = BASE_ORDER + "/update/{id}";

    /**.
     * Endpoint for update data order detail by id
     * Method type PUT
     */
    public static final String UPDATE_DETAIL = BASE_ORDER + "/update/{orderId}/order-details/{id}";

    /**.
     * Endpoint for delete data order by id
     * Method type DELETE
     */
    public static final String DELETE = BASE_ORDER + "/delete/{id}";

    /**.
     * Endpoint for delete data order detail by id
     * Method type DELETE
     */
    public static final String DELETE_DETAIL = BASE_ORDER + "/delete/{orderId}/order-details/{id}";

}
