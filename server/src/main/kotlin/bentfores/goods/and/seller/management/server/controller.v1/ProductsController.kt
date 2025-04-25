package bentfores.goods.and.seller.management.server.controller.v1

import bentfores.goods.and.seller.management.api.model.ProductStatusEnum
import bentfores.goods.and.seller.management.api.model.ProductsInfo
import bentfores.goods.and.seller.management.api.v1.ProductsApi
import bentfores.goods.and.seller.management.server.service.v1.ProductServiceV1
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductsController(
  private val productServiceV1: ProductServiceV1
) : ProductsApi {

  override fun productsByGet(status: ProductStatusEnum): ResponseEntity<List<ProductsInfo>> {
    return ResponseEntity.ok(
      productServiceV1.getProducts(status)
    )
  }

  override fun productsByPatch(status: ProductStatusEnum, articles: List<String>): ResponseEntity<Unit> {
    productServiceV1.patchProducts(status, articles)
    return ResponseEntity.status(200).build()
  }

  override fun productByGet(article: String): ResponseEntity<ProductsInfo> {
    return ResponseEntity.ok(
      productServiceV1.getProduct(article)
    )
  }
}