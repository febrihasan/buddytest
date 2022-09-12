package org.ait.project.buddytest.shared.openfeign.payment.common;

/**.
 * Class Path Payment Client APIs
 */
public class PathPaymentClientAPIs {

    /**.
    * Base endpoint for payment client
    */
    public static final String BASE_PAYMENT = "/payment";

    /**.
     * Endpoint for posting payment
     * Method type POST
     */
    public static final String POSTING = BASE_PAYMENT + "/posting";

    /**.
     * Endpoint for preview / check status payment by reference number
     * Method type GET
     */
    public static final String PREVIEW = BASE_PAYMENT +  "/preview";

    /**.
     * Endpoint for cancel payment by reference_number
     * Method type DELETE
     */
    public static final String CANCEL = BASE_PAYMENT + "/cancel";

}
