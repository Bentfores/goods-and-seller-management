package bentfores.goods.and.seller.management.server.controller.v1

import bentfores.goods.and.seller.management.api.model.ManagementSuppliersInfo
import bentfores.goods.and.seller.management.api.model.NewSupplierInfo
import bentfores.goods.and.seller.management.api.model.SupplierStatusEnum
import bentfores.goods.and.seller.management.api.v1.SuppliersApi
import bentfores.goods.and.seller.management.server.service.v1.SupplierServiceV1
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.util.UUID

@RestController
class SuppliersController(
  private val supplierServiceV1: SupplierServiceV1
) : SuppliersApi {

  override fun suppliersByGet(statuses: List<SupplierStatusEnum>): ResponseEntity<List<ManagementSuppliersInfo>> {
    return ResponseEntity.ok(
      supplierServiceV1.getSuppliers(statuses)
    )
  }

  override fun suppliersByPatch(
    status: SupplierStatusEnum,
    suppliers: List<UUID>,
    article: String?,
    comment: String?
  ): ResponseEntity<Unit> {
    supplierServiceV1.patchSuppliers(status, suppliers, article, comment)
    return ResponseEntity.status(200).build()
  }

  override fun suppliersNamesByGet(requestBody: List<String>): ResponseEntity<List<ManagementSuppliersInfo>> {
    return ResponseEntity.ok(
      supplierServiceV1.getSuppliersByNames(requestBody)
    )
  }

  override fun suppliersByPost(
    newSupplierInfo: List<NewSupplierInfo>,
    article: String?,
    imageUrl: String?,
    productName: String?,
    profitPlace: BigDecimal?
  ): ResponseEntity<Unit> {
    supplierServiceV1.postSuppliers(
      newSupplierInfo,
      article!!,
      imageUrl,
      productName,
      profitPlace
    )
    return ResponseEntity.status(200).build()
  }
}