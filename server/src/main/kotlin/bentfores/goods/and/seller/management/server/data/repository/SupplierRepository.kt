package bentfores.goods.and.seller.management.server.data.repository

import bentfores.goods.and.seller.management.server.data.entity.Supplier
import bentfores.goods.and.seller.management.server.data.entity.Supplier.SupplierStatus
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SupplierRepository : JpaRepository<Supplier, UUID> {

  @Query(
    """
      select s from Supplier s
      where s.status in :status
    """
  )
  fun findSuppliersByStatuses(status: List<SupplierStatus>): List<Supplier>
}