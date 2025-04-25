package bentfores.goods.and.seller.management.server.mapper.v1

import bentfores.goods.and.seller.management.api.model.ManagementSuppliersInfo
import bentfores.goods.and.seller.management.api.model.SupplierStatusEnum
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
      SupplierStatusEnum.WRONG -> SupplierStatus.WRONG
    }
  }

  fun mapToSupplierStatusEnum(enum: SupplierStatus): SupplierStatusEnum {
    return when (enum) {
      SupplierStatus.COOPERATING -> SupplierStatusEnum.COOPERATING
      SupplierStatus.NOT_COOPERATING -> SupplierStatusEnum.NOT_COOPERATING
      SupplierStatus.BLACKLISTED -> SupplierStatusEnum.BLACKLISTED
      SupplierStatus.MESSAGE_SENT -> SupplierStatusEnum.MESSAGE_SENT
      SupplierStatus.WRONG -> SupplierStatusEnum.WRONG
    }
  }

  fun mapToManagementSuppliersInfoList(suppliers: List<Supplier>): List<ManagementSuppliersInfo> {
    return suppliers.map { mapToManagementSuppliersInfo(it) }
  }

  fun mapToManagementSuppliersInfo(supplier: Supplier): ManagementSuppliersInfo {
    return ManagementSuppliersInfo(
        supplierId = supplier.supplierId!!,
        status = mapToSupplierStatusEnum(supplier.status),
        name = supplier.supplierName,
        comment = supplier.comment
      )
  }
}