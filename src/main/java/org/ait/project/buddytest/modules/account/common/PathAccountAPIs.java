package org.ait.project.buddytest.modules.account.common;

/**.
 * Class Path Account APIs
 */
public class PathAccountAPIs {

    /**.
    * Base endpoint for account controller
    */
    public static final String BASE_ACCOUNT = "/accounts";

    /**.
     * Endpoint for find all data accounts
     * Method type GET
     */
    public static final String FIND_ALL = BASE_ACCOUNT;

    /**.
     * Endpoint for find all data accounts for pagination
     * Method type GET
     */
    public static final String FIND_ALL_WITH_PAGE =  BASE_ACCOUNT + "/page";

    /**.
     * Endpoint for find one data account by id
     * Method type GET
     */
    public static final String FIND_ONE =  BASE_ACCOUNT +  "/{id}";

    /**.
     * Endpoint for create a new account
     * Method type POST
     */
    public static final String CREATE = BASE_ACCOUNT + "/create";

    /**.
     * Endpoint for update data account by id
     * Method type PUT
     */
    public static final String UPDATE =  BASE_ACCOUNT + "/update/{id}";

    /**.
     * Endpoint for update data account by id
     * Method type PUT
     */
    public static final String UPDATE_BALANCE =  BASE_ACCOUNT + "/update/balance/{customerId}";

    /**.
     * Endpoint for delete data account by id
     * Method type DELETE
     */
    public static final String DELETE =  BASE_ACCOUNT + "/delete/{id}";

}
