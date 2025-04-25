package bentfores.goods.and.seller.management.server.data.repository

import bentfores.goods.and.seller.management.server.data.entity.Supplier
import bentfores.goods.and.seller.management.server.data.entity.Supplier.SupplierStatus
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface SupplierRepository : JpaRepository<Supplier, UUID> {

  @Query(
    """
      select s from Supplier s
      where s.status in :status
    """
  )
  fun findSuppliersByStatuses(status: List<SupplierStatus>): List<Supplier>

  @Modifying
  @Query(
    """
    update Supplier s
    set s.status = :status,
        s.comment = :comment  
    where s.supplierId in (
      select sp.supplier.supplierId
      from SupplierProduct sp
      where sp.product.article = :article
      and sp.supplier.supplierId in :suppliers
    )
    """
  )
  fun updateAllByStatusAndArticle(status: SupplierStatus, suppliers: List<UUID>, article: String, comment: String?): Int

  @Modifying
  @Query(
    """
    update Supplier s
    set s.status = :status
    where s.supplierId in :suppliers
    """
  )
  fun updateAllByStatus(status: SupplierStatus, suppliers: List<UUID>): Int
  fun existsBySupplierName(supplierName: String): Boolean

  @Query(
    """
      select s from Supplier s
      where s.supplierName = :supplierName
    """
  )
  fun findBySupplierName(supplierName: String): Supplier
}