package org.ait.project.buddytest.modules.payment.common;

/**.
 * Class Path Payment APIs
 */
public class PathPaymentAPIs {

    /**.
    * Base endpoint for payment controller
    */
    public static final String BASE_PAYMENT = "/payments";

    /**.
     * Endpoint for find all data orders
     * Method type GET
     */
    public static final String FIND_ALL = BASE_PAYMENT;

    /**.
     * Endpoint for find all data orders for pagination
     * Method type GET
     */
    public static final String FIND_ALL_WITH_PAGE = BASE_PAYMENT + "/page";

    /**.
     * Endpoint for create payment
     * Method type POST
     */
    public static final String CREATE = BASE_PAYMENT + "/create";

    /**.
     * Endpoint for preview / check status payment by reference number
     * Method type GET
     */
    public static final String PREVIEW = BASE_PAYMENT +  "/preview/{referenceNumber}";

    /**.
     * Endpoint for posting payment
     * Method type PUT
     */
    public static final String POSTING = BASE_PAYMENT + "/posting/{referenceNumber}";

    /**.
     * Endpoint for cancel payment by reference_number
     * Method type DELETE
     */
    public static final String CANCEL = BASE_PAYMENT + "/cancel/{referenceNumber}";

}
