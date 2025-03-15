package bentfores.goods.and.seller.management.server.controller.v1

import bentfores.goods.and.seller.management.api.model.ProductStatusEnum
import bentfores.goods.and.seller.management.api.model.ProductsResponse
import bentfores.goods.and.seller.management.api.v1.ProductsApi
import bentfores.goods.and.seller.management.server.service.v1.ProductServiceV1
import bentfores.goods.and.seller.management.server.service.v1.SupplierServiceV1
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductsController(
  private val productServiceV1: ProductServiceV1
) : ProductsApi {

  override fun productsByGet(status: ProductStatusEnum): ResponseEntity<ProductsResponse> {
    return ResponseEntity.ok(
      productServiceV1.getProducts(status)
    )
  }
}