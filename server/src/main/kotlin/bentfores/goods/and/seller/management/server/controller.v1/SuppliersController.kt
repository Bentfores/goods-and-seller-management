package bentfores.goods.and.seller.management.server.controller.v1

import bentfores.goods.and.seller.management.api.model.SupplierStatusEnum
import bentfores.goods.and.seller.management.api.model.SuppliersResponse
import bentfores.goods.and.seller.management.api.v1.SuppliersApi
import bentfores.goods.and.seller.management.server.service.v1.SupplierServiceV1
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class SuppliersController(
  private val supplierServiceV1: SupplierServiceV1
) : SuppliersApi {

  override fun suppliersByGet(status: List<SupplierStatusEnum>): ResponseEntity<SuppliersResponse> {
    return ResponseEntity.ok(
      supplierServiceV1.getSuppliers(status)
    )
  }
}