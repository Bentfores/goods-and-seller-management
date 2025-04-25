package bentfores.goods.and.seller.management.server.data.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "products")
data class Product(

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "product_id")
  var productId: UUID? = null,

  @Column(name = "article")
  var article: String,

  @Column(name = "image_url")
  var imageUrl: String,

  @Column(name = "product_name")
  var productName: String,

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  var status: ProductStatus = ProductStatus.NOT_PROCESSED,

  @Column(name = "profit_place")
  var profitPlace: BigDecimal,

  @OneToMany(mappedBy = "product", cascade = [CascadeType.ALL], orphanRemoval = true)
  var productSuppliers: List<SupplierProduct> = mutableListOf(),

  @CreatedDate
  @Column(updatable = false, name = "created_at")
  var createdAt: LocalDateTime? = LocalDateTime.now(),

  @LastModifiedDate
  @Column(name = "updated_at")
  var updatedAt: LocalDateTime? = LocalDateTime.now()

) {

  enum class ProductStatus {
    NOT_PROCESSED,
    PROCESSED,
    IGNORED
  }
}
