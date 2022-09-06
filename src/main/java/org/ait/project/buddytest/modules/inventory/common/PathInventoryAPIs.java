package org.ait.project.buddytest.modules.inventory.common;

/**.
 * Class Path Inventory APIs
 */
public class PathInventoryAPIs {

    /**.
    * Base endpoint for inventory controller
    */
    public static final String BASE_INVENTORY = "/inventories";

    /**.
     * Endpoint for find all data inventories
     * Method type GET
     */
    public static final String FIND_ALL = BASE_INVENTORY;

    /**.
     * Endpoint for find all data inventories for pagination
     * Method type GET
     */
    public static final String FIND_ALL_WITH_PAGE =  BASE_INVENTORY + "/page";

    /**.
     * Endpoint for find one data inventory by id
     * Method type GET
     */
    public static final String FIND_ONE =  BASE_INVENTORY +  "/{id}";

    /**.
     * Endpoint for create a new inventory
     * Method type POST
     */
    public static final String CREATE = BASE_INVENTORY + "/create";

    /**.
     * Endpoint for update data inventory by id
     * Method type PUT
     */
    public static final String UPDATE =  BASE_INVENTORY + "/update/{id}";

    /**.
     * Endpoint for delete data inventory by id
     * Method type DELETE
     */
    public static final String DELETE =  BASE_INVENTORY + "/delete/{id}";

}
