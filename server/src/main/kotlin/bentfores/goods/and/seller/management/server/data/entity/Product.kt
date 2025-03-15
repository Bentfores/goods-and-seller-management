package bentfores.goods.and.seller.management.server.data.entity

import bentfores.goods.and.seller.management.server.data.misc.Auditable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
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

  ) : Auditable() {

  enum class ProductStatus {
    NOT_PROCESSED,
    PROCESSED,
    IGNORED
  }
}
