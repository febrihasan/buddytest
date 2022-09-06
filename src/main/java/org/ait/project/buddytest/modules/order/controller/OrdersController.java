package org.ait.project.buddytest.modules.order.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.order.common.PathOrderAPIs;
import org.ait.project.buddytest.modules.order.dto.request.OrdersRequestDto;
import org.ait.project.buddytest.modules.order.dto.response.OrdersResponseDto;
import org.ait.project.buddytest.modules.order.service.internal.OrdersService;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**.
 * Class Rest Controller of Orders
 */
@RestController
@RequiredArgsConstructor
public class OrdersController {

    /**.
     *  Get function Order Service
     */
    private final OrdersService ordersService;

    /**.
     *  Api for Get all orders
     */
    @Operation(summary = "Get all orders",
            description = "Retrieve a list of all orders")
    @GetMapping(PathOrderAPIs.FIND_ALL)
    public ResponseEntity<ResponseTemplate<ResponseList<OrdersResponseDto>>>
        getAllOrders() {
        return ordersService.getAllOrders();
    }

    /**.
     *  Api for Get all orders with pagination
     * @param page number
     */
    @Operation(summary = "Get all orders by page",
            description = "Retrieves a list of all orders with pagination")
    @GetMapping(PathOrderAPIs.FIND_ALL_WITH_PAGE)
    public ResponseEntity<ResponseTemplate<ResponseList<OrdersResponseDto>>>
        getAllOrdersWithPage(final Pageable page) {
        return ordersService.getAllOrdersWithPage(page);
    }

    /**.
     *  Api for Get a order
     * @param id
     */
    @Operation(summary = "Get order by id",
            description = "Retrieves a spesific order by id")
    @GetMapping(PathOrderAPIs.FIND_ONE)
    public OrdersResponseDto getOrderById(final @PathVariable Long id) {
        return ordersService.getOrderById(id);
    }

    /**.
     *  Api for Create a new order
     * @param orderDto
     */
    @Operation(summary = "Create new order",
            description = "Create a new order")
    @PostMapping(PathOrderAPIs.CREATE)
    public void createOrder(final @RequestBody OrdersRequestDto orderDto) {
        ordersService.createOrder(orderDto);
    }

    /**.
     *  Api for Update a product
     * @param id
     * @param orderDto
     */
    @Operation(summary = "Update product",
            description = "Update a product")
    @PutMapping(PathOrderAPIs.UPDATE)
    public OrdersResponseDto updateOrder(final @RequestBody OrdersRequestDto orderDto,
                                            final @PathVariable Long id) {
        return ordersService.updateOrder(orderDto, id);
    }

    /**.
     *  Api for Delete a order
     * @param id
     */
    @Operation(summary = "Delete order",
            description = "Delete a order")
    @DeleteMapping(PathOrderAPIs.DELETE)
    public void deleteProduct(final @PathVariable Long id) {
        ordersService.deleteOrder(id);
    }

}