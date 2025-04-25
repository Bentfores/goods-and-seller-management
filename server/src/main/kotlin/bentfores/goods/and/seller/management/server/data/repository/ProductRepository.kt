package bentfores.goods.and.seller.management.server.data.repository

import bentfores.goods.and.seller.management.server.data.entity.Product
import bentfores.goods.and.seller.management.server.data.entity.Product.ProductStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import java.util.UUID

interface ProductRepository : JpaRepository<Product, UUID> {

  @Query(
    """
      select p from Product p
      where p.status in :status
      order by p.profitPlace
    """
  )
  fun findProductsByStatus(status: ProductStatus): List<Product>

  @Modifying
  @Query(
    """
      update Product p
        set p.status = :status
        where p.article in :articles
    """
  )
  fun updateAllByStatus(status: ProductStatus, articles: List<String>): Int

  fun findProductByArticle(article: String): Product
  fun existsProductByArticle(article: String): Boolean
}