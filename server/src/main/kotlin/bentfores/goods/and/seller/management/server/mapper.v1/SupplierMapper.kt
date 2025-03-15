package bentfores.goods.and.seller.management.server.mapper.v1

import bentfores.goods.and.seller.management.api.model.ProductsInfo
import bentfores.goods.and.seller.management.api.model.ProductsResponse
import bentfores.goods.and.seller.management.api.model.SupplierStatusEnum
import bentfores.goods.and.seller.management.api.model.SuppliersInfo
import bentfores.goods.and.seller.management.api.model.SuppliersResponse
import bentfores.goods.and.seller.management.server.data.entity.Product
import bentfores.goods.and.seller.management.server.data.entity.Supplier
import bentfores.goods.and.seller.management.server.data.entity.Supplier.SupplierStatus
import org.springframework.stereotype.Component

@Component
class SupplierMapper {

  fun mapToSupplierStatus(enum: SupplierStatusEnum): SupplierStatus {
    return when (enum) {
      SupplierStatusEnum.COOPERATING -> SupplierStatus.COOPERATING
      SupplierStatusEnum.NOT_COOPERATING -> SupplierStatus.NOT_COOPERATING
      SupplierStatusEnum.BLACKLISTED -> SupplierStatus.BLACKLISTED
      SupplierStatusEnum.MESSAGE_SENT -> SupplierStatus.MESSAGE_SENT
    }
  }

  fun mapToSupplierStatusEnum(enum: SupplierStatus): SupplierStatusEnum {
    return when (enum) {
      SupplierStatus.COOPERATING -> SupplierStatusEnum.COOPERATING
      SupplierStatus.NOT_COOPERATING -> SupplierStatusEnum.NOT_COOPERATING
      SupplierStatus.BLACKLISTED -> SupplierStatusEnum.BLACKLISTED
      SupplierStatus.MESSAGE_SENT -> SupplierStatusEnum.MESSAGE_SENT
    }
  }

  fun mapToSupplierResponse(suppliers: List<Supplier>): SuppliersResponse {
    return SuppliersResponse(
      suppliers = suppliers.map { it.supplierUrl }
    )
  }
}