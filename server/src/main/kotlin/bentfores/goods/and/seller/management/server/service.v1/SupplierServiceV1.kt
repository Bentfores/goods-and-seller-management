package bentfores.goods.and.seller.management.server.service.v1

import bentfores.goods.and.seller.management.api.model.SupplierStatusEnum
import bentfores.goods.and.seller.management.api.model.SuppliersResponse
import bentfores.goods.and.seller.management.server.data.repository.SupplierRepository
import bentfores.goods.and.seller.management.server.mapper.v1.SupplierMapper
import org.springframework.stereotype.Service

@Service
class SupplierServiceV1(
  private val supplierRepository: SupplierRepository,
  private val supplierMapper: SupplierMapper
) {

  fun getSuppliers(status: List<SupplierStatusEnum>): SuppliersResponse {
    return supplierMapper.mapToSupplierResponse(
      supplierRepository.findSuppliersByStatuses(
        status.map {
          supplierMapper.mapToSupplierStatus(
            it
          )
        }
      ),
    )
  }
}

