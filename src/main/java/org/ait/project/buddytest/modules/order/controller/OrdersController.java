package org.ait.project.buddytest.modules.order.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.order.common.PathOrderAPIs;
import org.ait.project.buddytest.modules.order.dto.request.OrderDetailsRequestDto;
import org.ait.project.buddytest.modules.order.dto.request.OrdersRequestDto;
import org.ait.project.buddytest.modules.order.dto.response.OrderDetailsResponseDto;
import org.ait.project.buddytest.modules.order.dto.response.OrdersResponseDto;
import org.ait.project.buddytest.modules.order.service.internal.OrderDetailsService;
import org.ait.project.buddytest.modules.order.service.internal.OrdersService;
import org.ait.project.buddytest.shared.dto.template.ResponseDetail;
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
     *  Get function Order Detail Service
     */
    private final OrderDetailsService orderDetailsService;

    /**.
     *  Api for Get all orders
     * @return all data orders
     */
    @Operation(summary = "Get all orders",
            description = "Retrieve a list of all orders")
    @GetMapping(PathOrderAPIs.FIND_ALL)
    public ResponseEntity<ResponseTemplate<ResponseList<OrdersResponseDto>>>
        getAllOrders() {
        return ordersService.getAllOrders();
    }

    /**.
     *  Api for Get all order details
     * @param orderId
     * @return all data order details by orderId
     */
    @Operation(summary = "Get all order details",
            description = "Retrieve a list of all order details")
    @GetMapping(PathOrderAPIs.FIND_ALL_DETAIL)
    public ResponseEntity<ResponseTemplate<ResponseList<OrderDetailsResponseDto>>>
    getAllOrderDetails(final @PathVariable Long orderId) {
        return orderDetailsService.getAllOrderDetails(orderId);
    }

    /**.
     *  Api for Get all orders with page
     * @param page number
     * @return all data orders with pagination
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
     * @return data order
     */
    @Operation(summary = "Get order by id",
            description = "Retrieves a spesific order by id")
    @GetMapping(PathOrderAPIs.FIND_ONE)
    public ResponseEntity<ResponseTemplate<ResponseDetail<OrdersResponseDto>>>
        getOrderById(final @PathVariable Long id) {
        return ordersService.getOrderById(id);
    }

    /**.
     *  Api for Get a order detail
     * @param orderId
     * @param id
     * @return data order detail
     */
    @Operation(summary = "Get order detail by id",
            description = "Retrieves a spesific order detail by id")
    @GetMapping(PathOrderAPIs.FIND_ONE_DETAIL)
    public ResponseEntity<ResponseTemplate<ResponseDetail<OrderDetailsResponseDto>>>
        getOrderDetailById(final @PathVariable Long orderId, final @PathVariable Long id) {
        return orderDetailsService.getOrderDetailById(orderId, id);
    }

    /**.
     *  Api for Create a new order
     * @param orderDto
     * @return new data order
     */
    @Operation(summary = "Create new order",
            description = "Create a new order")
    @PostMapping(PathOrderAPIs.CREATE)
    public ResponseEntity<ResponseTemplate<ResponseDetail<OrdersResponseDto>>>
        createOrder(final @RequestBody OrdersRequestDto orderDto) {
        return ordersService.createOrder(orderDto);
    }

    /**.
     *  Api for Create a new order detail
     * @param orderDetailDto
     * @param orderId
     * @return new data order detail
     */
    @Operation(summary = "Create new order detail",
            description = "Create a new order detail")
    @PostMapping(PathOrderAPIs.CREATE_DETAIL)
    public ResponseEntity<ResponseTemplate<ResponseDetail<OrderDetailsResponseDto>>>
        createOrderDetail(final @RequestBody OrderDetailsRequestDto orderDetailDto,
                                  final @PathVariable Long orderId) {
        return orderDetailsService.createOrderDetail(orderDetailDto, orderId);
    }

    /**.
     *  Api for Update a order
     * @param id
     * @param orderDto
     * @return update order
     */
    @Operation(summary = "Update order",
            description = "Update a order")
    @PutMapping(PathOrderAPIs.UPDATE)
    public ResponseEntity<ResponseTemplate<ResponseDetail<OrdersResponseDto>>>
        updateOrder(final @RequestBody OrdersRequestDto orderDto,
                                            final @PathVariable Long id) {
        return ordersService.updateOrder(orderDto, id);
    }

    /**.
     *  Api for Update a order detail
     * @param orderDetailDto
     * @param orderId
     * @param id
     * @return data order detail
     */
    @Operation(summary = "Update order detail",
            description = "Update a order detail")
    @PutMapping(PathOrderAPIs.UPDATE_DETAIL)
    public ResponseEntity<ResponseTemplate<ResponseDetail<OrderDetailsResponseDto>>>
        updateOrderDetail(final @RequestBody OrderDetailsRequestDto orderDetailDto,
                                                     final @PathVariable Long orderId, final @PathVariable Long id) {
        return orderDetailsService.updateOrderDetail(orderDetailDto, orderId, id);
    }

    /**.
     *  Api for Delete a order
     * @param id
     */
    @Operation(summary = "Delete order",
            description = "Delete a order")
    @DeleteMapping(PathOrderAPIs.DELETE)
    public void deleteOrder(final @PathVariable Long id) {
        ordersService.deleteOrder(id);
    }

    /**.
     *  Api for Delete a order detail
     * @param orderId
     * @param id
     */
    @Operation(summary = "Delete order detail",
            description = "Delete a order detail")
    @DeleteMapping(PathOrderAPIs.DELETE_DETAIL)
    public void deleteOrderDetail(final @PathVariable Long orderId, final @PathVariable Long id) {
        orderDetailsService.deleteOrderDetail(orderId, id);
    }

}