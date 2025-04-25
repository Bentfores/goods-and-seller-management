package bentfores.goods.and.seller.management.server.data.repository

import bentfores.goods.and.seller.management.server.data.entity.Product
import bentfores.goods.and.seller.management.server.data.entity.Supplier
import bentfores.goods.and.seller.management.server.data.entity.SupplierProduct
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface SupplierProductRepository : JpaRepository<SupplierProduct, UUID> {
  fun existsBySupplierAndProduct(supplier: Supplier, product: Product): Boolean
}