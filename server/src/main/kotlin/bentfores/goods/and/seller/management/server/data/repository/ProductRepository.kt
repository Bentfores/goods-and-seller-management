package bentfores.goods.and.seller.management.server.data.repository

import bentfores.goods.and.seller.management.server.data.entity.Product
import bentfores.goods.and.seller.management.server.data.entity.Product.ProductStatus
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, UUID> {
  fun findProductsByStatus(status: ProductStatus): List<Product>
}